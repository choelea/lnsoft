<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message>
		</title>
		<script type="text/javascript">
		function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				window.location.href="<%=request.getContextPath()%>/cczx.do?method=getZjList&page="+page;
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
		<html:form action="/cczx.do?method=queryZjList" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="ddbh">订单编号</html:option>
							<html:option value="khzlh">客户指令号</html:option>
							<html:option value="xdsj">下达时间</html:option>
						</html:select>
					</td>
					<td align="right">
						<b>查询字段值:</b>
					</td>
					<td>
						<html:text property="fieldValue" styleClass="input"/>
					</td>
					<td width="20%">
						<input type="hidden" name="orderKind" value="${orderKind }">
						<input type="submit" name="chaxun" value="查 询" class="inputbutton"/>
					</td>
				</tr>
			</table>
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>订单类型</th>
						<th>客户指令号</th>
						<th>紧急程度</th>
						<th>下达时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="15%">
								<a href="<%=request.getContextPath()%>/cczx.do?method=viewObject&kind=zj&pk=${obj.crkzj}">${obj.ddbh}</a>
							</td>
							<td width="10%">
								${obj.ddlx }
							</td>
							<td width="10%">
								${obj.khzlh }
							</td>
							<td width="10%">
								${obj.jjcd }
							</td>
							<td width="12%">
								${obj.xdsj }
							</td>
							<td width="12%">
								<c:if test="${obj.ddlx =='入库'}">
									<c:if test="${obj.ddzt eq 3 }">
										<a href="<%=request.getContextPath()%>/cczx.do?method=goZj&pk=${obj.crkzj}" >质检</a> 
									</c:if>
									<c:if test="${obj.ddzt > 3 }">
										已质检
									</c:if>
								</c:if>
								<c:if test="${obj.ddlx =='出库'}">
									<c:if test="${obj.ddzt eq 4 }">
										<a href="<%=request.getContextPath()%>/cczx.do?method=goZj&pk=${obj.crkzj}" >质检</a> 
									</c:if>
									<c:if test="${obj.ddzt > 4 }">
										已质检
									</c:if>
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="8" align="center">
							暂无订单信息!
						</td>
					</tr>
				</logic:empty>
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
						<input type="text" name="pa" class="inputsmall"
							value="${pageinfo.curpage }"
							onchange="pagedata(this.value,${pageinfo.allpage });" />
						页
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>