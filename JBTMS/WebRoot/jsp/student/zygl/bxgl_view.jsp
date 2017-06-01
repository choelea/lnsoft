<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
<head>
<title><bean:message key="system.title"/></title>
<script type="text/javascript">
	var m = 0;
	function back(){
		window.location.href="<%=request.getContextPath()%>/bxgl.do?method=getList";
	}
</script>
  </head>
  <body>
  	<html:form action="/bxgl.do?method=query" method="post">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>班线信息</center></caption>
  			<tr>
  				<td align="right" width="25%">班线编号&nbsp;&nbsp;</td>
  				<td colspan="3">
  					<html:text property="vo.bxbh" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">起始站点&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.sfz" styleClass="input" readonly="true"/>
  				</td>
  				<td align="right">目的站点&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.mdz" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">班线描述&nbsp;&nbsp;</td>
  				<td colspan="3">
  					<html:textarea property="vo.bxms" cols="50" rows="5" readonly="true"></html:textarea>
  				</td>
  			</tr>
  			<c:if test="${!empty list}">
  				<tr>
  					<td align="center" colspan="4">
	  					<table id="zhongzhuan" align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
	  						<tr>
	  							<td align="center" colspan="3">中转站
	  						</tr>
	  						<tr>
	  							<td align="center">地区名称</td>
	  							<td align="center">停车顺序</td>
	  							<td align="center">操 作</td>
	  						</tr>
	  						<c:forEach var="obj" items="${list }">
	  							<tr>
	  								<td align="center">${obj.bxzd}</td>
	  								<td align="center">${obj.tksx }</td>
	  								<td></td>
	  							</tr>
	  						</c:forEach>
	  					</table>
  					</td>
  				</tr>
  			</c:if>
  				
  			<tr>
  				<td colspan="4" align="center">
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">
  				</td>
  			</tr>
  		</table>
  	</html:form>
  </body>
</html>
