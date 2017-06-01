<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ taglib uri="/NumCn" prefix="cn" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	var time = "${djxxForm.sjxx.kssc}";
    	var long = parseInt(time)*60;
    	var sInter2=setInterval(function (){
    		var hasTime = document.getElementById("hasTime");
    		long -=1;
    		var hour = parseInt(long/60/60);
    		var min = parseInt((long-hour*60*60)/60);
    		hasTime.innerHTML = hour+"小时"+min+"分钟";
    		if(long == 300 ){
    			alert("距离考试结束还有5分钟!");
    		}else if(long <= 0){
    			var docForm = document.forms[0];
    			docForm.submit();
    		}
    	},1000);
    	function IsNull(){
    		if(long>0){
    			return confirm("是否确认交卷?");
    		}
    	}
    </script>
  </head>
  
  <body>
    <html:form action="/djxxExam.do?m=save" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr align="center">
   				<td>
   					<h2>${djxxForm.sjxx.sjmc }</h2>
   					学 号：${userBh }&nbsp;&nbsp;&nbsp;&nbsp;学生姓名：${userName }&nbsp;&nbsp;&nbsp;&nbsp;答卷时间：${djxxForm.sjxx.kssc }分钟&nbsp;&nbsp;&nbsp;&nbsp; 满 分：100 &nbsp;&nbsp;&nbsp;&nbsp;剩余时间：<span id="hasTime"></span>
   					<html:hidden property="vo.djsj"/>
   					<html:hidden property="vo.djdf"/>
   					<html:hidden property="vo.sfjj"/>
   					<html:hidden property="vo.sfyj"/>
   					<html:hidden property="vo.sskssz"/>
   					<html:hidden property="sjxx.sjzj"/>
   					<html:hidden property="xsxx.xszj"/>
   				</td>
   			</tr>
    		<logic:notEmpty name="kt">
    			<c:set var="suffix" value="0"/>
    			<logic:iterate id="tk" name="kt" indexId="i">
    			<c:set var="count" value="${tk.sjtx.zts+suffix}"/>
    				<tr>
		    			<td>
		    			&nbsp;&nbsp;&nbsp;&nbsp;<b><cn:upper property="${i}"/>、${tk.sjtx.sjtxmc} （共 ${tk.sjtx.zts } 题 每题 ${tk.sjtx.dtfs } 分 总计 ${tk.sjtx.zjfs } 分）</b>
		    			</td>
		    		</tr>
		    		<logic:iterate id="st" name="tk" property="list" indexId="j">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${j+1 }、${st[1].stmc }
		    				<html:hidden property="list[${suffix+j}].stgl.stzj" value="${st[1].stzj }"/>
		    				<html:hidden property="list[${suffix+j}].stgl.stlx" value="${st[1].stlx }"/>
		    				</td>
		    			</tr>
		    			<c:if test="${st[1].stlx=='单选题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="A"/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }		    				
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="B"/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="C"/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="D"/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='多选题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="A"/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }		    					    				
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="B"/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="C"/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="D"/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			<c:if test="${st[1].xxe!='' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="E"/> E.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxe }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].xxf!='' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="F"/> F.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxf }
		    				</td>
		    			</tr>
		    			</c:if>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='判断题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				对<input type="radio" name="list[${suffix+j}].stda" value="对"/>
		    				错<input type="radio" name="list[${suffix+j}].stda" value="错"/>
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='描述题' || st[1].stlx=='操作题' }">
		    			<tr>
		    				<td align="center">
		    				<textarea rows="6" cols="50" name="list[${suffix+j}].stda"></textarea>
		    				</td>
		    			</tr>
		    			</c:if>
		    		</logic:iterate>
		    		<c:set var="suffix" value="${count}"/>
    			</logic:iterate>
    		</logic:notEmpty>
    		<tr>
    			<td align="center">
    				<html:submit styleClass="inputbutton">交 卷</html:submit>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
