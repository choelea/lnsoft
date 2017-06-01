package com.whjbsoft.www.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import java.io.FileReader;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
public class CheckDate {
	public static boolean checkTime(String miCode, String jiaFlie){
		boolean flag=false;
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String cTime=dateFormat.format(new java.util.Date()); 
		 String endTime=jieMi(miCode,jiaFlie);
		 int num= FormateDate.contrastDate(cTime,endTime);
			if(num<0){
				flag=false;	
			}else{
				flag=true;	
			}
		 
		return flag;
	}

	
	public static String  jieMi(String miCode,String jiaFlie) {
	     
		 FileInputStream fi;
		try {
			
	        // ����ܳ�����
	        fi = new FileInputStream(new File(miCode));
	        byte rawKeyData[] = new byte[fi.available()];// = new byte[5];
	         fi.read(rawKeyData);
	         fi.close();
	        // ��ԭʼ�ܳ����ݴ���һ��DESKeySpec����
	         DESKeySpec dks = new DESKeySpec(rawKeyData);
	        // ����һ���ܳ׹�����Ȼ��������DESKeySpec����ת����һ��SecretKey����
	         SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
	        // Cipher����ʵ����ɽ��ܲ���
	         Cipher cipher = Cipher.getInstance("DES");
	        // ���ܳ׳�ʼ��Cipher����
	         cipher.init(Cipher.DECRYPT_MODE, key);
	         //�ļ���ʱ���·��
              String afile="c:\\jbwmscode.txt";
	            try {
	               
	                //�����
	                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(afile));
	                //������
	                CipherInputStream in = new CipherInputStream(new BufferedInputStream(
	                        new FileInputStream(jiaFlie)), cipher);
	               int i;
	                do {
	                    i = in.read();
	                    if (i != -1)
	                        out.write(i);
	                }
	                while (i != -1);
	                in.close();
	                out.close();
	                
	            }
	            catch (Exception ey5) {
	                System.exit(0);
	            }
	        
	         String s=getTextFromTxt1(afile);
	       return s;
	       
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
	private static String getTextFromTxt1(String filePath) {
		FileReader fr;
		try {
			fr = new FileReader(filePath);
		
		BufferedReader br = new BufferedReader(fr);
		StringBuffer buff = new StringBuffer();
		String temp = null;
		while((temp = br.readLine()) != null){
		  buff.append(temp + "\r\n");
		}
		  br.close();
		 return buff.toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
