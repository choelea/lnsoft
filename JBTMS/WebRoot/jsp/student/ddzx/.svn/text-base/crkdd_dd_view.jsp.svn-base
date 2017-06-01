<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>  
    <script type="text/javascript">
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/crkdd.do?method=getDdList&page=1";
    	}
    	function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  <body>
  	<html:form action="/crkdd.do?method=dDu" method="post">
  		<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>订单调度</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				${vo.ddbh }
    			</td>
    			<td align="right" width="20%">订单类型&nbsp;&nbsp;</td>
    			<td>
    				${vo.ddlx }
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户指令号&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.khzlh }
    			</td>
    			<td align="right">下达时间&nbsp;&nbsp;
    			</td>
    			<td >
					${vo.xdsj }
    			</td>    
    		</tr> 
    		<tr>
    			<td align="right">库房&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.kfmc}
    			</td>
    			<td align="right">紧急程度&nbsp;&nbsp;
    			</td>
    			<td >
					${vo.jjcd }
    			</td>    
    		</tr> 
    		<tr>
	    		<td align="right">
	    		${vo.ddlx eq "入库"?"入库类型":"出库类型" }&nbsp;&nbsp;
	    		</td>
	    			<td >
						${vo.crklx }
	    		</td> 
    			<td align="right">${vo.ddlx eq "入库"?"预计入库时间":"预计出库时间" }&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.yjcrksj}
    			</td>
    		</tr> 
    		</table>
    		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr>
    			<td align="right" width="20%">质检人&nbsp;&nbsp;
    			</td>
    			<td width="70%" id="zj">
    			<c:if test="${ygList!=null && fn:length(ygList)>0}">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tr align="center">
    				<td width="32%">员工编号</td><td width="32%">员工姓名</td><td width="32%">职位</td>
    				</tr>
    				<c:forEach var="zjy" items="${ygList }">
    					<c:if test="${zjy.ygzw eq '质检员' }">
    					<tr align="center">
    						<td>${zjy.ygbh }</td><td>${zjy.ygmc }</td><td>${zjy.ygzw }</td>
    					</tr>
    					</c:if>
    				</c:forEach>
    			</table>
    			</c:if>
    			</td>   
    			
    		</tr>
    		<tr>
    			<td align="right">仓储人员&nbsp;&nbsp;
    			</td>
    			<td id="cc">
    			<c:if test="${ygList!=null && fn:length(ygList)>0}">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tr align="center">
    				<td width="32%">员工编号</td><td width="32%">员工姓名</td><td width="32%">职位</td>
    				</tr>
    				<c:forEach var="zjy" items="${ygList }">
    					<c:if test="${zjy.ygzw != '质检员' }">
    					<tr align="center">
    						<td>${zjy.ygbh }</td><td>${zjy.ygmc }</td><td>${zjy.ygzw }</td>
    					</tr>
    					</c:if>
    				</c:forEach>
    			</table>
    			</c:if>
    			</td>   
    		</tr> 
    		<tr>
    			<td align="right">设备&nbsp;&nbsp;
    			</td>
    			<td id="sb">
    			<c:if test="${sbList!=null && fn:length(sbList)>0}">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tr align="center">
    				<td width="32%">设备编号</td><td width="32%">设备类型</td><td width="32%">动力类型</td>
    				</tr>
    				<c:forEach var="sb" items="${sbList }">
    					<tr align="center">
    						<td>${sb.sbbh}</td><td>${sb.sblx}</td><td>${sb.dllx}</td>
    					</tr>
    				</c:forEach>
    			</table>
    			</c:if>
    			
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
