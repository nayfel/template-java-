<%@include file="/html/init.jsp" %>

<portlet:actionURL var="updateAssignment">
   <portlet:param name="action" value="updateAssignment" />
</portlet:actionURL>
<portlet:actionURL var="startAssignment">
   <portlet:param name="action" value="startAssignment" />
</portlet:actionURL>
<portlet:actionURL var="makeDailyLog">
   <portlet:param name="action" value="makeDailyLog" />
</portlet:actionURL>
<portlet:actionURL var="dailyLogsPage">
   <portlet:param name="action" value="dailyLogsPage" />
</portlet:actionURL>
<portlet:actionURL var="requestCourse">
   <portlet:param name="action" value="requestCourse" />
</portlet:actionURL>
<portlet:actionURL var="requestTrack">
   <portlet:param name="action" value="requestTrack" />
</portlet:actionURL>

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>

<%
String hasPermission = prefs.getValue("hasPermission", "");
DecimalFormat format = new DecimalFormat();
format.setDecimalSeparatorAlwaysShown(false);
//make sure this user has assignments

List<Assignment> relevantAssignments = new ArrayList<Assignment>();
for(Assignment assignment: assignments) {
	if(screenName.equals(assignment.getMs3employeedb_uid())) {
		relevantAssignments.add(assignment);
	}
}


if(themeDisplay.getUser().getFullName().equals("")) {
%>
	<p>Please sign in to access this portlet.</p>
<%
}
else {
	if(hasPermission.equals("true")) {
%>
<a class="under16" href="<%=home%>">Go Home</a>
<br />
<button class="linkImitation" style="font-size:16px;" onClick="javascript: window.history.go(-1)">Go Back</button>
<br />
<%
	}
%>	
	<div class="accordion">
<%
	if(!hasPermission.equals("true")) {
%>
		<h3>Course List</h3>	
		<div class="tableHolder">
		<div class="tableTitle"><div class="inline">Courses </div></div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
				<th>Title </th>
				<th class="min100">Description </th>
				<th>Provider </th>
				<th>List Price </th>
				<th>Estimated Total Hours </th>
				<th>Total Sections </th>
				<th>Personal Status</th>	
			</tr>
			</thead>
			<tbody>
		<%
			for(Course course: courses) {
		%>	
			<tr>
				<td><div><%=course.getTitle() %></div></td>
				<td><div><%=course.getDescription() %></div></td>
				<td><div><%=course.getProvider() %></div></td>
				<td><div><%=course.getListPrice() %></div></td>
				<td><div><%= format.format(course.getEstimatedHours()) %></div></td>
				<td><div><%=course.getSections() %></div></td>
		<%
					String status= "None";
					for(Assignment assignment: assignments) {
						if(assignment.getCourses_title().equals(course.getTitle())) {
							if(assignment.getMs3employeedb_uid().equals(screenName)) {
								if(!assignment.getStartDate().isEmpty() && assignment.getEndDate().isEmpty()) {
									status= "In Progress";
								}
								else if(!assignment.getAssignedDate().isEmpty() && assignment.getStartDate().isEmpty()) {
									status= "Assigned";	
								}
								else if(assignment.getAssignedDate().isEmpty() && assignment.getStatus().equals("requested")) {
									status= "Requested";
								}
								else if(!assignment.getEndDate().isEmpty()) {
									status= "Completed";
								}
								else {		//not sure if I should keep this. It shouldn't ever happen...
									status= "ERROR";
								}
								break;
							}
						}
					}
	%>
				<td>
						<p class="tableReplacement"><%= status %></p>
	<%
				if(status.equals("None")) {
	%>
						<aui:form style="margin: -20px 0 -10px 0" name="requestCourse" action="<%=requestCourse%>">
							<aui:input name="requestTitle" label="" value="<%= course.getTitle() %>" style="display:none;" />
							<input id="doAssign" type="submit" value="Request"/>
						</aui:form>
	<%
				}
	%>
				</td>
			</tr>
		<%
			}
		%>
			</tbody>
		</table>
		</div>


	
	<h3>Track List</h3>
	<div class="tableHolder">
		<div class="tableTitle">Tracks</div>
		<table class="pagedSearchableDataTable">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Course List</th>
					<th>Personal Status</th>
				</tr>
			</thead>
			<tbody>
<%
		for(Track track: tracks) {
			String[] courseList = track.getCourseList().split(", ");
%>
				<tr>
					<td><%= track.getTitle() %></td>
					<td><%= track.getDescription() %></td>
					<td>
<%
						for(int i= 0; i < courseList.length; i++) {
%>
							<p><b><%= i+1 %>:</b> <%= courseList[i] %></p>
<%
						}
%>
					</td>
					<td>
<%
					String status="None";
					for(TrackAssignment trackAssignment: trackAssignments) {
						if(trackAssignment.getUserScreenName().equals(screenName) && trackAssignment.getTrackId()==track.getTrackId()) {
							String[] relevantAssignmentsString = trackAssignment.getAssignmentIdList().split(", ");
							for(String assignmentId: relevantAssignmentsString) {
								Assignment assignment = AssignmentLocalServiceUtil.getAssignment(Long.parseLong(assignmentId));
								if(!assignment.getEndDate().isEmpty()) {
									status="Completed";
								}
								else if(!assignment.getStartDate().isEmpty()) {
									status="In Progress";
								}
								else if(!assignment.getAssignedDate().isEmpty()) {
									status="Assigned";
								}
								else {
									status="Requested";
								}
								break;
							}
							break;
						}
					}
%>				
						<p class="tableReplacement"><%= status %></p>
<%
					if(status.equals("None")) {
%>
							<aui:form style="margin: -20px 0 -10px 0" name="requestTrack" action="<%=requestTrack%>">
								<aui:input name="trackId" label="" value="<%= track.getTrackId() %>" style="display:none;" />
								<input type="submit" value="Request"/>
							</aui:form>
<%					}	%>
						
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
	if(relevantAssignments.isEmpty()) {
%>
	<p class="tableReplacement">You do not have any courses assigned to you.</p>
	<p class="tableReplacement">Request one above.</p>
<%
	}
	else {
		
//separate assignments into appropriate lists
		List<Assignment> inProgress = new ArrayList<Assignment>();
		List<Assignment> requested = new ArrayList<Assignment>();
		List<Assignment> assigned = new ArrayList<Assignment>();
		List<Assignment> completed = new ArrayList<Assignment>();
		for(Assignment assignment: relevantAssignments) {
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


<h3>In Progress</h3>
<%
	if(inProgress.isEmpty()) {
%>
		<p class="tableReplacement">You aren't currently working on any courses.</p>
<%
	}
	else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Courses in Progress</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
			    <th>Course Title</th>
			    <th>Date Started</th>
			    <th>Hours Spent</th>
			    <th>Current Section</th>
			    <th class="min100">Status</th>
			    <th>Course Actions</th>
			    <th>Read Logs</th>
			</tr>
			</thead>
			<tbody>
<%
		RESTservices reststuff = new RESTservices();
		List<Employee> employees = reststuff.getAllEmployees(prefs.getValue("employeeEndPoint", ""));
		
		for(Assignment assignment: inProgress) {
			Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
			    <td><%= assignment.getHoursSpent() %></td>
			    <td><%= assignment.getCurrentSection() %> / <%= course.getSections() %> </td>
			    <td><%= assignment.getStatus() %></td>
			    <td>
			    	<button class="inline" onclick='openUpdateAssigment("<%= assignment.getAssignmentId() %>")'>Update</button>
			    	<button class="inline spaceLeft" onclick='openMakeLog("<%= assignment.getAssignmentId() %>")'>Daily Log</button>
			    </td>
			    <td>
			    	<aui:form name="dailyLogsPage" action="<%=dailyLogsPage%>">
						<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="Past Logs"/>
					</aui:form>
				</td>
			</tr>
			
	<div id = "updateAssignment<%= assignment.getAssignmentId() %>Dialog" class="dialog" title = "Progress Update">
    	<aui:form cssClass="inputForm" name="updateAssigment" action="<%=updateAssignment%>">
			<div class="dialogHeader"><%= assignment.getCourses_title() %></div>
			<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
			<aui:select name="status" label="Status">
				<option selected="selected" label="<%= assignment.getStatus() %>" value="<%= assignment.getStatus() %>"></option>
				<option label="In Progress" value="In Progress"></option>
				<option label="Paused" value="Paused"></option>
				<option label="Stuck" value="Stuck"></option>
				<option label="Abandoned" vlaue="Abandoned"></option>
				<option label="Other" value="Other"></option>
			</aui:select>
			<aui:input name="certified" label="Certified" type="checkbox" value="<%= assignment.getCertification() %>"/>
			<aui:input name="completed" label="Completed" type="checkbox" onchange="showSelect()" />
			<div class="empList" style="display:none;">
				<aui:select name="employeeId" label="Employee List">
					<aui:option label="" value="" selected='true' />
	<%
				for(Employee emp: employees) {
					String fullName = emp.getFirstName()+" "+emp.getLastName();
	%>
					<aui:option label="<%= fullName %>" value="<%=emp.getEmployeeId()%>" />
	<%			}	%>
				</aui:select>
				<aui:input name="notes" label="Course Summary" value="" type="textarea">
					<aui:validator name="maxLength">75</aui:validator>
				</aui:input>
			</div>
			<input type="submit" value="Update"/>
		</aui:form>
   	</div>
   	
   	<div id = "makeDailyLog<%= assignment.getAssignmentId() %>Dialog" class="dialog" title = "Today's Summary">
    	<aui:form cssClass="inputForm" name="makeDailyLog" action="<%=makeDailyLog%>">
			<div class="dialogHeader"><%= assignment.getCourses_title() %></div>
			<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
			<aui:input name="hours" label="Hours " type="text" >
				<aui:validator name="number" errorMessage="Please enter one number"></aui:validator>
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input name="section" label="Current Section" type="text" value="<%= assignment.getCurrentSection() %>" />
			<aui:input name="accomplishments" label="Accomplishments " type="textarea" value="" >
				<aui:validator name="maxLength">500</aui:validator>
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input name="roadblocks" label="Roadblocks " type="textarea" value="" >
				<aui:validator name="maxLength">500</aui:validator>
			</aui:input>
			<aui:input name="plan" label="Plan for next time" type="textarea" value="" >
				<aui:validator name="maxLength">500</aui:validator>
			</aui:input>
			<aui:input name="notes" label="Other Notes" type="textarea" >
				<aui:validator name="maxLength">500</aui:validator>
			</aui:input>
			<input type="submit" value="Submit"/>
		</aui:form>
   	</div>
<%
		}
%>
			</tbody>
		</table>
	</div>
<%
		}
%>


<h3>Assigned</h3>
<%
	if(assigned.isEmpty()) {
%>
	<p class="tableReplacement">You are not assigned any courses.</p>
<%
	}
	else {
%>
	
	<div class="tableHolder">
		<div class="tableTitle">Assigned Courses</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
			    <th>Course Title</th>
			    <th>Date Assigned</th>
			    <th>Course Notes</th>
			    <th>Start Training</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: assigned) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getAssignedDate().substring(0, assignment.getAssignedDate().indexOf(" ")) %></td>
			    <td><%= assignment.getNotes() %></td>
			    <td>
					<button onclick='openStartAssigment("<%= assignment.getAssignmentId() %>")'>Start Course</button>
			    </td>
			</tr>
			
	<div id = "startAssignment<%= assignment.getAssignmentId() %>Dialog" class="dialog" title = "Start Course">
		<aui:form cssClass="inputForm" name="startAssigment" action="<%=startAssignment%>">
			<div cssClass="dialogHeader"><b><%= assignment.getCourses_title() %></b></div>
			<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
			<aui:input name="cost" label="Cost" type="text"/>
			<input type="submit" value="Commence"/>
		</aui:form>
	</div>
<%
			}
%>
			</tbody>
		</table>
	</div>
<%
		}
if(!hasPermission.equals("true")) {
%>
<h3>Requested</h3>
<%
		if(requested.isEmpty()) {
%>
		<p class="tableReplacement">You do not have any outstanding course requests.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Requested Courses</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
			    <th>Course Title</th>
			    <th>Provider</th>
			    <th>List Price</th>
			    <th class="min100">Status</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: requested) {
			Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= course.getProvider() %></td>
			    <td><%= course.getListPrice() %></td>
			    <td><%= assignment.getStatus() %></td>
			</tr>
<%
			}
%>
			</tbody>
		</table>
	</div>
<%
		}
}
%>


<h3>Completed</h3>
<%
		if(completed.isEmpty()) {
%>
		<p class="tableReplacement">You have not completed any courses yet.</p>
<%
		}
		else {
%>
	<div class="tableHolder">
		<div class="tableTitle">Completed Courses</div>
		<table class="pagedSearchableDataTable">
			<thead>
			<tr>
			    <th>Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Total Hours</th>
				<th>Certified</th>
				<th>Amount Paid</th>
				<th class="min100">Summary</th>
				<th>Course Actions</th>
			</tr>
			</thead>
			<tbody>
<%
		String cert= "";
		for(Assignment assignment: completed) {
			if(assignment.getCertification()) {
				cert = "<img class='cert' src='https://thecliparts.com/wp-content/uploads/2016/07/check-clipart-6.png' />"; 
			}
			else {
				cert = "<img class='cert' src='https://static1.squarespace.com/static/56d752cd356fb0d6f3fc3d47/t/573a17f47da24f53b4119280/1463425020501/citizen+x+3+logo+copy.jpg' />";
			}
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
				<td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
				<td><%= assignment.getEndDate().substring(0, assignment.getEndDate().indexOf(" ")) %></td>
				<td><%= format.format(assignment.getHoursSpent()) %></td>
				<td><%= cert %></td>
				<td><%= assignment.getCost() %></td>
				<td><%= assignment.getNotes() %></td>
				<td>
			    	<aui:form name="dailyLogsPage" action="<%=dailyLogsPage%>">
						<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
						<input class="linkImitation" type="submit" value="Read Logs"/>
					</aui:form>
					<button class = "spaceBelow" onclick='openCompletedAssigment("<%= assignment.getAssignmentId() %>")'>Update</button>
				</td>
			</tr>
			
	<div id = "updateCompletedAssignment<%= assignment.getAssignmentId() %>Dialog" class="dialog" title = "Progress Update">
    	<aui:form cssClass="inputForm" name="updateAssigment" action="<%=updateAssignment%>">
			<div class="dialogHeader"><%= assignment.getCourses_title() %></div>
			<aui:input name="assignmentId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
			<aui:input name="notes" label="Summary" value="<%= assignment.getNotes() %>" type="textarea">
				<aui:validator name="maxLength">500</aui:validator>
			</aui:input>
			<aui:input name="certified" label="Certified" type="checkbox" value="<%= assignment.getCertification() %>"/>
			<aui:input name="completed" label="Completed" type="checkbox" value="true" />
			<input type="submit" value="Update"/>
		</aui:form>
   	</div>
<%
			}
%>
			</tbody>
		</table>
	</div>
	
<%
		}
	}
%>
	</div>
<%
}
%>