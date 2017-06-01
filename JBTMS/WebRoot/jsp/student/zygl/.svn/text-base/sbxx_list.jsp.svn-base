<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
			function toadd(){
	    		window.location.href="<%=request.getContextPath()%>/sbxx.do?method=goSave"
	    	}
	    	function todel(){
	    		var temp=document.getElementsByName("pk");
				  for (i=0;i<temp.length;i++){ 
				  //遍历Radio 
				    if(temp[i].checked){     	
				    	 break;
				     }
				  } 
			  	if(i==temp.length){
					alert("没有选择信息！");
					return false;
				}
				if(confirm("确认删除？")){
					var form = document.forms[0];
					form.action="<%=request.getContextPath()%>/sbxx.do?method=delete";
			  		form.method="post";
			  		form.submit();
		  		}
	    	}
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
					window.location.href="<%=request.getContextPath()%>/sbxx.do?method=getList&page="+page;
				}
			}
			function check(ssxs){
				if(ssxs==0){
					alert("原始数据，禁止修改！");
					return false;
				}
				return true;
			}
		</script>

  </head>
<c:if test="${msg!=null }">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>
  <body>
    <html:form action="/sbxx.do?method=query" method="post" >
		<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" style="word-break:break-all;">
			<tr>
				<td align="right" width="20%"><b>查询字段名:</b></td>
				<td width="25%">
					<html:select property="fieldName">
						<html:option value="">请选择查询字段名</html:option>
						<html:option value="A.sbbh">设备编号</html:option>
						<html:option value="A.sblx">设备类型</html:option>
						<html:option value="A.sbzt">设备状态</html:option>
						<html:option value="B.kfmc">所在仓库</html:option>
					</html:select>
				</td>
				<td align="right" width="15%"><b>查询字段值:</b></td>
				<td width="20%"><html:text property="fieldValue" styleClass="input"></html:text> </td>
				<td ><html:submit value="查 询" styleClass="inputbutton"></html:submit> </td>
			</tr>
		</table>
		<table width="100%" align="center" cellpadding="0" cellspacing="1"
			border="0" style="word-break:break-all;">
			<thead>
				<tr>
					<th>全选
						<input type="checkbox" id="delpk" onClick="return selAll();">
					</th>
					<th>设备编号</th>
					<th>设备类型</th>
					<th>设备状态</th>
					<th>动力类型</th>
					<th>所在仓库</th>
					<th>修 改</th>
				</tr>
			</thead>
			<c:if test="${!empty pageinfo.pagedata }">
				<c:forEach var="obj" items="${pageinfo.pagedata }">
					<tr align="center">
						<td >
							<input type="checkbox" name="pk" value="${obj.sbzj }" ${obj.ssxs==0?"disabled":"" }/>
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/sbxx.do?method=view&pk=${obj.sbzj}">${obj.sbbh}</a>
						</td>
						<td>${obj.sblx }</td>
						<td>${obj.sbzt }</td>
						<td>${obj.dllx }</td>
						<td>${obj.kfbh }</td>
						<td>
							<a href="<%=request.getContextPath()%>/sbxx.do?method=goUpdate&pk=${obj.sbzj}">修 改</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty pageinfo.pagedata }">
				<tr>
					<td colspan="9" align="center">
						暂无设备信息！
					</td>
				</tr>
			</c:if>
			<tr>
				<td align="center" colspan="8">
					<input type="button" value="添 加" onclick="toadd();" class="inputbutton" />
					<input type="button" value="删 除" onclick="return todel();" class="inputbutton" />
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="right">
					共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页
					&nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
					<input type="button" name="first" class="inputbutton3"
						onClick="pagedata(1,${pageinfo.allpage });" />
					<input type="button" name="before" class="inputbutton1"
						onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });" />
					<input type="button" name="next" class="inputbutton2"
						onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });" />
					<input type="button" name="last" class="inputbutton4"
						onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });" />
					跳至
					<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }"
						onchange="pagedata(this.value,${pageinfo.allpage });" />
					页
				</td>
			</tr>
		</table>
	</html:form>
  </body>
</html>
