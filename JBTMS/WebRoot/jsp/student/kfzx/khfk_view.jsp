<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" />
		</title>
		<script type="text/javascript">
			function back(){
				window.location.href="<%=request.getContextPath()%>/khfk.do?method=getList";
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
	<body onload="getHt(${khfkForm.yspsd.ysdzj});">
		<html:form action="/khfk.do?method=getList" method="post" >
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
					<td colspan="3"><html:textarea property="vo.fkbz" cols="50" rows="4" readonly="true"/></td>
				</tr>
				<tr>
					<td align="right">制 单 人&nbsp;&nbsp;</td>
					<td><html:text property="vo.fksj" styleClass="input" readonly="true" /></td>
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
						<input type="button" value="返 回" onclick="back();" class="inputbutton">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
