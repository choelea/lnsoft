<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/init/init.jsp" %>
<%@ include file="/init/dwrjs.jsp" %>
<%@ include file="/init/extjs.jsp" %>
<html>
  <head>
    <title><bean:message key="system.title"/></title>
    <script src="./js/hpxx.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function back(){
			window.location.href="./sjzdmx.do?method=sjzdmxList&page=1&sjzd.sjzdzj=${objPk}&vo.fqzj=${fqPk}";
		}
    </script>
  </head>
  
  <body>
    <html:form action="/sjzdmx.do?method=addObject" method="post" onsubmit="return IsNull();">
    	<table width="100%" align="center" cellpadding="0" cellspacing="1" border="0" style="word-break:break-all;">
    		<caption><center>货品管理</center></caption>
    		<tr>
    			<td align="right">货品编码&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="hpxx.hpbm" styleClass="input" onblur="valiValue(this,'hpbm');"/>
    				<span id="hpbm"></span>
    				<html:hidden property="sjzd.sjzdzj" value="${objPk }"/>
    				<html:hidden property="vo.fqzj" value="${fqPk }"/>
    			</td>
    			<td align="right">货品名称&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="hpxx.hpmc" styleClass="input" onblur="valiValue(this,'hpmc');"/>
    				<span id="hpmc"></span>	
    			</td>
    		</tr>
    		<tr>
    			<td align="right">条 形 码&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.txm" styleClass="input" readonly="true" onclick="getTxm(this);"/>
    			</td>
    			<td align="right">拼 音 码&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.pym" styleClass="input" readonly="true" onclick="getPym(this);"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">型 号&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hpxh" styleClass="input" />
    			</td>
    			<td align="right">规 格&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hpgg" styleClass="input" />
    			</td>
    		</tr>
    		<tr>
    			<td align="right">货品类型&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hplx" styleClass="input" readonly="true"/>
    			<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getHplx(1);"/>
    			<input type="hidden" name="hplxzj" id="hplxzj"/>
    			</td>
    			<td align="right">货品子类型&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hpzlx" styleClass="input" readonly="true"/>
    			<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getHpzlx(1);"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">货品单价&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hpdj" styleClass="input"/>
    			</td>
    			<td align="right">货品单位&nbsp;&nbsp;</td>
    			<td>
    				<html:text property="hpxx.hpdw" styleClass="input" readonly="true"/>
    				<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getHpdw(1,'qt');"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">保 质 期(天)&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.bzq" styleClass="input"/>
    			</td>
    			<td align="right">生产厂商&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.sccs" styleClass="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">体 积&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.hptj" styleClass="input"/>
    			</td>
    			<td align="right">体积单位&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.tjdw" styleClass="input" readonly="true"/>
    			<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getHpdw(1,'tj');"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">重 量&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.zl" styleClass="input"/>
    			</td>
    			<td align="right">重量单位&nbsp;&nbsp;</td>
    			<td><html:text property="hpxx.zldw" styleClass="input" readonly="true"/>
    			<img src="./images/button/export.jpg" alt="点击选择" style="cursor:hand;" onclick="getHpdw(1,'zl');"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">存储环境&nbsp;&nbsp;</td>
    			<td>
    			<html:select property="hpxx.cchj" style="width:100pt;">
    				<html:option value="干燥">干燥</html:option>
    				<html:option value="通风">通风</html:option>
    				<html:option value="阴凉">阴凉</html:option>
    				<html:option value="潮湿">潮湿</html:option>
    			</html:select>
    			</td>
    			<td align="right">货品属性&nbsp;&nbsp;</td>
    			<td>
    			<html:select property="hpxx.hpsx" style="width:100pt;">
    				<html:option value="防潮">防潮</html:option>
    				<html:option value="易碎">易碎</html:option>
    				<html:option value="贵重">贵重</html:option>
    				<html:option value="易盗">易盗</html:option>
    				<html:option value="赠品">赠品</html:option>
    			</html:select>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">货品说明&nbsp;&nbsp;</td>
    			<td colspan="3">
    			<html:textarea property="hpxx.hpsm" cols="60" rows="5"></html:textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4">
    				<html:submit styleClass="inputbutton">添 加</html:submit>
    				<input type="button" value="返 回" class="inputbutton" onclick="back();"/>
    				<input type="hidden" id="show-btn"/>
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
