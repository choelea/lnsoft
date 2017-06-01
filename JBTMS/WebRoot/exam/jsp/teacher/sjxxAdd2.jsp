<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<%@ taglib prefix="cn" uri="/NumCn"%>
<%@ taglib uri="/WEB-INF/tlds/ReplaceImgs.tld" prefix="imgs" %> 
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	var stTy = "";
    	var bsuf = 0;
    	var esuf = 0;
    	function IsNull(suffix){    		
    		var expNum = /^[0-9]+$/;
    		var arr = new Array();
    		for(var i=0;i<suffix;i++){
    			var stmc = document.all("ktlist["+i+"].stmc");
    			var stzj = document.all("ktlist["+i+"].stzj");
    			if(stmc==null || stzj==null){
    				continue;
    			}
    			if(!expNum.test(stzj.value) || stmc.value==""){
    				alert("请输入试题信息!");
    				return false;
    			}
    			arr[i]=stzj.value;
    		}
    		for(var i=0;i<arr.length-1;i++){
    			for(var j=i+1;j<arr.length;j++){
    				if(arr[i]==arr[j]){
    					alert("请删除重复的试题信息!");
    					return false;
    				}
    			}
    		}
    		return true;
    	}
    	function clearValue(obj){
    		var inputs = obj.getElementsByTagName("input");
    		for(var i=0;i<inputs.length;i++){
    			inputs[i].value="";
    		}
    	}
    	function back(){
    		window.location.href="./sjxxExam.do?m=objList&page=1";
    	}
    	function getStglList(stType,beginSuf,endSuf){
    		if(stType!=""){
    			stTy = stType;
    			bsuf = beginSuf;
    			esuf = endSuf;
	    		stPageinfo(1);	    		
    		}    		
    	}
    	function stPageinfo(curpage){
    	    var filterStr=""; 
    	    var strs="";
    		var hql=" and A.stlx = '"+stTy+"'";
    		ExamDWR.stPageinfo(hql,curpage,function(data){
    			var list = data.pagedata;	
    			var div1 = document.getElementById("div1");
    			var msg = "<table id=\"dataListTab\" border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td width='50'>全选<input type='checkbox' name='selPk' onClick='selAll();'/></td><td>题目名称</td></tr>";
    			for(var obj in list){
    			if(!isNaN(obj)){
    			        filterStr=html2txt(list[obj].stmc,true);
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"checkbox\" name=\"paramPk\" value=\""+list[obj].stzj+"\" />"+
							  "<input type=\"hidden\" name=\"paramValue\" value=\""+filterStr+"\">"+
							  "</td><td align='left'>"+filterStr+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无试题信息</td></tr>";
	    		}
    			div1.innerHTML=msg+pageMsg(data,"stPageinfo");
    			document.getElementById("show-btn").click();
    		})
    	}    
    	function setValue(){
    		var paramPks = document.getElementsByName("paramPk");
    		var paramValues = document.getElementsByName("paramValue");
    		for(var i=0;i<paramPks.length;i++){
    			if(paramPks[i].checked){
    				for(var j=bsuf;j<esuf;j++){
    					var stmc = document.all("ktlist["+j+"].stmc");
    					var stzj = document.all("ktlist["+j+"].stzj");
    					if(stzj!=null&&stmc!=null&&stzj.value==""&&stmc.value==""){
    						stzj.value=paramPks[i].value;
    						stmc.value=paramValues[i].value;
    						break;
    					}
    				}
    			}
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
    	function selAll(){ 
			var o=document.getElementsByName("paramPk"); 
			for(i=0;i<o.length;i++) {
				if(!o[i].disabled){
				    o[i].checked=event.srcElement.checked; 
				}
			}
		}
			function html2txt(str,noEnter){
			var html = str;
			html = html.replace(/<!--[\s\S]*?-->/img, "");//注释
			html = html.replace(/<[\/]*table[^>]*>/img, "\n");//table
			html = html.replace(/<[\/]*tbody[^>]*>/img, "");//tbody
			html = html.replace(/<[\/]*tr[^>]*>/img, "\n");//tr
			html = html.replace(/<[\/]*td[^>]*>/img, "\n");//td
			html = html.replace(/<[\/]*p[^>]*>/img, "\n");//p
			html = html.replace(/<[\/]*a[^>]*>/img, "\n");//a
			html = html.replace(/<[\/]*col[^>]*>/img, "\n");//col
			html = html.replace(/<[\/]*br[^>]*>/img, "\n");//br
			html = html.replace(/<[\/]*[^>]*>/img, "\n");//
			html = html.replace(/<[\/]*span[^>]*>/img, "");//span
			html = html.replace(/<[\/]*center[^>]*>/img, "");//center
			html = html.replace(/<[\/]*ul[^>]*>/img, "");//ul
			html = html.replace(/<[\/]*i[^>]*>/img, "");//i
			html = html.replace(/<[\/]*li[^>]*>/img, "");//li
			html = html.replace(/<[\/]*b[^>]*>/img, "");//b
			html = html.replace(/<[\/]*hr[^>]*>/img, "");//hr
			html = html.replace(/<[\/]*h\d+[^>]*>/img, "");//h1,2,3,4,5,6
			html = html.replace(/<STYLE[\s\S]*?<\/STYLE>/img, "");//样式
			html = html.replace(/<script[\s\S]*?<\/script>/img, "");//引用的脚本
			//html = html.replace(/<[\?!A-Za-z\][^><]*>/img, "");alert("str:"+html)
			html = html.replace(/\r/img, "");//换行
			html=html.replace(/&nbsp;/g,"");
			html=html.replace(/<img[^>]+>/g,"");
			html = html.replace(/\n/img, "\r\n");//回车
			html = html.replace(/[　|\s]*\r\n[　|\s]*\r\n/img, "\r\n");
			//html = reg.replace(html,@"(\r\n)[^ 　]/img,"$1");
		//	html = formatHtml(html);
			if(noEnter){
			   html = html.replace(/\r\n/img, "");
			   html = html.replace(/\n/img, "");
			   html = html.replace(/\r/img, "");
			}
			return html;
			} 
	
    </script> 
  </head>
  
  <body>
    <html:form action="/sjxxExam.do?m=save" method="post">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>试卷管理</center></caption>
    		<tr >
    			<td align="center" colspan="4">
    				试卷编号：${sjxxForm.vo.sjbh }&nbsp;&nbsp;&nbsp;&nbsp;试卷名称：${sjxxForm.vo.sjmc }
    				<html:hidden property="vo.sjbh"/>
    				<html:hidden property="vo.sjzt"/>
    				<html:hidden property="vo.sjmc"/>
    				<html:hidden property="vo.sjnyd"/>
    				<html:hidden property="vo.kssc"/>
    				<html:hidden property="vo.cjr"/>
    				<html:hidden property="vo.cjsj"/>
    				<input type="hidden" id="show-btn"/>
    			</td>
    		</tr>
    		<logic:notEmpty name="tklist">
    			<c:set var="suffix" value="0"/>
    			<logic:iterate id="tk" name="tklist" indexId="i">
    				<c:set var="count" value="${tk.zts+suffix}"/>
    				<tr>
		    			<td align="left" colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;	    			
		    			<b><cn:upper property="${i}"/>、${tk.sjtxmc} （共 ${tk.zts } 题 每题 ${tk.dtfs } 分 总计 ${tk.zjfs } 分）</b>
		    			<html:hidden property="txlist[${i}].zts" value="${tk.zts }"/>
		    			<html:hidden property="txlist[${i}].dtfs" value="${tk.dtfs }"/>
		    			<html:hidden property="txlist[${i}].sjtxmc" value="${tk.sjtxmc }"/>
		    			<html:hidden property="txlist[${i}].plsx" value="${tk.plsx }"/>
		    			<html:hidden property="txlist[${i}].zjfs" value="${tk.zjfs }"/>
		    			(添加试题：<img src="./images/button/export.jpg" border="0" style="cursor:hand;" onclick="getStglList('${tk.sjtxmc}',${suffix },${count});"/>)
		    			</td>
		    		</tr>
		    		<c:forEach var="cursuf" begin="${suffix}" end="${count-1 }" varStatus="st">
		    			<tr>
		    				<td>
		    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="width: 18px">${cursuf-suffix+1 }</span>、<html:text property="ktlist[${cursuf}].stmc" styleClass="inputlong" readonly="true"/>
		    					<img src="./images/button/del.gif" style="cursor: hand;" border="0" onclick="clearValue(this.parentNode);"/>
		    					<html:hidden property="ktlist[${cursuf}].stzj"/>
		    					<html:hidden property="ktlist[${cursuf}].stlx" value="${tk.sjtxmc}"/>
		    				</td>
		    			</tr>
		    		</c:forEach>
		    		<c:set var="suffix" value="${count}"/>
    			</logic:iterate>
    		</logic:notEmpty>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit styleClass="inputbutton" onclick="return IsNull(${suffix});">添 加</html:submit>
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
