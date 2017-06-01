<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">    	
    	function getKfPagedata(curpage){
    		var countHql = "select count(A) from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			var hql = "from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			UserDWR.getPageinfo(countHql, hql, curpage,10,"正常",function(data){
				var list = data.pagedata;
				var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
						"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='kfxx'></td><td>库房编号</td><td>库房名称</td></tr>";
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
			 		msg = msg + pageMsg(data,"getKfPagedata");
			 		div1.innerHTML=msg;
			 		document.getElementById("show-btn").click();
			});
    	}
    	function getQwPagedata(curpage){
    		var kfzj = $("kfxx.kfzj");
    		if(kfzj.value!="" && !isNaN(kfzj.value)){
    			var countHql = "select count(A) from Qwxx A where A.kfxx.kfzj = "+kfzj.value;
				var hql = "from Qwxx A where A.kfxx.kfzj = "+kfzj.value;
				UserDWR.getPageinfo(countHql, hql, curpage,10,null,function(data){
					var list = data.pagedata;
		    		var div1 = document.getElementById("div1");    		
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='qwxx'></td><td>区位编号</td><td>区位名称</td><td>存储类型</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].qwzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].qwbh+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].qwmc+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].cclx+"\">"+
									"</td><td>"+list[obj].qwbh+"</td><td>"+list[obj].qwmc+"</td><td>"+list[obj].cclx+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无区位信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"getQwPagedata");
		    		div1.innerHTML=msg;
					document.getElementById("show-btn").click();
				});
    		}else{
    			alert("请选择库房信息!");
    		}    		
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
    	function setValue(){
    		var paramPks = document.getElementsByName("paramPk");
    		var paramValues = document.getElementsByName("paramValue");    		
    		var pagemsglx = document.all("pagemsglx");
    		
    		for(var i=0;i<paramPks.length;i++){
    			if(paramPks[i].checked){
    				if("kfxx"==pagemsglx.value){
    					var kfzj =$("kfxx.kfzj");
    					var kfmc =$("kfxx.kfmc");
    					kfzj.value=paramPks[i].value;
    					kfmc.value=paramValues[i].value;
    					var qwzj =$("qwxx.qwzj");
    					var qwmc =$("qwxx.qwmc");
    					qwzj.value="";
    					qwmc.value="";
    				}else if("qwxx"==pagemsglx.value){    					
    					var qwzj =$("qwxx.qwzj");
    					var qwmc =$("qwxx.qwmc");
    					qwzj.value=paramPks[i].value;
    					qwmc.value=paramValues[i].value;
    				}    				
    				break;
    			}
    		}
    	}
    	function IsNull(){
    		var kfzj =$("kfxx.kfzj");
    		var qwzj =$("qwxx.qwzj");
    		if(kfzj.value!="" && qwzj.value!="" && !isNaN(kfzj.value) && !isNaN(qwzj.value)){
    			return true;
    		}else{
    			alert("请确认库房和区位信息!");
    			return false;
    		}
    	}
    	function back(){
    		window.location.href="./qwxx.do?method=objList";
    	}
    </script>   
  </head>
  
  <body>
    <html:form action="/kccx.do?method=query" method="post" onsubmit="return IsNull();">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >    		
		<caption><center>库存查询</center></caption>
			<tr>
				<td align="center" width="20%">库 房：</td>
				<td width="25%"><html:text property="kfxx.kfmc" readonly="true" styleClass="input"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getKfPagedata(1);"/>
					<html:hidden property="kfxx.kfzj"/>
					<input type="hidden" id="show-btn"/>
				</td>
				<td align="center" width="20%">区 位：</td>
				<td><html:text property="qwxx.qwmc" readonly="true" styleClass="input"/>
					<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getQwPagedata(1);"/>
					<html:hidden property="qwxx.qwzj"/>
					<html:submit styleClass="inputbutton">查 询</html:submit>
				</td>
			</tr>
    		<tr align="center">
    			<td colspan="4">标识符定义 U:上限 G:货品 O:合格数量 N:损毁数量</td>
    		</tr>
    		<c:if test="${kccxForm.qwxx.qfabm!=0 }">
	    		<tr>
	    			<td colspan="4" align="center">A 面</td>
	    		</tr>
    		</c:if>
    		<tr>
    			<td colspan="4">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    				<tbody id="aid">
    					<tr>
    					<c:set value="1" var="row"></c:set>
    					<logic:iterate id="obj" name="alist" indexId="i">
    						<c:if test="${(i+1)%kccxForm.qwxx.amls==0 }">    							
    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">A${row }-${kccxForm.qwxx.amls }</font>
    							<div>
    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    								<tr align="center">
    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly"class="inputsmall3"/>
    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    									<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
    									</td>
    								</tr>
    								<tr align="center">
    									<td>O:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.hgsl }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>N:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.shsl }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    							</table>
    							</div>
    							</td>
    							</tr>   
    							<c:set value="${row+1 }" var="row"></c:set>							
    						</c:if>
    						<c:if test="${(i+1)%kccxForm.qwxx.amls!=0 }">
    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">A${row }-${(i+1)%kccxForm.qwxx.amls }</font>
    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    								<tr align="center">
    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" class="inputsmall3"/>
    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    									<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
    									</td>
    								</tr>
    								<tr align="center">
    									<td>O:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.hgsl }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>N:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.shsl }" readonly="readonly" class="inputsmall3"/></td>
    								</tr>
    							</table>
    							</td>
    						</c:if>    						
    					</logic:iterate>
    				</tbody>
    			</table><input type="hidden" id="show-btn"/>
    			</td>
    		</tr>
    		<c:if test="${kccxForm.qwxx.qfabm!=0 }">
	    		<tr>
	    			<td colspan="4" align="center">B 面</td>
	    		</tr>
	    		<tr>
	    			<td colspan="4">
	    			<table width="90%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    				<tbody id="bid">
	    					<tr>
	    					<c:set value="1" var="row"></c:set>
	    					<logic:iterate id="obj" name="blist" indexId="i">
	    						<c:if test="${(i+1)%kccxForm.qwxx.bmls==0 }">    							
	    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">B${row }-${kccxForm.qwxx.bmls }</font>
	    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    								<tr align="center">
    										<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" class="inputsmall3"/>
	    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    										<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
	    									</td>
	    								</tr>
	    								<tr align="center">
	    									<td>O:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.hgsl }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>N:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.shsl }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    							</table>
	    							</td>
	    							</tr>
	    							<c:set value="${row+1 }" var="row"></c:set>
	    						</c:if>
	    						<c:if test="${(i+1)%kccxForm.qwxx.bmls!=0 }">
	    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">B${row }-${(i+1)%kccxForm.qwxx.bmls }</font>
	    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    								<tr align="center">
	    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" class="inputsmall3"/>
	    										<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    											<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
	    									</td>
	    								</tr>
	    								<tr align="center">
	    									<td>O:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.hgsl }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>N:<input type="text" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.shsl }" readonly="readonly" class="inputsmall3"/></td>
	    								</tr>
	    							</table>
	    							</td>
	    						</c:if>
	    					</logic:iterate>
	    				</tbody>
	    			</table>
	    			</td>
	    		</tr>
    		</c:if>
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
