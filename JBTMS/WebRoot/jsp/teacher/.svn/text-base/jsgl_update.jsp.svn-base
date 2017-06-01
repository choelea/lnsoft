<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title>My JSP 'teacher_list.jsp' starting page</title>
		<script type="text/javascript">
		var flag1 = false;
		function isNull(){
			var jsbh = document.getElementById("vo.jsbh");
			var jsmc = document.getElementById("vo.jsmc");
			var jsmm = document.getElementById("vo.jsmm");
			var charVail = /[A-Za-z0-9]+$/;
			var nameVail = /\w/;
			if(jsbh.value==""){
				bhspan.innerHTML="请输入教师工号！";
				jsbh.focus();
				return false;
			}else if(!charVail.test(jsbh.value)){
				jsbh.focus();
				bhspan.innerHTML="教师工号只能是数字或字母！";
				return false;
			}else{
				bhspan.innerHTML="";
			}
			
			if(jsmc.value==""){
				mcspan.innerHTML="请输入教师姓名！";
				jsmc.focus();
				return false;
			}else{
			    mcspan.innerHTML="";
			}
			if(jsmm.value==""){
				mmspan.innerHTML="请输入密码！";
				jsmm.focus();
				return false;
			}else if(!charVail.test(jsmm.value)){
				jsmm.focus();
				mmspan.innerHTML="密码只能是数字或字母！";
				return false;
			}else{
				mmspan.innerHTML="";
			}
			if(flag1){
				bhspan.innerHTML="教师工号已存在！";
				jsbh.focus();
				return false;
			}
		}
		function isExist(param1,param2){
			var param0 = document.getElementById("vo.jxzj").value;
			if(param2!=""){
				UserDWR.isExistJsxx(param0,param1,param2,cd1);
			}
		}
		function cd1(data){
			flag1 = data;
			var jsbh = document.getElementById("vo.jsbh");
			if(flag1){
				bhspan.innerHTML="教师工号已存在！";
				jsbh.focus();
			}else{
				bhspan.innerHTML="";
			}
		}
		</script>
	</head>
	<body>
		<html:form action="/jsgl.do?method=updateObject" onsubmit="return isNull()">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<tr height="40px">
					<td colspan="2" align="center">
						<span class="bt">教师信息修改</span>
				
					</td>
				</tr>
				<tr height="35px">
					<td align="right" width="40%">
						教师工号&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsbh"
							onblur="isExist('jsbh',this.value)"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="bhspan" class="spts"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						教师姓名&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsmc"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="mcspan" class="spts"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						登陆密码&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsmm"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="mmspan" class="spts"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						教师类型&nbsp;&nbsp;
					</td>
					<td>
						<html:radio property="vo.jslx" value="1">老师</html:radio>
						<html:radio property="vo.jslx" value="0">管理员</html:radio>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;
					</td>
					<td>
						<html:textarea property="vo.bzxx" cols="40" rows="4"></html:textarea>
					</td>
				</tr>
				<tr height="35px">
					<td colspan="2" align="center">
						<html:hidden property="vo.kfxg"/>
						<html:hidden property="vo.jxzj"/>
						<input type="submit" name="tijian" value="修 改" class="inputbutton">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" name="fanhui" value="返 回" class="inputbutton"
							onclick="window.location.href='<%=request.getContextPath()%>/jsgl.do?method=getList'">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
