<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function back(){
    		window.location.href="./bmxx.do?method=objList"
    	}
    </script>    
  </head>
  
  <body>
    <html:form action="/bmxx.do?method=viewObject" method="post" onsubmit="return false;">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>部门管理</center></caption>
    		<tr >
    			<td width="40%"  align="right" >部门编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.bmbh" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.bmzj"/>
    				<input type="hidden" name="show-btn">
    			</td>
    		</tr>
    		<tr>
    			<td align="right">部门名称&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.bmmc" styleClass="input" readonly="true"/>    				
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >联系电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.bmdh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >所属机构&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
					<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >备 注&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:textarea property="vo.bzxx" cols="40" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2" >
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>    				
    			</td>
    		</tr>
    	</table>
	</html:form>
  </body>
</html>
