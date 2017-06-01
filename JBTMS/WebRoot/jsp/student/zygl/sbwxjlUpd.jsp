<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
<head>
<title><bean:message key="system.title"/></title>
<link rel="stylesheet" type="text/css" href="./css/newdate.css" />
	<script type="text/javascript">
		function isNull(){
			var sbbh = $("vo.sbbh");
			var wxrq = $("vo.wxrq");
			var zxhs = $("vo.zxhs");
			var wxfy = $("vo.wxfy");
			var xlry = $("vo.xlry");
			var ssjg = $("vo.ssjg");
			if(sbbh.value==""){
				alert("请输入维修设备信息!");
				return false;
			}
			if(wxrq.value==""){
				alert("请输入维修日期!");
				return false;
			}else if(!checkDate(wxrq.value)){
				alert("维修日期不能小于当前日期!");
				return false;
			}
			if(zxhs.value==""){
				alert("请输入维修耗时!");
				return false;
			}else if(isNaN(zxhs.value)){
				alert("维修耗时输入有误!");
				return false;
			}
			if(wxfy.value==""){
				alert("请输入维修费用!");
				return false;
			}else if(isNaN(wxfy.value)){
				alert("维修费用输入有误!");
				return false;
			}
			if(xlry.value==""){
				alert("请指定维修人员信息!");
				return false;
			}
			if(ssjg.value==""){
				alert("请输入维修单所属机构!");
				return false;
			}
			return true;
		}
		function checkDate(date){
			var dat = date.split("-");
			var dat1 = new Date(dat[0],dat[1]-1,dat[2]);
			var dat2 = new Date();
			var y = dat2.getYear();
			var m = dat2.getMonth();
			var d = dat2.getDate();
			dat2 = new Date(y,m,d);
			return dat1>=dat2;
		}
		function setValue(){
			var infokind = document.all("infokind").value;
			var pk = document.getElementsByName("ls");
			var pk1 = document.getElementsByName("ls1");
			var pk2 = document.getElementsByName("ls2");
			if("sbxx"==infokind){
				var sbbh = $("vo.sbbh");
				var sblx = $("vo.sblx");
				var ssjg = $("vo.ssjg");
				var wxry = $("vo.xlry");
				var i = ToDel(pk);
				if(i != -1){
					sbbh.value = pk[i].value;
					sblx.value = pk1[i].value;
					ssjg.value = pk2[i].value;
					wxry.value="";
				}
			}else if("ygxx"==infokind){
				var xlry = $("vo.xlry");
				var i = ToDel(pk);
				if(i != -1){
					xlry.value = pk1[i].value;
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
		function getSbxx(curpage){//设备
			if('${curGwzj}'=='4'){
				var countHql = "select count(A) from Sbxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				var hql = "select new com.whjbsoft.www.vo.SbxxVo(A.sbzj,A.sbbh,A.sbbh,A.sblx,B.ssjg) from Sbxx A inner join A.kfxx B where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				UserDWR.getPageinfo(countHql, hql, curpage,10,null, function (data){
		    		var list = data.pagedata;
		    		var div1 = document.getElementById("div1");
		    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
		    			"<tr align=\"center\" height=\"30\">"+
		    			"<td>选择<input type='hidden' name='infokind' value='sbxx'></td><td>设备编号</td><td>设备类型</td></tr>";
					if(list.length==0){
						msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无设备信息！</td></tr>";
					}else{
			    		for(var obj in list){
			    			if(!isNaN(obj)){
			    				msg=msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
			    				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sbbh+"\">"+
			    				"<input type=\"hidden\" name=\"ls1\" value=\""+list[obj].sblx+"\">"+
			    				"<input type=\"hidden\" name=\"ls2\" value=\""+list[obj].sbzt+"\">"+
			    				"</td><td>"+list[obj].sbbh+"</td><td>"+list[obj].sblx+"</td></tr>";
			    			}
			    		}
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"getSbxx");
		    		div1.innerHTML = msg;
		    		$("show-btn").click();
		    	});
			}else if('${curGwzj}'=='2' || '${curGwzj}'=='3'){
				var countHql = "select count(A) from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				var hql = " from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				UserDWR.getPageinfo(countHql, hql, curpage,10,null, function (data){
		    		var list = data.pagedata;
		    		var div1 = document.getElementById("div1");
		    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
		    			"<tr align=\"center\" height=\"30\">"+
		    			"<td>选择<input type='hidden' name='infokind' value='sbxx'></td><td>车辆编号</td><td>车 牌 号</td><td>车辆类型</td></tr>";
					if(list.length==0){
						msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无车辆信息！</td></tr>";
					}else{
			    		for(var obj in list){
			    			if(!isNaN(obj)){
			    				msg=msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
			    				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ylbh+"\">"+
			    				"<input type=\"hidden\" name=\"ls1\" value=\"运输车辆\">"+
			    				"<input type=\"hidden\" name=\"ls2\" value=\""+list[obj].ssjg+"\">"+
			    				"</td><td>"+list[obj].ylbh+"</td><td>"+list[obj].cph+"</td><td>"+list[obj].cllx+"</td></tr>";
			    			}
			    		}
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"getSbxx");
		    		div1.innerHTML = msg;
		    		$("show-btn").click();
		    	});
			}		
		}
    	function getYgxx(curpage){//员工
    		var ssjg = $("vo.ssjg");
    		if(ssjg.value!=""){
    			var countHql = "select count(A) from Ygxx A where 1=1 and A.ssjg=? and A.ygzw='维修工' and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				var hql = " from Ygxx A where 1=1 and A.ssjg=? and A.ygzw='维修工' and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)";
				UserDWR.getPageinfo(countHql, hql, curpage,10,ssjg.value, function (data){
		    		var list = data.pagedata;
		    		var div1 = document.getElementById("div1");
		    		var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
		    			"<tr align=\"center\" height=\"30\">"+
		    			"<td>选择<input type='hidden' name='infokind' value='ygxx'></td><td>员工编号</td><td>员工姓名</td><td>员工职位</td></tr>";
					if(list.length==0){
						msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"4\">暂无员工信息！</td></tr>";
					}else{
			    		for(var obj in list){
			    			if(!isNaN(obj)){
			    				msg=msg + "<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\">"+
			    				"<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ygbh+"\">"+
			    				"<input type=\"hidden\" name=\"ls1\" value=\""+list[obj].ygmc+"\">"+
			    				"<input type=\"hidden\" name=\"ls2\" value=\""+list[obj].ssjg+"\">"+
			    				"</td><td>"+list[obj].ygbh+"</td><td>"+list[obj].ygmc+"</td><td>"+list[obj].ygzw+"</td></tr>";
			    			}
			    		}
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"getYgxx");
		    		div1.innerHTML = msg;
		    		$("show-btn").click();
		    	});
    		}else{
    			alert("请先选择维修设备信息!");
    		}
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
			window.location.href="./sbwxjl.do?method=objList";
		}
	</script>
  </head>
  
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
    <html:form action="/sbwxjl.do?method=updObject" method="post" onsubmit="return isNull();">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>设备维修管理</center></caption>
  			<tr>
  				<td width="25%" align="right">设备维修编号&nbsp;&nbsp;</td>
  				<td width="25%">
  					<html:text property="vo.sbwxjlbh" styleClass="input" readonly="true"/>
  					<html:hidden property="vo.sssysz"/>
  					<html:hidden property="vo.ssxs"/>
  					<html:hidden property="vo.ssxtmk"/>
  					<html:hidden property="vo.sbwxjlzj"/>
  					<input type="hidden" name="show-btn">
  				</td>
  				<td width="20%" align="right">设备编号<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.sbbh" styleClass="input" readonly="true"/>
  					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;"  onclick="getSbxx(1);"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">设备类型<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.sblx" styleClass="input" readonly="true"/>
  				</td>
  				<td align="right">维修日期<font color="red">*</font></td>
  				<td>
  					<html:text property="vo.wxrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">自修耗时(小时)<font color="red">*</font></td>
  				<td><html:text property="vo.zxhs" styleClass="input"/></td>
  				<td align="right">维修费用<font color="red">*</font></td>
  				<td><html:text property="vo.wxfy" styleClass="input"/></td>
  			</tr>
  			<tr>
  				<td align="right">维修方式&nbsp;&nbsp;</td>
  				<td><html:text property="vo.xlfs" styleClass="input"/></td>
  				<td align="right">维修人员<font color="red">*</font></td>
  				<td><html:text property="vo.xlry" styleClass="input" readonly="true"/>
  				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;"  onclick="getYgxx(1);"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">所属机构<font color="red">*</font></td>
  				<td><html:text property="vo.ssjg" styleClass="input" readonly="true"/></td>
  				<td align="right">制 单 人&nbsp;&nbsp;</td>
  				<td><html:text property="vo.zdr" styleClass="input" readonly="true"/></td>
  			</tr>
  			<tr>
  				<td align="right">维修原因&nbsp;&nbsp;</td>
  				<td colspan="3"><html:textarea property="vo.wxyy" rows="4" cols="50"/></td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<html:submit value="修 改" styleClass="inputbutton"></html:submit>
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">  					
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