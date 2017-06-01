<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>

<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title> 
    <link rel="stylesheet" type="text/css" href="./ext-2.0.1/resources/css/ext-all.css" />
	<script type="text/javascript" src="./ext-2.0.1/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="./ext-2.0.1/ext-all.js"></script>
    <script type="text/javascript">    	
    var win;
	function newWin()
	{
		if(!win){
			var html = document.getElementById("bjqxfp").innerHTML;
			win=new Ext.Window({
			title:"班级权限分配",
			width:280,
			height:170,
			closeAction:'hide',
			html:html,
			maximizable:false
			}
			);
		}		
		win.show();
	}
	function queryStu(){
		var fzrs = document.getElementsByName("fzrs");
		for(var i=0;i<fzrs.length;i++){
			if(fzrs[i].checked){
				Ext.MessageBox.buttonText.yes = "确 定";
				Ext.MessageBox.buttonText.no = "取 消"; 
				var temp = fzrs[i].value;
				UserDWR.getXsxxCount(${curClassPk},function cd(data){
					Ext.MessageBox.confirm("请确认","班级人员总数:"+data+"<br/>实验组每组人数:"+parseInt(temp)+"<br/>可分组数："+parseInt(data/parseInt(temp))+"<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空余人数："+(data%parseInt(temp))+"<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否开始分配?",function(button,text){
						if(button=="yes"){
							window.location.href="./testSetup.do?method=autoSetup&manNum="+temp;
						}
					}); 		
				});
			}
		}
		win.hide();	
	}	
	function pagedata(page,count){
		var exp = /^\d+$/;
		if(!exp.test(page)){
			alert("页码输入有误!");
		}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
			alert("页数超出范围!");
		}else{
			window.location.href="./testSetup.do?method=groupList&page="+page;
		}
	}
	function resetRule(){
		var ids = document.getElementsByName("pk");
		var flag = false;
		for(var i = 0;i<ids.length;i++){
			if(ids[i].checked){
				flag = true;
				break;
			}
		}
		if(!flag){
			alert("请选择需要交换角色的实验组!");
			return false;
		}
		if(confirm("确定要交换角色吗？")){
			var f = document.forms[0];
			f.action = "./testSetup.do?method=changeSetup";
			f.method="POST";
			f.submit();
		}
	}
	function handGroup(){
		window.location.href="./testSetup.do?method=xsxxLeaveList";
	}
	function back(){
		window.location.href="./testSetup.do?method=bjxxList";
	}
	function selAll(){ 
	    var o=document.getElementsByName("pk"); 
	     for(i=0;i<o.length;i++) {
		 	if(!o[i].disabled){
		       o[i].checked=event.srcElement.checked; 
		     }
		 }
	}
    </script> 
    <c:if test="${msg!=null }">
    	<script type="text/javascript">
    		alert('${msg}');
    	</script>
    </c:if>
  </head>
  
  <body>
  <html:form action="/testSetup.do?method=groupList" method="post">
    <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    	<thead>
	    	<tr>
	    		<th style="text-align: center;">全选<input type="checkbox" id="delpk" onClick="return selAll();"></th>
	    		<th style="text-align: center;">实 验 组</th>
	    		<th style="text-align: center;">所属班级</th>
	    		<th style="text-align: center;">组员人数</th>
	    		<th style="text-align: center;">角色设置(手动)</th>
	    	</tr>
    	</thead>
    	<logic:notEmpty name="pageinfo" property="pagedata">
    	<logic:iterate id="obj" name="pageinfo" property="pagedata">
		   	<tr align="center">
		   		<td><input type="checkbox" name="pk" value="${obj[0] }" <c:if test="${obj[2]<=1 }">disabled="disabled"</c:if>/></td>
		   		<td>
		   		实验组${obj[0]}
		   		</td>
		   		<td>${obj[1]}</td>
		   		<td>
		   		${obj[2]}人
		   		</td>
		   		<td><a href="./testSetup.do?method=xsxxList&groupPk=${obj[0]}">角色设置</a></td>
		   	</tr>
		</logic:iterate>
    	</logic:notEmpty>
    	<logic:empty name="pageinfo" property="pagedata">
    		<tr>
	    		<td colspan="7" align="center">
	    			暂无实验组信息!
	    		</td>
	    	</tr>
    	</logic:empty>
    	<tr>
    		<td colspan="7" align="center">
    			<input type="button" value="分配权限" class="inputbutton" id="btn" onclick="newWin();"/>
	    		<input type="button" value="交换角色" class="inputbutton" onclick="resetRule();"/>
	    		<input type="button" value="手动分组" class="inputbutton" onclick="handGroup();"/>
    			<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    		</td>
    	</tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页 &nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
				<input type="button" name="first" class="inputbutton3"	onClick="pagedata(1,${pageinfo.allpage });"/>
				<input type="button" name="before" class="inputbutton1" onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });"/>
				<input type="button" name="next" class="inputbutton2" onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });"/>
				<input type="button" name="last" class="inputbutton4" onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });"/>
				跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }" onchange="pagedata(this.value,${pageinfo.allpage });"/>页
			</td>
		</tr>
	</table>
    </html:form>
    <div id="bjqxfp" style="display: none;">
    	<div> 
    		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    			<tr>
    				<td style="background-color: #E6F3FF;">
    				&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="fzrs" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;单人实验模式<br/>
    				</td>
    			</tr>
    			<tr>
    				<td style="background-color: #E6F3FF;">
    				&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="fzrs" value="6"/>&nbsp;&nbsp;&nbsp;&nbsp;团队实验模式<br/>
    				</td>
    			</tr>
    			<tr>
    				<td align="center" style="background-color: #E6F3FF;">
    				<input type="button" name="sure" value="确 定" class="inputbutton" onclick="javascript:queryStu();"/>
    				<input type="button" name="cancle" value="取 消" class="inputbutton" onclick="javascript:win.hide();"/>
    				</td>
    			</tr>
    		</table> 
    	</div>
    </div>
  </body>
</html>
