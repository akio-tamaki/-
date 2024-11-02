<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%@page errorPage = "total-error.jsp" %>

<% request.setCharacterEncoding("UTF-8");
  int prmPrice = Integer.parseInt(request.getParameter("price"));
  int prmCount = Integer.parseInt(request.getParameter("count")); 
  int prmDelivery = Integer.parseInt(request.getParameter("delivery")); 
%>

<%= prmPrice %>円×<%= prmCount %>個＋送料<%= prmDelivery %>円＝
<%= prmPrice * prmCount + prmDelivery %>円

<%@include file="../footer.html" %>