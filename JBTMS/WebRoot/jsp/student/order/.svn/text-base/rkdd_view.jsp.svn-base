<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
   	function back(){
   		if(${backPath!=null}){
   			window.location.href="<%=request.getContextPath()%>/crkdd.do?method=objList&page=1";
   		}else
   			window.location.href="<%=request.getContextPath()%>/crkdd.do?method=getList&page=1&orderKind=${orderKind}";
   	}
   	 function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  <body>
  	<html:form action="/crkdd.do?method=updateObject" method="post">
  	<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>入库订单</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    				<html:hidden property="vo.crkzj"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="hidden" name="orderKind" value="${orderKind }">
    			</td>
    			<td align="right" width="20%">客户合同&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><input type="text" name="khht" class="input" readonly="readonly" value="${htmc }"/>
    			<input type="hidden" name="htzj" value="${htzj }">
    			</td>
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
    				<html:text property="vo.ddlx" styleClass="input" value="入库" readonly="true"/>
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
    			<td colspan="3">
    				<c:if test="${ddzt eq 0 }">
					<c:set var="zt" value="录入" ></c:set>
				</c:if>
				<c:if test="${ddzt eq 1 }">
					<c:set var="zt" value="作业计划" ></c:set>
				</c:if>
				<c:if test="${ddzt eq 2 }">
					<c:set var="zt" value="调度" ></c:set>
				</c:if>
				<c:if test="${ddzt eq 3 }">
					<c:set var="zt" value="接受" ></c:set>
				</c:if>
				<c:if test="${ddzt eq 4 }">
					<c:set var="zt" value="质检" ></c:set>
				</c:if>
				<c:if test="${ddzt > 4 }">
					<c:set var="zt" value="入库" ></c:set>
				</c:if>
    				<input type="text" value="${zt }" class="input" readonly="readonly"/>
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
    			<td align="right">入库类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常入库">正常入库</html:radio>
    				<html:radio property="vo.crklx" value="调拨入库">调拨入库</html:radio>
    				<html:radio property="vo.crklx" value="退货入库">退货入库</html:radio>
    			</td>
    		</tr> 	
    		<tr>    			
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
    		</tr>   
    		 		
    		<tr>
    			<td align="right">备　　注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="50" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品选择</td>
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
    	</table>
    	</div>
			<p align="center">
	    		<input type="button" value="打 印" class="inputbutton" onclick="toChild();"/>
	    		<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
	    	</p>
  	</html:form>
  </body>
</html>
