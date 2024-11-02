<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

  <%@page import="bean.Product" %>
  
  <% Product product = (Product) request.getAttribute("product"); %>
  
  <%=product.getId() %>:<%=product.getName() %>:<%=product.getPrice() %><br>

<%@include file="../footer.html" %>