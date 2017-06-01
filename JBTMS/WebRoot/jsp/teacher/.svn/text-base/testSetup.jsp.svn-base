<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp" %>
<html>
	<head>
		<title><bean:message key="system.title"></bean:message></title>
	<script type="text/javascript">	
	function isNull(){
		var classInfo = document.getElementById("classInfo").value;
		var flowInfo = document.getElementById("flowInfo").value;
		var usersel = document.getElementsByName("usersel");
		var flag = false;
		var numVali = /^[0-9]+$/;
		if(classInfo==""){
			alert("请选择实验班级！");
			return false;
		}
		for(var i=0;i<usersel.length;i++){
			if(usersel[i].checked){
				flag = true;
				break;
			}
		}
		if(!flag){
			alert("请选择学生信息!");
			return false;
		}
		if(flowInfo==""){
			alert("请选择实验流程！");
			return false;
		}
	}
	function selAll(){
	     o=document.getElementsByName("usersel");
	     for(i=0;i<o.length;i++) 
	     if(!o[i].disabled)
	    	o[i].checked=event.srcElement.checked; 
    }
    function getClaInfo(curpage){
    	var div1 = document.getElementById("div1");
    	var expNum = /^[0-9]+$/;
    	if(expNum.test(curpage)){
    		var countHql = "select count(A) from Bjxx A left join A.jsbjs B inner join B.jsgl C where C.jxzj=${userPk}";
    		var hql = "select A from Bjxx A left join A.jsbjs B inner join B.jsgl C where C.jxzj=${userPk}";
    		UserDWR.getPageinfo(countHql,hql,curpage,10,null, function getInfo(data){
	    		var arr = data.pagedata;
	    		var msg = "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
			    	"<tr align=\"center\" height=\"30\">"+
			    		"<td><input type=\"hidden\" name=\"paramType\" value=\"claSelInfo\">选 择</td>"+
			    		"<td>班级编号</td>"+    		
			    		"<td>班级名称</td></tr>";
			    for(var obj in arr){
	    			if(!isNaN(obj)){
	    				msg+="<tr><td style='text-align:center;'><input type='radio' name='paramPk' value='"+arr[obj].bjzj+"'/><input type='hidden' name=\"className\" value='"+arr[obj].bjmc+"'</td><td style='text-align:center;'>"+arr[obj].bjbh+"</td><td style='text-align:center;'>"+arr[obj].bjmc+"</td></tr>";
	    			}
	    		}
	    		msg+="</table>";
	    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
					"<tr>"+
					"<td style=\"text-align:right;\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\"getClaInfo(1);\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\"getClaInfo("+data.previouspage+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\"getClaInfo("+data.nextpage+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\"getClaInfo("+data.allpage+");\"/>"+					
						"</td>"+
					"</tr>"+
				"</table>"
	    		div1.innerHTML=msg;
	    		document.getElementById("show-btn").click();
	    	});
    	}    	
    }
    function getFlowInfo(curpage){
    	var div1 = document.getElementById("div1");
    	var expNum = /^[0-9]+$/;
    	if(expNum.test(curpage)){
    		var countHql = "select count(A) from Sjxx A";
    		var hql = "from Sjxx A";
    		UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
	    		var arr = data.pagedata;
	    		var msg = "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
			    	"<tr align=\"center\" height=\"30\">"+
			    		"<td style='text-align:center;'><input type=\"hidden\" name=\"paramType\" value=\"flowSelInfo\">选 择</td>"+
			    		"<td style='text-align:center;'>任务编号</td>"+    		
			    		"<td style='text-align:center;'>任务名称</td></tr>";
			    for(var obj in arr){
	    			if(!isNaN(obj)){
	    				msg+="<tr><td style='text-align:center;'><input type='radio' name='paramPk' value='"+arr[obj].sjzj+"'/><input type='hidden' name=\"flowName\" value='"+arr[obj].sjmc+"'</td><td style='text-align:center;'>"+arr[obj].sjbh+"</td><td style='text-align:center;'>"+arr[obj].sjmc+"</td></tr>";
	    			}
	    		}
	    		msg+="</table>";
	    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
					"<tr>"+
					"<td style=\"text-align:right;\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\"getFlowInfo(1);\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\"getFlowInfo("+data.previouspage+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\"getFlowInfo("+data.nextpage+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\"getFlowInfo("+data.allpage+");\"/>"+					
						"</td>"+
					"</tr>"+
				"</table>"
	    		div1.innerHTML=msg;
	    		document.getElementById("show-btn").click();
	    	});
    	}
    }
    function setValue(){
    	var paramType = document.all("paramType");
    	var paramPk = document.getElementsByName("paramPk");
    	if("claSelInfo"==paramType.value){
    		var className = document.getElementsByName("className");
    		var classInfo = document.all("classInfo");
    		var classInfoName = document.all("classInfoName");
    		for(var i=0;i<paramPk.length;i++){
    			if(paramPk[i].checked){
    				getUserinfos(1,10,paramPk[i].value);
    				classInfo.value=paramPk[i].value;
    				classInfoName.value=className[i].value;
    				break;
    			}
    		}
    	}else if("flowSelInfo"==paramType.value){
    		var flowInfo = document.all("flowInfo");
    		var flowId = document.all("flowId");
    		var flowName = document.getElementsByName("flowName");
    		for(var i=0;i<paramPk.length;i++){
    			if(paramPk[i].checked){    				
    				flowInfo.value=flowName[i].value;
    				flowId.value=paramPk[i].value;
    				break;
    			}
    		}
    	}
    }
    function getUserinfos(curpage, pagerecord, claPk){
    	var expNum = /^[0-9]+$/;
    	if(claPk!=null && !isNaN(claPk) && pagerecord!=null && expNum.test(pagerecord) && parseInt(pagerecord)>0){
    		var countHql = "select count(A) from Xsxx A where A.bjxx.bjzj="+claPk;
    		var hql = "from Xsxx A where A.bjxx.bjzj="+claPk;
    		UserDWR.getPageinfo(countHql,hql,curpage, pagerecord, null,function(data){
    			var arr = data.pagedata;
    			if(arr.length>0){
    				var stuListDiv = document.getElementById("stuListDiv");
					var msg="<table align=\"center\" border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\">"+
							"<tr>"+
								"<th height=\"30\" style='text-align:center;'><input type=\"checkbox\" id=\"delpk\" onClick=\"return selAll();\">全选</th><th style='text-align:center;'>学 号</th><th style='text-align:center;'>姓 名</th><th style='text-align:center;'>是否启用</th>"+
							"</tr>";
	    			
	    			for(var obj in arr){
	    				if(!isNaN(obj)){
	    					var states = "";
	    					if(arr[obj].yxbj==1){
	    						states="有效";
	    					}else{
	    						states="停用";
	    					}
	    					var hh = (arr[obj].zhsyrwmc==null)?"":arr[obj].zhsyrwmc;
	    					msg+="<tr><td style='text-align:center;'><input type=\"checkbox\" name=\"usersel\" value=\""+arr[obj].xszj+"\"/></td>"+
	    						"<td style='text-align:center;'>"+arr[obj].xsxh+"</td><td style='text-align:center;'>"+arr[obj].xsxm+"</td><td style='text-align:center;'>"+states+"</td></tr>";
	    				}
	    			}
	    			msg+="</table>";
	    			stuListDiv.innerHTML=msg+pageMsg(data,claPk);
	    			var dpage = document.all("curpage");
    				dpage.value=curpage;
    			}    			
    		});
    	}
    }
    function pageMsg(data,claPk){
		var msg = "";
		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
				"<td style=\"text-align:right;\">"+
					"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 <input type='text' name='pagesize' value="+data.pagerecord+" style='width:30pt;height=15pt;' onblur='getUserinfos(1,this.value,"+claPk+")'/> 条记录&nbsp;&nbsp;"+
					"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\"getUserinfos(1,"+data.pagerecord+","+claPk+");\"/>"+
					"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\"getUserinfos("+data.previouspage+","+data.pagerecord+","+claPk+");\"/>"+
					"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\"getUserinfos("+data.nextpage+","+data.pagerecord+","+claPk+");\"/>"+
					"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\"getUserinfos("+data.allpage+","+data.pagerecord+","+claPk+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
		return msg;
	}
	</script>
	<c:if test="${msg!=null }">
		<script type="text/javascript">
   			alert('${msg}');
   		</script>
	</c:if>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/testSetup.do?method=setup" name="form" method="post" onsubmit="return isNull();">
			<table align="center" border="0" width="100%" cellpadding="0" cellspacing="1">
				<tr  align="center" height="30px">
					<td colspan="6" valign="middle" style="text-align: left;">						
						&nbsp;&nbsp;&nbsp;&nbsp;<b>实验设置</b>
					</td>
				</tr>
				<tr height="30">
					<td align="right" height="27" width="20%"><input type="hidden" id="show-btn"/>						
						实验班级选择：&nbsp;&nbsp;
					</td>
					<td style="text-align: left;">
						<input type="hidden" name="classInfo" value="${classInfo}"/>
						<input type="text" name="classInfoName" value="${classInfoName}" class="input" readonly="readonly"/><img src="<%=request.getContextPath() %>/images/openwin.jpg" style="cursor:hand;" onclick="getClaInfo(1);"/>
					</td>
					<td align="right" height="27" width="20%">
						实验任务选择：&nbsp;&nbsp;
					</td>
					<td style="text-align: left;">
						<input type="hidden" name="flowId" value="${flowId}"/>
						<input type="text" name="flowInfo" class="input" value="${flowInfo}" readonly="readonly"/><img src="<%=request.getContextPath() %>/images/openwin.jpg" style="cursor:hand;" onclick="getFlowInfo(1);"/>
					</td>
				</tr>
				<tr >
					<td align="right" colspan="6" style="padding-top: 0pt;">
					<c:if test="${curpage==null }"><input type="hidden" name="curpage" value="1"/></c:if>
					<c:if test="${curpage!=null }"><input type="hidden" name="curpage" value="${curpage }"/></c:if>
					<div id="stuListDiv">
						<table align="center" border="0" width="100%" cellpadding="0" cellspacing="1">
							<tr>
								<th height="30" style='text-align:center;'><input type="checkbox" id="delpk" onClick="return selAll();">全选</th>
								<th style='text-align:center;'>学 号</th>
								<th style='text-align:center;'>姓 名</th>
								<!-- <th style='text-align:center;'>任 务</th> -->
								<th style='text-align:center;'>有效标记</th>
							</tr>
							<c:if test="${empty data.pagedata}">
							<tr>
								<td style="text-align:center;" colspan="6">请选择班级信息</td>
							</tr>
							</c:if>
							<c:if test="${!empty data.pagedata}">
								<c:forEach var="obj" items="${data.pagedata}">
									<tr>
										<td style="text-align:center;"><input type="checkbox" name="usersel" value="${obj.xszj }"/></td>
										<td style="text-align:center;">${obj.xsxh }</td>
										<td style="text-align:center;">${obj.xsxm }</td>
										<!-- <td style="text-align:center;">${obj.zhsyrwmc }</td> -->																				
										<td style="text-align:center;">
											<c:if test="${obj.yxbj==1}">有效</c:if>
											<c:if test="${obj.yxbj!=1}">停用</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:if>			
						</table>
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td style="text-align:right;">
								共 [${data.allpage}] 页&nbsp;&nbsp;当前第 [${data.curpage}] 页 &nbsp;&nbsp;每页 <input type='text' name='pagesize' value="${data.pagerecord}" style='width:30pt;height=15pt;' onblur="getUserinfos(1,this.value,${classInfo})"/> 条记录&nbsp;&nbsp;
								<input type="button" name="first" class="inputbutton3"	onClick="getUserinfos(1,${data.pagerecord},${classInfo});"/>
								<input type="button" name="before" class="inputbutton1" onClick="getUserinfos(${data.previouspage},${data.pagerecord},${classInfo});"/>
								<input type="button" name="next" class="inputbutton2" onClick="getUserinfos(${data.nextpage},${data.pagerecord},${classInfo});"/>
								<input type="button" name="last" class="inputbutton4" onclick="getUserinfos(${data.allpage},${data.pagerecord},${classInfo});"/>
								</td>
							</tr>
						</table>
					</div>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="center" height="33">
						<input type="submit" name="product" value="确 定"
							class="inputbutton">
						<input	type="reset" name="qd" value="重 置" class="inputbutton">
					</td>
				</tr>
			</table>
		</form>
		 <div id="hello-win" class="x-hidden">
		    <div id="hello-tabs">
		          <div class="tanchuang" id="div1">
			       </div>
			</div>
		</div>
	</body>
</html>
