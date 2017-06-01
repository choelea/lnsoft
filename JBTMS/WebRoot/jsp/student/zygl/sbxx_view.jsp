<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
			function back(){
				window.location.href="<%=request.getContextPath()%>/sbxx.do?method=getList&rmMsg=true";
			}
		</script>

  </head>
  
  <body>
     <html:form action="/sbxx.do?method=getList" method="post">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>设备信息</center></caption>
  			<tr>
  				<td width="25%" align="right">设备编号&nbsp;&nbsp;</td>
  				<td width="25%">
  					<html:text property="vo.sbbh" styleClass="input" readonly="true"/>
  				</td>
  				<td width="20%" align="right">所在仓库&nbsp;&nbsp;</td>
  				<td>
  					<input type="text" name="kfbh" readonly="readonly" value="${kfbh }" class="input">
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备类型&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.sblx" styleClass="input" readonly="true"/>
  				</td>
  				<td align="right">动力类型&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.dllx" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">可载货长(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhc" styleClass="input" readonly="true"/></td>
  				<td align="right">可载货宽(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhk" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">可载货高(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhg" styleClass="input" readonly="true"/></td>
  				<td align="right">底盘高度(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.dpgd" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">载重量(吨)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.zzl" styleClass="input" readonly="true"/></td>
  				<td align="right">颜 色&nbsp;&nbsp;</td>
  				<td><html:text property="vo.ys" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">使用状态&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.sbzt" styleClass="input" readonly="true"/>
  				</td>
  				<td align="right">燃油类型&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.rylx" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备价值&nbsp;&nbsp;</td>
  				<td><html:text property="vo.sbjz" styleClass="input" readonly="true"/></td>
  				<td align="right">功 率(W)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.gl" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">购买日期&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.gmrq" styleClass="input" readonly="true" />
  				</td>
  				<td align="right">生产厂商&nbsp;&nbsp;</td>
  				<td><html:text property="vo.sccj" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">备 注&nbsp;&nbsp;</td>
  				<td colspan="3"><html:textarea property="vo.bzxx" rows="4" cols="50" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">
  			</tr>
  		</table>
  	</html:form>
  </body>
</html>
