<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
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
				window.location.href="./testSetup.do?method=xsxxLeaveList&page="+page;
			}
		}
		function sigleTest(){
			var stuPk = document.getElementsByName("pk");
			var flag = false;
			for(var i=0;i<stuPk.length;i++){
				if(stuPk[i].checked){
					flag=true;
					break;
				}
			}
			if(!flag){
				alert("请选择学生信息!");
			}
			return flag;
		}
    </script> 
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
  <html:form action="/testSetup.do?method=handSetup" method="post" onsubmit="return sigleTest();">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全 选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>学 号</th>	    		
	    		<th>学生姓名</th>
	    		<th>登陆密码</th>
	    		<th>有效标记</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.xszj }"/></td>
		   		<td>${obj.xsxh }</td>		   		
		   		<td>${obj.xsxm }</td>
		   		<td>${obj.xsmm }</td>		   		
		   		<td>
		   			<c:if test="${obj.yxbj==1}">
		   				<font color="#0000ff">有效</font>
		   			</c:if>
		   			<c:if test="${obj.yxbj!=1}">
		   				<font color="#ff0000">无效</font>
		   			</c:if>
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
    			<input type="submit" value="单人实验" class="inputbutton"/>
    			<input type="button" name="fanhui" class="inputbutton" value="返 回" onclick="window.location.href='./testSetup.do?method=groupList'">
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
