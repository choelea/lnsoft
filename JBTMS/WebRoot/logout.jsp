<%@ page language="java"  pageEncoding="GB2312"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
  </head>
  <body>  
  <%
   session.invalidate();
   response.sendRedirect("index.jsp");
   %>
  </body>

</html>

