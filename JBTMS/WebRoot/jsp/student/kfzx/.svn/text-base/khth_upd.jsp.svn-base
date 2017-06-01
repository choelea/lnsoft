<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
	<script>
		function $(tag){
			return document.getElementById(tag);
		}
		function back(){
			window.location.href="<%=request.getContextPath()%>/khth.do?method=getList";
		}
		function isNull(){
			var ddbh = $("yspsd.ysdbh");
			var ddzj = $("yspsd.ysdzj");
			var fhzd = $("vo.fhzd");
			var thrqm = $("vo.thrqm");
			var thyy = $("vo.thyy");
			if(ddbh.value==""||ddzj.value==""){
				alert("订单编号不能为空!");
				return false;
			}
			if(fhzd.value==""){
				alert("发货站点不能为空!");
				return false;
			}
			if(thrqm.value==""){
				alert("退货人签名不能为空!");
				return false;
			}
			if(thyy.value==""){
				alert("退货原因不能为空!");
				return false;
			}
			return true;
		}
		function getPagedata(curpage){
			var hql = " select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,D.dwmc,E.dwmc,D.ssjg,E.ssjg) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.yszt = 4 " ;
			var countHql = " select count(*) from Yspsd A inner join A.khht B inner join B.khdd C inner join C.khxxByKhzj D inner join C.khxxByKhxKhzj E where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ysdlx = ? and A.yszt = 4 ";
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
				var sfzz = $("vo.fhzd");
				var psh = document.getElementsByName("lsid");
				var ls = document.getElementsByName("ls");
				var sfz = document.getElementsByName("sfz");
				ysdzj.value=psh[i].value;
				ysdbh.value=ls[i].value;
				sfzz.value = sfz[i].value;
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
		function toCheck(temp){
			var count = -1;
			for(var i=0;i<temp.length;i++){
				if(temp[i].checked){
					return i;
				}
			}
			return count;
		}
		function getHt(ddzj){
			var hql = " from Khddhpb where 1=1 and ddzj = (select A.khht.khdd.ddzj from Yspsd A where A.ysdzj ="+ddzj+")";
			UserDWR.getList(hql,null,cda);
		}
		function cda(data){
			var list = data;
			var tbody = $("hpTab").lastChild;
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
		}
	</script>
  </head>
  <body onload="getHt(${khthForm.yspsd.ysdzj});">
    <html:form action="khth.do?method=update" method="post" onsubmit="return isNull();">
    	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
    		<caption><center>客户退货修改</center></caption>
    		<tr>
    			<td align="right">退货单号&nbsp;&nbsp;</td>
    			<td colspan="3"><html:text property="vo.thdh" styleClass="input" readonly="true"/></td>
    		</tr>
    		<tr>
    			<td width="25%" align="right">订单编号&nbsp;&nbsp;</td>
    			<td width="25%">
    				<html:text property="yspsd.ysdbh" styleClass="input" readonly="true"/>
    				<html:hidden property="yspsd.ysdzj" />
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" onclick="getPagedata(1);" alt="点击选择" style="cursor:hand;" >
    			</td>
    			<td width="20%" align="right">发货站点&nbsp;&nbsp;</td>
    			<td><html:text property="vo.fhzd" readonly="true" styleClass="input"/></td>
    		</tr>
    		<tr>
    			<td align="right">退货人签名&nbsp;&nbsp;</td>
    			<td><html:text property="vo.thrqm" styleClass="input"/></td>
    			<td align="right">退货日期&nbsp;&nbsp;</td>
    			<td><html:text property="vo.thrq" readonly="true" styleClass="input"/></td>
    		</tr>
    		<tr>
    			<td align="right">退货原因&nbsp;&nbsp;</td>
    			<td colspan="3"><html:textarea property="vo.thyy" rows="4" cols="50"/></td>
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
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<input type="button" value="返 回" onclick="back();" class="inputbutton">
    				<html:hidden property="vo.thzj"/>
    				<html:hidden property="vo.sssysz" />
    				<html:hidden property="vo.ssxs" />
    				<input type="hidden" name="show-btn">
    			</td>
    		</tr>
    	</table>
    </html:form>
    <div id="hello-win" class="x-hidden">
    	<div id="hello-tabs">
    		<div id="div1" class="tanchuang"></div>
    	</div>
    </div>
  </body>
</html>