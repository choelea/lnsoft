<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <script type="text/javascript">
    	function back(){
    		window.location.href="<%=request.getContextPath()%>/khts.do?method=getList&page=1&rmMsg=true";
    	}
    </script> 
  </head>
  
  <body>
  	<html:form action="/khts.do?method=tsslObject" method="post">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>客户投诉单</center></caption>
    		<tr>
    			<td align="right" width="20%">投诉编号&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="hidden" id="show-btn"/> 
    			</td>
    			<td width="25%">
    				<html:text property="vo.tsbh" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right" width="20%">投诉客户&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.tskh" styleClass="input" readonly="true"/>    		
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">投 诉 人&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td width="25%">
    				<html:text property="vo.tsr"  styleClass="input"/>
    			</td>
    			<td align="right" width="20%">投诉人电话&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.tsrdh" styleClass="input" readonly="true"/>    			
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">投诉日期&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    			<td width="25%" colspan="3">
    				<html:text property="vo.tsrq" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">投诉内容&nbsp;&nbsp;<font color="red">*</font></td>
    			<td colspan="3">
    				<html:textarea property="vo.tsnr" cols="50" rows="4" readonly="true"></html:textarea>
    			</td>
    		</tr>
    		<c:if test="${khtsForm.vo.sfsl==1 }">
    		<tr>
    			<td align="right">受理回复&nbsp;&nbsp;<font color="red">*</font></td>
    			<td colspan="3">
    				<html:textarea property="vo.slhf" cols="50" rows="4"  readonly="true" ></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="20%">受 理 人&nbsp;&nbsp;<font color="red">*</font>
    			</td>
    			<td width="25%">
    				<html:text property="vo.slr"  styleClass="input"  readonly="true" value="${userTName }"/>
    			</td>
    			<td align="right" width="20%">受理日期&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.slrq" styleClass="input" readonly="true"/>    			
    			</td>
    		</tr>
    		</c:if>
    		<tr>
    			<td align="center" colspan="4">
    				<html:hidden property="vo.tszj"/>
    				<html:hidden property="vo.sfsl" value="1"/>
    				<html:hidden property="vo.ssxs" value="${userPk }"/>
    				<html:hidden property="vo.sssysz" value="${userSyszzj }"/>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
  	</html:form>
  	<div id="hello-win" class="x-hidden">
	    <div id="hello-tabs">
           <div class="tanchuang" id="div1">
            </div>
        </div>
    </div>
  </body>
</html>