<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.html" %>
<table border="1" style="border-color: lime;">
  <tr>
    <th>商品番号</th>
    <th>商品名</th>
    <th>価格</th>
  </tr>
  <c:forEach var="product" items="${list}">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
    </tr>
  </c:forEach>
</table>

<%@include file="../footer.html"%>