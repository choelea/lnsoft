<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
<head>
<title><bean:message key="system.title"/></title>
<script type="text/javascript">
	function toAdd(){
		window.location.href="<%=request.getContextPath()%>/khfk.do?method=goSave";
	}
	function selAll(){
		var pks = document.getElementsByName("pk");
		for(var i=0;i<pks.length;i++){
			if(!pks[i].disabled){
				pks[i].checked=event.srcElement.checked;
			}
		}
	}
	function toDel(){
		var pks = document.getElementsByName("pk");
		var count = 0;
		for(var i=0;i<pks.length;i++){
			if(!pks[i].checked){
				count++;
			}
		}
		if(count==pks.length){
			alert("至少选择一条记录！");
			return false;
		}
		if(confirm("确认删除记录?")){
			var form = document.forms[0];
			form.action="<%=request.getContextPath()%>/khfk.do?method=delete";
			form.method="post";
			form.submit();
		}
	}
	function pagedata(page,count){
		var exp = /^\d+$/;
		if(!exp.test(page)){
			alert("页码输入有误!");
		}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
			alert("页数超出范围!");
		}else{
			window.location.href="<%=request.getContextPath()%>/khfk.do?method=getList&page="+page;
		}
	}
</script>

</head>
<c:if test="${msg!=null }">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>
<body>
	<html:form action="/khfk.do?method=query" method="post">
		<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="word-break:break-all;">
			<tr>
				<td align="right" width="20%"><b>查询字段名:</b></td>
				<td width="25%">
					<html:select property="fieldName" value="${fieldName }">
						<html:option value="">请选择查询字段名</html:option>
						<html:option value="fkbh">返单编号</html:option>
						<html:option value="fksj">返单时间</html:option>
					</html:select>
				</td>
				<td align="right" width="15%"><b>查询字段值:</b></td>
				<td width="20%"><html:text property="fieldValue" styleClass="input" value="${fieldValue }"></html:text> </td>
				<td ><html:submit value="查 询" styleClass="inputbutton"></html:submit> </td>
			</tr>
		</table>
		<table width="100%" align="center" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
			<thead>
				<tr align="center" height="30">
					<th><input type="checkbox" name="apk" onclick="selAll();"> 全选</th>
					<th>返单编号</th>
					<th>收货方</th>
					<th>发货方</th>
					<th>制单时间</th>
					<th>操 作</th>
				</tr>
			</thead>
			<c:if test="${!empty pageinfo.pagedata }">
				<c:forEach var="obj" items="${pageinfo.pagedata }">
					<tr align="center" height="25">
						<td><input type="checkbox" value="${obj.khfkzj }"name="pk" <c:if test="${(obj.ssxs==0 and obj.sssysz==0) or (obj.fkzt!=0) }">disabled="disabled"</c:if>> </td>
						<td><a href="<%=request.getContextPath()%>/khfk.do?method=view&pk=${obj.khfkzj }">${obj.fkbh }</a></td>
						<td>${obj.fkr }</td>
						<td>${obj.fhr }</td>
						<td>${obj.fksj }</td>
						<td>
							<c:if test="${obj.fkzt!=1}">
								<a href="<%=request.getContextPath()%>/khfk.do?method=goUpdate&pk=${obj.khfkzj }">修 改</a>/
								<a href="<%=request.getContextPath()%>/khfk.do?method=khfd&pk=${obj.khfkzj }">返 单</a>
							</c:if>
							<c:if test="${obj.fkzt==1}">已返单</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty pageinfo.pagedata }">
				<tr align="center" height="25">
					<td colspan="7" align="center">暂无信息</td>
				</tr>
			</c:if>
			<tr align="center" height="30">
				<td colspan="7" >
					<input type="button" value="添 加" onclick="toAdd();" class="inputbutton">
					<input type="button" value="删 除" onclick="toDel();" class="inputbutton">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="td1">
					共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页
					&nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
					<input type="button" name="first" class="inputbutton3" onClick="pagedata(1,${pageinfo.allpage });" />
					<input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });" />
					<input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });" />
					<input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });" />
					跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" 
						onchange="pagedata(this.value,${pageinfo.allpage });" />页
				</td>
			</tr>
		</table>
	</html:form>
</body>
</html>