<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/extjs.jsp" %>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
     function $(tag){
     	return document.getElementById(tag);
     }
     var flag1=false;
     function IsNull(){
     	var cllx = $("vo.cllx");
     	var ssyzdmc = $("vo.ssjg");
     	var syzt = $("vo.syzt");
     	var cph = $("vo.cph");
     	var kzhc = $("vo.kzhc");
     	var kzhk = $("vo.kzhk");
     	var kzhg = $("vo.kzhg");
     	var zdcr = $("vo.zdcr");
     	var zddxcc = $("vo.zddxcc");
     	var zdhz = $("vo.zdhz");
     	var cph = $("vo.cph");
     	var isNum = /^[0-9]*$/;
     	if(cph.value==""){
     		alert("请输入车牌号！");
     		return false;
     	}
     	if(kzhc.value==""){
     		alert("请输入可载货长！");
     		return false;
     	}else if(isNaN(kzhc.value)||parseFloat(kzhg.value)<0){
   			alert("可载货长格式输入有误！");
   			return false;
   		}
   		if(kzhk.value==""){
     		alert("请输入可载货宽！");
     		return false;
     	}else if(isNaN(kzhk.value)||parseFloat(kzhg.value)<0){
   			alert("可载货宽格式输入有误！");
   			return false;
   		}
   		if(kzhg.value==""){
     		alert("请输入可载货高！");
     		return false;
     	}else if(isNaN(kzhg.value)||parseFloat(kzhg.value)<0){
   			alert("可载货高格式输入有误！");
   			return false;
   		}
     	if(zddxcc){
     		if(isNaN(zddxcc.value)){
     			alert("最大单项尺寸格式输入有误！");
     			return false;
     		}else if(parseFloat(zddxcc.value)>parseFloat(kzhc.value)){
     			alert("最大单项尺寸超出可载货长！");
     			return false;
     		}
     	}
     	if(zdcr){
     		if(isNaN(zdcr.value)||parseFloat(kzhg.value)<0){
     			alert("车容格式输入有误！");
     			return false;
     		}else if(parseFloat(zdcr.value)>(parseFloat(kzhc.value)*parseFloat(kzhk.value)*parseFloat(kzhg.value))){
     			alert("车容超出车辆最大体积！");
     			return false;
     		}
     	}
     	if(zdhz){
     		if(isNaN(zdhz.value)||parseFloat(zdhz.value)<0){
     			alert("核载格式输入有误！");
     			return false;
     		}
     	}
     	if(ssyzdmc.value=="") {
     		alert("请输入车辆所属站点信息!");
     	   	return false;
     	}
     	if(cllx.value=="") {
     		alert("请输入车辆类型!");
     	   	return false;
     	}
     	if(syzt.value=="") {
     		alert("请输入车辆使用状态");
     	   	return false;
     	}
     	
     }
     
     function setValue(){
			var pk = document.getElementsByName("pk");			
			var i = ToDel();
			if(i!=-1){
				var pagemsglx = document.all("pagemsglx");
				var ls = document.getElementsByName("ls");
				if(pagemsglx.value=='cheliang'){					
					var rkjs = document.all("vo.cllx");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='syzt'){
					var rkjs = document.all("vo.syzt");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='station'){
					var rkjs = document.all("vo.ssjg");
					rkjs.value=ls[i].value;
				}
			}
		}
    	function ToDel() { 
		  var temp=document.getElementsByName("pk"); 
		  var count=-1;
		  for (i=0;i<temp.length;i++){ 
		    if(temp[i].checked){
		    	return i; 
		     } 
		  } 
		  return count;
		} 
    	function pageAdata(curpage){
    		UserDWR.getSjzdmx(curpage,3,cda);
    	}
    	function pageBdata(curpage){
    		UserDWR.getSjzdmx(curpage,1,cdb);
    	}
    	function pageCdata(curpage){
    		UserDWR.getSjzdmx(curpage,16,cdc);
    	}
    	function cda(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
    			"<tr align=\"center\" height=\"30\">"+
    			"<td>选择<input type='hidden' name='pagemsglx' value='syzt'></td><td>状态编号</td><td>状态名称</td></tr>";
			if(list.length==0){
				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无状态信息！</td></tr>";
			}else{
	    		for(var obj in list){
	    			if(!isNaN(obj)){
	    				msg=msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
	    				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
	    				"<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
	    				"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr>";
	    			}
	    		}
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageAdata");
    		div1.innerHTML = msg;
    	}	
    	function cdb(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='cheliang'></td><td>车辆类型编号</td><td>车辆类型名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg=msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无车辆类型信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageBdata");
    		div1.innerHTML=msg;
    	}
    	function cdc(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table width='100%' border='0' cellpadding='0' cellspacing='1' style='word-break:break-all;'>"+
    			"<tr align='center' height='30'><input type='hidden' name='pagemsglx' value='station'>"+
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
    function back(){   	
    	window.location.href = "<%=request.getContextPath()%>/clgl.do?method=getList";
    }
    function countMaxCr(){
    	var kzhc = $("vo.kzhc");
     	var kzhk = $("vo.kzhk");
     	var kzhg = $("vo.kzhg");
     	var zdcr = $("vo.zdcr");
     	if(kzhc.value!="" && kzhk.value!="" && kzhg.value!="" && !isNaN(kzhc.value) && !isNaN(kzhk.value) && !isNaN(kzhg.value)){
     		zdcr.value = parseFloat(kzhc.value)*parseFloat(kzhk.value)*parseFloat(kzhg.value);
     	}
    }
    </script>
  </head>
  <body>
    <html:form action="/clgl.do?method=update" method="post" onsubmit="return IsNull();" >
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center> 车辆录入</center></caption>
    		<tr >
    			<td width="30%" align="right" class="td2">车辆编号&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="vo.ylbh" styleClass="input" readonly="true"/>
    				<div id="bhspan"></div>
    			</td>
    			<td width="20%" align="right">车牌号<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.cph" styleClass="input"/>
    				<div id="mcspan"></div>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">可载货长(米)<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kzhc" styleClass="input" />
    			</td>
    			<td align="right">可载货宽(米)<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kzhk" styleClass="input"/>
    			</td>
    		</tr>   
    		<tr>
    			<td align="right" class="td2">可载货高(米)<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.kzhg" styleClass="input"/>
    			</td>
    				<td align="right">车容(立方米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdcr" styleClass="input" readonly="true" onclick="countMaxCr();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">最大单项尺寸(米)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zddxcc" styleClass="input"/>
    			</td>
    				<td align="right">核载(吨)&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdhz" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>	
    			<td align="right" class="td2">车的品牌&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.clpp" styleClass="input"/>
    			</td>
    			<td align="right">车辆状态<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.syzt" styleClass="input" readonly="true"/>
					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1);clickHid();"/>
				</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">所属站点<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"></html:text>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand" onclick="pageCdata(1);clickHid();">
    			</td>
    				<td align="right">车辆类型<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.cllx" styleClass="input" readonly="true"/>
					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);clickHid();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备注信息&nbsp;&nbsp;</td>
    			<td colspan="3"><html:textarea property="vo.bzxx" cols="50" rows="4"/></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" class="td2">
    				<html:submit styleClass="inputbutton">修　改</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<html:hidden property="vo.ylzj"/>
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    				<input type="hidden" id="show-btn"/> 
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
