<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp"%>
<%@ include file="/init/dwrjs.jsp"%>
<%@ include file="/init/extjs.jsp"%>
<html>
  <head>
  	<title><bean:message key="system.title"></bean:message></title>
  	<script language="javascript" src="<%=request.getContextPath()%>/ext-2.0.1/examples/window/djxx.js"></script>
  	<script type="text/javascript">
  		function bjSel(curpage){
			var div1 = document.getElementById("div1");
			document.getElementById("show-btn").click();
			var con ="";
			if('${userType}'=='1'){
				con = " and B.jsgl.jxzj="+'${userPk}';
			}
			var counthql = "select count(A) from Bjxx A inner join A.jsbjs B  where 1=1 ";
			var hql = "select A from Bjxx A inner join A.jsbjs B where 1=1 ";
			UserDWR.getPageinfo(counthql+con,hql+con,curpage,10,null,function cd(data){
		    	var list = data.pagedata;
	    		var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\ style=\"word-break:break-all;\">"+
	   				"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='paramType' value='banji'/></td><td>班级编号</td><td>班级名称</td></tr>";
	    		for(var obj in list){
	    			if(!isNaN(obj)){
						msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].bjzj+"\" />"+
							  "<input type='hidden' name='paramValue' value='"+list[obj].bjmc+"'/>"+
								"</td><td>"+list[obj].bjbh+"</td><td>"+list[obj].bjmc+"</td></tr >";					
		    		}
	    		}
	    		if(list.length==0){
	    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无班级信息</td></tr>";
	    		}
	    		msg = msg + "</table>";
	    		msg = msg + pageMsg(data,"bjSel");
	    		div1.innerHTML=msg;
	    	});
		}
		function setValue(){
			var paramType = document.all("paramType");
			var paramPk = document.getElementsByName("paramPk");
			var paramValue = document.getElementsByName("paramValue");
			for(var i=0;i<paramPk.length;i++){
				if(paramPk[i].checked){
					var bjzj = document.all("bjzj");
					var bjmc = document.all("bjmc");
					bjzj.value= paramPk[i].value;
					bjmc.value=paramValue[i].value;
				}
			}
		}
		function pageMsg(data,fn){
    		var msg = "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1);\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+");\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>";
			return msg;
    	}
    	function pageMsg1(data,fn){
    		var msg = "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1);\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+");\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+");\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+");\"/>"+
						"跳至<input type=\"text\" name=\"pa\" class=\"inputsmall\" value=\""+data.curpage+"\" onchange=\"pagedata(this.value,"+data.allpage+")\"/>页"				
					"</td>"+
				"</tr>"+
			"</table>";
			return msg;
    	}
    	function pagedata(page,count){
			var exp = /^\d+$/;
			if(!exp.test(page)){
				alert("页码输入有误!");
			}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
				alert("页数超出范围!");
			}else{
				djSel(page);
			}
		}
		function djSel(curpage){
			var bjzj = document.all("bjzj");
			var expNum = /^[0-9]+$/;
			if(bjzj==null || !expNum.test(bjzj.value)){
				alert("请选择班级信息!");
				return false;
			}else{
				var countHql = "select count(A) from Djxx A where A.xsxx.bjxx.bjzj="+bjzj.value;
				var hql = "select new com.whjbsoft.www.vo.DjInfo(A.djzj,D.sjzj,D.sjmc,B.xsxh,B.xsxm,A.djsj) from Djxx A inner join A.xsxx B inner join B.bjxx C inner join A.sjxx D where C.bjzj="+bjzj.value+" order by A.djsj desc";
				UserDWR.getPageinfo(countHql,hql,curpage,10,null,function res(data){
					var list = data.pagedata;
					var djInfo = document.getElementById("djInfo");
					var msg = "<table id=\"2\" width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"1\" border=\"0\" style=\"word-break:break-all; \">"+
						"<thead><tr><th class=\"th1\">任务名称</th><th class=\"th1\">学生学号</th><th class=\"th1\">学生姓名</th>"+
								"<th class=\"th1\">执行时间</th><th class=\"th1\">操作</th></tr></thead>";
					for(var obj in list){
						if(!isNaN(obj)){
							msg+="<tr align=\"center\"><td>"+list[obj].sjmc+"</td><td>"+list[obj].xsxh+"</td><td>"+list[obj].xsxm+"</td><td>"+list[obj].djsj+"</td><td><a href=\"javascript:sjC("+list[obj].sjzj+","+list[obj].djzj+");\">任务进度</a></td></tr>";
						}
					}
					if(list.length==0){
	    				msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无进度信息! </td></tr>";
	    			}
					msg+="</table>";
					msg+=pageMsg1(data,"djSel");
					document.getElementById("djInfo").innerHTML=msg;
				});
			}
		}
		function sjC(sjzj,djzj){
    	 	UserDWR.getSjxx(sjzj,djzj,function cd(data){
	    	 		var sjDiv = document.getElementById("sjDiv");
	    	 		sjDiv.innerHTML="";
	    	 		var tabE = document.createElement("<table align='center' width='100%' border='0' cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">");
	    	 		var tbodyE = document.createElement("tbody");
	    	 		var sj = new Array();
	    	 		sj[0]="任务编号:";
	    	 		sj[1]=data.sjbh;
	    	 		sj[2]="任务名称:";
	    	 		sj[3]=data.sjmc;
	    	 		var ktlb = new Array();
	    	 		ktlb[0]="步 骤";
	    	 		ktlb[1]="操作名称";
	    	 		ktlb[2]="操作类型";
	    	 		ktlb[3]="操作描述";
	    	 		ktlb[4]="是否答题";
	    	 		var trE = document.createElement("tr");
	    	 		for(var i=0;i<sj.length;i++){
	    	 			var tdE = document.createElement("<td class='td'>");
	    	 			var textNode = document.createTextNode(sj[i]);
	    	 			tdE.appendChild(textNode);
	    	 			tdE.setAttribute("align","center");
	    	 			trE.appendChild(tdE);
	    	 		}    
	    	 		
	    	 		tbodyE.appendChild(trE); 
	    	 		var ktbt = document.createElement("tr");
	    	 		var kttd = document.createElement("<td colspan='4' align='center' class='td'>");    	 		
	    	 		var ktnode = document.createTextNode("操作列表");
	    	 		kttd.appendChild(ktnode);
	    	 		ktbt.appendChild(kttd);
	    	 		tbodyE.appendChild(ktbt);  
	    	 		var ktbt1 = document.createElement("tr");
	    	 		var kttd1 = document.createElement("<td colspan='4' align='center' class='td'>");
	    	 		var tabE1 = document.createElement("<table align='center' class='indextable' width='100%'  border='0' cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">");
	    	 		var tbodyE1 = document.createElement("tbody");
	    	 		var tr1 = document.createElement("tr");
	    	 		for(var i=0;i<ktlb.length;i++){
	    	 			var td1 = document.createElement("<td align='center' class='td'>");
	    	 			var tdNode1 = document.createTextNode(ktlb[i]);
	    	 			td1.appendChild(tdNode1);
	    	 			tr1.appendChild(td1);
	    	 		}
	    	 		tbodyE1.appendChild(tr1);
	    	 		var ktlist = data.list;
	    	 		var sjhpvo = data.sjhp;
	    	 		for(var obj in ktlist){
						if(!isNaN(obj)){
							var tr2 = document.createElement("tr");
	    	 				var td1 = document.createElement("<td align='center' class='td'>");
	    	 				var tdNode1 = document.createTextNode(parseInt(obj)+1);
	    	 				td1.appendChild(tdNode1);
	    	 				var td2 = document.createElement("<td align='center' class='td'>");
	    	 				var tdNode2 = document.createTextNode(ktlist[obj].stmc);
	    	 				td2.appendChild(tdNode2);
	    	 				var td3 = document.createElement("<td align='center' class='td'>");
	    	 				var tdNode3 = document.createTextNode(ktlist[obj].stlx);
	    	 				td3.appendChild(tdNode3);    	 				
	    	 				var td4 = document.createElement("<td align='center' class='td'>");
	    	 				if(ktlist[obj].yksl!=null && !isNaN(ktlist[obj].yksl)&&ktlist[obj].yksl!=0){
	    	 					var tdNode4 = document.createTextNode("移库数量："+ktlist[obj].yksl);
	    	 					td4.appendChild(tdNode4);
	    	 				}else if(ktlist[obj].stbh==118){
	    	 						var hptab = document.createElement("<table id='showhp' align='center' class='indextable' width='100%'  border='0' cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">");
	    	 						var hpbody = document.createElement("tbody");
	    	 						var hptr1 = document.createElement("tr");    	 						
	    	 						var hptd1 = document.createElement("<td align='center' class='td'>");
	    	 						var hptdNode1 = document.createTextNode("货品名称");
	    	 						var hptd2 = document.createElement("<td align='center' class='td'>"); 
	    	 						var hptdNode2 = document.createTextNode("采购数量");
	    	 						hptd1.appendChild(hptdNode1);
	    	 						hptd2.appendChild(hptdNode2);
	    	 						hptr1.appendChild(hptd1);
	    	 						hptr1.appendChild(hptd2);
	    	 						hpbody.appendChild(hptr1);
	    	 						for(var i in sjhpvo){
	    	 							if(!isNaN(i)){
		    	 							var hptr = document.createElement("tr");
		    	 							var hptd3 = document.createElement("<td align='center' class='td'>");
			    	 						var hptdNode3 = document.createTextNode(sjhpvo[i].hpmc);
			    	 						var hptd4 = document.createElement("<td align='center' class='td'>"); 
			    	 						var hptdNode4 = document.createTextNode(sjhpvo[i].hpsl);
			    	 						hptd3.appendChild(hptdNode3);
			    	 						hptd4.appendChild(hptdNode4);
			    	 						hptr.appendChild(hptd3);
			    	 						hptr.appendChild(hptd4);
			    	 						hpbody.appendChild(hptr);
	    	 							}
	    	 						}
	    	 						hptab.appendChild(hpbody);
		    	 					td4.appendChild(hptab);
	    	 					}else{
		    	 					if(ktlist[obj].ktms!=null){
			    	 					var tdNode4 = document.createTextNode(ktlist[obj].ktms);
			    	 					td4.appendChild(tdNode4);
		    	 					}else {
		    	 						var tdNode4 = document.createTextNode("");
			    	 					td4.appendChild(tdNode4);
		    	 					}
	    	 					}
	    	 				var td5 = document.createElement("<td align='center' class='td'>");
	    	 				var span = document.createElement("<span style='color=red;'>");
	    	 				var duihao = document.createTextNode("");
	    	 				if(ktlist[obj].sfdt==1){
	    	 					duihao = document.createTextNode("√");
	    	 				}
	    	 				span.appendChild(duihao);
	    	 				td5.appendChild(span);
	    	 				tr2.appendChild(td1);
	    	 				tr2.appendChild(td2);
	    	 				tr2.appendChild(td3);
	    	 				tr2.appendChild(td4);
	    	 				tr2.appendChild(td5);
	    	 				tbodyE1.appendChild(tr2);
						}    	 			
	    	 		}
	    	 		tabE1.appendChild(tbodyE1);
	    	 		kttd1.appendChild(tabE1);
	    	 		ktbt1.appendChild(kttd1);
	    	 		tbodyE.appendChild(ktbt1);
	    	 		tabE.appendChild(tbodyE);
	    	 		sjDiv.appendChild(tabE);
	    	 		document.getElementById("showsjxx").click();
	    	 });
    	 }
    	 
  	</script>
  </head>
  
  <body> 	 
    <html:form action="/taskCircs.do?method=objList" method="post">
			<table id="1" width="100%" align="center" cellpadding="0"
				cellspacing="0" border="0" style="word-break:break-all;">
				<tr>
					<td align="right" width="40%"><input type="hidden" id="showsjxx"/>
						<b>选择班级信息：</b>
					</td><td>
					<td align="left" width="20%">
						<input type="text" name="bjmc" class="input" readonly="readonly" onclick="bjSel(1);" value="${bjmc }"/>
						<input type="hidden" name="bjzj" />
						<input type="hidden" id="show-btn" />
					</td>					
					<td align="left">
						<input type="button" name="su" value="查 询" class="inputbutton" onclick="djSel(1);"/>
					</td>
				</tr>
			</table>
			<div id="djInfo">
			<table id="2" width="100%" align="center" cellpadding="0"
				cellspacing="1" border="0" style="word-break:break-all; ">
				<thead>
					<tr>
						<th class="th1">
							任务名称
						</th>
						<th class="th1">
							学生学号
						</th>
						<th class="th1">
							学生姓名
						</th>
						<th class="th1">
							执行时间
						</th>						
						<th class="th1">
							操作
						</th>
					</tr>
				</thead>
				<tr>
					<td colspan="5" align="center">
						暂无进度信息!
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
						跳至<input type="text" name="pa" class="inputsmall" value="${pageinfo.curpage }"/>页
					</td>
				</tr>
			</table>
			</div>
		</html:form>
		<div id="dj-win" class="x-hidden">
		    <div id="dj-tabs">
		    	<div id="sjDiv"></div>
		    </div>
		</div>
		<div id="hello-win" class="x-hidden">
			<div  id="hello-tabs">
				<div class="tanchuang" id="div1"></div>
			</div>
		</div>
		
  </body>
</html>
