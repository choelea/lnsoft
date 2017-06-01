<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
<head>
<title><bean:message key="system.title"/></title>
<script type="text/javascript">
	var m =${fn:length(list)};
	function $(tag){
		return document.getElementById(tag);
	}
	function isNull(){
		var bxbh = $("vo.bxbh");
		var qszd = $("vo.sfz");
		var mdzd = $("vo.mdz");
		var tccx = document.getElementsByName("tdcx");
		var tcdq = document.getElementsByName("diqu");
		if(bxbh.value==""){
			alert("班线编号不能为空!");
			return false;
		}
		if(qszd.value==""){
			alert("起始站点不能为空!");
			return false;
		}
		if(mdzd.value==""){
			alert("目的站点不能为空!");
			return false;
		}
		/*if(qszd.value==mdzd.value){
			alert("起点和终点不能重复!");
			return false;
		}*/
		for(var i=0;i<tcdq.length;i++){
			for(var n=0;n<tcdq.length;n++){
				if(tcdq[i].value==""){
					alert("地区不能为空!");
					return false;
				}else if(tcdq[i].value==qszd.value || tcdq[i].value==mdzd.value){
					alert("中转站不能和起点或终点重复!");
					return false;
				}
				if(i!=n){
					if(tcdq[i].value==tcdq[n].value){
						alert("地区不能重复!");
						return false;
					}
				}
			}
		}
		for(var j=0;j<tccx.length;j++){
			for(var k=0;k<tccx.length;k++){
				if(tccx[j].value==""){
					alert("停车次序不能为空!");
					return false;
				}else if(isNaN(tccx[j].value)){
					alert("停车次序应为数字!");
					return false;
				}
				if(j!=k){
					if(tccx[j].value==tccx[k].value){
						alert("停车次序不能相等!");
						return false;
					}
				}
			}
		}
		return true;
	}
	function back(){
		window.location.href="<%=request.getContextPath()%>/bxgl.do?method=getList";
	}
	function toCheck(temp){
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
	function setValue(){
		var infokind = document.all("sel").value;
		if("qszd"==infokind){
			var pk = document.getElementsByName("pk");
			var zdmc = document.getElementsByName("psh");
			var cllx = $("vo.sfz");
			var i = toCheck(pk);
			if(i != -1){
				cllx.value = zdmc[i].value;
			}
		}
		if("mdzd"==infokind){
			var pk = document.getElementsByName("pk");
			var zdmc = document.getElementsByName("psh");
			var clzt = $("vo.mdz");
			var i = toCheck(pk);
			if(i != -1){
				clzt.value = zdmc[i].value;
			}
		}
		if("zhuan"==infokind){
			var pk = document.getElementsByName("pk");
			var zdmc = document.getElementsByName("psh");
			var x = $("se").value;
			var clzt = document.all(x);
			var i = toCheck(pk);
			if(i != -1){
				clzt.value = zdmc[i].value;
			}
		}
	}
	function removePut(obj){
		var tab = $("zhongzhuan");
		var tbody = tab.lastChild;
		var etr = obj.parentNode.parentNode;
		tbody.removeChild(etr);
	}
	function inserPut(){
		var tab = $("zhongzhuan");
		var tbody = tab.lastChild;
		var etr = document.createElement("<tr>");
		var etd1 = document.createElement("<td align='center' width='40%'>");
		var etd2 = document.createElement("<td align='center' width='40%'>");
		var etd3 = document.createElement("<td align='center' width='20%'>");
		var eput1 = document.createElement("<input type='text' id="+m+" name='diqu' class='input' readonly='true' onclick='getParamterB(1,\"zhuan\",this);'>");
		var ehidd = document.createElement("<input type='hidden' name='fl' value="+m+">");
		var eput2 = document.createElement("<input type='text' name='tdcx' class='input'>");
		var eput3 = document.createElement("<img src='<%=request.getContextPath()%>/images/button/del1.bmp' alt='点击删除' style='cursor:hand;' onclick='removePut(this);'>");
		etd1.appendChild(eput1);
		etd1.appendChild(ehidd);
		etd2.appendChild(eput2);
		etd3.appendChild(eput3);
		etr.appendChild(etd1);
		etr.appendChild(etd2);
		etr.appendChild(etd3);
		tbody.appendChild(etr);
		m++;
	}
	function getParamterA(curpage,zdlx){
		clickbtn();
		$("sel").value=zdlx;
		var countHql = "select count(*) from Sjzdmx where 1=1 and sjzdzj = ?";
		var hql = " from Sjzdmx where 1=1 and sjzdzj = ?";
		UserDWR.getPageinfo(countHql, hql, curpage,10, 16,cda);
	}
	function getParamterB(curpage,zdlx,obj){
		clickbtn();
		$("sel").value=zdlx;
		var countHql = "select count(*) from Sjzdmx where 1=1 and sjzdzj = ?";
		var hql = " from Sjzdmx where 1=1 and sjzdzj = ?";
		UserDWR.getPageinfo(countHql, hql, curpage,10, 16,cda);
		var etr = obj.parentNode.parentNode;
		var eput = etr.firstChild.lastChild;
		while(eput.nodeType!=1){
			eput = eput.previousSibling;
		}
		$("se").value=eput.value;
	}
	function getParamter(curpage){
		var countHql = "select count(*) from Sjzdmx where 1=1 and sjzdzj = ?";
		var hql = " from Sjzdmx where 1=1 and sjzdzj = ?";
		UserDWR.getPageinfo(countHql, hql, curpage,10, 16,cda);
	}
	function cda(data){
		var list = data.pagedata;				
		var infoview = $("infoview");
		var msg ="<table align='center' width='100%' border='0' cellpadding='0' cellspacing='1' style='word-break:break-all;'>"+
		"<tr align='center' height='30'><td width='10%'>选择<input type='hidden'name='infokind' value='cllx'/></td><td width='30%'>国家名称</td><td width='30%'>地区名称</td></tr>";
		for(var obj in list){
			if(!isNaN(obj)){
				msg = msg+"<tr align='center' height='20'><td>"+
				"<input type='radio' name='pk' value="+obj+">"+
				"<input type='hidden' name='psh' value="+list[obj].sjzdmxmc+">"+
				"</td><td>"+list[obj].sjzdmxmc+"</td><td>"+list[obj].field1+"</td></tr>"
			}
		}
		if(list.length==0){
  				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无地区信息</td></tr>";
   		}
   		msg = msg + "</table>";
   		msg = msg + pageMsg(data,"getParamter");
   		infoview.innerHTML=msg;
	}
	function clickbtn(){
		$("show-btn").click();
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
	function check(bxlx){
		var t = $("etd");
		var tab = $("zhongzhuan");
		if(bxlx==2&&tab){
			t.removeChild(tab);
		}else {
			if(tab){
				t.removeChild(tab);
			}
			vtab = document.createElement("<table id='zhongzhuan' width='100%' border='0' cellspacing='1' cellpadding='0'>");
			r = vtab.insertRow();
			c = document.createElement("<td align='center' colspan='3'>");
			c.innerHTML = "添加中转站<img src='<%=request.getContextPath()%>/images/button/openwin.jpg' alt='点击选择' style='cursor:hand;'  onclick='inserPut();'/>";
			r.appendChild(c);
			r = vtab.insertRow();
			c = r.insertCell();
			c.setAttribute("align","center");
			c.innerHTML = "地区名称";
			c = r.insertCell();
			c.setAttribute("align","center");
			c.innerHTML = "停车次序";
			c = r.insertCell();
			c.setAttribute("align","center");
			c.innerHTML = "操 作";
			t.appendChild(vtab);
		}
	}
</script>
  </head>
  <body>
  	<html:form action="/bxgl.do?method=update" method="post" onsubmit="return isNull();">
  		<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
  			<caption><center>班线修改</center></caption>
  			<tr>
  				<td align="right">班线编号&nbsp;&nbsp;</td>
  				<td colspan="3">
  					<html:text property="vo.bxbh" styleClass="input" readonly="true"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right" width="25%">起始站点<font color="red">*</font></td>
  				<td width="25%">
  					<html:text property="vo.sfz" styleClass="input" readonly="true"/>
  					<img name="qszd" src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="getParamterA(1,this.name);"/>
  						<input type="hidden" name="sel">
  				</td>
  				<td align="right" width="20%">目的站点<font color="red">*</font></td>
  				<td >
  					<html:text property="vo.mdz" styleClass="input" readonly="true"/>
  					<img name="mdzd" src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
  									style="cursor:hand;"  onclick="getParamterA(1,this.name);"/>
  				</td>
  			</tr>
  			<tr>
  				<td align="right">班线描述&nbsp;&nbsp;</td>
  				<td colspan="3">
  					<html:textarea property="vo.bxms" cols="50" rows="5"></html:textarea>
  				</td>
  			</tr>
  			<tr>
  				<td align="center" colspan="4" id="etd">
  					<c:if test="${bxlx!=2 }">
  						<table id="zhongzhuan" align="center" width="100%" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
	  						<tr>
	  							<td align="center" colspan="3">添加中转站
	  								<img src="<%=request.getContextPath()%>/images/button/export.jpg" alt="点击选择" 
	  									style="cursor:hand;"  onclick="inserPut();"/></td>
	  						</tr>
	  						<tr>
	  							<td align="center">地区名称</td>
	  							<td align="center">停车顺序</td>
	  							<td align="center">操 作</td>
	  						</tr>
	  						<c:forEach var="obj" items="${list }" varStatus="i">
	  							<tr>
	  								<td align="center" width="40%">
	  									<input type="text" id="${i.index }" name="diqu" value="${obj.bxzd }" onclick="getParamterB(1,'zhuan',this);" class="input" readonly="readonly">
	  									<input type="hidden" name="fl" value="${i.index }"/>
	  									</td>
		  							<td align="center" width="40%"><input type="text" name="tdcx" value="${obj.tksx }" class="input"></td>
	  								<td align="center"><img src="<%=request.getContextPath()%>/images/button/del1.bmp" alt="点击删除" style="cursor:hand;" onclick="removePut(this);"></td>
	  							</tr>
	  						</c:forEach>
	  					</table>
  					</c:if>
  				</td>
  			</tr>
  			<tr>
  				<td colspan="4" align="center">
  					<html:submit value="修 改" styleClass="inputbutton"></html:submit>
  					<input type="button" value="返 回" onclick="back();" class="inputbutton">
  					<html:hidden property="vo.sssysz"/>
  					<html:hidden property="vo.ssxs" />
  					<html:hidden property="vo.bxzj"/>
  					<input type="hidden" name="show-btn">
  					<input type="hidden" name="se">
  				</td>
  			</tr>
  		</table>
  	</html:form>
  	<div id="hello-win" class="x-hidden">
		<div id="hello-tabs">
			<div class="tanchuang" id="infoview"></div>
		</div>
	</div>
  </body>
</html>