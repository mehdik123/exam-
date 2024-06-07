<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Affectation</title>
</head>
<body>
<h2>Employee Affectation</h2>
<form action="/manager/assign" method="post">
    <label for="employee">Employee Name:</label>
    <select name="employeeId" id="employee">
        <c:forEach items="${employees}" var="employee">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <label for="project">Project Name:</label>
    <select name="projectId" id="project">
        <c:forEach items="${projects}" var="project">
            <option value="${project.id}">${project.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Affecter projet</button>
</form>
</body>
</html>
