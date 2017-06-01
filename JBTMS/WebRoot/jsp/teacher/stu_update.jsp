<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>

<html>
	<head>
		<title>学生信息添加</title>
		<link href="<%=request.getContextPath()%>/css/newdate.css" rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function goback(){
				window.location.href="<%=request.getContextPath()%>/student.do?method=getList&bjzj=${bjzj}&page=${page}"
			}
			function isNull(){
				var zcsl = document.getElementById("zcsl");
				var xsmm = document.getElementById("vo.xsmm");
				var xsdh= document.all("vo.xsdh");
				var zjhm = document.all("vo.zjhm");
				var exp = /^\w+$/;
				var intexp = /^[0-9]+$/;
				var phoneExp = /^(\(){0,1}[0-9]{0,4}(\)){0,1}(-|\s){0,1}(\(){0,1}[0-9]{1,4}(\)){0,1}(-|\s){0,1}[0-9]{4}(-|\s){0,1}[0-9]{3,4}$/;
				if(xsmm.value==""){
					mmsp.innerHTML="请输入登陆密码！";
					xsmm.focus();
					return false;
				}else{
					mmsp.innerHTML="";
				}
				if(!exp.test(xsmm.value)){
					mmsp.innerHTML="密码只能由字母和数字组成！";
					xsmm.focus();
					return false;
				}else{
					mmsp.innerHTML="";
				}
				
				if(xsdh.value!=""&&!phoneExp.test(xsdh.value)){
					dhsp.innerHTML="电话号码格式不正确！";
					xsdh.focus();
					return false;
				}else{
					dhsp.innerHTML="";
				}
				
				if(zjhm.value!=""&&!exp.test(zjhm.value)){
					zjsp.innerHTML="证件号码输入不正确！";
					zjhm.focus();
					return false;
				}else{
					zjsp.innerHTML="";
				}
				
			}
		</script>
	</head>
	<body>
		<html:form action="/student.do?method=updateObject&page=${page}" method="post" onsubmit="return isNull()">
			<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>学生管理</center></caption>
    		<tr>
    			<td align="right">所属院校&nbsp;&nbsp;</td>
    			<td>
					<input type="text" name="xxmc" readonly="readonly" class="input" value="${bjxx.xxmc }"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">所属班级&nbsp;&nbsp;</td>
    			<td>
					<input type="text" name="bjmc" readonly="readonly" class="input" value="${bjxx.bjmc }"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" width="40%" class="td2">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</td>
    			<td><html:text property="vo.xsxh" styleClass="input" readonly="true"/><span id="check" style="color: red;"></span>
    				<html:hidden property="vo.sfdl"/>
    				<!-- 下来字段现在用于存储试验任务名称 -->
    				<html:hidden property="vo.zhsyrwmc"/>
    				<html:hidden property="vo.zhdlsj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">学生姓名&nbsp;&nbsp;</td>
    			<td><html:text property="vo.xsxm" styleClass="input"/><span id="xmsp" class="spts"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" class="td2">登陆密码&nbsp;&nbsp;</td>
    			<td><html:text property="vo.xsmm" styleClass="input"/><span id="mmsp" class="spts"></span>
    			</td>
    		</tr>
    		 <tr>
    			<td align="right">入学时间&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.rxsj" styleClass="input" readonly="true"  onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    		</tr> 
    		<tr>
    			<td align="right">性 &nbsp;&nbsp;&nbsp; 别&nbsp;&nbsp;</td>
    			<td>
					<html:radio property="vo.xb" value="男">男</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;
					<html:radio property="vo.xb" value="女">女</html:radio>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">地 &nbsp;&nbsp;&nbsp; 址&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.xsdz" styleClass="input"/>
    			</td>
    		</tr>  	
    		<tr>
    			<td align="right">电 &nbsp;&nbsp;&nbsp; 话&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.xsdh" styleClass="input"/>
    			<span id="dhsp" class="spts"></span>
    			</td>
    		</tr>  
    		<tr>
    			<td align="right">证件号码&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.zjhm" styleClass="input"/>
    			<span id="zjsp" class="spts"></span>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">籍 &nbsp;&nbsp;&nbsp; 贯&nbsp;&nbsp;</td>
    			<td>
    			<html:text property="vo.xsjg" styleClass="input"/>
    			</td>
    		</tr>  		
    		<tr>
    			<td align="right" class="td2">有效标记&nbsp;&nbsp;</td>
    			<td>
    				<html:select property="vo.yxbj" style="width:100pt">
    					<html:option value="1">有效</html:option>
    					<html:option value="0">无效</html:option>
    				</html:select>
    			</td>
    		</tr>	
    		<tr>
				<td class="td1">
						备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:
					</td>
					<td class="td2">
						<html:textarea property="vo.bzxx" cols="40" rows="4" ></html:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<html:hidden property="vo.xszj"/>
						<html:hidden property="vo.sssyz"/> 
						<input type="hidden" name="bjzj" value="${bjzj }"/>
						<html:submit styleClass="inputButton">修 改</html:submit>
						<input type="button" value="返 回" class="inputButton" onclick="goback()">
					</td>
				</tr>
			</table>
		</html:form>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/newdate.js"></script>
	</body>
</html>

