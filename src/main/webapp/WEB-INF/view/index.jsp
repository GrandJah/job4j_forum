<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="posts" type="java.util.List"--%>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <title>Forum</title>
</head>
<body>
<div class="row justify-content-center">
    <table class="table table-striped col-lg-6 col-md-8 col-sm-12">
        <tr class="row justify-content-center">
            <th class="col-3">Login as: ${user.username}</th>
            <th class="col-4"></th>
            <th class="col-3 text-right"><a href="<c:url value='/logout'/>">Выйти!</a></th>
        </tr>
        <tr class="row justify-content-center">
            <th colspan="4"><a href="<c:url value='/edit'/>">Добавить тему</a></th>
        </tr>
        <tr class="row justify-content-center">
            <th colspan="4">Темы форума</th>
        </tr>
        <c:forEach var="post" items="${posts}" varStatus="loop">
            <tr class="row justify-content-center table-bordered">
                <td class="col-12"><a href="<c:url value='/post?id=${post.id}'/>"><c:out
                        value="${post.name}"/></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
