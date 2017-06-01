<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function IsNull(){
    		var jsbh = document.all("vo.jsbh");
    		var jsmc = document.all("vo.jsmc");
    		var jsmm = document.all("vo.jsmm");
    		var exp = /^\w+$/;
    		if(!exp.test(jsbh.value)){
    			alert("教师工号由字母和数字组成!");
    			return false;
    		}
    		if(jsmc.value==""){
    			alert("请输入教师登陆名!");
    			return false;
    		}
    		if(!exp.test(jsmm.value)){
    			alert("教师密码由字母和数字组成!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/teacher.do?method=teaList&page=1";
    	}
    	  	
    </script> 
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
    <html:form action="/jsgl.do?method=updPaw" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption>教师管理</caption>
    		<tr>
    			<td width="40%" align="right">教师编号&nbsp;&nbsp;</td>
    			<td><html:hidden property="vo.jxzj"/>
    				<html:text property="vo.jsbh" styleClass="input"  readonly="true"/>
    				<div id="jsbh"></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">教师名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.jsmc" styleClass="input" />
    			<input type="hidden" name="oldName" value="${teacherForm.vo.jsmc }"/>
    				<div id="jsmc"></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">登陆密码&nbsp;&nbsp;</td>
    			<td><html:text property="vo.jsmm" styleClass="input"/></td>
    		</tr>
    		<tr>
    			<td align="right">教师类型&nbsp;&nbsp;</td>
    			<td>
    			<html:select property="vo.jslx" style="width:100pt;">
	    			<c:if test="${userType==1 }">
    					<html:option value="1">教师</html:option>
    				</c:if>
    				<c:if test="${userType==0 }">
    					<html:option value="0">管理员</html:option>
    				</c:if>  
    			</html:select>
    			</td>
    		</tr>    		
    		<tr>
    			<td align="right">备注说明&nbsp;&nbsp;</td>
    			<td><html:hidden property="vo.kfxg"/>
    				<html:textarea property="vo.bzxx" cols="30" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<html:reset styleClass="inputbutton">重 置</html:reset>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
