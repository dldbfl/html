
<%@page import="kr.or.ddit.ibatis.vo.MemberVO" %>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory" %>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%
//클라이언트 요청시 전달되는 값을 받는다- 없다
//처리(CRUD)한다
//1. SqlMapClient객체 얻어오기
SqlMapClient client =SqlMapClientFactory.getSMClient();

//2. mapper파일의 namespace이름과 id이름을 이용하여
//sql문 실행
List<MemberVO> list = client.queryForList("member.listAll");
//3. list에서 한줄씩 꺼내어 json object배열을 만든다.
for(int i = 0; i < list.size(); i++){
	MemberVO vo = list.get(i);
	if(i>0) out.print(",");
%>
		{
		"name" : "<%= vo.getMem_name() %>",
		"tel" : "<%= vo.getMem_hp() %>",
		"addr" : "<%= vo.getMem_add1() %> <%= vo.getMem_add2() %>",
		"id" : "<%= vo.getMem_id() %>",
		"mail"  : "<%= vo.getMem_mail() %>" 
		}
<%
     }
%>
]