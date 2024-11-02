<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%
  Double random = Math.random();
  pageContext.setAttribute("random", random);
%>
<p>
  ${random}<br>
  ${random < 0.5 ? "あたり" : "はずれ"}
</p>

<%@include file="../footer.html" %>