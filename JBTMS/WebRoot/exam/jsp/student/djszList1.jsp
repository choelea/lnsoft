<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
  	<title><bean:message key="system.title"></bean:message></title> 
  	<link href="./css/admin.css" rel="stylesheet" type="text/css">
  	<script type="text/javascript" src="./js/pub.js"></script>  	
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
    <html:form action="/djxxExam.do?m=query" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>试卷名称</th>
	    		<th>答 卷 人</th>	    		
	    		<th>答卷时间</th>
	    		<th>状 态</th>
	    		<th>查看成绩</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.djzj }"/></td>		   		
		   		<td>${obj.sjxx.sjmc }</td>
		   		<td>${obj.xsxx.xsxm }</td>
		   		<td>${obj.djsj }</td>
		   		<td>
		   		<c:if test="${obj.sfyj==0 }">
		   			未 阅
		   		</c:if>
		   		<c:if test="${obj.sfyj!=0 }">
		   			已 阅
		   		</c:if>
		   		</td>
		   		<td>
		   		<a href="./djxxExam.do?m=preview&vo.djzj=${obj.djzj }&sjxx.sjzj=${obj.sjxx.sjzj }&backType=stu" <c:if test="${obj.sfyj==0 }">onclick="alert('请等待教师阅卷!');return false;"</c:if>>查看成绩</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无答卷信息!
    		</td>
    	</tr>
    	</logic:empty>
    	  	<tr>
    	<td height="35" colspan="6" align="center"><input type="button" value="返回" name="button" class="inputbutton" onclick="javascript:window.location.href='<%=request.getContextPath()%>/djxxExam.do?m=objList&rmMsg=true'"></td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata1('./djxxExam.do?m=cjList',1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata1('./djxxExam.do?m=cjList',${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata1('./djxxExam.do?m=cjList',${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata1('./djxxExam.do?m=cjList',${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata1('./djxxExam.do?m=cjList',this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
