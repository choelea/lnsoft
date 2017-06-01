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
    <html:form action="/sjxxExam.do?m=query" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="20%">
  			<b>查询字段名：</b>
  			</td>
  			<td align="left" width="25%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="sjbh">试卷编号</html:option>
  					<html:option value="sjmc">试卷名称</html:option>
  					<html:option value="sjnyd">试卷难易度</html:option>
  					<html:option value="cjr">出 卷 人</html:option>
  				</html:select>
  			</td>
  			<td align="right" width="15%"><b>查询字段值：</b></td>
  			<td align="left" width="20%"><html:text property="fieldValue" styleClass="input"></html:text></td>
  			<td align="left" ><input type="submit" name="su" value="查 询" class="inputbutton"/></td>
  		</tr>
  	</table>
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th>全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th>试卷编号</th>
	    		<th>试卷名称</th>
	    		<th>试卷难易度</th>
	    		<th>试卷状态</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.sjzj }"/></td>
		   		<td>
		   		<a href="./sjxxExam.do?m=preview&vo.sjzj=${obj.sjzj }">${obj.sjbh }</a>
		   		</td>
		   		<td>${obj.sjmc }</td>
		   		<td>${obj.sjnyd }</td>
		   		<td>
		   		<c:if test="${obj.sjzt==0 }">
		   			<a href="./sjxxExam.do?m=updState&vo.sjzj=${obj.sjzj }&vo.sjzt=1">禁 用</a>
		   		</c:if>
		   		<c:if test="${obj.sjzt!=0 }">
		   			<a href="./sjxxExam.do?m=updState&vo.sjzj=${obj.sjzj }&vo.sjzt=0">启 用</a>
		   		</c:if>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无试卷信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
    			<input type="button" value="添 加" onclick="toadd('./sjxxExam.do');" class="inputbutton"/>
    			<input type="button" value="删 除" onclick="return todel('./sjxxExam.do');" class="inputbutton"/>
    		</td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata('./sjxxExam.do',1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata('./sjxxExam.do',${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata('./sjxxExam.do',${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata('./sjxxExam.do',${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata('./sjxxExam.do',this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
