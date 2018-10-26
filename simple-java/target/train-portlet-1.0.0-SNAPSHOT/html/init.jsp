<%@page import="ms3.service.service.TrackLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="java.util.List" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.text.DecimalFormat" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="com.squareup.okhttp.Response" %>
<%@ page import= "com.squareup.okhttp.Request" %>
<%@ page import= "com.squareup.okhttp.OkHttpClient" %>
<%@ page import= "org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import= "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import= "com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import= "com.liferay.portal.model.User" %>
<%@ page import= "com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import= "com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import= "com.liferay.portal.kernel.util.Constants" %>
<%@ page import= "com.liferay.portal.kernel.util.StringPool"  %>
<%@ page import= "com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import= "com.liferay.portal.model.Role" %>

<%@ page import= "ms3.train.controller.RESTservices" %>
<%@ page import= "ms3.train.objects.Employee" %>
<%@ page import="ms3.service.model.Course" %>
<%@ page import="ms3.service.model.Assignment" %>
<%@ page import= "ms3.service.model.DailyLog" %>
<%@ page import= "ms3.service.model.Track" %>
<%@ page import= "ms3.service.model.TrackAssignment" %>
<%@ page import="ms3.service.service.CourseLocalServiceUtil" %>
<%@ page import="ms3.service.service.AssignmentLocalServiceUtil" %>
<%@ page import= "ms3.service.service.DailyLogLocalServiceUtil" %>
<%@ page import= "ms3.service.service.TrackLocalServiceUtil" %>
<%@ page import= "ms3.service.service.TrackAssignmentLocalServiceUtil" %>

<%@include file="/html/scripts.jsp" %>
<%@include file="/html/style.jsp" %>
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
long companyId = themeDisplay.getCompanyId();
String screenName = themeDisplay.getUser().getScreenName();
List<Course> courses = CourseLocalServiceUtil.getCourses(0, CourseLocalServiceUtil.getCoursesCount());
List<Assignment> assignments = AssignmentLocalServiceUtil.getAssignments(0, AssignmentLocalServiceUtil.getAssignmentsCount());
List<DailyLog> dailyLogs = DailyLogLocalServiceUtil.getDailyLogs(0, DailyLogLocalServiceUtil.getDailyLogsCount());
List<Track> tracks = TrackLocalServiceUtil.getTracks(0, TrackLocalServiceUtil.getTracksCount());
List<TrackAssignment> trackAssignments = TrackAssignmentLocalServiceUtil.getTrackAssignments(0, TrackAssignmentLocalServiceUtil.getTrackAssignmentsCount());
List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
	String success = (String)request.getAttribute("success");
	if(success!=null) {
%>
		<p id="successText"><%= success %></p>
<%
	}
	String error = (String)request.getAttribute("error");
	if(error!=null) {
%>
		<p id="errorText"><%= error %></p>
<%
	}
%>