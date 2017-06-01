<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/sjxx.do?method=gotoAdd"
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
				form.action="<%=request.getContextPath() %>/sjxx.do?method=delObject";
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
				window.location.href="<%=request.getContextPath()%>/sjxx.do?method=objList&page="+page;
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
  <html:form action="/sjxx.do?method=delObject" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>任务编号</th>
	    		<th>任务名称</th>
	    		<th>发布时间</th>
	    		<th>发布状态</th>
	    		<th>操作状态</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td width="10%"><input type="checkbox" name="pk" value="${obj.sjzj }" <c:if test="${obj.cjrzj!=userPk}">disabled="disabled"</c:if>/></td>
		   		<td width="15%"><a href="<%=request.getContextPath()%>/sjxx.do?method=viewObject&pk=${obj.sjzj}">${obj.sjbh }</a></td>
		   		<td width="25%">${obj.sjmc }</td>
		   		<td width="25%">${obj.cjsj }</td>
		   		<td width="10%">
		   			<c:if test="${obj.cjrzj!=userPk}">
			   			<c:if test="${obj.sjzt==0}">
			   				<font color="#ff0000">禁用</font>
			   			</c:if>
			   			<c:if test="${obj.sjzt!=0}">
			   				<font color="#0000ff">开启</font>
			   			</c:if>
		   			</c:if>
		   			<c:if test="${obj.cjrzj==userPk}">
			   			<c:if test="${obj.sjzt==0}">
			   				<a href="<%=request.getContextPath()%>/sjxx.do?method=updSjzt&pk=${obj.sjzj }&state=${(obj.sjzt+1)%2}"><font color="#ff0000">禁用</font></a>
			   			</c:if>
			   			<c:if test="${obj.sjzt!=0}">
			   				<a href="<%=request.getContextPath()%>/sjxx.do?method=updSjzt&pk=${obj.sjzj }&state=${(obj.sjzt+1)%2}"><font color="#0000ff">开启</font></a>
			   			</c:if>
		   			</c:if>
		   		</td>
		   		<td width="15%">
		   			<c:if test="${obj.cjrzj==userPk}">
		   			<a href="<%=request.getContextPath()%>/sjxx.do?method=gotoUpd&pk=${obj.sjzj }">修改</a>
		   			</c:if>		   			
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无任务信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
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
