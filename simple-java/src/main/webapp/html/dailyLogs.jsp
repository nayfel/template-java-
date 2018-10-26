<%@include file="/html/init.jsp" %>
<%@include file="/html/goHomeHeader.jsp" %>

<%
	String assignId = prefs.getValue("assignmentId", "");
	Long assignmentId = Long.parseLong(assignId);
	Assignment assignment = AssignmentLocalServiceUtil.getAssignment(assignmentId);
	List<DailyLog> relevant = new ArrayList<DailyLog>();
	User them = UserLocalServiceUtil.getUserByScreenName(companyId, assignment.getMs3employeedb_uid());
	for(DailyLog log: dailyLogs) {
		if(log.getAssignment_id()==assignmentId) {
			relevant.add(log);
		}
	}
	if(relevant.isEmpty()) {
%>
		<div class="tableReplacement">There aren't any logs here!</div>
<%
	}
	else {
	
%>

	<div class="tableHolder">
		<div class="tableTitle">Logs for <%= assignment.getCourses_title() %> by <%= them.getFullName() %></div>
		<table class="pagedSearchableDataTable">
			<thead>
				<tr>
				    <td>Date</td>
				    <td>Hours</td>
				    <td>Section</td>
				    <td>Accomplishments</td>
				    <td>Roadblocks</td>
				    <td>Plans</td>
				    <td class="min100">Notes</td>
				</tr>
			</thead>
			<tbody>
<%
		for(DailyLog log: relevant) {
%>
			<tr>
			    <td><%= log.getDate() %></td>
			    <td><%= log.getHours() %></td>
			    <td><%= log.getSection() %></td>
			    <td><%= log.getAccomplishments() %></td>
			    <td><%= log.getRoadblocks() %></td>
			    <td><%= log.getPlan() %></td>
			    <td><%= log.getNotes() %></td>
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