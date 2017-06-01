package com.whjbsoft.www.util;


public class DogCreate {
	/**
	 * 构造字符串
	 * @param strs
	 * 	元素数组
	 * @return
	 * 	
	 */
	public static String compageString(String[] strs){
		StringBuffer sb = new StringBuffer();
		if(strs!=null && strs.length>0){
			for (int i=0;i<strs.length;i++) {
				if(i+1!=strs.length){
					sb.append(strs[i]).append(",");
				}else{
					sb.append(strs[i]);
				}
				
			}
		}
		return sb.toString();
	}
}
