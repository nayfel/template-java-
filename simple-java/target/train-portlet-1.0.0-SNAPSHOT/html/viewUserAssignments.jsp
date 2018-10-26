<%@page import="ms3.service.NoSuchCourseException"%>
<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<portlet:actionURL var="approveRequestFromAssign">
	<portlet:param name="action" value="approveRequestFromAssign" />
</portlet:actionURL>
<portlet:actionURL var="dailyLogsPage">
   <portlet:param name="action" value="dailyLogsPage" />
</portlet:actionURL>

<%
DecimalFormat format = new DecimalFormat();
format.setDecimalSeparatorAlwaysShown(false);
screenName = prefs.getValue("userScreenName", "");
List<Assignment> relevantAssignments = new ArrayList<Assignment>();
User them = UserLocalServiceUtil.getUserByScreenName(companyId, screenName);
for(Assignment assignment: assignments) {
	if(screenName.equals(assignment.getMs3employeedb_uid())) {
		relevantAssignments.add(assignment);
	}
}
	
	if(relevantAssignments.isEmpty()) {
%>
		<div><%= them.getFullName() %> does not have any relationship with any courses.</div>
<%	
	}
	else {
%>
		<div class="dialogHeader spaceBelow">Training Profile for <%= them.getFullName() %></div>
<%
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
		
//show off the lists

%>
	<div class="accordion">
	<h3>In Progress</h3>
<%
		if(inProgress.isEmpty()) {
%>
			<p class="tableReplacement"><%= them.getFullName() %> is not currently working on any courses.</p>
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
			    <th class="min100">Overall Notes</th>
			    <th>Read Logs</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: inProgress) {
			Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
			    <td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
			    <td><%= format.format(assignment.getHoursSpent()) %></td>
			    <td><%= assignment.getCurrentSection() %> / <%= course.getSections() %> </td>
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
			<p class="tableReplacement"><%= them.getFullName() %> is not currently assigned any courses.</p>
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
			</tr>
			</thead>
			<tbody>
<%
			for(Assignment assignment: assigned) {
%>
				<tr>
				    <td><%= assignment.getCourses_title() %></td>
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
		<p class="tableReplacement"><%= them.getFullName() %> does not have any outstanding course requests.</p>
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
			    <th>Approve</th>
			</tr>
			</thead>
			<tbody>
<%
			for(Assignment assignment: requested) {
				try {
					Course course = CourseLocalServiceUtil.getCourse(assignment.getCourses_title());
%>
				<tr>
				    <td><%= assignment.getCourses_title() %></td>
				    <td><%= course.getProvider() %></td>
				    <td><%= course.getListPrice() %></td>
				    <td>
				    	<aui:form name="approveRequestFromAssign" action="<%=approveRequestFromAssign%>">
							<aui:input name="requestId" label="" value="<%= assignment.getAssignmentId() %>" style="display:none;" />
							<input id="doApprove" type="submit" value="Approve"/>
						</aui:form>
					</td>
				</tr>
<%
				} 	//cleaning up from delete course before I made it delete these there.
				catch(NoSuchCourseException e) {
					for(DailyLog log: dailyLogs) {
						if(log.getAssignment_id()== assignment.getAssignmentId()) {
							DailyLogLocalServiceUtil.deleteDailyLog(log);
						}
					}
					AssignmentLocalServiceUtil.deleteAssignment(assignment);
				}
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
			<p class="tableReplacement"><%= them.getFullName() %> has not completed any courses yet.</p>
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
				<th class="min100">Overall Notes</th>
				<th>Read Logs</th>
			</tr>
			</thead>
			<tbody>
<%
		for(Assignment assignment: completed) {
%>
			<tr>
			    <td><%= assignment.getCourses_title() %></td>
				<td><%= assignment.getStartDate().substring(0, assignment.getStartDate().indexOf(" ")) %></td>
				<td><%= assignment.getEndDate().substring(0, assignment.getEndDate().indexOf(" ")) %></td>
				<td><%= format.format(assignment.getHoursSpent()) %></td>
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
	}
%>