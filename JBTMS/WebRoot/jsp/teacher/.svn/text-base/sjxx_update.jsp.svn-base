<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>  
    <script language="javascript"
			src="<%=request.getContextPath()%>/ext-2.0.1/examples/window/hello2.js"></script>
   <script type="text/javascript">
   		var tjhpst = '${tjhpst}';
    	function IsNull(){
    		var sjbh = document.all("sjbh");
    		var sjmc = document.all("sjmc");
    		var hpbm = document.getElementsByName("hpbm");
    		var stPk = document.getElementsByName("stPk");
    		var exp = /^\w+$/;
    		var expInt = /^\d+$/;
    		if(!exp.test(sjbh.value)){
    			alert("任务编号由字母和数字组成!");
    			return false;
    		}
    		if(sjmc.value==""){
    			alert("请输入任务名称!");
    			return false;
    		}
    		for(var i=0;i<hpbm.length;i++){
    			for(var j=i+1;j<hpbm.length;j++){
    				if(hpbm[i].value==hpbm[j].value){
    					alert("不能重复添加货品!");
    					return false;
    				}
    			}
    		}
    		if(stPk.length==0){
    			alert("请输入任务操作信息!");
    			return false;
    		}else{
    			for(var i = 0;i<stPk.length;i++){
    				var yksl = document.all("list["+i+"].yksl");
    				if(!expInt.test(stPk[i].value)){
    					alert("任务信息输入有误!");
    					return false;
    				}
    				if(stPk[i].value==tjhpst){
    					var hp = document.all("hpsl");
    					if(hp){
    						if(!(hp.length)){
    							if(hp.value==""){
	    							alert("请填写货品数量！");
	    							return false;
	    						}
	    						if(!expInt.test(hp.value)){
	    							alert("货品数量只能输入整数！");
	    							return false;
	    						}
    						}
	    					for(var d=0;d<hp.length;d++){
	    						if(hp[d].value==""){
	    							alert("请填写货品数量！");
	    							return false;
	    						}
	    						if(!expInt.test(hp[d].value)){
	    							alert("货品数量只能输入整数！");
	    							return false;
	    						}
	    					}
	    				}else{
	    					alert("请选择货品！");
	    					return false;
	    				}
    				}
    				if(yksl!=null){
    					if(!expInt.test(yksl.value)){
    						alert("移库数量输入有误!");
    						return false;
    					}
    				}
    			}   			
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/sjxx.do?method=objList&page=1";
    	}
    	function valiValue(o){
    		var sjzj = document.all("sjzj");
    		if(o.value!=""){
    			UserDWR.isExit("from Sjxx where sjbh =? and sjzj<>"+sjzj.value,o.value,function cd(data){
    				var field = document.getElementById("bjbh");
    				var submitbut = document.all("submitbut");
    				if(data){
    					submitbut.disabled=true;
    					field.innerHTML="试卷编号已存在！";
    				}else{
    					field.innerHTML="";
    					submitbut.disabled=false;
    				}
    			});
    		}
    	}    
    	function setValue(){
			var pagemsglx = document.all("pagemsglx");
			if(pagemsglx&&"goods"==pagemsglx.value){
				var pk = document.getElementsByName("lsid");
				var hppk = document.getElementsByName("hppk");
				var ls = document.getElementsByName("ls");
				var showhp = document.getElementById("showhp");
				var hpls = document.getElementsByName("hpls");
				var ehpmc = document.getElementsByName("ehpmc");
				var ehpbm= document.getElementsByName("hpls");
				for(var j =0;j<pk.length;j++) {
					if(pk[j].value==tjhpst){
	   					var hptab = document.getElementById("showhp");
	   					var hpbody = hptab.lastChild;
	   					for(var i=0;i<hppk.length;i++){
							if(hppk[i].checked){
	    					var etd = document.createElement("<td align='center'>");
						    var tdNode = document.createTextNode(ehpmc[i].value);
						    etd.appendChild(tdNode);
						    var inpE2 = document.createElement("<input type='text' name='hpsl' class='inputsmall2'>");
						    inpE2.setAttribute("value","");
						    var inpE3 = document.createElement("<input type='hidden' name='hpbm'>");
						    inpE3.setAttribute("value",ehpbm[i].value);
						    var butE = document.createElement("<img src='<%=request.getContextPath()%>/images/button/del.gif' alt='点击删除' style='cursor:hand;' onclick='delTrE(this);'>");
						    var rows = hptab.rows;
						    var flags = false;
						    for(var r=0;r<rows.length;r++){
						    	var rowfirstchild = rows[r].firstChild.firstChild;
								if(rows[r].firstChild.innerText!=null){
									var tdtext = rows[r].firstChild.innerText;
									if(ehpmc[i].value==tdtext){
										flags = true;
										break;
									}
								}
						    	if(rowfirstchild.innerHTML!=null){
									if(ehpmc[i].value==rowfirstchild.innerHTML){
										flags = true;
										break;
									}
						    	}
						    }
						    if(flags){
						    	continue;
						    }
						    var row = hpbody.insertRow();
						    var cell1 = row.insertCell();
						    var cell2 = row.insertCell();
						    var cell3 = row.insertCell();
						    var cell4 = row.insertCell();
						    cell1.appendChild(etd);
						    cell2.appendChild(inpE2);
						    cell3.appendChild(butE);
						    cell4.appendChild(inpE3);
							}
	   					}
				   }
			   }
			}else{
				var pk = document.getElementsByName("lsid");
				var hppk = document.getElementsByName("");
				var ls = document.getElementsByName("ls");
				var showhp = document.getElementById("showhp");
				var hpls = document.getElementsByName("hpls");
				var stlxzw = document.getElementsByName("stlxzw");
				var ktsfyklx = document.getElementsByName("ktsfyklx");
				var msg = "<table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\" style=\"word-break:break-all;\">"+
					"<tr align=\"center\">"+
						"<td>操作编号</td>"+
						"<td>操作名称</td>"+
						"<td>操作类型</td>"+
						"<td>操作描述</td>"+
					"</tr>";
				var ind = 0;
				for(var i=0;i<pk.length;i++){
					if(pk[i].checked){
						msg = msg + "<tr align=\"center\"><td><input type=\"hidden\" name=\"stPk\" value=\""+pk[i].value+"\"/>"+parseInt(ind+1)+"</td><td>"+ls[i].value+"</td>"+
							"<td>"+stlxzw[i].value+"</td>";
	    				if(ktsfyklx[i].value=='0'){
	    					if(pk[i].value==tjhpst){
	    						msg=msg+"<td><table id='showhp' width='200' border='0' cellpadding='0' cellspacing='1' style='word-break:break-all;' ><tr><td colspan='3' align='center'>添加货品:<img src=\"<%=request.getContextPath()%>/images/button/export.jpg\" alt=\"点击添加货品\" style=\"cursor:hand;\" onclick='pageGdata(1);'/></td></tr></table>";
	    					}else{
	    						msg=msg+"<td><input type=\"text\" name=\"list["+ind+"].ktms\" class=\"input\" style=\"width:150pt\"/></td>";
	    					}
	    				}else{
	    					msg=msg+"<td>移库数量:<input type=\"text\" name=\"list["+ind+"].yksl\" class=\"input\" style=\"width:60pt\"/></td>";
	    				}
	    				
	    				msg = msg+"</tr>";  
	    				ind++;  
				}
				}
				msg = msg + "</table>";
				document.getElementById("stlb").innerHTML=msg;
			}
		}
		function delTrE(obj){
			var tabId = document.getElementById("showhp");
			var tbody = tabId.lastChild;
			tbody.removeChild(obj.parentNode.parentNode);
		}		
		function pageGdata(curpage){
			document.getElementById("show-btn").click();
    		UserDWR.getGoods(curpage,cdg);
    	}
    	function cdg(data){
    		var list = data.pagedata;
			var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
   				"<tr align=\"center\" height=\"30\">"+
				"<td>选择<input type='hidden' name='pagemsglx' value='goods'></td><td>货品编码</td><td>货品名称</td><td>货品类型</td></tr>";
    		  for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"hppk\" value=\""+obj+"\" />"+
							  "<input type=\"hidden\" name=\"hplsid\" value=\""+list[obj].hpzj+"\">"+
							   "<input type=\"hidden\" name=\"hpls\" value=\""+list[obj].hpbm+"\">"+
							  "<input type=\"hidden\" name=\"ehpmc\" value=\""+list[obj].hpmc+"\">"+
							  "</td><td>"+list[obj].hpbm+"</td><td>"+list[obj].hpmc+"</td><td>"+list[obj].hplx+"</td></tr >";					
		    		}
    			}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无货品信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		infoview.innerHTML=msg+pageMsg(data,"pageGdata");
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
		function selAll(){ 
		    var o=document.getElementsByName("lsid"); 
		     for(i=0;i<o.length;i++) {
			 	if(!o[i].disabled){
			       o[i].checked=event.srcElement.checked; 
			     }
			 }
		}
    </script> 
  </head>  
  <body>
    <html:form action="/sjxx.do?method=updObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>任务管理</center></caption>
    		<tr>
    			<td align="right">任务编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="sjbh" styleClass="input" readonly="true"/>
    				<html:hidden property="cjrzj"/>
    				<html:hidden property="sjzj"/>
    				<html:hidden property="stmc"/>
    				<html:hidden property="ksgz"/>
    				<div id="spts"></div>
    			</td>    		
    			<td align="right">任务名称&nbsp;&nbsp;</td>
    			<td><html:text property="sjmc" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">发布时间&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="cjsj" styleClass="input" readonly="true"/>    				
    			</td>
    			<td align="right">任务状态&nbsp;&nbsp;</td>
    			<td>
    			<html:select property="sjzt" style="width:100pt;">
    				<html:option value="1">启用</html:option>
    				<html:option value="0">禁用</html:option>
    			</html:select>  				
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">操作选择
    			<img src="<%=request.getContextPath()%>/images/button/export.jpg" id="show-btn2" alt="点击选择" style="cursor:hand;"/>    			
    			</td>    			
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    			<div id="stlb">
    				<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    					<tr align="center">
    						<td>操作编号</td>
    						<td>操作名称</td>
    						<td>操作类型</td>
    						<td>操作描述</td>
    					</tr>
    					<logic:notEmpty name="ktlist">
    						<logic:iterate id="ktobj" name="ktlist" indexId="ind">
	    						<tr align="center">
		    						<td><input type="hidden" name="stPk" value="${ktobj.stgl.stzj }"/>${ind+1} </td>
		    						<td><input type="hidden" name="list[${ind}].ftzj" value="${ktobj.ftzj }"/>${ktobj.stgl.stmc }</td>
								 	<td>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'0')}">基础资料
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'1')}">客户关系
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'2')}">仓储
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'3')}">订单
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'4')}">财务
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'5')}">决策
									</c:if>
								 	</td>			

		    						<c:if test="${ktobj.stgl.sfyk==0 }">		    						
		    						<c:if test="${ktobj.stgl.stzj==tjhpst}">
		    				 		<td>
		    				 			<table id="showhp" width="200" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
		    				 				<tr>
		    				 					<td align="center" colspan="3">货品添加<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击添加货品" style="cursor:hand;" onclick='pageGdata(1);'/></td>
		    				 				</tr>
		    				 				<c:if test="${hplist!=null }">
			    				 				<c:forEach var="sjhp" items="${hplist}">
			    				 				<tr>
			    				 					<td align="center">
			    				 						<c:forEach var="hpxx" items="${hpxxlist }">
			    				 						<c:if test="${sjhp.hpbm==hpxx.hpbm }">${hpxx.hpmc }</c:if>
			    				 						
			    				 						</c:forEach>
			    				 						<input type="hidden" name="hpbm" value="${sjhp.hpbm }">
			    				 					</td>
			    				 					<td > <input type="text" name="hpsl" value="${sjhp.hpsl }" class="inputsmall2"></td>
			    				 					<td><img src='<%=request.getContextPath()%>/images/button/del.gif' alt='点击删除' style='cursor:hand;' onclick='delTrE(this);'></td>
			    				 				</tr>
			    				 				</c:forEach>
		    				 				</c:if>
		    				 			</table>
		    				 		</td>
		    				 		</c:if>
		    				 		<c:if test="${ktobj.stgl.stzj!=tjhpst}">
		    				 		<td><input type="text" name="list[${ind }].ktms" value="${ktobj.ktms }" class="input" style="width:150pt" readonly="readonly"/></td>
		    				 		</c:if>
		    						</c:if>
		    						<c:if test="${ktobj.stgl.sfyk!=0 }">
		    				 		<td>移库数量:<input type="text" name="list[${ind }].yksl" value="${ktobj.yksl }" class="input" style="width:60pt"/></td>
		    				 		</c:if>
	    						</tr>
    						</logic:iterate>
    					</logic:notEmpty>				
    				</table>
    			</div>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="hidden" id="show-btn">
    				<html:submit styleClass="inputbutton" styleId="submitbut">修 改</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" name="show-hp">
    			</td>
    		</tr>
    	</table>
    </html:form>
   <div id="hello-win" class="x-hidden">
			<div id="hello-tabs">
				<div class="tanchuang" id="infoview"></div>
			</div>
		</div>
    <div id="hello-win2" class="x-hidden">
		<div id="hello-tabs2">
			<div style="height: 330px;overflow: auto">
				<table border="0" width="100%" cellpadding="0" cellspacing="1" style="word-break:break-all;">
    			<tr align="center" height="30">
					<td>
						 选 择<input type="checkbox" id="delpk" onClick="return selAll();">
					</td>
					<td>
						操作名称
					</td>
					<td>
						操作类型
					</td>
				</tr>
				<logic:notEmpty name="list">
					<logic:iterate id="obj" name="list">
						<c:set var="che" value=""></c:set>
						<logic:iterate id="ktobj" name="ktlist">
							<c:if test="${obj.stzj==ktobj.stgl.stzj }">
								<c:set var="che" value="checked='checked'"></c:set>
							</c:if>
						</logic:iterate>
						<tr align="center" height="25">
							<td>
								<input type="checkbox" name="lsid" value="${obj.stzj}" ${che }/>
								<input type="hidden" name="ls" value="${obj.stmc }">
								<input type="hidden" name="ktsfyklx" value="${obj.sfyk }">
							</td>
							<td>
								${obj.stmc }
							</td>
							<td>
								<c:set var="stlxzw" value=""></c:set>
								<c:if test="${fn:contains(obj.stlx,'0')}">基础资料
									<c:set var="stlxzw" value="${stlxzw}基础资料"></c:set>
								</c:if>
								<c:if test="${fn:contains(obj.stlx,'1')}">客户关系
									<c:set var="stlxzw" value="${stlxzw}客户关系"></c:set>
								</c:if>
								<c:if test="${fn:contains(obj.stlx,'2')}">仓储
									<c:set var="stlxzw" value="${stlxzw}仓储"></c:set>
								</c:if>
								<c:if test="${fn:contains(obj.stlx,'3')}">订单
									<c:set var="stlxzw" value="${stlxzw}订单"></c:set>
								</c:if>
								<c:if test="${fn:contains(obj.stlx,'4')}">财务
									<c:set var="stlxzw" value="${stlxzw}财务"></c:set>
								</c:if>
								<c:if test="${fn:contains(obj.stlx,'5')}">决策
									<c:set var="stlxzw" value="${stlxzw}决策"></c:set>
								</c:if>
								<input type="hidden" name="stlxzw" value="${stlxzw}">
							</td>
						</tr >
					</logic:iterate>
				</logic:notEmpty>
				<logic:empty name="list">
					<tr align="center" height="30">
						<td colspan="9">
							暂无操作信息!
						</td>
					</tr>
				</logic:empty>
    		</table>
        </div>
    </div>
	</div>
  </body>
</html>