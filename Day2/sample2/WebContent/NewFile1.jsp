<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>NewFile1.jsp</h3>

<%
// Java 영역
String name = request.getParameter("name");

%>

이름:<%=name %>
<br><br>

<%
String eng = request.getParameter("eng");
%>

영어가능:<%=eng %>
<br><br>

<%-- <%
String german = request.getParameter("other");
%> --%>

<%
String other[] = request.getParameterValues("other");

if(other != null){
for(int i =0; i< other.length; i++){
	%>
	제2외국어:<%=other[i] %><br>
	<%
    }
}
%>
<br><br>

<%
String age = request.getParameter("age");
int agenum = Integer.parseInt(age);
%>

연령대:<%=agenum %>대

</body>
</html>