﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %> 
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/fn.tld" prefix="fn" %>
<html>
<head>
<title><bean:message key="system.title"></bean:message></title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript">
	function comm(){
		var jiaose = document.all("loginType");
		if(jiaose.value=='1'){
			alert("请选择角色!");
			return false;
		}
		var username = document.all("userName");
		var password = document.all("password");
		if(username.value==""){
			alert("请输入登陆用户名!");
			return false;
		}
		if(password.value==""){
			alert("请输入登陆密码!");
			return false;
		}
		var form = window.document.forms[0];
		form.action = "<%=request.getContextPath()%>/login.do?method=login";
		form.method= "post";
		form.submit();
	}
	function rest(){
	  var form = window.document.forms[0];
	  form.reset();
	  document.all("userName").value="";
	  document.all("password").value="";
	}
	document.onkeydown = function(){
		if(event.keyCode=='13'){
			comm();
		};
	}
</script>
	<c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
</head>
<body  bgcolor="#cee2ed" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="text-align: center;">
<html:form action="/login.do?method=login" method="post">
<table id="__01" width="1003" height="612" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="7">
			<img src="images/login/log-in_01.jpg" width="1002" height="228" alt=""></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="228" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login/log-in_02.jpg" width="540" height="154" alt=""></td>
		<td colspan="3"
			background="images/login/log-in_03.jpg" width="198" height="154" alt=""><table width="160" border="0">
          <tr>
            <td width="160" height="30"></td>
          </tr>
          <tr>
            <td width="160" height="30"><html:text property="userName" style="width:150px"/></td>
          </tr>
          <tr>
            <td width="160" height="30"><html:password property="password" style="width:150px"/></td>
          </tr>
          <tr>
            <td width="160" height="30"><html:select property="loginType" style="width:150px">
                    <html:option value="1">--请选择角色--</html:option>
                    <html:option value="stuLogin">学生</html:option>
    				<html:option value="teaLogin">教师</html:option>
    				<html:option value="adminLogin">管理员</html:option>
            </html:select></td>
          </tr>
        </table></td>
		<td rowspan="4">
			<img src="images/login/log-in_04.jpg" width="264" height="344" alt=""></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="154" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/log-in_05.jpg" width="494" height="1" alt=""></td>
		<td rowspan="2">
			<a href="#"> <img src="images/login/log-in_06.jpg" width="44" height="21" style="cursor:hand;" border="0" onclick="comm();"></a></td>
		<td>
			<img src="images/login/log-in_07.jpg" width="2" height="1" alt=""></td>
		<td rowspan="3">
			<img src="images/login/log-in_08.jpg" width="64" height="190" alt=""></td>
		<td rowspan="2">
			<a href="#"> <img src="images/login/log-in_09.jpg" width="44" height="21" style="cursor:hand;" border="0" onclick="rest()"></a></td>
		<td rowspan="3">
			<img src="images/login/log-in_10.jpg" width="90" height="190" alt=""></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login/log-in_11.jpg" width="494" height="189" alt=""></td>
		<td rowspan="2">
			<img src="images/login/log-in_12.jpg" width="2" height="189" alt=""></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="20" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/login/log-in_13.jpg" width="44" height="169" alt=""></td>
		<td>
			<img src="images/login/log-in_14.jpg" width="44" height="169" alt=""></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="169" alt=""></td>
	</tr>
	<tr>
		<td colspan="7" background="images/login/log-in_15.jpg" width="1002" height="40" align="center">
			 <span style="font-size: 12px;">版权所有：武汉骏邦信息科技有限公司 </span></td>
		<td>
			<img src="images/login/分隔符.gif" width="1" height="40" alt=""></td>
	</tr>
</table>
</html:form>
</body>
</html>