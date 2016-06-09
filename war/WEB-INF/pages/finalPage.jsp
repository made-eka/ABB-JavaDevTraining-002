<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% response.addHeader("Refresh","5"); %>
<c:url var="resources" value="/resources/theme1" scope="request" />

<html>
    <head>
        <link href="${resources}/css/core.css" rel="stylesheet">
    </head>
    <body>
        <abb_h1>The Final Page</abb_h1><br>
        <abb_h2>${input_message}</abb_h2>
        
        <form:form method="GET" action="/ABBJavaDev-SpringMVC/backToIndex">
            <table>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Back"/></td>
                </tr>
            </table>  
        </form:form>
    </body>
</html>