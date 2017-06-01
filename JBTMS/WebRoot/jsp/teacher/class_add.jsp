<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" /></title>
		<script type="text/javascript">
		var flag1 = false;
		function isNull(){
			var bjbh = document.getElementById("vo.bjbh");
			var bjmc = document.getElementById("vo.bjmc");
			var xxmc = document.all("vo.xxmc");
			var charVail = /^[A-Za-z0-9]+$/;
			var nameVail = /\w/;
			var bhv = /^[0-9]{2}$/;
			if(bjbh.value==""){
				bhspan.innerHTML="<font size=3px' color='red'>请输入班级编号！</front>";
				return false;
			}else if(!charVail.test(bjbh.value)){
				bhspan.innerHTML="<font size=3px' color='red'>班级编号只能是数字或字母！</front>";
				return false;
			}else{
				bhspan.innerHTML="";
			}
			if(bjmc.value==""){
				mcspan.innerHTML="<font size=3px' color='red'>请输入班级名称！</front>";
				return false;
			}else{
			    mcspan.innerHTML="";
			}
			if(xxmc.value==""){
				xxspan.innerHTML="<font size=3px' color='red'>请输入学校名称！</front>";
				return false;
			}else{
			    xxspan.innerHTML="";
			}
			if(flag1){
				bhspan.innerHTML="<font size=3px' color='red'>班级编号已存在！</front>";
				return false;
			}

		}
		function testTeachInfo(param1,param2,param3){
			if(param2!=""){
				UserDWR.isExistBjxx(0,param1,param2,cd1);
			}
		}
		function cd1(data){
			flag1 = data;
			var bjbh = document.getElementById("vo.bjbh");
			if(flag1){
				bhspan.innerHTML="<font size=3px' color='red'>班级编号已存在！</front>";
			}else{
				bhspan.innerHTML="";
			}
		}
		</script>
		<script type="text/javascript" language="javascript"
			src="<%=request.getContextPath()%>/js/popcalendar.js"></script>
	</head>
	<body>
		<html:form action="/class.do?method=saveObject" onsubmit="return isNull()">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<tr height="40px">
					<td colspan="2" align="center">
					<span class="bt">班级信息添加</span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right" width="40%">
						班级编号&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.bjbh"
							onblur="testTeachInfo('bjbh',this.value,'1')"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="bhspan"></span>
					</td>
				</tr>

				<tr height="35px">
					<td align="right">
						班级名称&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.bjmc"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="mcspan"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						学校名称&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.xxmc"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="xxspan"></span>
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
						<input type="submit" name="tijiao" value="添 加" class="inputbutton">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" name="fanhui" value="返 回" class="inputbutton"
							onclick="window.location.href='<%=request.getContextPath()%>/class.do?method=getList'">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>

