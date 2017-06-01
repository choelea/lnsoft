<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/ggxx.do?method=getList&page=1";
    	}  
    	
    </script> 
  </head>
  
  <body>
    <html:form action="/ggxx.do?method=viewObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>公告管理</center></caption>
    		<tr>
    			<td width="40%" align="right">公告标题&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="ggbt" styleClass="input" readonly="true"/>
    				<html:hidden property="ggzj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">班级名称&nbsp;&nbsp;</td>
    			<td><html:text property="bjxx.bjmc" styleClass="input" readonly="true"/>
    				<html:hidden property="bjxx.bjzj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">发 布 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="ggzz" styleClass="input" readonly="true"/>
    			</td>
    		</tr>   
    		<tr>
    			<td align="right">发布时间&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="fbsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 		
    		<tr>
    			<td align="right">公告内容&nbsp;&nbsp;</td>
    			<td>
    				<html:textarea property="ggnr" cols="50" rows="8" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
