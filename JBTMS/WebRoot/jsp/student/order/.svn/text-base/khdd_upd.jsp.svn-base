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
    		var dForm = document.forms[0];
    		dForm.action="<%=request.getContextPath()%>/khdd.do?method=update";
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
    </script> 
  </head>
  
  <body >
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
  	<html:form action="/khdd.do?method=update" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户订单修改</center></caption>
    		<tr>
    			<td align="right" width="25%">订单编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="vo.ddbh" styleClass="input" readonly="true"/></td>
    			<td align="right" width="20%">订单日期&nbsp;&nbsp;
    				<html:hidden property="vo.ssxs" />
    				<html:hidden property="vo.sssysz" />
    				<html:hidden property="vo.ddzt" />
    				<html:hidden property="vo.ddzj"/>
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
    				<html:text property="vo.zdr" styleClass="input" readonly="true" />
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">货品信息
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
	    					<td>货品数量</td>
	    					<td></td>
	    				</tr>
						<c:forEach var="obj" items="${list }">
							<tr align="center">
								<td>
									<input type='hidden' name='khhpzj'
										value="${obj.ddhpzj }">
									<input type='text' name='hpbm' value="${obj.hpbm }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpmc' value="${obj.hpmc }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpdw' value="${obj.hpdw }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hplx' value="${obj.hplx }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpxh' value="${obj.hpxh }"
										class='inputsmall2' readonly='readonly'>
								</td>
								<td>
									<input type='text' name='hpsl' class='inputsmall2'
										value="${obj.hpsl }" readonly="readonly">
								</td>
							</tr>
						</c:forEach>
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="修 改" class="inputbutton" onclick="return IsNull();"/>
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
