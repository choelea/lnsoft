<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">		
		function back(){
			window.location.href="./pddd.do?method=valiList&page=1";
		}
		function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  
  <body>
  	<html:form action="/pddd.do?method=updObject" method="post" onsubmit="return false;">
  	<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" id="printTabId" style="word-break:break-all;">
    		<caption><center>库房产品盘点表</center></caption>
    		<tr>
    			<td align="right" width="25%">盘点编号&nbsp;&nbsp;</td>
    			<td><html:text property="vo.pdbh" styleClass="input" readonly="true"/></td>    			
    			<td align="right" width="20%">盘点日期&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.pdzt"/>
    				<html:hidden property="vo.pdzj"/>    				
    			</td>
    			<td >
    				<html:text property="vo.pdrq" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">盘点库房&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sykfmc" readonly="true" styleClass="input"/>
    				<html:hidden property="vo.sykfzj"/>
    			</td>
    			<td align="right">盘点类型&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.pdlx" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    					<tr align="center">
    						<td>产品编号</td>
    						<td>产品名称</td>
    						<td>期初库存</td>
    						<td>入 库</td>
    						<td>出 库</td>
    						<td>期末库存</td>
    						<td>盘 盈</td>
    						<td>盘 亏</td>
    						<td>批 号</td>
    					</tr>
    					<logic:iterate id="obj" name="list">
    						<tr align="center">
    						<td>${obj.hpbm }</td>
    						<td>${obj.hpmc }</td>
    						<td>${obj.qckc }</td>
    						<td>${obj.rksl }</td>
    						<td>${obj.cksl }</td>
    						<td>${obj.qmkc }</td>
    						<td>${obj.pysl }</td>
    						<td>${obj.pksl }</td>
    						<td>${obj.ph }</td>
    					</tr>
    					</logic:iterate>
    				</table>
    			</td>
    		</tr>
    	</table>
    	</div>
    	<p align="center">
    		<input type="button" value="打 印" class="inputbutton" onclick="toChild();"/>
    		<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    	</p>
  	</html:form>
  </body>
</html>
