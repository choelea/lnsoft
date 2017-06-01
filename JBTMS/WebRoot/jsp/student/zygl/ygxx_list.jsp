<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message>
		</title>
		<script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/yggl.do?method=goAdd"
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
				form.action="<%=request.getContextPath()%>/yggl.do?method=delObject";
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
				window.location.href="<%=request.getContextPath()%>/yggl.do?method=getList&page="+page;
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
		<c:if test="${msg!=null }">
			<script type="text/javascript">
    		alert('${msg}');
    	</script>
		</c:if>
	</head>

	<body>
		<html:form action="/yggl.do?method=queryList" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="ygbh">员工编号</html:option>
							<html:option value="ygmc">员工姓名</html:option>
							<html:option value="ygzw">员工职位</html:option>
							<html:option value="ygzt">员工状态</html:option>
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
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>员工职位</th>
						<th>员工状态</th>
						<th>所属站点</th>
						<th>修 改</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="8%">
								<input type="checkbox" name="pk" value="${obj.ygzj }" ${obj.ssxs==0?"disabled":"" }/>
							</td>
							<td width="15%">
								<a
									href="<%=request.getContextPath()%>/yggl.do?method=viewObject&pk=${obj.ygzj}">${obj.ygbh}</a>
							</td>
							<td width="10%">
								${obj.ygmc }
							</td>
							<td width="10%">
								${obj.ygzw }
							</td>
							<td width="10%">
								<c:if test="${obj.ygzt=='0'}">
									空闲
								</c:if>
								<c:if test="${obj.ygzt =='1'}">
									忙碌
								</c:if>
							</td>
							<td width="10%">${obj.ssjg }</td>
							<td width="10%">
							<c:if test="${(obj.ssxs!=0 and obj.sssysz!=0)}">
								<a
									href="<%=request.getContextPath()%>/yggl.do?method=goUpdate&pk=${obj.ygzj}" onclick="return check(${obj.ssxs });">修 改</a>
							</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="8" align="center">
							暂无员工信息!
						</td>
					</tr>
				</logic:empty>
				<tr>
					<td colspan="8" align="center">
						<input type="button" value="添 加" onclick="toadd();"
							class="inputbutton" />
						<input type="button" value="删 除" onclick="return todel();"
							class="inputbutton" />
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