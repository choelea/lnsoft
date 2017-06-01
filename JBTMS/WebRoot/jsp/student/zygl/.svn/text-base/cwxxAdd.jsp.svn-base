<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script type="text/javascript">
    	function IsNull(){
    		var amhs = document.all("vo.amhs");
    		var amls = document.all("vo.amls");
    		var bmhs = document.all("vo.bmhs");
    		var bmls = document.all("vo.bmls");
    		var expNum = /^[0-9]+$/;
    		if(amhs!=null){
    			if(!expNum.test(amhs.value)){
    				alert("行数输入有误!");
    				return false;
    			}
    			if(parseInt(amhs.value)<1 || parseInt(amhs.value)>20){
    				alert("行数请控制在1-20之间!");
    				return false;
    			}  			
    		}
    		if(amls!=null){
    			if(!expNum.test(amls.value)){
    				alert("列数输入有误!");
    				return false;
    			}
    			if(parseInt(amls.value)<1 || parseInt(amls.value)>20){
    				alert("列数请控制在1-20之间!");
    				return false;
    			}  			
    		}
    		if(bmhs!=null){
    			if(!expNum.test(bmhs.value)){
    				alert("行数输入有误!");
    				return false;
    			}   
    			if(parseInt(bmhs.value)<1 || parseInt(bmhs.value)>20){
    				alert("行数请控制在1-20之间!");
    				return false;
    			} 			
    		}
    		if(bmls!=null){
    			if(!expNum.test(bmls.value)){
    				alert("列数输入有误!");
    				return false;
    			}   
    			if(parseInt(bmls.value)<1 || parseInt(bmls.value)>20){
    				alert("列数请控制在1-20之间!");
    				return false;
    			}  			
    		}
    	}
    	function createTable(){
    		var aid = document.getElementById("aid");
    		var amhs = document.all("vo.amhs");
    		var amls = document.all("vo.amls");
    		var expNum = /^[0-9]+$/;
    		
    		if(aid!=null){
    			if(!expNum.test(amhs.value)){
    				alert("行数输入有误!");
    				return false;
    			}
    			if(parseInt(amhs.value)<1 || parseInt(amhs.value)>20){
    				alert("行数请控制在1-20之间!");
    				return false;
    			}
    			if(!expNum.test(amls.value)){
    				alert("列数输入有误!");
    				return false;
    			}
    			if(parseInt(amls.value)<1 || parseInt(amls.value)>20){
    				alert("列数请控制在1-20之间!");
    				return false;
    			}
    			var fchi = aid.firstChild;
    			while(fchi!=null){
    				var tchi = fchi.nextSibling;
    				aid.removeChild(fchi);
    				fchi = tchi;
    			}
    			for(var i=1;i<parseInt(amhs.value)+1;i++){
    				var trE = aid.insertRow();
    				trE.setAttribute("align","center");
    				for(var j=1;j<parseInt(amls.value)+1;j++){
    					var tdE = trE.insertCell();
    					tdE.setAttribute("innerText","A"+i+"-"+j);
    				}
    			}
    		}
    	}
    	function back(){
    		window.location.href="./qwxx.do?method=objList";
    	}
    </script>   
  </head>
  
  <body>
    <html:form action="/qwxx.do?method=fpcw" method="post" onsubmit="return IsNull();">
		<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    		<caption><center>储位管理(区位：${qwxxForm.vo.qwbh })</center></caption>
    		<c:if test="${qwxxForm.vo.qfabm!=0 }">
	    		<tr>
	    			<td colspan="4" align="center">A 面</td>
	    		</tr>
    		</c:if>
    		<tr >
    			<td width="30%"  align="right" >行 数&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">*</font>
    			<html:hidden property="kfxx.kfzj"/>
    			<html:hidden property="vo.qwzj"/>
    			</td>
    			<td width="25%">
    				<html:text property="vo.amhs" styleClass="input" onblur="createTable();" readonly="${qwxxForm.kfxx.kflx!='普通仓库'?'true':'false' }"/>
    			</td>
    			<td width="15%" align="right">列 数&nbsp;&nbsp;<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.amls" styleClass="input" onblur="createTable();" readonly="${qwxxForm.kfxx.kflx!='普通仓库'?'true':'false' }"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="4">
    			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
    				<tbody id="aid">
    					<c:forEach var="i" begin="1" end="${qwxxForm.vo.amhs }">
    						<tr align="center">
    						<c:forEach var="j" begin="1" end="${qwxxForm.vo.amls }">
    							<td align="center" >A${i }-${j }</td>
    						</c:forEach>
    						</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<c:if test="${qwxxForm.vo.qfabm!=0 }">
	    		<tr>
	    			<td colspan="4" align="center">B 面</td>
	    		</tr>
	    		<tr >
	    			<td width="30%"  align="right" >行 数&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">*</font>
	    			</td>
	    			<td width="25%">
	    				<html:text property="vo.bmhs" styleClass="input" readonly="true"/>
	    				<input type="hidden" name="show-btn">
	    			</td>
	    			<td width="15%" align="right">列 数&nbsp;&nbsp;<font color="red">*</font></td>
	    			<td>
	    				<html:text property="vo.bmls" styleClass="input" readonly="true"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="4">
	    			<table width="90%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;" >
	    				<tbody id="bid">
	    					<c:forEach var="i" begin="1" end="${qwxxForm.vo.bmhs }">
	    						<tr align="center">
	    						<c:forEach var="j" begin="1" end="${qwxxForm.vo.bmls }">
	    							<td align="center" >B${i }-${j }</td>
	    						</c:forEach>
	    						</tr>
	    					</c:forEach>
	    				</tbody>
	    			</table>
	    			</td>
	    		</tr>
    		</c:if>
    		<tr>
    			<td align="center" colspan="4" >
    				<html:submit styleClass="inputbutton">分 配</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>    				
    			</td>
    		</tr>
    	</table>
	</html:form>
  </body>
</html>
