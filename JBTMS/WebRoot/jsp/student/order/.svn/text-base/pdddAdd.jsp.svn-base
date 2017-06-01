<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <link rel="stylesheet" type="text/css" href="./css/newdate.css" />
    <script type="text/javascript">
		function IsNull(){
			var pdrq = $("vo.pdrq");
			var sykfmc = $("vo.sykfmc");
			var sykfzj = $("vo.sykfzj");
			if(pdrq.value==""){
				alert("请输入计划盘点日期!");
				return false;
			}
			if(checkDate(pdrq.value)){
				alert("计划日期输入有误!");
				return false;
			}
			if(sykfzj.value==""){
				alert("请选择库房信息!");
				return false;
			}
			return true;
		}
		function checkDate(date1){
			if(date1.length>10){
				date1=date1.substring(0,10);
			}
			var d1 = date1.split("-");
			var d2 = new Date();
			var y = d2.getYear();
			var m = d2.getMonth();
			var d = d2.getDate();
			var sdate = new Date(d1[0],d1[1]-1,d1[2]);
			var edate = new Date(y,m,d);
			return sdate<edate;
		}
		function pageKfdata(curpage,kflx){
			var countHql = "select count(A) from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			var hql = "from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			UserDWR.getPageinfo(countHql, hql, curpage,10,"正常",function(data){
				var list = data.pagedata;
				var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
						"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='kf"+kflx+"'></td><td>库房编号</td><td>库房名称</td></tr>";
			 		for(var obj in list){
			 			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].kfzj+"\" />"+
						  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].kfmc+"\">"+
						  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].kflx+"\">"+
						  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].ssjg+"\">"+
						  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].kfgly+"\">"+
							"</td><td>"+list[obj].kfbh+"</td><td>"+list[obj].kfmc+"</td></tr >";
			  		}
			 		}
			 		if(list.length==0){
			 			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无库房信息</td></tr>";
			 		}
			 		msg = msg + "</table>";
			 		msg = msg + pageMsg(data,"pageKfdata",kflx);
			 		div1.innerHTML=msg;
			 		document.getElementById("show-btn").click();
			});
		}
		function back(){
			window.location.href="./pddd.do?method=objList&page=1";
		}
		function setValue(){
			var paramPk = document.getElementsByName("paramPk");
			var paramValue = document.getElementsByName("paramValue");		
			
			for(var i=0;i<paramPk.length;i++){
				if(paramPk[i].checked){										
					var paramValue3 = document.getElementsByName("paramValue3");
	   				var sykfmc = $("vo.sykfmc");
  					var sykfzj = $("vo.sykfzj");
  					var pdr = $("vo.pdr");
  					sykfmc.value=paramValue[i].value;
  					sykfzj.value=paramPk[i].value;
  					pdr.value=paramValue3[i].value;
  					break;
				}
			}			
		}
		function pageMsg(data,fn,name){
		  	var msg = "";
		  	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\" onClick=\""+fn+"(1,'"+name+"');\"/>"+
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
  
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
  	<html:form action="/pddd.do?method=addObject" method="post" onsubmit="return IsNull();">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>盘点订单</center></caption>
    		<tr>
    			<td align="right" width="25%">盘点编号&nbsp;&nbsp;</td>
    			<td colspan="3"><html:text property="vo.pdbh" styleClass="input" readonly="true"/></td>    			
    		</tr>
    		<tr>
    			<td align="right" width="20%">计划日期<font color="red">*</font>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.pdzt"/>
    				<input type="hidden" id="show-btn"/>
    			</td>
    			<td >
    				<html:text property="vo.pdrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    			<td align="right">盘点库房<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.sykfmc" readonly="true" styleClass="input"/>    				
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageKfdata(1,'ck');"/>
    				<html:hidden property="vo.sykfzj"/>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">盘 点 人<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.pdr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">盘点类型&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.pdlx" style="width:100pt">
    					<html:option value="日盘点">日盘点</html:option>
    					<html:option value="月盘点">月盘点</html:option>
    					<html:option value="年盘点">年盘点</html:option>
    				</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit styleClass="inputbutton">添 加</html:submit>
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
