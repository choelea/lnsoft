function back(){
	window.location.href="./kfxx.do?method=objList&rmMsg=true";
}
function IsNull(){
	var kfbh = document.all("vo.kfbh");
	var kfmc = document.all("vo.kfmc");
	var pym = document.all("vo.pym");
	var kflx = document.all("vo.kflx");
	var kfcd = document.all("vo.kfcd");
	var kfkd = document.all("vo.kfkd");
	var kfgd = document.all("vo.kfgd");
	var kfmj = document.all("vo.kfmj");
	var tdkd = document.all("vo.tdkd");
	var xzbj = document.all("vo.xzbj");	
	var kfgly = document.all("vo.kfgly");
	var kfzt = document.all("vo.kfzt");
	var ssjg = document.all("vo.ssjg");
	
	var expInt=/^[0-9]+$/;
	var expFloat=/^[0-9]*(.)[0-9]+$/;
	if(kfbh.value==""){
		alert("库房编号输入有误!");
		return false;
	}
	if(kfmc.value==""){
		alert("库房名称输入有误!");
		return false;
	}
	if(pym.value==""){
		alert("请输入库房拼音码!");
		return false;
	}
	if(kflx.value==""){
		alert("请输入库房类型!");
		return false;
	} 
	if(!expInt.test(kfcd.value) && !expFloat.test(kfcd.value)){
		alert("库房长度输入有误!");
		return false;
	}
	if(!expInt.test(kfkd.value) && !expFloat.test(kfkd.value)){
		alert("库房宽度输入有误!");
		return false;
	}
	if(!expInt.test(kfgd.value) && !expFloat.test(kfgd.value)){
		alert("库房高度输入有误!");
		return false;
	}
	if(!expInt.test(kfmj.value) && !expFloat.test(kfmj.value)){
		alert("库房面积输入有误!");
		return false;
	}
	if(tdkd.value!="" && !expInt.test(tdkd.value) && !expFloat.test(tdkd.value)){
		alert("通道宽度输入有误!");
		return false;
	}
	if(xzbj.value!="" && !expInt.test(xzbj.value) && !expFloat.test(xzbj.value)){
		alert("旋转半径输入有误!");
		return false;
	}
	if(kfgly.value==""){
		alert("请输入库管信息!");
		return false;
	}
	if(kfzt.value==""){
		alert("请输入库房状态信息!");
		return false;
	}
	if(kfzt.value==""){
		alert("请输入库房所属机构!");
		return false;
	}
	return true;
}
function valiValue(o,f,ssxs,sssysz){
	if(o.value!=""){
		var hql = "from Kfxx A where A."+f+" = '"+o.value+"' and A.ssxs ="+ssxs+" and A.sssysz = "+sssysz;
		UserDWR.isExit(hql,null,function cd(data){
			var field = document.getElementById(f);
			if(data)						
				field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
			else
				field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
		});
	}
}
function valiValue1(o,f,ssxs,sssysz){
	var oldName = document.all("oldName");
	if(o.value!=""){
		var field = document.getElementById(f);
		if(oldName.value!=o.value){
			var hql = "from Kfxx A where A."+f+" = '"+o.value+"' and A.ssxs ="+ssxs+" and A.sssysz = "+sssysz;
   			UserDWR.isExit(hql,null,function cd(data){	    				
   				if(data)						
   					field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
   				else
   					field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
   			});	
		}else{
			field.innerHTML="<font color='#ff0000'></font>";
		}
	}
}
function getPym(obj){
	var kfmc = document.all("vo.kfmc");
	if(kfmc.value!=""){
		UserDWR.createPym(kfmc.value,function(data){
			obj.value=data;
		});
	}
}
function countArea(){
	var kfcd = document.all("vo.kfcd");
	var kfkd = document.all("vo.kfkd");
	var expInt=/^[0-9]+$/;
	var expFloat=/^[0-9]*(.)[0-9]+$/;
	if(expInt.test(kfcd.value)||expFloat.test(kfcd.value)){
		if(expInt.test(kfkd.value)||expFloat.test(kfkd.value)){
			var area = parseFloat(kfcd.value)*parseFloat(kfkd.value);
			document.all("vo.kfmj").value=area;
		}
	}
}
function setKflx(){
	paramPageinfo(1,7);
	document.getElementById("show-btn").click();
}
function setKfzt(){
	paramPageinfo(1,8);
	document.getElementById("show-btn").click();
}
function setSsjg(){
	paramPageinfo(1,16);
	document.getElementById("show-btn").click();
}
function setKfgly(ssxs,sssysz){
	ygxxPageinfo(1,"库管",ssxs,sssysz);
	document.getElementById("show-btn").click();
}
function paramPageinfo(curpage,ptype){
	var countHql = "select count(A) from Sjzdmx A where A.sjzd.sjzdzj = "+ptype+" and A.fqzj=0";
	var hql = "from Sjzdmx A where A.sjzd.sjzdzj = "+ptype+" and A.fqzj=0";
	UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
		var list = data.pagedata;
   		var div1 = document.getElementById("div1");    		
		var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
  				"<tr align=\"center\" height=\"30\">"+
			"<td>选择<input type='hidden' name='paramType' value='cslx'/><input type='hidden' name='paramType1' value='"+ptype+"'/></td><td>参数编号</td><td>参数名称</td></tr>";
   		for(var obj in list){
   			if(!isNaN(obj)){
				msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].sjzdmxzj+"\" />"+
					  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].sjzdmxmc+"\">"+
						"</td><td>"+list[obj].sjzdmxbh+"</td><td>"+list[obj].sjzdmxmc+"</td></tr >";					
    		}
   		}
   		if(list.length==0){
   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无参数信息</td></tr>";
   		}
   		msg = msg + "</table>";
   		msg = msg + pageMsg(data,"paramPageinfo",ptype);
   		div1.innerHTML=msg;
	});
}
function ygxxPageinfo(curpage,ptype,ssxs,sssysz){
	var countHql = "select count(A) from Ygxx A where A.ygzw = '"+ptype+"' and A.ssxs ="+ssxs+" and A.sssysz = "+sssysz;
	var hql = "from Ygxx A where A.ygzw = '"+ptype+"' and A.ssxs ="+ssxs+" and A.sssysz = "+sssysz;
	UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
		var list = data.pagedata;
   		var div1 = document.getElementById("div1");    		
		var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
  				"<tr align=\"center\" height=\"30\">"+
			"<td>选择<input type='hidden' name='paramType' value='ygxx'/><input type='hidden' name='paramType1' value='"+ptype+"'/></td><td>员工编号</td><td>员工名称</td></tr>";
   		for(var obj in list){
   			if(!isNaN(obj)){
				msg = msg +"<tr align=\"center\" height=\"25\"><td><input type=\"radio\" name=\"paramPk\" value=\""+list[obj].ygzj+"\" />"+
					  "<input type=\"hidden\" name=\"paramValue\" value=\""+list[obj].ygmc+"\">"+
					  "<input type=\"hidden\" name=\"paramValue1\" value=\""+list[obj].ygdh+"\">"+
					  "<input type=\"hidden\" name=\"paramValue2\" value=\""+list[obj].ssjg+"\">"+
						"</td><td>"+list[obj].ygbh+"</td><td>"+list[obj].ygmc+"</td></tr >";					
    		}
   		}
   		if(list.length==0){
   			msg = msg + "<tr align=\"center\" height=\"30\"><td colspan=\"9\">暂无员工信息</td></tr>";
   		}
   		msg = msg + "</table>";
   		msg = msg + pageMsg1(data,"ygxxPageinfo",ptype,ssxs,sssysz);
   		div1.innerHTML=msg;
	});
}
function pageMsg(data,fn,ptype){
	var msg = "";
	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
		"<tr>"+
			"<td align=\"right\">"+
				"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
				"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,"+ptype+");\"/>"+
				"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+","+ptype+");\"/>"+
				"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+","+ptype+");\"/>"+
				"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+","+ptype+");\"/>"+					
			"</td>"+
		"</tr>"+
	"</table>"
	return msg;
}
function pageMsg1(data,fn,ptype,ssxs,sssysz){
	var msg = "";
	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
		"<tr>"+
			"<td align=\"right\">"+
				"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
				"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,'"+ptype+"',"+ssxs+","+sssysz+");\"/>"+
				"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+",'"+ptype+"',"+ssxs+","+sssysz+");\"/>"+
				"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+",'"+ptype+"',"+ssxs+","+sssysz+");\"/>"+
				"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+",'"+ptype+"',"+ssxs+","+sssysz+");\"/>"+					
			"</td>"+
		"</tr>"+
	"</table>"
	return msg;
}
function setValue(){
	var paramType = document.all("paramType");
	var paramType1 = document.all("paramType1");
	var paramPks = document.getElementsByName("paramPk");
	var paramValues = document.getElementsByName("paramValue");
	for(var i=0;i<paramPks.length;i++){
		if(paramPks[i].checked){
			if("cslx"==paramType.value){
				if("7"==paramType1.value){
					document.all("vo.kflx").value=paramValues[i].value;
				}else if("8"==paramType1.value){
					document.all("vo.kfzt").value=paramValues[i].value;
				}else if("16"==paramType1.value){
					document.all("vo.ssjg").value=paramValues[i].value;
				}
			}else if("ygxx"==paramType.value){
				var paramValues1 = document.getElementsByName("paramValue1");
				var paramValues2 = document.getElementsByName("paramValue2");
				document.all("vo.kfgly").value=paramValues[i].value;
				document.all("vo.kflxdh").value=paramValues1[i].value;
				document.all("vo.ssjg").value=paramValues2[i].value;
			}
			break;
		}
	}
}