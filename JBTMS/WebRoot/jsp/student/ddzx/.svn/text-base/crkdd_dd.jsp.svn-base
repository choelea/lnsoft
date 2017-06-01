<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
    <script type="text/javascript">
    	var td=null;
    	function IsNull(){
    		var zjryzj = document.getElementsByName("zjryzj");
    		var ccryzj = document.getElementsByName("ccryzj");
    		var sbzj = document.getElementsByName("sbzj");
    		
    		if(!zjryzj[0]){
    			alert("请选择质检人员！");
    			return false;
    		}
    		if(!ccryzj[0]){
    			alert("请选择仓储人员！");
    			return false;
    		}
			if(!sbzj[0]){
				alert("请选择设备！");
				return false;
			}    		
    	}
    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/crkdd.do?method=getDdList&page=1";
    	}
    	function setValue(){
			var pk = document.getElementsByName("pk");			
			var pagemsglx = document.all("pagemsglx");
			if(pagemsglx.value=="zjry"){
				var i = ToDel();
				if(i!=-1){
					var ls = document.getElementsByName("ls");
					var lsid = document.getElementsByName("lsid");
					var extygmc = document.getElementsByName("extygmc");
					var extygzw = document.getElementsByName("extygzw");
					if(pagemsglx.value=="zjry"){
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
							"<td width='35%'>员工编号</td><td width='35%'>员工姓名</td><td>职位</td><td width='10%'>删除</td></tr>";
				   			msg = msg+"<tr align=\"center\"><td><input type='hidden' name='zjryzj' value="+lsid[i].value+">"+ls[i].value+"</td><td>"+extygmc[i].value+"</td><td>"+extygzw[i].value+"</td><td><img src='<%=request.getContextPath()%>/images/button/del1.bmp' alt='点击删除' style='cursor:hand;' onclick='removePut(this)'/></td></tr >";	
				   			msg = msg + "</table>";
				   			td.innerHTML=msg;
<%--						var msg  ="员工编号："+ls[i].value+"　　姓名："+extygmc[i].value+"　　职位："+extygzw[i].value--%>
						td.innerHTML=msg;
					}
				}
			}else if(pagemsglx.value=="ccry"){
				var arr = gerChoose();
				if(arr.length>0){
					var ls = document.getElementsByName("ls");
					var lsid = document.getElementsByName("lsid");
					var extygmc = document.getElementsByName("extygmc");
					var extygzw = document.getElementsByName("extygzw");
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
			  			"<tr align=\"center\" height=\"30\">"+
						"<td width='35%'>员工编号</td><td width='35%'>员工姓名</td><td>职位</td><td width='10%'>删除</td></tr>";
			   			for(var i=0;i<arr.length;i++){
			   				msg = msg+"<tr align=\"center\"><td><input type='hidden' name='ccryzj' value="+lsid[arr[i]].value+">"+ls[arr[i]].value+"</td><td>"+extygmc[arr[i]].value+"</td><td>"+extygzw[arr[i]].value+"</td><td><img src='<%=request.getContextPath()%>/images/button/del1.bmp' alt='点击删除' style='cursor:hand;' onclick='removePut(this)'/></td></tr >";	
						}
				   		msg = msg + "</table>";
			   			td.innerHTML=msg;
				}
			}else if(pagemsglx.value=="ccsb"){
				var arr = gerChoose();
				if(arr.length>0){
					var ls = document.getElementsByName("ls");
					var lsid = document.getElementsByName("lsid");
					var extsblx = document.getElementsByName("extsblx");
					var extdllx = document.getElementsByName("extdllx");
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
			  			"<tr align=\"center\" height=\"30\">"+
						"<td width='35%'>设备编号</td><td width='35%'>设备类型</td><td>动力类型</td><td width='10%'>删除</td></tr>";
			   			for(var i=0;i<arr.length;i++){
			   				msg = msg+"<tr align=\"center\"><td><input type='hidden' name='sbzj' value="+lsid[arr[i]].value+">"+ls[arr[i]].value+"</td><td>"+extsblx[arr[i]].value+"</td><td>"+extdllx[arr[i]].value+"</td><td><img src='<%=request.getContextPath()%>/images/button/del1.bmp' alt='点击删除' style='cursor:hand;' onclick='removePut(this)'/></td></tr >";	
						}
				   		msg = msg + "</table>";
			   			td.innerHTML=msg;
				}
			}
		}
		function removePut(obj){
			obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
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
		function gerChoose(){
			var temp=document.getElementsByName("pk");
			var arr = new Array();
			var j=0;
			for(var i=0;i<temp.length;i++){
				if(temp[i].checked){
					arr[j]=i;
					j++;
				}
			}
			return arr;
		}
    	function pageAdata(curpage){
    		var countHql = "select count(A) from Ygxx A ,Kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ygzw=? and A.ygzt=? and A.ssjg = B.ssjg and B.kfzj=${vo.sykfzj} ";
			var listHql = "select A from Ygxx A ,Kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.ygzw=? and A.ygzt=? and A.ssjg = B.ssjg and B.kfzj=${vo.sykfzj} ";
    		var arr = new Array();
    		arr[0]='质检员';
    		arr[1]='0';
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,arr,function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='zjry'></td><td width='35%'>员工编号</td><td width='35%'>员工姓名</td><td>职位</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ygzj+"\">"+
							  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ygbh+"\">"+
							  "<input type=\"hidden\" name=\"extygmc\" value=\""+list[obj].ygmc+"\">"+
							  "<input type=\"hidden\" name=\"extygzw\" value=\""+list[obj].ygzw+"\">"+
								"</td><td>"+list[obj].ygbh+"</td><td>"+list[obj].ygmc+"</td><td>"+list[obj].ygzw+"</td></tr >";					
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无员工信息！</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"pageAdata");
		   		div1.innerHTML=msg; 		
    	});
    	}
    	
    	function pageBdata(curpage){
    		var countHql = "select count(A) from Ygxx A ,Kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and (A.ygzw=? or A.ygzw=? or A.ygzw=?) and A.ygzt=? and A.ssjg = B.ssjg and B.kfzj=${vo.sykfzj} ";
			var listHql = "select A from Ygxx A ,Kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and (A.ygzw=? or A.ygzw=? or A.ygzw=?) and A.ygzt=? and A.ssjg = B.ssjg and B.kfzj=${vo.sykfzj} ";
    		var arr = new Array();
    		arr[0]='库管';
    		arr[1]='库工';
    		arr[2]='理货员';
    		arr[3]='0';
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,arr,function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='ccry'></td><td width='35%'>员工编号</td><td width='35%'>员工姓名</td><td>职位</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].ygzj+"\">"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].ygbh+"\">"+
						  "<input type=\"hidden\" name=\"extygmc\" value=\""+list[obj].ygmc+"\">"+
						  "<input type=\"hidden\" name=\"extygzw\" value=\""+list[obj].ygzw+"\">"+
						  "</td><td>"+list[obj].ygbh+"</td><td>"+list[obj].ygmc+"</td><td>"+list[obj].ygzw+"</td></tr >";									
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无员工信息！</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"pageBdata");
		   		div1.innerHTML=msg; 		
    	});
    	}
    	
    	function pageCdata(curpage){
    		var countHql = "select count(A) from Sbxx A inner join A.kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.sbzt=? and B.kfmc=? ";
			var listHql = "select A from Sbxx A inner join A.kfxx B where 1=1 and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}and A.sbzt=? and B.kfmc=? ";
    		var arr = new Array();
    		arr[0]='空闲';
    		arr[1]='${vo.kfmc}';
    		UserDWR.getPageinfo(countHql,listHql,curpage,10,arr,function (data){
		    	var list = data.pagedata;
		   		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		  				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='ccsb'></td><td width='35%'>设备编号</td><td width='35%'>设备类型</td><td>动力类型</td></tr>";
		   		for(var obj in list){
		   			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].sbzj+"\">"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].sbbh+"\">"+
						  "<input type=\"hidden\" name=\"extsblx\" value=\""+list[obj].sblx+"\">"+
						  "<input type=\"hidden\" name=\"extdllx\" value=\""+list[obj].dllx+"\">"+
						  "</td><td>"+list[obj].sbbh+"</td><td>"+list[obj].sblx+"</td><td>"+list[obj].dllx+"</td></tr >";
		    		}
		   		}
		   		if(list.length==0){
		   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无设备信息！</td></tr>";
		   		}
		   		msg = msg + "</table>";
		   		msg = msg + pageMsg(data,"pageCdata");
		   		div1.innerHTML=msg; 		
    	});
    	}
    	function clickHid(temp){
    		td = document.getElementById(temp);
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
  	<html:form action="/crkdd.do?method=dDu" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>订单调度</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				${vo.ddbh }
    			</td>
    			<td align="right" width="20%">订单类型&nbsp;&nbsp;</td>
    			<td>
    				${vo.ddlx }
    			</td>
    		</tr>
    		<tr>
    			<td align="right">客户指令号&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.khzlh }
    			</td>
    			<td align="right">下达时间&nbsp;&nbsp;
    			</td>
    			<td >
					${vo.xdsj }
    			</td>    
    		</tr> 
    		<tr>
    			<td align="right">库房&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.kfmc}
    			</td>
    			<td align="right">紧急程度&nbsp;&nbsp;
    			</td>
    			<td >
					${vo.jjcd }
    			</td>    
    		</tr> 
    		<tr>
	    		<td align="right">
	    		${vo.ddlx eq "入库"?"入库类型":"出库类型" }&nbsp;&nbsp;
	    		</td>
	    			<td >
						${vo.crklx }
	    		</td> 
    			<td align="right">${vo.ddlx eq "入库"?"预计入库时间":"预计出库时间" }&nbsp;&nbsp;
    			</td>
    			<td>
    				${vo.yjcrksj}
    			</td>
    		</tr> 
    		</table>
    		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr>
    			<td align="right" width="20%">质检人&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td colspan="2" width="60%" id="zj">
    			</td>   
    			<td width="20%">
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择质检人员" style="cursor:hand;" onclick="pageAdata(1);clickHid('zj');"/>
    			</td>    
    		</tr>
    		<tr>
    			<td align="right">仓储人员&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td colspan="2" id="cc">
    			</td>   
    			<td>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择仓储人员" style="cursor:hand;" onclick="pageBdata(1);clickHid('cc');"/>
    			</td>    
    		</tr> 
    		<tr>
    			<td align="right">设备&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td colspan="2" id="sb">
    			</td>   
    			<td>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择设备" style="cursor:hand;" onclick="pageCdata(1);clickHid('sb');"/>
    			</td>    
    		</tr>       
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.crkzj" value="${vo.crkzj }"/>
    				<html:hidden property="vo.ddlx" value="${vo.ddlx }"/>
    				<input type="hidden" id="show-btn"/> 
    				<input type="submit" value="确 定" class="inputbutton" onclick="return IsNull();"/>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
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
