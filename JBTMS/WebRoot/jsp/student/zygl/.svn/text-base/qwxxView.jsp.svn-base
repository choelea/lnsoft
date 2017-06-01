<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript" src="./js/qwxx.js"></script>    
  </head>
  
  <body>
    <html:form action="/qwxx.do?method=viewObject" method="post">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>区位管理</center></caption>
    		<tr >
    			<td width="30%"  align="right" >区位编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.qwbh" styleClass="input" readonly="true"/>
    				<html:hidden property="kfxx.kfzj"/>
    				<html:hidden property="vo.qwzj"/>
    				<html:hidden property="vo.qfabm"/>
    				<html:hidden property="vo.amhs"/>
    				<html:hidden property="vo.amls"/>
    				<html:hidden property="vo.bmhs"/>
    				<html:hidden property="vo.bmls"/>
    				<html:hidden property="vo.sffpcw"/>
    				<input type="hidden" name="show-btn">
    			</td>
    			<td width="15%" align="right">区位名称&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.qwmc" styleClass="input" readonly="true"/>
    				<input type="hidden" name="oldName" value="${qwxxForm.vo.qwmc}"/>
    				<span id="qwmc"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >存储功能&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ccgn" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >存储类型&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.cclx" styleClass="input" readonly="true"/>
    			</td>    			    			   			
    		</tr>
    		<tr>
    			<td align="right" >存储方式&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ccfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" >存储品质&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ccpz" styleClass="input" readonly="true"/>
    			</td>		
    		</tr>
    		<tr>
    			<td align="right" >存储环境&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:select property="vo.cchj" style="width: 100pt;">
    					<html:option value="干燥">干燥</html:option>
	    				<html:option value="通风">通风</html:option>
	    				<html:option value="阴凉">阴凉</html:option>
	    				<html:option value="潮湿">潮湿</html:option>
    				</html:select>
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
