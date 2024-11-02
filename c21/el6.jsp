<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../header.html" %>

${param.user }
${param.user.length() }
${param.user.toUpperCase() }

<p>${param.user } ${param.user.length() } ${param.user.toUpperCase() }

<%@include file="../footer.html" %>