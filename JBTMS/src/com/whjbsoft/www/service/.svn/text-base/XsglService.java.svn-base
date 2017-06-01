/**
 * 
 */
package com.whjbsoft.www.service;

import java.io.InputStream;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.util.Pageinfo;

/**
 * @author whjb
 * @Date 2009-9-25 ÉÏÎç11:53:50
 */
public interface XsglService {
	int pagerecord = 10;
	public Pageinfo getPagedata(String con,int curpage,Object... params);
	
	public boolean save (Xsxx xsgl,int bjzj,int zcsl);
	
	public boolean update(Xsxx xsgl);

	public Xsxx getXsgl(int pk);
	
	public void updYxbj(int id,int state);
	
	public boolean isExistXsgl(int sign,String fieldName,String fieldValue);
	
	public boolean delXsgl(String []pk);
	
	public Bjxx getBjgl(int id);
	
	public boolean importStu(InputStream in,int bjzj);
	
}
