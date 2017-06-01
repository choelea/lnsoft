<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" /></title>
	</head>
	<body>
		<html:form action="/jsgl.do?method=updateObject" onsubmit="return isNull()">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<tr height="40px">
					<td colspan="2" align="center">
						<span class="bt">教师信息</span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right" width="40%">
						教师工号&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsbh" readonly="true"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="bhspan" class="spts"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						教师姓名&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsmc"  readonly="true"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="mcspan" class="spts"></span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						登陆密码&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.jsmm"  readonly="true"></html:text>
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
						<html:textarea property="vo.bzxx" cols="40" rows="4"  readonly="true"></html:textarea>
					</td>
				</tr>
				<tr height="35px">
					<td colspan="2" align="center">
						<input type="button" name="fanhui" value="返 回" class="inputbutton"
							onclick="window.location.href='<%=request.getContextPath()%>/jsgl.do?method=getList'">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
