<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
	    function ToAdd(){
	    	window.location.href="./kfxx.do?method=gotoAdd";
	    }
	    function selAll(){ 
	     o=document.getElementsByName("pk"); 
	     for(i=0;i<o.length;i++) 
	     	if(o[i].disabled==false){
	     		 o[i].checked=event.srcElement.checked; 
	     	} 
		}
		function ToDel() { 
			  var temp=document.getElementsByName("pk"); 
			  var count=0;
			  for (i=0;i<temp.length;i++){ 
			  //遍历Radio 
			    if(temp[i].checked){     	
			    	 break;
			     }  
			     count++;   
			  } 
		  	if(count==temp.length){
				alert("至少选择一条记录！");
				return false;
			}
			if(confirm("确定要删除吗？")){
				var form = document.forms[0];
				form.action="./kfxx.do?method=delObject";
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
					window.location.href="./kfxx.do?method=objList&page="+page;
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
	<c:if test="${msg!=null}">
		<script type="text/javascript">
	     alert("${msg }");
		</script>
	</c:if>
  </head>
  
  <body>
    <html:form action="/kfxx.do?method=queryList" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="kfbh">仓库编号</html:option>
							<html:option value="kfmc">仓库名称</html:option>
							<html:option value="pym">拼 音 码</html:option>
							<html:option value="kflx">仓库类型</html:option>
							<html:option value="kfzt">仓库状态</html:option>
							<html:option value="kfgly">管 理 员</html:option>
							<html:option value="ssjg">所属机构</html:option>
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
						<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
						<th>库房编号</th>
						<th>库房名称</th>
						<th>库房类型</th>
						<th>库房面积</th>
						<th>库房状态</th>
						<th>所属站点</th>
						<th>修改</th>
						<th>区位管理</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="7%">
								<input type="checkbox" name="pk" value="${obj.kfzj }" ${obj.ssxs==0?"disabled":"" }/>
							</td>
							<td>
								<a href="./kfxx.do?method=viewObject&vo.kfzj=${obj.kfzj}">${obj.kfbh}</a>
							</td>
							<td>
								${obj.kfmc }
							</td>
							<td>
								${obj.kflx }
							</td>
							<td>
								${obj.kfmj }
							</td>
							<td>
								${obj.kfzt }
							</td>
							<td>${obj.ssjg }</td>
							<td>
								<a href="./kfxx.do?method=gotoUpd&vo.kfzj=${obj.kfzj}" onclick="return check(${obj.ssxs });">修改</a>
							</td>
							<td>
								<a href="./qwxx.do?method=objList&kfxx.kfzj=${obj.kfzj}&rmMsg=true">区位管理</a>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无仓库信息!
						</td>
					</tr>
				</logic:empty>
				<tr>
					<td colspan="9" align="center">
						<input type="button" value="添 加" onclick="ToAdd();" class="inputbutton" />
						<input type="button" value="删 除" onclick="return ToDel();" class="inputbutton" />
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页&nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
						<input type="button" name="first" class="inputbutton3" onClick="pagedata(1,${pageinfo.allpage });" />
						<input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });" />
						<input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });" />
						<input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });" />
						跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata(this.value,${pageinfo.allpage });" />页
					</td>
				</tr>
			</table>
		</html:form>
  </body>
</html>
