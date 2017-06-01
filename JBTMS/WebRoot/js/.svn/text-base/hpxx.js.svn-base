function IsNull(){
	var hpbm = document.all("hpxx.hpbm");
	var hpmc = document.all("hpxx.hpmc");
	var txm = document.all("hpxx.txm");
	var pym = document.all("hpxx.pym");
	var hpxh = document.all("hpxx.hpxh");
	var hpgg = document.all("hpxx.hpgg");
	var hplx = document.all("hpxx.hplx");
	var hpdj = document.all("hpxx.hpdj");
	var hpdw = document.all("hpxx.hpdw");
	var hptj = document.all("hpxx.hptj");
	var tjdw = document.all("hpxx.tjdw");
	var zl = document.all("hpxx.zl");
	var zldw = document.all("hpxx.zldw");
	var expFloat = /^[0-9]*(.)[0-9]{1,2}$/;
	var expInt = /^[0-9]+$/;
	var expNum = /^\w+$/;
	if(!expNum.test(hpbm.value)){
		alert("货品编号输入有误!");
		return false;
	}
	if(hpmc.value==""){
		alert("请输入货品名称!");
		return false;
	}
	if(txm.value==""){
		alert("请输入货品条形码!");
		return false;
	}
	if(pym.value==""){
		alert("请输入货品拼音码!");
		return false;
	}
	if(hpxh.value!="" && !expNum.test(hpxh.value)){
		alert("货品型号输入有误!");
		return false;
	}
	if(hpgg.value!="" && !expNum.test(hpgg.value)){
		alert("货品规格输入有误!");
		return false;
	}
	if(hplx.value==""){
		alert("请输入货品类型!");
		return false;
	}
	if(!expInt.test(hpdj.value)&&!expFloat.test(hpdj.value)){
		alert("货品单价输入有误!");
		return false;
	}
	if(hpdw.value==""){
		alert("请输入货品单位!");
		return false;
	}
	if(!expInt.test(hptj.value)&&!expFloat.test(hptj.value)){
		alert("货品体积输入有误!");
		return false;
	}
	if(tjdw.value==""){
		alert("体积单位输入有误!");
		return false;
	}
	if(!expInt.test(zl.value)&&!expFloat.test(zl.value)){
		alert("货品重量输入有误!");
		return false;
	}
	if(zldw.value==""){
		alert("重量单位输入有误!");
		return false;
	}    		
	return true;
}

function valiValue(o,f){
	if(o.value!=""){
		var hql = "from Hpxx A where A."+f+" = '"+o.value+"'";
		UserDWR.isExit(hql,null,function cd(data){
			var field = document.getElementById(f);
			if(data)						
				field.innerHTML="<font color='#ff0000'>Sorry,该信息已存在!</font>";
			else
				field.innerHTML="<font color='#ff0000'>恭喜,该信息可以使用!</font>";
		});
	}
}
function valiValue1(o,f){
	var oldName = document.all("oldName");
	if(o.value!=""){
		var field = document.getElementById(f);
		if(oldName.value!=o.value){
			var hql = "from Hpxx A where A."+f+" = '"+o.value+"'";
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
function getTxm(obj){
	if(obj.value=="")
		UserDWR.createTxm(function(data){
			obj.value=data;
		});
}
function getPym(obj){
	var hpmc = document.all("hpxx.hpmc");
	if(hpmc.value!=""){
		UserDWR.createPym(hpmc.value,function(data){
			obj.value=data;
		});
	}
}
function getHplx(curpage){
	hplxPageinfo(curpage,0);
    document.getElementById("show-btn").click();
}
function getHpzlx(curpage){
	var fqpk = document.getElementById("hplxzj");
	if(fqpk.value!=""){
		hplxPageinfo(curpage,fqpk.value);
    	document.getElementById("show-btn").click();
	}
}
function hplxPageinfo(curpage,fqzj){
	var countHql = "select count(A) from Sjzdmx A where A.sjzd.sjzdzj = 20 and A.fqzj="+fqzj;
	var hql = "from Sjzdmx A where A.sjzd.sjzdzj = 20 and A.fqzj="+fqzj;
	UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
		var list = data.pagedata;
   		var div1 = document.getElementById("div1");    		
		var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
  				"<tr align=\"center\" height=\"30\">"+
			"<td>选择<input type='hidden' name='paramType' value='hplx'/><input type='hidden' name='paramType1' value='"+fqzj+"'/></td><td>类型编号</td><td>类型名称</td></tr>";
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
   		msg = msg + pageMsg(data,"hplxPageinfo",fqzj);
   		div1.innerHTML=msg;
	});
}
function getHpdw(curpage,dwlx){
	hpdwPageinfo(curpage,dwlx);
    document.getElementById("show-btn").click();
}
function hpdwPageinfo(curpage,fqzj){
var countHql = "select count(A) from Sjzdmx A where A.sjzd.sjzdzj = 17 and A.field1='"+fqzj+"'";
	var hql = "from Sjzdmx A where A.sjzd.sjzdzj = 17 and A.field1='"+fqzj+"'";
	UserDWR.getPageinfo(countHql,hql,curpage,10,null,function(data){
		var list = data.pagedata;
   		var div1 = document.getElementById("div1");    		
		var msg = "<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"1\" style=\"word-break:break-all;\">"+
  				"<tr align=\"center\" height=\"30\">"+
			"<td>选择<input type='hidden' name='paramType' value='dwlx'/><input type='hidden' name='paramType1' value='"+fqzj+"'/></td><td>类型编号</td><td>类型名称</td></tr>";
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
   		msg = msg + pageMsg(data,"hpdwPageinfo",fqzj);
   		div1.innerHTML=msg;
	});
}
function pageMsg(data,fn,fqzj){
	var msg = "";
	msg = msg + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
		"<tr>"+
			"<td align=\"right\">"+
				"共 ["+data.allpage+"] 页&nbsp;&nbsp;当前第 ["+data.curpage+"] 页 &nbsp;&nbsp;每页 ["+data.pagerecord+"] 条记录&nbsp;&nbsp;"+
				"<input type=\"button\" name=\"first\" class=\"inputbutton3\"	onClick=\""+fn+"(1,'"+fqzj+"');\"/>"+
				"<input type=\"button\" name=\"before\" class=\"inputbutton1\" onClick=\""+fn+"("+data.previouspage+",'"+fqzj+"');\"/>"+
				"<input type=\"button\" name=\"next\" class=\"inputbutton2\" onClick=\""+fn+"("+data.nextpage+",'"+fqzj+"');\"/>"+
				"<input type=\"button\" name=\"last\" class=\"inputbutton4\" onclick=\""+fn+"("+data.allpage+",'"+fqzj+"');\"/>"+					
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
			if("hplx"==paramType.value){
				if("0"==paramType1.value){
					document.all("hpxx.hplx").value=paramValues[i].value;
					document.getElementById("hplxzj").value=paramPks[i].value;
				}else{
					document.all("hpxx.hpzlx").value=paramValues[i].value;
				}
			}else if("dwlx"==paramType.value){
				if("qt"==paramType1.value){
					document.all("hpxx.hpdw").value=paramValues[i].value;
				}else if("tj"==paramType1.value){
					document.all("hpxx.tjdw").value=paramValues[i].value;
				}else if("zl"==paramType1.value){
					document.all("hpxx.zldw").value=paramValues[i].value;
				}
			}
			break;
		}
	}
}