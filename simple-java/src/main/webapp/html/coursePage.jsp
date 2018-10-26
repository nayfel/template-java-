<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>
<%
// this page shows the details of a single page and the users interacting with it. Allows editing of the course. This is only available to admins.

DecimalFormat format = new DecimalFormat();
format.setDecimalSeparatorAlwaysShown(false);
	String sentTitle = (String)prefs.getValue("assignTitle","");
	Course course = CourseLocalServiceUtil.getCourse(sentTitle);
	
%>

<portlet:actionURL var="assignToUser">
	<portlet:param name="action" value="assignToUser" />
</portlet:actionURL>
<portlet:actionURL var="viewUserAssignments">
	<portlet:param name="action" value="viewUserAssignments" />
</portlet:actionURL>
<portlet:actionURL var="approveRequestFromAssign">
	<portlet:param name="action" value="approveRequestFromAssign" />
</portlet:actionURL>
<portlet:actionURL var="deleteCourse">
	<portlet:param name="action" value="deleteCourse" />
</portlet:actionURL>
<portlet:actionURL var="editCourse">
   <portlet:param name="action" value="editCourse" />
</portlet:actionURL>
<portlet:actionURL var="dailyLogsPage">
   <portlet:param name="action" value="dailyLogsPage" />
</portlet:actionURL>
<portlet:actionURL var="addSkill">
   <portlet:param name="action" value="addSkill" />
</portlet:actionURL>
<portlet:actionURL var="coursePage">
   <portlet:param name="action" value="coursePage" />
</portlet:actionURL>


<div class="tableHolder">
<div class="tableTitle"><%= course.getTitle() %></div>
<table class="dataTable plain">
	<thead>
	<tr>
		<th>Title</th>
		<th class="min100">Description</th>
		<th>Provider</th>
		<th>List Price</th>
		<th>Estimated Hours</th>
		<th>Sections</th>
		<th>Skills</th>
		<th class="min220">Actions</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td><%=course.getTitle() %></td>
		<td><%=course.getDescription() %></td>
		<td><%=course.getProvider() %></td>
		<td><%=course.getListPrice() %></td>
		<td><%= format.format(course.getEstimatedHours()) %></td>
		<td><%=course.getSections() %></td>
		<td><%= course.getSkills() %></td>
		<td>		
			<button class="spaceAround" onclick="$( '#editCourseDialog' ).dialog( 'open' );" >Edit</button>
			<button class="bigRed spaceAround" onclick="$( '#deleteCourseDialog' ).dialog( 'open' );">Delete</button>
		</td>
	</tr>
	</tbody>
</table>
</div>


	<div id = "editCourseDialog" class="dialog" title = "Update Course">
		<aui:form class="inputForm" name="editCourse" action="<%=editCourse%>">
			<div>Title: <br />
			<span class="spaceAround bold" ><%= course.getTitle() %></span>
			</div>
			<aui:input name="description" label="Description: " type="textarea" value="<%= course.getDescription() %>">
				<aui:validator name="maxLength">500</aui:validator>
			</aui:input>
			<aui:input name="provider" label="Provider: " type="text" value="<%= course.getProvider() %>">
				<aui:validator name="maxLength">75</aui:validator>
			</aui:input>
			<aui:input name="listPrice" label="List Price" type="text" value="<%= course.getListPrice() %>"/>
			<aui:input name="estimatedHours" label="Estimated Hours" value="<%= format.format(course.getEstimatedHours()) %>" type="text" >
				<aui:validator name="number" errorMessage="Please enter one number"></aui:validator>
			</aui:input>
			<aui:input name="sections" label="Total Sections" value="<%= course.getSections() %>" type="text"/>
			<div class="under16 spaceAround">Skills</div>	
<%
		if(course.getSkills().isEmpty()) {
%>
			<div><span class="italic"><%= course.getTitle() %></span> does not have any skills attached to it yet.</div>	
<%
		} else {
			String[] skills = course.getSkills().split(", ");
			for(int i=0; i<skills.length; i++) {
%>
				<aui:input name="<%= String.valueOf(i) %>" value="<%= skills[i] %>" label="Existing Skill" />
<%		
			}
		}
%>
			<aui:input name="newSkill" label="New skill" type="text" >
				<aui:validator name="custom" errorMessage="The skill cannot contain any commas." >
	function(val, fieldNode, ruleValue) {
		return val.indexOf(',') < 0;
	}
				</aui:validator>
			</aui:input>
			<input type="submit" value="Update" />
		</aui:form>
	</div>


<div id = "deleteCourseDialog" class="dialog" title = "WARNING!">
	<p class="warning">If you delete this course, it will delete all users' records of its assignment and completion!</p>
	<p class="spaceAbove bold">Are you sure you want to delete this course?</p>
	<aui:form name="deleteCourse" action="<%= deleteCourse %>">
		<input class="inline dialogButtons" type="submit" value="Yes" />
	</aui:form>
	<button class="inline dialogButtons" onclick="$(this).parent().dialog('close')">No</button>
</div>


<div class="accordion">

<%
List<Assignment> courseAssignments = new ArrayList<Assignment>();
for(Assignment assignment: assignments) {
	if(assignment.getCourses_title().equals(sentTitle)) {
		courseAssignments.add(assignment);
	}
}

List<Track> relevantTracks = new ArrayList<Track>();
for(Track track: tracks) {
	String[] titles= track.getCourseList().split(", ");
	for(int i=0; i<titles.length; i++) {
		if(titles[i].equals(sentTitle)) {
			relevantTracks.add(track);
		}
	}
}
	if(!relevantTracks.isEmpty()) {
%>
<h3>Containing Tracks</h3>
<div class="tableHolder">
	<div class="tableTitle">Tracks</div>
	<table class="pagedSearchableDataTable">
		<thead>
		<tr>
			<th>Title</th>
			<th>Courses</th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody>
<%
		for(Track track: relevantTracks) {
			String[] titles= track.getCourseList().split(", ");
%>
		<tr>
			<td><%= track.getTitle() %></td>
			<td>
<%					for(int i=0; i<titles.length; i++) {	%>
						<p style="margin-bottom:8px;"><%= titles[i] %></p>
<%					}	%>
			</td>
			<td><%= track.getDescription() %></td>
		</tr>
	</tbody>
<%		}	%>
	</table>
</div>
<%	
	}


if(courseAssignments.isEmpty()) {
%>
	<h3>Nobody has ever worked on this course.</h3>
	<p class="tableReplacement">Assign it to somebody below.</p>
<%
}
else {

//separate assignments into appropriate lists
	List<Assignment> inProgress = new ArrayList<Assignment>();
	List<Assignment> requested = new ArrayList<Assignment>();
	List<Assignment> assigned = new ArrayList<Assignment>();
	List<Assignment> completed = new ArrayList<Assignment>();
	for(Assignment assignment: courseAssignments) {
		if(!assignment.getStartDate().isEmpty() && assignment.getEndDate().isEmpty()) {
			inProgress.add(assignment);
		}
		else if(!assignment.getAssignedDate().isEmpty() && assignment.getStartDate().isEmpty()) {
			assigned.add(assignment);	
		}
		else if(assignment.getAssignedDate().isEmpty() && assignment.getStatus().equals("requested")) {
			requested.add(assignment);
		}
		else if(!assignment.getEndDate().isEmpty()) {
			completed.add(assignment);
		}
	}
	
%>

	<h3>Working on</h3>
<%
	if(inProgress.isEmpty()) {
%>
		<p class="tableReplacement">Nobody is currently working on this course.</p>
<%
	}
	else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Current workers</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
			    <th>Screen Name</th>
			    <th>Date Started</th>
			    <th>Current Section</th>
			    <th>Hours Spent</th>
			    <th class="min100">Status</th>
			    <th class="min100">Overall Notes</th>
			    <th>Read Logs</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: inProgress) {
%>
			<tr>
			    <td>
					<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
						<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
					</aui:form>
				</td>
			    <td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
			    <td><%= assignment.getCurrentSection() %></td>
			    <td><%= assignment.getHoursSpent() %></td>
			    <td><%= assignment.getStatus() %></td>
			    <td><%= assignment.getNotes() %></td>
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
	</div>
<%
		}
%>
	
	
	<h3>Assigned to</h3>
<%
	if(assigned.isEmpty()) {
%>
		<p class="tableReplacement">This course is not currently assigned to anybody.</p>
<%
	}
	else {
%>
		<div class="tableHolder">
			<div class="tableTitle">This course is assigned to</div>
			<table class="pagedSearchableDataTable">
				<thead>
				<tr>
					<th>Name</th>
					<th>Date Assigned</th>
				</tr>	
				</thead>
				<tbody>
<%
	for(Assignment assignment: assigned) {
%>
				<tr>
					<td>
						<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
							<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
							<input class="linkImitation" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
						</aui:form>
					</td>
					<td><%= assignment.getAssignedDate().substring(0, assignment.getAssignedDate().indexOf(" ")) %></td>
				</tr>
<%
		}
%>
				</tbody>
			</table>
		</div>
<% 
	}
%>


	<h3>Requested by</h3>
<%
	if(requested.isEmpty()) {
%>
	<p class="tableReplacement">There are no outstanding requests to take this course.</p>
<%
	}
	else {
%>
<div class="tableHolder">
	<div class="tableTitle">This course is requested by</div>
	<table class="pagedSearchableDataTable">
		<thead>
		<tr>
			<th>Name</th>
			<th>Approve</th>
		</tr>
		</thead>
		<tbody>
<%
		for(Assignment assignment: requested) {
%>
		<tr>
			<td>
				<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
					<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
					<input class="linkImitation" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
				</aui:form>
			</td>
			<td>
		    	<aui:form name="approveRequestFromAssign" action="<%=approveRequestFromAssign%>">
					<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
					<input id="doApprove" type="submit" value="Approve"/>
				</aui:form>
			</td>
		</tr>
<%
		}
%>
		</tbody>
	</table>
</div>
<% 
	}
%>


<h3>Completed by</h3>
<%
	if(completed.isEmpty()) {
%>
	<p class="tableReplacement">Nobody has completed this course yet</p>
<%
	}
	else {
%>
	<div class="tableHolder">
		<div class="tableTitle">This course has been completed by </div>
		<table class="pagedSearchableDataTable">
			<thead>
				<tr>
					<th>Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Total Hours</th>
					<th>Certified</th>
					<th>Amount Paid</th>
					<th class="min100">Overall Notes</th>
					<th>Read Logs</th>
				</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: completed) {
%>
				<tr>
					<td>
						<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
							<aui:input name="userAssignmentsScreenName" label="" value="<%= assignment.getMs3employeedb_uid() %>" style="display:none;" />
							<input class="linkImitation" type="submit" value="<%= assignment.getMs3employeedb_uid() %>" />
						</aui:form>
					</td>
					<td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
					<td><%= assignment.getEndDate().substring(0, assignment.getEndDate().indexOf(" ")) %></td>
					<td><%= assignment.getHoursSpent() %></td>
					<td><%= assignment.getCertification() %></td>
					<td><%= assignment.getCost() %></td>
					<td><%= assignment.getNotes() %></td>
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
	</div>
<% 
	}

//end of the else, seeing if there are any assignments linked to this course
}

%>
<h3>Available Users</h3>
<div class="tableHolder">
	<div class="tableTitle">Available Users</div>
	<table class="pagedSearchableDataTable">
		<thead>
		<tr>
			<th>Name</th>
			<th>Assign This Course</th>
		</tr>
		</thead>
		<tbody>
<%
for(User user: users) {
	boolean skip= false;
	for(Assignment assignment: courseAssignments) {
		if(user.getScreenName().equals(assignment.getMs3employeedb_uid())) {
			skip=true;
		}
	}
	if(!skip) {
%>
		<tr>
			<td>
				<aui:form name="viewUserAssignments" action="<%= viewUserAssignments %>">
					<aui:input name="userAssignmentsScreenName" label="" value="<%= user.getScreenName() %>" style="display:none;" />
					<input class="linkImitation" type="submit" value="<%= user.getFullName() %>" />
				</aui:form>
			</td>
			<td>
				<aui:form class="inputForm" name="assignToUser" action="<%=assignToUser%>">
					<aui:input name="user" label="" value="<%= user.getScreenName() %>" style="display:none;"/>
					<input value="Assign By Screen Name	" type="submit" />
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
</div>