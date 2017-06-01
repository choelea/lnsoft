<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
		function IsNull(){
			var htzj = $("khht.htzj");
			var syhth = $("vo.syhth");
			if(htzj.value==""){
				alert("请选择合同信息!");
				return false;
			}
			if(isNaN(htzj.value)){
				alert("合同信息输入有误!");
				return false;
			}
			if(syhth.value==""){
				alert("请选择合同信息!");
				return false;
			}
			return true;
		}
		function pageHtdata(curpage){
			var countHql = "select count(A) from Khht A where  A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.sfjs=0 and (A.htzt>0 and A.htlx<>'外包合同' or A.htzt>1 and A.htlx='外包合同')";
			var hql = "from Khht A where A.ssxs = ${userPk} and A.sssysz = ${userSyszzj} and A.sfjs=0 and (A.htzt>0 and A.htlx<>'外包合同' or A.htzt>1 and A.htlx='外包合同')";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,function(data){
				var list = data.pagedata;
				var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
						"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='htxx'></td><td>合同编号</td><td>合同名称</td><td>合同类型</td></tr>";
			 		for(var obj in list){
			 			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].htzj+"\" />"+
						  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].htbh+"\">"+
						  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].htmc+"\">"+
						  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].htlx+"\">"+
						  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].khzh+"\">"+
						  "<input type=\"hidden\" name=\"paramValue4\" value=\""+list[obj].jsfs+"\">"+
							"</td><td>"+list[obj].htbh+"</td><td>"+list[obj].htmc+"</td><td>"+list[obj].htlx+"</td></tr >";
			  		}
			 		}
			 		if(list.length==0){
			 			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无合同信息</td></tr>";
			 		}
			 		msg = msg + "</table>";
			 		msg = msg + pageMsg(data,"pageHtdata");
			 		div1.innerHTML=msg;
			 		document.getElementById("show-btn").click();
			});
		}
		function back(){
			window.location.href="./zdgl.do?method=objList&page=1";
		}
		function setValue(){
			var paramPk = document.getElementsByName("paramPk");
			var paramValue = document.getElementsByName("paramValue");		
			var paramValue1 = document.getElementsByName("paramValue1");
			var paramValue2 = document.getElementsByName("paramValue2");
			var paramValue3 = document.getElementsByName("paramValue3");
			var paramValue4 = document.getElementsByName("paramValue4");
			for(var i=0;i<paramPk.length;i++){
				if(paramPk[i].checked){
					var htzj = $("khht.htzj");
	   				var syhth = $("vo.syhth");
  					var htlx = $("vo.bz");
  					var jsfs = $("vo.jsfs");
  					var fkzh = $("vo.fkzh");
  					htzj.value=paramPk[i].value;
  					syhth.value=paramValue[i].value;
  					htlx.value=paramValue2[i].value;
  					fkzh.value=paramValue3[i].value;
  					jsfs.value=paramValue4[i].value;
  					UserDWR.getZdgl(paramPk[i].value,function(data){
  						var khqm = $("vo.khqm");
  						var ssjg = $("vo.ssjg");
  						var yfk = $("vo.yfk");
  						var yf = $("vo.yf");
  						var zf = $("vo.zf");
  						var bf = $("vo.bf");
  						var ccfy = $("vo.ccfy");
  						var ccyqfy = $("vo.ccyqfy");
  						var zje = $("vo.zje");
  						khqm.value=data.khxm;
  						ssjg.value=data.skr;
  						yfk.value=data.yfk;
  						yf.value=data.yf;
  						zf.value=data.zf;
  						bf.value=data.bf;
  						ccfy.value=data.ccfy;
  						ccyqfy.value=data.ccyqfy;
  						zje.value=data.zje;
  					});
  					break;
				}
			}			
		}
		function pageMsg(data,fn){
		  	var msg = "";
		  	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\" onClick=\""+fn+"(1);\"/>"+
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
  	<html:form action="/zdgl.do?method=addObject" method="post" onsubmit="return IsNull();">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>账单管理</center></caption>
    		<tr>
    			<td align="right" width="25%">账单编号&nbsp;&nbsp;</td>
    			<td ><html:text property="vo.zzdbh" styleClass="input" readonly="true"/></td>
    			<td align="right">做账日期&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.zdrq" readonly="true" styleClass="input"/>
    			</td>	
    		</tr>
    		<tr>
    			<td align="right" width="20%">合 同 号<font color="red">*</font>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.sfhx"/>
    				<html:hidden property="vo.ssjg"/>
    				<html:hidden property="khht.htzj"/>
    				<input type="hidden" id="show-btn"/>
    			</td>
    			<td >
    				<html:text property="vo.syhth" styleClass="input" readonly="true"/>
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageHtdata(1);"/>
    				<html:hidden property="vo.bz"/>
    			</td>
    			<td align="right">结算方式&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.jsfs" readonly="true" styleClass="input"/>    				
    				
    			</td>
    		</tr>
    		<tr>    			
    			<td align="right">客户姓名<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.khqm" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">付款帐号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.fkzh" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4">
    				<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    					<tr align="center">
    						<td align="center" width="30%">序 号</td>
    						<td>费用名称</td>
    						<td>金 额</td>
    					</tr>
    					<tr align="center">
    						<td>1</td>
    						<td align="center" width="30%">预 付 款</td>
    						<td align="center"><html:text property="vo.yfk" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>2</td>
    						<td align="center">运 费</td>
    						<td><html:text property="vo.yf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>3</td>
    						<td align="center">杂 费</td>
    						<td><html:text property="vo.zf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td>4</td>
    						<td align="center">保 费</td>
    						<td><html:text property="vo.bf" styleClass="input" readonly="true"/></td>
    					</tr>
    					<tr align="center">
    						<td></td>
    						<td align="center">总 计</td>
    						<td><html:text property="vo.zje" styleClass="input" readonly="true"/></td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.ccfy" styleClass="input"/>
					<html:hidden property="vo.ccyqfy" styleClass="input"/>
    				<html:hidden property="vo.ssxt" value="${curGwzj }"/>
    				<html:submit styleClass="inputbutton">生 成</html:submit>
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
