<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<html>
  <head>    
    <title>打 印</title>
    <script type="text/javascript"> 
    	function toGiveVal(){  	
			var div = document.getElementById("printId");
			div.innerHTML=window.opener.document.getElementById("printId").innerHTML;
			window.print();
		}
    </script>
  </head>
  
  <body onload="toGiveVal();">  	
    <div id="printId">	
	</div>
	 
  </body>
</html>
