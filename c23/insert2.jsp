<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <p>追加する商品を入力してください。</p>
  <form action="Insert2.action" method="post">
    商品名<input type="text" name="name"> 
    価格<input type="text" name="price">
    <p><input type="checkbox" name="food" value="1">づくし追加</p>
    <p><input type="submit" value="追加"></p>
  </form>

<%@include file="../footer.html" %>