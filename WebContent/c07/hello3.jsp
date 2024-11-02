<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

  <%-- メッセージの出力 --%>
  <p>Hello!</p>
  <p>こんにちは！</p>
  
  <p><% out.println(new java.util.Date()); %></p>

<%@include file="../footer.html" %>