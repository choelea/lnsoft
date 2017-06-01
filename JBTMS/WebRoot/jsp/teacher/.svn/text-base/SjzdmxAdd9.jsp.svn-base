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
    			alert("存储功能编号输入有误!");
    			return false;
    		}
    		if(sjzdmxmc.value==""){
    			alert("请输入存储功能信息!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./sjzdmx.do?method=sjzdmxList&page=1&sjzd.sjzdzj=${objPk}&vo.fqzj=${fqPk}";
    	}
    	function valiValue(o,f){
    		if(o.value!=""){
    			var hql = "from Sjzdmx A where A."+f+" = '"+o.value+"' and A.sjzd.sjzdzj = ${objPk}";
    			UserDWR.isExit(hql,null,function cd(data){
    				var field = document.getElementById(f);
    				if(data)						
    					field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
    				else
    					field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
    			});
    		}
    	}   
    </script> 
  </head>
  
  <body>
    <html:form action="/sjzdmx.do?method=addObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>存储功能管理</center></caption>
    		<tr>
    			<td width="40%" align="right">存储功能编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sjzdmxbh" styleClass="input" onblur="valiValue(this,'sjzdmxbh');"/>
    				<span id="sjzdmxbh"></span>
    				<html:hidden property="sjzd.sjzdzj" value="${objPk }"/>
    				<html:hidden property="vo.fqzj" value="0"/>
    				<html:hidden property="vo.kfcz" value="1"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">存储功能名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.sjzdmxmc" styleClass="input" onblur="valiValue(this,'sjzdmxmc');"/>
    				<span id="sjzdmxmc"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">添 加</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>
