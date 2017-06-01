<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	function IsNull(){
    		var sjzj = document.all("sjxx.sjzj");
    		var bjzj = document.all("bjxx.bjzj");
    		var expNum=/^[0-9]+$/;
    		if(!expNum.test(bjzj.value)){
    			alert("请输入实验班级信息!");
    			return false;
    		}
    		if(!expNum.test(sjzj.value)){
    			alert("请输入使用试卷信息!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./ksszExam.do?m=objList&page=1";
    	}
    	function getBjList(curpage){
    		var countHql = "select count(A) from Bjxx A";
    		var hql = "from Bjxx A";
    		ExamDWR.getPageinfo(countHql,hql,curpage,function(data){
    			var list = data.pagedata;		
    			var div1 = document.getElementById("div1");
    			var msg = "<table border=\"0\" width=\"100%\" style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td width='40'>选 择<input type='hidden' name='paramType' value='bjxx'/></td><td>班级编号</td><td>班级名称</td></tr>";
    			for(var obj in list){
    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].bjzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].bjmc+"\">"+
							  "</td><td>"+list[obj].bjbh+"</td><td>"+list[obj].bjmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无班级信息</td></tr>";
	    		}
    			div1.innerHTML=msg+pageMsg(data,"getBjList");
    			document.getElementById("show-btn").click();
    		});
    	}
    	function getSjList(curpage){
    		var countHql = "select count(A) from Sjxxs A";
    		var hql = "from Sjxxs A";
    		ExamDWR.getPageinfo(countHql,hql,curpage,function(data){
    			var list = data.pagedata;		
    			var div1 = document.getElementById("div1");
    			var msg = "<table border=\"0\" width=\"100%\" style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td width='40'>全选<input type='hidden' name='paramType' value='sjxx'/></td><td>试卷编号</td><td>试卷名称</td></tr>";
    			for(var obj in list){
    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].sjzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].sjmc+"\">"+
							  "</td><td>"+list[obj].sjbh+"</td><td>"+list[obj].sjmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无试卷信息</td></tr>";
	    		}
    			div1.innerHTML=msg+pageMsg(data,"getSjList");
    			document.getElementById("show-btn").click();
    		});
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
    		var paramType = document.all("paramType");
    		for(var i=0;i<paramPks.length;i++){
    			if(paramPks[i].checked){
    				if("bjxx"==paramType.value){
    					var bjzj = document.all("bjxx.bjzj");
    					var bjmc = document.all("bjxx.bjmc");
    					bjzj.value=paramPks[i].value;
    					bjmc.value=paramValues[i].value;
    				}else if("sjxx"==paramType.value){
    					var sjzj = document.all("sjxx.sjzj");
    					var sjmc = document.all("sjxx.sjmc");
    					sjzj.value=paramPks[i].value;
    					sjmc.value=paramValues[i].value;
    				}
    				break;
    			}
    		}
    	}
    </script> 
  </head>
  
  <body>
    <html:form action="/ksszExam.do?m=save" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>试验设置</center></caption>
    		<tr >
    			<td align="right" width="45%">
    				实验班级：<input type="hidden" id="show-btn"/>
    			</td>
    			<td>
    				<html:text property="bjxx.bjmc" styleClass="input" readonly="true"/>
    				<html:hidden property="bjxx.bjzj"/>
    				<html:hidden property="vo.ksszzt" value="0"/>
    				<img src="./images/button/export.jpg" border="0" style="cursor:hand;" onclick="getBjList(1);"/>
    			</td>
    		</tr>
    		<tr >
    			<td align="right">
    				使用试卷：
    			</td>
    			<td>
    				<html:text property="sjxx.sjmc" styleClass="input" readonly="true"/>
    				<html:hidden property="sjxx.sjzj"/>
    				<img src="./images/button/export.jpg" border="0" style="cursor:hand;" onclick="getSjList(1);"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    				<html:submit styleClass="inputbutton">设 置</html:submit>
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
