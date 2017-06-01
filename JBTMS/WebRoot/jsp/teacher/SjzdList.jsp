<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <style type="text/css">
    	td{
    		height: 50pt;
    	}
    </style>   
  </head>
  
  <body>
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;" >
    	<tr >
    	<logic:notEmpty name="sjzdlist">
    		<logic:iterate id="sjzd" name="sjzdlist" indexId="i">
    			<c:if test="${(i+1)%4==0 }">
    				<td align="center" height="35"><img src="./images/gif.gif">　<a href="./sjzdmx.do?method=sjzdmxList&sjzd.sjzdzj=${sjzd.sjzdzj }&vo.fqzj=0">${sjzd.sjzdmc }</a></td>
    				</tr>
    			</c:if>
    			<c:if test="${(i+1)%4!=0 }">
    				<td align="center" height="35"><img src="./images/gif.gif">　<a href="./sjzdmx.do?method=sjzdmxList&sjzd.sjzdzj=${sjzd.sjzdzj }&vo.fqzj=0">${sjzd.sjzdmc }</a></td>
    			</c:if>
    		</logic:iterate>
    		<c:forEach var="k" begin="1" end="${4-fn:length(sjzdlist)%4}">
    			<td align="center" height="35"></td>
    		</c:forEach>
    	</logic:notEmpty>
    </table>
  </body>
</html>
