<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ taglib uri="/WEB-INF/tlds/ReplaceImgs.tld" prefix="imgs" %> 
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
    <html:form action="/stglExam.do?m=query" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="0" border="0" style="word-break:break-all;">
  		<tr>
  			<td align="right" width="20%">
  			<b>查询字段名：</b>
  			</td>
  			<td align="left" width="25%">
  				<html:select property="fieldName" style="width:100pt">
  					<html:option value="">选择查询字段名称</html:option>
  					<html:option value="stnyd">难 易 度</html:option>
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
	    		<th width="8%">全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th width="70%">试题名称</th>
	    		<th>试题类型</th>
	    		<th>难 易 度</th>
	    		<th>操 作</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj.stzj }" /></td>
		   		<td align="left">
		   		<a href="./stglExam.do?m=preview&vo.stzj=${obj.stzj }"><imgs:replaceImg imgs="${obj.stmc }" /></a>
		   		</td>
		   		<td>${obj.stlx }</td>
		   		<td>${obj.stnyd }</td>
		   		<td>
		   			<a href="./stglExam.do?m=preupdate&vo.stzj=${obj.stzj }">修 改</a>
		   		</td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
    		<td colspan="7" align="center">
    			暂无试题信息!
    		</td>
    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
    			<input type="button" value="添 加" onclick="toadd('./stglExam.do');" class="inputbutton"/>
    			<input type="button" value="删 除" onclick="return todel('./stglExam.do');" class="inputbutton"/>
    			<input type="button" value="返 回" onclick="back1('./stglExam.do?m=tkList');" class="inputbutton"/>
    		</td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata('./stglExam.do',1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata('./stglExam.do',${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata('./stglExam.do',${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata('./stglExam.do',${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata('./stglExam.do',this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
  </body>
</html>
