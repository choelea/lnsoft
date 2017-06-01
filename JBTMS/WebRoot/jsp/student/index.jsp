
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ include file="/init/dwrjs.jsp" %>
<html>
<head>
<title><bean:message key="system.title"></bean:message></title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ext-2.0.1/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/ext-2.0.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/ext-2.0.1/ext-all.js"></script>

<style type="text/css">
<!--
a {
	font-size: 12px;
	color: #333333;
}
a:visited {
	color: #333333;
	text-decoration: none;
}
a:hover {
	color: #006600;
	text-decoration: underline;
}
a:link {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

-->

body,td,th {
	font-family: 宋体;
	font-size: 12px;
}
.indextable{
	border-color:#CCCCCC;
	background-color: #ced7f7;
}
.indextable2{
	background-color: #ffffff;
}
.td1{
	
	 height:22px; 
	 font-size:12px;
	 background-color:#FFFfff; 
	 color:#000; 
	 padding-top:5px;
	 text-align: left;
}
.td3{
	
	 height:22px; 
	 font-size:12px;
	 background-color:#FFFfff; 
	 color:#000; 
	 padding-top:5px;
	 text-align: center;
}
.td2{
	 height:50px; 
	 font-size:12px;
	 background-color:#FFFfff; 
	 color:#000; 
	 padding-top:5px;
}
.input{	
	border-left: 0px solid;
	border-right: 0px solid;
	border-top: 0px solid;
	border-bottom: 1px solid
}
.inputxx{	
	border-left: 1px solid;
	border-right: 1px solid;
	border-top: 1px solid;
	border-bottom: 1px solid
}
.inputbutton {
	background-image: url(<%=request.getContextPath()%>/images/button2.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	background-color: #FFFFFF;
	color:#FFFFFF;
	cursor: hand;
}
.inputbutton1 {
	height: 16px;
	width: 21px;
	background-image: url(<%=request.getContextPath()%>/images/button/prev.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	background-color: #FFFFFF;
	cursor: hand;
}
.inputbutton2 {
	height: 16px;
	width: 21px;
	background-image: url(<%=request.getContextPath()%>/images/button/next.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	background-color: #FFFFFF;
	cursor: hand;
}
.inputbutton3 {
	height: 16px;
	width: 23px;
	background-image: url(<%=request.getContextPath()%>/images/button/first.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	background-color: #FFFFFF;
	cursor: hand;
}
.inputbutton4 {
	height: 16px;
	width: 24px;
	background-image: url(<%=request.getContextPath()%>/images/button/four.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	background-color: #FFFFFF;
	cursor: hand;
}
dl,dd,dt,ul,li{ margin:0; padding:0; list-style:none; color:#333;}
#wenzhang{ width:182px; text-align:center; font-size:12px;border-left:1px solid #dedede;border-right:1px solid #dedede; border-bottom:1px solid #dedede;}
#wenzhang  dd dl dt{ border-top:1px solid #dedede;  height:25px; line-height:25px; font-weight:bold; background-image:url(<%=request.getContextPath() %>/images/admin/dtbj.jpg);}
#wenzhang ul{ background:#f9f9f9; }
#wenzhang li{ border-top:1px solid #efefef; line-height:25px;}
-->
</style>
<script language="javascript" src="<%=request.getContextPath()%>/ext-2.0.1/examples/window/sjxx.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript">
	var curSta=false;
	function loginOut(){
		window.location.href="<%=request.getContextPath()%>/logout.jsp";
	}
	function subC(){
		var xszj = document.getElementById("xszj");
		var xsxm = document.getElementById("xsxm");
		var xsmm = document.getElementById("xsmm");
		var xsdh = document.getElementById("xsdh");
		var xsdz = document.getElementById("xsdz");
		var xsjg = document.getElementById("xsjg");
		var zjhm = document.getElementById("zjhm");
		var expNum = /^[0-9]+$/;
		var expChar = /^\w+$/;
		var expPhone = /^(\(){0,1}[0-9]{0,4}(\)){0,1}(-|\s){0,1}(\(){0,1}[0-9]{1,4}(\)){0,1}(-|\s){0,1}[0-9]{4}(-|\s){0,1}[0-9]{3,4}$/;
		if(!expNum.test(xszj.value.trim())){
			alert("学生信息有误!");
			return false;
		}
		if(xsxm.value==""){
			alert("请输入学生姓名!");
			return false;
		}
		if(xsmm.value==""){
			alert("请输入学生密码!");
			return false;
		}else if(!expChar.test(xsmm.value)){
			alert("学生密码输入有误!");
			return false;
		}
		if(xsdh.value!="" && !expPhone.test(xsdh.value)){
			alert("电话号码输入有误!");
			return false;
		}
		if(zjhm.value!="" && !expChar.test(zjhm.value)){
			alert("证件号码输入有误!(证件号码由字母和数组组成!)");
			return false;
		}
		var userxb = "";
		if(document.getElementsByName("xb")[0].checked){
			userxb= "男";
		}
		if(document.getElementsByName("xb")[1].checked){
			userxb="女";
		}
		var xsxx = {xszj:xszj.value,xsxm:xsxm.value,xsmm:xsmm.value,xsxb:userxb,dz:xsdz.value,jg:xsjg.value,dh:xsdh.value,zjhm:zjhm.value};
		UserDWR.updateXsxx(xsxx,function(data){
			var sfcg = document.getElementById("sfcg");
			if(data){
				sfcg.innerHTML="个人资料修改成功!";
			}else{
				sfcg.innerHTML="个人资料修改失败!";
			}
		});
	}
	function getUser(){
		var xszj = document.getElementById("xszj");
		UserDWR.getXsxx(xszj.value,function(data){
			document.getElementById("xsxm").value=data.xsxm==null?"":data.xsxm;
			document.getElementById("xsmm").value=data.xsmm==null?"":data.xsmm;
			document.getElementById("rxsj").value=data.rxsj==null?"":data.rxsj;
			document.getElementById("xsdz").value=data.dz==null?"":data.dz;
			document.getElementById("xsdh").value=data.dh==null?"":data.dh;
			document.getElementById("zjhm").value=data.zjhm==null?"":data.zjhm;
			document.getElementById("xsjg").value=data.jg==null?"":data.jg;
			if(data.xsxb!=null&&""!=data.xsxb){
				if(data.xsxb=="男"){
					document.getElementsByName("xb")[0].checked=true;
				}else if(data.xsxb=="女"){
					document.getElementsByName("xb")[1].checked=true;
				}
			}
		});
	}
	function ggC(){
    	 	UserDWR.getGgxxList(${userBjzj},1,cd1);
    	 }
    	 function ggzzPage(page){
    	 	UserDWR.getGgxxList(${userBjzj},page,cd1);
    	 }
    	 function cd1(data){
    	 	var ggxxList = data.pagedata;
    	 	var msgArr = new Array();
    	 	msgArr[0] = "公告标题";
    	 	msgArr[1] = "发 布 人";
    	 	msgArr[2] = "发布时间";
    	 	var ggDiv = document.getElementById("ggDiv");
    	 	ggDiv.innerHTML="";
    	 	var tabE = document.createElement("<table align='center' class='indextable' width='100%' border='0' cellpadding=\"0\" cellspacing=\"1\" border=\"0\" style=\"word-break:break-all;\">");
    	 	var tbodyE = document.createElement("tbody");
    	 	var theadE = document.createElement("tr");
    	 	for(var i =0;i<msgArr.length;i++){
    	 		var thE = document.createElement("<td class='td3' align='center'>");
    	 		var thTextNode = document.createTextNode(msgArr[i]);
    	 		thE.appendChild(thTextNode);
    	 		theadE.appendChild(thE);
    	 	}
    	 	tbodyE.appendChild(theadE);
    	 	for(var obj in ggxxList){
    	 		if(!isNaN(obj)){
    	 			var trE = document.createElement("tr");
    	 			var hanshu = "xxnr('"+ggxxList[obj].ggzj+"');";
    	 			var tdE1 = document.createElement("<td align='center' class='td3' onclick=\""+hanshu+"\" style='color: blue;cursor:hand;'>");
    	 			var tdE2 = document.createElement("<td align='center' class='td3'>");
    	 			var tdE3 = document.createElement("<td align='center' class='td3'>");
    	 			var tdNode1 = document.createTextNode(ggxxList[obj].ggbt);
    	 			var tdNode2 = document.createTextNode(ggxxList[obj].ggzz);
    	 			var tdNode3 = document.createTextNode(ggxxList[obj].fbsj);
    	 			tdE1.appendChild(tdNode1);
    	 			tdE1.setAttribute("title",ggxxList[obj].ggnr);
    	 			tdE2.appendChild(tdNode2);
    	 			tdE3.appendChild(tdNode3);
    	 			trE.appendChild(tdE1);
    	 			trE.appendChild(tdE2);
    	 			trE.appendChild(tdE3);
    	 			tbodyE.appendChild(trE);
    	 		}    	 		
    	 	}
    	 	if(ggxxList.length==0){
  				var trE = document.createElement("tr");
  				var tdE = document.createElement("<td align='center'colspan='3' class='td3'>");
  				var tdNode = document.createTextNode("暂无公告信息！");
  				tdE.appendChild(tdNode);
  				trE.appendChild(tdE);
  				tbodyE.appendChild(trE);
   			}    	 	
    	 	tabE.appendChild(tbodyE);
    	 	ggDiv.appendChild(tabE);
    	 	//分页信息
    	 	var pageTab = document.createElement("<table width=\"100%\" class='indextable2'  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
    	 	var pageTbody=document.createElement("tbody");
    		var pageTr = document.createElement("tr");
			var pageTd = document.createElement("<td align='right'>");
			var msg = "共 ["+data.allpage+"] 页 当前第 ["+data.curpage+"] 页 每页 ["+data.pagerecord+"] 条记录 ";
			var pageTextNode = document.createTextNode(msg);
			pageTd.appendChild(pageTextNode);
			var fb = document.createElement("<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\"ggzzPage(1);\">");
			var pb = document.createElement("<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\"ggzzPage("+data.previouspage+");\"/>");
			var nb = document.createElement("<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\"ggzzPage("+data.nextpage+");\"/>");
			var lb = document.createElement("<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\"ggzzPage("+data.allpage+");\"/>");
			pageTd.appendChild(fb);
			pageTd.appendChild(pb);
			pageTd.appendChild(nb);
			pageTd.appendChild(lb);
			pageTr.appendChild(pageTd);
			pageTbody.appendChild(pageTr);
			pageTab.appendChild(pageTbody);
    		ggDiv.appendChild(pageTab);
    	 }
    	 function xxnr(ggzj){
    	 	UserDWR.getFbGgxx(ggzj,xxnrcd);
    	 }
    	 function xxnrcd(data){
    	 	var ggDiv = document.getElementById("ggDiv");
    	 	ggDiv.innerHTML="";
    	 	var tabE = document.createElement("<table align='center' class='indextable' width='99%' border='0' cellpadding=\"0\" cellspacing=\"1\" border=\"0\" style=\"word-break:break-all;\">");
    	 	var tr1 = document.createElement("<tr height='30' class='td1'>");
    	 	var tdbt = document.createElement("<td width='100' class='td3'>");
    	 	var xxbt  = document.createTextNode("标　　题");
    	 	tdbt.appendChild(xxbt);
    	 	tr1.appendChild(tdbt); 
    	 	var tdbtnr = document.createElement("<td class='td1'>");
    	 	var inpbt = document.createElement("<input type='text' class='input' readonly='readonly'>");
    	 	inpbt.setAttribute("value",data[0]);
    	 	tdbtnr.appendChild(inpbt);
    	 	tr1.appendChild(tdbtnr);
    	 	var tr2 = document.createElement("<tr height='30' class='td3'>");
    	 	var tdsj = document.createElement("<td>");
    	 	var sjbt = document.createTextNode("发布时间");
    	 	tdsj.appendChild(sjbt);
    	 	tr2.appendChild(tdsj);
    	 	var tdsjnr = document.createElement("<td class='td1'>");
    	 	var inpsj = document.createElement("<input type='text' class='input' readonly='readonly'>");
    	 	inpsj.setAttribute("value",data[1]);
    	 	tdsjnr.appendChild(inpsj);
    	 	tr2.appendChild(tdsjnr);
    	 	var tr3 = document.createElement("<tr class='td3'>");
    	 	var tdxxnr = document.createElement("<td class='td3'>");
    	 	var nrbtxx = document.createTextNode("公告内容");
    	 	tdxxnr.appendChild(nrbtxx);
    	 	tr3.appendChild(tdxxnr);
    	 	var tdggnr = document.createElement("<td class='td1'>");
    	 	var textear = document.createElement("<textarea rows='11' cols='48' readonly='readonly'>");
    	 	var ggnrxx = document.createTextNode(data[2]);
    	 	textear.appendChild(ggnrxx);
    	 	tdggnr.appendChild(textear);
    	 	tr3.appendChild(tdggnr);
    	 	var tr4 = document.createElement("tr");
    	 	var tdlast=document.createElement("<td colspan='2' class='td3' align='center'>");
    	 	var fh = document.createElement("<input type='button' value='返 回' onclick='ggC()' class='inputbutton'>");
    	 	tdlast.appendChild(fh);
    	 	tr4.appendChild(tdlast);
    	 	tabE.appendChild(tr1);
    	 	tabE.appendChild(tr2);
    	 	tabE.appendChild(tr3);
    	 	tabE.appendChild(tr4);
    	 	ggDiv.innerHTML=tabE.outerHTML;
    	 }
    	 function helpMsg(msg){
			window.open("<%=request.getContextPath()%>/help/"+msg+".html","Help","menubar=no,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=no");
		}
		function Toback(){
			window.location.href="<%=request.getContextPath()%>/logout.jsp";
		}
		function window.onload(){
			if(${curGwzj==1}){
				window.mainFrame.location.href="<%=request.getContextPath()%>/bmxx.do?method=objList&rmMsg=true";
			}else if(${curGwzj==2}){
				window.mainFrame.location.href="<%=request.getContextPath()%>/khdd.do?method=getList&page=1&rmMsg=true";
			}else if(${curGwzj==3}){
				window.mainFrame.location.href="<%=request.getContextPath()%>/crkdd.do?method=objList&rmMsg=true";
			}else if(${curGwzj==4}){
				window.mainFrame.location.href="<%=request.getContextPath()%>/cczx.do?method=getJsList&rmMsg=true";
			}else if(${curGwzj==5}){
				window.mainFrame.location.href="<%=request.getContextPath()%>/zdgl.do?method=objList&rmMsg=true";
			}
		}
		function changeBackground(id,rule){
			UserDWR.changeSystemMode(rule,function (data){
				if(!data){					
					alert("您不具备此模块操作权限!");
					return false;
				}
			});			
		}
		var obj = null;
		jQuery(
		function($){
			
	       $("#wenzhang>dd>dl>dd").hide();
	     	$.each($("#wenzhang>dd>dl>dt"), function(){
			$(this).click(function(){
				obj=this;
				UserDWR.changeSystemMode($(this).find("span").eq(0).text(),function (data){
				if(!data){					
					alert("您不具备此模块操作权限!");
					return false;
				}else{
					$("#wenzhang>dd>dl>dd ").not($(this).next()).hide();
					if($(obj).next().is(":hidden")){
						$(obj).next().show();
					}else{
						$(obj).next().hide();
					} 

					
					//$(this).next().toggle();
				}
				});	
				
			});
			});
		$("dl").find("a").click(function(){
				$("#xtwz").html($(this).text());
		});
	  });
	  function setTimeDisplay(){
			var date = new Date();
			var msg = date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			document.getElementById("timeSpan").innerHTML=msg;
			window.setTimeout(setTimeDisplay,1000);
	}
	window.setTimeout(setTimeDisplay,1000);
</script>
</head>
<body bgcolor="#e0edf6" style="text-align: center;">
  <div id="gg-win" class="x-hidden">
	    <div id="gg-tabs">
  			<div id="ggDiv" style="background-color:white; width:100%; height:320px;" ></div>
  		</div>
  </div>
  <div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
	    	<div id="sjDiv"></div>
	    </div>
	</div>
  <div id="hello-wgrzl" class="x-hidden">
  	<div id="hello-tgrzl">
 	 <div id="disStu" style="background-color:white; width:100%; height:390px;">
  		<table width="85%" height="160" align="center" class="indextable" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr>
    			<td colspan="2" class="td3" align="center" valign="middle"><span style="font-size:16px;font-weight: 900">个人资料信息</span>
    			</td>
    		</tr>
    		<tr>
    			<td width="25%" align="right" class="td3">学　　号：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="xsxh" class="input"  id="xsxh" value="${userName }" readonly="readonly"/>
    				<input type="hidden" name="xszj" value="${userStuPk}" id="xszj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">学生姓名：&nbsp;&nbsp;</td>
    			<td class="td1"><input type="text" id="xsxm" class="input"  value="${userTName }"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">登陆密码：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="xsmm" id="xsmm" class="input"  value="${userPaw}"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">性　　别：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="radio" name="xb" value="男"/>男 
    				<input type="radio" name="xb" value="女"/>女
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">入学时间：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="rxsj" id="rxsj" class="input" readonly="readonly" />
    			</td>
    		</tr>    		
    		<tr>
    			<td align="right" class="td3">地　　址：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="xsdz" id="xsdz" class="input"  />
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">电　　话：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="xsdh" id="xsdh" class="input"  />
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">证件号码：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="zjhm" id="zjhm" class="input"  />
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td3">籍　　贯：&nbsp;&nbsp;</td>
    			<td class="td1">
    				<input type="text" name="xsjg" id="xsjg" class="input"  />
    			</td>
    		</tr>
    		<tr>
    			<td align="center"  class="td3" colspan="2" >
    			<input type="button" name="cz" value="修 改" onClick="subC()" class="inputbutton" />
    			</td>
    		</tr>
    		<tr>
    			<td align="center"  class="td3" colspan="2" >
    			<span id="sfcg" style="color:red;"></span>
    			</td>
    		</tr>
    	</table> 
  	</div>
  </div>
  </div>
<table id="__01" width="1002" height="613" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="8" background="<%=request.getContextPath()%>/images/admin/student_01.jpg" width="1002" height="47" align="right">
			<table style="font-size:12px">
            	<tr>
            	<td align="right"><img src="<%=request.getContextPath()%>/images/20050129171645978.gif" width="26" height="23"/> </td> 
                <td align="left"><a href="#" class="b" id="showgrzl" onclick="getUser();">资料修改</a>&nbsp;&nbsp;<td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/20050129172033262.gif" width="18" height="15"/> </td> 
                <td align="left"><a href="#" class="b" id="showggxx" onClick="ggC();">班级公告</a>&nbsp;&nbsp;<td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/bz.gif"/> </td> 
                <td align="left"><a href="javascript:helpMsg('xsbz');" class="b">系统帮助</a>&nbsp;&nbsp;<td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/sx.gif"/> </td> 
                <td align="left"><a href="javascript:helpMsg('sxzds');" class="b">实训指导</a>&nbsp;&nbsp;<td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/tc.gif"/> </td> 
                <td align="left"><a href="<%=request.getContextPath() %>/logout.jsp" class="b">退出系统</a></td> 
                 <td>&nbsp;&nbsp;</td> 
                </tr>
            </table>
          </td>
	</tr>
	<tr>
		<td colspan="8">
			<img src="<%=request.getContextPath()%>/images/admin/student_02.jpg" width="1002" height="21" alt=""></td>
	</tr>
	<tr>
		<td colspan="5" rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_03.jpg" width="365" height="31" alt=""></td>
		<td background="<%=request.getContextPath()%>/images/admin/student_04.jpg"width="573" height="23"  style="font-size:12px">
			<table width="573" height="22" style="font-size:12px">
			<tr>
			<td align="left" style="color: black;">欢迎您:${userTName}</td>
			<td align="right" style="color: black;">现在时间：<span id="timeSpan"></span></td>
			</tr>
			</table></td>
		<td colspan="2" rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_05.jpg" width="64" height="31" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_06.jpg" width="573" height="8" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="<%=request.getContextPath()%>/images/admin/student_07.jpg" width="233" height="28" alt=""></td>
		<td colspan="3" align="left" background="<%=request.getContextPath()%>/images/admin/student_08.jpg" width="764" height="28"  style="font-size:12px;color: black;">
			<span id="xtwz"></span></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_09.jpg" width="5" height="28" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="<%=request.getContextPath()%>/images/admin/student_10.jpg" width="200" height="8" alt=""></td>
		<td colspan="4" rowspan="2" width="797" height="439">
		 <iframe src="#" width="100%" height="100%" frameborder="0" name="mainFrame" scrolling="yes"></iframe>
			</td>
		<td rowspan="3">
			<img src="<%=request.getContextPath()%>/images/admin/student_12.jpg" width="5" height="463" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_13.jpg" width="6" height="455" alt=""></td>
		<td background="<%=request.getContextPath()%>/images/admin/student_14.jpg" width="185" height="431" valign="top">
			<dl id="wenzhang">
        <dd>
        <dl>
           <dt>资源管理<span style="display: none">1</span></dt>
           <dd>
             <ul>
                <li><a href="<%=request.getContextPath()%>/bmxx.do?method=objList&rmMsg=true" target="mainFrame">部门管理</a></li>
                 <li><a href="<%=request.getContextPath()%>/yggl.do?method=getList&rmMsg=true" target="mainFrame">员工管理</a></li>
                 <li><a href="<%=request.getContextPath()%>/bxgl.do?method=getList&rmMsg=true" target="mainFrame">班线管理</a></li>
                 <li><a href="<%=request.getContextPath()%>/clgl.do?method=getList&rmMsg=true" target="mainFrame">车辆管理</a></li>
                 <li><a href="<%=request.getContextPath()%>/sbwxjl.do?method=objList&rmMsg=true" target="mainFrame">设备维修</a></li>
             </ul>
           </dd>
        </dl>
        </dd>
        <dd>
        <dl>
          <dt>客户管理<span style="display: none">1</span></dt>
           <dd>
              <ul>
               <li><a href="<%=request.getContextPath()%>/khxx.do?method=getList&page=1&rmMsg=true" target="mainFrame">客户信息</a></li>
                 <li><a href="<%=request.getContextPath()%>/hzgxxx.do?method=getList&page=1&rmMsg=true" target="mainFrame">申请合作</a></li>
                 <li><a href="<%=request.getContextPath()%>/htxx.do?method=getList&page=1&rmMsg=true" target="mainFrame">客户合同</a></li>
              </ul>
           </dd>
        </dl>
        </dd> 
         <dl>
          <dt>订单管理<span style="display: none">2</span></dt>
           <dd>
              <ul>
               <li><a href="<%=request.getContextPath()%>/khdd.do?method=getList&page=1&rmMsg=true" target="mainFrame">客户订单</a></li>
	                  <li><a href="<%=request.getContextPath()%>/send.do?method=getList&rmMsg=true&address=trans" target="mainFrame">运输订单</a></li>
              </ul>
           </dd>
        </dl>
		<dl>
          <dt>调度中心<span style="display: none">3</span></dt>
           <dd>
              <ul>
               <li><a href="<%=request.getContextPath()%>/send.do?method=objList1&rmMsg=true&address=trans" target="mainFrame">订单分拣</a></li>
	                  <li><a href="<%=request.getContextPath()%>/ddfj.do?method=getList&rmMsg=true&address=trans" target="mainFrame">订单调度</a></li>
              </ul>
           </dd>
        </dl>	
		<dl>
          <dt>运输作业<span style="display: none">4</span></dt>
           <dd>
              <ul>
                <li><a href="<%=request.getContextPath()%>/ysps.do?method=getList&address=feiyong&rmMsg=true" target="mainFrame">费用调整</a></li>
	                  <li><a href="<%=request.getContextPath()%>/pgpc.do?method=getList&rmMsg=true" target="mainFrame">派工派车</a></li>
	                  <li><a href="<%=request.getContextPath()%>/pgpc.do?method=getZcList&rmMsg=true" target="mainFrame">装车</a></li>
	                  <li><a href="<%=request.getContextPath()%>/pgpc.do?method=getFcList&rmMsg=true" target="mainFrame">发运</a></li>
	                  <li><a href="<%=request.getContextPath()%>/ysps.do?method=getList&rmMsg=true" target="mainFrame">签收</a></li>
	                  <li><a href="<%=request.getContextPath()%>/ydcx.do?method=getList&rmMsg=true" target="mainFrame">运单查询</a></li>
              </ul>
           </dd>
        </dl>	
        <dl>
          <dt>客服中心<span style="display: none">6</span></dt>
           <dd>
              <ul>
                <li><a href="<%=request.getContextPath()%>/send.do?method=objList&rmMsg=true&address=trans" target="mainFrame">订单查询</a></li>
	                  <li><a href="<%=request.getContextPath()%>/khfk.do?method=getList&rmMsg=true" target="mainFrame">客户返单</a></li>
	                  <li><a href="<%=request.getContextPath()%>/khts.do?method=getList&rmMsg=true" target="mainFrame">客户投诉</a></li>
	                  <li><a href="<%=request.getContextPath()%>/khth.do?method=getList&rmMsg=true" target="mainFrame">客户退货</a></li>
              </ul>
           </dd>
        </dl>		
		<dl>
          <dt>财务管理<span style="display: none">5</span></dt>
           <dd>
              <ul>
                <li><a href="<%=request.getContextPath()%>/zdgl.do?method=objList&rmMsg=true" target="mainFrame">账单管理</a></li>
	                  <li><a href="<%=request.getContextPath()%>/cwtj.do?method=ysLrCwtj&kind=ps" target="mainFrame">收入统计</a></li>
	                  <li><a href="<%=request.getContextPath()%>/cwtj.do?method=ysCbCwtj&kind=ps" target="mainFrame">成本统计</a></li>
	                   <li><a href="<%=request.getContextPath()%>/cwtj.do?method=ysJlrCwtj&kind=ps" target="mainFrame">利润统计</a></li>
              </ul>
           </dd>
        </dl>		
		 <dl>
          <dt> <a href="<%=request.getContextPath()%>/djxxExam.do?m=objList&rmMsg=true" target="mainFrame">在线考试</a><span style="display: none">5</span></dt>
           
        </dl>
			</td>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_15.jpg" width="9" height="455" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_16.jpg" width="185" height="24" alt=""></td>
		<td colspan="4">
			<img src="<%=request.getContextPath()%>/images/admin/student_17.jpg" width="797" height="24" alt=""></td>
	</tr>
	<tr>
		<td colspan="8" background="<%=request.getContextPath()%>/images/admin/student_18.jpg" width="1002" height="22" align="center">
			<span style="font-size:12px">&copy;版权所有：武汉骏邦信息科技有限公司</span></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="6" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="185" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="9" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="33" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="132" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="573" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="59" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="5" height="1" alt=""></td>
	</tr>
</table>
</body>
</html>