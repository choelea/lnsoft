<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function toadd(){
    		window.location.href="<%=request.getContextPath()%>/ggxx.do?method=gotoAdd"
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
				form.action="<%=request.getContextPath() %>/ggxx.do?method=delObject";
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
				window.location.href="<%=request.getContextPath()%>/ggxx.do?method=getList&page="+page;
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
  <html:form action="/ggxx.do?method=delObject" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>公告标题</th>
	    		<th>所属班级</th>
	    		<th>发布作者</th>
	    		<th>发布时间</th>
	    		<th>操 作</th>
	    	</tr>
    	</thead>
    	<c:if test="${!empty pageinfo.pagedata}">
			<c:forEach var="obj" items="${pageinfo.pagedata}">
		   	<tr align="center">
		   		<td width="10%"><input type="checkbox" name="pk" value="${obj.ggzj }"/></td>
		   		<td width="30%"><a href="<%=request.getContextPath()%>/ggxx.do?method=viewObject&pk=${obj.ggzj}">${obj.ggbt }</a></td>
		   		<td width="15%">${obj.bjxx.bjmc }</td>
		   		<td width="15%">${obj.ggzz }</td>
		   		<td width="20%">${obj.fbsj }</td>
		   		<td width="10%">
		   			<a href="<%=request.getContextPath()%>/ggxx.do?method=gotoUpd&pk=${obj.ggzj }">修 改</a>
		   		</td>
		   	</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty pageinfo.pagedata}">
    		<tr>
    		<td colspan="7" align="center">
    			暂无公告信息!
    		</td>
    	</tr>
    	</c:if>
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
