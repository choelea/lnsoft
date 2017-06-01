<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" />
		</title>
		<script type="text/javascript">
	function $(tag){
		return document.getElementById(tag);
	}
	function isNull(){
		var ysdbh = $("yspsd.ysdbh");
		if(ysdbh.value==""){
			alert("请选择订单！");
			return false;
		}
	}
	function back(){
		window.location.href="<%=request.getContextPath()%>/khfk.do?method=getList";
	}
	function toCheck(temp){
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
	function getPagedata(curpage){
		var hql = " select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,D.dwmc,E.dwmc,D.ssjg,E.ssjg) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.yszt >= 4 and (A.sffd != 1 or A.sffd is null)" ;
		var countHql = " select count(*) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.yszt = 4 and (A.sffd != 1 or A.sffd is null)";
		UserDWR.getPageinfo(countHql, hql, curpage,10,null,cdc);
		clickHid();
	}
	function setValue(){
		var infokind = document.all("pagemsglx").value;
		var temp = document.getElementsByName("pk");
		if("ysd"==infokind){
			var i = toCheck(temp);
			if(i!=-1){
				var ysdzj = $("yspsd.ysdzj");
				var ysdbh = $("yspsd.ysdbh");
				var fkr = $("vo.fkr");
				var fhr = $("vo.fhr");
				var sfzz = $("vo.sfz");
				var mdzz = $("vo.mdz");
				var psh = document.getElementsByName("lsid");
				var ls = document.getElementsByName("ls");
				var dhf = document.getElementsByName("dhfmc");
				var shf = document.getElementsByName("shfmc");
				var sfz = document.getElementsByName("sfz");
				var mdz = document.getElementsByName("mdz");
				ysdzj.value=psh[i].value;
				ysdbh.value=ls[i].value;
				fkr.value = shf[i].value;
				fhr.value = dhf[i].value;
				sfzz.value = sfz[i].value;
				mdzz.value = mdz[i].value;
				var hql = " from Khddhpb where 1=1 and ddzj = (select A.khht.khdd.ddzj from Yspsd A where A.ysdzj ="+psh[i].value+")";
				UserDWR.getList(hql,null,function (data){
					var list = data;
					var tbody = $("hpTab").lastChild;
					$("hpTab").removeChild(tbody);
					var tbody = document.createElement("tbody");
					for(var i in list){
						if(!isNaN(i)){
							var tj = 0;
							var trE = document.createElement("<tr align='center'>");
					     	var tdE1 = document.createElement("td");
					     	tdE1.innerText=list[i].hpbm;
					     	var tdE2 = document.createElement("td");
					     	tdE2.innerText=list[i].hpmc;
					     	var tdE3 = document.createElement("td");
					     	tdE3.innerText=list[i].hplx;
					     	var tdE4 = document.createElement("td");
					     	tdE4.innerText=list[i].hptj;
					     	var tdE7 = document.createElement("td");
					     	tdE7.innerText=list[i].tjdw;
					     	var tdE5 = document.createElement("td");
					     	tdE5.innerText=list[i].hpdw;
					     	var tdE6 = document.createElement("td");
					     	tdE6.innerText=list[i].hpsl;
					     	trE.appendChild(tdE1);
					     	trE.appendChild(tdE2);
					     	trE.appendChild(tdE3);
					     	trE.appendChild(tdE4);
					     	trE.appendChild(tdE7);
					     	trE.appendChild(tdE5);
					     	trE.appendChild(tdE6);
					        tbody.appendChild(trE);
						}
					}
					$("hpTab").appendChild(tbody);
				});
			}
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
   		msg = msg + pageMsg(data,"getPagedata");
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
		<html:form action="/khfk.do?method=save" method="post"
			onsubmit="return isNull();">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<caption>
					<center>客户返单</center>
				</caption>
				<tr>
					<td align="right" width="25%">
						返单编号&nbsp;&nbsp;
					</td>
					<td width="25%">
						<html:text property="vo.fkbh" styleClass="input" readonly="true"></html:text>
					<td align="right" width="20%">
						运输单号&nbsp;&nbsp;
					</td>
					<td >
						<html:text property="yspsd.ysdbh" styleClass="input" readonly="true"></html:text>
						<html:hidden property="yspsd.ysdzj"/>
						<img src="<%=request.getContextPath()%>/images/button/export.jpg"
							alt="点击选择" style="cursor:hand;" onclick="getPagedata(1);" />
					</td>
				</tr>
				<tr>
					<td align="right">委 托 方&nbsp;&nbsp;</td>
					<td><html:text property="vo.fhr" styleClass="input" readonly="true"></html:text></td>
					<td align="right">收 货 方&nbsp;&nbsp;</td>
					<td><html:text property="vo.fkr" styleClass="input" readonly="true"></html:text></td>
				</tr>
				<tr>
					<td align="right">始 发 站&nbsp;&nbsp;</td>
					<td><html:text property="vo.sfz" styleClass="input" readonly="true"></html:text></td>
					<td align="right">目 的 站&nbsp;&nbsp;</td>
					<td><html:text property="vo.mdz" styleClass="input" readonly="true"></html:text></td>
				</tr>
				<tr>
					<td align="right">备 注&nbsp;&nbsp;</td>
					<td colspan="3"><html:textarea property="vo.fkbz" cols="50" rows="4"/></td>
				</tr>
				<tr>
					<td align="right">制 单 人&nbsp;&nbsp;</td>
					<td><html:text property="vo.fksj" styleClass="input" readonly="true" value="${userTName}"/></td>
					<td align="right">制单日期&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.fksj" styleClass="input" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<table id="hpTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<caption><center>货品信息</center></caption>
							<thead>
								<tr align="center">
									<td>货品编码</td>
									<td>货品名称</td>
									<td>货品类型</td>
									<td>货品体积</td>
									<td>体积单位</td>
									<td>货品单位</td>
									<td>货品数量</td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<html:submit value="添 加" styleClass="inputbutton"></html:submit>
						<input type="button" value="返 回" onclick="back();" class="inputbutton">
						<html:hidden property="vo.ssxs" value="${userPk }"/>
    					<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
						<html:hidden property="vo.fkzt" value="0" />
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