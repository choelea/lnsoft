function back(){
	window.location.href="./qwxx.do?method=objList";
}
function IsNull(){
	var qwbh = document.all("vo.qwbh");
	var qwmc = document.all("vo.qwmc");
	var ccgn = document.all("vo.ccgn");
	var cclx = document.all("vo.cclx");
	var ccfs = document.all("vo.ccfs");
	var ccpz = document.all("vo.ccpz");
	var cchj = document.all("vo.cchj");
	
	var expInt=/^[0-9]+$/;
	var expFloat=/^[0-9]*(.)[0-9]+$/;
	if(qwbh.value==""){
		alert("区位编号输入有误!");
		return false;
	}
	if(qwmc.value==""){
		alert("区位名称输入有误!");
		return false;
	}
	if(ccgn.value==""){
		alert("请输入存储功能!");
		return false;
	}
	if(cclx.value==""){
		alert("请输入存储类型!");
		return false;
	} 
	if(ccfs.value==""){
		alert("请输入存储方式!");
		return false;
	}
	if(ccpz.value==""){
		alert("请输入存储品质!");
		return false;
	}
	if(cchj.value==""){
		alert("请输入存储环境!");
		return false;
	}
	return true;
}
function valiValue(o,f,kfzj){
	if(o.value!=""){
		var hql = "from Qwxx A where A."+f+" = '"+o.value+"' and A.kfxx.kfzj = "+kfzj;
		UserDWR.isExit(hql,null,function cd(data){
			var field = document.getElementById(f);
			if(data)						
				field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
			else
				field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
		});
	}
}
function valiValue1(o,f,kfzj){
	var oldName = document.all("oldName");
	if(o.value!=""){
		var field = document.getElementById(f);
		if(oldName.value!=o.value){
			var hql = "from Qwxx A where A."+f+" = '"+o.value+"' and A.kfxx.kfzj = "+kfzj;
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
function setCcgn(){
	paramPageinfo(1,9);
	document.getElementById("show-btn").click();
}
function setCclx(){
	paramPageinfo(1,20);
	document.getElementById("show-btn").click();
}
function setCcfs(){
	paramPageinfo(1,10);
	document.getElementById("show-btn").click();
}
function setCcpz(){
	paramPageinfo(1,11);
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
function setValue(){
	var paramType = document.all("paramType");
	var paramType1 = document.all("paramType1");
	var paramPks = document.getElementsByName("paramPk");
	var paramValues = document.getElementsByName("paramValue");
	for(var i=0;i<paramPks.length;i++){
		if(paramPks[i].checked){
			if("cslx"==paramType.value){
				if("9"==paramType1.value){
					document.all("vo.ccgn").value=paramValues[i].value;
				}else if("10"==paramType1.value){
					document.all("vo.ccfs").value=paramValues[i].value;
				}else if("11"==paramType1.value){
					document.all("vo.ccpz").value=paramValues[i].value;
				}else if("20"==paramType1.value){
					document.all("vo.cclx").value=paramValues[i].value;
				}
			}
			break;
		}
	}
}