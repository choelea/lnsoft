<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
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
				window.location.href="<%=request.getContextPath()%>/send.do?method=objList1&address=trans&page="+page;
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
		<html:form action="/send.do?method=queryList1&address=trans" method="post" >
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td width="25%"> 
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="A.ysdbh">运输单号</html:option>
							<html:option value="A.dhsj">到货时间</html:option>
							<html:option value="A.ysfs">运输方式</html:option>
							<html:option value="D.dwmc">委 托 方</html:option>
							<html:option value="E.dwmc">收 货 方</html:option>
						</html:select>
					</td>
					<td align="right" width="15%">
						<b>查询字段值:</b>
					</td>
					<td width="20%">
						<html:text property="fieldValue" styleClass="input"></html:text>
						</td>
					<td width="20%">
						<input type="submit" name="chaxun" value="查询" class="inputbutton"/>
					</td>
				</tr>
			</table>
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<thead>
					<tr>
						<th>
							全选
							<input type="checkbox" id="delpk" onClick="return selAll();">
						</th>
						<th>运输单号</th>
						<th>订单类型</th>
						<th>运输方式</th>
						<th>委 托 方</th>
						<th>收 货 方</th>
						<th>执行状态</th>
						<th>操 作</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="10%">
								<input type="checkbox" name="pk" value="${obj.ysdzj }" />
							</td>
							<td >
								<a
									href="<%=request.getContextPath()%>/send.do?method=view2&address=trans&pk=${obj.ysdzj}">${obj.ysdbh}</a>
							</td>
							<td>
							<c:if test="${obj.ysdlx eq '运输' }">
								整 车
							</c:if>
							<c:if test="${obj.ysdlx eq '配送' }">
								零 担
							</c:if>
							<td>${obj.ysfs }</td>
							<td>${obj.dhfmc }</td>
							<td>${obj.shfmc }</td>
							<td>
								<c:if test="${obj.yszt==0 }">
								录入
								</c:if>
								<c:if test="${obj.yszt==1 }">
								计划
								</c:if>
								<c:if test="${obj.yszt==2 }">
								调度
								</c:if>
								<c:if test="${obj.yszt==3 }">
								在途
								</c:if>
								<c:if test="${obj.yszt==4 }">
								签收
								</c:if>
							</td>
							<td >
								<c:if test="${obj.yszt==0 }">
									<a href="<%=request.getContextPath()%>/send.do?method=task&address=trans&pk=${obj.ysdzj}">分 拣</a>
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无运输单!
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
