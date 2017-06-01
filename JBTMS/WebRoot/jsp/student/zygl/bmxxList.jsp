<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
	    function ToAdd(){
	    	window.location.href="./bmxx.do?method=gotoAdd";
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
				form.action="./bmxx.do?method=delObject";
		  		form.method="POST";
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
					window.location.href="./bmxx.do?method=objList&page="+page;
				}
		}
	</script>
	<c:if test="${msg!=null}">
		<script type="text/javascript">
	     alert("${msg }");
		</script>
	</c:if>
  </head>
  
  <body>
    <html:form action="/bmxx.do?method=queryList" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="bmbh">部门编号</html:option>
							<html:option value="bmmc">部门名称</html:option>							
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
						<th>部门编号</th>
						<th>部门名称</th>
						<th>部门电话</th>
						<th>所属机构</th>
						<th>修 改</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="7%">
								<input type="checkbox" name="pk" value="${obj.bmzj }" <c:if test="${(obj.ssxs==0 and obj.sssysz==0)}">disabled="disabled"</c:if>/>
							</td>
							<td>
								<a href="./bmxx.do?method=viewObject&vo.bmzj=${obj.bmzj}">${obj.bmbh}</a>
							</td>
							<td>
								${obj.bmmc }
							</td>
							<td>
								${obj.bmdh }
							</td>
							<td>
								${obj.ssjg }
							</td>
							<td>
								<c:if test="${(obj.ssxs!=0 and obj.sssysz!=0)}">
									<a href="./bmxx.do?method=gotoUpd&vo.bmzj=${obj.bmzj}&rmMsg=true">修 改</a>
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无部门信息!
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
