<%@ page import="model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%
    Task task = (Task) request.getAttribute("task");
%>
<jsp:include page="header.jsp" />

<h1>Read existing Task</h1>

<p>Id: <%=task.getId()%></p>
<p>Title: <%=task.getName()%></p>
<p>Priority: <%=task.getPriority()%></p>
</body>
</html>
