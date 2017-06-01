<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
<head>
<title><bean:message key="system.title"/></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
	<script type="text/javascript">
		function $(tag){
			return document.getElementById(tag);
		}
		function isNull(){
			var kfbh = $("kfbh");
			var sblx = $("vo.sblx");
			var dllx = $("vo.dllx");
			var kzhc = $("vo.kzhc");
			var kzhk = $("vo.kzhk");
			var kzhg = $("vo.kzhg");
			var dpgd = $("vo.dpgd");
			var zzl = $("vo.zzl");
			var syzt = $("vo.sbzt");
			var rylx = $("vo.rylx");
			var sbjz = $("vo.sbjz");
			var gl = $("vo.gl");
			var gmrq = $("vo.gmrq");
			if(kfbh.value==""){
				alert("请选择所在仓库！");
				return false;
			}
			if(sblx.value==""){
				alert("请选择设备类型!");
				return false;
			}
			if(dllx.value==""){
				alert("请选择动力类型!");
				return false;
			}
			if(kzhc&&isNaN(kzhc.value)){
				alert("可载货长格式不正确!");
				return false;
			}
			if(kzhk&&isNaN(kzhk.value)){
				alert("可载货宽格式不正确!");
				return false;
			}
			if(kzhg&&isNaN(kzhg.value)){
				alert("可载货高格式不正确!");
				return false;
			}
			if(zzl&&isNaN(zzl.value)){
				alert("载重量格式不正确!");
				return false;
			}
			if(syzt.value==""){
				alert("请选择设备状态!");
				return false;
			}
			if(sbjz&&isNaN(sbjz.value)){
				alert("设备价值格式不正确!");
				return false;
			}
			if(gl&&isNaN(gl.value)){
				alert("功率格式不正确!");
				return false;
			}
			if(gmrq){
				if(checkDate(gmrq.value)){
					alert("请输入正确的购买日期!");
					return false;
				}
			}
			return true;
		}
		function checkDate(date){
			var dat = date.split("-");
			var dat1 = new Date(dat[0],dat[1]-1,dat[2]);
			var dat2 = new Date();
			return dat1>dat2;
		}
		function setValue(){
			var infokind = document.all("infokind").value;
			if("kfxx"==infokind){
				var pk = document.getElementsByName("ls");
				var pks = document.getElementsByName("lsid");
				var kfbh = $("kfbh");
				var kfzj = $("kfzj");
				var i = ToDel(pk);
				if(i != -1){
					kfbh.value = pk[i].value;
					kfzj.value = pks[i].value;
				}
			}
			if("sbxx"==infokind){
				var pk = document.getElementsByName("ls");
				var zdmc = document.getElementsByName("psh");
				var clzt = $("vo.sblx");
				var i = ToDel(pk);
				if(i != -1){
					clzt.value = pk[i].value;
				}
			}
			if("dlxx"==infokind){
				var pk = document.getElementsByName("ls");
				var zdmc = document.getElementsByName("psh");
				var clzt = $("vo.dllx");;
				var i = ToDel(pk);
				if(i != -1){
					clzt.value = pk[i].value;
				}
			}
			if("syzt"==infokind){
				var pk = document.getElementsByName("ls");
				var zdmc = document.getElementsByName("psh");
				var clzt = $("vo.sbzt");;
				var i = ToDel(pk);
				if(i != -1){
					clzt.value = pk[i].value;
				}
			}
			if("rylx"==infokind){
				var pk = document.getElementsByName("ls");
				var zdmc = document.getElementsByName("psh");
				var clzt = $("vo.rylx");;
				var i = ToDel(pk);
				if(i != -1){
					clzt.value = pk[i].value;
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
		function getParamterA(curpage){//仓库
			$("show-btn").click();
			var countHql = "select count(*) from Kfxx where 1=1 and ssxs = ${userPk} and sssysz = ${userSyszzj}";
			var hql = " from Kfxx where 1=1 and ssxs = ${userPk} and sssysz = ${userSyszzj}";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null, cda);
		}
		function pageBdata(curpage){//设备类型
    		$("show-btn").click();
    		UserDWR.getSjzdmx(curpage,4,cdb);
    	}
    	function pageCdata(curpage){//动力
    		$("show-btn").click();
    		UserDWR.getSjzdmx(curpage,5,cdc);
    	}
    	function pageDdata(curpage){//状态
    		$("show-btn").click();
    		UserDWR.getSjzdmx(curpage,3,cdd);
    	}
    	function pageEdata(curpage){//燃油
    		$("show-btn").click();
    		UserDWR.getSjzdmx(curpage,6,cde);
    	}
    	function cda(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
    			"<tr align=\"center\" height=\"30\">"+
    			"<td>选择<input type='hidden' name='infokind' value='kfxx'></td><td>仓库编号</td><td>仓库名称</td></tr>";
			if(list.length==0){
				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无仓库信息！</td></tr>";
			}else{
	    		for(var obj in list){
	    			if(!isNaN(obj)){
	    				msg=msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
	    				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].kfmc+"\">"+
	    				"<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].kfzj+"\">"+
	    				"</td><td>"+list[obj].kfbh+"</td><td>"+list[obj].kfmc+"</td></tr>";
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
    			"<td>选择<input type='hidden' name='infokind' value='sbxx'></td><td>设备编号</td><td>设备名称</td></tr>";
			if(list.length==0){
				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无设备信息！</td></tr>";
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
    		msg = msg + pageMsg(data,"pageBdata");
    		div1.innerHTML = msg;
    	}
    	function cdc(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
    			"<tr align=\"center\" height=\"30\">"+
    			"<td>选择<input type='hidden' name='infokind' value='dlxx'></td><td>动力类型编号</td><td>动力类型名称</td></tr>";
			if(list.length==0){
				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无动力类型信息！</td></tr>";
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
    		msg = msg + pageMsg(data,"pageCdata");
    		div1.innerHTML = msg;
    	}
    	function cdd(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
    			"<tr align=\"center\" height=\"30\">"+
    			"<td>选择<input type='hidden' name='infokind' value='syzt'></td><td>状态编号</td><td>状态名称</td></tr>";
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
    		msg = msg + pageMsg(data,"pageDdata");
    		div1.innerHTML = msg;
    	}	
    	function cde(data){
    		var list = data.pagedata;
    		var div1 = document.getElementById("div1");
    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
    			"<tr align=\"center\" height=\"30\">"+
    			"<td>选择<input type='hidden' name='infokind' value='rylx'></td><td>燃油类型编号</td><td>燃油类型名称</td></tr>";
			if(list.length==0){
				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无燃油类型信息！</td></tr>";
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
    		msg = msg + pageMsg(data,"pageEdata");
    		div1.innerHTML = msg;
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
			window.location.href="<%=request.getContextPath()%>/sbxx.do?method=getList&rmMsg=true";
		}
	</script>
  </head>
  
  <body>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
    <html:form action="/sbxx.do?method=update" method="post" onsubmit="return isNull();">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>设备修改</center></caption>
  			<tr>
  				<td width="25%" align="right">设备编号&nbsp;&nbsp;</td>
  				<td width="25%">
  					<html:text property="vo.sbbh" styleClass="input" readonly="true"/>
  				</td>
  				<td width="20%" align="right">所在仓库<font color="red">*</font></td>
  				<td>
  					<input type="text" name="kfbh" readonly="readonly" value="${kfbh }" class="input">
  					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="getParamterA(1);"/>
  					<input type="hidden" name="kfzj" value="${kfzj }">
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备类型<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.sblx" styleClass="input" readonly="true"/>
  					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="pageBdata(1);"/>
  				</td>
  				<td align="right">动力类型<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.dllx" styleClass="input" readonly="true"/>
  					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="pageCdata(1);"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">可载货长(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhc" styleClass="input"/></td>
  				<td align="right">可载货宽(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhk" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">可载货高(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.kzhg" styleClass="input"/></td>
  				<td align="right">底盘高度(米)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.dpgd" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">载重量(吨)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.zzl" styleClass="input"/></td>
  				<td align="right">颜 色&nbsp;&nbsp;</td>
  				<td><html:text property="vo.ys" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">使用状态<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.sbzt" styleClass="input" readonly="true"/>
  					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="pageDdata(1);"/>
  				</td>
  				<td align="right">燃油类型&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.rylx" styleClass="input" readonly="true"/>
  					<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="pageEdata(1);"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备价值&nbsp;&nbsp;</td>
  				<td><html:text property="vo.sbjz" styleClass="input"/></td>
  				<td align="right">功 率(W)&nbsp;&nbsp;</td>
  				<td><html:text property="vo.gl" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">购买日期&nbsp;&nbsp;</td>
  				<td>
  					<html:text property="vo.gmrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
  				</td>
  				<td align="right">生产厂商&nbsp;&nbsp;</td>
  				<td><html:text property="vo.sccj" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">备 注&nbsp;&nbsp;</td>
  				<td colspan="3"><html:textarea property="vo.bzxx" rows="4" cols="50"/></td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<html:submit value="修 改" styleClass="inputbutton"></html:submit>
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">
  					<html:hidden property="vo.sbzj"/>
  					<html:hidden property="vo.sssysz" />
  					<html:hidden property="vo.ssxs" />
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