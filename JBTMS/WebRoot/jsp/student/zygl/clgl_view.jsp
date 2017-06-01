<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
     function back(){
    	window.location.href="<%=request.getContextPath()%>/clgl.do?method=getList";
     }
    </script> 
  </head>
  
  <body>
    <html:form action="/clgl.do?method=view" method="post">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>运力信息</center></caption>
    		<tr>
    			<td width="35%"  align="right">车辆编号&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.ylbh" styleClass="input" readonly="true"/>
    			</td>
    			<td width="15%" align="right">车牌号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.cph" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">可载货长(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kzhc" styleClass="input" readonly="true"/> 
    			</td>
    			<td align="right">可载货宽(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kzhk" styleClass="input" readonly="true"/>
    			</td>
    			
    		</tr>   
    		<tr>
    			<td align="right">可载货高(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kzhg" styleClass="input" readonly="true"/>
    			</td>
    				<td align="right">车容(立方米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdcr" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">最大单项尺寸(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zddxcc" styleClass="input" readonly="true"/>
    			</td>
    				<td align="right">核载(吨)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdhz" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    			<tr>
    			<td align="right">车的品牌&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.clpp" styleClass="input" readonly="true"/>
    			</td>
    				<td align="right">车辆类型&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.cllx" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		
    		<tr>	
    			<td align="right">车辆状态&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.syzt" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">车辆所属站点&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备注信息&nbsp;&nbsp;</td>
    			<td colspan="3"><html:textarea property="vo.bzxx" cols="50" rows="4" readonly="true"/></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
