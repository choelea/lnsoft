<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function back(){
    		window.location.href="./sjzdmx.do?method=sjzdList";
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
				window.location.href="./sjzdmx.do?method=sjzdmxList&page="+page+"&sjzd.sjzdzj=${objPk}&vo.fqzj=${fqPk}";
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
  <html:form action="/sjzdmx.do?method=delObject" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>编 号</th>
	    		<th>公 式</th>
	    		<th>可否操作</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata" indexId="i">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.sjzdmxzj }" <c:if test="${obj.kfcz==0 }">disabled="disabled"</c:if>/></td>
		   		<td>${i+1 }</td>
		   		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;${obj.sjzdmxbh }${obj.sjzdmxmc }=${obj.field1 }${obj.field2 }</td>
		   		<td>
		   		<c:if test="${obj.kfcz==0 }">
		   			否
		   		</c:if>
		   		<c:if test="${obj.kfcz!=0 }">
		   			是
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无参数信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
    			<input type="button" value="返 回" onclick="back();" class="inputbutton"/>
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
