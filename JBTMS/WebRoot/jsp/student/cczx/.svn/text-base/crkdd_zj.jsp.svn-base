<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function isNull(){
			var hgsl = document.getElementsByName("hgsl");
			for(var i=0; i<hgsl.length; i++){
				if(hgsl[i].value==""){
					alert("请输入合格数量！");
					return false;
				}
			}
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/cczx.do?method=getZjList&page=1";
    	}
    	//入库质检
   		function zjjs(temp){
   			var numVail = /^[0-9]+$|[0-9]+\.[0-9]+$/;
   			if(temp.value!=""){
   				if(!numVail.test(temp.value)){
   					alert("请输入正确的合格数量！");
   					temp.value="";
   					return false;
   				}
   				var zsl = temp.parentElement.previousSibling.innerText;
	   			if(parseFloat(temp.value)>parseFloat(zsl)){
	   				alert("合格数量不能大于总数量！");
	   				temp.value="";
	   				return false;
	   			}
	   			temp.parentElement.nextSibling.innerHTML = zsl-temp.value;
   			}
   		}
   		//出库质检
   		function ckzjjs(temp){
   			var numVail = /^[0-9]+$|[0-9]+\.[0-9]+$/;
   			if(temp.value!=""){
   				var yhgsl = temp.previousSibling;
   				if(yhgsl){
   					if(parseFloat(temp.value)>parseFloat(yhgsl.getAttribute("value"))){
   						alert("输入的合格数量不能大于原来的合格数量！");
   						temp.value=yhgsl.getAttribute("value");
   						return false;
   					}
   				}
   				if(!numVail.test(temp.value)){
   					alert("请输入正确的合格数量！");
   					temp.value="";
   					return false;
   				}
   				var zsl = temp.parentElement.previousSibling.innerText;
	   			if(parseFloat(temp.value)>parseFloat(zsl)){
	   				alert("合格数量不能大于总数量！");
	   				temp.value="";
	   				return false;
	   			}
	   			temp.parentElement.nextSibling.innerHTML = zsl-temp.value;
   			}
   		}
    </script> 
  </head>
  <body>
  	<html:form action="/cczx.do?method=zjObject" method="post" onsubmit="return isNull()">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>${orderKind eq '入库'?'入库订单':'出库订单' }</center></caption>
    		<tr>
    			<td align="right" width="20%">质检编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.zjbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			
    		</tr>
    		<tr>
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
    			<td align="right">客户指令号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.khzlh" styleClass="input" readonly="true"/>
    			</td>
    			   
    		</tr>    
    		<tr>
    			<td align="right">下达时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.xdsj" styleClass="input" readonly="true"/>
    			</td> 
    			<td align="right">订单类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.ddlx" styleClass="input" readonly="true"/>
    			</td>
    				
    		</tr>
    		<tr>
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
    			<td align="right">执行状态&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td ><input type="text" value="调度" class="input" readonly="readonly"/>
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
    			<td align="center" colspan="4">货品信息</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
	    				<tr align="center">
	    					<td>货品编号</td>
	    					<td>货品名称</td>
	    					<td>货品单位</td>
	    					<td>货品类型</td>
	    					<td>货品型号</td>
	    					<td>货品数量</td>
	    					<td>合格数量 <font color="red" >*</font> </td>
	    					<td>损毁数量</td>
	    					<td></td>
	    				</tr>
	    			<tbody id="tbody">
	    			<c:forEach var="obj" items="${list }">
							<tr align="center">
								<c:if test="${orderKind eq '入库' }">
		    					<td>${obj.hpbm }<input type="hidden" name="hpzj" value="${obj.crkhpzj }"></td>
		    					<td>${obj.hpmc }</td>
		    					<td>${obj.hpdw }</td>
		    					<td>${obj.hplx }</td>
		    					<td>${obj.hpxh }</td>
		    					<td>${obj.hpsl }</td>
		    					<td><input type="text" name="hgsl" class="inputsmall3" onblur="zjjs(this)"></td>
		    					<td width="15%">${obj.shsl }</td>
		    					</c:if>
		    					<c:if test="${orderKind eq '出库' }">
		    					<td>${obj.hpbm }<input type="hidden" name="hpzj" value="${obj.crkhpzj }"></td>
		    					<td>${obj.hpmc }</td>
		    					<td>${obj.hpdw }</td>
		    					<td>${obj.hplx }</td>
		    					<td>${obj.hpxh }</td>
		    					<td>${obj.hpsl }</td>
		    					<td><input type="hidden" name="yhgsl" value="${obj.hgsl }"><input type="text" name="hgsl" class="inputsmall3" value="${obj.hgsl }" onblur="ckzjjs(this)"></td>
		    					<td width="15%">${obj.shsl }</td>
		    					</c:if>
		    				</tr>
						</c:forEach>	
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">质检时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.zjsj" styleClass="input" readonly="true"></html:text>
    			</td>	
    			<td align="right">质检人&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.zjr" styleClass="input" readonly="true"></html:text>
    			</td>
    		</tr> 	
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.crkzj"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="submit" name="tijiao" class="inputbutton" value="质 检">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="orderKind" value="${orderKind }">
    			</td>
    		</tr>
    	</table>
  	</html:form>
  </body>
</html>
