<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/extjs.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
		<script type="text/javascript">
    	var span1;
    	var span2;
    	function selAll(){ 
		    var o=document.getElementsByName("pk"); 
		     for(var i=0;i<o.length;i++) {
			 	if(!o[i].disabled){
			       o[i].checked=event.srcElement.checked; 
			     }
			 }
		}
		function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				window.location.href="<%=request.getContextPath()%>/pgpc.do?method=getList&page="+page;
			}
		}
		
		function ToDel(temp) {
		  var arrs = new Array();
		  var lszj = document.getElementsByName("lsid");
		  var count = 0;
		  for (var i=0;i<temp.length;i++){
		    if(temp[i].checked){
		    	arrs[count]=lszj[i].value;
		    	count++;
		     }  
		  } 
		  return arrs;
		}
		function setValue(){
			var pk = document.getElementsByName("jlpk");
			var lsid = document.getElementsByName("lsid");
			var psgemsglx = document.getElementById("pagemsglx");
			var ysddzj = document.getElementById("ddzj");
			var ysddlx = document.getElementById("ddlx");
			var arr = ToDel(pk);
			if(pagemsglx.value=="emp"){
				if(arr.length!=0){
					UserDWR.pgWork(ysddlx.value,ysddzj.value,${userDjxxzj},arr,function (data){
						if(data){
							alert("派工成功!");
							var span = document.getElementsByName("sfpg");
							var span9 = document.getElementsByName("sfpc");
							if(span9[span1].innerText.trim()=="已派车"){
								span[span1].innerHTML="已派工/已派车";
								span9[span1].innerHTML="";
							}else{
								span[span1].innerHTML="已派工/";
							}							
						}else {
							alert("派工失败!");
						}
					});
				}
			}
			if(pagemsglx.value=="cheliang"){
				if(arr.length!=0){
					UserDWR.pcWork(ysddlx.value,ysddzj.value,${userDjxxzj},arr,function (data){
						if(data){
							alert("派车成功!");
							var span = document.getElementsByName("sfpc");							
							var span9 = document.getElementsByName("sfpg");
							if(span9[span2].innerText.trim()=="已派工/"){
								span[span2].innerHTML="";
								span9[span2].innerHTML="已派工/已派车";
							}else{
								span[span2].innerHTML="已派车";
							}
						}else {
							alert("派车失败!");
						}
					});
				}
			}
		}
		function ygPagedate(td,ysddzj,ysddlx,curpage,sfz){
			var ddzj = document.getElementById("ddzj");
			var ddlx = document.getElementById("ddlx");
			var ysddsfz = document.getElementById("sfz");
			span1=td;
			ddzj.value = ysddzj;
			ddlx.value = ysddlx;
			ysddsfz.value = sfz;
			var arr = new Array();
			arr[0]=0;
			arr[1]=sfz;
			arr[2]="司机";
			var countHql = "select count(A) from Ygxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.ygzt = ? and A.ssjg= ? and A.ygzw = ?";
			var hql = " from Ygxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.ygzt = ? and A.ssjg = ? and A.ygzw = ?";
			UserDWR.getPageinfo(countHql, hql, curpage,10,arr,cdb);
			clickHid();
		}
		function ygPagedate1(curpage){
			var sfz = document.getElementById("sfz");
			var arr = new Array();
			arr[0]=0;
			arr[1]=sfz.value;
			arr[2]="司机";
			var countHql = "select count(A) from Ygxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.ygzt = ? and A.ssjg= ? and A.ygzw = ?";
			var hql = " from Ygxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.ygzt = ? and A.ssjg = ? and A.ygzw = ?";
			UserDWR.getPageinfo(countHql, hql, curpage,10,arr,cdb);
			clickHid();
		}
		
		function cdb(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='emp'></td><td>员工编号</td><td>员工职位</td><td>员工姓名</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg=msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"jlpk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ygbh+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ygzj+"\">"+
							"</td><td>"+list[obj].ygbh+"</td><td>"+list[obj].ygzw+"</td><td>"+list[obj].ygmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无员工信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"ygPagedate1");
    		div1.innerHTML=msg;
    	}
		function clPagedate(td,ysddzj,ysddlx,curpage,sfz){
			var ddzj = document.getElementById("ddzj");
			var ddlx = document.getElementById("ddlx");
			var ysddsfz = document.getElementById("sfz");
			span2=td;
			ddzj.value = ysddzj;
			ddlx.value = ysddlx;
			ysddsfz.value = sfz;
			var arr = new Array();
			arr[0]="空闲";
			arr[1]=sfz;
			var countHql = "select count(A) from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.syzt = ? and A.ssjg= ?";
			var hql = " from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.syzt = ? and A.ssjg = ?";
			UserDWR.getPageinfo(countHql, hql, curpage,10,arr,cda);
			clickHid();
		}
		function clPagedate1(curpage){
			var sfz = document.getElementById("sfz");
			var arr = new Array();
			arr[0]="空闲";
			arr[1]=sfz.value;
			var countHql = "select count(A) from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.syzt = ? and A.ssjg= ?";
			var hql = " from Ylxx A where 1=1 and (A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} or A.ssxs = 0 and A.sssysz = 0) and A.syzt = ? and A.ssjg = ?";
			UserDWR.getPageinfo(countHql, hql, curpage,10,arr,cda);
			clickHid();
		}
		function cda(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellpadding='0' cellspacing='1' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='cheliang'></td><td>车辆编号</td><td>车辆类型</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg=msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"jlpk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ylbh+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ylzj+"\">"+
							"</td><td>"+list[obj].ylbh+"</td><td>"+list[obj].cllx+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无车辆信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"clPagedate1");
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
    </script>
		<c:if test="${msg!=null }">
			<script type="text/javascript">
    		alert('${msg}');
    	</script>
		</c:if>
	</head>
	<body>
		<html:form action="/pgpc.do?method=query" method="post">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" width="20%">
						<b>查询字段名:</b>
					</td>
					<td>
						<html:select property="fieldName">
							<html:option value="">请选择字段名称</html:option>
							<html:option value="ysddbh">调度单号</html:option>
							<html:option value="ysddlx">调度类型</html:option>
							<html:option value="ysfs">运输方式</html:option>
						</html:select>
					</td>
					<td align="right">
						<b>查询字段值:</b>
					</td>
					<td>
						<html:text property="fieldValue" styleClass="input"/>
					</td>
					<td width="20%">
						<input type="submit" name="chaxun" value="查 询" class="inputbutton"/>
						<input type="hidden" name="show-btn">
						<input type="hidden" name="ddzj">
						<input type="hidden" name="ddlx">
						<input type="hidden" name="sfz">
					</td>
				</tr>
			</table>
			<table width="100%" align="center" cellpadding="0" cellspacing="1"
				border="0" style="word-break:break-all;">
				<thead>
					<tr align="center">
						<th>
							全选
							<input type="checkbox" id="delpk" onClick="return selAll();">
						</th>
						<th>调度单号</th>
						<th>调度类型</th>
						<th>运输方式</th>
						<th>始 发 站</th>
						<th>调度状态</th>
						<th>操 作</th>
					</tr>
				</thead>
				<c:set var="x" value="0"></c:set>
				<logic:notEmpty name="pageinfo" property="pagedata">
					<logic:iterate id="obj" name="pageinfo" property="pagedata"
						indexId="i">
						<tr align="center">
							<td >
								<input type="checkbox" name="pk" value="${obj.ysddzj }" />
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/pgpc.do?method=view&vo.ysddzj=${obj.ysddzj}">${obj.ysddbh}</a>
							</td>
							<td>
								<c:if test="${obj.ysddlx eq '运输' }">
									整 车
								</c:if>
								<c:if test="${obj.ysddlx eq '配送' }">
									零 担
								</c:if>
							</td>
							<td>${obj.ysfs }</td>
							<td>${obj.sfz }</td>
							<td>
								<c:if test="${obj.ysddzt==0 }">录 入</c:if>
								<c:if test="${obj.ysddzt==1 }">装 车</c:if>
								<c:if test="${obj.ysddzt==2 }">在 途</c:if>
								<c:if test="${obj.ysddzt==3 }">完 成</c:if>
							</td>
							<td>
								<c:if test="${obj.sfpg==0||obj.sfpc==0}">
									<span id="sfpg">
									<c:if test="${obj.sfpg==0 }">
										<a href="javascript:ygPagedate(${x},${obj.ysddzj},'${obj.ysddlx }',1,'${obj.sfz}');">派 工</a>/
									</c:if>
									<c:if test="${obj.sfpg==1 }">已派工/</c:if>
									</span>
									<span id="sfpc">
									<c:if test="${obj.sfpc==0 }">
										<a href="javascript:clPagedate(${x},${obj.ysddzj},'${obj.ysddlx }',1,'${obj.sfz}');">派 车</a>
									</c:if>
									<c:if test="${obj.sfpc==1 }">已派车</c:if>
									</span>
									<c:set var="x" value="${x+1 }"></c:set>
								</c:if>
								<c:if test="${obj.sfpg==1&&obj.sfpc==1&&obj.ysddzt>=0}">
									已派工/已派车
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="pageinfo" property="pagedata">
					<tr>
						<td colspan="9" align="center">
							暂无调度单信息!
						</td>
					</tr>
				</logic:empty>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页
						&nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
						<input type="button" name="first" class="inputbutton3"
							onClick="pagedata(1,${pageinfo.allpage });" />
						<input type="button" name="before" class="inputbutton1"
							onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });" />
						<input type="button" name="next" class="inputbutton2"
							onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });" />
						<input type="button" name="last" class="inputbutton4"
							onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });" />
						跳至
						<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }"
							onchange="pagedata(this.value,${pageinfo.allpage });" />
						页
					</td>
				</tr>
			</table>
		</html:form>
		<div id="hello-win" class="x-hidden">
			<div id="hello-tabs">
				<div class="tanchuang" id="div1"></div>
			</div>
		</div>
	</body>
</html>