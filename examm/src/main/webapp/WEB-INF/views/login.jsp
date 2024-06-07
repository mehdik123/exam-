<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="/login" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"/>
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"/>
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>