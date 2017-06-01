<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/hzgxxx.do?method=getList&page=1&rmMsg=true";
    	}
    </script> 
  </head>
  
  <body>
  	<html:form action="/hzgxxx.do?method=getList" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>合作关系信息</center></caption>
    		<tr>
    			<td align="right" width="20%">合作编号&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.hzgxzj"/>
    			</td>
    			<td width="25%">
    				<html:text property="vo.hzdbh" styleClass="input" readonly="true"/>
    				<div id="hzdbh"></div>
    			</td>
    			<td align="right" width="20%">合作单位名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.hzdwmc" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合作单位类型&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.hzdwlx" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">联 系 人&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.lxr" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">联系电话&nbsp;&nbsp;</td>
    			<td><html:text property="vo.lxdh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">联系人传真&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.lxrcz" styleClass="input" readonly="true"/>
    			</td>
    		</tr>    		
    		<tr>
    			<td align="right">单位邮编&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.dwyb" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">协议编号&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.xybh" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 
    		<tr>
    			<td align="right">单位地址&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:text property="vo.dwdz" styleClass="input" style="width:270pt" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">开 户 行&nbsp;&nbsp;</td>
    			<td><html:text property="vo.khh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">帐 号&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.zh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">法人代表&nbsp;&nbsp;</td>
    			<td><html:text property="vo.frdb" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">企业代码&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.qydm" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">营业执照号&nbsp;&nbsp;</td>
    			<td><html:text property="vo.yyzzhm" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">地税登记号&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.dsdjhm" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">国税登记号&nbsp;&nbsp;</td>
    			<td><html:text property="vo.gsdjhm" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">道路运输许可证&nbsp;&nbsp;</td>
    			<td><html:text property="vo.dlysxkz" styleClass="input" readonly="true"/>
    			</td>    			
    		</tr>
    		<tr>
    			<td align="right">危险品运输许可证&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.wxpysxkz" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">注册资金&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.zczj" styleClass="input" readonly="true"/>(RMB)
    			</td>
    		</tr>
    		<tr>
    			<td align="right">成立时间&nbsp;&nbsp;    			
    			</td>
    			<td colspan="3">
    				<html:text property="vo.clsj" styleClass="input" readonly="true"/>(yyyy-MM-dd格式)
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备 注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzsm" cols="50" rows="5" readonly="true"></html:textarea>
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
