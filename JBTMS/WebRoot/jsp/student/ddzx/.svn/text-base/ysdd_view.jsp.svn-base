<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
			var strr = "("
			function back(){
	    		window.location.href="<%=request.getContextPath()%>/ddfj.do?method=getList&page=1";
	    	}
			function getXx(ddzj){		
				var bxHql = "select A from Bxxx A where A.bxzj = (select A.bxxx.bxzj from Xlyh A where A.ysddxx.ysddzj = ?)";
				UserDWR.getList(bxHql,ddzj,function cda(data){
					var sfz = data[0].sfz;
					var mdz = data[0].mdz;
					$("bxxx.bxbh").value=data[0].bxbh;
					var bxzj = data[0].bxzj;
					var tbody = $("bxTab").lastChild;
					var trE = document.createElement("<tr align='center'>");
			     	var tdE1 = document.createElement("td");
			     	tdE1.innerText=sfz;
			     	var tdE2 = document.createElement("td");
			     	tdE2.innerText=mdz;
			     	var tdE3 = document.createElement("td");
					var str = "";
					var lcHql = "select A from Bxlc A inner join A.bxxx B where 1=1 and B.bxzj = ? order by A.tksx";
					UserDWR.getList(lcHql,bxzj,function cdb(data){
					     if(data.length!=0){
					     	for(var i=0;i<data.length;i++){
						     	if(i!=data.length-1){
						     		str += data[i].bxzd +"、";
						     	}else {
						     		str += data[i].bxzd;
						     	}
						     }
					     	tdE3.innerText=str;
					     }else {
					     	tdE3.innerText="无通达地区";
					     }
					});
			     	trE.appendChild(tdE1);
			     	trE.appendChild(tdE2);
			     	trE.appendChild(tdE3);
			        tbody.appendChild(trE);
					$("bxTab").appendChild(tbody);
				});
				
				var hql = " select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,A.khht.khdd.khxxByKhzj.dwmc,A.khht.khdd.khxxByKhxKhzj.dwmc,A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg) from Yspsd A where A.ysdzj in " +
						" (select A.yspsd.ysdzj from Ysddd A where A.ysddxx.ysddzj = ?)";
				UserDWR.getList(hql,ddzj,function cdc(data){
					var tbody = $("ysdTab").lastChild;
					for(var i=0;i<data.length;i++){
						var trE = document.createElement("<tr align='center'>");
				     	var tdE1 = document.createElement("td");
				     	tdE1.innerText=data[i].ysdbh;
				     	var tdE2 = document.createElement("td");
				     	tdE2.innerText=data[i].dhfmc;
				     	var tdE3 = document.createElement("td");
				     	tdE3.innerText=data[i].shfmc;
				     	var tdE4 = document.createElement("td");
				     	tdE4.innerText=data[i].sfz;
				     	var tdE5 = document.createElement("td");
				     	tdE5.innerText=data[i].mdz;
				     	var tdE6 = document.createElement("td");
				     	tdE6.innerText=data[i].ysfs;
				     	trE.appendChild(tdE1);
				     	trE.appendChild(tdE2);
				     	trE.appendChild(tdE3);
				     	trE.appendChild(tdE4);
				     	trE.appendChild(tdE5);
				     	trE.appendChild(tdE6);
				        tbody.appendChild(trE);
					}
				});
			}
			function toChild(){
				var win = window.open("./jsp/print.jsp","打印","height="+(screen.availheight-200)+", width="+(screen.availwidth-300)+",left=150,top=50,menubar=yes,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=yes");			
			}
 		</script>
	</head>
	<body >
		<html:form action="/ddfj.do?method=getList" method="post" >
			<div id="printId">
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<caption><center>调度单信息</center></caption>
				<tr>
					<td width="25%" align="right">调度单号&nbsp;&nbsp;</td>
					<td width="25%">
						<html:text property="vo.ysddbh" readonly="true" styleClass="input"/>
					</td>
					<td width="20%" align="right">调度类型&nbsp;&nbsp;</td>
					<td >
						<html:select property="vo.ysddlx" disabled="true">
								<html:option value="运输">整 车</html:option>
								<html:option value="配送">零 担</html:option>
						</html:select>
					</td>
				</tr>
				<tr>
					<td width="20%" align="right">运输方式&nbsp;&nbsp;</td>
					<td>
						<html:text property="vo.ysfs"  styleClass="input" readonly="true"/>
					</td>
					<td width="20%" align="right">班线选择&nbsp;&nbsp;</td>
					<td>
						<html:text property="bxxx.bxbh"  styleClass="input" readonly="true"/>
					</td>
				</tr>
				<tr id="bxxx">
					<td colspan="4">
						<table id="bxTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr>
									<td colspan="3" align="center">班线信息</td>
								</tr>
								<tr align="center">
									<td>始发站</td>
									<td>终点站</td>
									<td>通达地区</td>
								</tr>
								<tr align="center">
									<td>${ysddForm.bxxx.sfz}</td>
									<td>${ysddForm.bxxx.mdz}</td>
									<td>${tddq}</td>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
				<tr>    			
	    			<td align="center" colspan="4">订单信息</td>
    			</tr>
				<tr>
					<td colspan="4">
						<table id="ysdTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr align="center">
									<td>订单编号</td>
									<td>委托方</td>
									<td>收货方</td>
									<td>始发站</td>
									<td>终点站</td>
									<td>运输方式</td>
								</tr>
							</thead>
							<c:forEach var="obj" items="${yspsd }">
								<tr align="center">
									<td>${obj.ysdbh }</td>
									<td>${obj.dhfmc }</td>
									<td>${obj.shfmc }</td>
									<td>${obj.sfz }</td>
									<td>${obj.mdz }</td>
									<td>${obj.ysfs }</td>
								</tr>
							</c:forEach>
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