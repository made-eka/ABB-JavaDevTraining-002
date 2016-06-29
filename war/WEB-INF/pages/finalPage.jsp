<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% response.addHeader("Refresh","5"); %>
<c:url var="resources" value="/resources/theme1/css/core.css" scope="request" />

<html>
    <head>
        <link href="${resources}" rel="stylesheet">
    </head>
    <body>
        <abb_h1>The Final Page</abb_h1><br>
        <abb_h2>${input_message}</abb_h2><br><br>
        <table border="1">
            <tr>
                <th width="100">User Name</td>
                <th width="200">Email</td>
            </tr>
            <c:forEach var="user" items="${user_list}">
            <tr>
                <td><a href=# onclick="window.open('/ABBJavaDev-SpringMVC/user/${user.userName}', '_blank',
                    'width=600, height=400','toolbar=no,location=no,menubar=no,scrollbars=no');">${user.userName}</a></td>
                <td>${user.email}</td>
            </tr>
            </c:forEach>
        </table>
        <form:form method="GET" action="/ABBJavaDev-SpringMVC/backToIndex">
            <table>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Back"/>
                        <input type="button" value="Add User" onclick="window.open('/ABBJavaDev-SpringMVC/addUser', '_blank',
                        'width=600, height=400','toolbar=no,location=no,menubar=no,scrollbars=no');"/></td>
                </tr>
            </table>  
        </form:form>
    </body>
</html>