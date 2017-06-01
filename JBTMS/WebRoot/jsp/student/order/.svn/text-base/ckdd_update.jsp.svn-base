<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
    <script type="text/javascript">
    	function IsNull(){
    		var rkddbh = document.all("rkddbh");
    		var jjcd = document.all("vo.jjcd");
    		var kfmc = document.all("vo.kfmc");
    		var rklx = document.all("vo.crklx");
    		var rkfs = document.all("vo.crkfs");
    		var xdsj = document.all("vo.xdsj");
    		var yjrksj = document.all("vo.yjcrksj");
    		if(rkddbh.value==""){
    			alert("请选择入库订单！");
    			return false;
    		}
    		if(jjcd.value==""){
    			alert("请选择紧急程度！");
    			return false;
    		}
    		if(kfmc.value==""){
    			alert("请选择库房！");
    			return false;
    		}
    		if(checkRadio(rklx)){
    			alert("请选择出库类型！");
    			return false;
    		}
    		if(rkfs.value==""){
    			alert("请选择出库方式！");
    			return false;
    		}
    		if(yjrksj.value==""){
    			alert("请输入预计出库时间！");
    			return false;
    		}
    		var arr1 = xdsj.value.split("-");
    		var date1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
    		var arr2 = yjrksj.value.split("-");
    		var date2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
    		if(date2<date1){
    			alert("预计出库时间有误！");
    			return false;
    		}
    	}
    	function checkRadio(temp){
    		for(var i=0;i<temp.length;i++){
    			if(temp[i].checked){
    				return false;
    			}
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/crkdd.do?method=getList&page=1&orderKind=${orderKind}";
    	}
    	function setValue(){
			var pk = document.getElementsByName("pk");			
			var i = ToDel();
			if(i!=-1){
				var pagemsglx = document.all("pagemsglx");
				var ls = document.getElementsByName("ls");
				var lsid = document.getElementsByName("lsid");
				if(pagemsglx.value=='rkdd'){					
					var rkddbh = document.all("rkddbh");
					var htzj = document.all("htzj");
					var extkhzlh = document.getElementsByName("extkhzlh");
					var khzlh = document.all("vo.khzlh");
					var crkfss = document.getElementsByName("ckfss");
					var ckfs = document.all("vo.crkfs");
					rkddbh.value=ls[i].value;
					htzj.value=lsid[i].value;
					khzlh.value=extkhzlh[i].value;
					ckfs.value=crkfss[i].value;
					var rkddzj = document.getElementsByName("rkddzj");
					var hql = "from Crkhp where crkdd.crkzj="+rkddzj[i].value+" order by hpbm";
					var tbody = document.getElementById("tbody");
					var fc = tbody.firstChild;
					while(fc!=null){
						var tc = fc.nextSibling;
						tbody.removeChild(fc);
						fc = tc;
					}
					UserDWR.getList(hql,null,function(data){
						for(var obj in data){
    						if(!isNaN(obj)){
    							r = tbody.insertRow();
    							c = r.insertCell();
    							c.setAttribute("align","center");
    							c.innerHTML=data[obj].hpbm;
    							c = r.insertCell();
    							c.setAttribute("align","center");
    							c.innerHTML=data[obj].hpmc;
    							c = r.insertCell();
    							c.setAttribute("align","center")
    							c.innerHTML=data[obj].hpdw;
    							c = r.insertCell();
    							c.setAttribute("align","center");
    							c.innerHTML=data[obj].hplx;
    							c = r.insertCell();
    							c.setAttribute("align","center");
    							c.innerHTML=data[obj].hpxh;
    							c = r.insertCell();
    							c.setAttribute("align","center");
    							c.innerHTML=data[obj].hpsl;
    						}
   						}
					});
				}
				if(pagemsglx.value=='kfxx'){
					var kfzj = document.all("vo.sykfzj");
					var kfmc = document.all("vo.kfmc");
					kfmc.value=ls[i].value;
					kfzj.value=lsid[i].value;
				}
			}
		}
		function delTrE(obj){
			var tabId = document.getElementById("goodListId");
			var tbody = tabId.lastChild;
			tbody.removeChild(obj.parentNode.parentNode);
		}
    	function ToDel() { 
		  var temp=document.getElementsByName("pk");
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
    	function pageAdata(curpage){
    		var countHql = "select count(A) from Crkdd A inner join A.khht B  where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ddlx = ?";
			var listHql = "select  new com.whjbsoft.www.vo.CrkddVo(A.crkzj,A.ddbh,A.khzlh,B.htzj,B.htmc,A.ddzt,A.sykfzj,A.kfmc,A.crkfs) from Crkdd A inner join A.khht B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ddlx = ?";
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,"入库",function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='rkdd'></td><td>入库订单编号</td><td>合同名称</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ddbh+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].htzj+"\">"+
							  "<input type=\"hidden\" name=\"rkddzj\" value=\""+list[obj].crkzj+"\">"+
							  "<input type=\"hidden\" name=\"extkhzlh\" value=\""+list[obj].khzlh+"\">"+
							  "<input type=\"hidden\" name=\"extkfzj\" value=\""+list[obj].sykfzj+"\">"+
							  "<input type=\"hidden\" name=\"extkfmc\" value=\""+list[obj].kfmc+"\">"+
							  "<input type=\"hidden\" name=\"ckfss\" value=\""+list[obj].ckfs+"\">"+
								"</td><td>"+list[obj].ddbh+"</td><td>"+list[obj].htmc+"</td></tr >";					
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无信息！</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"pageAdata");
		   		div1.innerHTML=msg; 		
    	});
    	}
    	
    	function pageBdata(curpage){
    		var kfzj = document.all("vo.sykfzj");
    		UserDWR.getKfSsjg(kfzj.value,function(str){
    		var countHql = "select count(*) from Kfxx A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ssjg=? ";
			var listHql = "select A from Kfxx A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ssjg=? ";
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,str,function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='kfxx'></td><td>库房编号</td><td>库房名称</td><td>库房 类型</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].kfmc+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].kfzj+"\">"+
								"</td><td>"+list[obj].kfbh+"</td><td>"+list[obj].kfmc+"</td><td>"+list[obj].kflx+"</td></tr >";					
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无信息！</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"pageBdata");
		   		div1.innerHTML=msg; 		
    	});});
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
  </head>
  
  <body>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
  	<html:form action="/crkdd.do?method=updateObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>出库订单修改</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			<td align="right" width="20%">入库订单&nbsp;&nbsp;&nbsp;&nbsp;
    			<td><input type="text" name="rkddbh" class="input" value="${rkddbh }" readonly="readonly"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户指令号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td>
    				<html:text property="vo.khzlh" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">下达时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.xdsj" styleClass="input" readonly="true"/>
    			</td>    
    		</tr>    
    		<tr>
    			<td align="right">订单类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.ddlx" styleClass="input" value="出库" readonly="true"/>
    			</td>
    			<td align="right">紧急程度&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:select property="vo.jjcd" style="width:100pt">
    					<html:option value="">选择紧急程度</html:option>
    					<html:option value="一般">一般</html:option>
    					<html:option value="紧急">紧急</html:option>
    					<html:option value="特急">特急</html:option>
    				</html:select>
    			</td>		
    		</tr>
    		<tr>
    			<td align="right">执行状态&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td colspan="3"><input type="text" value="录入" class="input" readonly="readonly"/>
    				<html:hidden property="vo.ddzt" styleClass="input" value="0"/>
    			</td>
    		</tr> 	
    		<tr>
    			<td align="right">库房信息&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:text property="vo.kfmc" styleClass="input" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);clickHid();"/>
    				<html:hidden property="vo.sykfzj" styleClass="input"/>
    			</td>
    			<td align="right">出库类型&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常出库">正常出库</html:radio>
    				<html:radio property="vo.crklx" value="调拨出库">调拨出库</html:radio>
    				<html:radio property="vo.crklx" value="退货出库">退货出库</html:radio>
    			</td>
    		</tr> 	
    		<tr>    			
    			<td align="right">
    			出库方式&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.crkfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">预计出库时间&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:text property="vo.yjcrksj" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''" />
    			</td>
    		</tr>   
    		 		
    		<tr>
    			<td align="right">备　　注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品选择</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
	    				<tr align="center">
	    					<td>货品编号</td>
	    					<td>货品名称</td>
	    					<td>货品单位</td>
	    					<td>货品类型</td>
	    					<td>货品型号</td>
	    					<td>货品数量</td>
	    					<td></td>
	    				</tr>
	    			<tbody id="tbody">
	    			<c:forEach var="obj" items="${list }">
							<tr align="center">
		    					<td>${obj.hpbm }</td>
		    					<td>${obj.hpmc }</td>
		    					<td>${obj.hpdw }</td>
		    					<td>${obj.hplx }</td>
		    					<td>${obj.hpxh }</td>
		    					<td>${obj.hpsl }</td>
		    				</tr>
						</c:forEach>	
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.crkzj"/>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="submit" value="修 改" class="inputbutton" onclick="return IsNull();"/>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="orderKind" value="${orderKind }">
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
