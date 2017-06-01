<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/> </title>
    <script type="text/javascript">
    	
    	function toAdd(){
    		window.location.href="<%=request.getContextPath()%>/khth.do?method=goSave";
    	}
    	function toDel(){
    		var pks = document.getElementsByName("pk");
    		var count = 0;
    		for(var i=0;i<pks.length;i++){
    			if(!pks[i].checked){
    				count++;
    			}
    		}
    		if(count == pks.length){
    			alert("至少选择一条记录!");
    			return false;
    		}
    		if(confirm("确定删除记录?")){
    			var form = document.forms[0];
    			form.action = "<%=request.getContextPath()%>/khth.do?method=delete";
    			form.method = "post";
    			form.submit();
    		}
    	}
    	function selAll(){
    		var pks = document.getElementsByName("pk");
    		for(var i=0;i<pks.length;i++){
    			if(!pks[i].disabled){
    				pks[i].checked = event.srcElement.checked;
    			}
    		}
    	}
    	function pagedata(page,count){
    		var exp = /^\d+$/;
    		if(!exp.test(page)){
    			alert("页数输入有误!");
    		}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
    			alert("页数超出范围!");
    		}else {
    			window.location.href="<%=request.getContextPath()%>/khth.do?method=getList&page="+page;
    		}
    	}
    </script>
  </head>
<c:if test="${msg != null}">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>
  <body>
    <html:form action="khth.do?method=query" method="post">
    	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="word-break:break-all;">
			<tr>
				<td align="right" width="20%"><b>查询字段名:</b></td>
				<td width="25%">
					<html:select property="fieldName">
						<html:option value="">请选择查询字段名</html:option>
						<html:option value="A.thdh">退货单号</html:option>
						<html:option value="B.ddh">订单编号</html:option>
						<html:option value="A.thrqm">退货人</html:option>
						<html:option value="A.thrq">退货日期</html:option>
						<html:option value="A.fhzd">发货站点</html:option>
					</html:select>
				</td>
				<td align="right" width="15%"><b>查询字段值:</b></td>
				<td width="20%"><html:text property="fieldValue" styleClass="input"></html:text> </td>
				<td ><html:submit value="查 询" styleClass="inputbutton"></html:submit> </td>
			</tr>
		</table>
    	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
    		<thead>
    			<tr>
    				<th><input type="checkbox" name="apk" onclick="selAll();"> 全选</th>
    				<th>退货单号</th>
    				<th>订单编号</th>
    				<th>发货站点</th>
    				<th>退货人签名</th>
    				<th>退货日期</th>
    				<th>操 作</th>
    			</tr>
    		</thead>
    		<c:if test="${!empty pageinfo.pagedata}">
    			<c:forEach var="obj" items="${pageinfo.pagedata}">
    				<tr align="center">
	    				<td><input type="checkbox" name="pk" value="${obj.thzj}"></td>
	    				<td><a href="<%=request.getContextPath()%>/khth.do?method=view&pk=${obj.thzj}">${obj.thdh}</a></td>
	    				<td>${obj.ddh }</td>
	    				<td>${obj.fhzd}</td>
	    				<td>${obj.thrqm}</td>
	    				<td>${obj.thrq}</td>
	    				<td><a href="<%=request.getContextPath()%>/khth.do?method=goUpdate&pk=${obj.thzj}">修 改</a></td>
	    			</tr>
    			</c:forEach>
    		</c:if>
    		<c:if test="${empty pageinfo.pagedata}">
    			<tr>
    				<td colspan="8" align="center">暂无客户退货信息</td>
    			</tr>
    		</c:if>
    		<tr>
    			<td colspan="8" align="center">
    				<input type="button" value="添 加" onclick="toAdd();" class="inputbutton">
    				<input type="button" value="删 除" onclick="toDel();" class="inputbutton">
    			</td>
    		</tr>
    	</table>
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
    		<tr>
    			<td align="right">共 [${pageinfo.allpage}] 页 当前第 [${pageinfo.curpage}] 页 每页 [${pageinfo.pagerecord}] 记录
    				<input type="button" class="inputbutton3" onclick="pagedata(1,${pageinfo.allpage});">
    				<input type="button" class="inputbutton1" onclick="pagedata(${pageinfo.previouspage},${pageinfo.allpage});">
    				<input type="button" class="inputbutton2" onclick="pagedata(${pageinfo.nextpage},${pageinfo.allpage});">
    				<input type="button" class="inputbutton4" onclick="pagedata(${pageinfo.allpage},${pageinfo.allpage});">
    				跳至<input type="text" value="${pageinfo.curpage}" onchange="pagedata(this.value,${pageinfo.allpage});" class="inputsmall">页
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>