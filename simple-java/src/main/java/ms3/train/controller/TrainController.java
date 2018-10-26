package ms3.train.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import ms3.service.NoSuchAssignmentException;
import ms3.service.NoSuchCourseException;
import ms3.service.model.Assignment;
import ms3.service.model.Course;
import ms3.service.model.DailyLog;
import ms3.service.model.Track;
import ms3.service.model.TrackAssignment;
import ms3.service.service.AssignmentLocalServiceUtil;
import ms3.service.service.CourseLocalServiceUtil;
import ms3.service.service.DailyLogLocalServiceUtil;
import ms3.service.service.TrackAssignmentLocalServiceUtil;
import ms3.service.service.TrackLocalServiceUtil;

@Controller("TrainController")
@RequestMapping("VIEW")
public class TrainController extends MVCPortlet {
	
// this is called every time the portlet is loaded, the jsp name it returns is displayed.
	@RenderMapping
	public String processRenderRequest(RenderRequest request,
		RenderResponse response, Model model) throws Exception {		
	PortletPreferences prefs = request.getPreferences();

	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
// this is from the config page, shows which role can view the admin sections of the portlet (editing, assigning courses etc)
	String permissableRole = GetterUtil.getString(prefs.getValue("ableRole", ""));
// also from config, the address of the employee API that connects to save the employee's skills when they complete a class.
	String employeeEndPoint = GetterUtil.getString(prefs.getValue("employeeEndPoint", ""));
System.out.println("Necessary Role: "+permissableRole);
System.out.println("Employee API Endpoint: "+employeeEndPoint);
//checking the permission and setting it for the rest of the portlet.
	List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
	String hasPermission = "false";
	for(Role role: userRoles) {
		if(role.getName().equals(permissableRole)) {
			hasPermission = "true";
		}
	}
	prefs.setValue("hasPermission", hasPermission);
	prefs.store();

	
//Where are we going?
	//I made going to each page an action that triggers a return here. Many of the functions in this class end with one of these.
	String coursePageString = (String)request.getAttribute("goToCoursePage");
	if(coursePageString!=null) {
		return "coursePage";
	}
	String personalAssignmentsString = (String)request.getAttribute("goToPersonalAssignments");
	if(personalAssignmentsString!=null) {
		return "personalAssignments";
	}
	String viewUserAssignmentsString = (String)request.getAttribute("goToUserAssignments");
	if(viewUserAssignmentsString != null) {
		return "viewUserAssignments";
	}
	String viewDailyLogsString = (String)request.getAttribute("goToDailyLogs");
	if(viewDailyLogsString != null) {
		return "dailyLogs";
	}
	String viewTrackPage = (String)request.getAttribute("goToTrackPage");
	if(viewTrackPage != null) {
		return "trackPage";
	}

// the default pages, pending permission
	if(hasPermission.equals("true")) {
		return "view";
	}
	return "personalAssignments";
	
	}


// these are the functions that take the user to a certain page. Sometimes they set variables for use there.
@ActionMapping(params = "action=coursePage")
public void coursePage(ActionRequest request, ActionResponse response) throws Exception{
	PortletPreferences prefs = request.getPreferences();
	prefs.setValue("assignTitle", request.getParameter("submitTitle"));
	prefs.store();
	request.setAttribute("goToCoursePage", "true");
}

@ActionMapping(params = "action=personalAssignmentsPage")
public void personalAssignmentsPage(ActionRequest request, ActionResponse response) throws Exception{
	request.setAttribute("goToPersonalAssignments", "true");
	System.out.println("PA!");
}

@ActionMapping(params = "action=viewUserAssignments")
public void viewUserAssignments(ActionRequest request, ActionResponse response) throws Exception{
	PortletPreferences prefs = request.getPreferences();
	prefs.setValue("userScreenName", request.getParameter("userAssignmentsScreenName"));
	prefs.store();
	request.setAttribute("goToUserAssignments", "true");
}

@ActionMapping(params = "action=dailyLogsPage")
public void dailyLogsPage(ActionRequest request, ActionResponse response) throws Exception{
	PortletPreferences prefs = request.getPreferences();
	prefs.setValue("assignmentId", request.getParameter("assignmentId"));
	prefs.store();
	request.setAttribute("goToDailyLogs", "true");
}

@ActionMapping(params = "action=trackPage")
public void trackPage(ActionRequest request, ActionResponse response) throws Exception{
	PortletPreferences prefs = request.getPreferences();
	prefs.setValue("trackId", request.getParameter("trackId"));
	prefs.store();
	request.setAttribute("goToTrackPage", "true");
}




// action function for interacting with the service objects: assignments, courses, dailyLogs and tracks
@ActionMapping(params = "action=addCourse")
public void addCourse(ActionRequest request, ActionResponse response){
	SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	
	PortletPreferences prefs = request.getPreferences();
	
	try {
//take all inputs into strings
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String provider = request.getParameter("provider");
		String listPrice = request.getParameter("listPrice");
		String estHours = request.getParameter("estimatedHours");
		String sections = request.getParameter("sections");
		String skill = request.getParameter("skill");

		//changes the display of the hours so there isn't a '.0' at the end
		double estimatedHours = Double.parseDouble(estHours);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		format.format(estimatedHours);
		List<Course> courseResults = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
		long highestId = 1;
		for(Course course: courseResults) {
			
//CHECK the entered title doesn't already exist.
			if(title.equals(course.getTitle())) {
				request.setAttribute("error", "That title has already been used.");
				return;
			}
//CHECK the new course id isn't used and is higher than the rest.
			if(highestId <= course.getCourseId()) {
				highestId = course.getCourseId() + 1;
			}
		}
		
		long courseId = highestId;
//set a new course with these values and add it to the table.
		Course course = CourseLocalServiceUtil.createCourse(title);
		course.setTitle(title);
		course.setCourseId(courseId);
		course.setDescription(description);
		course.setProvider(provider);
		course.setListPrice(listPrice);
		course.setEstimatedHours(estimatedHours);
		course.setSections(sections);
		course.setSkills(skill);
		CourseLocalServiceUtil.updateCourse(course);
// they can add the course to a trak when they make it. In the future they should be able to add it to multiple tracks at once.
		if(!request.getParameter("trackInclusion").isEmpty()) {
			Track track = TrackLocalServiceUtil.getTrack(Long.parseLong(request.getParameter("trackInclusion")));
			String courseList= track.getCourseList();
			courseList += ", "+title;
			track.setCourseList(courseList);
			TrackLocalServiceUtil.updateTrack(track);
		}
		request.setAttribute("success", "The course "+course.getTitle()+" has been created.");
		
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		SessionErrors.add(request, "errorAddCourse");
	}
}

// edits an existing course, follows largely the same format as the addCourse function.
@ActionMapping(params = "action=editCourse")
public void editCourse(ActionRequest request, ActionResponse response) 
		throws PortletException, PortalException, SystemException, IOException{
	
	PortletPreferences prefs = request.getPreferences();
	
	String title = prefs.getValue("assignTitle", "");
	
	try {
		Course course = CourseLocalServiceUtil.getCourse(title);

		course.setDescription(request.getParameter("description") );
		course.setListPrice(request.getParameter("listPrice") );
		course.setProvider(request.getParameter("provider") );
		
		Double estimatedHours = Double.parseDouble(request.getParameter("estimatedHours"));
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		format.format(estimatedHours);
		course.setEstimatedHours(estimatedHours);
		
		course.setSections(request.getParameter("sections") );
		
//This section essentially converts the existing string of course titles into a list, then goes through them and updates them to the new values.
//At the end, it checks if a new skill was added in and adds that to the end. It then trims the final comma off.
//I may be a little over zealous with the checks, but I hate null pointer exceptions.
		String skills = course.getSkills();
		List<String> skillList = new ArrayList<String>();

		if(!skills.isEmpty()) {
			String[] skillArray = skills.split(", ");
			Collections.addAll(skillList, skillArray);
			for(int i=0; i<skillList.size(); i++) {
				String updatedSkill = request.getParameter(String.valueOf(i));
				
				skillList.set(i, updatedSkill);	
			}
		}
		if(!request.getParameter("newSkill").isEmpty()) {
			skillList.add(request.getParameter("newSkill"));
		}
		skills= "";
		for(String skill: skillList) {
			if(!skill.isEmpty()) {
				skills+= skill+", ";
			}
		}
		if(skills!="") {
			skills= skills.substring(0, skills.length()-2);
		}
		
		course.setSkills(skills);
		
		CourseLocalServiceUtil.updateCourse(course);	
		request.setAttribute("success", "The course "+course.getTitle()+" has been updated.");
		request.setAttribute("goToCoursePage", "true");
	}
	catch (NoSuchCourseException e) {
		request.setAttribute("error", "A course by that title is not in the catalog.");
		request.setAttribute("goToCoursePage", "true");
		return;
	}
}

// delete a course, as well as it's associated assignments and dailyLogs, otherwise they would throw null pointer exceptions/ primary key not found.
//also removes that course from tracks.
@ActionMapping(params = "action=deleteCourse")
public void deleteCourse(ActionRequest request, ActionResponse response) {
	PortletPreferences prefs = request.getPreferences();
	String title = prefs.getValue("assignTitle", "");
	Course course;
	try {
//finds assignments linked to it by the title, deletes all of its associated logs, then deletes it.
		course = CourseLocalServiceUtil.getCourse(title);
		List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
		List<DailyLog> logs = DailyLogLocalServiceUtil.getDailyLogs(0, DailyLogLocalServiceUtil.getDailyLogsCount());
		for(Assignment assignment: assignments) {
			if(assignment.getCourses_title().equals(title)) {
				for(DailyLog log: logs) {
					if(log.getAssignment_id()==assignment.getAssignmentId()) {
						DailyLogLocalServiceUtil.deleteDailyLog(log);
					}
				}
				AssignmentLocalServiceUtil.deleteAssignment(assignment);
			}
		}
// if a track somehow only has that course, that is deleted, otherwise it is removed from the list.
		List<Track> tracks = TrackLocalServiceUtil.getTracks(0, TrackLocalServiceUtil.getTracksCount());
		for(Track track: tracks) {
			String courseList = track.getCourseList();
			if(courseList.contains(title)) {
				if(courseList.equals(title)) {
					TrackLocalServiceUtil.deleteTrack(track);
				}
// comma nonsense.
				else {
					if(courseList.endsWith(title)) {
						String replace = ", "+title;
						courseList= courseList.replace(replace, "");
					}
					else {
						String replace = title+", ";
						courseList= courseList.replace(replace, "");
					}
					track.setCourseList(courseList);
					TrackLocalServiceUtil.updateTrack(track);
				}
			}
		}
		CourseLocalServiceUtil.deleteCourse(course);
		
		request.setAttribute("success", "The course "+title+" and its associated assignments were successfully deleted.");
	} catch (NoSuchCourseException e) {
		request.setAttribute("error", "A course by that title is not in the catalog.");
		request.setAttribute("goToCoursePage", "true");
		return;
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

// makes an assignment for a course to a user
@ActionMapping(params = "action=assignToUser")
public void assignToUser(ActionRequest request, ActionResponse response) throws Exception{
	PortletPreferences prefs = request.getPreferences();
	String screenName = request.getParameter("user");
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
// this should be impossible, but just in case...
	if(screenName == null || screenName.equals("")) {
		request.setAttribute("error", "Please fill in a screen name for the assignment.");
		request.setAttribute("goToCoursePage", "true");
		return;
	}
	Long companyId = CompanyThreadLocal.getCompanyId();
	try {
//to ensure user exists with catch
		User admin = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
		String title = prefs.getValue("assignTitle", "");
//to ensure course exists with catch
		Course course = CourseLocalServiceUtil.getCourse(title);
//to ensure they aren't already assigned
		if(checkIfInAssignments(screenName, title)) {
			request.setAttribute("error", "The user "+screenName+" cannot be assigned "+title+".");
			request.setAttribute("goToCoursePage", "true");
			return;
		}
//make the assignment, with Id one higher than the existing highest
		long assignmentId = makeAssignmentId();
		Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
		assignment.setAssignedDate(setDate());
		assignment.setCourses_title(title);
		assignment.setMs3employeedb_uid(screenName);
		assignment.setAdmin(themeDisplay.getUser().getFullName());
		AssignmentLocalServiceUtil.addAssignment(assignment);
		request.setAttribute("success", "Your assignment of "+assignment.getCourses_title()+" to "+assignment.getMs3employeedb_uid()+" has been saved.");
		request.setAttribute("goToCoursePage", "true");
	}
	catch (NoSuchUserException e) {
		request.setAttribute("error", "There are no users by that screen name.");
		request.setAttribute("goToCoursePage", "true");
		return;
	}
	catch (NoSuchCourseException e) {
		request.setAttribute("error", "A course by that title is not in the catalog.");
		request.setAttribute("goToCoursePage", "true");
		return;
	}
}

// when a user requests to take a course, it displays on an admin's home page.
@ActionMapping(params = "action=requestCourse")
public void requestCourse(ActionRequest request, ActionResponse response) throws Exception{
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	User user = themeDisplay.getUser();
	String title = request.getParameter("requestTitle");
	if(checkIfInAssignments(user.getScreenName(), title)) {
		request.setAttribute("error", "The user "+user.getScreenName()+" cannot request "+title+".");
		return;
	}
	long assignmentId = makeAssignmentId();
	Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
	assignment.setCourses_title(title);
	assignment.setMs3employeedb_uid(user.getScreenName());
//not necessary, but to be safe.
	assignment.setAssignedDate(null);
	assignment.setStartDate(null);
//for sorting
	assignment.setStatus("requested");
	AssignmentLocalServiceUtil.addAssignment(assignment);
	request.setAttribute("success", "Your course request has been saved.");
}

@ActionMapping(params = "action=approveRequest")
public void approveRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException {
	long requestId = Long.parseLong(request.getParameter("requestId"));
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	User user = themeDisplay.getUser();
	assignment.setAssignedDate(setDate());
	assignment.setStatus("Approved on "+setDate());
	AssignmentLocalServiceUtil.updateAssignment(assignment);
	request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
}
@ActionMapping(params = "action=denyRequest")
public void denyRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException {
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	User user = themeDisplay.getUser();
	long requestId = Long.parseLong(request.getParameter("requestId"));
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
//	assignment.setEndDate(setDate());
//	assignment.setStatus("Request Denied by "+user.getFullName());
//	assignment.setStartDate(null);
//	assignment.setAssignedDate(null);
	AssignmentLocalServiceUtil.deleteAssignment(assignment);
	
				System.out.println("Course denied. Quick, send an email!!!");
	
	request.setAttribute("success", "You have denied the request for "+assignment.getCourses_title()+" by "+assignment.getMs3employeedb_uid());
}

// same as request, but returns to a different page
@ActionMapping(params = "action=approveRequestFromAssign")
public void approveRequestFromAssign(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException{
	long requestId = Long.parseLong(request.getParameter("requestId"));
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
	assignment.setAssignedDate(setDate());
	assignment.setStatus("Approved on "+setDate());
	AssignmentLocalServiceUtil.updateAssignment(assignment);
	request.setAttribute("success", "You have approved "+assignment.getCourses_title()+" for "+assignment.getMs3employeedb_uid());
	request.setAttribute("goToCoursePage", "true");
}

// when a user updates their progress/ relationship with an assignment. If they complete it, they may add its skill(s) to their employee page.
// note where an assignment is located (in progress, completed, etc depends on: endDate, startDate, assignedDate and status. These are important!
@ActionMapping(params = "action=updateAssignment")
public void updateAssignment(ActionRequest request, ActionResponse response) throws Exception {
	PortletPreferences prefs = request.getPreferences();
	String reqId = request.getParameter("assignmentId");
	long requestId = Long.parseLong(reqId);
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
	if(request.getParameter("status")!=null) {
		assignment.setStatus(request.getParameter("status"));
	}
	if(request.getParameter("completed").equals("true")) {
		assignment.setEndDate(setDate());
		assignment.setNotes(request.getParameter("notes"));
		String skillList = CourseLocalServiceUtil.getCourse(assignment.getCourses_title()).getSkills();
// if the course has associated skills, gives them to the employee via the restService function.
// this check should be impossible due to aui:validator, but just in case...
		if(!skillList.isEmpty()) {
			if(request.getParameter("employeeId").isEmpty()) {
				request.setAttribute("error", "Identify yourself to save your skills to your profile.");
				request.setAttribute("goToPersonalAssignments", "true");
				return;
			}
			RESTservices restServices = new RESTservices();
			String[] skills = skillList.split(", ");
			for(String skill: skills) {
				restServices.saveSkill(prefs.getValue("employeeEndPoint", ""), Integer.parseInt(request.getParameter("employeeId")), skill);
			}
		}
	}
	else {
		assignment.setEndDate(null);
	}
	if(request.getParameter("certified").equals("true")) {
		assignment.setCertification(true);
	}
	else {
		assignment.setCertification(false);
	}
	AssignmentLocalServiceUtil.updateAssignment(assignment);
	request.setAttribute("goToPersonalAssignments", "true");
	request.setAttribute("success", assignment.getCourses_title()+" was updated.");
}

// this is called when a user has been assigned a course, and clicks on "Start" in the Personal Assignments page.
// from now on this course will be interpreted as "In Progress" or something.
@ActionMapping(params = "action=startAssignment")
public void startAssignment(ActionRequest request, ActionResponse response) throws Exception {
	String reqId = (String)request.getParameter("assignmentId");
	long requestId = Long.parseLong(reqId);
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(requestId);
	assignment.setCost(request.getParameter("cost"));
	assignment.setStartDate(setDate());
	assignment.setCurrentSection("0");
	assignment.setStatus("Started");
	assignment.setNotes("");
//to be on the safe side
	assignment.setEndDate(null);
	AssignmentLocalServiceUtil.updateAssignment(assignment);
	request.setAttribute("goToPersonalAssignments", "true");
	request.setAttribute("success", "You have begun "+assignment.getCourses_title());
}

// a daily log is meant to keep track of an employee's progress that day.
@ActionMapping(params = "action=makeDailyLog")
public void makeDailyLog(ActionRequest request, ActionResponse response) throws Exception {
	String assignId = (String)request.getParameter("assignmentId");
	long assignmentId = Long.parseLong(assignId);
	String date = setDate();
	String accomplishments = (String)request.getParameter("accomplishments");
	String roadblocks = (String)request.getParameter("roadblocks");
	String plan = (String)request.getParameter("plan");
	String notes = (String)request.getParameter("notes");
	String hrs = (String)request.getParameter("hours");
	String section = (String)request.getParameter("section");
	List<DailyLog> allLogs = DailyLogLocalServiceUtil.getDailyLogs(0, DailyLogLocalServiceUtil.getDailyLogsCount());
	long dailyLogId= 1;
	for(DailyLog log: allLogs) {
		if(log.getDailyLogId() >= dailyLogId) {
			dailyLogId = log.getDailyLogId()+1;
		}
	}
	try {
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(assignmentId);
		double hours = Double.parseDouble(hrs);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		format.format(hours);
		DailyLog dailyLog = DailyLogLocalServiceUtil.createDailyLog(dailyLogId);
		dailyLog.setAssignment_id(assignmentId);
		dailyLog.setDate(date);
		dailyLog.setAccomplishments(accomplishments);
		dailyLog.setRoadblocks(roadblocks);
		dailyLog.setPlan(plan);
		dailyLog.setNotes(notes);
		dailyLog.setHours(hours);
		dailyLog.setSection(section);
		
		DailyLogLocalServiceUtil.addDailyLog(dailyLog);
		request.setAttribute("success", "Your log has been saved.");
		
		assignment.setCurrentSection(section);
		assignment.setHoursSpent(assignment.getHoursSpent()+hours);
		AssignmentLocalServiceUtil.updateAssignment(assignment);
		
		request.setAttribute("goToPersonalAssignments", "true");
		request.setAttribute("success", "Your log has been saved.");
	}
	//I think it is actually impossible for this to happen. But just in case.
	catch(NoSuchAssignmentException e) {
		request.setAttribute("error", "There is no assignment by that id.");
		request.setAttribute("goToPersonalAssignments", "true");
	}
	catch(NumberFormatException f) {
		request.setAttribute("error", "Make sure to enter your hours as a single number");
		request.setAttribute("goToPersonalAssignments", "true");
	}
}


@ActionMapping(params = "action=makeTrack")
public void makeTrack(ActionRequest actionRequest,ActionResponse response)
throws Exception {
	String indexesString = actionRequest.getParameter("phonesIndexes");
    int[] indexes = StringUtil.split(indexesString, 0);
    String courseList= "";
    for (int i = 0; i < indexes.length; i++) {
    	int index = indexes[i];
    	if(index==0) {
			actionRequest.setAttribute("error", "Do not leave a course section blank.");
			return;
    	}
        String courseTitle = ParamUtil.getString(actionRequest, "courseTitle" + index);
        System.out.println("Title: "+courseTitle);
        courseList += courseTitle;
        if(i < indexes.length-1) {
        	courseList += ", ";
        }
    }
    String title = (String)actionRequest.getParameter("title");
	long trackId = 1;
	List<Track> tracks = TrackLocalServiceUtil.getTracks(0, TrackLocalServiceUtil.getTracksCount());
	if(!tracks.isEmpty()) {
		for(Track track: tracks) {
			if(track.getTitle().equals(title)) {
				actionRequest.setAttribute("error", "Provide a unique title for this track.");
				return;
			}
			if(track.getTrackId()>=trackId) {
				trackId = track.getTrackId()+1;
			}
		}
	}
	Track track = TrackLocalServiceUtil.createTrack(trackId);
	track.setTitle(title);
	if(!actionRequest.getParameter("description").equals("")) {
		track.setDescription(actionRequest.getParameter("description"));
	}
	track.setCourseList(courseList);
	TrackLocalServiceUtil.addTrack(track);
	actionRequest.setAttribute("success", "Your track has been saved.");
}

@ActionMapping(params = "action=assignTrack")
public void assignTrack(ActionRequest actionRequest,ActionResponse response) throws Exception {
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String screenName = (String)actionRequest.getParameter("screenName");
	long trackId= Long.parseLong((String)actionRequest.getParameter("trackId"));
	Track track = TrackLocalServiceUtil.getTrack(trackId);
	List<TrackAssignment> trackAssignments = TrackAssignmentLocalServiceUtil.getTrackAssignments(0, TrackAssignmentLocalServiceUtil.getTrackAssignmentsCount());
	for(TrackAssignment trackAssignment: trackAssignments) {
		if(trackAssignment.getTrackId()==trackId && trackAssignment.getUserScreenName().equals(screenName)) {
			actionRequest.setAttribute("error", "This user has already been assigned this track.");
			return;
		}
	}
	track.getCourseList();
	String[] titles = track.getCourseList().split(", ");
	String assignmentIdList = "";
	for(int i = 0; i < titles.length; i++) {
		String title = titles[i];
		if(!title.isEmpty()) {
			if(!checkIfInAssignments(screenName, title)) {
				long assignmentId = makeAssignmentId();
				Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
				assignment.setAssignedDate(setDate());
				assignment.setCourses_title(title);
				assignment.setMs3employeedb_uid(screenName);
				assignment.setNotes("Course "+(i+1)+" of the '"+track.getTitle()+"' track.");
				assignment.setAdmin(themeDisplay.getUser().getFullName());
				AssignmentLocalServiceUtil.addAssignment(assignment);
				assignmentIdList += assignmentId+", ";
			}
		}
	}
	
	long trackAssignmentId = TrackAssignmentLocalServiceUtil.getTrackAssignmentsCount()+1;
	for(TrackAssignment trackAssignment: trackAssignments) {
		if(trackAssignment.getTrackAssignmentId() >= trackAssignmentId) {
			trackAssignmentId= trackAssignment.getTrackAssignmentId()+1;
		}
	}
	TrackAssignment trackAssignment = TrackAssignmentLocalServiceUtil.createTrackAssignment(trackAssignmentId);
	trackAssignment.setUserScreenName(screenName);
	trackAssignment.setTrackId(trackId);
	trackAssignment.setAssignmentIdList(assignmentIdList);
	trackAssignment.setDateAssigned(setDateNoMinutes());
	trackAssignment.setAdmin(themeDisplay.getUser().getFullName());
	TrackAssignmentLocalServiceUtil.addTrackAssignment(trackAssignment);
	actionRequest.setAttribute("success", "Your track has been assigned to "+screenName+".");
}

@ActionMapping(params = "action=requestTrack")
public void requestTrack(ActionRequest request, ActionResponse response) throws Exception {
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long trackId= Long.parseLong(request.getParameter("trackId"));
	String screenName = themeDisplay.getUser().getScreenName();
	List<TrackAssignment> trackAssignments = TrackAssignmentLocalServiceUtil.getTrackAssignments(0, TrackAssignmentLocalServiceUtil.getTrackAssignmentsCount());
	for(TrackAssignment trackAssignment: trackAssignments) {
		if(trackAssignment.getTrackId()==trackId && trackAssignment.getUserScreenName().equals(screenName)) {
			request.setAttribute("error", "You've already been assigned to this track.");
			return;
		}
	}
	Track track = TrackLocalServiceUtil.getTrack(trackId);
	track.getCourseList();
	String[] titles = track.getCourseList().split(", ");
	String assignmentIdList = "";
	for(int i = 0; i < titles.length; i++) {
		String title = titles[i];
		if(!title.isEmpty()) {
			if(!checkIfInAssignments(screenName, title)) {
				long assignmentId = makeAssignmentId();
				Assignment assignment = AssignmentLocalServiceUtil.createAssignment(assignmentId);
				assignment.setCourses_title(title);
				assignment.setMs3employeedb_uid(screenName);
				assignment.setStatus("requested");
				assignment.setAssignedDate(null);
				assignment.setStartDate(null);
				assignment.setEndDate(null);
				AssignmentLocalServiceUtil.addAssignment(assignment);
				assignmentIdList += assignmentId+", ";
			}
		}
	}
	
	long trackAssignmentId = TrackAssignmentLocalServiceUtil.getTrackAssignmentsCount()+1;
	for(TrackAssignment trackAssignment: trackAssignments) {
		if(trackAssignment.getTrackAssignmentId() >= trackAssignmentId) {
			trackAssignmentId= trackAssignment.getTrackAssignmentId()+1;
		}
	}
	TrackAssignment trackAssignment = TrackAssignmentLocalServiceUtil.createTrackAssignment(trackAssignmentId);
	trackAssignment.setTrackId(trackId);
	trackAssignment.setUserScreenName(screenName);
	trackAssignment.setAssignmentIdList(assignmentIdList);
	TrackAssignmentLocalServiceUtil.updateTrackAssignment(trackAssignment);
	request.setAttribute("success", "You have requested "+track.getTitle()+".");
}

@ActionMapping(params = "action=approveTrackRequest")
public void approveTrackRequest(ActionRequest request, ActionResponse response) throws Exception {
	long trackAssignmentId = Long.parseLong(request.getParameter("trackAssignmentId"));
	TrackAssignment trackAssignment = TrackAssignmentLocalServiceUtil.getTrackAssignment(trackAssignmentId);
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	trackAssignment.setAdmin(themeDisplay.getUser().getFullName());
	trackAssignment.setDateAssigned(setDateNoMinutes());
	String[] assignmentIdArray = trackAssignment.getAssignmentIdList().split(", ");
	for(String assignmentId: assignmentIdArray) {
		Assignment assignment = AssignmentLocalServiceUtil.getAssignment(Long.parseLong(assignmentId));
		assignment.setAdmin(themeDisplay.getUser().getFullName());
		assignment.setAssignedDate(setDate());
		assignment.setStatus("Assigned by "+assignment.getAdmin()+" on "+assignment.getAssignedDate());
		AssignmentLocalServiceUtil.updateAssignment(assignment);
	}
	TrackAssignmentLocalServiceUtil.updateTrackAssignment(trackAssignment);
	request.setAttribute("success", "The track has been assigned to "+trackAssignment.getUserScreenName()+".");
}

@ActionMapping(params = "action=denyTrackRequest")
public void denyTrackRequest(ActionRequest request, ActionResponse response) throws PortalException, SystemException, ReadOnlyException, ValidatorException, IOException {
//	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long trackAssignmentId = Long.parseLong(request.getParameter("trackAssignmentId"));
	TrackAssignment trackAssignment = TrackAssignmentLocalServiceUtil.getTrackAssignment(trackAssignmentId);
//	trackAssignment.setAdmin(themeDisplay.getUser().getFullName());
//	trackAssignment.setDateAssigned(null);
	TrackAssignmentLocalServiceUtil.deleteTrackAssignment(trackAssignment);
	
				System.out.println("Track denied. Quick, send an email!!!");
	
	request.setAttribute("success", "You have denied the request for "+TrackLocalServiceUtil.getTrack(trackAssignment.getTrackId())+" by "+trackAssignment.getUserScreenName());
}



@ActionMapping(params = "action=deleteTrack")
public void deleteTrack(ActionRequest request, ActionResponse response) throws Exception {
	PortletPreferences prefs = request.getPreferences();
	long trackId = Long.parseLong(prefs.getValue("trackId", ""));
	String title = TrackLocalServiceUtil.getTrack(trackId).getTitle();
	TrackLocalServiceUtil.deleteTrack(trackId);
	request.setAttribute("success", "The track "+title+" has been deleted.");
}

@ActionMapping(params = "action=editTrack")
public void editTrack(ActionRequest request, ActionResponse response) throws Exception {
	PortletPreferences prefs = request.getPreferences();
	long trackId = Long.parseLong(prefs.getValue("trackId", ""));
	Track track = TrackLocalServiceUtil.getTrack(trackId);
	track.setAccreditation(request.getParameter("accreditation"));
	track.setDescription(request.getParameter("description"));
	
	String courseString = track.getCourseList();
	Set<String> courseList = new HashSet<String>();

	String[] courseArray = courseString.split(", ");
	for(int i=0; i<courseArray.length; i++) {
		String updatedCourse = request.getParameter(String.valueOf(i));
		courseList.add(updatedCourse);	
	}
	if(!request.getParameter("newCourse").isEmpty()) {
		courseList.add(request.getParameter("newCourse"));
	}
	courseString= "";
	for(String course: courseList) {
		if(!course.isEmpty()) {
			courseString+= course+", ";
		}
	}
	if(courseString=="") {
		request.setAttribute("error", "A track must have at least one course.");
		return;
	}
	courseString= courseString.substring(0, courseString.length()-2);
	track.setCourseList(courseString);
	
	TrackLocalServiceUtil.updateTrack(track);
	request.setAttribute("success", "The track "+track.getTitle()+" has been updated.");
	request.setAttribute("goToTrackPage", "true");
}





// Auxillary functions

//this was meant to be extrapolated for all of the objects' id's. Oh well.
public long makeAssignmentId() throws Exception {
	long assignmentId = (long)AssignmentLocalServiceUtil.getAssignmentsCount();
	if(assignmentId > 0) {
		List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
		for(Assignment assignment: assignments) {
			if(assignmentId <= assignment.getAssignmentId()) {
				assignmentId = assignment.getAssignmentId()+1;
			}
		}
	}
	return assignmentId;
}

// gives the current date in the correct format.
public String setDate() {
	//DateFormat df = new SimpleDateFormat("dd/MM/yy");
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
	String formattedDate = sdf.format(date);
    return formattedDate;
}
public String setDateNoMinutes() {
	//DateFormat df = new SimpleDateFormat("dd/MM/yy");
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String formattedDate = sdf.format(date);
    return formattedDate;
}

public boolean checkIfInAssignments(String screenName, String title) throws SystemException {
	List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
	for(Assignment assignment: assignments) {
		if(assignment.getCourses_title().equals(title)) {
			if(assignment.getMs3employeedb_uid().equals(screenName)) {
				return true;
			}
		}
	}
	return false;
}

}