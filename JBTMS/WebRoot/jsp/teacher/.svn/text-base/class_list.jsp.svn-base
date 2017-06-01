<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/init/init.jsp"%>
<html>
	<head>
		<title><bean:message key="system.title" /></title>
		<script type="text/javascript">
    function ToAdd(){
    	window.location.href="<%=request.getContextPath()%>/class.do?method=goAdd";
    }
    function selAll(){ 
     o=document.getElementsByName("pk"); 
     for(i=0;i<o.length;i++) 
     	if(o[i].disabled==false){
     		 o[i].checked=event.srcElement.checked; 
     	} 
	}
	function ToDel() { 
		  var temp=document.getElementsByName("pk"); 
		  var count=0;
		  for (i=0;i<temp.length;i++){ 
		  //遍历Radio 
		    if(temp[i].checked){     	
		    	 break;
		     }  
		     count++;   
		  } 
	  	if(count==temp.length){
			alert("至少选择一条记录！");
			return false;
		}
		if(!confirm("确定要删除吗？")){
			return false;
		}
	} 
	function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				window.location.href="<%=request.getContextPath()%>/class.do?method=getList&page="+page;
			}
	}
	</script>
		<c:if test="${!empty msg}">
			<script type="text/javascript">
	     alert("${msg }");
		</script>
		</c:if>
	</head>
	<body>
		<html:form action="/class.do?method=delObject" method="post">
			<table align="center" width="100%" border="0" cellpadding="0"
				cellspacing="1" style="word-break:break-all;">
				<tr align="center" height="30">
					<th>
						<input type="checkbox" id="delpk" onClick="return selAll();">
						全选
					</th>
					<th>
						班级编号
					</th>
					<th>
						班级名称
					</th>
					<th>
						代课教师
					</th>
					<th>
						修改
					</th>
				</tr>
				<c:forEach var="obj" items="${pageinfo.pagedata }">
					<tr align="center" height="25">
						<td>
							<input type="checkbox" name="pk" value="${obj.bjzj }" />
						</td>
						<td>
							<a href="<%=request.getContextPath()%>/class.do?method=viewObject&pk=${obj.bjzj}">${obj.bjbh}</a>
						</td>
						<td>
							${obj.bjmc }
						</td>
						<td>
							${obj.jsmc }
						</td>
						<td>
							<a
								href="<%=request.getContextPath()%>/class.do?method=goUpdate&pk=${obj.bjzj}">
								修改 </a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${empty pageinfo.pagedata }">
					<tr align="center" height="30">
						<td colspan="9">
							暂无班级信息!
						</td>
					</tr>
				</c:if>
				<tr align="center" height="30">
					<td colspan="9">
						<input type="button" name="add" class="inputbutton" value="添 加"
							onClick="ToAdd();">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" name="add" class="inputbutton" value="删 除"
							onClick="return ToDel();">
					</td>
				</tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="td1">
						共 [${pageinfo.allpage }] 页&nbsp;&nbsp;当前第 [${pageinfo.curpage }] 页
						&nbsp;&nbsp;每页 [${pageinfo.pagerecord }] 条记录&nbsp;&nbsp;
						<input type="button" name="first" class="inputbutton3"
							onClick="pagedata(1,${pageinfo.allpage });" />
						<input type="button" name="before" class="inputbutton1"
							onClick="pagedata(${pageinfo.previouspage },${pageinfo.allpage });" />
						<input type="button" name="next" class="inputbutton2"
							onClick="pagedata(${pageinfo.nextpage },${pageinfo.allpage });" />
						<input type="button" name="last" class="inputbutton4"
							onclick="pagedata(${pageinfo.allpage },${pageinfo.allpage });" />
						跳至
						<input type="text" name="pa" class="inputsmall"
							value="${pageinfo.curpage }"
							onchange="pagedata(this.value,${pageinfo.allpage });" />
						页
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>


