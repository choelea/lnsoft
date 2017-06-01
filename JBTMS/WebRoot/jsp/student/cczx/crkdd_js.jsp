<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/cczx.do?method=getJsList";
    	}
   
    </script> 
  </head>
  <body>
  	<html:form action="/cczx.do?method=jsObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>${orderKind eq '入库'?'入库订单':'出库订单' }</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			<c:if test="${orderKind eq '入库' }">
    			<td align="right" width="20%">客户合同&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><input type="text" name="khht" class="input" readonly="readonly" value="${htmc }"/>
    			<input type="hidden" name="htzj" value="${htzj }">
    			</td>
    			</c:if>
    			<c:if test="${orderKind eq '出库' }">
    			<td align="right" width="20%">入库订单&nbsp;&nbsp;&nbsp;&nbsp;
    			<td><input type="text" name="rkddbh" class="input" value="${crkddbh }" readonly="readonly"/>
    			</td>
    			</c:if>
    		</tr>
    		<tr>
    			<td align="right">客户指令号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.khzlh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">下达时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.xdsj" styleClass="input" readonly="true"/>
    			</td>    
    		</tr>    
    		<tr>
    			<td align="right">订单类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.ddlx" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">紧急程度&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:select property="vo.jjcd" style="width:100pt">
    					<html:option value="">选择紧急程度</html:option>
    					<html:option value="一般">一般</html:option>
    					<html:option value="紧急">紧急</html:option>
    					<html:option value="特急">特急</html:option>
    				</html:select>
    			</td>		
    		</tr>
    		<tr>
    			<td align="right">执行状态&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td colspan="3"><input type="text" value="调度" class="input" readonly="readonly"/>
    				<html:hidden property="vo.ddzt" styleClass="input" value="0"/>
    			</td>
    		</tr> 	
    		<tr>
    			<td align="right">库房信息&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.kfmc" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.sykfzj" styleClass="input"/>
    			</td>
    			<c:if test="${orderKind eq '入库' }">
    			<td align="right">入库类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常入库">正常入库</html:radio>
    				<html:radio property="vo.crklx" value="调拨入库">调拨入库</html:radio>
    				<html:radio property="vo.crklx" value="退货入库">退货入库</html:radio>
    			</td>
    			</c:if>
    			<c:if test="${orderKind eq '出库' }">
    			<td align="right">出库类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常出库">正常出库</html:radio>
    				<html:radio property="vo.crklx" value="调拨出库">调拨出库</html:radio>
    				<html:radio property="vo.crklx" value="退货出库">退货出库</html:radio>
    			</td>
    			</c:if>
    		</tr> 	
    		<tr> 
    			<c:if test="${orderKind eq '入库' }">
    			<td align="right">
    			入库方式&nbsp;&nbsp;&nbsp;&nbsp;
    			<td>
    				<html:text property="vo.crkfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">预计入库时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.yjcrksj" styleClass="input" readonly="true"  />
    			</td>
    			</c:if>		
    			<c:if test="${orderKind eq '出库' }">
    			<td align="right">
    			出库方式&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.crkfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">预计出库时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.yjcrksj" styleClass="input" readonly="true"/>
    			</td>
    			</c:if>
    		</tr>   
    		 		
    		<tr>
    			<td align="right">备　　注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="50" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品信息</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
	    				<tr align="center">
	    					<td>货品编号</td>
	    					<td>货品名称</td>
	    					<td>货品单位</td>
	    					<td>货品类型</td>
	    					<td>货品型号</td>
	    					<td>货品数量</td>
	    					<td></td>
	    				</tr>
	    			<tbody id="tbody">
	    			<c:forEach var="obj" items="${list }">
							<tr align="center">
		    					<td>${obj.hpbm }</td>
		    					<td>${obj.hpmc }</td>
		    					<td>${obj.hpdw }</td>
		    					<td>${obj.hplx }</td>
		    					<td>${obj.hpxh }</td>
		    					<td>${obj.hpsl }</td>
		    				</tr>
						</c:forEach>	
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.crkzj"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="submit" name="tijiao" class="inputbutton" value="接受">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="orderKind" value="${orderKind }">
    			</td>
    		</tr>
    	</table>
  	</html:form>
  </body>
</html>
