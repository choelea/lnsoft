<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>    
    <title>打 印</title>
    <script type="text/javascript"> 
    	function back(){
			window.location.href="./cwtj.do?method=ccCbCwtj";
		}
		function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script>
  </head>
  
  <body >  	
  	<div id="printId">
    <table width="100%" cellpadding="0" cellspacing="1" border="0">
    	<caption>财务报表</caption>
    	<tr>
    		<td align="right" width="25%">统计人&nbsp;&nbsp;</td>
    		<td width="25%">${userTName }</td>
    		<td align="right" width="20%">统计时间&nbsp;&nbsp;</td>
    		<td>${tjsj}</td>
    	</tr>
    	<tr>
    		<td colspan="4">
	    		<table width="100%" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
	    			<tr >
			    		<td align="center">序 号</td>
			    		<td align="center">项目名称</td>
			    		<td align="center">费 用</td>
			    	</tr>
			    	<tr align="center">
			    		<td>1</td>
			    		<td >设备维修费</td>
			    		<td>${vo.bf }</td>
			    	</tr>
			    	<tr align="center">
			    		<td>2</td>
			    		<td >员工工资</td>
			    		<td>${vo.ccyqfy }</td>
			    	</tr>
			    	<tr align="center">
			    		<td colspan="2">成本总计</td>
			    		<td>${vo.ccyqfy+vo.bf}</td>
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
