<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khxx.do?method=getList&page=1&rmMsg=true";
    	}
    </script> 
  </head>
  
  <body>
  	<html:form action="/khxx.do?method=getList" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户信息</center></caption>
    		<tr>
    			<td align="right" width="20%">客户编号&nbsp;&nbsp;
    				<html:hidden property="vo.sftzwl" />
    				<html:hidden property="vo.khzj" />
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    			</td>
    			<td colspan="3">
    				<html:text property="vo.khbh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">所属机构&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" width="20%">单位名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.dwmc" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户经理&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.khjl" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">客户经理电话&nbsp;&nbsp;</td>
    			<td><html:text property="vo.khjldh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">联 系 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.lxr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">联系人电话&nbsp;&nbsp;</td>
    			<td><html:text property="vo.lxrdh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">联系人传真&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.lxrcz" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">联系人E-mail&nbsp;&nbsp;</td>
    			<td><html:text property="vo.lxryx" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">联系人邮编&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.lxryb" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">客户级别&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.khjb" style="width:100pt" disabled="true">
    					<html:option value="">选择客户级别</html:option>
    					<html:option value="A">A</html:option>
    					<html:option value="B">B</html:option>
    					<html:option value="C">C</html:option>
    				</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户地址&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.khdz" styleClass="input" />
    			</td>
    			<td align="right">行业属性&nbsp;&nbsp;</td>
    			<td><html:text property="vo.hysx" styleClass="input" style="width:120pt" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">开户行&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.khh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">开户账号&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.khzh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户描述&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:textarea property="vo.khms" cols="50" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">制 单 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">制单日期&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdsj" styleClass="input" readonly="true"/>
    			</td>
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
