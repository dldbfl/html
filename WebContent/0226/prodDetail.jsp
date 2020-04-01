
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	ProdVO vo = (ProdVO)request.getAttribute("prodVo");


%>
		{
		"gu" : "<%= vo.getProd_id() %>",
		"nm" : "<%= vo.getProd_name() %>",
		"lgu" : "<%= vo.getProd_lgu() %>",
		"price" : "<%= vo.getProd_price() %>",
		"color" : "<%= vo.getProd_color() %>",
		"cost" : "<%= vo.getProd_cost() %>",
		"detail" : "<%= vo.getProd_detail() %>",
		"outline" : "<%= vo.getProd_outline() %>",
		"properstock" : "<%= vo.getProd_properstock() %>",
		"qtyin" : "<%= vo.getProd_qtyin() %>",
		"qtysale" : "<%= vo.getProd_qtysale() %>",
		"sale" : "<%= vo.getProd_sale() %>",
		"size" : "<%= vo.getProd_size() %>",
		"totalstock" : "<%= vo.getProd_totalstock() %>",
		"unit" : "<%= vo.getProd_unit() %>"				
		}


