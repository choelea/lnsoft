<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title>error.jsp</title>
    <c:if test="${msg!=null}">
    <script type="text/javascript">		
		alert('${msg}');
	</script>    	
    </c:if>
    <script type="text/javascript">
		window.parent.location.href="<%=request.getContextPath() %>/index.jsp";
	</script>
  </head>
  
  <body>
  <%session.invalidate();%>
  </body>
</html>
