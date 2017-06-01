<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function IsNull(){
    		var sjzdmxbh = document.all("vo.sjzdmxbh");
    		var sjzdmxmc = document.all("vo.sjzdmxmc");
    		var expNum = /^\w+$/;    	
    		if(!expNum.test(sjzdmxbh.value)){
    			alert("运输方式编号输入有误!");
    			return false;
    		}
    		if(sjzdmxmc.value==""){
    			alert("请输入运输方式信息!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./sjzdmx.do?method=sjzdmxList&page=1&sjzd.sjzdzj=${objPk}&vo.fqzj=${fqPk}";
    	}
    	function valiValue(o,f){
    		var oldName = document.all("oldName");    		
    		if(o.value!=""){
    			var field = document.getElementById(f);
    			if(oldName.value!=o.value){
    				var hql = "from Sjzdmx A where A."+f+" = '"+o.value+"' and A.sjzd.sjzdzj = ${objPk}";
	    			UserDWR.isExit(hql,null,function cd(data){	    				
	    				if(data)						
	    					field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
	    				else
	    					field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
	    			});	
    			}else{
    				field.innerHTML="<font color='#ff0000'></font>";
    			}    			
    		}
    	}   
    </script> 
  </head>
  
  <body>
    <html:form action="/sjzdmx.do?method=updObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>运输方式管理</center></caption>
    		<tr>
    			<td width="40%" align="right">运输方式编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sjzdmxbh" styleClass="input" readonly="true"/>
    				<span id="sjzdmxbh"></span>
    				<html:hidden property="sjzd.sjzdzj"/>
    				<html:hidden property="vo.fqzj"/>
    				<html:hidden property="vo.kfcz"/>
    				<html:hidden property="vo.sjzdmxzj"/>
    				<input type="hidden" name="oldName" value="${sjzdForm.vo.sjzdmxmc}">
    			</td>
    		</tr>
    		<tr>
    			<td align="right">运输方式名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.sjzdmxmc" styleClass="input" onblur="valiValue(this,'sjzdmxmc');"/>
    				<span id="sjzdmxmc"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">运输方式类型&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.field1" style="width: 100pt;">
    					<html:option value="公路">公路</html:option>
    					<html:option value="铁路">铁路</html:option>
    				</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
