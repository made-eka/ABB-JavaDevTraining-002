<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="resources" value="/resources/theme1/css/core.css" scope="request" />
<html>
    <head>
        <link href="${resources}" rel="stylesheet">
        <c:if test="${mode == 'add'}">
            <title>Add User</title>
        </c:if>
        <c:if test="${mode == 'edit'}">
            <title>Update User</title>
        </c:if>
    </head>
    <body>
        <c:if test="${mode == 'add'}">
            <abb_h2>Add User</abb_h2>
        </c:if>
        <c:if test="${mode == 'edit'}">
            <abb_h2>Update User</abb_h2>
        </c:if>
        <br><br>
        <form:form method="POST" action="#" modelAttribute="user">
        <table>
            <tr>
                <td width=100>Username</td>
            <c:if test="${mode == 'add'}">
                <td><form:input size="20" maxlength="20" path="userName" value="${user.userName}"/></td>
            </c:if>
            <c:if test="${mode == 'edit'}">
                <td><form:input size="20" maxlength="20" path="userName" value="${user.userName}" readonly="true"/></td>
            </c:if>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input size="20" maxlength="20" path="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><form:input size="50" maxlength="50" path="address" value="${user.address}"/></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input type="number" style="width: 50px" path="age" value="${user.age}"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><spring:bind path="gender">
                    <c:forEach items="${genderList}" var="genderName">
                        <c:choose>
                            <c:when test="${genderName.key eq user.gender}">
                                <input type="radio" name="gender" value="${genderName.key}"
                                checked="checked">${genderName.value}
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="gender" value="${genderName.key}">${genderName.value}
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </spring:bind></td>
            </tr>
            <tr>
                <td>Division</td>
                <td><form:input size="20" maxlength="20" path="division" value="${user.division}"/></td>
            </tr>
            <tr><td colspan=2>&nbsp;</td></tr>
            <tr><td colspan=2><input type="submit" value="Save"/>
                <input type="button" value="Close" onclick="self.close()"/></td></tr>
        </table>
        </form:form>
    </body>
</html>