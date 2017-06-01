<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript" src="./js/kfxx.js"></script>    
  </head>
  
  <body>
    <html:form action="/kfxx.do?method=viewObject" method="post">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>库房管理</center></caption>
    		<tr >
    			<td width="30%"  align="right" >仓库编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.kfbh" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.kfzj"/>
    				<input type="hidden" name="show-btn">
    			</td>
    			<td width="15%" align="right">仓库名称&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfmc" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >拼 音 码&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.pym" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >库房类型&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kflx" styleClass="input" readonly="true"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >长度(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfcd" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >宽度(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfkd" styleClass="input" readonly="true"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >高度(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfgd" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >仓库面积(㎡)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfmj" styleClass="input" readonly="true"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >通道宽度(米)&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.tdkd" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >旋转半径(米)&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.xzbj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >管 理 员&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfgly" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >联系电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kflxdh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >详细地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:text property="vo.kfxxdz" styleClass="inputlong" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >库房状态&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kfzt" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >所属站点&nbsp;&nbsp;</td>
    			<td>
					<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >备 注&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="60" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" >
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>    				
    			</td>
    		</tr>
    	</table>
	</html:form>
  </body>
</html>
