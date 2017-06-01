<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>  
    <link href="${url}/css/admin.css" rel="stylesheet" type="text/css"> 
  </head>
  
  <body>
    <html:form  action="/student.do?method=importStu&bjzj=${bjzj}" method="post" enctype="multipart/form-data">
    	<table border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;" width="100%">
    		<tr>
    			<td align="right" width="35%">选择文件：</td>
    			<td width="5%"></td>
    			<td><html:file property="file"/></td>
    		</tr>
    		<tr>
    			<td colspan="3" align="center">
    				<input type="submit" class="inputbutton" value="提 交"/>&nbsp;&nbsp;
    				<input type="button" class="inputbutton" value="返 回" onclick="window.location.href='<%=request.getContextPath() %>/student.do?method=getList&bjzj=${bjzj}'"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
