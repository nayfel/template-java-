<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:renderURL var ="home">
	<portlet:param name="mvcPath" value="/html/interaction/view.jsp"/>
</portlet:renderURL>


<a class="under16" href="<%=home%>">Go Home</a>
<br />
<button class="linkImitation spaceBelow" style="font-size:16px;" onClick="javascript: window.history.go(-1)">Go Back</button>
<br />