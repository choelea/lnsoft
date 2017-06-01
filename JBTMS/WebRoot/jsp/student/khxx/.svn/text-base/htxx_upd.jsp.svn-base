<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
    <script type="text/javascript">
    	var bhexist = false;
    	function IsNull(){
    		var htmc = document.all("vo.htmc");//合同名称
    		var htlx = document.all("vo.htlx");//合同类型
    		var ddbh = document.all("khdd.ddbh");//订单编号
    		var qymc = document.all("vo.qymc");//企业名称
    		var ywdb = document.all("vo.ywdb");//业务代表
    		var jzrq = document.all("vo.jzrq");//截止日期
    		var yfdj = document.all("vo.yfdj");//运费单价
    		var sfysps = document.all("vo.sfkyysps");
    		var ccdj = document.all("vo.ccdj");
    		var jsfs = document.all("vo.jsfs");//结算方式
    		var khh = document.all("vo.khh");//开户行
    		var khzh = document.all("vo.khzh");//帐号
    		var sh = document.all("vo.sh");//税号
    		var ssjg = document.all("vo.ssjg");//委托方
    		var bxfl = document.all("vo.bxfl");
    		var tdsj = document.all("vo.tdsj");
    		var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		var taxExp = /^[0-9]{3,4}(-)[0-9]{8}$/;
    		var postExp = /^\d{6}$/;
    		var numExp = /^\d+$/;
    		var charExp = /^\w+$/;
    		var dateExp = /^\s*[1-9]{1}[0-9]{3}(-)((0[1-9]{1})|(1[0-2]{1}))(-)((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-2]{1}))\s*$/;
    		if(htmc.value==""){
    			alert("请输入合同名称!");
   				return false;
    		}
    		if(htlx.value==""){
    			alert("请选择合同类型!");
   				return false;
    		}
    		if(ddbh.value==""){
    			alert("请选择订单编号!");
    			return false;
    		}
    		if(jzrq.value==""){
    			alert("请输入截至日期!");
   				return false;
    		}else if(checkDate(jzrq.value,tdsj.value)){
				alert("请输入正确的截止日期!");
				return false;
    		}
    		if(yfdj.value==""){
    			alert("请输入运费单价!");
    			return false;
    		}else if(isNaN(yfdj.value)){
    			alert("运费单价格式不正确!");
    			return false;
    		}
    		if(bxfl.value==""){
    			alert("请输入保险费率!");
    			return false;
    		}else if(isNaN(bxfl.value)||bxfl.value > 100){
    			alert("保险费率格式不正确!");
    			return false;
    		}
    		if(jsfs.value==""){
    			alert("请选择结算方式!");
    			return false;
    		}
    		if(ssjg.value==""){
    			alert("请选择所属机构!");
    			return false;
    		}
    		var dForm = document.forms[0];
    		dForm.action="<%=request.getContextPath()%>/htxx.do?method=update";
    		dForm.method="post";
    		dForm.submit();
    		return true;
    	}
    	function checkDate(date1,date2){
			var arr1 = date1.split("-");
			var arr2 = date2.split("-");
			var dat1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
			var dat2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
			return dat1<=dat2;
		}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/htxx.do?method=getList&page=1&rmMsg=true";
    	}
    	function setValue(){
			var pk = document.getElementsByName("pk");			
			var i = ToDel();
			if(i!=-1){
				var pagemsglx = document.all("pagemsglx");
				var ls = document.getElementsByName("ls");
				if(pagemsglx.value=='banks'){					
					var rkjs = document.all("vo.khh");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='pays'){					
					var rkjs = document.all("vo.jsfs");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='areas'){					
					var rkjs = document.all("vo.ssjg");
					rkjs.value=ls[i].value;
				}
				if(pagemsglx.value=='clis'){					
					var rkjs = document.all("khdd.ddbh");
					var tyf = document.all("khdd.ddzj");
					var wtfmc = document.getElementsByName("wtfmc");
					var shfmc = document.getElementsByName("shfmc");
					var xzkhjl = document.getElementsByName("lsid");
					var wtf = document.all("vo.wtf");
					rkjs.value=ls[i].value;
					tyf.value=xzkhjl[i].value;
					wtf.value = wtfmc[i].value;
					getHt(xzkhjl[i].value);
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
    	function pageBdata(curpage){
    		UserDWR.getSjzdmx(curpage,14,cdb);
    	}		
    	function pageAdata(curpage){
    		UserDWR.getSjzdmx(curpage,16,cde);
    	}	
    	function pagePdata(curpage){
    		UserDWR.getSjzdmx(curpage,12,cdp);
    	}	
    	function cdb(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='banks'></td><td>银行名称</td><td>银行简称</td></tr>";
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
    		msg = msg + pageMsg(data,"pageBdata");
    		div1.innerHTML=msg;
    	}
    	function cde(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='areas'></td><td>地区编号</td><td>地区名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无地区信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageAdata");
    		div1.innerHTML=msg;
    	}
    	function cdp(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='pays'></td><td>结算编号</td><td>结算名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sjzdmxmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sjzdmxzj+"\">"+
							"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无结算方式信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pagePdata");
    		div1.innerHTML=msg;
    	}
    	function pageCdata(curpage){
    		var hql = "select new com.whjbsoft.www.vo.KhddVo(A.ddzj,B.khzj,B.dwmc,B.lxr,B.lxrdh,B.ssjg,C.khzj,C.dwmc,C.lxr,C.lxrdh,C.ssjg,A.ddbh) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ddzt = 1";
			var countHql = "select count(A) from Khdd A inner join A.khxxByKhzj B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ddzt=1";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,cdc);
    	}	
    	function cdc(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td width='15%'>选择<input type='hidden' name='pagemsglx' value='clis'></td><td>订单编号</td><td>委 托 方</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ddbh+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ddzj+"\">"+
						  "<input type=\"hidden\" name=\"wtfmc\" value=\""+list[obj].wtfmc+"\">"+
						  "<input type=\"hidden\" name=\"shfmc\" value=\""+list[obj].shfmc+"\">"+
							"</td><td>"+list[obj].ddbh+"</td><td>"+list[obj].wtfmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无订单信息</td></tr>";
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
    	function getHt(ddzj){
			var countHql = "select count(*) from Khddhpb where 1=1 and ddzj = "+ddzj;
			var hql = " from Khddhpb where 1=1 and ddzj = "+ddzj;
			UserDWR.getPageinfo(countHql, hql, 1,10,null,cda);
		}
		function cda(data){
			var list = data.pagedata;
			var tbody = $("hpTab").lastChild;
			$("hpTab").removeChild(tbody);
			var tbody = document.createElement("tbody");
			for(var i in list){
				if(!isNaN(i)){
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
  
  <body onload="getHt(${ddzj });">
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
  	<html:form action="/htxx.do?method=save" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>合同修改</center></caption>
    		<tr>
    			<td align="right" width="20%">合同编号&nbsp;&nbsp;&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    				<html:hidden property="vo.htzt"/>
    				<html:hidden property="vo.sfkyysps" value="0"/>
    				<html:hidden property="vo.htzj"/>
    				<html:hidden property="vo.sfjs"/>
    				<input type="hidden" id="show-btn"/> 
    			</td>
    			<td width="25%">
    				<html:text property="vo.htbh" styleClass="input" readonly="true" />
    				<div id="htbh"></div>
    			</td>
    			<td align="right" width="20%">合同名称&nbsp;&nbsp;<font color="red">*</font></td>
    			<td><html:text property="vo.htmc" styleClass="input" />    			
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合同类型&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:select property="vo.htlx" style="width:100pt" >
    					<html:option value="">选择合同类型</html:option>
    					<html:option value="运输合同">整 车</html:option>
    					<html:option value="配送合同">零 担</html:option>
    				</html:select>
    			</td>
    			<td align="right">业务代表&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.ywdb" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">订单编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="khdd.ddbh" readonly="true" styleClass="input"/>
    				<html:hidden property="khdd.ddzj" />
    			</td>
    			<td align="right">截止日期&nbsp;&nbsp;<font color="red">*</font></td>
    			<td >
    				<html:text property="vo.jzrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    		</tr>
    		<tr id="ysps">
    			
    			<td align="right">运费单价(元/m³)&nbsp;&nbsp;<font color="red">*</font></td>
    			<td colspan="3">
    				<html:text property="vo.yfdj" styleClass="input"/>
    			</td>
    		</tr> 	
    		<tr>
    			<td align="right">保险费率&nbsp;&nbsp;<font color="red">*</font></td>
    			<td >
    				<html:text property="vo.bxfl" styleClass="input"/>%
    			</td>
    			<td align="right">结算方式&nbsp;&nbsp;<font color="red">*</font></td>
    			<td >
    				<html:text property="vo.jsfs" styleClass="input" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagePdata(1);clickHid();"/>
    			</td>
    		</tr> 	
    		<tr>    			
    			<td align="right">开 户 行&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.khh" styleClass="input" readonly="true"/>
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);clickHid();"/>
    			</td>
    			<td align="right">帐 号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.khzh" styleClass="input"/><span class="tishi"><bean:message key="number"/></span>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">税 号&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.sh" styleClass="input"/><div class="tishi"><bean:message key="char"/></div>
    			</td>
    			<td align="right">所属机构&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合同说明&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.htsm" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">委 托 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.wtf" styleClass="input" readonly="true"/></td>
    			<td align="right">承 运 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.cyf" styleClass="input" value="${userTName }" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">填 单 人&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.tdr" styleClass="input" readonly="true"/></td>
    			<td align="right">填单时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.tdsj" styleClass="input" readonly="true"/>
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
    			<td align="center" colspan="4">
    				<input type="button" value="修 改" class="inputbutton" onclick="return IsNull();"/>
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