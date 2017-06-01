<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>    
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function subm(){
    		var form = window.document.forms[0];
    		var jlr='${jlr}';
    		if("jlr"==jlr){
    			form.action = "<%=request.getContextPath()%>/cwtj.do?method=ysJlrCwtj&kind=${kind }";
    		}else{
    			form.action = "<%=request.getContextPath()%>/cwtj.do?method=ysLrCwtj&kind=${kind }";
    		}
			form.method= "post";
			form.submit();
    	}
    </script>
  </head>
  
  <body>
  	<html:form action="/cwtj.do?method=ysLrCwtj&kind=${kind }" method="POST">
    <table align="center" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<html:select property="year">
					<c:forEach var="y" begin="2005" end="2020">
					<html:option value="${y}">${y}</html:option>
					</c:forEach>
				</html:select>
				年
				<html:select property="month">
					<html:option value="01">01</html:option>
					<html:option value="02">02</html:option>
					<html:option value="03">03</html:option>
					<html:option value="04">04</html:option>
					<html:option value="05">05</html:option>
					<html:option value="06">06</html:option>
					<html:option value="07">07</html:option>
					<html:option value="08">08</html:option>
					<html:option value="09">09</html:option>
					<html:option value="10">10</html:option>
					<html:option value="11">11</html:option>
					<html:option value="12">12</html:option>
				</html:select>
				月
				<c:if test="${'jlr'!=jlr}">
				<html:select property="type">
					<html:option value="pie">饼 图</html:option>
					<html:option value="bar">柱状图</html:option>
				</html:select>
				</c:if>
				<c:if test="${'jlr'==jlr}">
					<html:hidden property="type" value="bar"/>
				</c:if>
			</td>
			
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="显 示" class="inputbutton" onclick="subm()">
			</td>
			<td>
			&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="报 表" class="inputbutton" onclick="javaScript:window.location.href='<%=request.getContextPath() %>/cwtj.do?method=ysLrBb&kind=${kind }&ny=${ny }&jlr=${jlr }'">
			</td>
		</tr>
		</table>
	</html:form>
		<table align="center" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td id="map" align="center">
				<img src="${path}"/>
			</td>
		</tr>
		</table>
  </body>
</html>
