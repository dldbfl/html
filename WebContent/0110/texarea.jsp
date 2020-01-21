<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="../css/mystyle.css?after">
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String text = request.getParameter("area");
		
	 	text = text.replaceAll("\r\n","<br>");
%>

<h1>처리결과</h1>
<pre>
textarea에 입력한 내용 중에는 enter 기호('\r\n')가 삽입되어있다.
enter기호를 줄바꿈 태그&lt;br&gt;로 변환, replaceAll해서 출력한다.
</pre>
<div>
	이름 : <%= name %><br>
	<br>
	입력한 내용<br>
	<div>
	<%= text %>
	</div>
</div>


</body>
</html>