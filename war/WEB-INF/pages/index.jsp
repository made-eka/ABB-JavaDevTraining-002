<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<% response.addHeader("Refresh","5"); %>
<c:url var="resources" value="/resources/theme1" scope="request" />

<html>
<head>
<link href="${resources}/css/core.css" rel="stylesheet">
</head>
<body>
	<abb_h1>ABB Java Development Training</abb_h1><br>
	<abb_h2>Ant-Ivy-SpringMVC Training</abb_h2><br>
	
	<table>
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
	</table>
</body>
</html>
