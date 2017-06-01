<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	var bhexist = false;
    	function IsNull(){
    		var hzdbh = document.all("vo.hzdbh");
    		var hzdwmc = document.all("vo.hzdwmc");
    		var hzdwlx = document.all("vo.hzdwlx");
    		var lxr = document.all("vo.lxr");
    		var lxrdh = document.all("vo.lxdh");
    		var lxrcz = document.all("vo.lxrcz");
    		var dwdz = document.all("vo.dwdz");
    		var dwyb = document.all("vo.dwyb");
    		var xybh = document.all("vo.xybh");
    		var khh = document.all("vo.khh");
    		var zh = document.all("vo.zh");
    		var frdb = document.all("vo.frdb");
    		var qydm = document.all("vo.qydm");
    		var yyzzhm = document.all("vo.yyzzhm");
    		var dsdjhm = document.all("vo.dsdjhm");
    		var gsdjhm = document.all("vo.gsdjhm");
    		var dlysxkz = document.all("vo.dlysxkz");
    		var wxpysxkz = document.all("vo.wxpysxkz");
    		var zczj = document.all("vo.zczj");
    		var clsj = document.all("vo.clsj");
    		var cwfs = 0;
    		var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		var taxExp = /^[0-9]{3,4}(-)[0-9]{8}$/;
    		var postExp = /^\d{6}$/;
    		var numExp = /^\d+$/;
    		var charExp = /^\w+$/;
    		var dateExp = /^\s*[1-9]{1}[0-9]{3}(-)((0[1-9]{1})|(1[0-2]{1}))(-)((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))\s*$/;
    		if(hzdbh.value==""){
    			alert("请输入合作编号!");
   				return false;
    		}else if(bhexist){
    			alert("合作编号已存在!");
   				return false;
    		}
    		if(hzdwmc.value==""){
    			alert("请输入合作单位信息!");
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
    		/*if(hzdwlx.value==""){
    			cwfs+=1;
    		} 
    		if(lxrcz.value!=""){
    			if(!taxExp.test(lxrcz.value)){
    				cwfs+=1;
    			}
    		}
    		if(dwdz.value==""){
    			cwfs+=1;
    		}
    		if(dwyb.value==""){
    			cwfs+=1;
    		}else if(!postExp.test(dwyb.value)){
    			cwfs+=1;
    		}
    		if(xybh.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(xybh.value)){
    			cwfs+=1;
    		}
    		if(khh.value==""){
    			cwfs+=1;
    		}
    		if(zh.value==""){
    			cwfs+=1;
    		}else if(!numExp.test(zh.value)){
    			cwfs+=1;
    		}
    		if(qydm.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(qydm.value)){
    			cwfs+=1;
    		}
    		if(yyzzhm.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(yyzzhm.value)){
    			cwfs+=1;
    		}
    		if(dsdjhm.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(dsdjhm.value)){
    			cwfs+=1;
    		}
    		if(gsdjhm.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(gsdjhm.value)){
    			cwfs+=1;
    		}
    		if(dlysxkz.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(dlysxkz.value)){
    			cwfs+=1;
    		}
    		if(wxpysxkz.value==""){
    			cwfs+=1;
    		}else if(!charExp.test(wxpysxkz.value)){
    			cwfs+=1;
    		}
    		if(zczj.value==""){
    			cwfs+=1;
    			zczj.value=0;
    		}else if(isNaN(zczj.value)){
    			cwfs+=1;
    		}    		
    		if(clsj.value==""){
    			cwfs+=1;
    		}else if(!dateExp.test(clsj.value)){
    			cwfs+=1;
    		}*/
    		if(frdb.value==""){
    			alert("请输入法人代表信息!");
   				return false;
    		}
    		var dForm = document.forms[0];
    		dForm.action="<%=request.getContextPath()%>/hzgxxx.do?method=save";
    		dForm.method="post";
    		dForm.submit();
    		return true;
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/hzgxxx.do?method=getList&page=1&rmMsg=true";
    	}
    	function valiValue(o,f){
    		if(o.value!=""){
    			UserDWR.hzgxExist(o.value,f,${userPk},${userSyszzj},function cd(data){
    				var field = document.getElementById(f);
    				if(data){
    					field.innerHTML="<font color='#ff0000'>编号已存在于数据库</font>";
    					bhexist = true;
    				}else{
    					field.innerHTML="<font color='#ff0000'>可以使用</font>";
    				}
    			});
    		}
    	}    
    	function setValue(){
			var pk = document.getElementsByName("pk");			
			var i = ToDel();
			if(i!=-1){
				var pagemsglx = document.all("pagemsglx");
				if(pagemsglx.value=='1'){
					var ls = document.getElementsByName("ls");
					var rkjs = document.all("vo.khh");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='0'){
					var ls = document.getElementsByName("ls");
					var xzkhdwlx = document.getElementsByName("xzkhdwlx");
					var xzlxr = document.getElementsByName("xzlxr");
					var xzlxdh = document.getElementsByName("xzlxdh");
					var xzlxcz = document.getElementsByName("xzlxcz");
					var xzlxyb = document.getElementsByName("xzlxyb");
					var xzlxdz = document.getElementsByName("xzlxdz");
					var xzkhjl = document.getElementsByName("xzkhjl");
					var xzkhh = document.getElementsByName("xzkhh");
					var xzkhzh = document.getElementsByName("xzkhzh");
					           
					document.all("vo.hzdwmc").value=ls[i].value;
		    		document.all("vo.hzdwlx").value=xzkhdwlx[i].value;
		    		document.all("vo.lxr").value=xzlxr[i].value;
		    		document.all("vo.lxdh").value=xzlxdh[i].value;
		    		document.all("vo.lxrcz").value=xzlxcz[i].value;
		    		document.all("vo.dwdz").value=xzlxdz[i].value;
		    		document.all("vo.dwyb").value=xzlxyb[i].value;
		    		document.all("vo.frdb").value=xzkhjl[i].value;
		    		document.all("vo.khh").value = xzkhh[i].value;
		    		document.all("vo.zh").value = xzkhzh[i].value;
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
    	function pagedata(curpage){
    		UserDWR.getSjzdmx(curpage,14,cd);
    	}	
    	function cd(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='1'></td><td>银行名称</td><td>银行简称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxmc+"</td><td>"+list[obj].field1+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无银行信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pagedata");
    		div1.innerHTML=msg;
    	}
    	function pageCdata(curpage){
    		var countHql = "select count(*) from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			var hql = " from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,cdc);
    	}	
    	function cdc(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='0'></td><td>客户编号</td><td>单位名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].dwmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].khzj+"\">"+
						  "<input type=\"hidden\" name=\"xzkhdwlx\" value=\""+list[obj].hysx+"\">"+
						  "<input type=\"hidden\" name=\"xzlxr\" value=\""+list[obj].lxr+"\">"+
						  "<input type=\"hidden\" name=\"xzlxdh\" value=\""+list[obj].lxrdh+"\">"+
						  "<input type=\"hidden\" name=\"xzlxcz\" value=\""+list[obj].lxrcz+"\">"+
						  "<input type=\"hidden\" name=\"xzlxyb\" value=\""+list[obj].lxryb+"\">"+
						  "<input type=\"hidden\" name=\"xzlxdz\" value=\""+list[obj].khdz+"\">"+
						  "<input type=\"hidden\" name=\"xzkhjl\" value=\""+list[obj].khjl+"\">"+
						  "<input type=\"hidden\" name=\"xzkhh\" value=\""+list[obj].khh+"\">"+
						  "<input type=\"hidden\" name=\"xzkhzh\" value=\""+list[obj].khzh+"\">"+
							"</td><td>"+list[obj].khbh+"</td><td>"+list[obj].dwmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无客户信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageCdata");
    		div1.innerHTML=msg;    		
    	}
    	function clickHid(){
    		document.getElementById("show-btn").click();
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
  	<html:form action="/hzgxxx.do?method=save" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>合作关系录入</center></caption>
    		<tr>
    			<td align="right" width="20%">合作编号&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="hidden" name="stzj" value="45"/>
    				<html:hidden property="vo.ssxs" value="${userPk }"/>
    				<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				<input type="hidden" id="show-btn"/> 
    			</td>
    			<td width="25%">
    				<html:text property="vo.hzdbh" styleClass="input" readonly="true" value="${autobh }"/>
    				<div id="hzdbh"></div>
    			</td>
    			<td align="right" width="20%">合作单位名称&nbsp;&nbsp;<font color="red">*</font></td>
    			<td><html:text property="vo.hzdwmc" styleClass="input" />
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageCdata(1);clickHid();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合作单位类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.hzdwlx" styleClass="input"/>
    			</td>
    			<td align="right">联 系 人&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td>
    				<html:text property="vo.lxr" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">联系电话&nbsp;&nbsp;<font color="red">*</font></td>
    			<td><html:text property="vo.lxdh" styleClass="input"/><div class="tishi"><bean:message key="phone"/></div>
    			</td>
    			<td align="right">联系人传真&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.lxrcz" styleClass="input"/><div class="tishi"><bean:message key="telephone"/></div>
    			</td>
    		</tr>    		
    		<tr>
    			<td align="right">单位邮编&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.dwyb" styleClass="input"/><span class="tishi"><bean:message key="yzbm"/></span>
    			</td>
    			<td align="right">协议编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.xybh" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">单位地址&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:text property="vo.dwdz" styleClass="input" style="width:270pt"/>
    			</td>
    		</tr>    		
    		<tr>    			
    			<td align="right">开 户 行&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.khh" styleClass="input" readonly="true"/>
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagedata(1);clickHid();"/>
    			</td>
    			<td align="right">帐 号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.zh" styleClass="input"/><span class="tishi"><bean:message key="number"/></span>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">法人代表&nbsp;&nbsp;<font color="red">*</font></td>
    			<td><html:text property="vo.frdb" styleClass="input"/>
    			</td>
    			<td align="right">企业代码&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.qydm" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">营业执照号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.yyzzhm" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    			<td align="right">地税登记号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.dsdjhm" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">国税登记号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.gsdjhm" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    			<td align="right">道路运输许可证&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.dlysxkz" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>    			
    		</tr>
    		<tr>
    			<td align="right">危险品运输许可证&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.wxpysxkz" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    			<td align="right">注册资金&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zczj" styleClass="input"/>(RMB)
    			</td>
    		</tr>
    		<tr>
    			<td align="right">成立时间&nbsp;&nbsp;&nbsp;&nbsp; 			
    			</td>
    			<td colspan="3">
    				<html:text property="vo.clsj" styleClass="input"/>(yyyy-MM-dd格式)
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备 注&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzsm" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="添 加" class="inputbutton" onclick="return IsNull();"/>
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
