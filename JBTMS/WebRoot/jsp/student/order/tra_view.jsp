<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
	      
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
    	window.location.href="<%=request.getContextPath()%>/send.do?method=getList&address=trans";
      }
      function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script>
	</head>
	<body onload="getHt(${ddzj});">
		<html:form action="/send.do?method=getList&address=trans" method="post">
		<div id="printId">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>运输订单信息</center></caption>
				<tr>
					<td width="20%" align="right">运输单号&nbsp;&nbsp;</td>
					<td width="25%">
						<html:text property="vo.ysdbh" styleClass="input" readonly="true"/>
					</td>
					<td align="right" width="20%">合同编号&nbsp;&nbsp;</td>
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
					<td align="right">订单类型&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
						<c:if test="${sendForm.vo.ysdlx eq '运输'}">
						<input type="text" value="整车" class="input" readonly="readonly">
						</c:if>
						<c:if test="${sendForm.vo.ysdlx eq '配送'}">
						<input type="text" value="零担" class="input" readonly="readonly">
						</c:if>
					</td>
					<td align="right">运输方式&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>
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
					<td  align="right">备注&nbsp;&nbsp;</td>
					<td colSpan="3">
						<html:textarea property="vo.yssm" rows="4" cols="50" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td  align="right">制单人&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.zdr" styleClass="input" readonly="true"/>
					</td>
					<td align="right">填单日期&nbsp;&nbsp;</td>
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
			</table>
		</div>
		<p align="center">
    		<input type="button" value="打 印" class="inputbutton" onclick="toChild();"/>
    		<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    	</p>
		</html:form>
	</body>
</html>
