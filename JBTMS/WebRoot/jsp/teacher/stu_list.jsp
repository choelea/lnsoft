<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/student.do?method=goAdd&sign=2&bjzj=${bjzj}&page=${page}"
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
				form.action="<%=request.getContextPath() %>/student.do?method=delObject&bjzj=${bjzj}&page=${page}";
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
				window.location.href="<%=request.getContextPath()%>/student.do?method=getList&bjzj=${bjzj}&page="+page;
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
  <html:form action="/student.do?method=queryList&bjzj=${bjzj}" method="post">
  <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="20%">
  			<b>查询字段名：</b>
  			</td>
  			<td align="left" width="25%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="xsxh">学 号</html:option>
  					<html:option value="xsxm">学生姓名</html:option>
  				</html:select>
  			</td>
  			<td align="right" width="15%"><b>查询字段值：</b></td>
  			<td align="left" width="20%"><html:text property="fieldValue" styleClass="input"></html:text>
  			</td>
  			<td align="left" ><input type="submit" name="su" value="查 询" class="inputbutton"/></td>
  		</tr>
  	</table>
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全 选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>学 号</th>	    		
	    		<th>学生姓名</th>
	    		<th>登陆密码</th>
	    		<th>有效标记</th>
	    		<!-- 
	    			<th>登陆状态</th>
	    		 -->	    		
	    		<th>操 作</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.xszj }"/></td>
		   		<td><a href="<%=request.getContextPath()%>/student.do?method=viewObject&bjzj=${bjzj }&pk=${obj.xszj}&page=${page }">${obj.xsxh }</a></td>		   		
		   		<td>${obj.xsxm }</td>
		   		<td>${obj.xsmm }</td>		   		
		   		<td>
		   			<a href="<%=request.getContextPath()%>/student.do?method=updYxbj&stuPk=${obj.xszj}&bjzj=${bjzj}&state=${(obj.yxbj+1)%2}&page=${page}">
		   			<c:if test="${obj.yxbj==1}">
		   				<font color="#0000ff">有效</font>
		   			</c:if>
		   			<c:if test="${obj.yxbj!=1}">
		   				<font color="#ff0000">无效</font>
		   			</c:if>
		   			</a>
		   		</td>
		   			   		
		   		<td>		   		
		   		<a href="<%=request.getContextPath()%>/student.do?method=goUpdate&bjzj=${bjzj }&pk=${obj.xszj}&page=${page }">修 改</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="9" align="center">
    			暂无学生信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="9" align="center">
    			<input type="button" value="导 入" onclick="window.location.href='<%=request.getContextPath()%>/student.do?method=gotoDr&bjzj=${bjzj }'" class="inputbutton"/>
    			<input type="button" value="添 加" onclick="toadd();" class="inputbutton"/>
    			<input type="button" value="删 除" onclick="return todel();" class="inputbutton"/>
    			<input type="button" name="fanhui" class="inputbutton" value="返 回"
							onclick="window.location.href='<%=request.getContextPath()%>/class.do?method=getListForStu'">
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
