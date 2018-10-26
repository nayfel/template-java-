<%@include file="/html/init.jsp" %>


<portlet:actionURL var="addCourse">
   <portlet:param name="action" value="addCourse" />
</portlet:actionURL>

<portlet:actionURL var="makeTrack">
	<portlet:param name="action" value="makeTrack" />
</portlet:actionURL>
<portlet:actionURL var="assignTrack">
	<portlet:param name="action" value="assignTrack" />
</portlet:actionURL>
<portlet:actionURL var="deleteTrack">
	<portlet:param name="action" value="deleteTrack" />
</portlet:actionURL>

<portlet:actionURL var="coursePage">
   <portlet:param name="action" value="coursePage" />
</portlet:actionURL>
<portlet:actionURL var="personalAssignmentsPage">
   <portlet:param name="action" value="personalAssignmentsPage" />
</portlet:actionURL>
<portlet:actionURL var="approveRequest">
   <portlet:param name="action" value="approveRequest" />
</portlet:actionURL>
<portlet:actionURL var="approveTrackRequest">
   <portlet:param name="action" value="approveTrackRequest" />
</portlet:actionURL>
<portlet:actionURL var="denyRequest">
   <portlet:param name="action" value="denyRequest" />
</portlet:actionURL>
<portlet:actionURL var="denyTrackRequest">
   <portlet:param name="action" value="denyTrackRequest" />
</portlet:actionURL>
<portlet:actionURL var="dailyLogsPage">
   <portlet:param name="action" value="dailyLogsPage" />
</portlet:actionURL>
<portlet:actionURL var="viewUserAssignments">
	<portlet:param name="action" value="viewUserAssignments" />
</portlet:actionURL>
<portlet:actionURL var="trackPage">
	<portlet:param name="action" value="trackPage" />
</portlet:actionURL>

<%

/*
for(Track track: tracks) {
	TrackLocalServiceUtil.deleteTrack(track);
}

for(Course course: courses) {
	System.out.println(course.toString());
//	CourseLocalServiceUtil.deleteCourse(course);
}

for(Assignment assignment: assignments) {
	System.out.println(assignment.toString());
//	AssignmentLocalServiceUtil.deleteAssignment(assignment);
}

for(DailyLog dailyLog: dailyLogs) {
	DailyLogLocalServiceUtil.deleteDailyLog(dailyLog);
}

for(TrackAssignment trackAssignment: trackAssignments) {
	TrackAssignmentLocalServiceUtil.deleteTrackAssignment(trackAssignment);
}
*/

DecimalFormat format = new DecimalFormat();
format.setDecimalSeparatorAlwaysShown(false);
User myself = themeDisplay.getUser();
if(myself.getFullName().equals("")) {
%>
	<p>Please sign in to access this portlet.</p>
<%
}
else {

%>


<aui:a cssClass="bigLink" href="<%= personalAssignmentsPage %>">My Courses</aui:a>


<!-- The dialog that comes up when you click the plus next to Course. It takes in all of the required info for a course.  -->
<div id = "makeCourseDialog" class="dialog" title = "Course Creation">
	<aui:form cssClass="inputForm" name="addCourse" action="<%=addCourse%>">
		<aui:input cssClass="normalInput" name="title" label="Title" type="text">
<!-- aui:validator checks if what is entered follows the necessary qualifications -->
			<aui:validator name="maxLength">75</aui:validator>
			<aui:validator name="required" />
			<aui:validator name="custom" errorMessage="The title cannot contain any commas." >
	function(val, fieldNode, ruleValue) {
		return val.indexOf(',') < 0;
	}
			</aui:validator>
		</aui:input>
		<aui:input class="normalInput" name="description" label="Description" type="textarea">
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
		<aui:input name="provider" label="Provider" type="text" >
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="listPrice" label="List Price" type="text">
			<aui:validator name="maxLength">75</aui:validator>
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="estimatedHours" label="Estimated Hours" type="text">
			<aui:validator name="number" errorMessage="Please enter one number"></aui:validator>
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="sections" label="Total Sections" type="text" >
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="skill" label="Learned Skill" type="text" >
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:select name="trackInclusion" label="Add to Track" >
			<aui:option value="" label="" selected='true'></aui:option>
<%			for(Track track: tracks) { %>
				<aui:option value="<%= track.getTrackId() %>" label="<%= track.getTitle() %>" ></aui:option>
<%			} %>
		</aui:select>
		<input type="submit" value="Make Course"/>
	</aui:form>

</div>
<!-- The accoridion here is what keeps all of the page in the tabs. I find it works best when there is an h3 then a div. Never break the pattern. -->
<div class="accordion">
<h3>Course List</h3>
<!-- How all of the tables look in this portlet. They are dataTables so they are searchable and paged. -->
<div class="tableHolder">
<div class="tableTitle"><div class="inline">Courses </div><div class="inline create" onclick="$( '#makeCourseDialog' ).dialog( 'open' );">+</div></div>
<table class="pagedSearchableDataTable">
	<thead>
	<tr>
		<th>Title </th>
		<th class="min100">Description </th>
		<th>Provider </th>
		<th>List Price </th>
		<th>Estimated Total Hours </th>
		<th>Total Sections </th>
		<th>Learned Skill(s)</th>
	</tr>
	</thead>
	<tbody>
<%
// there is a list for each of the object types in init.jsp. They come up a lot.
	for(Course course: courses) {
%>	
	<tr>
		<td>
			<aui:form name="coursePage" action="<%=coursePage%>">
				<aui:input name="submitTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
				<input class="linkImitation" id="doAssign" type="submit" value="<%= course.getTitle() %>"/>
			</aui:form>
		</td>
		<td><%=course.getDescription() %></td>
		<td><%=course.getProvider() %></td>
		<td><%=course.getListPrice() %></td>
		<td><%= format.format(course.getEstimatedHours()) %></td>
		<td><%=course.getSections() %></td>
		<td><%= course.getSkills() %></td>
	</tr>
<%
	}
%>
	</tbody>
</table>
</div>

<!-- Second tab in the accordion -->
	<h3>Track List</h3>
	<div class="tableHolder">
	<div class="tableTitle"><div class="inline">Tracks </div><div class="inline create" onclick="$( '#makeTrackDialog' ).dialog( 'open' );">+</div></div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
				<th>Title</th>
				<th>Courses</th>
				<th>Description</th>
				<th>Estimated Cumulative Hours</th>
				<th>Assigned To</th>
				<th>In Progress For</th>
				<th>Actions</th>
			</tr>
			</thead>
			<tbody>
<%
// this was difficult to develop. It's a complex way of checking each assignment in the track to see if the users associated with them have started or not.
// then they're sorted into the assigned to or in progress for columns.
		for(Track track: tracks) {
			String[] titles = track.getCourseList().split(", ");
			double cumulative= 0;
			for(int i = 0; i < titles.length; i++) {
				cumulative += CourseLocalServiceUtil.getCourse(titles[i]).getEstimatedHours();
			}
			List<User> inProgressUsers = new ArrayList<User>();
			List<User> assignedUsers = new ArrayList<User>();
			List<User> newbies = new ArrayList<User>();
			newbies.addAll(users);
			for(TrackAssignment trackAssignment: trackAssignments) {
				User thisOne = UserLocalServiceUtil.getUserByScreenName(companyId, trackAssignment.getUserScreenName());
				newbies.remove(thisOne);
				String status="";
				String[] assignmentIds = trackAssignment.getAssignmentIdList().split(", ");
				for(String id: assignmentIds) {
					if(AssignmentLocalServiceUtil.getAssignment(Long.parseLong(id)).getStartDate().isEmpty()) {
						status="assigned";
					}
					else if(AssignmentLocalServiceUtil.getAssignment(Long.parseLong(id)).getEndDate().isEmpty()) {
						status="progress";
						break;
					}
					else {
						status="completed";
						break;
					}
				}
				if(status.equals("assigned")) {
					assignedUsers.add(thisOne);
				}
				else if(status.equals("progress")) {
					inProgressUsers.add(thisOne);
				}
			}

%>
			<tr>
				<td>
					<aui:form name="trackPage" action="<%= trackPage %>">
						<aui:input name="trackId" label="" value="<%= track.getTrackId() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="<%= track.getTitle() %>" />
					</aui:form>
				</td>
<!-- So the course list of a track is just a String with a , between each course's title. I tried doing a collection but it wouldn't compile. This requires a lot of formatting but at least it works.
The same is true of the skills in a course. -->
				<td><%= track.getCourseList() %></td>
				<td><%= track.getDescription() %></td>
				<td><%= cumulative %></td>
				<td>
<%
				for(User user: assignedUsers) {
%>
				<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
					<aui:input name="userAssignmentsScreenName" label="" value="<%= user.getScreenName() %>" style="display:none;" />
					<input class="linkImitation" type="submit" value="<%= user.getFullName() %>" />
				</aui:form>
<%
				}
%>
				</td>
				<td>
<%
				for(User user: inProgressUsers) {
%>
				<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
					<aui:input name="userAssignmentsScreenName" label="" value="<%= user.getScreenName() %>" style="display:none;" />
					<input class="linkImitation" type="submit" value="<%= user.getFullName() %>" />
				</aui:form>
<%
				}
%>
				</td>
				<td>
					<button class="actionButton" onclick='openAssignTrack("<%= track.getTrackId() %>")'>Assign</button>
				</td>
			</tr>

<!-- It would make sense to make an "Assign Course" button above. Oh well. -->
	<div id = "assignTrack<%= track.getTrackId() %>Dialog" class="dialog" title = "Track Assignment">
    	<aui:form cssClass="inputForm" name="assignTrack" action="<%=assignTrack%>">
    		<aui:input name="trackId" label="" value="<%= track.getTrackId() %>" style="display:none;" />
    		<p class="spaceBelow 18font">Assign <i><%= track.getCourseList() %></i> to</p>
			<aui:select id="trackScreenName" name="screenName" label="">
	<%
			for(User user: newbies) {
	%>
				<aui:option value="<%= user.getScreenName() %>" label="<%= user.getFullName() %>"></aui:option>
	<%
			}
	%>
			</aui:select>
			<input type="submit" value="Assign"/>
    	</aui:form>
    </div>

<%
		}
%>
			


			</tbody>
		</table>
	</div>

<!-- requests are made by users and can be accepted or denied by an admin. There should be an email sent out when they are denied. -->
	<h3>Course Requests</h3>
	<div class="tableHolder">
	<div class="tableTitle">Course Requests</div>
		<table class="pagedSearchableDataTable">
		<thead>
			<tr>
				<th>Employee</th>
			    <th class="min100">Course Title</th>
			    <th>Request Actions</th>
			</tr>
		</thead>
		<tbody>
	<%
		for(Assignment assignment: assignments) {
			if(assignment.getAssignedDate().isEmpty() && assignment.getStatus().equals("requested")) {
	%>
			<tr>
				<td><%= assignment.getMs3employeedb_uid() %></td>
			    <td><%= assignment.getCourses_title() %></td>
			    <td>
			    	<aui:form name="approveRequest" action="<%=approveRequest%>">
						<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input id="doApprove" type="submit" value="Approve"/>
					</aui:form>

					<aui:form name="denyRequest" action="<%=denyRequest%>">
						<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input style="color:red;" type="submit" value="Deny"/>
					</aui:form>
				</td>
			</tr>
	<%
			}
		}
	%>
		</tbody>
		</table>
	</div>
	
	
		<h3>Track Requests</h3>
	<div class="tableHolder">
	<div class="tableTitle">Track Requests</div>
		<table class="pagedSearchableDataTable">
		<thead>
			<tr>
				<th>Employee</th>
			    <th class="min100">Track Title</th>
			    <th class="min100">Track Courses</th>
			    <th>Request Actions</th>
			</tr>
		</thead>
		<tbody>
	<%
		for(TrackAssignment trackAssignment: trackAssignments) {
			if(trackAssignment.getDateAssigned().isEmpty() && trackAssignment.getAdmin().isEmpty()) {
				Track track = TrackLocalServiceUtil.getTrack(trackAssignment.getTrackId());
	%>
			<tr>
				<td><%= trackAssignment.getUserScreenName() %></td>
			    <td><%= track.getTitle() %></td>
			    <td><%= track.getCourseList() %></td>
			    <td>
			    	<aui:form name="approveRequest" action="<%=approveTrackRequest%>">
						<aui:input name="trackAssignmentId" label="" value="<%= trackAssignment.getTrackAssignmentId() %>" style="display:none;" />
						<input id="doApprove" type="submit" value="Approve"/>
					</aui:form>

					<aui:form name="denyRequest" action="<%=denyTrackRequest%>">
						<aui:input name="trackAssignmentId" label="" value="<%= trackAssignment.getTrackAssignmentId() %>" style="display:none;" />
						<input style="color:red;" type="submit" value="Deny"/>
					</aui:form>
				</td>
			</tr>
	<%
			}
		}
	%>
		</tbody>
		</table>
	</div>
	
	
	<h3>All Course Assignments (Not Started)</h3>
	<div class="tableHolder">
	<div class="tableTitle">Courses Assigned</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
				<th>Name</th>
			    <th>Course Title</th>
			    <th>Date Assigned</th>
			    <th>Assigned By</th>
			</tr>
			</thead>
			<tbody>
<%
		List<Assignment> assigned = new ArrayList<Assignment>();
		for(Assignment assignment: assignments) {
			if(!assignment.getAssignedDate().isEmpty() && assignment.getStartDate().isEmpty()) {
				assigned.add(assignment);	
			}
		}
		for(Assignment assignment: assigned) {
%>
			<tr>
				<td>
					<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
						<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="<%= UserLocalServiceUtil.getUserByScreenName(companyId, assignment.getMs3employeedb_uid()).getFullName() %>" />
					</aui:form>
				</td>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getAssignedDate().substring(0, assignment.getAssignedDate().indexOf(" ")) %></td>
			    <td></td>
			</tr>
<%
		}
%>
			</tbody>
		</table>
	</div>
	
	<h3>All Courses in Progress</h3>
	<div class="tableHolder">
	<div class="tableTitle">Courses in Progress</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
				<th>Name</th>
			    <th>Course Title</th>
			    <th>Assigned By</th>
			    <th>Date Started</th>
			    <th>Hours Spent</th>
			    <th>Current Section</th>
			    <th class="min100">Status</th>
			    <th>Last Log</th>
			    <th>Read Logs</th>
			</tr>
			</thead>
			<tbody>
<%
		List<Assignment> inProgress = new ArrayList<Assignment>();
		for(Assignment assignment: assignments) {
			if(!assignment.getStartDate().isEmpty() && assignment.getEndDate().isEmpty()) {
				inProgress.add(assignment);
			}
		}
		for(Assignment assignment: inProgress) {
			Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
			User user = UserLocalServiceUtil.getUserByScreenName(companyId, assignment.getMs3employeedb_uid());
	//find the date of the latest daily log by looking at which was last to be made (log id's always go up sequentially, starting at 0)
			String lastLog = "";
			long biggestId = -1;
			for(DailyLog log: dailyLogs) {
				if(log.getAssignment_id()==assignment.getAssignmentId()) {
					if(log.getDailyLogId() > biggestId) {
						biggestId=log.getDailyLogId();
					}
				}
			}
			if(biggestId==-1) {
				lastLog="No logs";
			}
			else {
				lastLog=DailyLogLocalServiceUtil.getDailyLog(biggestId).getDate();
			}
%>
			<tr>
				<td>
					<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
						<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="<%= user.getFullName() %>" />
					</aui:form>
				</td>
			    <td><%= assignment.getCourses_title() %></td>
			    <td>></td>
			    <td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
			    <td><%= format.format(assignment.getHoursSpent()) %></td>
			    <td><%= assignment.getCurrentSection() %> / <%= course.getSections() %> </td>
			    <td><%= assignment.getStatus() %></td>
			    <td><%= assignment.getNotes() %></td>
				<td><%= lastLog %></td>
				<td>
			    	<aui:form name="dailyLogsPage" action="<%=dailyLogsPage%>">
						<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="Past Logs"/>
					</aui:form>
				</td>
			</tr>
<%
		}
%>
			</tbody>
		</table>
		
		<portlet:actionURL var="editArticleActionURL">
	<portlet:param name="action" value="makeTrack" />
</portlet:actionURL>
<div id = "makeTrackDialog" class="dialog" title = "Track Creation">
<p>Select courses in the order you want them to be taken</p>
<aui:form action="<%=editArticleActionURL%>" method="post" name="LiferayAautoFieldForm">
		<aui:input cssClass="normalInput" name="title" label="Title" type="text">
			<aui:validator name="maxLength">75</aui:validator>
			<aui:validator name="required" />
		</aui:input>
		<aui:input class="normalInput" name="description" label="Description" type="textarea">
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
		
		<!-- This is the stuff I'm using for Liferay Auto Fields that allows you to add or remove fields dynamically.
		It breaks really easily. I can't get it to happen twice on the same page - for this and the skills in a new course. -->
  <div id="courseList">
    <div class="lfr-form-row lfr-form-row-inline">
      <div class="row-fields">
		<aui:select id="courseTitle1" name="courseTitle1" label="Course">
<%
		for(Course course: courses) {
%>
			<aui:option value="<%= course.getTitle() %>" label="<%= course.getTitle() %>"></aui:option>
<%
		}
%>
		</aui:select>
      </div>
    </div>
  </div>
  <aui:layout>
    <aui:column>
      <aui:button type="submit" value="Save Track"></aui:button>
    </aui:column>
  </aui:layout>
  
  	<!-- This is the script to make the Auto Fields work (the automatic option to add multiple courses for the track). 
  	For whatever reason, it won't work if I change the name of 'phonesIndexes'. Also, I can't use it on the skills for
  	the courses, only can use it once. -->
  <aui:script use="liferay-auto-fields">
    new Liferay.AutoFields(
    {
    contentBox: '#courseList',
    fieldIndexes: '<portlet:namespace />phonesIndexes'
    }).render();
  </aui:script>
</aui:form>
</div>
		
	</div>



<h3>All Track Assignments</h3>
	<div class="tableHolder">
	<div class="tableTitle">Track Assignments</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
				<th>Name</th>
				<th>Track Title</th>
				<th>Courses Status</th>
				<th>Assigned By</th>
			</tr>
			</thead>
			<tbody>
<%

	for(TrackAssignment trackAssignment: trackAssignments) {
		User user = UserLocalServiceUtil.getUserByScreenName(companyId, trackAssignment.getUserScreenName());
		Track track = TrackLocalServiceUtil.getTrack(trackAssignment.getTrackId());
		String[] assignmentIds = trackAssignment.getAssignmentIdList().split(", ");
		
%>

			<tr>
				<td><%= user.getFullName() %></td>
				<td><%= track.getTitle() %></td>
				<td>
<%
// there is exactly one assignment for each user/ course combo
			for(int i=0; i<assignmentIds.length; i++) {
				Assignment assignment = AssignmentLocalServiceUtil.getAssignment(Long.parseLong(assignmentIds[i]));
				String status= "";
				if(assignment.getStartDate().isEmpty()) {
					status="Assigned";
				}
				else {
					if(!assignment.getEndDate().isEmpty()) {
						status="Completed";
					}
					else {
						status="In Progress";
					}
				}
%>
					<p><%= i %>: <u><%= assignment.getCourses_title() %>:</u> <%= status %></p>
<%
			}
%>
				</td>
				<td></td>
			</tr>
<%
	}
%>

		</tbody>
	</table>
</div>

<!-- end of the accordion -->
</div>


<%
//ending the original if/else checking if they're signed in.
}
%>
