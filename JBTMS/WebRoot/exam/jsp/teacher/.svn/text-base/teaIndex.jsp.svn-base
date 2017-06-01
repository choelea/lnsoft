<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %> 
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/fn.tld" prefix="fn" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	
	.MM {	width: 182px;
		margin: 0px;
		padding: 0px;
		left: 0px;
		top: 0px;
		right: 0px;
		bottom: 0px;
		clip: rect(0px,0px,0px,0px);
	}
	.content {	width: 182px;
		height: 26px;
	}
	.content{
		width: 182px;
		height: 26px;
		
	}
	.MM ul {
		list-style-type: none;
		margin: 0px;
		padding: 0px;
		display: block;
	}
	.MM li {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		line-height: 26px;
		color: #333333;
		list-style-type: none;
		display: block;
		text-decoration: none;
		height: 26px;
		width: 182px;
		padding-left: 0px;
	}
	.MM {
		width: 182px;
		margin: 0px;
		padding: 0px;
		left: 0px;
		top: 0px;
		right: 0px;
		bottom: 0px;
		clip: rect(0px,0px,0px,0px);
	}
	.MM a:link {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		line-height: 26px;
		color: #333333;
		background-image: url(./../../images/menu_bg1.gif);
		background-repeat: no-repeat;
		height: 35px;
		width: 182px;
		display: block;
		text-align: center;
		margin: 0px;
		padding: 0px;
		overflow: hidden;
		text-decoration: none;
	}
	.MM a:visited {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		line-height: 26px;
		color: #333333;
		background-image: url(./../../images/menu_bg1.gif);
		background-repeat: no-repeat;
		display: block;
		text-align: center;
		margin: 0px;
		padding: 0px;
		height: 35px;
		width: 182px;
		text-decoration: none;
	}
	.MM a:active {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		line-height: 26px;
		color: #333333;
		background-image: url(./../../images/menu_bg1.gif);
		background-repeat: no-repeat;
		height: 35px;
		width: 182px;
		display: block;
		text-align: center;
		margin: 0px;
		padding: 0px;
		overflow: hidden;
		text-decoration: none;
	}
	.MM a:hover {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		line-height: 26px;
		font-weight: bold;
		color: #006600;
		background-image: url(./../../images/menu_bg2.gif);
		background-repeat: no-repeat;
		text-align: center;
		display: block;
		margin: 0px;
		padding: 0px;
		height: 35px;
		width: 182px;
		text-decoration: none;
	}
	body,td,th {
		font-size: 12px;
	}
	-->
	.kuang {
		border-top-width: 0px;
		border-right-width: 0px;
		border-bottom-width: 0px;
		border-left-width: 0px;
		border-top-style: solid;
		background-image: url(./../../images/chax_06.gif);
		height: 17px;
		background-position: bottom;
		color: #006699;
		font-weight: bold;
		font-family: "宋体";
	}
	.STYLE5 {color: #666666; font-weight: bold; }
	.bk {
		border-top-width: 1px;
		border-right-width: 1px;
		border-bottom-width: 1px;
		border-left-width: 1px;
		border-top-style: solid;
		border-right-style: solid;
		border-bottom-style: solid;
		border-left-style: solid;
		border-top-color: #CCCCCC;
		border-right-color: #CCCCCC;
		border-bottom-color: #E1E1E1;
		border-left-color: #CCCCCC;
	}
	-->
	</style>
    <script type="text/javascript">
    	function IsAdmin(){
    		var ut = '${userType}';
    		if(ut!='0'){
    			alert("您没有管理员权限!");
    			return false;
    		}
    		return true;
    	}
    	function helpMsg(){
			window.open("./../../help/jszds.html","Help","width="+window.screen.availwidth+",height="+window.screen.availheight+",top=0,left=0,menubar=no,location=no,directories=no,toolbar=false,resizable=yes,scrollbars=no");
		}
    </script>
  </head>
  
  <body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="90"><table id="__01" width="100%" height="90" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="348"><img src="./../../images/guanli_01_01.gif" width="348" height="90" alt="" /></td>
        <td background="./../../images/guanli_01_02.gif">&nbsp;</td>
        <td width="565"><img src="./../../images/guanli_01_03.gif" alt="" width="565" height="90" border="0" usemap="#Map" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="204" valign="top" bgcolor="#F0F0F0"><table id="__01" width="204" height="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="43"><img src="./../../images/guanli_02_01.gif" width="204" height="43" alt="" /></td>
          </tr>
          <tr>
            <td align="center" valign="top" background="./../../images/guanli_02_03.gif">
              <div class="content">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
    			<ul class="MM">
                 	<c:if test="${userType==0 }">
    				<li><a href="../../jsgl.do?m=objList&rmMsg=true" target="mainFrame" onclick="return IsAdmin();">教师管理</a></li>
    				</c:if>
    				<c:if test="${userType!=0 }">
    				<li><a href="../../jsgl.do?m=premsg" target="mainFrame">个人资料</a></li>
    				</c:if>
    				<li><a href="../../bjgl.do?m=objList&rmMsg=true" target="mainFrame">班级管理</a></li>
    				<li><a href="../../xsxx.do?m=claList&rmMsg=true" target="mainFrame">学生管理</a></li>
    				<li><a href="../../stgl.do?m=tkList&rmMsg=true" target="mainFrame">试题管理</a></li>
    				<li><a href="../../sjxx.do?m=objList&rmMsg=true" target="mainFrame">试卷管理</a></li>
    				<!-- 
    				<li><a href="../../stgl.do?m=objList&rmMsg=true" target="mainFrame">答案维护</li>
    				 --> 
    				<li><a href="../../kssz.do?m=objList&rmMsg=true" target="mainFrame">考试设置</a></li>   				
    				<li><a href="../../djxxExam.do?m=syszList&rmMsg=true" target="mainFrame">成绩管理</a></li>
                </ul>
              </div>
              
              </td>
          </tr>
          <tr>
            <td height="22"><img src="./../../images/guanli_02_05.gif" width="204" height="22" alt="" /></td>
          </tr>
        </table></td>
        <td width="8" bgcolor="#F0F0F0"><img src="./../../images/guanli_03.gif" width="8" height="484" alt="" /></td>
        <td valign="top">
        <iframe src="../../bjgl.do?m=objList&rmMsg=true" name="mainFrame" id="mainFrame" frameborder="0" align="middle" width="100%" height="100%"></iframe>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#EFEFEF">Copyright&copy; 版权所有：武汉骏邦科技信息有限公司</td>
  </tr>
</table>
<map name="Map" id="Map">
<area shape="rect" coords="416,66,475,82" href="javascript:helpMsg();" />
<area shape="rect" coords="501,64,557,86" href="./../../logout.jsp" />
</map>
  </body>
</html>
