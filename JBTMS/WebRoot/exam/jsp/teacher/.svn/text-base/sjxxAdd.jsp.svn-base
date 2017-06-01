<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	function IsNull(){
    		var sjbh = document.all("vo.sjbh");
    		var sjmc = document.all("vo.sjmc");
    		var kssc = document.all("vo.kssc");
    		var tmlx = document.getElementsByName("tmlx");
    		var expNum = /^[0-9]+$/;
    		if(sjbh.value==""){
    			alert("请输入试卷编号!");
    			return false;
    		}
    		if(sjmc.value==""){
    			alert("请输入试卷名称!");
    			return false;
    		}
    		if(kssc.value==""){
    			alert("请输入考试时长!");
    			return false;
    		}else if(!expNum.test(kssc.value)){
    			alert("考试时间输入有误!");
    			return false;
    		}
    		var sumCent = 0;
    		for(var i=0;i<tmlx.length;i++){
    			if(tmlx[i].checked){
    				var zts = document.all("txlist["+i+"].zts");
    				var dtfs = document.all("txlist["+i+"].dtfs");
    				var zjfs = document.all("txlist["+i+"].zjfs");
    				if(!expNum.test(zts.value)){
    					alert("题目数量输入有误!");
    					return false;
    				}else if(parseInt(zts.value)==0){
    					alert("题目数量输入有误!");
    					return false;
    				}
    				if(!expNum.test(dtfs.value)){
    					alert("题目分数输入有误!");
    					return false;
    				}
    				sumCent+=parseInt(zts.value)*parseInt(dtfs.value);
    				zjfs.value=parseInt(zts.value)*parseInt(dtfs.value);
    			}
    		}
    		if(sumCent!=100){
    			alert("试卷采用百分制，请调整分数设置!");
    			return false;
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./sjxxExam.do?m=objList&page=1";
    	}
    </script> 
  </head>
  
  <body>
    <html:form action="/sjxxExam.do?m=nextsave" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>试卷管理</center></caption>
    		<tr >
    			<td align="right">
    				试卷编号：
    			</td>
    			<td>
    				<html:text property="vo.sjbh" styleClass="input"/>
    				<html:hidden property="vo.sjzt"/>
    			</td>
    			<td align="right">
    				试卷名称：
    			</td>
    			<td>
    				<html:text property="vo.sjmc" styleClass="input"/>
    			</td>
    		</tr>
    		<tr >
    			<td align="right">
    				难 易 度：
    			</td>
    			<td>
    				<html:select property="vo.sjnyd" style="width:100pt;">
    					<html:option value="简单">简单</html:option>
	    				<html:option value="一般">一般</html:option>
	    				<html:option value="困难">困难</html:option>
    				</html:select>
    			</td>
    			<td align="right">
    				考试时长：
    			</td>
    			<td>
    				<html:text property="vo.kssc" styleClass="input"/>(分钟)
    			</td>
    		</tr>
    		<tr >
    			<td align="right">
    				出 卷 人：
    			</td>
    			<td>
    				<html:text property="vo.cjr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">
    				出卷时间：
    			</td>
    			<td>
    				<html:text property="vo.cjsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">题目类型</td>
    		</tr>
    		<logic:notEmpty name="tklist">
    			<logic:iterate id="tk" name="tklist" indexId="i">
    				<tr>
		    			<td align="center" colspan="4">
		    			${i+1 }.${tk.tklx}<input type="checkbox" name="tmlx" value="${tk.tkzj }"/>
		    			题数：<html:text property="txlist[${i}].zts" styleClass="inputsmall2"/>
		    			每题分数：<html:text property="txlist[${i}].dtfs" styleClass="inputsmall2"/>
		    			<html:hidden property="txlist[${i}].sjtxmc" value="${tk.tklx}"/>
		    			<html:hidden property="txlist[${i}].plsx" value="${tk.tkzj }"/>
		    			<html:hidden property="txlist[${i}].zjfs"/>
		    			</td>
		    		</tr>
    			</logic:iterate>
    		</logic:notEmpty>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit styleClass="inputbutton">下一步</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
