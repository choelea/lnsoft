<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
		<script type="text/javascript">
	      function $(tag){
	      	return document.getElementById(tag);
	      }
	      function IsNull(){
      	   
      	   var htbh = $("khht.htbh");
      	   var ysfs = $("vo.ysfs");
      	   var tbsm = $("vo.tbsm");
      	   var yf = $("vo.yf");
      	   var tbje = $("vo.tbje");
      	   var yzf = $("vo.yzfhj");
      	   var dateExp = /^\s*[1-9]{1}[0-9]{3}(-)((0[1-9]{1})|(1[0-2]{1}))(-)((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))\s*$/;
      	   var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
      	   var dhsj = document.getElementById("vo.dhsj");//到货时间
      	   var zdsj = document.getElementById("vo.zdsj");
      	    var qhsj = document.getElementById("vo.qhsj");//取货时间
      	    var htjzrq = document.getElementById("khht.jzrq");
      	   if(htbh.value==""){
      	   		alert("请选择合同编号!");
      	   		return false;
      	   }
      	   if(dhsj.value==""){
      	   		alert("请输入到货时间!");
   				return false;
      	   }
      	    
      	   if(checkDate(dhsj.value,zdsj.value)){
      	   		alert("到货时间应大于当前时间!");
   				return false;
      	   }
      	   if(checkDate(htjzrq.value,dhsj.value)){
      	   		alert("到货时间应小于合同截止日期!");
   				return false;
      	   }
      	   if(qhsj.value==""){
      	   		alert("请输入取货时间!");
   				return false;
      	   }
      	   if(checkDate(qhsj.value,dhsj.value)){
      	   		alert("取货时间应大于到货时间!");
   				return false;
      	   }
      	   if(ysfs.value==""){
      	   		alert("请输入运输方式!");
   				return false;
      	   }
      	   if(yf.value==""){
      	   		alert("请输入运费信息!");
   				return false;
      	   }else if(isNaN(yf.value)){
      	   		alert("运费输入有误!");
   				return false;
      	   }
      	   if(tbsm.value=="0"){
      	   		if(tbje.value==""||tbje.value==0){
      	   			alert("请输入投保金额!");
      	   			return false;
      	   		}else if(isNaN(tbje.value)){
      	   			alert("投保金额格式不正确!");
      	   			return false;
      	   		}
      	   }
      	   var fyxj = document.getElementById("vo.fyxj");//运费小计
      	   if(fyxj.value==""){
      	   		alert("请统计运费小计!");
   				return false;
      	   }else if(isNaN(fyxj.value)){
      	   		alert("运费小计统计有误!");
   				return false;
      	   }
      	   
      	   var yzfhj = document.getElementById("vo.yzfhj");//运杂费合计
      	   if(yzfhj.value==""){
      	   		alert("请统计运杂费信息!");
   				return false;
      	   }else if(isNaN(yzfhj.value)){
      	   		alert("运杂费信息统计有误!");
   				return false;
      	   }
      	   var ysk = document.getElementById("vo.ysk");//预收款
      	   if(ysk.value==""){
      	   		alert("请输入预收款信息!");
   				return false;
      	   }else if(isNaN(ysk.value)){
      	   		alert("预收款信息输入有误!");
   				return false;
      	   }
      	   yunfei();
      	   yfxjjs();
      	   yzfhjjs();
      }
       function checkDate(date1,date2){
			var arr1 = date1.split("-");
			var arr2 = date2.split("-");
			var dat1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
			var dat2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
			return dat1<dat2;
		}
      function clickHid(){
    		document.getElementById("show-btn").click();
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
				}else if(pagemsglx.value=='ht'){					
					var htbh = document.all("khht.htbh");
					var htzj= document.all("khht.htzj");
					var yf = document.getElementsByName("yf");
					var bx = document.getElementsByName("bx");
					var ddzj = document.getElementsByName("ddid");
					var jzrq = document.getElementsByName("jzrq");
					var ztj = $("ztj");
					ztj.value=0;
					var yfdj = $("khht.yfdj");
					var bxfl = $("khht.bxfl");
					var htjzrq = $("khht.jzrq");
					htbh.value=ls[i].value;
					htzj.value=lsid[i].value;
					yfdj.value = yf[i].value;
					bxfl.value = bx[i].value;
					htjzrq.value = jzrq[i].value;
					var hql = " from Khddhpb where 1=1 and ddzj = "+ddzj[i].value;
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
						        if(list[i].tjdw=="立方米"){
						        	tj = list[i].hptj;
						        }else if(list[i].tjdw=="立方厘米"){
						        	tj = list[i].hptj/1000000;
						        }else if(list[i].tjdw=="立方毫米"){
						        	tj = list[i].hptj/1000000000;
						        }
						        ztj.value = parseFloat(ztj.value) + tj*list[i].hpsl;
							}
						}
						$("hpTab").appendChild(tbody);
						
					});
					var khql = "select new com.whjbsoft.www.vo.KhddVo(A.ddzj,B.dwmc,B.lxr,B.lxrdh,B.ssjg,B.khjl,B.khjldh,B.khdz,B.khzh,B.lxryb,C.dwmc,C.lxr,C.lxrdh,C.ssjg,C.khdz,C.khzh,C.lxryb,A.ddbh,A.qhrq,A.ddzt,A.zdr) from Khdd A inner join A.khxxByKhzj B inner join A.khxxByKhxKhzj C where 1=1 and A.ddzj = " +ddzj[i].value;
					UserDWR.getList(khql,null,function (data){
						var obj = data;
						var dhfmc = $("dhf.dwmc");
						var dhflxr = $("dhf.lxr");
						var dhfdh = $("dhf.lxrdh");
						var sfz = $("dhf.ssjg");
						var khjl = $("dhf.khjl");
						var khjldh = $("dhf.khjldh");
						var dhfdz = $("dhf.khdz");
						var dhfzh = $("dhf.khzh");
						var dhfyb = $("dhf.lxryb");
						var shfmc = $("shf.dwmc");
						var shflxr = $("shf.lxr");
						var shfdh = $("shf.lxrdh");
						var mdz = $("shf.ssjg");
						var shfdz = $("shf.khdz");
						var shfzh = $("shf.khzh");
						var shfyb = $("shf.lxryb");
						dhfmc.value = obj[0].wtfmc;
						dhflxr.value = obj[0].wtflxr;
						dhfdh.value = obj[0].wtfdh;
						sfz.value = obj[0].wtfssjg;
						khjl.value = obj[0].wtfjl;
						khjldh.value = obj[0].wtfjldh;
						dhfdz.value = obj[0].wtfdz;
						dhfzh.value = obj[0].wtfzh;
						dhfyb.value= obj[0].wtfyb;
						shfmc.value = obj[0].shfmc;
						shflxr.value = obj[0].shflxr;
						shfdh.value = obj[0].shfdh;
						mdz.value = obj[0].shfssjg;
						shfdz.value = obj[0].shfdz;
						shfzh.value = obj[0].shfzh;
						shfyb.value = obj[0].shfyb;
					});
				}
			}
		}
		function pageAdata(curpage){
    		var countHql = "select count(*) from Khht A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and (A.htzt=0 and A.htlx = ? or A.htlx='外包合同' and A.sfkyysps=1 and A.htzt=1) ";
			var hql = "select new com.whjbsoft.www.vo.HtxxVo(A.htzj,A.htbh,A.htmc,B.ddzj,A.yfdj,A.bxfl,A.jzrq) from Khht A inner join A.khdd B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and (A.htzt=0 and A.htlx = ? or A.htlx='外包合同' and A.sfkyysps=1 and A.htzt=1)";
			UserDWR.getPageinfo(countHql, hql, curpage,10,"配送合同",cdc);
    	}
    	function cdc(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='ht'></td><td>合同编号</td><td>合同名称</td><td>截止日期</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].htmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].htzj+"\">"+
						  "<input type=\"hidden\" name=\"ddid\" value=\""+list[obj].ddzj+"\">"+
						   "<input type=\"hidden\" name=\"yf\" value=\""+list[obj].yfdj+"\">"+
						    "<input type=\"hidden\" name=\"bx\" value=\""+list[obj].bxfl+"\">"+
						    "<input type=\"hidden\" name=\"jzrq\" value=\""+list[obj].jzrq+"\">"+
							"</td><td>"+list[obj].htbh+"</td><td>"+list[obj].htmc+"</td><td>"+list[obj].jzrq+"</td></tr >";
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无合同信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageAdata");
    		div1.innerHTML=msg;    		
    	}
		
		function pagedata(curpage){
    		UserDWR.getSjzdmx(curpage,2,cd);
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
    	window.location.href="<%=request.getContextPath()%>/send.do?method=getList&address=send";
     }
    function isChange(){
    	var tbsm = document.getElementById("vo.tbsm");
    	var tbje = document.getElementById("vo.tbje");
    	var bxf = document.getElementById("vo.bxf");
    	if(tbsm.value==0){
    		tbje.readOnly=false;
    		bxf.readOnly= false;
    		tbje.value=0;
    		bxf.value=0;
    		yzfhjjs();
    	}else{
    		tbje.readOnly=true;
    		bxf.readOnly= true;
    		tbje.value=0;
    		bxf.value=0;
    		yzfhjjs();
    	}
    }
    function bxfy(){
    	var bxje = $("vo.tbje");
     	var bxf = $("vo.bxf");
     	var bxfl = $("khht.bxfl");
     	if(bxfl.value==""){
     		alert("请先选择合同!");
     		return false;
     	}
     	bxf.value = bxje.value * bxfl.value/100;
     	yzfhjjs();
    }
     function yunfei(){//运费
     	var tiji = $("ztj");
     	var yfdj = $("khht.yfdj");
     	var yf = $("vo.yf");
     	yf.value = Math.round(tiji.value * yfdj.value*100)/100;
		yfxjjs();
		yzfhjjs();
     }
     
     function yfxjjs(){ 
     	 var yf = document.getElementById("vo.yf");
	     var zf = document.getElementById("vo.zf");
	     var yfxj = document.getElementById("vo.fyxj");
	     if(yf.value==""){
	     	yf.value=0;
	     }
	     if(isNaN(yf.value)){
	     	yf.value=0;
	     }
	     if(zf.value==""){
	     	zf.value=0;
	     }
	     if(isNaN(zf.value)){
	     	zf.value=0;
	     }
	     yfxj.value=parseFloat(yf.value)+parseFloat(zf.value);
     }
     
     function yzfhjjs(){ 
     	var yfxj = document.getElementById("vo.fyxj");
     	var bxje = document.getElementById("vo.tbje");
     	var bxf = document.getElementById("vo.bxf");
     	var yzfhj = document.getElementById("vo.yzfhj");
     	if(yfxj.value==""){
     		yfxjjs();
     	}
     	var yf = document.getElementById("vo.yf");
		 if(bxje.value==""){
		 	bxje.value=0;
		 }
		 if(isNaN(bxje.value)){
		 	bxje.value=0;
		 }
		 if(bxf.value==""){
		 	bxf.value=0;
		 }
		 if(isNaN(bxf.value)){
		 	bxf.value=0;
		 }
		 yzfhj.value=parseFloat(yfxj.value)+parseFloat(bxf.value);
     }
     
    </script>
	</head>
	<body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
		<html:form action="/send.do?method=save&address=send" method="post" onsubmit="return IsNull();">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>配送订单录入</center></caption>
				<tr>
					<td width="20%" align="right">运输单号&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td width="25%">
						<html:text property="vo.ysdbh" styleClass="input" readonly="true"/>
					</td>
					<td align="right" width="20%">合同编号&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="khht.htbh" readonly="true" styleClass="input"/>
						<html:hidden property="khht.htzj"/>
						<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1);clickHid();"/>
					</td>
				</tr>
				<tr>
	    			<td align="right">始 发 站&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="dhf.ssjg" readonly="true" styleClass="input"/>
	    			</td>
	    			<td align="right">目 的 站&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="shf.ssjg" readonly="true" styleClass="input"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">到货时间&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.dhsj" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
					</td>
					<td align="right">取货时间&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.qhsj" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
					</td>
	    		</tr>
				<tr>
					
					<td align="right">运输方式&nbsp;&nbsp;<font color="red">*</font></td>
					<td colspan="3">
						<html:text property="vo.ysfs"  styleClass="input" readonly="true"/>
						<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pagedata(1);clickHid();"/>
					</td>
				</tr>
				<tr>
	    			<td align="right">委 托 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td colspan="3">
	    				<html:text property="dhf.dwmc" readonly="true" styleClass="input" style="width: 320px;"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">客户经理&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="dhf.khjl" readonly="true" styleClass="input"/>
	    			</td>
	    			<td align="right">经理电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="dhf.khjldh" readonly="true" styleClass="input"/>
	    			</td>
	    			
	    		</tr>
	    		<tr>
					<td align="right">委托方邮编&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="dhf.lxryb" styleClass="input" readonly="true"/>
					</td>
					<td align="right">委托方账号&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="dhf.khzh" styleClass="input" readonly="true"/>
					</td>
					
				</tr>
	    		<tr>
	    			<td align="right">取货联系人&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="dhf.lxr" readonly="true" styleClass="input"/>
	    			</td>
	    			<td align="right">取货人电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="dhf.lxrdh" readonly="true" styleClass="input"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">取货地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td colspan="3">
	    				<html:text property="dhf.khdz" readonly="true" styleClass="input" style="width: 320px;"/>
	    			</td>
	    		</tr>
				<tr>
	    			<td align="right">收 货 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td colspan="3">
	    				<html:text property="shf.dwmc" readonly="true" styleClass="input" style="width: 320px;"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">收货联系人&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="shf.lxr" readonly="true" styleClass="input"/>
	    			</td>
	    			<td align="right">收货人电话&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td>
	    				<html:text property="shf.lxrdh" readonly="true" styleClass="input"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">收货地址&nbsp;&nbsp;&nbsp;&nbsp;</td>
	    			<td colspan="3">
	    				<html:text property="shf.khdz" readonly="true" styleClass="input" style="width: 320px;"/>
	    			</td>
	    		</tr>
				<tr>
					<td align="right">收货方账号&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="shf.khzh" styleClass="input" readonly="true"/>
					</td>
					<td align="right">收货方邮编&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="shf.lxryb" styleClass="input" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td  align="right">运费&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.yf" styleClass="input"  readonly="true" onclick="yunfei();"/>
					</td>
					<td align="right">杂费&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zf" styleClass="input" onchange="yunfei();"/>
					</td>
				</tr>
				<tr>
					<td  align="right">费用小计&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.fyxj" styleClass="input"  readonly="true"/>
					</td>
					<td align="right">投保声明&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:select property="vo.tbsm" onchange="isChange();">
						<html:option value="0">投保</html:option>
						<html:option value="1">不投保</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td  align="right">投保金额&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.tbje" styleClass="input" onchange="bxfy();"/>
					</td>
					<td align="right">保险费&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.bxf" styleClass="input" readonly="true" />
					</td>
				</tr>
				<tr>
					<td  align="right">运杂费合计&nbsp;&nbsp;<font color="red">*</font></td>
					<td >
						<html:text property="vo.yzfhj" styleClass="input" readonly="true"/>
					</td>
					<td  align="right">预收款&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.ysk" styleClass="input" />
					</td>
				</tr>
				<tr>
					<td  align="right">
						备注&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
					<td colSpan="3">
						<html:textarea property="vo.yssm" rows="4" cols="50" />
					</td>
				</tr>
				<tr>
					<td  align="right">制单人&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zdr" styleClass="input" value="${userTName }" readonly="true"/>
					</td>
					<td align="right">填单日期&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zdsj" styleClass="input" readonly="true"/>
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
					<td align="center" colspan="4" >
						<input type="hidden" id="show-btn" />
						<html:hidden property="vo.ssxs" value="${userPk }"/>
    				    <html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				    <html:hidden property="vo.ysdlx" value="配送"/>
    				    <html:hidden property="vo.yszt" value="0"/>
    				    <input type="hidden" name="ztj" value="0">
    				    <html:hidden property="khht.yfdj"/>
    				    <html:hidden property="khht.bxfl"/>
    				    <html:hidden property="khht.jzrq"/>
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
