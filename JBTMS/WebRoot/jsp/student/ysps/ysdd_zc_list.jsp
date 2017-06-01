<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/extjs.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
    	function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				window.location.href="<%=request.getContextPath()%>/ydcx.do?method=getList&page="+page;
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
		<html:form action="/pgpc.do?method=queryZc" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="ysddbh">调度单号</html:option>
							<html:option value="ysddlx">调度类型</html:option>
							<html:option value="ysfs">运输方式</html:option>
						</html:select>
					</td>
					<td align="right">
						<b>查询字段值:</b>
					</td>
					<td>
						<html:text property="fieldValue" styleClass="input"/>
					</td>
					<td width="20%">
						<input type="submit" name="chaxun" value="查 询" class="inputbutton"/>
						<input type="hidden" name="show-btn">
						<input type="hidden" name="ddzj">
						<input type="hidden" name="ddlx">
						<input type="hidden" name="sfz">
					</td>
				</tr>
			</table>
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<thead>
					<tr align="center">
						<th>
							全选
							<input type="checkbox" id="delpk" onClick="return selAll();">
						</th>
						<th>调度单号</th>
						<th>调度类型</th>
						<th>运输方式</th>
						<th>始 发 站</th>
						<th>调度状态</th>
						<th>操 作</th>
					</tr>
				</thead>
				<c:set var="x" value="0"></c:set>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata"
						indexId="i">
						<tr align="center">
							<td >
								<input type="checkbox" name="pk" value="${obj.ysddzj }" />
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/pgpc.do?method=view&vo.ysddzj=${obj.ysddzj}&type=zc">${obj.ysddbh}</a>
							</td>
							<td>
								<c:if test="${obj.ysddlx eq '运输' }">
									整 车
								</c:if>
								<c:if test="${obj.ysddlx eq '配送' }">
									零 担
								</c:if>
							</td>
							<td>${obj.ysfs }</td>
							<td>${obj.sfz }</td>
							<td>
								<c:if test="${obj.ysddzt==0 }">录 入</c:if>
								<c:if test="${obj.ysddzt==1 }">装 车</c:if>
								<c:if test="${obj.ysddzt==2 }">在 途</c:if>
								<c:if test="${obj.ysddzt==3 }">完 成</c:if>
							</td>
							<td>
								<c:if test="${obj.sfpg==1&&obj.sfpc==1&&obj.ysddzt==0}">
									<a href="<%=request.getContextPath()%>/pgpc.do?method=ysdZc&vo.ysddzj=${obj.ysddzj}" >装 车</a>
								</c:if>
								<c:if test="${obj.sfpg==1&&obj.sfpc==1&&obj.ysddzt>0}">
									已装车
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无调度单信息!
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
						<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }"
							onchange="pagedata(this.value,${pageinfo.allpage });" />
						页
					</td>
				</tr>
			</table>
		</html:form>
		<div id="hello-win" class="x-hidden">
			<div id="hello-tabs">
				<div class="tanchuang" id="div1"></div>
			</div>
		</div>
	</body>
</html>