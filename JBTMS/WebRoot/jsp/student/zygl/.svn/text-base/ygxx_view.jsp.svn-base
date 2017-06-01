<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title> 
   <link rel="stylesheet" type="text/css" href="./css/newdate.css" />
    <script type="text/javascript">
     function back(){
    	window.location.href="./yggl.do?method=getList";
     }
    </script> 
  </head>
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
    <html:form action="/yggl.do?method=updateObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>员工信息</center></caption>
    		<tr >
    			<td width="30%"  align="right" class="td2">员工编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.ygbh" styleClass="input" readonly="true"/>
    			</td>
    			<td width="15%" align="right">员工姓名&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ygmc" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">性　　别&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				　<html:radio property="vo.ygxb" value="男"/>男　
    				<html:radio property="vo.ygxb" value="女"/>女
    			</td>
    			
    			<td align="right" class="td2">出生日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.csrq" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		
    		<tr>
    			<td align="right" class="td2">工作日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.gzrq" styleClass="input" readonly="true" />
    			</td>
    			<td align="right" class="td2">员工职位&nbsp;&nbsp;&nbsp;&nbsp;
    			<td>
    				<html:text property="vo.ygzw" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			
    			<td  align="right" class="td2">员工工资&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.yggz" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" class="td2">所属部门&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    			    <html:text property="vo.ssbm" styleClass="input" readonly="true"/>
    			    <html:hidden property="vo.ssjg" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ygdh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right" class="td2">身份证号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sfzh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工状态&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.ygzt" styleClass="input" >
    					<html:option value="0">空闲</html:option>
    					<html:option value="1">忙碌</html:option>
    				</html:select>
    			</td>
    			<td align="right" class="td2">员工地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.ygdz" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工描述&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3" align="left">
    				<html:textarea  property="vo.ygms" cols="50" rows="5" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" class="td2">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
