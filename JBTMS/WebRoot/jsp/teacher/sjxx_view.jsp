<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
    <script type="text/javascript">    	
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/sjxx.do?method=objList&page=1";
    	}
    </script> 
  </head>  
  <body>
    <html:form action="/sjxx.do?method=viewObject" method="post">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>任务管理</center></caption>
    		<tr>
    			<td align="right">任务编号&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="sjbh" styleClass="input" readonly="true"/>
    				<html:hidden property="cjrzj"/>
    				<html:hidden property="sjzj"/>
    				<div id="bjbh"></div>
    			</td>    		
    			<td align="right">任务名称&nbsp;&nbsp;</td>
    			<td><html:text property="sjmc" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">发布时间&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="cjsj" styleClass="input" readonly="true"/>    				
    			</td>
    			<td align="right">任务状态&nbsp;&nbsp;</td>
    			<td>
    			<html:select property="sjzt" style="width:100pt;" disabled="true">
    				<html:option value="1">启用</html:option>
    				<html:option value="0">禁用</html:option>
    			</html:select>  				
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">操作选择
    			</td>    			
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    			<div id="stlb">
    				<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    					<tr align="center">
    						<td>操作编号</td>
    						<td>操作名称</td>
    						<td>操作类型</td>
    						<td>考题描述</td>
    					</tr>
    					<logic:notEmpty name="ktlist">
    						<logic:iterate id="ktobj" name="ktlist" indexId="ind">
	    						<tr align="center">
		    						<td><input type="hidden" name="stPk" value="${obj.stgl.stzj }"/>${ind+1 }</td>
		    						<td>${ktobj.stgl.stmc }</td>
								 	<td>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'0')}">基础资料
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'1')}">客户关系
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'2')}">仓储
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'3')}">订单
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'4')}">财务
									</c:if>
									<c:if test="${fn:contains(ktobj.stgl.stlx,'5')}">决策
									</c:if>
								 	</td>
		    						<c:if test="${ktobj.stgl.sfyk==0 }">
		    						<c:if test="${ktobj.stgl.stzj==tjhpst}">
		    				 		<td>
		    				 			<table width="200" border="0" cellpadding="0" cellspacing="1" style="word-break:break-all;">
		    				 				<tr>
		    				 					<td align="center">货品名称</td>
		    				 					<td align="center">货品数量</td>
		    				 				</tr>
		    				 				<c:if test="${hplist!=null }">
			    				 				<c:forEach var="sjhp" items="${hplist}">
			    				 				<tr>
			    				 					<td align="center">
			    				 						<c:forEach var="hpxx" items="${hpxxlist }">
			    				 						<c:if test="${sjhp.hpbm==hpxx.hpbm }">${hpxx.hpmc }</c:if>
			    				 						</c:forEach>
			    				 					</td>
			    				 					<td align="center">${sjhp.hpsl }</td>
			    				 				</tr>
			    				 				</c:forEach>
		    				 				</c:if>
		    				 			</table>
		    				 		</td>
		    				 		</c:if>
		    				 		<c:if test="${ktobj.stgl.stzj!=tjhpst}">
		    				 		<td><input type="text" name="list[${ind }].ktms" value="${ktobj.ktms }" class="input" style="width:150pt" readonly="readonly"/></td>
		    				 		</c:if>
		    						
		    						</c:if>
		    						<c:if test="${ktobj.stgl.sfyk!=0 }">
		    				 		<td>移库数量:<input type="text" name="list[${ind }].yksl" value="${ktobj.yksl }" class="input" style="width:60pt" readonly="readonly"/></td>
		    				 		</c:if>
	    						</tr>
    						</logic:iterate>
    					</logic:notEmpty>				
    				</table>
    			</div>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>
  </body>
</html>