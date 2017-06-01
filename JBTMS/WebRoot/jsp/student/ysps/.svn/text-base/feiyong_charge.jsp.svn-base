<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
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
      	   var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
      	   var dhsj = document.getElementById("vo.dhsj");//到货时间
      	   
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
      	   var qhsj = document.getElementById("vo.qhsj");//取货时间
      	   
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
     
		function getHt(ddzj){
			var hql = " from Khddhpb where 1=1 and ddzj = "+ddzj;
			UserDWR.getList(hql,null,cda);
		}
		function cda(data){
			var list = data;
			var tbody = $("hpTab").lastChild;
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
		}
					
     function back(){
    	window.location.href="<%=request.getContextPath()%>/ysps.do?method=getList&address=feiyong";
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
	     yzfhjjs();
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
	<body onload="getHt(${ddzj });">
		<html:form action="/ysps.do?method=charge&address=feiyong" method="post" onsubmit="return IsNull();">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>${ysdlx}订单费用调整</center></caption>
				<tr>
					<td width="20%" align="right">${ysdlx}单号&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td width="25%">
						<html:text property="vo.ysdbh" styleClass="input" readonly="true"/>
					</td>
					<td align="right" width="20%">合同编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="khht.htbh" readonly="true" styleClass="input"/>
						<html:hidden property="khht.htzj"/>
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
	    			<td align="right">到货时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.dhsj" styleClass="input" readonly="true" />
					</td>
					<td align="right">取货时间&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.qhsj" styleClass="input" readonly="true" />
					</td>
	    		</tr>
				<tr>
					
					<td align="right">运输方式&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="3">
						<html:text property="vo.ysfs"  styleClass="input" readonly="true"/>
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
					<td  align="right">运费&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.yf" styleClass="input"  readonly="true" />
					</td>
					<td align="right">杂费&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zf" styleClass="input" onchange="yfxjjs();"/>
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
						<c:if test="${sendForm.vo.tbsm==0 }">
							<html:text property="vo.tbje" styleClass="input" onchange="bxfy();"/>
						</c:if>
						<c:if test="${sendForm.vo.tbsm==1 }">
							<html:text property="vo.tbje" readonly="true" styleClass="input" onchange="bxfy();"/>
						</c:if>
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
						<html:textarea property="vo.yssm" rows="4" cols="50" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td  align="right">制单人&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zdr" styleClass="input" readonly="true"/>
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
						<html:hidden property="vo.ysdzj"/>
						<html:hidden property="vo.ssxs"/>
    				    <html:hidden property="vo.sssysz"/>
    				    <html:hidden property="vo.ysdlx"/>
    				    <html:hidden property="vo.yszt" />
    				    <html:hidden property="khht.yfdj"/>
    				    <html:hidden property="khht.bxfl"/>
						<html:submit styleClass="inputbutton">费用调整</html:submit>
						<input type="button" value="返 回" class="inputbutton" onclick="back();" />
					</td>
				</tr>
				
			</table>
		</html:form>
	</body>
</html>
