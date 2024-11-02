<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

  <p>お名前を入力してください。</p>
  <form action="greeting-out" method="post">
    <input type="text" name="user" placeholder="お名前">
    <input type="submit" value="確定">  
  </form>

<%@include file="../footer.html" %>