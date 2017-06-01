<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	var tempId = null;
    	function selAll(){
		    var o=document.getElementsByName("pk"); 
		     for(i=0;i<o.length;i++) {
			 	if(!o[i].disabled){
			       o[i].checked=event.srcElement.checked; 
			     }
			 }
		}
		function handSetRule(sid){
			tempId=sid;
			document.getElementById("show-btn").click();
		}
		function setValue(){
			var expNum = /^[0-9]+$/;
			var gid="";
			var flag =false;
			var rpk = document.getElementsByName("rpk");			
			for(var i=0;i<rpk.length;i++){
				if(rpk[i].checked){
					gid += "&rpks="+rpk[i].value;
					if(!flag)
					 flag = true;
				}
			}
			if(tempId==null || !expNum.test(tempId)){
				flag = false;
			}
			if(flag){
				window.location.href="./testSetup.do?method=groupSetup&spk="+tempId+gid;				
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
  <html:form action="/testSetup.do?method=xsxxList" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th style="text-align:center;">全 选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th style="text-align:center;">学 号</th>	    		
	    		<th style="text-align:center;">学生姓名</th>
	    		<th style="text-align:center;">权 限</th>
	    		<th style="text-align:center;">有效标记</th>
	    		<th style="text-align:center;">权限设置<input type="hidden" id="show-btn"></th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="list">
    	<logic:iterate id="obj" name="list">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.xszj }"/></td>
		   		<td>${obj.xsxh }</td>		   		
		   		<td>${obj.xsxm }</td>
		   		<td>
		   		<c:forEach var="gw" items="${obj.xsgwxxes }">
		   			${gw.id.gwxx.gwmc } 
		   		</c:forEach>
		   		</td>		   		
		   		<td>
		   			<c:if test="${obj.yxbj==1}">
		   				<font color="#0000ff">有效</font>
		   			</c:if>
		   			<c:if test="${obj.yxbj!=1}">
		   				<font color="#ff0000">无效</font>
		   			</c:if>
		   		</td>
		   		<td>
		   		<a href="#" onclick="handSetRule('${obj.xszj}');">权限设置</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="list">
    		<tr>
    		<td colspan="9" align="center">
    			暂无组员信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="9" align="center">
    			<input type="button" name="fanhui" class="inputbutton" value="返 回" onclick="window.location.href='./testSetup.do?method=groupList'">
    		</td>
    	</tr>
    </table>
    <div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1">
           <table border="0" width="100%" style="word-break:break-all;">
    			<tr align="center">
    				<td>选 择</td>
    				<td>角 色</td>
    			</tr>
    			<c:if test="${rlist!=null && fn:length(rlist)>0 }">
	    			<c:forEach var="ruleObj" items="${rlist}">
		   				<tr align="center">
		    				<td><input type="checkbox" name="rpk" value="${ruleObj.gwzj }"/></td>
		    				<td>${ruleObj.gwmc }</td>
		    			</tr>
	    			</c:forEach>
    			</c:if>
    			<c:if test="${rlist==null || fn:length(rlist)==0 }">
    				<tr align="center">
	    				<td colspan="2">暂无角色信息!</td>
	    			</tr>
    			</c:if>
    		</table>
           </div>
        </div>
    </div>
    </html:form>    
  </body>
</html>
