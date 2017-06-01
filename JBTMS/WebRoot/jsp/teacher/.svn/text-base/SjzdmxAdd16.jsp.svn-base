<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">
    	function IsNull(){
    		var sjzdmxbh = document.all("vo.sjzdmxbh");
    		var sjzdmxmc = document.all("vo.sjzdmxmc");
    		var expNum = /^\w+$/;
    		if(!expNum.test(sjzdmxbh.value)){
    			alert("站点编号输入有误!");
    			return false;
    		}
    		if(sjzdmxmc.value==""){
    			alert("请输入站点信息!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./sjzdmx.do?method=sjzdmxList&page=1&sjzd.sjzdzj=${objPk}&vo.fqzj=${fqPk}";
    	}
    	function valiValue(o,f){
    		if(o.value!=""){
    			var hql = "from Sjzdmx A where A."+f+" = '"+o.value+"' and A.sjzd.sjzdzj = ${objPk}";
    			UserDWR.isExit(hql,null,function cd(data){
    				var field = document.getElementById(f);
    				if(data)						
    					field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
    				else
    					field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
    			});
    		}
    	}
    	function sjzdPage(curpage){
    		getPageinfo(curpage,0);
    		document.getElementById("show-btn").click();
    	}
    	function getPageinfo(curpage,fqzj){
    		var countHql = "select count(A) from Sjzdmx A where A.sjzd.sjzdzj = 15 and A.fqzj="+fqzj;
    		var hql = "from Sjzdmx A where A.sjzd.sjzdzj = 15 and A.fqzj="+fqzj;
    		UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
    			var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择</td><td>区域编号</td><td>区域名称</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].sjzdmxzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].sjzdmxmc+"\">"+
								"</td><td><a href=\"javascript:getPageinfo(1,"+list[obj].sjzdmxzj+");\">"+list[obj].sjzdmxbh+"</a></td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无参数信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"getPageinfo",fqzj);	    		
	    		if(fqzj!=0){
	    			msg+="<p align=\"center\"><input type=\"button\" class=\"inputbutton\" value=\"返 回\" onclick=\"getPageinfo(1,0);\"/></p>";
	    		}
	    		div1.innerHTML=msg;
    		});
    	}
    	function pageMsg(data,fn,fqzj){
    		var msg = "";
    		msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,"+fqzj+");\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+","+fqzj+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+","+fqzj+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+","+fqzj+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
    	}
    	function setValue(){
    		var paramPks = document.getElementsByName("paramPk");
    		var paramValues = document.getElementsByName("paramValue");
    		for(var i=0;i<paramPks.length;i++){
    			if(paramPks[i].checked){
    				var field1 = document.all("vo.field1");
    				field1.value=paramValues[i].value;
    				break;
    			}
    		}
    	}
    </script> 
  </head>
  
  <body>
    <html:form action="/sjzdmx.do?method=addObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>站点管理</center></caption>
    		<tr>
    			<td width="40%" align="right">站点编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.sjzdmxbh" styleClass="input" onblur="valiValue(this,'sjzdmxbh');"/>
    				<span id="sjzdmxbh"></span>
    				<html:hidden property="sjzd.sjzdzj" value="${objPk }"/>
    				<html:hidden property="vo.fqzj" value="0"/>
    				<html:hidden property="vo.kfcz" value="1"/>
    				<input type="hidden" id="show-btn"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">站点名称&nbsp;&nbsp;</td>
    			<td><html:text property="vo.sjzdmxmc" styleClass="input" onblur="valiValue(this,'sjzdmxmc');"/>
    				<span id="sjzdmxmc"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">所属地区&nbsp;&nbsp;</td>
    			<td><html:text property="vo.field1" styleClass="input" readonly="true"/>
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="sjzdPage(1);"/>
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
           
            </div>
    	</div>
	</div>    
  </body>
</html>
