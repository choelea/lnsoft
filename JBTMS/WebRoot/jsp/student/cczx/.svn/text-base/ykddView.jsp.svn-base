<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <link rel="stylesheet" type="text/css" href="./css/newdate.css" />
    <script type="text/javascript">    	
		function back(){
			window.location.href="./ykdd.do?method=valiList&page=1";
		}
		function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
  	<html:form action="/ykdd.do?method=addObject" method="post" onsubmit="return false;">
  		<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>移库订单</center></caption>
    		<tr>
    			<td align="right" width="25%">移库编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="vo.ykbh" styleClass="input" readonly="true"/></td>
    			<td align="right" width="20%">计划日期
    				<html:hidden property="vo.ykzj"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.ykzt"/>
    				<input type="hidden" name="ykfssjg" id="ykfssjg"/>
    				<input type="hidden" name="ykflx" id="ykflx"/>
    			</td>
    			<td >
    				<html:text property="vo.ddrq" styleClass="input" readonly="true" />
    			</td>
    		</tr>
    		<tr>
    			<td align="right">源 库 房</td>
    			<td>
    				<html:text property="vo.ckkfmc" readonly="true" styleClass="input"/>
    				<html:hidden property="vo.ckkfzj"/>
    			</td>
    			<td align="right">目标库房</td>
    			<td>
    				<html:text property="vo.rkkfmc" readonly="true" styleClass="input"/>
    				<html:hidden property="vo.rkkfzj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">操 作 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ckczr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">操 作 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.rkczr" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">填 单 人&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.tdr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">填单日期&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.tdsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备　　注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">移库明细
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tbody id="mxId">
	    				<tr align="center">
	    					<td>明细编号</td>
	    					<td>源区位</td>
	    					<td>源储位</td>
	    					<td>目标区位</td>
	    					<td>目标储位</td>
	    					<td>移库数量(合格)</td>
	    					<td>移库数量(损毁)</td>
	    				</tr>
	    				<logic:iterate id="ykmx" name="list" indexId="i">
	    					<tr align="center" id="${i }">
		    					<td>${i+1 }</td>
		    					<td><input type='text' name='list[${i }].yqw.qwmc' readonly='readonly' class='inputsmall2' value='${ykmx.cwxxByCwzj.qwxx.qwmc }' style='cursor:hand;' >
		    					<input type='hidden' name='list[${i }].yqw.qwzj' value="${ykmx.cwxxByCwzj.qwxx.qwzj }">
		    					<input type='hidden' name='list[${i }].yqw.cclx' value="${ykmx.cwxxByCwzj.qwxx.cclx }">		    					
		    					</td>
		    					<td>
		    					<input type='text' name='list[${i }].ycw.cwbh' readonly='readonly' class='inputsmall2' value='${ykmx.cwxxByCwzj.cwbh }' style='cursor:hand;' >
		    					<input type='hidden' name='list[${i }].ycw.cwzj' value="${ykmx.cwxxByCwzj.cwzj }">
		    					<input type='hidden' name='list[${i }].ycw.cwsx' value="${ykmx.cwxxByCwzj.cwsx }">
		    					<input type='hidden' name='list[${i }].ycw.hpbm' value="${ykmx.cwxxByCwzj.hpbm }">
		    					<input type='hidden' name='list[${i }].ycw.hgsl' value="${ykmx.cwxxByCwzj.hgsl }">
		    					<input type='hidden' name='list[${i }].ycw.shsl' value="${ykmx.cwxxByCwzj.shsl }">
		    					</td>
		    					<td><input type='text' name='list[${i }].mbqw.qwmc' readonly='readonly' class='inputsmall2' style='cursor:hand;' value="${ykmx.cwxxByCwxCwzj.qwxx.qwmc }" >
		    					<input type='hidden' name='list[${i }].mbqw.qwzj' value="${ykmx.cwxxByCwxCwzj.qwxx.qwzj }">
		    					<input type='hidden' name='list[${i }].mbqw.cclx' value="${ykmx.cwxxByCwxCwzj.qwxx.cclx }">
		    					</td>
		    					<td><input type='text' name='list[${i }].mbcw.cwbh' readonly='readonly' class='inputsmall2' style='cursor:hand;' value="${ykmx.cwxxByCwxCwzj.cwbh }">
		    					<input type='hidden' name='list[${i }].mbcw.cwzj' value="${ykmx.cwxxByCwxCwzj.cwzj }">
		    					<input type='hidden' name='list[${i }].mbcw.cwsx' value="${ykmx.cwxxByCwxCwzj.cwsx }">
		    					<input type='hidden' name='list[${i }].mbcw.hpbm' value="${ykmx.cwxxByCwxCwzj.hpbm }">
		    					<input type='hidden' name='list[${i }].mbcw.hgsl' value="${ykmx.cwxxByCwxCwzj.hgsl }">
		    					<input type='hidden' name='list[${i }].mbcw.shsl' value="${ykmx.cwxxByCwxCwzj.shsl }">
		    					</td>
		    					<td><input type='text' name='list[${i }].ykhpsl' class='inputsmall2' value="${ykmx.ykhpsl }" style='cursor:hand;' readonly='readonly' ></td>
		    					<td><input type='text' name='list[${i }].ykshsl' class='inputsmall2' value="${ykmx.ykshsl }" style='cursor:hand;' readonly='readonly'></td>
		    					
		    				</tr>
	    				</logic:iterate>
    				</tbody>
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
