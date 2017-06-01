function pagedata(path,page,count){
	var exp = /^\d+$/;
	if(!exp.test(page)){
		alert("页码输入有误!");
	}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
		alert("页数超出范围!");
	}else{
		window.location.href=path+"?m=objList&page="+page;
	}
}
function pagedata1(path,page,count){
	var exp = /^\d+$/;
	if(!exp.test(page)){
		alert("页码输入有误!");
	}else if(parseInt(page)<=0 || parseInt(page)>parseInt(count)){
		alert("页数超出范围!");
	}else{
		window.location.href=path+"&page="+page;
	}
}
//电话验证
function valiPhone(obj){
	var expPhone = /^\(?[0-9]{3,4}\)?(-| )?[0-9]{4}(-| )?[0-9]{3,4}$/;
	if(obj!=null&&obj.disabled == false){
		if(expPhone.test(obj.value))
			return true;
		else
			return false;
	}else
		return false;
}
//邮编验证
function valiPost(obj){
 	var postExp = /^\d{6}$/;
 	if(obj!=null&&obj.disabled == false){
		if(postExp.test(obj.value))
			return true;
		else
			return false;
	}else
		return false;
}
//数字验证
function valiNum(obj){
 	if(obj!=null&&obj.disabled == false){
		if(obj.value.trim()=="")
			return false;
		else if(isNaN(obj.value))
			return false;
		else
			return true;
	}else
		return false;
}
//整数验证
function valiInt(obj){
	var intExp = /^[0-9]+$/;
	if(obj!=null&&obj.disabled == false){
		if(intExp.test(obj.value))
			return true;
		else
			return false;
	}else
		return false;
}
//邮箱验证
function valiEmail(obj){
	if(obj!=null&&obj.disabled == false){
	   var emailStr=obj.value;
	   if (emailStr.length == 0) {
           return true;
       }
       var emailPat=/^(.+)@(.+)$/;
       var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
       var validChars="\[^\\s" + specialChars + "\]";
       var quotedUser="(\"[^\"]*\")";
       var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
       var atom=validChars + '+';
       var word="(" + atom + "|" + quotedUser + ")";
       var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
       var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
       var matchArray=emailStr.match(emailPat);
       if (matchArray == null) {
           return false;
       }
       var user=matchArray[1];
       var domain=matchArray[2];
       if (user.match(userPat) == null) {
           return false;
       }
       var IPArray = domain.match(ipDomainPat);
       if (IPArray != null) {
           for (var i = 1; i <= 4; i++) {
              if (IPArray[i] > 255) {
                 return false;
              }
           }
           return true;
       }
       var domainArray=domain.match(domainPat);
       if (domainArray == null) {
           return false;
       }
       var atomPat=new RegExp(atom,"g");
       var domArr=domain.match(atomPat);
       var len=domArr.length;
       if ((domArr[domArr.length-1].length < 2) ||
           (domArr[domArr.length-1].length > 3)) {
           return false;
       }
       if (len < 2) {
           return false;
       }
       return true;
    }else
    	return false;
}
//字符串验证
function valiChar(obj){
	var charExp = /^\w+$/;
	if(obj!=null&&obj.disabled == false){
		if(charExp.test(obj.value))
			return true;
		else
			return false;
	}else
		return false;
}
function toadd(path){
	window.location.href=path+"?m=presave"
}
function todel(path){
	var temp=document.getElementsByName("pk");
	for (i=0;i<temp.length;i++){ 
	  //遍历Radio 
	    if(temp[i].checked){     	
	    	 break;
	    }
	} 
	if(i==temp.length){
		alert("没有选择信息！");
		return false;
	}
	if(confirm("确认删除？")){
		var form = document.forms[0];
		form.action=path+"?m=delete";
	 	form.method="post";
	 	form.submit();
	}
}
function selAll(){ 
	var o=document.getElementsByName("pk"); 
	for(i=0;i<o.length;i++) {
		if(!o[i].disabled){
		    o[i].checked=event.srcElement.checked; 
		}
	}
}
function back(path,type){
	window.location.href=path+"/jsp/student/flow"+type+".jsp";
}
function back1(path){
	window.location.href=path;
}