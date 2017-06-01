<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khdd.do?method=getList&page=1";
    	}
    	function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  
  <body >
  	<html:form action="/khdd.do?method=getList" method="post">
  		<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户订单信息</center></caption>
    		<tr>
    			<td align="right" width="25%">订单编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="vo.ddbh" styleClass="input" readonly="true"/></td>
    			<td align="right" width="20%">订单日期&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    				<html:hidden property="vo.ddzt" />
    				<html:hidden property="vo.ddzj"/>
    			</td>
    			<td >
    				<html:text property="vo.ddrq" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委 托 方&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="dhf.dwmc" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">收 货 方&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="shf.dwmc" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委托方联系人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="dhf.lxr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">收货方联系人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="shf.lxr" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委托方电话&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="dhf.lxrdh" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">收货方电话&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="shf.lxrdh" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>    			
    			
    			<td align="right">取货日期&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.qhrq" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">填 单 人&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.zdr" styleClass="input" readonly="true" />
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品信息
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tbody>
	    				<tr align="center">
	    					<td>货品编号</td>
	    					<td>货品名称</td>
	    					<td>货品单位</td>
	    					<td>货品类型</td>
	    					<td>货品型号</td>
	    					<td>货品数量</td>
	    					<td></td>
	    				</tr>
						<c:forEach var="obj" items="${list }">
							<tr align="center">
								<td>
									<input type='hidden' name='khhpzj'
										value="${obj.ddhpzj }">
									<input type='text' name='hpbm' value="${obj.hpbm }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpmc' value="${obj.hpmc }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpdw' value="${obj.hpdw }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hplx' value="${obj.hplx }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpxh' value="${obj.hpxh }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpsl' class='inputsmall2'
										value="${obj.hpsl }" readonly="readonly">
								</td>
							</tr>
						</c:forEach>
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
