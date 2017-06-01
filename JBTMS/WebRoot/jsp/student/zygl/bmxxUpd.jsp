<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function back(){
    		window.location.href="./bmxx.do?method=objList"
    	}
    	function IsNull(){
    		var expPhone = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		var bmmc = $("vo.bmmc");
    		var bmdh = $("vo.bmdh");
    		var ssjg = $("vo.ssjg");
    		if(bmmc.value==""){
    			alert("请输入部门名称!");
    			return false;
    		}
    		if(bmdh.value!="" && !expPhone.test(bmdh.value)){
    			alert("部门电话输入有误!!");
    			return false;
    		}
    		if(ssjg.value==""){
    			alert("请输入部门隶属机构!");
    			return false;
    		}
    		return true;
    	}
    	function setSsjg(){
    		paramPageinfo(1,16);
			document.getElementById("show-btn").click();
    	}
    	function paramPageinfo(curpage,ptype){
			var countHql = "select count(A) from Sjzdmx A where A.sjzd.sjzdzj = "+ptype+" and A.fqzj=0";
			var hql = "from Sjzdmx A where A.sjzd.sjzdzj = "+ptype+" and A.fqzj=0";
			UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
				var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='paramType' value='cslx'/><input type='hidden' name='paramType1' value='"+ptype+"'/></td><td>参数编号</td><td>参数名称</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].sjzdmxzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].sjzdmxmc+"\">"+
								"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无参数信息</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"paramPageinfo",ptype);
		   		div1.innerHTML=msg;
			});
		}
		function pageMsg(data,fn,ptype){
			var msg = "";
			msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,"+ptype+");\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+","+ptype+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+","+ptype+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+","+ptype+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
		}
		function setValue(){
			var paramType = document.all("paramType");
			var paramType1 = document.all("paramType1");
			var paramPks = document.getElementsByName("paramPk");
			var paramValues = document.getElementsByName("paramValue");
			for(var i=0;i<paramPks.length;i++){
				if(paramPks[i].checked){
					if("cslx"==paramType.value){
						if("16"==paramType1.value){
							document.all("vo.ssjg").value=paramValues[i].value;
						}
					}
					break;
				}
			}
		}
		function valiValue(o,f,ssxs,sssysz){
			var oldName = document.all("oldName");
			if(o.value!=""){
				var ssjg = $("vo.ssjg");
				if(ssjg.value!=""){
					var field = document.getElementById(f);
					if(oldName.value!=o.value){
						var hql = "from Bmxx A where A."+f+" = '"+o.value+"' and A.ssjg=? and A.ssxs ="+ssxs+" and A.sssysz = "+sssysz;
						UserDWR.isExit(hql,ssjg.value,function cd(data){
							var field = document.getElementById(f);
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
		}
    </script>    
  </head>
  
  <body>
    <html:form action="/bmxx.do?method=updObject" method="post" onsubmit="return IsNull();">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>部门管理</center></caption>
    		<tr >
    			<td width="40%"  align="right" >部门编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.bmbh" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.bmzj"/>
    				<input type="hidden" name="show-btn">
    			</td>
    		</tr>
    		<tr>
    			<td align="right">部门名称&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.bmmc" styleClass="input" onblur="valiValue(this,'bmmc','${userPk }','${userSyszzj }')"/>
    				<span id="bmmc"></span>
    				<input type="hidden" name="oldName" value="${bmxxForm.vo.bmmc }"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >联系电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.bmdh" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >所属机构&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
					<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="setSsjg();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" >备 注&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:textarea property="vo.bzxx" cols="40" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2" >
    				<html:submit styleClass="inputbutton">修 改</html:submit>
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
