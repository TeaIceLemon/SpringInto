<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        li {
            display: inline;
        }
    </style>
</head>
<body>

<ul>
    <li><a href="/">Home</a></li>
    <li><a href="/register">Register</a></li>
    <li><a href="/login">Login</a></li>
    <sec:authorize access="isAuthenticated()">
    <li><a href="/user-adverts">User adverts</a></li>

    </sec:authorize>

</body>
</html>