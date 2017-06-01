<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/newdate.css" />
    <script type="text/javascript">
    	var count = 0;
    	function $(tag){
    		return document.getElementById(tag);
    	}
    	function IsNull(){
    		var qhrq = document.all("vo.qhrq");//取货日期
    		var ddrq = document.all("vo.ddrq");
    		var dhf = $("dhf.dwmc");
    		var shf = $("shf.dwmc");
    		var dhfzj = $("dhf.khzj");
    		var shfzj = $("shf.khzj");
    		var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		var numExp = /^\d+$/;
    		var charExp = /^\w+$/;
    		var dateExp = /^\s*[1-9]{1}[0-9]{3}(-)((0[1-9]{1})|(1[0-2]{1}))(-)((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-2]{1}))\s*$/;
    		var expFloat = /(^\d+$)|(^\d*(.)\d+$)/;
    		if(dhf.value==""){
    			alert("请选择委托方!");
    			return false;
    		}
    		if(shf.value==""){
    			alert("请选择收货方!");
    			return false;
    		}
    		if(dhfzj.value==shfzj.value){
    			alert("请选择不同的委托方和收货方");
    			return false;
    		}
    		if(qhrq.value==""){
    			alert("请输入取货日期！");
    			return false;
    		}else if(checkDate(qhrq.value,ddrq.value)){
				alert("请输入正确的取货日期!");
				return false;
    		}
    		var inputE = document.getElementById("goodListId").getElementsByTagName("input");
    		if(inputE.length<=0){
    			alert("请选择货品!");
    			return false;
    		}else{    			
    			for(var i=0;i<count;i++){
    				var hpbm = document.getElementsByName("list["+i+"].hpbm");
    				if(hpbm.length>0){
    					var hpsl = document.getElementsByName("list["+i+"].hpsl");
    					if(!expFloat.test(hpsl[0].value)){
    						alert("货品数量输入有误!");
    						return false;
    					}
    				}
    			}
    		}
    		var dForm = document.forms[0];
    		dForm.action="<%=request.getContextPath()%>/khdd.do?method=save";
    		dForm.method="post";
    		dForm.submit();
    		return true;
    	}
    	function checkDate(date1,date2){
			var arr1 = date1.substring(0,10).split("-");
			var arr2 = date2.substring(0,10).split("-");
			var dat1 = new Date(arr1[0],arr1[1]-1,arr1[2]);
			var dat2 = new Date(arr2[0],arr2[1]-1,arr2[2]);
			return dat1<dat2;
		}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khdd.do?method=getList&page=1";
    	}
    	function setValue(){
			var paramValue = document.getElementsByName("paramValue");
			var paramField1 = document.getElementsByName("paramField1");
			var toFieldType = document.all("toFieldType");			
			var pagemsglx = document.all("pagemsglx");
			
			for(var i=0;i<paramValue.length;i++){
				if(paramValue[i].checked){
					if(pagemsglx.value=='kh'){
	    				var khbh = document.getElementsByName("ls");
	    				var khzj = document.getElementsByName("lsid");
	    				var lxr = document.getElementsByName("lxr");
	    				var lxrdh = document.getElementsByName("lxrdh");
	    				var ssjg = document.getElementsByName("ssjg");
	    				var khlx = $("khlx");
						if("dh"==khlx.value){
		    				var dhfmc = $("dhf.dwmc");
	    					var dhfzj = $("dhf.khzj");
	    					var dhflxr = $("dhf.lxr");
	    					var dhflxrdh = $("dhf.lxrdh");
	    					var dhfssjg = $("dhf.ssjg");
		    				dhfzj.value=khzj[i].value;
		    				dhfmc.value=khbh[i].value;
		    				dhflxr.value=lxr[i].value;
		    				dhflxrdh.value=lxrdh[i].value;
							break;
						}
						if("sh"==khlx.value){
							var shfmc = $("shf.dwmc");
	    					var shfzj = $("shf.khzj");
	    					var shflxr = $("shf.lxr");
	    					var shflxrdh = $("shf.lxrdh");
	    					var shfssjg = $("shf.ssjg");
		    				shfzj.value=khzj[i].value;
		    				shfmc.value=khbh[i].value;
		    				shflxr.value=lxr[i].value;
		    				shflxrdh.value=lxrdh[i].value;
							break;
						}
					}else if("goods"==pagemsglx.value){
						var paramField2 = document.getElementsByName("paramField2");
	    				var paramField3 = document.getElementsByName("paramField3");
	    				var paramField4 = document.getElementsByName("paramField4");
	    				var paramField5 = document.getElementsByName("paramField5");
	    				var paramField6 = document.getElementsByName("paramField6");
	    				var paramField7 = document.getElementsByName("paramField7");
	    				var paramField8 = document.getElementsByName("paramField8");
	    				var paramField9 = document.getElementsByName("paramField9");
	    				var paramField10 = document.getElementsByName("paramField10");
						var tabId = document.getElementById("goodListId");
						var tbody = tabId.lastChild;
						for(var i=0;i<paramValue.length;i++){
							if(paramValue[i].checked){
								var inpHid4=document.createElement("<input type='hidden' name='list["+count+"].hpdj'>");
								inpHid4.setAttribute("value",paramField7[i].value);
								var inpHid3=document.createElement("<input type='hidden' name='list["+count+"].hptj'>");
								inpHid3.setAttribute("value",paramField8[i].value);
								var inpHid2=document.createElement("<input type='hidden' name='list["+count+"].tjdw'>");
								inpHid2.setAttribute("value",paramField9[i].value);
								var inpHid1=document.createElement("<input type='hidden' name='list["+count+"].txm'>");
								inpHid1.setAttribute("value",paramField10[i].value);
								var inpEgg = document.createElement("<input type='hidden' name='list["+count+"].hpgg'>");
								inpEgg.setAttribute("value",paramField6[i].value);
						     	var inpE1 = document.createElement("<input type='text' name='list["+count+"].hpbm' class='inputsmall2' readonly='true' >");
						     	inpE1.setAttribute("value",paramField1[i].value);
						     	var inpE2 = document.createElement("<input type='text' name='list["+count+"].hpmc' class='inputsmall2' readonly='true' >");
						     	inpE2.setAttribute("value",paramField2[i].value);
						     	var inpE3 = document.createElement("<input type='text' name='list["+count+"].hpdw' class='inputsmall2' readonly='true' >");
						     	inpE3.setAttribute("value",paramField3[i].value);
						     	var inpE4 = document.createElement("<input type='text' name='list["+count+"].hplx' class='inputsmall2' readonly='true' >");
						     	inpE4.setAttribute("value",paramField4[i].value);
						     	var inpE5 = document.createElement("<input type='text' name='list["+count+"].hpxh' class='inputsmall2' readonly='true' >");
						     	inpE5.setAttribute("value",paramField5[i].value);
						     	var inpE6 = document.createElement("<input type='text' name='list["+count+"].hpsl' class='inputsmall2'>");
						     	var butE = document.createElement("<img src='<%=request.getContextPath()%>/images/button/del.gif' alt='点击删除' style='cursor:hand;' onclick='delTrE(this);'>");
								var row = tbody.insertRow();
								var cell1 = row.insertCell();
								var cell2 = row.insertCell();
								var cell3 = row.insertCell();
								var cell4 = row.insertCell();
								var cell5 = row.insertCell();
								var cell6 = row.insertCell();
								var cell7 = row.insertCell();
								cell1.appendChild(inpHid1);
								cell1.appendChild(inpHid2);
								cell1.appendChild(inpHid3);
								cell1.appendChild(inpHid4);
								cell1.appendChild(inpEgg);
								cell1.appendChild(inpE1);
								cell2.appendChild(inpE2);
								cell3.appendChild(inpE3);
								cell4.appendChild(inpE4);
								cell5.appendChild(inpE5);
								cell6.appendChild(inpE6);
								cell7.appendChild(butE);
								count++;
							}
						}
					}
				}
			}			
		}
		function pageAdata(curpage,lx){
    		var countHql = "select count(*) from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			var hql = " from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,cdc);
			$("khlx").value=lx;
    	}
    	function cdc(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='kh'></td><td>客户编号</td><td>单位名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramValue\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].dwmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].khzj+"\">"+
						  "<input type=\"hidden\" name=\"lxr\" value=\""+list[obj].lxr+"\">"+
						  "<input type=\"hidden\" name=\"lxrdh\" value=\""+list[obj].lxrdh+"\">"+
						  "<input type=\"hidden\" name=\"ssjg\" value=\""+list[obj].ssjg+"\">"+
							"</td><td>"+list[obj].khbh+"</td><td>"+list[obj].dwmc+"</td></tr >";
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无客户信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		msg = msg + pageMsg(data,"pageAdata");
    		div1.innerHTML=msg;    		
    	}
    	
    	function pageGdata(curpage,name){
    		var countHql = "select count(*) from Hpxx where 1=1 ";
			var hql = " from Hpxx where 1=1 ";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,function cdg(data){
	    		var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='goods'><input type='hidden' name='toFieldType' value='"+name+"'></td><td>货品编码</td><td>货品名称</td><td>货品类型</td></tr>";
	    		  for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"paramValue\" value=\""+list[obj].hpzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramField1\" value=\""+list[obj].hpbm+"\">"+
								  "<input type=\"hidden\" name=\"paramField2\" value=\""+list[obj].hpmc+"\">"+
								  "<input type=\"hidden\" name=\"paramField3\" value=\""+list[obj].hpdw+"\">"+
								  "<input type=\"hidden\" name=\"paramField4\" value=\""+list[obj].hplx+"\">"+
								  "<input type=\"hidden\" name=\"paramField5\" value=\""+list[obj].hpxh+"\">"+
								  "<input type=\"hidden\" name=\"paramField6\" value=\""+list[obj].hpgg+"\">"+
								  "<input type=\"hidden\" name=\"paramField7\" value=\""+list[obj].hpdj+"\">"+	
								  "<input type=\"hidden\" name=\"paramField8\" value=\""+list[obj].hptj+"\">"+
								  "<input type=\"hidden\" name=\"paramField9\" value=\""+list[obj].tjdw+"\">"+
								  "<input type=\"hidden\" name=\"paramField10\" value=\""+list[obj].txm+"\">"+							  
								  "</td><td>"+list[obj].hpbm+"</td><td>"+list[obj].hpmc+"</td><td>"+list[obj].hplx+"</td></tr >";					
			    		}
	    			}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无货品信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"pageGdata",name);
	    		div1.innerHTML=msg;
	    	});
    	}    		
    	function clickHid(){
    		document.getElementById("show-btn").click();
    	}
    	function pageMsg(data,fn,name){
    		var msg = "";
    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,'"+name+"');\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+",'"+name+"');\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+",'"+name+"');\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+",'"+name+"');\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
    	}
    	function delTrE(obj){
			var tabId = document.getElementById("goodListId");
			var tbody = tabId.lastChild;
			tbody.removeChild(obj.parentNode.parentNode);
		}
		
    </script> 
  </head>
  
  <body>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
  	<html:form action="/khdd.do?method=addObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户订单添加</center></caption>
    		<tr>
    			<td align="right" width="25%">订单编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="vo.ddbh" styleClass="input" readonly="true"/></td>
    			<td align="right" width="20%">订单日期&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs" value="${userPk }"/>
    				<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				<html:hidden property="vo.ddzt" value="0"/>
    				<input type="hidden" id="show-btn"/> 
    			</td>
    			<td >
    				<html:text property="vo.ddrq" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委 托 方<font color="red">*</font></td>
    			<td>
    				<html:text property="dhf.dwmc" readonly="true" styleClass="input"/>
    				<html:hidden property="dhf.khzj"/>
    				<img name="dh" src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1,this.name);clickHid();"/>
    			</td>
    			<td align="right">收 货 方<font color="red">*</font></td>
    			<td>
    				<html:text property="shf.dwmc" readonly="true" styleClass="input"/>
    				<html:hidden property="shf.khzj"/>
    				<img name="sh" src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1,this.name);clickHid();"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委托方联系人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="dhf.lxr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">收货方联系人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="shf.lxr" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">委托方电话&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="dhf.lxrdh" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">收货方电话&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="shf.lxrdh" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		
    		<tr>    			
    			
    			<td align="right">取货日期&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td >
    				<html:text property="vo.qhrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/><span id="sjts" style="color: red"></span>
    			</td>
    			<td align="right">填 单 人&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.zdr" styleClass="input" readonly="true" value="${userTName}"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品信息
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageGdata(1,'dhf');clickHid();"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tbody>
	    				<tr align="center">
	    					<td>货品编号</td>
	    					<td>货品名称</td>
	    					<td>货品单位</td>
	    					<td>货品类型</td>
	    					<td>货品型号</td>
	    					<td>货品数量<font color="red">*</font></td>
	    					<td></td>
	    				</tr>
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="添 加" class="inputbutton" onclick="return IsNull();"/>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="khlx">
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
