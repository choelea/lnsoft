<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %> 
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/fn.tld" prefix="fn" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>   
     <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath() %>/kindeditor.js"></script>
    <style type="text/css">
    table{
	border-color:#CCCCCC;
	background-color: #ced7f7;
    }
    td{
	 font-size:12px;
	 background-color:#FFF; 
	 color:#000;
	 /*text-align:center;*/ 
	 /*padding-top:5px;*/
}
.inputbutton {
	height: 20px;
	width: 55px;
	background-color:#ffffff;
	background-image: url(images/button2.jpg);
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
	color: white;
}
.inputlong {	
	width: 430px;
	border-left: 0px solid;
	border-right: 0px solid;
	border-top: 0px solid;
	border-bottom: 1px solid
}
    </style>
    <script type="text/javascript">
    	function IsNull(){
    		var stmc = document.all("vo.stmc");
    		var xxa = document.all("vo.xxa");
    		var xxb = document.all("vo.xxb");
    		var xxc = document.all("vo.xxc");
    		var xxd = document.all("vo.xxd");
    		var xxe = document.all("vo.xxe");
    		var xxf = document.all("vo.xxf");
    		var zqda = document.all("vo.zqda");
    		if(stmc.value==""){
    			alert("请输入题目信息!");
    			return false;
    		}
    		if(xxa!=null){
    			if(xxa.value==""){
    				alert("请输入选项信息!");
    				return false;
    			}
    		}
    		if(xxb!=null){
    			if(xxb.value==""){
    				alert("请输入选项信息!");
    				return false;
    			}
    		}
    		if(xxc!=null){
    			if(xxc.value==""){
    				alert("请输入选项信息!");
    				return false;
    			}
    		}
    		if(xxd!=null){
    			if(xxd.value==""){
    				alert("请输入选项信息!");
    				return false;
    			}
    		}
    		if(zqda!=null){
    			var flag = false;
    			for(var i=0;i<zqda.length;i++){
    				if(zqda[i].checked){
    					flag = true;
    					break;
    				}
    			}
    			if(!flag){
    				alert("请选择答案信息!");
    				return false;
    			}
    		}
    		return true;
    	}
    	function back(){
    		window.location.href="./stglExam.do?m=objList&page=1";
    	}
    </script> 
    <script type="text/javascript">
		KE.show({
			id : 'vo.stmc',
			width:'430px',
			height:'200',
			imageUploadJson : '<%=request.getContextPath() %>/jsp/upload_json.jsp',
			fileManagerJson : '<%=request.getContextPath() %>/jsp/file_manager_json.jsp',
			allowFileManager : false,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				//	document.forms['example'].submit();
				});
				KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {
					KE.util.setData(id);
				//	document.forms['example'].submit();
				});
			}
		});
	</script>
  </head>
  
  <body>
    <html:form action="/stglExam.do?m=update" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>试题管理</center></caption>
    		<tr align="center">
    			<td>试题类型：${tklx }&nbsp;&nbsp;&nbsp;&nbsp;试题难度：
    			<html:select property="vo.stnyd">
    				<html:option value="简单">简单</html:option>
    				<html:option value="一般">一般</html:option>
    				<html:option value="困难">困难</html:option>
    			</html:select>
    			<html:hidden property="vo.stlx" value="${tklx }"/>
    			<html:hidden property="tkgl.tkzj"/>
    			<html:hidden property="vo.stzj"/>
    			</td>
    		</tr>
    		<tr align="center">
    			<td>题 目</td>
    		</tr>
    		<tr align="center">
    			<td>
    			<html:textarea property="vo.stmc" cols="50" rows="6"></html:textarea>
    			<html:hidden property="oldmc" value="${stglsForm.vo.stmc }"/>
    			</td>
    		</tr>
    		<logic:equal value="单选题" name="tklx">
    		<tr align="center">
    			<td>
    				选 择 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>A <html:text property="vo.xxa" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>B <html:text property="vo.xxb" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>C <html:text property="vo.xxc" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>D <html:text property="vo.xxd" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>
    				正 确 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				A<html:radio property="stxx" value="A"/>&nbsp;&nbsp;
    				B<html:radio property="stxx" value="B"/>&nbsp;&nbsp;
    				C<html:radio property="stxx" value="C"/>&nbsp;&nbsp;
    				D<html:radio property="stxx" value="D"/>&nbsp;&nbsp;
    			</td>
    		</tr>
    		</logic:equal>
    		<logic:equal value="多选题" name="tklx">
    		<tr align="center">
    			<td>
    				选 择 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>A <html:text property="vo.xxa" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>B <html:text property="vo.xxb" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>C <html:text property="vo.xxc" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>D <html:text property="vo.xxd" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>E <html:text property="vo.xxe" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>F <html:text property="vo.xxf" styleClass="inputlong"/></td>
    		</tr>
    		<tr align="center">
    			<td>
    				正 确 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				A<html:multibox property="stxx" value="A"/>&nbsp;&nbsp;
    				B<html:multibox property="stxx" value="B"/>&nbsp;&nbsp;
    				C<html:multibox property="stxx" value="C"/>&nbsp;&nbsp;
    				D<html:multibox property="stxx" value="D"/>&nbsp;&nbsp;
    				E<html:multibox property="stxx" value="E"/>&nbsp;&nbsp;
    				F<html:multibox property="stxx" value="F"/>
    			</td>
    		</tr>
    		</logic:equal>
    		<logic:equal value="判断题" name="tklx">
    		<tr align="center">
    			<td>
    				正 确 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				对<html:radio property="stxx" value="对"/>&nbsp;&nbsp;
    				错<html:radio property="stxx" value="错"/>&nbsp;&nbsp;
    			</td>
    		</tr>
    		</logic:equal>
    		<logic:equal value="描述题" name="tklx">
    			<tr align="center">
    			<td>
    				参 考 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				<html:textarea property="vo.ckda" cols="50" rows="6"></html:textarea>
    			</td>
    		</tr>
    		</logic:equal>
    		<logic:equal value="操作题" name="tklx">
    			<tr align="center">
    			<td>
    				参 考 答 案
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				<html:textarea property="vo.ckda" cols="50" rows="6"></html:textarea>
    			</td>
    		</tr>
    		</logic:equal>
    		<tr>
    			<td align="center">
    				<html:submit styleClass="inputbutton">修 改</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    			</td>
    		</tr>
    	</table>
    </html:form>    
  </body>
</html>
