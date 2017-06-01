<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ taglib uri="/NumCn" prefix="cn" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
    	function backPath(){
    		var path='${backType}';
    		if("stu"==path){
    			window.location.href="./djxxExam.do?m=cjList";
    		}else if("tea"==path){
    			window.location.href="./djxxExam.do?m=djxxList&vo.sskssz=${djxxForm.vo.sskssz}";
    		}
    	}
    </script>    
  </head>
  
  <body>
    <html:form action="/djxxExam.do?m=preview" method="post">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr align="center">
   				<td colspan="2">
   					<h2>${djxxForm.sjxx.sjmc }</h2>
   					学 号：${djxxForm.xsxx.xsxh }&nbsp;&nbsp;&nbsp;&nbsp;学生姓名：${djxxForm.xsxx.xsxm }&nbsp;&nbsp;&nbsp;&nbsp;答卷时间：${djxxForm.sjxx.kssc }分钟&nbsp;&nbsp;&nbsp;&nbsp; 满 分：100 &nbsp;&nbsp;&nbsp;&nbsp;得 分：<span>${djxxForm.vo.djdf }</span>
   					<html:hidden property="vo.djsj"/>
   					<html:hidden property="vo.djzj"/>
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
		    			<td colspan="2">
		    			&nbsp;&nbsp;&nbsp;&nbsp;<b><cn:upper property="${i}"/>、${tk.sjtx.sjtxmc} （共 ${tk.sjtx.zts } 题 每题 ${tk.sjtx.dtfs } 分 总计 ${tk.sjtx.zjfs } 分）</b>
		    			</td>
		    		</tr>
		    		<logic:iterate id="st" name="tk" property="list" indexId="j">
		    			<tr>
		    				<td width="85%">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${j+1 }、${st[1].stmc }
		    				<html:hidden property="list[${suffix+j}].stgl.stzj" value="${st[1].stzj }"/>
		    				<html:hidden property="list[${suffix+j}].stgl.stlx" value="${st[1].stlx }"/>
		    				<html:hidden property="list[${suffix+j}].stda" value="${st[0].stda }"/>
		    				<html:hidden property="list[${suffix+j}].dtdf" value="${st[0].dtdf }"/>
		    				</td>		    				
		    				<td align="center">
			    				<c:if test="${st[1].stlx=='单选题' || st[1].stlx=='多选题' || st[1].stlx=='判断题'}">	
				    				<span style="text-align: right;"><font color="red">得 分：${st[0].dtdf }<br/>正确答案：${st[1].zqda }</font></span>
				    			</c:if>
				    			<c:if test="${st[1].stlx=='描述题' || st[1].stlx=='操作题'}">
				    				<span style="text-align: right;"><font color="red">得 分：${st[0].dtdf }</font></span>
				    			</c:if>			    				
		    				</td>		    				
		    			</tr>
		    			<c:if test="${st[1].stlx=='单选题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="A" <c:if test="${fn:contains(st[0].stda,'A') }">checked="checked"</c:if>/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }		    				
		    				</td>
		    				<td rowspan="4" align="center">
		    				<font color="red" size="7">${st[0].stda==st[1].zqda?'√':'×'}</font>
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="B" <c:if test="${fn:contains(st[0].stda,'B') }">checked="checked"</c:if>/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="C" <c:if test="${fn:contains(st[0].stda,'C') }">checked="checked"</c:if>/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="list[${suffix+j}].stda" value="D" <c:if test="${fn:contains(st[0].stda,'D') }">checked="checked"</c:if>/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='多选题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="A" <c:if test="${fn:contains(st[0].stda,'A') }">checked="checked"</c:if>/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }
		    				<input type="hidden" name="dxda${suffix+j }" value="${st[0].stda }"/>
		    				</td>
		    				<td rowspan="${st[1].xxe!=''?(st[1].xxf!=''?6:5):(st[1].xxf!=''?5:4) }" align="center">
		    				<font color="red" size="7">${st[0].stda==st[1].zqda?'√':'×'}</font>
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="B" <c:if test="${fn:contains(st[0].stda,'B') }">checked="checked"</c:if>/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="C" <c:if test="${fn:contains(st[0].stda,'C') }">checked="checked"</c:if>/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="D" <c:if test="${fn:contains(st[0].stda,'D') }">checked="checked"</c:if>/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			<c:if test="${st[1].xxe!='' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="E" <c:if test="${fn:contains(st[0].stda,'E') }">checked="checked"</c:if>/> E.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxe }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].xxf!='' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="list[${suffix+j}].stda" value="F" <c:if test="${fn:contains(st[0].stda,'F') }">checked="checked"</c:if>/> F.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxf }
		    				</td>
		    			</tr>
		    			</c:if>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='判断题' }">
		    			<tr>
		    				<td>
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				对<input type="radio" name="list[${suffix+j}].stda" value="对" <c:if test="${fn:contains(st[0].stda,'对') }">checked="checked"</c:if>/>
		    				错<input type="radio" name="list[${suffix+j}].stda" value="错" <c:if test="${fn:contains(st[0].stda,'错') }">checked="checked"</c:if>/>
		    				</td>
		    				<td align="center">
		    				<font color="red" size="7">${st[0].stda==st[1].zqda?'√':'×'}</font>
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='描述题' || st[1].stlx=='操作题' }">
		    			<tr>
		    				<td align="center" colspan="2">
		    				<html:textarea rows="6" cols="50" property="list[${suffix+j}].stda" value="${st[0].stda }"></html:textarea>
		    				</td>
		    			</tr>
		    			<tr>
		    				<td align="center" colspan="2">
		    				<font color="red">参考答案</font>
		    				</td>
		    			</tr>
		    			<tr>
		    				<td align="center" colspan="2">
		    				<html:textarea rows="6" cols="50" property="list[${suffix+j}].stda" value="${st[1].ckda }"></html:textarea>
		    				</td>
		    			</tr>
		    			</c:if>
		    		</logic:iterate>
		    		<c:set var="suffix" value="${count}"/>
    			</logic:iterate>
    		</logic:notEmpty>
    		<tr>
    			<td align="center" colspan="2">
    				<input type="button" name="back" value="返回" class="inputbutton" onclick="backPath();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
