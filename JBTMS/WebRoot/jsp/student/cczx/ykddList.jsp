<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
	    function selAll(){ 
	     o=document.getElementsByName("pk"); 
	     for(i=0;i<o.length;i++) 
	     	if(o[i].disabled==false){
	     		 o[i].checked=event.srcElement.checked; 
	     	} 
		}
		function pagedata(page,count){
				var exp = /^\d+$/;
				if(!exp.test(page)){
					alert("页码输入有误!");
				}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
					alert("页数超出范围!");
				}else{
					window.location.href="./ykdd.do?method=valiList&page="+page;
				}
		}
		function valiState(st,jhdate){
			if(st!='0'){
				alert("此订单已执行!");
				return false;
			}
			if(jhdate.length==0){
				alert("计划日期有误，请修改移库订单信息!");
				return false;
			}else if(jhdate.length>10){
				jhdate = jhdate.substring(0,10);
			}
			var d = jhdate.split("-");
			var yd = new Date(d[0],d[1]-1,d[2]);
			var nd = new Date();
			var y = nd.getYear();
			var m = nd.getMonth();
			var da = nd.getDate();
			nd = new Date(y,m,da);
			if(yd>nd){
				alert("尚未到计划移库日期!");
				return false;
			}else if(yd<nd){
				alert("移库执行时间已过!");
				return false;
			}else{
				return true;
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
    <html:form action="/ykdd.do?method=queryList1" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="ykbh">移库编号</html:option>
							<html:option value="ddrq">订单日期</html:option>
							<html:option value="ckkfmc">源 库 房</html:option>
							<html:option value="rkkfmc">目标库房</html:option>
							<html:option value="tdsj">填单日期</html:option>
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
						<th>移库编号</th>
						<th>计划日期</th>
						<th>源 库 房</th>
						<th>目标库房</th>
						<th>执行状态</th>
						<th>移 库</th>
					</tr>
				</thead>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata">
						<tr align="center">
							<td width="7%">
								<input type="checkbox" name="pk" value="${obj.ykzj }"/>
							</td>
							<td>
								<a href="./ykdd.do?method=viewObject1&vo.ykzj=${obj.ykzj}">${obj.ykbh}</a>
							</td>
							<td>
								${obj.ddrq }
							</td>
							<td>
								${obj.ckkfmc }
							</td>
							<td>
								${obj.rkkfmc }
							</td>
							<td>
								${obj.ykzt==0?'计划':'完成' }
							</td>
							<td>
								<a href="./ykdd.do?method=gotoVali&vo.ykzj=${obj.ykzj}" onclick="return valiState('${obj.ykzt }','${obj.ddrq }');">移 库</a>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无移库订单信息!
						</td>
					</tr>
				</logic:empty>
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
