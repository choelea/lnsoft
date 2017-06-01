<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
		function back(){
			window.location.href="<%=request.getContextPath()%>/cwtj.do?method=ysCbCwtj&kind=${kind}&ny=${ny}"
		}
		function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  
  <body>
  	<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>财务报表</center></caption>
    		<tr>
    			<td align="right" width="25%">统计人&nbsp;&nbsp;</td>
    			<td >${userTName }</td>
    			<td align="right">统计年月&nbsp;&nbsp;</td>
    			<td>
    				${ny }
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
    						<td align="center">员工工资</td>
    						<td>${vo.yfk }<td>
    					</tr>
    					<tr align="center">
    						<td>3</td>
    						<td align="center">车辆维修费</td>
    						<td>${vo.bf }</td>
    					</tr>
    					<tr align="center">
    						<td></td>
    						<td align="center">总 计</td>
    						<td>${vo.yfk+vo.bf}</td>
    					</tr>
    				</table>
    				</td>
    		</tr>
    	</table>
    	</div>
    	<p align="center">
    		<input type="button" value="打 印" class="inputbutton" onclick="toChild();"/>
    		<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    	</p>
  </body>
</html>
