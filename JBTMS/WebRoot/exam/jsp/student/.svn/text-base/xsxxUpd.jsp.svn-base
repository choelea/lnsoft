<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	function IsNull(){
    		var xsxh = document.all("vo.xsxh");
    		var xsxx = document.all("vo.xsxm");
    		var xsmm = document.all("vo.xsmm");
    		var exp = /^\w+$/;
    		var expNum = /^\d+$/;
    		if(!exp.test(xsxh.value)){
    			alert("学号前缀由字母和数字组成!");
    			return false;
    		}
    		if(xsxx.value==""){
    			alert("请输入学生姓名!");
    			return false;
    		}
    		if(!exp.test(xsmm.value)){
    			alert("密码由字母和数字组成!");
    			return false;
    		}
    		return true;
    	}
    	
    </script> 
  </head>
  
  <body>
    <html:form action="/xsxx.do?m=updMsg" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>个人资料</center></caption>
    		<tr>
    			<td width="40%" align="right">学生学号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.xsxh" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.xszj"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="bjxx.bjzj" />
    			</td>
    		</tr>
    		<tr>
    			<td align="right">学生姓名&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.xsxm" styleClass="input"/>
    			</td>
    		</tr> 
    		<tr>
    			<td align="right">登陆密码&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.xsmm" styleClass="input"/>
    			<html:hidden property="vo.yxbj"/>
    			</td>
    		</tr> 
    		<tr>
    			<td align="right">学生备注&nbsp;&nbsp;</td>
    			<td>
    			<html:textarea property="vo.bzxx" cols="30" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<html:reset styleClass="inputbutton">重 置</html:reset>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
