<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/htxx.do?method=getList&page=1&rmMsg=true";
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
		function change1() {
    		var crk = document.all("crk");
    		var ysps = document.all("ysps");
    		var data = document.all("vo.htlx");
    		if(data.value == "仓储合同"){
    			crk.style.display="block";
    			ysps.style.display="none";
    		}else if(data.value=="外包合同"){
    			crk.style.display="block";
    			ysps.style.display="block";
    		}else {
    			ysps.style.display="block";
    			crk.style.display="none";
    		}
    	}
    	function toChild(){
			var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
		}
    </script> 
  </head>
  
  <body onload="getHt(${ddzj });change1();">
  	<html:form action="/htxx.do?method=getList" method="post">
  		<div id="printId">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>合同信息</center></caption>
    		<tr>
    			<td align="right" width="20%">合同编号&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.htbh" styleClass="input"  readonly="true"/>
    			</td>
    			<td align="right" width="20%">合同名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.htmc" styleClass="input" readonly="true"/>    			
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合同类型&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:select property="vo.htlx" style="width:100pt" disabled="true">
    					<html:option value="">选择合同类型</html:option>    					
    					<html:option value="运输合同">整 车</html:option>
    					<html:option value="配送合同">零 担</html:option>
    				</html:select>
    			</td>
    			<td align="right">业务代表&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.ywdb" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">订单编号&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="khdd.ddbh" readonly="true" styleClass="input"/>
    				<html:hidden property="khdd.ddzj" />
    			</td>
    			<td align="right">截止日期&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.jzrq" styleClass="input" readonly="true" />
    			</td>
    		</tr>
    		<tr id="ysps">
    			
    			<td align="right">运费单价(元/m³)&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:text property="vo.yfdj" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 	
   			<tr id="crk">
    			<td align="right">存储单价(元/天/m³)&nbsp;&nbsp;</td>
    			<td colspan="3">
    				<html:text property="vo.ccdj" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 	
    		<tr>
    			<td align="right">保险费率&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.bxfl" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">结算方式&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.jsfs" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 	
    		<tr>    			
    			<td align="right">开 户 行&nbsp;&nbsp;</td>
    			<td><html:text property="vo.khh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">帐 号&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.khzh" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">税 号&nbsp;&nbsp;</td>
    			<td><html:text property="vo.sh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">所属机构&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ssjg" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">合同说明&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.htsm" cols="50" rows="5" readonly="true"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">委 托 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td><html:text property="vo.wtf" styleClass="input" readonly="true"/></td>
    			<td align="right">承 运 方&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.cyf" styleClass="input" readonly="true"/>
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
    	</table>
    	</div>
  	</html:form>
  		<p align="center">
    		<input type="button" value="打 印" class="inputbutton" onclick="toChild();"/>
    		<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    	</p>
  </body>
</html>
