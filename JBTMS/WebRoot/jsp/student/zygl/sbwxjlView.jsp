<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
<head>
<title><bean:message key="system.title"/></title>
	<script type="text/javascript">		
		function back(){
			window.location.href="./sbwxjl.do?method=objList";
		}
	</script>
  </head>
  
  <body>
    <html:form action="/sbwxjl.do?method=viewObject" method="post">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>设备维修管理</center></caption>
  			<tr>
  				<td width="25%" align="right">设备维修编号&nbsp;&nbsp;</td>
  				<td width="25%">
  					<html:text property="vo.sbwxjlbh" styleClass="input" readonly="true"/>
  					<html:hidden property="vo.sssysz"/>
  					<html:hidden property="vo.ssxs"/>
  					<html:hidden property="vo.ssxtmk"/>
  					<html:hidden property="vo.sbwxjlzj"/>
  					<input type="hidden" name="show-btn">
  				</td>
  				<td width="20%" align="right">设备编号&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.sbbh" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备类型&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.sblx" styleClass="input" readonly="true"/>
  				</td>
  				<td align="right">维修日期&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.wxrq" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">自修耗时(小时)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.zxhs" styleClass="input" readonly="true"/></td>
  				<td align="right">维修费用&nbsp;&nbsp;</td>
  				<td><html:text property="vo.wxfy" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">维修方式&nbsp;&nbsp;</td>
  				<td><html:text property="vo.xlfs" styleClass="input" readonly="true"/></td>
  				<td align="right">维修人员&nbsp;&nbsp;</td>
  				<td><html:text property="vo.xlry" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">所属机构&nbsp;&nbsp;</td>
  				<td><html:text property="vo.ssjg" styleClass="input" readonly="true"/></td>
  				<td align="right">制 单 人&nbsp;&nbsp;</td>
  				<td><html:text property="vo.zdr" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">维修原因&nbsp;&nbsp;</td>
  				<td colspan="3"><html:textarea property="vo.wxyy" rows="4" cols="50"/></td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">  					
  				</td>
  			</tr>
  		</table>
  	</html:form>
  </body>
</html>