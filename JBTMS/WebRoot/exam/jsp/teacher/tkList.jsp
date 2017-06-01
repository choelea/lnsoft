<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>    
    <title><bean:message key="system.title"/></title>
    <link href="./css/admin.css" rel="stylesheet" type="text/css"> 
    <script type="text/javascript" src="./js/pub.js"></script>
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
    <html:form action="/stglExam.do?m=query" method="post">  	
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th width="10%">全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>题库名称</th>
	    		<th>题库类型</th>
	    		<th>试题管理</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="list">
    	<logic:iterate id="obj" name="list">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.tkzj }"/></td>
		   		<td>
		   		${obj.tkmc }
		   		</td>
		   		<td>${obj.tklx }</td>
		   		<td>
		   		<a href="./stglExam.do?m=objList&tkgl.tkzj=${obj.tkzj}&rmMsg=true">试题管理</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="list">
    		<tr>
    		<td colspan="7" align="center">
    			暂无题库信息!
    		</td>
    	</tr>
    	</logic:empty>
    </table>
    </html:form>
  </body>
</html>
