<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--% response.addHeader("Refresh","5"); %-->
<c:url var="resource" value="/resources/theme1/css/core.css" scope="request" />

<html>
<head>
<link href="${resource}" rel="stylesheet">
</head>
<body>
    <abb_h1>ABB Java Development Training</abb_h1><br>
    <abb_h2>Ant-Ivy-SpringMVC Training</abb_h2><br>
    <form:form method="GET" action="/ABBJavaDev-SpringMVC/finalPage">
         <table>
             <tr>
                 <td><abb_p1>Your input message:</abb_p1></td><br>&nbsp;
             </tr>
             <tr>
                 <td style="color:red"><abb_p2>${input_message}</abb_p2><br></td>
             </tr>
             <tr>
                 <td>&nbsp;</td>
             </tr>
             <tr>
                 <td><input type="submit" value="Final Page"/></td>
            </tr>
        </table>  
    </form:form>
    <form:form method="POST" action="/ABBJavaDev-SpringMVC/login" modelAttribute="credential">
        <table>
            <tr>
                <td width=80>Username</td>
                <td><form:input id="username" name="username" path="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password id="password" name="password" path="password" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td style="color:red"><i>${error_message}</i></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" /></td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </form:form>
</body>
</html>
