<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function selAll(){ 
		    var o=document.getElementsByName("pk"); 
		     for(i=0;i<o.length;i++) {
			 	if(!o[i].disabled){
			       o[i].checked=event.srcElement.checked; 
			     }
			 }
		}
		function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				window.location.href="./khdd.do?method=objList&page="+page;
			}
		}
    </script> 
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
  <html:form action="/khdd.do?method=queryList" method="post">
  	<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="15%">
  			<b>查询字段名：</b>
  			</td>
  			<td align="left" width="17%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="A.ddbh">客户订单编号</html:option>
  					<html:option value="A.ddrq">订单日期</html:option>
  					<html:option value="A.qhrq">取货日期</html:option>
  					<html:option value="B.dwmc">委 托 方</html:option>
  					<html:option value="C.dwmc">收 货 方</html:option>
  					<html:option value="A.zdr">制 单 人</html:option>
  				</html:select>
  			</td>
  			<td align="right" width="15%"><b>查询字段值：</b></td>
  			<td align="left" width="38%"><html:text property="fieldValue" styleClass="input"></html:text>
  				<b>状 态：</b>
  				<html:select property="cxhtzt">
  					<html:option value="0">录 入</html:option>
  					<html:option value="1">通过审核</html:option>
  					<html:option value="2">签订合同</html:option>
  				</html:select>
  			</td>
  			<td align="left" ><input type="submit" value="查 询" class="inputbutton"/></td>
  		</tr>
  	</table>
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>订单编号</th>
	    		<th>委 托 方</th>
	    		<th>收 货 方</th>
	    		<th>取货日期</th>
	    		<th>制 单 人</th>
	    		<th>状 态</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.ddzj }"/></td>
		   		<td>
		   		<a href="<%=request.getContextPath()%>/khdd.do?method=view1&pk=${obj.ddzj }">${obj.ddbh }</a>
		   		</td>
		   		<td>${obj.wtfmc}</td>
		   		<td>${obj.shfmc }</td>
		   		<td>${obj.qhrq }</td>
		   		<td>${obj.zdr }</td>
		   		<td>
		   		<c:if test="${obj.ddzt==0 }">
		   			录 入
		   		</c:if>
		   		<c:if test="${obj.ddzt==1 }">
		   			通过审核
		   		</c:if>
		   		<c:if test="${obj.ddzt==2 }">
		   			签订合同
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="8" align="center">
    			暂无客户订单信息!
    		</td>
    	</tr>
    	</logic:empty>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata(1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata(this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
