<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>

<%
  int[] array = {0, 1, 2};
  pageContext.setAttribute("array", array);
  
  List<String> list = new ArrayList<>();
  list.add("zero");
  list.add("one");
  list.add("two");
  pageContext.setAttribute("list", list);
  
  Map<String, String> map = new HashMap<>();
  map.put("zero", "零");
  map.put("one", "壱");
  map.put("two", "弐");
  pageContext.setAttribute("map", map);
%>

${array[1]}<br>
${list[2]}<br>
${map["one"]}<br>
${map.two}

<%@include file="../footer.html" %>