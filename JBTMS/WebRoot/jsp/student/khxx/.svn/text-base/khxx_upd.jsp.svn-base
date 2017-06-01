<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	var bhexist = false;
    	var mcexist = false;
    	function IsNull(){
    		var khbh = document.all("vo.khbh");
    		var ssjg = document.all("vo.ssjg");
    		var dwmc = document.all("vo.dwmc");
    		var khjl = document.all("vo.khjl");
    		var khjldh = document.all("vo.khjldh");
    		var lxr = document.all("vo.lxr");
    		var lxrdh = document.all("vo.lxrdh");
    		var lxrcz = document.all("vo.lxrcz");
    		var email = document.all("vo.lxryx");
    		var lxryb = document.all("vo.lxryb");
    		var khjb = document.all("vo.khjb");
    		var khdz = document.all("vo.khdz");
    		var xmmc = document.all("vo.xmmc");
    		var hysx = document.all("vo.hysx");
    		var khh = document.all("vo.khh");
    		var khzh = document.all("vo.khzh");
    		var qygm = document.getElementsByName("vo.qygm");
    		var cwfs = 0;
    		var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		var taxExp = /^[0-9]{3,4}(-)[0-9]{8}$/;
    		var postExp = /^\d{6}$/;
    		if(khbh.value==""){
    			alert("请输入客户编号!");
   				return false;
    		}else if(bhexist){
    			alert("客户编号已存在!");
   				return false;
    		}
    		if(ssjg.value==""){
    			alert("请输入所属机构!");
    			return false;
    		}
    		if(dwmc.value==""){
    			alert("单位名称输入有误!");
   				return false;
    		}else if(mcexist){
    			alert("单位名称已存在!");
   				return false;
    		}
    		if(khjl.value==""){
    			alert("请输入客户经理信息!");
   				return false;
    		}
    		if(khjldh.value!=""){
    			if(!phoneExp.test(khjldh.value)){
    				alert("客户经理电话输入有误!");
   					return false;
    			}
    		}else{
    			alert("请输入客户经理电话!");
   				return false;
    		}
    		if(lxryb.value==""){
    			alert("请输入联系人邮编!");
   				return false;
    		}else if(!postExp.test(lxryb.value)){
    			alert("联系人邮编输入有误!");
   				return false;
    		}
    		if(lxr.value==""){
    			alert("请输入联系人信息!");
   				return false;
    		}
    		if(lxrdh.value==""){
    			alert("请输入联系人电话!");
   				return false;
    		}else if(!phoneExp.test(lxrdh.value)){
    			alert("联系人电话输入有误!");
   				return false;
    		}
    		/*if(lxrcz.value!=""){
    			if(!taxExp.test(lxrcz.value)){
    				cwfs+=1;
    			}
    		}
    		if(khjb.value==""){
    			cwfs+=1;
    		}
    		if(hysx.value==""){
    			cwfs+=1;
    		}
    		for(i=0;i<qygm.length;i++){
    			if(qygm[i].checked){
    				break;
    			}
    		}
    		if(i==qygm.length){
    			cwfs+=1;
    		}*/
    		if(khdz.value==""){
    			alert("请输入客户地址!");
   				return false;
    		}
    		if(hysx.value==""){
    			alert("请输入行业属性!");
   				return false;
    		}
    		if(khh.value==""){
    			alert("请输入开户行!");
   				return false;
    		}
    		if(khzh.value==""){
    			alert("请输入开户行账号!");
   				return false;
    		}
    		var dForm = document.forms[0];
    		dForm.action="<%=request.getContextPath()%>/khxx.do?method=update";
    		dForm.method="post";
    		dForm.submit();
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khxx.do?method=getList&page=1&rmMsg=true";
    	}
    	function valiValue(o,f){
    		var oldKhbh = document.all("oldKhbh");
    		var oldDwmc = document.all("oldDwmc");
    		if(o.value!=""){
    			if(f=="khbh" && o.value==oldKhbh.value){
					bhexist = false;
				}else if(f=="dwmc" && o.value==oldDwmc.value){
					mcexist = false;
				}else{
					UserDWR.khExist(o.value,f,${userPk},${userSyszzj},function cd(data){
	    				var field = document.getElementById(f);
	    				if(data){
	    					field.innerHTML="<font color='#ff0000'>记录已存在于数据库</font>";
	    					if(f=="khbh"){
	    						bhexist = true;
	    					}
	    					if(f=="dwmc"){
	    						mcexist = true;
	    					}
	    				}else{
	    					field.innerHTML="<font color='#ff0000'>可以使用</font>";
	    					mcexist = false;
	    				}
    				});
				}    			
    		}
    	}    
    	function setValue(){
			var pk = document.getElementsByName("pk");
			var ls = document.getElementsByName("ls");
			var hysx = document.all("vo.hysx");
			var khh = document.all("vo.khh");
			var ssjg = document.all("vo.ssjg");
			var i = ToDel();
			var info = document.getElementById("infokind");
			if(i!=-1){
				if(info.value=="hy"){
					hysx.value=ls[i].value;
				}
				if(info.value=="bank"){
					khh.value =ls[i].value;
				}
				if(info.value=="station"){
					ssjg.value =ls[i].value;
				}
			}
		}
    	function ToDel() { 
		  var temp=document.getElementsByName("pk"); 
		  var count=-1;
		  for (i=0;i<temp.length;i++){ 
		  //遍历Radio 
		    if(temp[i].checked){
		    	return i; 
		    	 break;
		     } 
		  } 
		  return count;
		} 
    	function pagedata2(curpage){
    		document.getElementById("show-btn").click();
    		UserDWR.getSjzdmx(curpage,14,cd2);
    	}
    	function pagedata(curpage){
    		document.getElementById("show-btn").click();
    		UserDWR.getSjzdmx(curpage,19,cd);
    	}
    	function pageCdata(curpage){
    		document.getElementById("show-btn").click();
    		UserDWR.getSjzdmx(curpage,16,cdc);
    	}
    	function cd(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td width='20%'>选择<input type='hidden'name='infokind' value='hy'/></td><td>行业编号</td><td>行业名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无行业属性信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pagedata");
    		div1.innerHTML=msg;
    	}
    	function cd2(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td width='20%'>选择<input type='hidden'name='infokind' value='bank'/></td><td>银行编号</td><td>银行名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxmc+"</td><td>"+list[obj].field1+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无银行行业信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pagedata2");
    		div1.innerHTML=msg;
    	}
    	function cdc(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table width='100%' border='0' cellpadding='0' cellspacing='1' style='word-break:break-all;'>"+
    			"<tr align='center' height='30'><input type='hidden' name='infokind' value='station'>"+
    			"<td>选择</td><td>站点名称</td><td>站点地区</td></tr>";
    		if(list.length==0){
    			msg = msg + "<tr align='center' height='30'><td colspan='4'>暂无站点信息！</td></tr>";
    		}else{
    			for(var i in list){
    				if(!isNaN(i)){
    					msg=msg+ "<tr align='center' height='25'><td><input type='radio' name='pk' value='"+i+"'>"+
    					"<input type='hidden' name='ls' value='"+list[i].sjzdmxmc+"'>"+
    					"</td><td>"+list[i].sjzdmxmc+"</td><td>"+list[i].field1+"</td></tr>";
    				}
    			}
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageCdata");
    		div1.innerHTML=msg;
    	}
    	function pageMsg(data,fn){
			var msg = "";
			msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
					"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
					"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1);\"/>"+
					"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+");\"/>"+
					"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+");\"/>"+
					"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
		}
    </script> 
  </head>
  
  <body>
  	<html:form action="/khxx.do?method=update" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户修改</center></caption>
    		<tr>
    			<td align="right" width="20%">客户编号&nbsp;&nbsp;
    				<html:hidden property="vo.sftzwl" />
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    				<html:hidden property="vo.khzj"/>
    			</td>
    			<td colspan="3">
    				<html:text property="vo.khbh" styleClass="input" readonly="true"/>
    				<div id="khbh"></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">所属机构&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageCdata(1);"/>
    			</td>
    			<td align="right" width="20%">单位名称<font color="red">*</font></td>
    			<td><html:text property="vo.dwmc" styleClass="input" onchange="valiValue(this,'dwmc');"/>
    				<div id="dwmc"></div>    				
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户经理<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.khjl" styleClass="input"/>
    			</td>
    			<td align="right">客户经理电话<font color="red">*</font></td>
    			<td><html:text property="vo.khjldh" styleClass="input"/><div class="tishi"><bean:message key="phone"/></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">联 系 人<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.lxr" styleClass="input"/>
    			</td>
    			<td align="right">联系人电话<font color="red">*</font></td>
    			<td><html:text property="vo.lxrdh" styleClass="input"/><div class="tishi"><bean:message key="phone"/></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">联系人传真&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.lxrcz" styleClass="input"/><div class="tishi"><bean:message key="telephone"/></div>
    			</td>
    			<td align="right">联系人E-mail&nbsp;&nbsp;</td>
    			<td><html:text property="vo.lxryx" styleClass="input"/></td>
    		</tr>
    		<tr>
    			<td align="right">联系人邮编<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.lxryb" styleClass="input"/><div class="tishi"><bean:message key="yzbm"/></div>
    			</td>
    			<td align="right">客户级别&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.khjb" style="width:100pt">
    					<html:option value="">选择客户级别</html:option>
    					<html:option value="A">A</html:option>
    					<html:option value="B">B</html:option>
    					<html:option value="C">C</html:option>
    				</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户地址<font color="red">*</font></td>
    			<td >
    				<html:text property="vo.khdz" styleClass="input" /></td>
    			<td align="right">行业属性<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.hysx" styleClass="input" style="width:120pt" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagedata(1);"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">开户行<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.khh" styleClass="input" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagedata2(1);"/>
    			</td>
    			<td align="right">开户账号<font color="red">*</font></td>
    			<td >
    				<html:text property="vo.khzh" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户描述&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:textarea property="vo.khms" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">制 单 人&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.zdr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">制单日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="修 改" class="inputbutton" onclick="return IsNull();"/>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="show-btn">
    			</td>
    		</tr>
    	</table>
  	</html:form>
  	<div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1"></div>
    </div>
	</div>
  </body>
</html>
