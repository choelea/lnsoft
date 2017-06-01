<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ taglib uri="/NumCn" prefix="cn" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <link href="./css/admin.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="./sjxxExam.do?m=objList&page=1";
    	}
    </script> 
  </head>
  
  <body>
    <html:form action="/sjxxExam.do?m=preview" method="post">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<tr >
    			<td align="center">
    				试卷编号：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.sjbh }
    			</td>
    			<td align="center">
    				试卷名称：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.sjmc }
    			</td>
    			<td align="center">
    				难 易 度：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.sjnyd }
    			</td>
    		</tr>
    		<tr >
    			<td align="center">
    				考试时长：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.kssc }分钟
    			</td>
    			<td align="center">
    				出 卷 人：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.cjr }
    			</td>
    			<td align="center">
    				出卷时间：
    			</td>
    			<td align="center">
    				${sjxxForm.vo.cjsj }
    			</td>
    		</tr>
    		<logic:notEmpty name="kt">
    			<logic:iterate id="tk" name="kt" indexId="i">
    				<tr>
		    			<td colspan="6">
		    			&nbsp;&nbsp;&nbsp;&nbsp;<b><cn:upper property="${i}"/>、${tk.sjtx.sjtxmc} （共 ${tk.sjtx.zts } 题 每题 ${tk.sjtx.dtfs } 分 总计 ${tk.sjtx.zjfs } 分）</b>
		    			</td>
		    		</tr>
		    		<logic:iterate id="st" name="tk" property="list" indexId="j">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${j+1 }、${st[1].stmc }
		    				</td>
		    			</tr>
		    			<c:if test="${st[1].stlx=='单选题' }">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="radio${st[1].stzj }" value="A"/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }		    				
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="radio${st[1].stzj }" value="B"/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="radio${st[1].stzj }" value="C"/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="radio" name="radio${st[1].stzj }" value="D"/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='多选题' }">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="A"/> A.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxa }		    					    				
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="B"/> B.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxb }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="C"/> C.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxc }
		    				</td>
		    			</tr>
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="D"/> D.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxd }
		    				</td>
		    			</tr>
		    			<c:if test="${st[1].xxe!='' }">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="E"/> E.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxe }
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].xxf!='' }">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input type="checkbox" name="checkbox${st[1].stzj }" value="F"/> F.&nbsp;&nbsp;&nbsp;&nbsp;${st[1].xxf }
		    				</td>
		    			</tr>
		    			</c:if>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='判断题' }">
		    			<tr>
		    				<td colspan="6">
		    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				对<input type="radio" name="radio${st[1].stzj }"/>
		    				错<input type="radio" name="radio${st[1].stzj }"/>
		    				</td>
		    			</tr>
		    			</c:if>
		    			<c:if test="${st[1].stlx=='描述题' || st[1].stlx=='操作题' }">
		    			<tr>
		    				<td colspan="6" align="center">
		    				<textarea rows="6" cols="50" name="text${st[1].stzj }"></textarea>
		    				</td>
		    			</tr>
		    			</c:if>
		    		</logic:iterate>
    			</logic:iterate>
    		</logic:notEmpty>
    		<tr>
    			<td align="center" colspan="6">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
