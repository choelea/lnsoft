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
    		var khht = document.all("khht");
    		var jjcd = document.all("vo.jjcd");
    		var kfmc = document.all("vo.kfmc");
    		var rklx = document.all("vo.crklx");
    		var rkfs = document.all("vo.crkfs");
    		var xdsj = document.all("vo.xdsj");
    		var yjrksj = document.all("vo.yjcrksj");
    		if(khht.value==""){
    			alert("请选择客户合同！");
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
    			alert("请选择入库类型！");
    			return false;
    		}
    		if(rkfs.value==""){
    			alert("请选择入库方式！");
    			return false;
    		}
    		if(yjrksj.value==""){
    			alert("请输入预计入库时间！");
    			return false;
    		}
    		var arr1 = xdsj.value.split("-");
    		var date1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
    		var arr2 = yjrksj.value.split("-");
    		var date2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
    		if(date2<date1){
    			alert("预计入库时间有误！");
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
				var htlxs = document.getElementsByName("xzhtlx");
				if(pagemsglx.value=='khht'){					
					var htmc = document.all("khht");
					var htzj = document.all("htzj");
					var htlx = document.all("vo.crkfs");
					var ssjg = document.all("ssjg");
					var extssjg = document.getElementsByName("extssjg");
					htmc.value=ls[i].value;
					htzj.value=lsid[i].value;
					ssjg.value=extssjg[i].value;
					if(htlxs[i].value=="外包合同"){
						htlx.value="仓运";
					}else if(htlxs[i].value=="仓储合同"){
						htlx.value="自提";
					}
					
					var khddzj = document.getElementsByName("khddzj");
					var hql = "from Khddhpb where khdd.ddzj="+khddzj[i].value+" order by hpbm";
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
    		var countHql = "select count(*) from Khht A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and htzt=0 and  (A.htlx = ? or A.htlx = ?)";
			var listHql = "select new com.whjbsoft.www.vo.HtxxVo(A.htzj,A.htbh,A.htmc,B.ddzj,A.yfdj,A.bxfl,A.htlx,A.ssjg) from Khht A inner join A.khdd B where 1=1 and A.ssxs = ${userPk} and htzt=0 and A.sssysz = ${userSyszzj} and (A.htlx = ? or A.htlx = ?)";
    		var arr = new Array();
    		arr[0]="仓储合同";
    		arr[1]="外包合同";
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,arr,function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='khht'></td><td>合同编号</td><td>合同名称</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].htmc+"\">"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].htzj+"\">"+
							  "<input type=\"hidden\" name=\"khddzj\" value=\""+list[obj].ddzj+"\">"+
							  "<input type=\"hidden\" name=\"xzhtlx\" value=\""+list[obj].jzrq+"\">"+
							  "<input type=\"hidden\" name=\"extssjg\" value=\""+list[obj].ssjg+"\">"+
								"</td><td>"+list[obj].htbh+"</td><td>"+list[obj].htmc+"</td></tr >";
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
    		var khht = document.all("khht");
    		if(khht.value==''){
    			alert("请先选择合同！");
    			return false;
    		}
    		clickHid();
    		var ssjg = document.all("ssjg");
    		var countHql = "select count(*) from Kfxx A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ssjg=?";
			var listHql = "select A from Kfxx A where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ssjg=?";
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,ssjg.value,function (data){
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
    	});
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
  	<html:form action="/crkdd.do?method=saveObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>入库订单录入</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			<td align="right" width="20%">客户合同&nbsp;&nbsp;<font color="red">*</font></td>
    			<td><input type="text" name="khht" class="input" readonly="readonly"/>
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1);clickHid();"/>
    			<input type="hidden" name="htzj">
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
    				<html:text property="vo.ddlx" styleClass="input" value="入库" readonly="true"/>
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
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageBdata(1);"/>
    				<html:hidden property="vo.sykfzj" styleClass="input"/>
    			</td>
    			<td align="right">入库类型&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常入库">正常入库</html:radio>
    				<html:radio property="vo.crklx" value="调拨入库">调拨入库</html:radio>
    				<html:radio property="vo.crklx" value="退货入库">退货入库</html:radio>
    			</td>
    		</tr> 	
    		<tr>    			
    			<td align="right">
    			入库方式&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.crkfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">预计入库时间&nbsp;&nbsp;<font color="red">*</font>
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
	    					<td>货品数量<font color="red">*</font></td>
	    					<td></td>
	    				</tr>
	    			<tbody id="tbody">
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="hidden" name="ssjg" id="ssjg">
    				<html:hidden property="vo.ssxs" value="${userPk }"/>
    				<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="submit" value="添 加" class="inputbutton" onclick="return IsNull();"/>
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
