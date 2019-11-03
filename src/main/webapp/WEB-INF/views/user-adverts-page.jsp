<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 11/3/2019
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>User Adverts</title>
</head>
<body>
<div class="row">
    <div class="col-12" style="padding-bottom: 20px">
        <table>
            <tr>
                <th>Lp.</th>
                <th>Tytuł</th>
                <th>Treść</th>
                <th>Autor</th>
                <th>Data dodania</th>
                <th>Akcje</th>
            </tr>
            <c:forEach items="${userAdverts}" var="advert" varStatus="stat">
                <tr>
                    <td>${stat.count}</td>
                    <td><b>${advert.title}</b></td>
                    <td>${advert.description}</td>
                    <td>${advert.owner.username}</td>
                    <td>${advert.posted}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
