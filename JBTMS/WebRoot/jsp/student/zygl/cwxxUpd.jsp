<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function resetFpcw(cwpk,dqsl){
    		var cwsx = document.getElementById("cwsx"+cwpk);
    		var cwhp = document.getElementById("cwhp"+cwpk);
    		var hpmcs = document.getElementById("hpmc"+cwpk);
    		var hpdw = document.getElementById("hpdw"+cwpk);
    		
    		try{
    			if(parseFloat(dqsl)<=0){
    				if(cwsx.value!="" && !isNaN(cwsx.value) && parseInt(cwsx.value)>0 && cwhp.value!=""){    					
    					var cwxx = {cwzj:cwpk,cwsx:cwsx.value,hpbm:cwhp.value,hpmc:hpmcs.value,hpdw:hpdw.value};
    					UserDWR.resetCwxx(cwxx,function(data){
    						if(data){
    							alert("储位设置成功!");
    						}else{
    							alert("储位设置失败,请重试!");
    						}
    					});
    				}
    			}else{
    				alert("当前储位尚有货品，无法修改存储商品类型!");
    				cwsx.value=0;
    				cwhp.value='';
    				hpmcs.value='';
    				hpdw.value='';
    			}
    		}catch(e){
    			alert("参数给定有误!");
    		}
    	}
    	function getPageinfo(curpage,cwpk,dqsl){
    		var countHql = "select count(A) from Hpxx A where A.hplx = ?";
    		var hql = "from Hpxx A where A.hplx = ?";
    		UserDWR.getPageinfo(countHql,hql,curpage,10,'${qwxxForm.vo.cclx}',function(data){
    			var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='qcwpk' id='qcwpk' value='"+cwpk+"'/><input type='hidden' name='qdqsl' id='qdqsl' value='"+dqsl+"'/></td><td>货品编号</td><td>货品名称</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].hpzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].hpbm+"\">"+
							  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].hpmc+"\">"+
							  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].hpdw+"\">"+
								"</td><td>"+list[obj].hpbm+"</td><td>"+list[obj].hpmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无货品信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"getPageinfo",cwpk);	    		
	    		div1.innerHTML=msg;
	    		document.getElementById("show-btn").click();
    		});
    	}
    	function pageMsg(data,fn,fqzj,dqsl){
    		var msg = "";
    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,"+fqzj+","+dqsl+");\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+","+fqzj+","+dqsl+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+","+fqzj+","+dqsl+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+","+fqzj+","+dqsl+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
    	}
    	function setValue(){
    		var paramPks = document.getElementsByName("paramPk");
    		var paramValues = document.getElementsByName("paramValue");
    		var paramValues1 = document.getElementsByName("paramValue1");
    		var paramValues2 = document.getElementsByName("paramValue2");
    		var qcwpk = document.getElementById("qcwpk");
    		var qdqsl = document.getElementById("qdqsl");
    		for(var i=0;i<paramPks.length;i++){
    			if(paramPks[i].checked){
    				var hpbm = document.getElementById("cwhp"+qcwpk.value);
    				var hpmc = document.getElementById("hpmc"+qcwpk.value);
    				var hpdw = document.getElementById("hpdw"+qcwpk.value);    				
    				hpbm.value=paramValues[i].value;
    				hpmc.value=paramValues1[i].value;
    				hpdw.value=paramValues2[i].value;
    				resetFpcw(qcwpk.value,qdqsl.value);
    				break;
    			}
    		}
    	}
    	function back(){
    		window.location.href="./qwxx.do?method=objList";
    	}
    </script>   
  </head>
  
  <body>
    <html:form action="/qwxx.do?method=fpcw" method="post" onsubmit="return false;">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>储位管理(区位：${qwxxForm.vo.qwbh }) <p>标识符定义 U:上限 G:货品</p></center></caption>
    		<c:if test="${qwxxForm.vo.qfabm!=0 }">
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
    						<c:if test="${(i+1)%qwxxForm.vo.amls==0 }">    							
    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">A${row }-${qwxxForm.vo.amls }</font>
    							<div>
    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    								<tr align="center">
    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" onblur="resetFpcw('${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" onclick="getPageinfo(1,'${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/>
    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    									<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
    									</td>
    								</tr>
    							</table>
    							</div>
    							</td>
    							</tr>   
    							<c:set value="${row+1 }" var="row"></c:set>							
    						</c:if>
    						<c:if test="${(i+1)%qwxxForm.vo.amls!=0 }">
    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">A${row }-${(i+1)%qwxxForm.vo.amls }</font>
    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    								<tr align="center">
    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" onblur="resetFpcw('${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/></td>
    								</tr>
    								<tr align="center">
    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly"  onclick="getPageinfo(1,'${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/>
    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    									<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
    									</td>
    								</tr>
    							</table>
    							</td>
    						</c:if>    						
    					</logic:iterate>
    				</tbody>
    			</table><input type="hidden" id="show-btn"/>
    			</td>
    		</tr>
    		<c:if test="${qwxxForm.vo.qfabm!=0 }">
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
	    						<c:if test="${(i+1)%qwxxForm.vo.bmls==0 }">    							
	    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">B${row }-${qwxxForm.vo.bmls }</font>
	    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    								<tr align="center">
    										<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" onblur="resetFpcw('${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" onclick="getPageinfo(1,'${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/>
	    									<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    										<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
	    									</td>
	    								</tr>
	    							</table>
	    							</td>
	    							</tr>
	    							<c:set value="${row+1 }" var="row"></c:set>
	    						</c:if>
	    						<c:if test="${(i+1)%qwxxForm.vo.bmls!=0 }">
	    							<td align="center" style="cursor:hand;"><font color="${obj.hgsl+obj.shsl>0?'red':'blue' }">B${row }-${(i+1)%qwxxForm.vo.bmls }</font>
	    							<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    								<tr align="center">
	    									<td>U:<input type="text" alt="储位上限：${obj.cwsx }" name="cwsx${obj.cwzj }" id="cwsx${obj.cwzj }" value="${obj.cwsx }" onblur="resetFpcw('${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/></td>
	    								</tr>
	    								<tr align="center">
	    									<td>G:<input type="text" alt="货品编码：${obj.hpbm==null?'无':obj.hpbm }" name="cwhp${obj.cwzj }" id="cwhp${obj.cwzj }" value="${obj.hpbm }" readonly="readonly" onclick="getPageinfo(1,'${obj.cwzj }','${obj.hgsl+obj.shsl }');" class="inputsmall3"/>
	    										<input type="hidden" name="hpmc${obj.cwzj }" id="hpmc${obj.cwzj }" value="${obj.hpmc }"/>
    											<input type="hidden" name="hpdw${obj.cwzj }" id="hpdw${obj.cwzj }" value="${obj.hpdw }"/>
	    									</td>
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
    		<tr>
    			<td align="center" colspan="4" >
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
