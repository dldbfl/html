<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	h1{
		color: aqua
	}
	h2{
		color: blueviolet;
	}
	span{
		color: pink;
	}
</style>
</head>
<body>
	<h1>JSP : JAVA Server Page</h1>
	<h2>클라이언트의 전송(요청)시 전송되는 데이터 값을 받는다.</h2>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
%>

<%= name %> 님 환영합니다.<br>
<%= id %>님의 정보를 소중히 저장하겠습니다.<br>
<span>즐거운 하루되세요,</span>
</body>
</html>