<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" /></title>
		
		
	</head>
	<body>
		<html:form action="/class.do?method=saveObject" onsubmit="return isNull()">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<tr height="40px">
					<td colspan="2" align="center">
					 <span class="bt">班级信息</span>
					</td>
				</tr>
				<tr height="35px">
					<td align="right" width="40%">
						班级编号&nbsp;&nbsp;
					</td>
					<td>
						<html:text styleClass="input" property="vo.bjbh"
							readonly="true"></html:text>
						&nbsp;&nbsp;&nbsp;
						<span id="bhspan"></span>
					</td>
				</tr>

				<tr height="35px">
					<td align="right">
						班级名称&nbsp;&nbsp;
					</td>
					<td>

						<html:text styleClass="input" property="vo.bjmc" readonly="true"></html:text>
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
					</td>
				</tr>
				<tr height="35px">
					<td align="right">
						备&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;
					</td>
					<td>
						<html:textarea property="vo.bzxx" cols="40" rows="4" readonly="true"></html:textarea>
					</td>
				</tr>
				<tr height="35px">
					<td colspan="2" align="center">
						<input type="button" name="fanhui" value="返 回" class="inputbutton"
							onclick="window.location.href='<%=request.getContextPath()%>/class.do?method=getList'">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>

