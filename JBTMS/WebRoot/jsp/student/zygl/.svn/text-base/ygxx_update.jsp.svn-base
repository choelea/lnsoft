<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<%@ include file="/init/dwrjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title> 
   <link rel="stylesheet" type="text/css" href="./css/newdate.css" />
    <script type="text/javascript">
     function IsNull(){
     	var ygmc = document.getElementById("vo.ygmc");
     	var gzrq = document.getElementById("vo.gzrq");
     	var ygzw = document.getElementById("vo.ygzw");
     	var yggz = document.getElementById("vo.yggz");
     	var ygdh = document.getElementById("vo.ygdh");
     	var ssjg = document.getElementById("vo.ssjg");
     	var sfzh = document.getElementById("vo.sfzh");
     	var csrq = document.getElementById("vo.csrq");
     	var phone = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
     	var vsfzh=/^[0-9]{17}[0-9a-zA-z]{1}$/;
     	var numVail = /^[0-9]+$|[0-9]+\.[0-9]+$/;
     	var nowdate = new Date();
     	if(ygmc.value == "") {
     		alert("请输入员工姓名!");
     	   	return false;
     	}
     	if(csrq.value!=""){
     		var date = toDate(csrq.value);
     		if(!(date<=nowdate)){
	     		alert("出生日期不能大于当前日期！");
	     		return false;
     		}
			var year = date.getYear();
			if((parseInt(year)<100)){
				year = "19"+year;
			}
     		if((parseInt(year)+18)>parseInt(nowdate.getYear())){
     			alert("您填写的员工出生日期距现在不满十八岁，请填写正确的出生日期！");
     			return false;
     		}
     	}
     	if(gzrq.value == "") {
     		alert("请选择工作日期!");
     	   	return false;
     	}
     	if(!(toDate(gzrq.value)<=nowdate)){
     		alert("工作日期不能大于当前日期！");
     		return false;
     	}
     	if(csrq.value!=""){
     		if(toDate(gzrq.value)<=toDate(csrq.value)){
	     		alert("工作日期不能大于出生日期！");
	     		return false;
     		}
     		var gzyear = toDate(gzrq.value).getYear();
			if((parseInt(gzyear)<100)){
				gzyear = "19"+gzyear;
			}
			var csyear = toDate(csrq.value).getYear();
			if((parseInt(csyear)<100)){
				csyear = "19"+csyear;
			}
     		if((parseInt(csyear)+18)>parseInt(gzyear)){
     			alert("您填写的员工出生日期距出生日期不满十八岁，请填写正确的工作日期！");
     			return false;
     		}
     	}
     	if(ygzw.value == "") {
     		alert("请选择员工职位!");
     	   	return false;
     	}
     	if(yggz.value == "") {
     		alert("请输入员工工资信息!");
     	   	return false;
     	}else if(!numVail.test(yggz.value)) {
     		alert("员工工资输入有误!");
     	   	return false;
     	}else if(parseFloat(yggz.value)<=0){
     		alert("员工工资不能小于零！");
     		return false;
     	}
     	if(ssjg.value == "") {
     		alert("请输入员工所属部门信息!");
     	   	return false;
     	}
     	if(ygdh.value!=""&&!phone.test(ygdh.value)) {
			alert("电话格式不正确!");
     	   	return false;
     	}
     	if(sfzh.value!=""){
	     	if(!vsfzh.test(sfzh.value)) {
				alert("身份证号不正确!");
	     	   	return false;
	     	}
     	}
     }
     
     function toDate(curdate){
     	var year = curdate.substring(0,4);
     	var month = curdate.substring(5,7);
     	var day = curdate.substring(8,11);
     	var date = new Date(year,parseInt(month)-1,day);
		return date;
     }
     function setValue(){
     	var pk = document.getElementsByName("pk");
     	var i = toSel();
     	if(i!=-1){
     		var pagemsglx = document.getElementById("pagemsglx");
     		var ls = document.getElementsByName("ls");
     		if(pagemsglx.value=='station'){
     			var ls1 = document.getElementsByName("ls1");
     			var ssbm = document.getElementById("vo.ssbm");
     			var rkjs = document.getElementById("vo.ssjg");
     			ssbm.value=ls[i].value;
     			rkjs.value = ls1[i].value;
     		}
     		if(pagemsglx.value=='ygzw'){
     			var rkjs = document.getElementById("vo.ygzw");
     			rkjs.value = ls[i].value;
     		}
     	}
     }
     function toSel(){
     	var temp = document.getElementsByName("pk");
     	var count = -1;
     	for(var i=0;i<temp.length;i++){
     		if(temp[i].checked){
     			return i;
     		}
     	}
     	return count;
     }
     function pageAdata(curpage){
     	UserDWR.getSjzdmx(curpage,13,cda);//员工职位
     }
     function pageBdata(curpage){
     	var countHql= "select count(A) from Bmxx A where 1=1 and (A.ssxs=${userPk} and A.sssysz=${userSyszzj} or A.ssxs=0 and A.sssysz=0)";
     	var hql = "from Bmxx A where 1=1 and (A.ssxs=${userPk} and A.sssysz=${userSyszzj} or A.ssxs=0 and A.sssysz=0)";
     	UserDWR.getPageinfo(countHql,hql,curpage,10,null,cdb);
     }
     function cda(data){
     	var list = data.pagedata;
     	var div1 = document.getElementById("div1");
     	var msg = "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
     		"<tr align=\"center\" height=\"30\">"+
     		"<td>选择<input type=\"hidden\" name=\"pagemsglx\" value=\"ygzw\"></td><td>职位编码</td><td>职位名称</td></tr>";
     	if(list.length==0){
     		msg = msg + "<tr align=\"center\" height=\"30\"><td>暂无职位信息!</td></tr>";
     	}else{
     		for(var obj in list){
     			if(!isNaN(obj)){
     				msg=msg+ "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
     				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
     				"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr>";
     			}
     		}
     	}
     	msg = msg + "</table>";
     	msg = msg + pageMsg(data,"pageAdata");
     	div1.innerHTML=msg;
     }
     function cdb(data){
     	var list = data.pagedata;
     	var div1 = document.getElementById("div1");
     	var msg = "<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
     		"<tr align=\"center\" height=\"30\">"+
     		"<td>选择<input type=\"hidden\" name=\"pagemsglx\" value=\"station\"></td><td>部门编号</td><td>部门名称</td><td>所属机构</td></tr>";
     	if(list.length==0){
     		msg = msg + "<tr align=\"center\" height=\"25\"><td colspan=\"4\">暂无部门信息！</td</tr>";
     	}else{
     		for(var obj in list){
     			if(!isNaN(obj)){
     				msg = msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
     				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].bmmc+"\">"+
     				"<input type=\"hidden\" name=\"ls1\" value=\""+list[obj].ssjg+"\">"+
     				"</td><td>"+list[obj].bmbh+"</td><td>"+list[obj].bmmc+"</td><td>"+list[obj].ssjg+"</td></tr>";
     			}
     		}
     	}
     	msg = msg + "</table>";
     	msg = msg + pageMsg(data,"pageBdata");
     	div1.innerHTML=msg;
     }
     function clickHid(){
     	document.getElementById("show-btn").click();
     }
     function pageMsg(data,fn){
     	var msg = "";
     	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
     		"<tr><td align=\"right\">"+
     		"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页&nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
     		"<input type=\"button\" name=\"first\" class=\"inputbutton3\" onclick=\""+fn+"(1);\">"+
     		"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onclick=\""+fn+"("+data.previouspage+");\">"+
     		"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onclick=\""+fn+"("+data.nextpage+");\">"+
     		"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+");\">"+
     		"</td></tr></table>";
     	return msg;
     }
     
     function back(){
    	window.location.href="./yggl.do?method=getList";
     }
    </script> 
  </head>
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
    <html:form action="/yggl.do?method=updateObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>员工修改</center></caption>
    		<tr >
    			<td width="30%"  align="right" class="td2">员工编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.ygbh" styleClass="input" readonly="true"/>
    				<div id="bhspan"></div>
    			</td>
    			<td width="15%" align="right">员工姓名&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.ygmc" styleClass="input"/>
    				<div id="mcspan"></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">性　　别&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				　<html:radio property="vo.ygxb" value="男"/>男　
    				<html:radio property="vo.ygxb" value="女"/>女
    			</td>
    			
    			<td align="right" class="td2">出生日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.csrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    		</tr>
    		
    		<tr>
    			<td align="right" class="td2">工作日期&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.gzrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    			<td align="right" class="td2">员工职位&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.ygzw" styleClass="input" readonly="true"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1);clickHid();"/>
    			</td>
    		</tr>
    		<tr>
    			
    			<td  align="right" class="td2">员工工资&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.yggz" styleClass="input"/><span class="tishi"><bean:message key="number"/></span>
    			</td>
    			<td align="right" class="td2">所属部门&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    			     <html:text property="vo.ssbm" styleClass="input" readonly="true"/>
    			    <html:hidden property="vo.ssjg" styleClass="input"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);clickHid();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ygdh" styleClass="input"/><div class="tishi"><bean:message key="phone"/></div>
    			</td>
    			<td align="right" class="td2">身份证号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sfzh" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工状态&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.ygzt" styleClass="input">
    					<html:option value="0">空闲</html:option>
    					<html:option value="1">忙碌</html:option>
    				</html:select>
    			</td>
    			<td align="right" class="td2">员工地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.ygdz" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">员工描述&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td colspan="3" align="left">
    				<html:textarea  property="vo.ygms" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" class="td2">
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.ygzj"/>
    				<input type="hidden" name="show-btn">
    			</td>
    		</tr>
    	</table>
    </html:form>
    <div id="hello-win" class="x-hidden">
    	<div id="hello-tabs">
    		<div class="tanchang" id="div1"></div>
    	</div>
    </div>
  </body>
</html>
