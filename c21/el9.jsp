<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<!-- スクリプトレットと式を使用した場合 -->
<p>スクリプトレットと式を使用した場合</p>
<%
double value = (double) Math.random();
%>

<%=value %><br/>
<%=(value < 0.5 ? "あたり" : "はずれ")%>

<!-- ELを使用した場合 -->
<p>ELを使用した場合</p>
<% pageContext.setAttribute("random", Math.random()); %>
${random}<br/>
${random<0.5 ? "あたり" : "はずれ"}

<%@include file="../footer.html" %>