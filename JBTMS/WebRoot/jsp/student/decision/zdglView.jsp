<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
		function back(){
			window.location.href="./zdgl.do?method=objList&page=1";
		}
    </script> 
  </head>
  
  <body>
  	<html:form action="/zdgl.do?method=exportObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>账单管理</center></caption>
    		<tr>
    			<td align="right" width="25%">账单编号&nbsp;&nbsp;</td>
    			<td ><html:text property="vo.zzdbh" styleClass="input" readonly="true"/></td>
    			<td align="right">做账日期&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdrq" readonly="true" styleClass="input"/>
    			</td>	
    		</tr>
    		<tr>
    			<td align="right" width="20%">合 同 号&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.sfhx"/>
    				<html:hidden property="vo.ssjg"/>
    				<html:hidden property="vo.zzdzj"/>
    			</td>
    			<td >
    				<html:text property="vo.syhth" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.bz"/>
    			</td>
    			<td align="right">结算方式&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.jsfs" readonly="true" styleClass="input"/>    				
    				
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">客户姓名&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.khqm" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">付款帐号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.fkzh" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4">
    				<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    					<tr align="center">
    						<td align="center" width="30%">序 号</td>
    						<td>费用名称</td>
    						<td>金 额</td>
    					</tr>
    					<tr align="center">
    						<td>1</td>
    						<td align="center" width="30%">预 付 款</td>
    						<td align="center"><html:text property="vo.yfk" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>2</td>
    						<td align="center">运 费</td>
    						<td><html:text property="vo.yf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>3</td>
    						<td align="center">杂 费</td>
    						<td><html:text property="vo.zf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>4</td>
    						<td align="center">保 费</td>
    						<td><html:text property="vo.bf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td></td>
    						<td align="center">总 计</td>
    						<td><html:text property="vo.zje" styleClass="input" readonly="true"/></td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit value="导出账单" styleClass="inputbutton"></html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
  	</html:form>
  </body>
</html>
