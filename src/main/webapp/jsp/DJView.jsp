<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>DJ View</title>
<!-- <meta> -->
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!-- </meta> -->
</head>

<body>
	
<%-- 	<jsp:useBean id="beatModel" class="ru.coutvv.oop.samples.complex.mvc.view.DJView" scope="request" /> --%>
	<!--     <c:out value="Jetty JSP Example"></c:out> -->
	<h1>DJ View</h1>
	Beat per Minute: ${applicationScope['beatModel'].getBPM()}
	<form method="get" action="djview/servlet/DJView">
		<input type="text" name="bpm" value="${applicationScope['beatModel'].getBPM()}"/>
		&nbsp;
		<input type="submit" name="set" value="set"><br/>
		<input type="submit" name="decrease" value="-"><br/>
		<input type="submit" name="increase" value="+"><br/>
		<input type="submit" name="on" value="on"><br/>
		<input type="submit" name="off" value="off"><br/>
		
		
	</form>
</body>
</html>