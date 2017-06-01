<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<html>
  <head>
  	<title><bean:message key="system.title"></bean:message></title> 
  	<link href="./css/admin.css" rel="stylesheet" type="text/css">
  	<script type="text/javascript" src="./js/pub.js"></script>
  	<script type="text/javascript">
  		function isDone(sysz,sjxx){
  			var hql = "from Djxxs A where A.xsxx.xszj = '${userStuPk}' and A.sskssz="+sysz+" and A.sjxx.sjzj="+sjxx;
			ExamDWR.isExist(hql,function (data){
				if(data){
					alert("您已经做过该试卷!");
				}else{
					window.location.href="./djxxExam.do?m=presave&vo.sskssz="+sysz+"&sjxx.sjzj="+sjxx;
				}
			});
		}		
  	</script>
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
	    		<th>班级名称</th>
	    		<th>试卷名称</th>	    		
	    		<th>状 态</th>
	    		<th>开始答卷</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.ksszzj }"/></td>		   		
		   		<td>${obj.bjxx.bjmc }</td>
		   		<td>${obj.sjxx.sjmc }</td>
		   		<td>
		   		<c:if test="${obj.ksszzt==0 }">
		   			禁 用
		   		</c:if>
		   		<c:if test="${obj.ksszzt!=0 }">
		   			启 用
		   		</c:if>
		   		</td>
		   		<td>
		   		<a href="#" onclick="isDone(${obj.ksszzj },${obj.sjxx.sjzj })">开始答卷</a>/
		   		<a href="./djxxExam.do?m=cjList&rmMsg=true" >成绩查看</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无实验设置信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    	<td height="35" colspan="5" align="center"><input type="button" value="返回" name="button" class="inputbutton" onclick="javascript:window.location.href='<%=request.getContextPath() %>/jsp/student/lct.jsp'"></td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata('./djxxExam.do',1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata('./djxxExam.do',${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata('./djxxExam.do',${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata('./djxxExam.do',${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata('./djxxExam.do',this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
