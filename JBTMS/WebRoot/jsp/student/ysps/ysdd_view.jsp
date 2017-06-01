<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
			function back(){
				var type='${type}';
				if("zc"==type){
	    			window.location.href="<%=request.getContextPath()%>/pgpc.do?method=getZcList&page=1";
	    		}else if("fc"==type){
	    			window.location.href="<%=request.getContextPath()%>/pgpc.do?method=getFcList&page=1";
	    		}else{
	    			window.location.href="<%=request.getContextPath()%>/pgpc.do?method=getList&page=1";
	    		}
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
							<html:option value="">请选择调度类型</html:option>
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
									<td colspan="6" align="center">班线信息</td>
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
				<tr><td colspan="4">&nbsp;</td></tr>
				<tr>
					<td colspan="4">
						<table id="ysdTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr>
									<td colspan="6" align="center">订单信息</td>
								</tr>
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
				<tr><td colspan="4">&nbsp;</td></tr>
				<tr id="clxx">
					<td colspan="4">
						<table id="clTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr>
									<td colspan="6" align="center">车辆信息</td>
								</tr>
								<tr align="center">
									<td>车辆编号</td>
									<td>车牌号</td>
									<td>车辆类型</td>
									<td>车辆品牌</td>
								</tr>
								<c:if test="${!empty ysddForm.ydcl }">
									<c:forEach var="obj" items="${ysddForm.ydcl }">
										<tr align="center">
											<td>${obj.ylbh }</td>
											<td>${obj.cph }</td>
											<td>${obj.cllx }</td>
											<td>${obj.clpp }</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${empty ysddForm.ydcl }">
									<tr>
										<td colspan="5" align="center">暂无派送车辆信息</td>
									</tr>
								</c:if>
							</thead>
						</table>
					</td>
				</tr>
				<tr><td colspan="4">&nbsp;</td></tr>
				<tr id="ygxx">
					<td colspan="4">
						<table id="ygTab" width="100%" align="center" cellpadding="0" cellspacing="1" border="0">
							<thead>
								<tr>
									<td colspan="6" align="center">员工信息</td>
								</tr>
								<tr align="center">
									<td>员工编号</td>
									<td>员工姓名</td>
									<td>员工电话</td>
									<td>员工职位</td>
									
								</tr>
								<c:if test="${!empty ysddForm.ydry }">
									<c:forEach var="obj" items="${ysddForm.ydry }">
										<tr align="center">
											<td>${obj.ygbh }</td>
											<td>${obj.ygmc }</td>
											<td>${obj.ygdh }</td>
											<td>${obj.ygzw }</td>
										</tr>
									</c:forEach>
								</c:if>
								<c:if test="${empty ysddForm.ydry }">
									<tr>
										<td colspan="4" align="center">暂无派送员工信息</td>
									</tr>
								</c:if>
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