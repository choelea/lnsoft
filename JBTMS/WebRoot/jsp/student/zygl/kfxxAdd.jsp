<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript" src="./js/kfxx.js"></script>    
  </head>
  
  <body>
    <html:form action="/kfxx.do?method=addObject" method="post" onsubmit="return IsNull();">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>库房管理</center></caption>
    		<tr >
    			<td width="30%"  align="right" >仓库编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.kfbh" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<input type="hidden" name="show-btn">
    			</td>
    			<td width="15%" align="right">仓库名称&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfmc" styleClass="input" onblur="valiValue(this,'kfmc','${userPk }','${userSyszzj }')"/>
    				<span id="kfmc"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >拼 音 码&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.pym" styleClass="input" readonly="true" onclick="getPym(this);"/>
    			</td>
    			<td align="right" >库房类型&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kflx" styleClass="input" readonly="true"/>
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="setKflx();"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >长度(米)&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfcd" styleClass="input"/>
    			</td>
    			<td align="right" >宽度(米)&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfkd" styleClass="input"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >高度(米)&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfgd" styleClass="input"/>
    			</td>
    			<td align="right" >仓库面积(㎡)&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfmj" styleClass="input" readonly="true" onclick="countArea();"/>
    			</td>
    			
    		</tr>
    		<tr>
    			<td align="right" >通道宽度(米)&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.tdkd" styleClass="input"/>
    			</td>
    			<td align="right" >旋转半径(米)&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.xzbj" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >管 理 员&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfgly" styleClass="input" readonly="true"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="setKfgly('${userPk }','${userSyszzj }');"/>
    			</td>
    			<td align="right" >联系电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.kflxdh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >详细地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:text property="vo.kfxxdz" styleClass="inputlong"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >库房状态&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kfzt" styleClass="input" readonly="true"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="setKfzt();"/>
    			</td>
    			<td align="right" >所属站点&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
					<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
<%--					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="setSsjg();"/>--%>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >备 注&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="60" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" >
    				<html:submit styleClass="inputbutton">添 加</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>    				
    			</td>
    		</tr>
    	</table>
	</html:form>
	<div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1">
           
            </div>
    	</div>
	</div>
  </body>
</html>
