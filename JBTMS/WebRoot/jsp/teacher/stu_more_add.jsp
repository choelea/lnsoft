<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>

<html>
	<head>
		<title>学生信息添加</title>
		<link href="<%=request.getContextPath()%>/css/newdate.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function goback(){
				window.location.href="<%=request.getContextPath()%>/student.do?method=getList&bjzj=${bjzj}&page=${page}"
			}
			function isNull(){
				var sj = document.all("sj");
	    		var xy = document.all("xy");
	    		var zy = document.all("zy");
				var zcsl = document.getElementById("zcsl");
				var xsmm = document.getElementById("vo.xsmm");
				var rxsj = document.all("vo.rxsj");
				var exp = /^\w+$/;
				var intexp = /^[0-9]+$/;
				var sjv = /^[0-9]{4}$/;
    			var xzv =/^[0-9]{2}$/;
				if(xsmm.value==""){
					mmsp.innerHTML="请输入登陆密码！";
					xsmm.focus();
					return false;
				}else{
					mmsp.innerHTML="";
				}
				if(!exp.test(xsmm.value)){
					mmsp.innerHTML="密码只能由字母和数字组成！";
					xsmm.focus();
					return false;
				}else{
					mmsp.innerHTML="";
				}
				
				if(zcsl.value==""){
					zcsp.innerHTML="请输入注册数量！";
					zcsl.focus();
					return false;
				}else{
					zcsp.innerHTML="";
				}
				if(!intexp.test(zcsl.value)){
					zcsp.innerHTML="注册数量只能是整数！";
					zcsl.focus();
					return false;
				}else{
					zcsp.innerHTML="";
				}
				
				if(parseInt(zcsl.value)<1){
					zcsp.innerHTML="注册数量不能小于0！";
					zcsl.focus();
					return false;
				}else{
					zcsp.innerHTML="";
				}
				
				if(parseInt(zcsl.value)>100){
					zcsp.innerHTML="一次注册数量不能大于100人！";
					zcsl.focus();
					return false;
				}else{
					zcsp.innerHTML="";
				}
			}
			
		</script>
	</head>
	<body>
		<html:form action="/student.do?method=saveMoreObject&page=${page}" method="post" onsubmit="return isNull()">
			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>学生注册</center></caption>
    		<tr>
    			<td align="right" width="40%" class="td2">班级编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.xsxh" styleClass="input" readonly="true" />
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">登陆密码&nbsp;&nbsp;</td>
    			<td><html:text property="vo.xsmm" styleClass="input"/>
    			<span id="mmsp" class="spts"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="40%" class="td2">注册数量&nbsp;&nbsp;</td>
    			<td><!-- 此处sfdl本应表示学生登陆状态，此处暂时用于表示注册学生数量 -->
    				<html:text property="zcsl" styleClass="input"/>
    				<span id="zcsp" class="spts"></span>
    			</td>
    		</tr>
    		 
    		<tr>
    			<td align="right" class="td2">有效标记&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.yxbj" style="width:100pt">
    					<html:option value="1">有效</html:option>
    					<html:option value="0">无效</html:option>
    				</html:select>
    			</td>
    		</tr>
   			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="bjzj" value="${bjzj }"/>
					<html:submit styleClass="inputButton">添 加</html:submit>
					<input type="button" value="返 回" class="inputButton" onclick="goback()">
				</td>
			</tr>
		</table>
		</html:form>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
	</body>
</html>

