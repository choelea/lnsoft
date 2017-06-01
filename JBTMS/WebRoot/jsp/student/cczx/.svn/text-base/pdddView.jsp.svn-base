<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">		
		function back(){
			window.location.href="./pddd.do?method=valiList&page=1";
		}
    </script> 
  </head>
  
  <body>
  	<html:form action="/pddd.do?method=updObject" method="post" onsubmit="return false;">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>盘点订单</center></caption>
    		<tr>
    			<td align="right" width="25%">盘点编号&nbsp;&nbsp;</td>
    			<td colspan="3"><html:text property="vo.pdbh" styleClass="input" readonly="true"/></td>    			
    		</tr>
    		<tr>
    			<td align="right" width="20%">计划日期&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.pdzt"/>
    				<html:hidden property="vo.pdzj"/>
    				<input type="hidden" id="show-btn"/>
    			</td>
    			<td >
    				<html:text property="vo.pdrq" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">盘点库房&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sykfmc" readonly="true" styleClass="input"/>
    				<html:hidden property="vo.sykfzj"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">盘 点 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.pdr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">盘点类型&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.pdlx" style="width:100pt" disabled="disabled">
    					<html:option value="日盘点">日盘点</html:option>
    					<html:option value="月盘点">月盘点</html:option>
    					<html:option value="年盘点">年盘点</html:option>
    				</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
  	</html:form>
  </body>
</html>
