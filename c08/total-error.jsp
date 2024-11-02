<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<%@page isErrorPage = "ture" %>

<% try {
			request.setCharacterEncoding("UTF-8");
			int price = Integer.parseInt(request.getParameter("price"));
			int count = Integer.parseInt(request.getParameter("count"));
%>			



  <%-- <p>数値を入力してください</p>--%>

  <%-- <p><%= exception %></p>--%>
<% } catch (NumberFormatException e){
			out.println("数値を入力してください");
		}
%>
<%@include file="../footer.html" %>