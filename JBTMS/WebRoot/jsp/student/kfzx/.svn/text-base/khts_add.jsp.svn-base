<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
    	var bhexist = false;
    	function IsNull(){
    		var tskh = document.all("vo.tskh");
    		var tsr = document.all("vo.tsr");
    		var tsrq = document.all("vo.tsrq");
    		var tsrdh = document.all("vo.tsrdh");
    		var tsnr = document.all("vo.tsnr");
    		var phoneExp = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
    		if(tskh.value==""){
    			alert("请填写要投诉的客户！");
    			return false;
    		}
    		if(tsr.value==""){
    			alert("请填写投诉人！");
    			return false;
    		}
    		if(tsrdh.value==""){
    			alert("请填写投诉人电话！");
    			return false;
    		}
    		if(!phoneExp.test(tsrdh.value)){
    			alert("请正确填写投诉人电话！");
    			return false;
    		}
    		if(tsnr.value==""){
    			alert("请填写投诉内容！");
    			return false;
    		}
    	}
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khts.do?method=getList&page=1&rmMsg=true";
    	}
    	function setValue(){
			var pk = document.getElementsByName("pk");			
			var i = ToDel();
			if(i!=-1){
				var pagemsglx = document.all("pagemsglx");
				var ls = document.getElementsByName("ls");
				if(pagemsglx.value=='kh'){		
					var tskh = document.all("vo.tskh");
					tskh.value=ls[i].value;
				}
			}
				
		}
    	function ToDel() { 
		  var temp=document.getElementsByName("paramValue"); 
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
    	function pageAdata(curpage,lx){
    		var countHql = "select count(*) from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			var hql = " from Khxx where 1=1 and (ssxs = ${userPk} and sssysz = ${userSyszzj} or ssxs = 0 and sssysz = 0)";
			UserDWR.getPageinfo(countHql, hql, curpage,10,null,cdc);
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
    	
    </script> 
  </head>
  
  <body>
  	<html:form action="/khts.do?method=saveObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户投诉单</center></caption>
    		<tr>
    			<td align="right" width="20%">投诉编号&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="hidden" id="show-btn"/> 
    			</td>
    			<td width="25%">
    				<html:text property="vo.tsbh" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right" width="20%">投诉客户&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.tskh" styleClass="input" />    		
    				<img name="dh" src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageAdata(1,this.name);clickHid();"/>	
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">投 诉 人&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td width="25%">
    				<html:text property="vo.tsr"  styleClass="input"/>
    			</td>
    			<td align="right" width="20%">投诉人电话&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.tsrdh" styleClass="input" />    			
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">投诉日期&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%" colspan="3">
    				<html:text property="vo.tsrq" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">投诉内容&nbsp;&nbsp;<font color="red">*</font></td>
    			<td colspan="3">
    				<html:textarea property="vo.tsnr" cols="50" rows="4"></html:textarea>
    			</td>
    			
    		</tr>
    	
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.sfsl" value="0"/>
    				<html:hidden property="vo.slr" value=""/>
    				<html:hidden property="vo.slrq" value=""/>
    				<html:hidden property="vo.slhf" value=""/>
    				<html:hidden property="vo.ssxs" value="${userPk }"/>
    				<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				<input type="submit" value="添 加" class="inputbutton" onclick="return IsNull();"/>
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