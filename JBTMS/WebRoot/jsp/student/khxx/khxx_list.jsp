<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/khxx.do?method=goSave"
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
				form.action="<%=request.getContextPath() %>/khxx.do?method=delete";
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
				window.location.href="<%=request.getContextPath()%>/khxx.do?method=getList&page="+page;
			}
		}
		function check(ssxs){
			if(ssxs==0){
				alert("原始数据，禁止修改!");
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
  <html:form action="/khxx.do?method=query" method="post">
  	<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="20%"><b>查询字段名：</b></td>
  			<td align="left" width="25%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="khbh">客户编号</html:option>
  					<html:option value="dwmc">单位名称</html:option>
  					<html:option value="ssjg">所属机构</html:option>
  					<html:option value="khjl">客户经理</html:option>
  					<html:option value="khjb">客户级别</html:option>
  					<html:option value="lxr">联 系 人</html:option>
  					<html:option value="khdz">客户地址</html:option>
  					<html:option value="hysx">行业属性</html:option>	
  				</html:select>
  			</td>
  			<td align="right" width="15%"><b>查询字段值：</b></td>
  			<td align="left" width="20%"><html:text property="fieldValue" styleClass="input"></html:text></td>
  			<td align="left" ><input type="submit" name="su" value="查 询" class="inputbutton"/></td>
  		</tr>
  	</table>
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>客户编号</th>
	    		<th>单位名称</th>
	    		<th>客户经理</th>
	    		<th>联 系 人</th>
	    		<th>客户级别</th>
	    		<th>停止往来</th>
	    		<th>操 作</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.khzj }" ${obj.ssxs==0?"disabled":"" }/></td>
		   		<td>
		   		<a href="<%=request.getContextPath()%>/khxx.do?method=view&pk=${obj.khzj }">${obj.khbh }</a>
		   		</td>
		   		<td>${obj.dwmc }</td>
		   		<td>${obj.khjl }</td>
		   		<td>${obj.lxr }</td>
		   		<td>${obj.khjb }</td>	   	
		   		<td>
		   			<c:if test="${obj.sftzwl==0 }">
		   				否
		   			</c:if>
		   			<c:if test="${obj.sftzwl!=0 }">
		   				是
		   			</c:if>
		   		</td>	
		   		<td>
		   		<c:if test="${obj.ssxs!=0 and obj.sssysz!=0}">
		   		<a href="<%=request.getContextPath()%>/khxx.do?method=goUpdate&pk=${obj.khzj }" onclick="return check(${obj.ssxs });">修 改</a>
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="8" align="center">
    			暂无客户资料信息!
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
