<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"></bean:message></title>
    <link rel="stylesheet" type="text/css" href="./css/newdate.css" />
    <script type="text/javascript">
    	var count = 0;
		function IsNull(){
			var ddrq = $("vo.ddrq");
			var tdsj = $("vo.tdsj");
			var ckkfzj = $("vo.ckkfzj");
			var rkkfzj = $("vo.rkkfzj");
			if(ddrq.value==""){
				alert("请输入计划移库日期!");
				return false;
			}
			if(checkDate(ddrq.value,tdsj.value)){
				alert("计划日期输入有误!");
				return false;
			}
			if(ckkfzj.value==""){
				alert("请选择源库房信息!");
				return false;
			}
			if(rkkfzj.value==""){
				alert("请选择目标库房信息!");
				return false;
			}
			var tbody = document.getElementById("mxId");
			var trEs = tbody.rows;
			var len = trEs.length;
			if(len<=1){
				alert("请设定移库明细信息!");
				return false;
			}
			for(var i=1;i<len;i++){
				var ycwzj = document.all("list["+trEs[i].id+"].ycw.cwzj");
				var mbcwzj = document.all("list["+trEs[i].id+"].mbcw.cwzj");
				var ykhpsl = document.all("list["+trEs[i].id+"].ykhpsl");
				var ykshsl = document.all("list["+trEs[i].id+"].ykshsl");
				if(ycwzj.value==""){
					alert("请选择源储位信息!");
					return false;
				}
				if(mbcwzj.value==""){
					alert("请选择目标储位信息!");
					return false;
				}
				if(ycwzj.value==mbcwzj.value){
					alert("源储位和目标储位不能为同一储位!");
					return false;
				}
				if(ykhpsl.value==""){
					alert("请输入移库货品数量!");
					return false;
				}
				if(ykshsl.value==""){
					alert("请输入移库货品数量!");
					return false;
				}
				if(isNaN(ykhpsl.value)){
					alert("移库货品数量输入有误!");
					return false;
				}
				if(isNaN(ykshsl.value)){
					alert("移库货品数量输入有误!");
					return false;
				}
				if((parseFloat(ykhpsl.value)+parseFloat(ykshsl.value))<=0){
					alert("移库货品数量输入有误!");
					return false;
				}
				for(var j=i+1;j<len;j++){
					var ycw = document.all("list["+trEs[j].id+"].ycw.cwzj");
					var mbcw = document.all("list["+trEs[j].id+"].mbcw.cwzj");
					if(ycw.value==ycwzj.value){
						alert("源储位存在重复记录!");
						return false;
					}
					if(mbcw.value==mbcwzj.value){
						alert("目标储位存在重复记录!");
						return false;
					}
				}
			}
			return true;
		}
		function checkDate(date1,date2){
			if(date1.length>10){
				date1=date1.substring(0,10);
			}
			if(date2.length>10){
				date2=date2.substring(0,10);
			}
			var d1 = date1.split("-");
			var d2 = date2.split("-");
			var sdate = new Date(d1[0],d1[1]-1,d1[2]);
			var edate = new Date(d2[0],d2[1]-1,d2[2]);
			return sdate<edate;
		}
		function pageKfdata(curpage,kflx){
			var countHql = "select count(A) from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			var hql = "from Kfxx A where A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
			UserDWR.getPageinfo(countHql, hql, curpage,10,"正常",function(data){
				var list = data.pagedata;
				var div1 = document.getElementById("div1");    		
				var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
						"<tr align=\"center\" height=\"30\">"+
					"<td>选择<input type='hidden' name='pagemsglx' value='kf"+kflx+"'></td><td>库房编号</td><td>库房名称</td></tr>";
			 		for(var obj in list){
			 			if(!isNaN(obj)){
					msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].kfzj+"\" />"+
						  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].kfmc+"\">"+
						  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].kflx+"\">"+
						  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].ssjg+"\">"+
						  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].kfgly+"\">"+
							"</td><td>"+list[obj].kfbh+"</td><td>"+list[obj].kfmc+"</td></tr >";
			  		}
			 		}
			 		if(list.length==0){
			 			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无库房信息</td></tr>";
			 		}
			 		msg = msg + "</table>";
			 		msg = msg + pageMsg(data,"pageKfdata",kflx);
			 		div1.innerHTML=msg;
			 		document.getElementById("show-btn").click();
			});
		}
		function pageMKfdata(curpage,kflx){
			var ykfssjg = $("ykfssjg");
			var ykflx = $("ykflx");
			if(ykfssjg.value=="" || ykflx.value==""){
				alert("请选择源库房信息!");
				return false;
			}else{
				var paramArr = new Array();
				paramArr[0]=ykflx.value;
				paramArr[1]=ykfssjg.value;
				paramArr[2]="正常";
		 		var countHql = "select count(A) from Kfxx A where A.kflx=? and A.ssjg=? and A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
		   		var hql = "from Kfxx A where A.kflx=? and A.ssjg=? and A.kfzt=? and A.ssxs = ${userPk} and A.sssysz = ${userSyszzj}";
		   		UserDWR.getPageinfo(countHql, hql, curpage,10,paramArr,function(data){
		   			var list = data.pagedata;
		    		var div1 = document.getElementById("div1");    		
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='kf"+kflx+"'></td><td>库房编号</td><td>库房名称</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].kfzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].kfmc+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].kflx+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].ssjg+"\">"+
								  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].kfgly+"\">"+
									"</td><td>"+list[obj].kfbh+"</td><td>"+list[obj].kfmc+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无库房信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"pageMKfdata",kflx);
		    		div1.innerHTML=msg;
		    		document.getElementById("show-btn").click();
		   		});
		  	}
		 }
		function yqwPagedata(curpage,trId){
			var ckkfzj = $("vo.ckkfzj");
			if(ckkfzj.value==""){
				alert("请选择源库房信息!");
			}else{
				var countHql = "select count(A) from Qwxx A where A.kfxx.kfzj = "+ckkfzj.value;
				var hql = "from Qwxx A where A.kfxx.kfzj = "+ckkfzj.value;
				UserDWR.getPageinfo(countHql, hql, curpage,10,null,function(data){
					var list = data.pagedata;
		    		var div1 = document.getElementById("div1");    		
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='yqw'><input type='hidden' name='dqhh' value='"+trId+"'></td><td>区位编号</td><td>区位名称</td><td>存储类型</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].qwzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].qwbh+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].qwmc+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].cclx+"\">"+
									"</td><td>"+list[obj].qwbh+"</td><td>"+list[obj].qwmc+"</td><td>"+list[obj].cclx+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无区位信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"yqwPagedata",trId);
		    		div1.innerHTML=msg;
					document.getElementById("show-btn").click();
				});
			}	
		}
		function ycwPagedata(curpage,trId){
			var yqwzj=document.all("list["+trId+"].yqw.qwzj");
			if(yqwzj.value==""){
				alert("请选择源区位信息!");
			}else{
				var countHql = "select count(A) from Cwxx A where A.cwsx >0 and A.hpbm is not null and A.qwxx.qwzj = "+yqwzj.value;
				var hql = "from Cwxx A where A.cwsx >0 and A.hpbm is not null and A.qwxx.qwzj = "+yqwzj.value;
				UserDWR.getPageinfo(countHql, hql, curpage,10,null,function(data){
					var list = data.pagedata;
		    		var div1 = document.getElementById("div1");    		
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='ycw'><input type='hidden' name='dqhh' value='"+trId+"'></td><td>储位编号</td><td>货品名称</td><td>储位上限</td><td>当前数量</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].cwzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].cwbh+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].cwsx+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].hpbm+"\">"+
								  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].hgsl+"\">"+
								  "<input type=\"hidden\" name=\"paramValue4\" value=\""+list[obj].shsl+"\">"+
									"</td><td>"+list[obj].cwbh+"</td><td>"+list[obj].hpmc+"</td><td>"+list[obj].cwsx+"</td><td>"+(parseFloat(list[obj].hgsl)+parseFloat(list[obj].shsl))+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无符合条件储位信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"ycwPagedata",trId);
		    		div1.innerHTML=msg;
					document.getElementById("show-btn").click();
				});
			}
		}
		function mbqwPagedata(curpage,trId){
			var rkkfzj = $("vo.rkkfzj");
			var yqwlx = document.all("list["+trId+"].yqw.cclx");
			if(rkkfzj.value==""){
				alert("请选择目标库房信息!");
				return false;
			}else if(yqwlx.value==""){
				alert("请选择源区位信息!");
				return false;
			}else{
				var countHql = "select count(A) from Qwxx A where A.cclx = ? and A.kfxx.kfzj = "+rkkfzj.value;
				var hql = "from Qwxx A where A.cclx = ? and A.kfxx.kfzj = "+rkkfzj.value;
				UserDWR.getPageinfo(countHql, hql, curpage,10,yqwlx.value,function(data){
					var list = data.pagedata;
		    		var div1 = document.getElementById("div1");	
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='mbqw'><input type='hidden' name='dqhh' value='"+trId+"'></td><td>区位编号</td><td>区位名称</td><td>存储类型</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].qwzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].qwbh+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].qwmc+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].cclx+"\">"+
									"</td><td>"+list[obj].qwbh+"</td><td>"+list[obj].qwmc+"</td><td>"+list[obj].cclx+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无区位信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"mbqwPagedata",trId);
		    		div1.innerHTML=msg;
					document.getElementById("show-btn").click();
				});
			}
		}
		function mbcwPagedata(curpage,trId){
			var mbqwzj=document.all("list["+trId+"].mbqw.qwzj");
			var yhpbm=document.all("list["+trId+"].ycw.hpbm");
			if(mbqwzj.value==""){
				alert("请选择源区位信息!");
			}else if(yhpbm.value==""){
				alert("请选择源储位信息!");
			}else{
				var countHql = "select count(A) from Cwxx A where A.cwsx >0 and A.hpbm = ? and A.qwxx.qwzj = "+mbqwzj.value;
				var hql = "from Cwxx A where A.cwsx >0 and A.hpbm = ? and A.qwxx.qwzj = "+mbqwzj.value;
				UserDWR.getPageinfo(countHql, hql, curpage,10,yhpbm.value,function(data){
					var list = data.pagedata;
		    		var div1 = document.getElementById("div1");
		    		div1.innerHTML="";
					var msg = "<table border=\"0\" width=\"100%\" cellspacing='1' cellpadding='0' style=\"word-break:break-all;\">"+
		   				"<tr align=\"center\" height=\"30\">"+
						"<td>选择<input type='hidden' name='pagemsglx' value='mbcw'><input type='hidden' name='dqhh' value='"+trId+"'></td><td>储位编号</td><td>货品名称</td><td>储位上限</td><td>当前数量</td></tr>";
		    		for(var obj in list){
		    			if(!isNaN(obj)){
							msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].cwzj+"\" />"+
								  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].cwbh+"\">"+
								  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].cwsx+"\">"+
								  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].hpbm+"\">"+
								  "<input type=\"hidden\" name=\"paramValue3\" value=\""+list[obj].hgsl+"\">"+
								  "<input type=\"hidden\" name=\"paramValue4\" value=\""+list[obj].shsl+"\">"+
									"</td><td>"+list[obj].cwbh+"</td><td>"+list[obj].hpmc+"</td><td>"+list[obj].cwsx+"</td><td>"+(parseFloat(list[obj].hgsl)+parseFloat(list[obj].shsl))+"</td></tr >";
			    		}
		    		}
		    		if(list.length==0){
		    			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无符合条件储位信息</td></tr>";
		    		}
		    		msg = msg + "</table>";
		    		msg = msg + pageMsg(data,"mbcwPagedata",trId);
		    		div1.innerHTML=msg;
					document.getElementById("show-btn").click();
				});
			}
		}
		function back(){
			window.location.href="./ykdd.do?method=objList&page=1";
		}
		function setValue(){
			var paramPk = document.getElementsByName("paramPk");
			var paramValue = document.getElementsByName("paramValue");
			var pagemsglx = document.all("pagemsglx");
			
			for(var i=0;i<paramPk.length;i++){
				if(paramPk[i].checked){
					if(pagemsglx.value=='kfck'){
						var paramValue1 = document.getElementsByName("paramValue1");
						var paramValue2 = document.getElementsByName("paramValue2");
						var paramValue3 = document.getElementsByName("paramValue3");
		   				var ykfssjg = $("ykfssjg");
	  					var ykflx = $("ykflx");
	  					var ckkfzj = $("vo.ckkfzj");
	  					var ckkfmc = $("vo.ckkfmc");
	  					var ckczr = $("vo.ckczr");
	  					ykfssjg.value=paramValue2[i].value;
	  					ykflx.value=paramValue1[i].value;
	  					ckkfzj.value=paramPk[i].value;
	  					ckkfmc.value=paramValue[i].value;
	  					ckczr.value=paramValue3[i].value;
	  					var rkkfzj = $("vo.rkkfzj");
	  					var rkkfmc = $("vo.rkkfmc");
	  					var rkczr = $("vo.rkczr");
	  					rkkfzj.value="";
	  					rkkfmc.value="";
	  					rkczr.value="";
	  					var tbody = document.getElementById("mxId");
	  					var trEs = tbody.rows;
	  					if(trEs.length>1){
		  					var trE = trEs[0].nextSibling;
		  					while(trE!=null){
		  						var temp = trE.nextSibling;
		  						tbody.removeChild(trE);
		  						trE = temp;
		  					}
	  					}
	  					break;
					}else if("kfrk"==pagemsglx.value){
						var paramValue3 = document.getElementsByName("paramValue3");
						var rkkfzj = $("vo.rkkfzj");
	  					var rkkfmc = $("vo.rkkfmc");
	  					var rkczr = $("vo.rkczr");
						rkkfzj.value=paramPk[i].value;
	  					rkkfmc.value=paramValue[i].value;
	  					rkczr.value=paramValue3[i].value;
	  					var tbody = document.getElementById("mxId");
	  					var trEs = tbody.rows;
	  					if(trEs.length>1){
		  					var trE = trEs[0].nextSibling;
		  					while(trE!=null){
		  						var temp = trE.nextSibling;
		  						tbody.removeChild(trE);
		  						trE = temp;
		  					}
	  					}
	  					break;
					}else if("yqw"==pagemsglx.value){
						var paramValue1 = document.getElementsByName("paramValue1");
						var paramValue2 = document.getElementsByName("paramValue2");
						var dqhh = document.all("dqhh");
						var yqwzj=document.all("list["+dqhh.value+"].yqw.qwzj");
						var yqwmc=document.all("list["+dqhh.value+"].yqw.qwmc");
						var yqwcclx=document.all("list["+dqhh.value+"].yqw.cclx");
						yqwzj.value=paramPk[i].value;
						yqwmc.value=paramValue1[i].value;
						yqwcclx.value=paramValue2[i].value;
						var ycwzj=document.all("list["+dqhh.value+"].ycw.cwzj");
						var ycwbh=document.all("list["+dqhh.value+"].ycw.cwbh");
						var ycwsx=document.all("list["+dqhh.value+"].ycw.cwsx");
						var yhpbm=document.all("list["+dqhh.value+"].ycw.hpbm");
						var yhgsl=document.all("list["+dqhh.value+"].ycw.hgsl");
						var yshsl=document.all("list["+dqhh.value+"].ycw.shsl");
						var mbqwzj=document.all("list["+dqhh.value+"].mbqw.qwzj");
						var mbqwmc=document.all("list["+dqhh.value+"].mbqw.qwmc");
						var mbqwcclx=document.all("list["+dqhh.value+"].mbqw.cclx");
						var mbcwzj=document.all("list["+dqhh.value+"].mbcw.cwzj");
						var mbcwbh=document.all("list["+dqhh.value+"].mbcw.cwbh");
						var mbcwsx=document.all("list["+dqhh.value+"].mbcw.cwsx");
						var mbhpbm=document.all("list["+dqhh.value+"].mbcw.hpbm");
						var mbhgsl=document.all("list["+dqhh.value+"].mbcw.hgsl");
						var mbshsl=document.all("list["+dqhh.value+"].mbcw.shsl");
						ycwzj.value="";
						ycwbh.value="";
						ycwsx.value="";
						yhpbm.value="";
						yhgsl.value="";
						yshsl.value="";
						mbqwzj.value="";
						mbqwmc.value="";
						mbqwcclx.value="";
						mbcwzj.value="";
						mbcwbh.value="";
						mbcwsx.value="";
						mbhpbm.value="";
						mbhgsl.value="";
						mbshsl.value="";
						break;
					}else if("mbqw"==pagemsglx.value){
						var paramValue1 = document.getElementsByName("paramValue1");
						var paramValue2 = document.getElementsByName("paramValue2");
						var dqhh = document.all("dqhh");
						var mbqwzj=document.all("list["+dqhh.value+"].mbqw.qwzj");
						var mbqwmc=document.all("list["+dqhh.value+"].mbqw.qwmc");
						var mbqwcclx=document.all("list["+dqhh.value+"].mbqw.cclx");
						mbqwzj.value=paramPk[i].value;
						mbqwmc.value=paramValue1[i].value;
						mbqwcclx.value=paramValue2[i].value;
						var mbcwzj=document.all("list["+dqhh.value+"].mbcw.cwzj");
						var mbcwbh=document.all("list["+dqhh.value+"].mbcw.cwbh");
						var mbcwsx=document.all("list["+dqhh.value+"].mbcw.cwsx");
						var mbhpbm=document.all("list["+dqhh.value+"].mbcw.hpbm");
						var mbhgsl=document.all("list["+dqhh.value+"].mbcw.hgsl");
						var mbshsl=document.all("list["+dqhh.value+"].mbcw.shsl");
						mbcwzj.value="";
						mbcwbh.value="";
						mbcwsx.value="";
						mbhpbm.value="";
						mbhgsl.value="";
						mbshsl.value="";
						break;
					}else if("ycw"==pagemsglx.value){
						var paramValue1 = document.getElementsByName("paramValue1");
						var paramValue2 = document.getElementsByName("paramValue2");
						var paramValue3 = document.getElementsByName("paramValue3");
						var paramValue4 = document.getElementsByName("paramValue4");
						var dqhh = document.all("dqhh");
						var ycwzj=document.all("list["+dqhh.value+"].ycw.cwzj");
						var ycwbh=document.all("list["+dqhh.value+"].ycw.cwbh");
						var ycwsx=document.all("list["+dqhh.value+"].ycw.cwsx");
						var yhpbm=document.all("list["+dqhh.value+"].ycw.hpbm");
						var yhgsl=document.all("list["+dqhh.value+"].ycw.hgsl");
						var yshsl=document.all("list["+dqhh.value+"].ycw.shsl");
						ycwzj.value=paramPk[i].value;
						ycwbh.value=paramValue[i].value;
						ycwsx.value=paramValue1[i].value;
						yhpbm.value=paramValue2[i].value;
						yhgsl.value=paramValue3[i].value;
						yshsl.value=paramValue4[i].value;
						var mbcwzj=document.all("list["+dqhh.value+"].mbcw.cwzj");
						var mbcwbh=document.all("list["+dqhh.value+"].mbcw.cwbh");
						var mbcwsx=document.all("list["+dqhh.value+"].mbcw.cwsx");
						var mbhpbm=document.all("list["+dqhh.value+"].mbcw.hpbm");
						var mbhgsl=document.all("list["+dqhh.value+"].mbcw.hgsl");
						var mbshsl=document.all("list["+dqhh.value+"].mbcw.shsl");
						mbcwzj.value="";
						mbcwbh.value="";
						mbcwsx.value="";
						mbhpbm.value="";
						mbhgsl.value="";
						mbshsl.value="";
						break;
					}else if("mbcw"==pagemsglx.value){
						var paramValue1 = document.getElementsByName("paramValue1");
						var paramValue2 = document.getElementsByName("paramValue2");
						var paramValue3 = document.getElementsByName("paramValue3");
						var paramValue4 = document.getElementsByName("paramValue4");
						var dqhh = document.all("dqhh");
						var mbcwzj=document.all("list["+dqhh.value+"].mbcw.cwzj");
						var mbcwbh=document.all("list["+dqhh.value+"].mbcw.cwbh");
						var mbcwsx=document.all("list["+dqhh.value+"].mbcw.cwsx");
						var mbhpbm=document.all("list["+dqhh.value+"].mbcw.hpbm");
						var mbhgsl=document.all("list["+dqhh.value+"].mbcw.hgsl");
						var mbshsl=document.all("list["+dqhh.value+"].mbcw.shsl");
						mbcwzj.value=paramPk[i].value;
						mbcwbh.value=paramValue[i].value;
						mbcwsx.value=paramValue1[i].value;
						mbhpbm.value=paramValue2[i].value;
						mbhgsl.value=paramValue3[i].value;
						mbshsl.value=paramValue4[i].value;
						break;
					}
				}
			}			
		}
		function pageMsg(data,fn,name){
		  	var msg = "";
		  	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
				"<tr>"+
					"<td align=\"right\">"+
						"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
						"<input type=\"button\" name=\"first\" class=\"inputbutton3\" onClick=\""+fn+"(1,'"+name+"');\"/>"+
						"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+",'"+name+"');\"/>"+
						"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+",'"+name+"');\"/>"+
						"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+",'"+name+"');\"/>"+					
					"</td>"+
				"</tr>"+
			"</table>"
			return msg;
		}
		function delTrE(obj){
			var tbody = document.getElementById("mxId");
			tbody.removeChild(obj.parentNode.parentNode);
		}
		function addTrE(){
			var tbody = document.getElementById("mxId");
			var trE = tbody.insertRow();
			var tdE1 = trE.insertCell();
			var tdE2 = trE.insertCell();
			var tdE3 = trE.insertCell();
			var tdE4 = trE.insertCell();
			var tdE5 = trE.insertCell();
			var tdE6 = trE.insertCell();
			var tdE7 = trE.insertCell();
			var tdE8 = trE.insertCell();
			//设置格式
			tdE1.setAttribute("align","center");
			tdE2.setAttribute("align","center");
			tdE3.setAttribute("align","center");
			tdE4.setAttribute("align","center");
			tdE5.setAttribute("align","center");
			tdE6.setAttribute("align","center");
			tdE7.setAttribute("align","center");
			tdE8.setAttribute("align","center");
			//填充内容
			trE.setAttribute("id",count);
			var textE = document.createTextNode(parseInt(count)+1);
			tdE1.appendChild(textE);
			var inputE1=document.createElement("<input type='text' name='list["+count+"].yqw.qwmc' readonly='readonly' style='cursor:hand;' class='inputsmall2' onclick='yqwPagedata(1,"+count+");'>");
			var hidE1 = document.createElement("<input type='hidden' name='list["+count+"].yqw.qwzj'>");
			var hidE11 = document.createElement("<input type='hidden' name='list["+count+"].yqw.cclx'>");
			tdE2.appendChild(inputE1);
			tdE2.appendChild(hidE1);
			tdE2.appendChild(hidE11);
			var inputE2=document.createElement("<input type='text' name='list["+count+"].ycw.cwbh' readonly='readonly' style='cursor:hand;' class='inputsmall2' onclick='ycwPagedata(1,"+count+");'>");
			var hidE2 = document.createElement("<input type='hidden' name='list["+count+"].ycw.cwzj'>");
			var hidE21 = document.createElement("<input type='hidden' name='list["+count+"].ycw.cwsx'>");
			var hidE22 = document.createElement("<input type='hidden' name='list["+count+"].ycw.hpbm'>");
			var hidE23 = document.createElement("<input type='hidden' name='list["+count+"].ycw.hgsl'>");
			var hidE24 = document.createElement("<input type='hidden' name='list["+count+"].ycw.shsl'>");
			tdE3.appendChild(inputE2);
			tdE3.appendChild(hidE2);
			tdE3.appendChild(hidE21);
			tdE3.appendChild(hidE22);
			tdE3.appendChild(hidE23);
			tdE3.appendChild(hidE24);
			var inputE3=document.createElement("<input type='text' name='list["+count+"].mbqw.qwmc' readonly='readonly' style='cursor:hand;' class='inputsmall2' onclick='mbqwPagedata(1,"+count+");'>");
			var hidE3 = document.createElement("<input type='hidden' name='list["+count+"].mbqw.qwzj'>");
			var hidE31 = document.createElement("<input type='hidden' name='list["+count+"].mbqw.cclx'>");
			tdE4.appendChild(inputE3);
			tdE4.appendChild(hidE3);
			tdE4.appendChild(hidE31);
			var inputE4=document.createElement("<input type='text' name='list["+count+"].mbcw.cwbh' readonly='readonly' style='cursor:hand;' class='inputsmall2' onclick='mbcwPagedata(1,"+count+");'>");
			var hidE4 = document.createElement("<input type='hidden' name='list["+count+"].mbcw.cwzj'>");
			var hidE41 = document.createElement("<input type='hidden' name='list["+count+"].mbcw.cwsx'>");
			var hidE42 = document.createElement("<input type='hidden' name='list["+count+"].mbcw.hpbm'>");
			var hidE43 = document.createElement("<input type='hidden' name='list["+count+"].mbcw.hgsl'>");
			var hidE44 = document.createElement("<input type='hidden' name='list["+count+"].mbcw.shsl'>");
			tdE5.appendChild(inputE4);
			tdE5.appendChild(hidE4);
			tdE5.appendChild(hidE41);
			tdE5.appendChild(hidE42);
			tdE5.appendChild(hidE43);
			tdE5.appendChild(hidE44);
			var inputE5=document.createElement("<input type='text' name='list["+count+"].ykhpsl' class='inputsmall2' style='cursor:hand;' onblur='IsNumFormat("+count+");'>");
			tdE6.appendChild(inputE5);
			var inputE6=document.createElement("<input type='text' name='list["+count+"].ykshsl' class='inputsmall2' style='cursor:hand;' onblur='IsNumFormat("+count+");'>");
			tdE7.appendChild(inputE6);
			var butE = document.createElement("<img src='./images/button/del.gif' alt='点击删除' style='cursor:hand;' onclick='delTrE(this);'>");
			tdE8.appendChild(butE);
			count++;
		}
		function IsNumFormat(dqhh){
			var obj = document.all("list["+dqhh+"].ykhpsl");
			var obj1 = document.all("list["+dqhh+"].ykshsl");
			var ycwsx=document.all("list["+dqhh+"].ycw.cwsx");				
			var yhgsl=document.all("list["+dqhh+"].ycw.hgsl");
			var yshsl=document.all("list["+dqhh+"].ycw.shsl");
			var mbcwsx=document.all("list["+dqhh+"].mbcw.cwsx");
			var mbhgsl=document.all("list["+dqhh+"].mbcw.hgsl");
			var mbshsl=document.all("list["+dqhh+"].mbcw.shsl");
			if(ycwsx.value==""){
				alert("请选择源储位信息!");
				obj.value="";
				obj1.value="";
			}				
			if(yhgsl.value==""){
				alert("请选择源储位信息!");
				obj.value="";
				obj1.value="";
			}
			if(yshsl.value==""){
				alert("请选择源储位信息!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(ycwsx.value)){
				alert("源储位上限获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(yhgsl.value)){
				alert("源储位当前货品数量获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(yshsl.value)){
				alert("源储位当前货品数量获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(mbcwsx.value==""){
				alert("请选择目标储位信息!");
				obj.value="";
				obj1.value="";
			}				
			if(mbhgsl.value==""){
				alert("请选择目标储位信息!");
				obj.value="";
				obj1.value="";
			}
			if(mbshsl.value==""){
				alert("请选择目标储位信息!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(mbcwsx.value)){
				alert("目标储位上限获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(mbhgsl.value)){
				alert("目标储位当前货品数量获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(isNaN(mbshsl.value)){
				alert("目标储位当前货品数量获取有误!");
				obj.value="";
				obj1.value="";
			}
			if(obj.value!=""){
				if(isNaN(obj.value)){
					alert("数量输入有误!");
					obj.value="";
				}				
				if(parseFloat(obj.value)>parseFloat(yhgsl.value)){
					alert("移库正品数量大于当前实际存储数量!(当前存储数量:"+parseFloat(yhgsl.value)+")");					
					obj.value="";
				}				
			}
			if(obj1.value!=""){
				if(isNaN(obj1.value)){
					alert("数量输入有误!");
					obj1.value="";
				}
				if(parseFloat(obj1.value)>parseFloat(yshsl.value)){
					alert("移库次品数量大于当前实际存储数量!(当前存储数量:"+parseFloat(yshsl.value)+")");					
					obj1.value="";
				}
				
			}
			if(obj.value!="" && obj1.value!=""){
				if((parseFloat(obj.value)+parseFloat(obj1.value))>(parseFloat(mbcwsx.value)-parseFloat(mbhgsl.value)-parseFloat(mbshsl.value))){
					alert("移库数量超出上限!(当前存储差额:"+(parseFloat(mbcwsx.value)-parseFloat(mbhgsl.value)-parseFloat(mbshsl.value))+")");					
					obj.value="";
					obj1.value="";
				}
			}
		}
    </script> 
  </head>
  
  <body>
  <script type="text/javascript" src="./js/newdate.js"></script>
  	<html:form action="/ykdd.do?method=addObject" method="post" onsubmit="return IsNull();">
  		  <table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>移库订单</center></caption>
    		<tr>
    			<td align="right" width="25%">移库编号&nbsp;&nbsp;</td>
    			<td width="25%"><html:text property="vo.ykbh" styleClass="input" readonly="true"/></td>
    			<td align="right" width="20%">计划日期<font color="red">*</font>
    				<html:hidden property="vo.ssxs"/>
    				<html:hidden property="vo.sssysz"/>
    				<html:hidden property="vo.ykzt"/>
    				<input type="hidden" id="show-btn"/>
    				<input type="hidden" name="ykfssjg" id="ykfssjg"/>
    				<input type="hidden" name="ykflx" id="ykflx"/>
    			</td>
    			<td >
    				<html:text property="vo.ddrq" styleClass="input" readonly="true" onclick="showcalendar(event,this);" onfocus="showcalendar(event, this);if(this.value=='0000-00-00')this.value=''"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">源 库 房<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.ckkfmc" readonly="true" styleClass="input"/>    				
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageKfdata(1,'ck');"/>
    				<html:hidden property="vo.ckkfzj"/>
    			</td>
    			<td align="right">目标库房<font color="red">*</font></td>
    			<td>
    				<html:text property="vo.rkkfmc" readonly="true" styleClass="input"/>    				
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="pageMKfdata(1,'rk');"/>
    				<html:hidden property="vo.rkkfzj"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">操 作 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.ckczr" readonly="true" styleClass="input"/>
    			</td>
    			<td align="right">操 作 人&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="vo.rkczr" readonly="true" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">填 单 人&nbsp;&nbsp;</td>
    			<td >
    				<html:text property="vo.tdr" styleClass="input" readonly="true"/>
    			</td>
    			<td align="right">填单日期&nbsp;&nbsp;
    			</td>
    			<td >
    				<html:text property="vo.tdsj" styleClass="input" readonly="true"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">备　　注&nbsp;&nbsp;
    			</td>
    			<td colspan="3">
    				<html:textarea property="vo.bzxx" cols="50" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">移库明细(<a href="javascript:addTrE();">增加</a>)
    			</td>
    		</tr>
    		<tr>    			
    			<td align="center" colspan="4">
    			<table width="100%" align="center" id="goodListId" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    				<tbody id="mxId">
	    				<tr align="center">
	    					<td>编 号</td>
	    					<td>源区位</td>
	    					<td>源储位<font color="red">*</font></td>
	    					<td>目标区位</td>
	    					<td>目标储位<font color="red">*</font></td>
	    					<td>移库数量(合格)<font color="red">*</font></td>
	    					<td>移库数量(损毁)<font color="red">*</font></td>
	    					<td></td>
	    				</tr>
    				</tbody>
    			</table>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit styleClass="inputbutton">添 加</html:submit>
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
