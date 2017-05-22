<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" import="java.io.*,java.sql.*" %>
<%  
ServletContext context = session.getServletContext();
String realContextPath = context.getRealPath(request.getContextPath()).replace("tomcat\\webapps\\ROOT",""); 


//Read mysql Port Configuration
String mysqlIni = realContextPath+"mysql\\my.ini";
BufferedReader reader = new BufferedReader(new FileReader(mysqlIni));
StringBuilder sb = new StringBuilder();
String line;
String mysqlPort = "";
while((line = reader.readLine())!= null){
	if(line.contains("port")){
		mysqlPort = line.split("=")[1].trim();
		break;
	}
} 

String mysqlTestData = ""; 
Connection conn = null; 
try{
	//注册数据库驱动  
	Class.forName("com.mysql.jdbc.Driver");  
	//获取数据库连接  
	conn = DriverManager.getConnection(  
		"jdbc:mysql://localhost:"+mysqlPort,"root","root");  
	//创建Statement  
	mysqlTestData = "Successfully connectted to mysql!";
	mysqlTestData ="<font color='green'>"+mysqlTestData+"</font>";
}catch(Exception e){
	mysqlTestData = e.getMessage();
	mysqlTestData ="<font color='red'>"+mysqlTestData+"</font>";
}finally{
	if(conn!=null){
		conn.close();
	}	
}
 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>JTM 环境检测</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link href="css/jtm.css" rel="stylesheet" type="text/css" />
</head>
<body class="jtm">
	<div class="header">
		<div class="title">JMAT 环境检测</div>
		<div class="banner"></div>
	</div>
	<div class="body">
		<table>
			<tr>
				<th>
					名称
				</th>
				<th>
					内容
				</th>
			</tr>
			<tr>
				<td width="300">
					<strong>安装路径:</strong>
				</td>
				<td>
					<%=realContextPath%>
				</td>
			</tr>
			<tr>
				<td>
					<strong>Tomcat版本:</strong>
				</td>
				<td>
					<%=application.getServerInfo() %>
				</td>
			</tr>
			<tr>
				<td>
					<strong>Tomcat端口:</strong>
				</td>
				<td>
					<%=request.getServerPort()%>
				</td>
			</tr>
			<tr>
				<td>
					<strong>Mysql</strong>
				</td>
				<td>
					端口:<%=mysqlPort%> <br/>
					账户:root/root
				</td>
			</tr>
			<tr>
				<td>
					<strong>Mysql 测试</strong>
				</td>
				<td>
					<%=mysqlTestData%>
				</td>
			</tr>
				</td>
			</tr>
			<tr>
				<td width="300">
					<strong>操作系统:</strong>
				</td>
				<td>
					<%=System.getProperty("os.name")%> (<%=System.getProperty("os.arch")%>)
				</td>
			</tr>
			<tr>
				<td>
					<strong>JDK版本:</strong>
				</td>
				<td>
					<%=System.getProperty("java.version")%>
				</td>
			</tr>
			<tr>
				<td>
					<strong>JDK路径:</strong>
				</td>
				<td>
					<%=System.getProperty("java.home")%>
				</td>
			</tr>
			<tr>
				<td>
					<strong>JDK临时路径:</strong>
				</td>
				<td>
					<%=System.getProperty("java.io.tmpdir")%>
				</td>
			</tr>
			
		</table>
		<div class="blank"></div>
		<div><p> 如果你修改了mysql的端口，请切记<b>修改对应程序中数据库连接的配置信息</b></p></div>
		<br/>
		</div>
		<div class="blank"></div>
		<div class="footer">
			<p class="copyright">Copyright © 2011 All Rights Reserved.</p>
		</div>
	
</body>
</html>