<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% for (int i = 1; i<10; i++) { %>
  <%=i %>×<%=i %>＝<%=i * i %><br>
<% } %>

<%@ include file="../footer.html" %>
