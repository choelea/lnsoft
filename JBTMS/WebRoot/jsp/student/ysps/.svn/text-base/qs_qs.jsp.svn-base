<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
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
	      	   var qhsj = $("vo.qhsj");
	      	   var yzf = $("vo.yzfhj");
	      	   var qsr = $("vo.shrqz");
	      	   var qsrq = $("vo.shrqzsj");
	      	   if(qsr.value==""){
	      	   		alert("请输入签收人!");
	      	   		return false;
	      	   }
	      	   if(qsrq.value==""){
	      	   		alert("请输入签字时间!");
	      	   		return false;
	      	   }else if(checkDate(qsrq.value,qhsj.value)){
	      	   		alert("签字时间输入有误!");
	      	   		return false;
	      	   }
	      	   
	      }
      	function checkDate(date1,date2){
			var arr1 = date1.split("-");
			var arr2 = date2.split("-");
			var dat1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
			var dat2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
			return dat1<dat2;
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
			     	var tdE5 = document.createElement("td");
			     	tdE5.innerText=list[i].hpdw;
			     	var tdE6 = document.createElement("td");
			     	tdE6.innerText=list[i].hpsl;
			     	trE.appendChild(tdE1);
			     	trE.appendChild(tdE2);
			     	trE.appendChild(tdE3);
			     	trE.appendChild(tdE4);
			     	trE.appendChild(tdE5);
			     	trE.appendChild(tdE6);
			        tbody.appendChild(trE);
				}
			}
		}
		
     function back(){
    	window.location.href="<%=request.getContextPath()%>/ysps.do?method=getList&address=qs";
     }
    </script>
	</head>
	<body onload="getHt(${ddzj });">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
		<html:form action="/ysps.do?method=ddqs" method="post" onsubmit="return IsNull();">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>${ysdlx}订单签收</center></caption>
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
						<html:text property="vo.zf" styleClass="input" />
					</td>
				</tr>
				<tr>
					<td  align="right">费用小计&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.fyxj" styleClass="input"  readonly="true"/>
					</td>
					<td align="right">投保声明&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:select property="vo.tbsm" disabled="true">
						<html:option value="0">投保</html:option>
						<html:option value="1">不投保</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td  align="right">投保金额&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.tbje" styleClass="input" />
					</td>
					<td align="right">保险费&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.bxf" styleClass="input" readonly="true" />
					</td>
				</tr>
				<tr>
					<td  align="right">运杂费合计&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td >
						<html:text property="vo.yzfhj" styleClass="input" readonly="true"/>
					</td>
					<td  align="right">预收款&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
					<td  align="right">签 收 人&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.shrqz" styleClass="input" />
					</td>
					<td align="right">签收日期&nbsp;&nbsp;<font color="red">*</font></td>
					<td>
						<html:text property="vo.shrqzsj" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
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
									<td>货品单位</td>
									<td>货品数量</td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="4" >
						<html:hidden property="vo.ysdzj"/>
						<html:hidden property="vo.ssxs"/>
    				    <html:hidden property="vo.sssysz"/>
    				    <html:hidden property="vo.ysdlx"/>
    				    <html:hidden property="vo.yszt" value="4" />
						<html:submit styleClass="inputbutton">签 收</html:submit>
						<input type="button" value="返 回" class="inputbutton" onclick="back();" />
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
