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
    <html:form action="/ksszExam.do?m=query" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>班级名称</th>
	    		<th>试卷名称</th>	    		
	    		<th>状 态</th>
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
		   			<a href="./ksszExam.do?m=szState&vo.ksszzj=${obj.ksszzj }&vo.ksszzt=1">禁 用</a>
		   		</c:if>
		   		<c:if test="${obj.ksszzt!=0 }">
		   			<a href="./ksszExam.do?m=szState&vo.ksszzj=${obj.ksszzj }&vo.ksszzt=0">启 用</a>
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无试验设置信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
    			<input type="button" value="添 加" onclick="toadd('./ksszExam.do');" class="inputbutton"/>
    			<input type="button" value="删 除" onclick="return todel('./ksszExam.do');" class="inputbutton"/>
    		</td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata('./ksszExam.do',1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata('./ksszExam.do',${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata('./ksszExam.do',${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata('./ksszExam.do',${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata('./ksszExam.do',this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
