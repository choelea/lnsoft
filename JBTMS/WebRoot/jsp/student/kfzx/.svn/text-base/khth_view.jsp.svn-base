<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khth.do?method=getList";
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
    <html:form action="khth.do?method=view" method="post">
    	<table width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
    		<caption><center>客户退货信息</center></caption>
    		<tr>
    			<td align="right">退货单号&nbsp;&nbsp;</td>
    			<td colspan="3"><html:text property="vo.thdh" styleClass="input" readonly="true"/></td>
    		</tr>
    		<tr>
    			<td width="25%" align="right">订单编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="yspsd.ysdbh" styleClass="input" readonly="true"/></td>
    			<td width="20%" align="right">发货站点&nbsp;&nbsp;</td>
    			<td><html:text property="vo.fhzd" styleClass="input" readonly="true"/></td>
    		</tr>
    		<tr>
    			<td align="right">退货人签名&nbsp;&nbsp;</td>
    			<td><html:text property="vo.thrqm" styleClass="input" readonly="true"/></td>
    			<td align="right">退货日期&nbsp;&nbsp;</td>
    			<td><html:text property="vo.thrq" styleClass="input" readonly="true"/></td>
    		</tr>
    		<tr>
    			<td align="right">退货原因&nbsp;&nbsp;</td>
    			<td colspan="3"><html:textarea property="vo.thyy" readonly="true" rows="4" cols="50"/></td>
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
    				<input type="button" value="返 回" onclick="back();" class="inputbutton">
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>