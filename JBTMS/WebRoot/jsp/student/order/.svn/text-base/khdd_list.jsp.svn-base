<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/khdd.do?method=goSave"
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
				form.action="<%=request.getContextPath() %>/khdd.do?method=delete";
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
				window.location.href="<%=request.getContextPath()%>/khdd.do?method=getList&page="+page;
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
  <html:form action="/khdd.do?method=query" method="post">
  	<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="20%">
  			<b>查询字段名：</b>
  			</td>
  			<td align="left" width="25%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="A.ddbh">客户订单编号</html:option>
  					<html:option value="A.ddrq">订单日期</html:option>
  					<html:option value="A.qhrq">取货日期</html:option>
  					<html:option value="B.dwmc">委 托 方</html:option>
  					<html:option value="C.dwmc">收 货 方</html:option>
  					<html:option value="A.zdr">制 单 人</html:option>
  				</html:select>
  			</td>
  			<td align="right" width="15%"><b>查询字段值：</b></td>
  			<td align="left" width="20%"><html:text property="fieldValue" styleClass="input"></html:text>
  			<td align="left" ><input type="submit" value="查 询" class="inputbutton"/></td>
  		</tr>
  	</table>
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>订单编号</th>
	    		<th>委 托 方</th>
	    		<th>收 货 方</th>
	    		<th>取货日期</th>
	    		<th>制 单 人</th>
	    		<th>操 作</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.ddzj }"/></td>
		   		<td>
		   		<a href="<%=request.getContextPath()%>/khdd.do?method=view&pk=${obj.ddzj }">${obj.ddbh }</a>
		   		</td>
		   		<td>${obj.wtfmc}</td>
		   		<td>${obj.shfmc }</td>
		   		<td>${obj.qhrq }</td>
		   		<td>${obj.zdr }</td>
		   		<td>
		   		<c:if test="${obj.ddzt==0 }">
		   			<a href="<%=request.getContextPath()%>/khdd.do?method=goUpdate&pk=${obj.ddzj }">修改</a>
		   			/
		   			<a href="<%=request.getContextPath()%>/khdd.do?method=valid&pk=${obj.ddzj }">审核</a>
		   		</c:if>
		   		<c:if test="${obj.ddzt==1 }">
		   			已 审 核
		   		</c:if>
		   		<c:if test="${obj.ddzt==2 }">
		   			完 成
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="8" align="center">
    			暂无客户订单信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="8" align="center">
    			<input type="button" value="添 加" onclick="toadd();" class="inputbutton"/>
    			<input type="button" value="删 除" onclick="return todel();" class="inputbutton"/>
    		</td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata(1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata(this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
