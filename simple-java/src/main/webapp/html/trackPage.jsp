<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<portlet:actionURL var="deleteTrack">
	<portlet:param name="action" value="deleteTrack" />
</portlet:actionURL>
<portlet:actionURL var="editTrack">
	<portlet:param name="action" value="editTrack" />
</portlet:actionURL>

<%
long trackId = Long.parseLong(prefs.getValue("trackId", ""));
Track track = TrackLocalServiceUtil.getTrack(trackId);
String[] courseTitles = track.getCourseList().split(", ");
int cumulative = 0;
for(String title: courseTitles) {
	cumulative+= CourseLocalServiceUtil.getCourse(title).getEstimatedHours();
}
%>

<div class="tableHolder">
<div class="tableTitle"><%= track.getTitle() %></div>
<table class="dataTable plain">
	<thead>
	<tr>
		<th>Title</th>
		<th class="min100">Description</th>
		<th>Estimated Cumulative Hours</th>
		<th>Course List</th>
		<th>Accreditation</th>
		<th class="min220">Actions</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td><%=track.getTitle() %></td>
		<td><%=track.getDescription() %></td>
		<td><%= cumulative %></td>
		<td><%= track.getCourseList() %></td>
		<td><%= track.getAccreditation() %></td>
		<td>		
			<button class="spaceAround" onclick="$( '#editTrackDialog' ).dialog( 'open' );" >Edit</button>
			<button class="bigRed spaceAround" onclick="$( '#deleteTrackDialog' ).dialog( 'open' );">Delete</button>
		</td>
	</tr>
	</tbody>
</table>


<%
//we want a single table that is broken out into each assignment to each course in the track.
//I cna first get all of the assignment ids from all of the track assignments to this track.
// then make a table of user, course name, status, date assigned

// the track fro this page, passed by the trackPage() function in the controller.

List<TrackAssignment> relevantTrackAssignments = new ArrayList<TrackAssignment>();
for(TrackAssignment trackAssignment: trackAssignments) {
	if(trackAssignment.getTrackAssignmentId()== trackId) {
		relevantTrackAssignments.add(trackAssignment);
	}
}

List<Assignment> relevantAssignments = new ArrayList<Assignment>();
for(TrackAssignment trackAssignment: relevantTrackAssignments) {
	String[] assignmentIds = trackAssignment.getAssignmentIdList().split(", ");
	for(String id: assignmentIds) {
		for(Assignment assignment: assignments) {
			if(assignment.getAssignmentId()==Long.parseLong(id)) {
				relevantAssignments.add(assignment);
				break;
			}
		}
	}
}

%>
<div class="tableHolder spaceAbove">
	<div class="tableTitle">All of this track's course assignments</div>
	<table class="dataTable plain">
		<thead>
		<tr>
			<th>Course</th>
			<th>Name</th>
			<th>Status</th>
			<th>Date Assigned</th>
			<th>Hours Spent</th>
			<th>Current Section</th>
		</tr>
		</thead>
		<tbody>
<%
		for(Assignment assignment: relevantAssignments) {
%>		
		<tr>
			<td><%= assignment.getCourses_title() %></td>
			<td><%= UserLocalServiceUtil.getUserIdByScreenName(companyId, assignment.getMs3employeedb_uid()) %></td>
			<td><%= assignment.getStatus() %></td>
			<td><%= assignment.getAssignedDate() %></td>
			<td><%= assignment.getHoursSpent() %></td>
			<td><%= assignment.getCurrentSection() %></td>
		</tr>
<%
		}
%>
		</tbody>
	</table>
</div>

<div id = "editTrackDialog" class="dialog" title = "Update Track">
	<aui:form class="inputForm" name="editTrack" action="<%=editTrack%>">
		<div>Title: <br />
		<span class="spaceAround bold" ><%= track.getTitle() %></span>
		</div>
		<aui:input name="description" label="Description: " type="textarea" value="<%= track.getDescription() %>">
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
		<aui:input name="accreditation" label="Accreditation: " type="text" value="<%= track.getAccreditation() %>" />
		<div class="under16 spaceAround">Course List</div>	
<%
		List<Course> availableCourses = new ArrayList<Course>();
		availableCourses.addAll(courses);
		for(int i=0; i<courseTitles.length; i++) {
			availableCourses.remove(CourseLocalServiceUtil.getCourse(courseTitles[i]));
%>
		<aui:select name="<%= String.valueOf(i) %>" label="Existing Course" >
			<aui:option value="<%= courseTitles[i] %>" label="<%= courseTitles[i] %>" selected='true' />
			<aui:option label="" value="" />
<%		
			for(Course course: courses) {
%>
				<aui:option label="<%= course.getTitle() %>" value="<%= course.getTitle() %>" />
<%			}	%>
		</aui:select>
<%		} %>
		<aui:select name="newCourse" label="New Course" >
			<aui:option label="" value="" selected='true' />
<%
		for(Course course: availableCourses) {
%>
			<aui:option label="<%= course.getTitle() %>" value="<%= course.getTitle() %>" />
<%
		}
%>
		</aui:select>

		<input type="submit" value="Update" />
	</aui:form>
</div>

<div id = "deleteTrackDialog" class="dialog" title = "WARNING!">
	<p class="warning">If you delete this track, it will delete all users' records of its assignment and completion!</p>
	<p class="spaceAbove bold">Are you sure you want to delete this track?</p>
	<aui:form name="deleteTrack" action="<%= deleteTrack %>">
		<input class="inline dialogButtons" type="submit" value="Yes" />
	</aui:form>
	<button class="inline dialogButtons" onclick="$(this).parent().dialog('close')">No</button>
</div>


