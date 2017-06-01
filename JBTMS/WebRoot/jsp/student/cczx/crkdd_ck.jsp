<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    var qwlink=null;//点击的设置区位连接
    var cwlink=null;//点击的设置储位连接
    var qwcclx="";//区位存储类型
    var cchpbm="";//货品编码
    var djhpbm="";//点击的设置储位所在信息的货品编码
    var arr = new Array()//用来存放区位对象的数组
    var ccqwzj = 0; //存储区位主键
    var i=0;//数组下标
   	function back(){
   		window.location.href="<%=request.getContextPath()%>/cczx.do?method=getCrkList&page=1";
   	}
   	function pageAdata(curpage){
   		var kfzj = document.all("vo.sykfzj");
   		var countHql = "select count(distinct A) from Cwxx C inner join C.qwxx A inner join A.kfxx B where 1=1 and B.ssxs = ${userPk} and B.sssysz = ${userSyszzj} and A.cclx=?  and (C.hgsl>0 or C.shsl>0) and C.hpbm=? and B.kfzj="+kfzj.value;
		var listHql = "select distinct A from Cwxx C inner join C.qwxx A inner join A.kfxx B where 1=1 and B.ssxs = ${userPk} and B.sssysz = ${userSyszzj} and A.cclx=?  and (C.hgsl>0 or C.shsl>0) and C.hpbm=? and B.kfzj="+kfzj.value;
   		var param = new Array();
   		param[0]=qwcclx;
   		param[1]=cchpbm;
   		UserDWR.getPageinfo(countHql,listHql,curpage,10,param,function (data){
	    	var list = data.pagedata;
	   		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	  				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='qwxx'></td><td>区位编号</td><td>区位名称</td><td>存储类型</td></tr>";
	   		for(var obj in list){
	   			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"pk\" onclick='chosQw(this)' value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].qwzj+"\">"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].qwbh+"\">"+
						  "<input type=\"hidden\" name=\"qwmc\" value=\""+list[obj].qwmc+"\">"+
						"</td><td>"+list[obj].qwbh+"</td><td>"+list[obj].qwmc+"</td><td>"+list[obj].cclx+"</td></tr >";					
	    		}
	   		}
	   		if(list.length==0){
	   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无信息！</td></tr>";
	   		}
	   		msg = msg + "</table>";
	   		msg = msg + pageMsg(data,"pageAdata");
	   		div1.innerHTML=msg; 
	   		var pk = document.getElementsByName("pk");
	    	var lsid = document.getElementsByName("lsid");
	    	for(var s=0;s<lsid.length;s++){
	    		for(var k=0;k<arr.length;k++){
	    			if(lsid[s].value==arr[k].qwzj){
	    				pk[s].checked=true;
	    				break;
	    			}
	    		}
	    	}
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
   	
   	//点击设置区位函数
   	function setQw(temp,cclx,hpbm){
   		arr=new Array();//初始化数组
   		i=0;//初始化数组下标
   		qwlink=temp;//点击的连接
   		qwcclx=cclx;//货品类型
   		cchpbm=hpbm;//货品编码
   		clickHid();
   		pageAdata(1);
   	}
   	
   	//区位信息类
   	function qwclass(){
   		this.qwzj=0;
   		this.qwbh="";
   		this.qwmc="";
   	}
   	
   	//选择区位后将选中的区位存储到数组中
   	function chosQw(temp){
   		var qwobj = new qwclass();//创建一个区位对象
   		var qwzj = temp.nextSibling;
   		while(qwzj.nodeType!=1){
   			qwzj=temp.nextSibling;
   		}
   		if(temp.checked){
   			qwobj.qwzj=qwzj.getAttribute("value");//将区位主键存储到对象中
   			qwzj = qwzj.nextSibling;
	   		while(qwzj.nodeType!=1){
	   			qwzj=qwzj.nextSibling;
	   		}
	   		qwobj.qwbh=qwzj.getAttribute("value");//将区位编号存储到对象中
	   		qwzj = qwzj.nextSibling;
	   		while(qwzj.nodeType!=1){
	   			qwzj=qwzj.nextSibling;
	   		}
	   		qwobj.qwmc=qwzj.getAttribute("value");//将区位名称存储到对象中
   			arr[i]=qwobj;
   			i++;
   		}else{
   			for(var j=0;j<arr.length;j++){
   				if(arr[j].qwzj==qwzj.getAttribute("value")){
   					arr[j]=new qwclass();
   				}
   			}
   		}
   	}
   	
   	function setValue(){
		var pagemsglx = document.all("pagemsglx");
		if("qwxx"==pagemsglx.value){
			if(qwlink!=null){
				var tb1 = qwlink.parentNode.nextSibling.firstChild.firstChild;
				var fc = tb1.firstChild;
				while(fc!=null){
					var tc = fc.nextSibling;
					tb1.removeChild(fc);
					fc = tc;
				}
				for(var c=0;c<arr.length;c++){
					if(arr[c].qwzj!=0){
						var tb1_tr1 = document.createElement("<tr>");//创建包含区位输入框tr 
						var td1_text1 = document.createTextNode("区位:");
						var tr1_td1 = document.createElement("<td width='15%' align='center'>");//创建包含区位输入框td 
						var td1_inp1 = document.createElement("<input type='text' readonly='readonly' class='inputsmall2'>");//创建区位输入框
						var tr1_tdt = document.createElement("<td width='5%'>");
						tr1_tdt.appendChild(td1_text1);//添加输入框前的字"区位："
						tr1_td1.appendChild(td1_inp1);//添加区位输入框到td
						tb1_tr1.appendChild(tr1_tdt);//添加包含区位输入框的td到tr
						tb1_tr1.appendChild(tr1_td1);//添加包含区位输入框的td到tr
						
						var tr1_td_szcw = document.createElement("<td width='8%' align='center'>");//创建包含设置储位的的td 
						td1_inp1.setAttribute("value",arr[c].qwmc);
						var td1_link1 = document.createElement("<a href='javascript:'onclick='setCw(this,"+arr[c].qwzj+",\""+cchpbm+"\")'>");
						td1_link1.innerHTML="设置储位";
						tr1_td_szcw.appendChild(td1_link1);//设置储位选择连接到td
						tb1_tr1.appendChild(tr1_td_szcw);//添加设置区位的td到tr
						
						var tr1_td2 = document.createElement("<td width='68%'>");//添加包含储位table的td
						//创建包含储位的table
						var c_tb = document.createElement("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">");
						var c_tby = document.createElement("<tbody>");//创建tbody
						var c_tb_tr = document.createElement("<tr>");//创建包含储位的tr
						var c_tr_td = document.createElement("<td>");//创建包含储位的td
						c_tr_td.innerHTML="&nbsp;";// 对td初始化数据 避免显示不出来
						c_tb_tr.appendChild(c_tr_td);//添加包含储位的td到tr
						c_tby.appendChild(c_tb_tr);//添加包含储位的tr到tbody
						c_tb.appendChild(c_tby);//添加包含储位的tbody到table
						tr1_td2.appendChild(c_tb);//添加包含储位的table到外层的td
						tb1_tr1.appendChild(tr1_td2);//添加td到外层的tr
						
						var tr1_td3 = document.createElement("<td width='1%'>");//添加删除的td
						tr1_td3.innerHTML="<img src='<%=request.getContextPath()%>/images/button/del2.gif' alt='点击删除' style='cursor:hand;' onclick='removePut(this);'>";
						tb1_tr1.appendChild(tr1_td3);//添加td到外层的tr
						tb1.appendChild(tb1_tr1);
					}
				}
			}
		}
		if("cwxx"==pagemsglx.value){
			if(cwlink!=null){
				var tb1 = cwlink.parentNode.nextSibling.firstChild.firstChild;
				var fc = tb1.firstChild;
				while(fc!=null){
					var tc = fc.nextSibling;
					tb1.removeChild(fc);
					fc = tc;
				}
				for(var c=0;c<arr.length;c++){
					if(arr[c].cwzj!=0){
						var tr = document.createElement("<tr>");
						var td1 = document.createElement("<td align='center'>");
						var text1 = document.createTextNode("储位编号");
						td1.appendChild(text1);
						var inp1 = document.createElement("<input type='hidden' name='cwzj"+djhpbm+"'>");
						inp1.setAttribute("value",arr[c].cwzj);
						td1.appendChild(inp1);
						tr.appendChild(td1); 
						
						var td3 = document.createElement("<td align='center'>");
						var text3 = document.createTextNode("存储合格量");
						td3.appendChild(text3);
						tr.appendChild(td3); 
						
						var td5 = document.createElement("<td align='center'>");
						var text5 = document.createTextNode("存储损毁量");
						td5.appendChild(text5);
						tr.appendChild(td5); 
						
						
						var td7 = document.createElement("<td align='center'>");
						var text7 = document.createTextNode("出库合格量");
						td7.appendChild(text7);
						tr.appendChild(td7); 
						
						
						
						var td9 = document.createElement("<td align='center'>");
						var text9 = document.createTextNode("出库损毁量");
						td9.appendChild(text9);
						tr.appendChild(td9); 
						
						
						var td11 = document.createElement("<td width='1%' rowspan='2'>");//添加删除的td
						td11.innerHTML="<img src='<%=request.getContextPath()%>/images/button/del2.gif' alt='点击删除' style='cursor:hand;' onclick='removePut(this,1);'>";
						tr.appendChild(td11);//添加td到外层的tr
						
						
						var tr2 = document.createElement("<tr align='center'>");
						
						var td2 = document.createElement("<td>");
						var inp2 = document.createElement("<input type='text' name='cwmc' readonly='readonly' class='inputsmall3'>");
						inp2.setAttribute("value",arr[c].cwbh);
						td2.appendChild(inp2);
						tr2.appendChild(td2);
						
						
						var td4 = document.createElement("<td>");
						var inp4 = document.createElement("<input type='text' name='ychgsl"+djhpbm+"'readonly='readonly' class='inputsmall3'>");
						inp4.setAttribute("value",arr[c].hgsl);
						td4.appendChild(inp4);
						tr2.appendChild(td4);
						
						
						var td6 = document.createElement("<td>");
						var inp6 = document.createElement("<input type='text' name='ycshsl"+djhpbm+"' readonly='readonly' class='inputsmall3'>");
						inp6.setAttribute("value",arr[c].shsl);
						td6.appendChild(inp6);
						tr2.appendChild(td6);
						
						
						var td8 = document.createElement("<td>");
						var inp8 = document.createElement("<input type='text' name='hgsl"+djhpbm+"' onchange='checkhgsl(this)' class='inputsmall3'>");
						td8.appendChild(inp8);
						tr2.appendChild(td8);
						
						
						
						var td10 = document.createElement("<td>");
						var inp10 = document.createElement("<input type='text' name='shsl"+djhpbm+"' onchange='checkhgsl(this)' class='inputsmall3'>");
						td10.appendChild(inp10);
						tr2.appendChild(td10);
						
						tb1.appendChild(tr);
						tb1.appendChild(tr2);
					}
				}
			}
		} 		
	}
	
	function setCw(temp,qwzj,hpbm){
		arr = new Array();//初始化数组
		i=0;//初始化数组下标
		cwlink = temp;//点击的设置储位连接
		djhpbm = hpbm;//货品编码
		ccqwzj = qwzj;//区位主键
		clickHid();
   		pageBdata(1);
	}
	function pageBdata(curpage){
  		var countHql = "select count(C) from Cwxx C inner join C.qwxx A inner join A.kfxx B  where 1=1 and B.ssxs = ${userPk} and B.sssysz = ${userSyszzj} and (C.hgsl>0 or C.shsl>0) and C.hpbm=? and A.qwzj="+ccqwzj;
		var listHql = "select C from Cwxx C inner join C.qwxx A inner join A.kfxx B  where 1=1 and B.ssxs = ${userPk} and B.sssysz = ${userSyszzj} and (C.hgsl>0 or C.shsl>0) and C.hpbm=? and A.qwzj="+ccqwzj;
	  	UserDWR.getPageinfo(countHql,listHql,curpage,10,djhpbm,function (data){
	    	var list = data.pagedata;
	   		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	  				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='cwxx'></td><td>储位编号</td><td>存储合格量</td><td>存储损毁量</td></tr>";
	   		for(var obj in list){
	   			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"pk\" onclick='chosCw(this)' value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].cwzj+"\">"+
						   "<input type=\"hidden\" name=\"cccwbh\" value=\""+list[obj].cwbh+"\">"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].cwsx+"\">"+
						  "<input type=\"hidden\" name=\"cchgsl\" value=\""+list[obj].hgsl+"\">"+
						  "<input type=\"hidden\" name=\"ccshsl\" value=\""+list[obj].shsl+"\">"+
						"</td><td>"+list[obj].cwbh+"</td><td>"+list[obj].hgsl+"</td><td>"+list[obj].shsl+"</td></tr >";					
	    		}
	   		}
	   		if(list.length==0){
	   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无信息！</td></tr>";
	   		}
	   		msg = msg + "</table>";
	   		msg = msg + pageMsg(data,"pageBdata");
	   		div1.innerHTML=msg; 
	   		var pk = document.getElementsByName("pk");
	    	var lsid = document.getElementsByName("lsid");
	    	for(var s=0;s<lsid.length;s++){
	    		for(var k=0;k<arr.length;k++){
	    			if(lsid[s].value==arr[k].cwzj){
	    				pk[s].checked=true;
	    				break;
	    			}
	    		}
	    	}
	   	});
  	}
  	function cwClass(){
  		this.cwzj=0;
  		this.cwbh="";
  		this.cwsx=0;
  		this.hgsl=0;
  		this.shsl=0;
  		
  	}
  	//选择储位位后将选中的区位存储到数组中
	function chosCw(temp){
		var cwobj = new cwClass();//创建一个区位对象
   		var cwzj = temp.nextSibling;
   		while(cwzj.nodeType!=1){
   			cwzj=temp.nextSibling;
   		}
   		if(temp.checked){
   			cwobj.cwzj=cwzj.getAttribute("value");//将储位主键存储到对象中
   			cwzj = cwzj.nextSibling;
	   		while(cwzj.nodeType!=1){
	   			cwzj=cwzj.nextSibling;
	   		}
	   		cwobj.cwbh=cwzj.getAttribute("value");//将储位编号存储到对象中
	   		cwzj = cwzj.nextSibling;
	   		while(cwzj.nodeType!=1){
	   			cwzj=cwzj.nextSibling;
	   		}
	   		cwobj.cwsx=cwzj.getAttribute("value");//将储位上限存储到对象中
	   		
	   		cwzj = cwzj.nextSibling;
	   		while(cwzj.nodeType!=1){
	   			cwzj=cwzj.nextSibling;
	   		}
	   		cwobj.hgsl=cwzj.getAttribute("value");//将合格数量存储到对象中
	   		
   			cwzj = cwzj.nextSibling;
	   		while(cwzj.nodeType!=1){
	   			cwzj=cwzj.nextSibling;
	   		}
	   		cwobj.shsl=cwzj.getAttribute("value");//将区损毁数量存储到对象中
   			arr[i]=cwobj;
   			i++;
   		}else{
   			for(var j=0;j<arr.length;j++){
   				if(arr[j].cwzj==cwzj.getAttribute("value")){
   					arr[j]=new cwClass();
   				}
   			}
   		}
	}
	//删除tr
   	function removePut(obj,flag){
		var etr = obj.parentNode.parentNode;
		if(flag!=null&&1==flag){
			obj.parentNode.parentNode.parentNode.removeChild(etr.nextSibling);
		}
		obj.parentNode.parentNode.parentNode.removeChild(etr);
		
	}
	
	function checkhgsl(temp){
		var numVail = /^[0-9]+$|[0-9]+\.[0-9]+$/;
		var crhpbh = document.getElementsByName("crhpbh");
		var crhgsl = document.getElementsByName("crhgsl");
		var crshsl = document.getElementsByName("crshsl");
		for(var h=0 ; h<crhpbh.length; h++){
			var hgzsl = 0.0;
			var shzsl = 0.0;
			var ychgsl = document.getElementsByName("ychgsl"+crhpbh[h].value);
			var ycshsl = document.getElementsByName("ycshsl"+crhpbh[h].value);
			var hgsl = document.getElementsByName("hgsl"+crhpbh[h].value);		
			var shsl = document.getElementsByName("shsl"+crhpbh[h].value);
			for(var g=0;g<ychgsl.length;g++){
				var cwccl = 0.0;
				if(hgsl[g].value!=""){
					if(!numVail.test(hgsl[g].value)){
						alert("请正确输入合格数量！");
						hgsl[g].value="";
						hgsl[g].focus();
						return false;
					}else{
						if(parseFloat(hgsl[g].value)>parseFloat(ychgsl[g].value)){
							alert("出库合格数量不能大于储位已存合格数量！");
							return false;
						}
						hgzsl +=parseFloat(hgsl[g].value);
					}
				}
				if(shsl[g].value!=""){
					if(!numVail.test(shsl[g].value)){
						alert("请正确输入合格数量！");
						shsl[g].value="";
						shsl[g].focus();
						return false;
					}else{
						if(parseFloat(shsl[g].value)>parseFloat(ycshsl[g].value)){
							alert("出库损毁数量不能大于储位已存损毁数量！");
							return false;
						}
						shzsl +=parseFloat(shsl[g].value);
					}
				}
			}
			if(parseFloat(hgzsl)>parseFloat(crhgsl[h].value)){
				alert("设置的出库合格数量不能大于要求出库的合格数量！");
				return false;
			}
			if(parseFloat(shzsl)>parseFloat(crshsl[h].value)){
				alert("设置的出库损毁数量不能大于要求出库的损毁数量！");
				return false;
			}
		}
	}
	
	function isNull(){
		var numVail = /^[0-9]+$|[0-9]+\.[0-9]+$/;
		var crhpbh = document.getElementsByName("crhpbh");
		var crhgsl = document.getElementsByName("crhgsl");
		var crshsl = document.getElementsByName("crshsl");
		for(var h=0 ; h<crhpbh.length; h++){
			var hgzsl = 0.0;
			var shzsl = 0.0;
			var ychgsl = document.getElementsByName("ychgsl"+crhpbh[h].value);
			var ycshsl = document.getElementsByName("ycshsl"+crhpbh[h].value);
			var hgsl = document.getElementsByName("hgsl"+crhpbh[h].value);		
			var shsl = document.getElementsByName("shsl"+crhpbh[h].value);
			for(var g=0;g<ychgsl.length;g++){
				var cwccl = 0.0;
				if(hgsl[g].value!=""){
					if(!numVail.test(hgsl[g].value)){
						alert("请正确输入合格数量！");
						hgsl[g].value="";
						hgsl[g].focus();
						return false;
					}else{
						if(parseFloat(hgsl[g].value)>parseFloat(ychgsl[g].value)){
							alert("出库合格数量不能大于储位已存合格数量！");
							return false;
						}
						hgzsl +=parseFloat(hgsl[g].value);
					}
				}
				if(shsl[g].value!=""){
					if(!numVail.test(shsl[g].value)){
						alert("请正确输入合格数量！");
						shsl[g].value="";
						shsl[g].focus();
						return false;
					}else{
						if(parseFloat(shsl[g].value)>parseFloat(ycshsl[g].value)){
							alert("出库损毁数量不能大于储位已存损毁数量！");
							return false;
						}
						shzsl +=parseFloat(shsl[g].value);
					}
				}
			}
			if(parseFloat(hgzsl)>parseFloat(crhgsl[h].value)){
				alert("设置的出库合格数量不能大于要求出库的合格数量！");
				return false;
			}
			if(parseFloat(shzsl)>parseFloat(crshsl[h].value)){
				alert("设置的出库损毁数量不能大于要求出库的损毁数量！");
				return false;
			}
			if(parseFloat(hgzsl)!=parseFloat(crhgsl[h].value)){
				alert("要求出库的合格数量和设置的出库合格数量不等！");
				return false;
			}
			if(parseFloat(shzsl)!=parseFloat(crshsl[h].value)){
				alert("要求出库的损毁数量和设置的出库损毁数量不等！");
				return false;
			}
		}
	}
    </script> 
  </head>
  <body>
  	<html:form action="/cczx.do?method=ckObject" onsubmit="return isNull();" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>出库订单</center></caption>
    		<tr>
    			<td align="right" width="20%">订单编号&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%">
    				<html:text property="vo.ddbh" styleClass="input" readonly="true"/>
    				<div id="ddbh"></div>
    			</td>
    			<td align="right" width="20%">入库订单&nbsp;&nbsp;&nbsp;&nbsp;
    			<td><input type="text" name="rkddbh" class="input" value="${crkddbh }" readonly="readonly"/>
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
    			<td align="right">紧急程度&nbsp;&nbsp;&nbsp;&nbsp;
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
    			<td align="right">库房信息&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.kfmc" styleClass="input" readonly="true"/>
    				<html:hidden property="vo.sykfzj" styleClass="input"/>
    			</td>
    			<td align="right">出库类型&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:radio property="vo.crklx" value="正常出库">正常出库</html:radio>
    				<html:radio property="vo.crklx" value="调拨出库">调拨出库</html:radio>
    				<html:radio property="vo.crklx" value="退货出库">退货出库</html:radio>
    			</td>
    		</tr> 	
    		<tr>    			
    			<td align="right">
    			出库方式&nbsp;&nbsp;&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.crkfs" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">预计出库时间&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.yjcrksj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>   
    		<tr>    			
    			<td align="center" colspan="4">货品信息</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
	    				<tr align="center">
	    					<td width="9%">货品名称</td>
	    					<td>货品属性及存储设置</td>
	    				</tr>
	    			<tbody id="tbody">
						<c:forEach var="obj" items="${list }">
							<tr align="center">
		    					<td>${obj.hpmc }</td>
		    					<td>
			    					<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
				    					<tr>
				    					<td align="right">货品编号:</td><td>${obj.hpbm}<input type="hidden" name="crhpzj" value="${obj.crkhpzj }"><input type="hidden" name="crhpbh" value="${obj.hpbm }"></td>
				    					<td align="right">货品单位:</td><td>${obj.hpdw}<input type="hidden" name="crhpdw" value="${obj.hpdw }"></td>
				    					
				    					<td align="right">货品类型:</td><td>${obj.hplx}</td>
				    					<td align="right">货品总数:</td><td>${obj.hpsl}</td>
				    					
				    					<td align="right">合格数量:</td><td>${obj.hgsl}<input type="hidden" name="crhgsl" value="${obj.hgsl }"></td>
				    					<td align="right">损毁数量:</td><td>${obj.shsl}<input type="hidden" name="crshsl" value="${obj.shsl }"></td>
				    					</tr>
				    					<tr>
				    					<td width="8%" align="center"><a href="javascript:" onclick="setQw(this,'${obj.hplx}','${obj.hpbm }')">设置区位</a></td>
										<td colspan="11">
										<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
										</table>
										</td>
										</tr>
									</table>
								</td>
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
    				<input type="submit" value="出 库" class="inputbutton"/> 
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="orderKind" value="${orderKind }">
    			</td>
    		</tr>
    	</table>
  	</html:form>
  </body>
  <div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1">
        </div>
    </div>
	</div>
</html>