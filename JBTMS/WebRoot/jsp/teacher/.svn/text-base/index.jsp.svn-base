<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %> 
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/fn.tld" prefix="fn" %>
<html>
<head>
<title><bean:message key="system.title"></bean:message></title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.1.min.js"></script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
	.b:link {
	font-family: "宋体";
	font-size: 12px;
	color: #000000 ;
	text-decoration: none;
	}
	.b:visited {
		font-family: "宋体";
		font-size: 12px;
		color: #000000;
		text-decoration: none;
	}
	.b:hover {
		font-family: "宋体";
		font-size: 12px;
		color: #FFCC00;
		text-decoration: none;
	}
	.d_h{
		width: 180px;
		margin: 0px;
		padding: 0px;
		left: 0px;
		top: 0px;
		right: 0px;
		bottom: 0px;
		clip: rect(0px,0px,0px,0px);
		}
	.d_h ul{
			list-style-type: none;
			margin: 0px;
			padding: 0px;
			display: block;
			}
	.d_h li{
			font-family:"宋体";
			font-size:12px;
			color:#000000;
			text-decoration:none;
			height:30px;
			width:180px;
			line-height:30px;
			list-style-type:none;
			display:block;
			}
	.d_h a:link{
		font-family:"宋体";
		font-size:12px;
		color:#000000;
		text-decoration:none;
		height:30px;
		width:180px;
		line-height:30px;
		list-style-type:none;
		display:block;
		margin:0px;
		padding:0px;
		overflow: hidden;
		background-image:url(<%=request.getContextPath()%>/images/admin/one.jpg);
		background-repeat: no-repeat;
		padding-left: 80px;	
		}
.d_h a:visited{
		font-family:"宋体";
		font-size:12px;
		color:#000000;
		text-decoration:none;
		height:30px;
		width:180px;
		line-height:30px;
		list-style-type:none;
		display:block;
		margin:0px;
		padding:0px;
		overflow: hidden;
		background-image:url(<%=request.getContextPath()%>/images/admin/one.jpg);
		background-repeat: no-repeat;
		padding-left: 80px;	
		}
.d_h a:hover{
		font-family:"宋体";
		font-size:12px;
		color:#000000;
		text-decoration:none;
		height:30px;
		width:180px;
		line-height:30px;
		list-style-type:none;
		display:block;
		margin:0px;
		padding:0px;
		overflow: hidden;
		background-image:url(<%=request.getContextPath()%>/images/admin/two.jpg);
		background-repeat: no-repeat;
		padding-left:80px;
		}
.d_h a:active{
		font-family:"宋体";
		font-size:12px;
		color:#000000;
		text-decoration:none;
		height:30px;
		width:180px;
		line-height:30px;
		list-style-type:none;
		display:block;
		margin:0px;
		padding:0px;
		overflow: hidden;
		background-image:url(<%=request.getContextPath()%>/images/admin/two.jpg);
		background-repeat: no-repeat;
		padding-left: 80px;	
		}
</style>
<script type="text/javascript">
    	function setTimeDisplay(){
			var date = new Date();
			var msg = date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			document.getElementById("timeSpan").innerHTML=msg;
			window.setTimeout(setTimeDisplay,1000);
		}
		window.setTimeout(setTimeDisplay,1000);
		jQuery(
		function($){
			$(".bbb").click(function(){
				$("#xtwz").html($(this).text());
			})
		});
    	function helpMsg(msg){
			window.open("<%=request.getContextPath()%>/help/"+msg+".html","Help","menubar=no,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=no");
		}
    </script>
</head>
<body bgcolor="#e0edf6" style="text-align: center;">
<table id="__01" width="1002" height="613" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="8" background="<%=request.getContextPath()%>/images/admin/student_01.jpg" width="1002" height="47" align="right">
			<table style="font-size:12px">
            	<tr>
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/bz.gif"> </td> 
                <td align="left"><a href="javascript:helpMsg('jsbz');" class="b">系统帮助</a><td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/sx.gif"> </td> 
                <td align="left"><a href="javascript:helpMsg('sxzds');" class="b">实训指导</a><td> 
                <td align="right"><img src="<%=request.getContextPath()%>/images/admin/tc.gif"> </td> 
                <td align="left"><a href="<%=request.getContextPath() %>/logout.jsp" class="b">退出系统</a></td> 
                 <td>&nbsp;&nbsp;</td> 
                </tr>
            </table>
          </td>
	</tr>
	<tr>
		<td colspan="8">
			<img src="<%=request.getContextPath()%>/images/admin/student_02.jpg" width="1002" height="21" alt=""></td>
	</tr>
	<tr>
		<td colspan="5" rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_03.jpg" width="365" height="31" alt=""></td>
		<td background="<%=request.getContextPath()%>/images/admin/student_04.jpg"width="573" height="23"  style="font-size:12px">
			<table width="573" height="22" style="font-size:12px">
			<tr>
			<td>欢迎您:${userTName}</td>
			<td align="right">现在时间：<span id="timeSpan"></span></td>
			</tr>
			</table></td>
		<td colspan="2" rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_05.jpg" width="64" height="31" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_06.jpg" width="573" height="8" alt=""></td>
	</tr>
	<tr>
		<td colspan="4">
			<img src="<%=request.getContextPath()%>/images/admin/student_07.jpg" width="233" height="28" alt=""></td>
		<td colspan="3" background="<%=request.getContextPath()%>/images/admin/student_08.jpg" width="764" height="28"  style="font-size:12px">
			<span id="xtwz">班级管理</span></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_09.jpg" width="5" height="28" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="<%=request.getContextPath()%>/images/admin/student_10.jpg" width="200" height="8" alt=""></td>
		<td colspan="4" rowspan="2" width="797" height="439">
		<iframe src="<%=request.getContextPath()%>/class.do?method=getList&page=1" width="100%" height="100%" frameborder="0" name="mainFrame" scrolling="auto"></iframe>
			</td>
		<td rowspan="3">
			<img src="<%=request.getContextPath()%>/images/admin/student_12.jpg" width="5" height="463" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_13.jpg" width="6" height="455" alt=""></td>
		<td background="<%=request.getContextPath()%>/images/admin/student_14.jpg" width="185" height="431">
			<ul class="d_h">
			  <c:if test="${userType==0}">
			  	<li><a href="<%=request.getContextPath()%>/jsgl.do?method=getList&page=1" class="bbb" target="mainFrame">教师管理</a></li>
		      </c:if>
			  <li>
                  <a href="<%=request.getContextPath()%>/class.do?method=getList&page=1" onclick="javaScript:dh.innerHTML='班级管理'" class="bbb" target="mainFrame">班级管理</a>
                  </li>
                  <li>
                  <a href="<%=request.getContextPath()%>/class.do?method=getListForStu&page=1" onclick="javaScript:dh.innerHTML='学生管理'" class="bbb" target="mainFrame">学生管理</a>
                  </li>
				  <li>
                  <a href="<%=request.getContextPath()%>/testSetup.do?method=bjxxList" onclick="javaScript:dh.innerHTML='实验设置'" class="bbb" target="mainFrame">实验设置</a>
                  </li>
                  <li>
                  <a href="<%=request.getContextPath()%>/ggxx.do?method=getList&page=1" onclick="javaScript:dh.innerHTML='公告信息'" class="bbb" target="mainFrame">公告信息</a>
                  </li>
				  <li>
                  <a href="<%=request.getContextPath()%>/sjzdmx.do?method=sjzdList" onclick="javaScript:dh.innerHTML='参数管理'" class="bbb" target="mainFrame">参数管理</a>
                  </li>
                  
                  <li>
                  <a href="<%=request.getContextPath()%>/jsgl.do?method=gotoUpdPaw&pk=${userPk }" onclick="javaScript:dh.innerHTML='资料修改'" class="bbb" target="mainFrame">资料修改</a>
                  </li>
                  <li>
                  <a href="<%=request.getContextPath()%>/stglExam.do?m=tkList&rmMsg=true" onclick="javaScript:dh.innerHTML='题库管理'" class="bbb" target="mainFrame">题库管理</a>
                  </li>
                  <li>
                  <a href="<%=request.getContextPath()%>/sjxxExam.do?m=objList&rmMsg=true" onclick="javaScript:dh.innerHTML='试卷管理'" class="bbb" target="mainFrame">试卷管理</a>
                  </li>
                   <li>
                  <a href="<%=request.getContextPath()%>/ksszExam.do?m=objList&rmMsg=true" onclick="javaScript:dh.innerHTML='考试设置'" class="bbb" target="mainFrame">考试设置</a>
                  </li>
                  <li>
                  <a href="<%=request.getContextPath()%>/djxxExam.do?m=syszList&rmMsg=true" onclick="javaScript:dh.innerHTML='成绩查询'" class="bbb" target="mainFrame">成绩查询</a>
                  </li>
			  </ul>
			</td>
		<td rowspan="2">
			<img src="<%=request.getContextPath()%>/images/admin/student_15.jpg" width="9" height="455" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/student_16.jpg" width="185" height="24" alt=""></td>
		<td colspan="4">
			<img src="<%=request.getContextPath()%>/images/admin/student_17.jpg" width="797" height="24" alt=""></td>
	</tr>
	<tr>
		<td colspan="8" background="<%=request.getContextPath()%>/images/admin/student_18.jpg" width="1002" height="22" align="center">
			<span style="font-size:12px">&copy;版权所有：武汉骏邦信息科技有限公司</span></td>
	</tr>
	<tr>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="6" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="185" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="9" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="33" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="132" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="573" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="59" height="1" alt=""></td>
		<td>
			<img src="<%=request.getContextPath()%>/images/admin/分隔符.gif" width="5" height="1" alt=""></td>
	</tr>
</table>
</body>
</html>