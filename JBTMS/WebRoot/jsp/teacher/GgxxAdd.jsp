<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function IsNull(){
    		var ggbt = document.all("ggbt");
    		var ggzz = document.all("ggzz");
    		var fbsj = document.all("fbsj");
    		var bjzj = document.all("bjxx.bjzj");
    		var expNum = /^\d+$/;
    		if(ggbt.value==""){
    			alert("请输入公告标题!");
    			return false;
    		}
    		if(!expNum.test(bjzj.value)){
    			alert("班级信息输入有误!");
    			return false;
    		}
    		if(ggzz.value==""){
    			alert("请输入发布作者信息!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/ggxx.do?method=getList&page=1";
    	}  
    	function setValue(){
			var pk = document.getElementsByName("pk");
			var ls = document.getElementsByName("ls");
			var rkjs = document.all("bjxx.bjmc");
			var lsid = document.getElementsByName("lsid");
			var jszj = document.all("bjxx.bjzj");
			var i = ToDel();
			if(i!=-1){
				rkjs.value=ls[i].value;
				jszj.value=lsid[i].value;
			}
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
    	function pagedata(curpage){
    		UserDWR.claPagedata(" and  C.id = ${userPk}",curpage,null,cd);
    	}	
    	function cd(data){
	    	var list = data.pagedata;
    		var div1 = document.getElementById("div1");    		
			var msg = "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
   				"<tr align=\"center\">"+
				"<td>选择</td><td>班级编号</td><td>班级名称</td></tr>";
    		for(var obj in list){
    			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\"><td><input type=\"radio\" name=\"pk\" value=\""+obj+"\" />"+
						  "<input type=\"hidden\" name=\"ls\" value=\""+list[obj].bjmc+"\">"+
						  "<input type=\"hidden\" name=\"lsid\" value=\""+list[obj].bjzj+"\">"+
							"</td><td>"+list[obj].bjbh+"</td><td>"+list[obj].bjmc+"</td></tr >";					
	    		}
    		}
    		if(list.length==0){
    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无班级信息</td></tr>";
    		}
    		msg = msg + "</table>";
    		//分页信息
    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\"pagedata(1);\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\"pagedata("+data.previouspage+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\"pagedata("+data.nextpage+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\"pagedata("+data.allpage+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
    		div1.innerHTML=msg;
    	}
    </script> 
  </head>
  
  <body>
    <html:form action="/ggxx.do?method=addObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>公告管理</center></caption>
    		<tr>
    			<td width="40%" align="right">公告标题&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="ggbt" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">班级选择&nbsp;&nbsp;</td>
    			<td><html:text property="bjxx.bjmc" styleClass="input" readonly="true"/>
    				<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" id="show-btn"/>
    				<html:hidden property="bjxx.bjzj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">发 布 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="ggzz" styleClass="input" readonly="true"/>
    			</td>
    		</tr>   
    		<tr>
    			<td align="right">发布时间&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="fbsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr> 		
    		<tr>
    			<td align="right">公告内容&nbsp;&nbsp;</td>
    			<td>
    				<html:textarea property="ggnr" cols="50" rows="8"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">添 加</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
    <div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1">
    		<table border="0" width="100%" style="word-break:break-all;" cellpadding="0" cellspacing="1">
    			<tr align="center" height="30">
					<td>
						 选择
					</td>
					<td>
						班级编号
					</td>
					<td>
						班级名称
					</td>
				</tr>
				<c:if test="${!empty pageinfo.pagedata}">
					<c:forEach var="obj" items="${pageinfo.pagedata}" varStatus="i">
						<tr align="center" height="25">
							<td>
								<input type="radio" name="pk" value="${i } " />
								<input type="hidden" name="ls" value="${obj.bjmc }">
								<input type="hidden" name="lsid" value="${obj.bjzj }">
							</td>
							<td>
								${obj.bjbh }
							</td>
							<td>
								${obj.bjmc }
							</td>
						</tr >
					</c:forEach>
				</c:if>
				<c:if test="${empty pageinfo.pagedata}">
					<tr align="center" height="30">
						<td colspan="9">
							暂无班级信息!
						</td>
					</tr>
				</c:if>
    		</table>
    		<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
						<input type="button" name="first" class="inputbutton3"	onClick="pagedata(1);"/><input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage });"/><input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage });"/><input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage });"/>						
					</td>
				</tr>
			</table>
        </div>
    </div>
	</div>
  </body>
</html>
