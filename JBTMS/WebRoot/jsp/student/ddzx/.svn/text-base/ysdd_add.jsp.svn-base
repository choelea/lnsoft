<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
			var strr = "";
			var zsfz = "";
			var zmdz = "";
			function $(tag){
				return document.getElementById(tag);
			}
			function isNull(){
				var ddlx = $("vo.ysddlx");
				var ysfs = $("vo.ysfs");
				var bxbh = $("bxxx.bxbh");
				var ysdzj = $("yddd[0].ysdzj");
				var tab = $("ysdTab");
				if(ddlx.value==""){
					alert("请选择调度类型!");
					return false;
				}
				if(ysfs.value==""){
					alert("请选择运输方式!");
					return false;
				}
				if(bxbh.value==""){
					alert("请选择班线!");
					return false;
				}
				if(tab.rows.length<=1){
					alert("请选择运输配送订单!");
					return false;
				}
			}
			function back(){
	    		window.location.href="<%=request.getContextPath()%>/ddfj.do?method=getList&page=1";
	    	}
	    	function clickHid(){
	    		document.getElementById("show-btn").click();
	        }
	        function ToDel(temp) { 
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
			function setValue(){		
				var pk = document.getElementsByName("pk");			
				var i = ToDel(pk);
				if(i!=-1){
					var pagemsglx = document.all("pagemsglx");
					var ls = document.getElementsByName("ls");
					var lsid = document.getElementsByName("lsid");
					if(pagemsglx.value=='ysfslx'){					
						var rkjs = document.all("vo.ysfs");
						rkjs.value=ls[i].value;
					}else if(pagemsglx.value=='bx'){
						var bxzj = document.all("bxxx.bxzj");
						var bxbh = document.all("bxxx.bxbh");
						var sfz = document.getElementsByName("bxsfz");
						var mdz = document.getElementsByName("bxmdz");
						bxbh.value=ls[i].value;
						bxzj.value=lsid[i].value;
						var tbody = $("bxTab").lastChild;
						$("bxTab").removeChild(tbody);
						var tbody = document.createElement("tbody");
						var trE = document.createElement("<tr align='center'>");
				     	var tdE1 = document.createElement("td");
				     	tdE1.innerText=sfz[i].value;
				     	var tdE2 = document.createElement("td");
				     	tdE2.innerText=mdz[i].value;
				     	strr = "('"
				     	strr += sfz[i].value + "','";
				     	strr += mdz[i].value + "'";
				     	var tdE3 = document.createElement("td");
						var hql = "select A from Bxlc A inner join A.bxxx B where 1=1 and B.bxzj = " + lsid[i].value +" order by A.tksx";
						var str = "";
						UserDWR.getList(hql,null,function cdb(data){
						     zhongzhuan = data;
						     if(data.length!=0){
						     	for(var i=0;i<data.length;i++){
							     	if(i!=data.length-1){
							     		str += data[i].bxzd +"、";
							     		strr += ",'"+ data[i].bxzd + "'";
							     	}else {
							     		str += data[i].bxzd;
							     		strr += ",'" + data[i].bxzd + "')";
							     	}
							     }
						     	tdE3.innerText=str;
						     }else {
						     	tdE3.innerText="无通达地区";
						     	strr += ")";
						     }
						});
						
				     	trE.appendChild(tdE1);
				     	trE.appendChild(tdE2);
				     	trE.appendChild(tdE3);
				        tbody.appendChild(trE);
						$("bxTab").appendChild(tbody);
						$("bxxx").style.display="block";
					}else if(pagemsglx.value=='ysd'){					
						var dhfmc = document.getElementsByName("dhfmc");
						var shfmc = document.getElementsByName("shfmc");
						var sfz = document.getElementsByName("sfz");
						var mdz = document.getElementsByName("mdz");
						var ysfs = document.getElementsByName("ysfs");
						var tbody = $("ysdTab").lastChild;
						$("ysdTab").removeChild(tbody);
						var tbody = document.createElement("tbody");
						for(var i=0;i<pk.length;i++){
							if(pk[i].checked){
								var trE = document.createElement("<tr align='center'>");
								var inp = document.createElement("<input type='hidden' name='yddd["+i+"].ysdzj' value='"+lsid[i].value+"'>" );
						     	var tdE1 = document.createElement("td");
						     	tdE1.innerText=ls[i].value;
						     	tdE1.appendChild(inp);
						     	var tdE2 = document.createElement("td");
						     	tdE2.innerText=dhfmc[i].value;
						     	var tdE3 = document.createElement("td");
						     	tdE3.innerText=shfmc[i].value;
						     	var tdE4 = document.createElement("td");
						     	tdE4.innerText=sfz[i].value;
						     	zsfz = sfz[i].value;
						     	var tdE5 = document.createElement("td");
						     	tdE5.innerText=mdz[i].value;
						     	zmdz = mdz[i].value;
						     	var tdE6 = document.createElement("td");
						     	tdE6.innerText=ysfs[i].value;
						     	var tdE7 = document.createElement("td");
						     	var butE = document.createElement("<img src='<%=request.getContextPath()%>/images/button/del.gif' alt='点击删除' style='cursor:hand;' onclick='delTrE(this);'>");
						     	tdE7.appendChild(butE);
						     	trE.appendChild(tdE1);
						     	trE.appendChild(tdE2);
						     	trE.appendChild(tdE3);
						     	trE.appendChild(tdE4);
						     	trE.appendChild(tdE5);
						     	trE.appendChild(tdE6);
						     	trE.appendChild(tdE7);
						        tbody.appendChild(trE);
							}
						}
						$("ysdTab").appendChild(tbody);
					}
				}
			}
			function delTrE(obj){
				var tabId = document.getElementById("ysdTab");
				var tbody = tabId.lastChild;
				tbody.removeChild(obj.parentNode.parentNode);
			}
	    	function pageAdata(curpage){
	    		var ddlx = $("vo.ysddlx");
	    		var ysfs = $("vo.ysfs");
	    		var bxxx = $("bxxx.bxzj");
	    		var i = ToDel(ddlx);
	    		var bysfs = ysfs.value.substring(0,2);
	    		var ysdlx = ddlx.value;
	    		var pArr = new Array();
	    		pArr[0]=ysdlx;
	    		pArr[1]="%"+bysfs+"%";
	    		if(ddlx.value==""){
	    			alert("请先选择调度类型!");
	    			return false;
	    		}else if(ysfs.value==""){
	    			alert("请先选择运输方式!");
	    			return false;
	    		}else if(ddlx.value=="配送"){
	    			if(bxxx.value==""||bxxx.value==null||bxxx.value==0){
		    			alert("请先选择班线!");
		    			return false;
		    		}else {
			    		var hql = " select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,A.khht.khdd.khxxByKhzj.dwmc,A.khht.khdd.khxxByKhxKhzj.dwmc,A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg) from Yspsd A where not exists "+
			    		"(select A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg from Yspsd A where A.khht.khdd.khxxByKhzj.ssjg not in "+strr+" and A.khht.khdd.khxxByKhxKhzj.ssjg not in "+strr+
			    		") and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ysdlx = ? and A.yszt = 1 and A.ysfs like ? " ;
						var countHql = " select count(*) from Yspsd A where not exists "+
			    		"(select A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg from Yspsd A where A.khht.khdd.khxxByKhzj.ssjg not in "+strr+" and A.khht.khdd.khxxByKhxKhzj.ssjg not in "+strr+
			    		") and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ysdlx = ? and A.yszt = 1 and A.ysfs like ? " ;
						UserDWR.getPageinfo(countHql, hql, curpage,10,pArr,cdc);
						clickHid();
	    			}
	    		}else {
		    		var hql = " select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,D.dwmc,E.dwmc,D.ssjg,E.ssjg) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ysdlx = ? and A.yszt = 1 and A.ysfs like ? " ;
					var countHql = " select count(*) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ysdlx = ? and A.yszt = 1 and A.ysfs like ?";
					UserDWR.getPageinfo(countHql, hql, curpage,10,pArr,cdb);
					clickHid();
	    		}
	    	}
	    	function cdc(data){
		    	var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='ysd'></td><td>订单编号</td><td>始发站</td><td>目的站</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ysdbh+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ysdzj+"\">"+
							  "<input type=\"hidden\" name=\"dhfmc\" value=\""+list[obj].dhfmc+"\">"+
							  "<input type=\"hidden\" name=\"shfmc\" value=\""+list[obj].shfmc+"\">"+
							  "<input type=\"hidden\" name=\"sfz\" value=\""+list[obj].sfz+"\">"+
							  "<input type=\"hidden\" name=\"mdz\" value=\""+list[obj].mdz+"\">"+
							  "<input type=\"hidden\" name=\"ysfs\" value=\""+list[obj].ysfs+"\">"+
							  "</td><td>"+list[obj].ysdbh+"</td><td>"+list[obj].sfz+"</td><td>"+list[obj].mdz+"</td></tr >";
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无订单信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"pageAdata");
	    		div1.innerHTML=msg;    		
	    	}
	    	function cdb(data){
		    	var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='ysd'></td><td>订单编号</td><td>始发站</td><td>目的站</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ysdbh+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ysdzj+"\">"+
							  "<input type=\"hidden\" name=\"dhfmc\" value=\""+list[obj].dhfmc+"\">"+
							  "<input type=\"hidden\" name=\"shfmc\" value=\""+list[obj].shfmc+"\">"+
							  "<input type=\"hidden\" name=\"sfz\" value=\""+list[obj].sfz+"\">"+
							  "<input type=\"hidden\" name=\"mdz\" value=\""+list[obj].mdz+"\">"+
							  "<input type=\"hidden\" name=\"ysfs\" value=\""+list[obj].ysfs+"\">"+
							  "</td><td>"+list[obj].ysdbh+"</td><td>"+list[obj].sfz+"</td><td>"+list[obj].mdz+"</td></tr >";
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无订单信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"pageAdata");
	    		div1.innerHTML=msg;    		
	    	}
	    	function pageBdata(curpage){
	    		var ddlx = $("vo.ysddlx");
	    		var ysdzj = document.getElementById("yddd[0].ysdzj");
				var tab = $("ysdTab");
	    		var i = ToDel(ddlx);
	    		if(ddlx.value==""){
	    			alert("请先选择调度类型!");
	    			return false;
	    		}else if(ddlx.value=="配送"){
	    			var hql = "select A from Bxxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) order by size(A.bxlcs)" ;
					var countHql = " select count(*) from Bxxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) ";
					UserDWR.getPageinfo(countHql, hql, curpage,10,null,cda);
					clickHid();
					return ;
	    		}else if(tab.rows.length<=1){
	    			alert("请先选择订单!");
	    			return false;
		    		}else {
		    			var hql = "select A from Bxxx A where (A.sfz = '"+zsfz+"' or A.mdz = '"+zsfz+"' or '"+zsfz+"' in (select B.bxzd from Bxlc B where B.bxxx.bxzj = A.bxzj )) and (A.sfz = '"+zmdz+"' or A.mdz = '"+zmdz+"' or '"+zmdz+"' in (select B.bxzd from Bxlc B where B.bxxx.bxzj = A.bxzj)) and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) order by size(A.bxlcs)" ;
						var countHql = " select count(*) from Bxxx A where (A.sfz = '"+zsfz+"' or A.mdz = '"+zsfz+"' or '"+zsfz+"' in (select B.bxzd from Bxlc B where B.bxxx.bxzj = A.bxzj )) and (A.sfz = '"+zmdz+"' or A.mdz = '"+zmdz+"' or '"+zmdz+"' in (select B.bxzd from Bxlc B where B.bxxx.bxzj = A.bxzj)) and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0)" ;
						UserDWR.getPageinfo(countHql, hql, curpage,10,null,cda);
						clickHid();
		    		}
	    	}
	    	function cda(data){
		    	var list = data.pagedata;
	    		var div1 = document.getElementById("div1");
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='bx'></td><td>班线编号</td><td>始发站</td><td>目的站</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].bxbh+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].bxzj+"\">"+
							  "<input type=\"hidden\" name=\"bxsfz\" value=\""+list[obj].sfz+"\">"+
							  "<input type=\"hidden\" name=\"bxmdz\" value=\""+list[obj].mdz+"\">"+
							  "</td><td>"+list[obj].bxbh+"</td><td>"+list[obj].sfz+"</td><td>"+list[obj].mdz+"</td></tr >";
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无班线信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"pageBdata");
	    		div1.innerHTML=msg;    		
	    	}
	    	
	    	function pagedata(curpage){
	    		UserDWR.getSjzdmx(curpage,2,cd);
	    		clickHid();
	    	}	
	    	function cd(data){
		    	var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='ysfslx'></td><td>运输方式编号</td><td>运输方式名称</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
								"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无运输方式信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"pagedata");
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
	    	function change2(){
	    		var ysdBody = $("ysdTab").lastChild;
	    		var bxBody = $("bxTab").lastChild;
	    		$("ysdTab").removeChild(ysdBody);
	    		$("bxTab").removeChild(bxBody);
	    		var ybody = document.createElement("tbody");
	    		var bbody = document.createElement("tbody");
	    		$("ysdTab").appendChild(ybody);
	    		$("bxTab").appendChild(bbody);
	    		$("bxxx.bxbh").value="";
	    		$("bxxx.bxzj").value="";
	    	}
 		</script>
	</head>
	<body>
		<html:form action="/ddfj.do?method=save" method="post" onsubmit="return isNull();">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>调度单录入</center></caption>
				<tr>
					<td width="25%" align="right">调度单号&nbsp;&nbsp;</td>
					<td width="25%">
						<html:text property="vo.ysddbh" readonly="true" styleClass="input"/>
					</td>
					<td width="20%" align="right">调度类型<font color="red">*</font></td>
					<td >
						<html:select property="vo.ysddlx" onchange="change2();">
							<html:option value="">请选择调度类型</html:option>
							<html:option value="运输">整 车</html:option>
							<html:option value="配送">零 担</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right">运输方式<font color="red">*</font></td>
					<td>
						<html:text property="vo.ysfs"  styleClass="input" readonly="true"/>
						<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagedata(1);"/>
					</td>
					<td width="20%" align="right">班线选择<font color="red">*</font></td>
					<td>
						<html:text property="bxxx.bxbh"  styleClass="input" readonly="true"/>
						<html:hidden property="bxxx.bxzj"/>
						<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);"/>
					</td>
				</tr>
				<tr style="display: none;" id="bxxx">
					<td colspan="4">
						<table id="bxTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr>
									<td colspan="3" align="center">班线信息</td>
								</tr>
								<tr align="center">
									<td>始发站</td>
									<td>终点站</td>
									<td>通达地区</td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
				<tr>    			
	    			<td align="center" colspan="4">订单选择<font color="red">*</font>
	    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1);"/>
	    			</td>
    			</tr>
				<tr>
					<td colspan="4">
						<table id="ysdTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr align="center">
									<td>订单编号</td>
									<td>委托方</td>
									<td>收货方</td>
									<td>始发站</td>
									<td>终点站</td>
									<td>运输方式</td>
									<td>操 作</td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="4" >
						<input type="hidden" id="show-btn" />
						<html:hidden property="vo.ssxs" value="${userPk }"/>
    				    <html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				    <html:hidden property="vo.ysddzt" value="0"/>
    				    <html:hidden property="vo.sfpg" value="0"/>
    				    <html:hidden property="vo.sfpc" value="0"/>
						<html:submit styleClass="inputbutton">添 加</html:submit>
						<input type="button" value="返 回" class="inputbutton" onclick="back();" />
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