package com.whjbsoft.www.util;

public class Letter {
	
	private static String _FromEncode_ = "GBK";
	private static String _ToEncode_ = "GBK";
	
    public static int compare(String str1, String str2)
     {
         int result = 0;
         String m_s1 = null;
         String m_s2 = null;
         try
         {
             m_s1 = new String(str1.getBytes(_FromEncode_), _ToEncode_);
             m_s2 = new String(str2.getBytes(_FromEncode_), _ToEncode_);
         }
         catch(Exception e)
         {
             return str1.compareTo(str2);
         }
         result = chineseCompareTo(m_s1, m_s2);
         return result;
     }

     public static int getCharCode(String s)
     {
         if(s == null && s.equals(""))
             return -1;
         byte b[] = s.getBytes();
         int value = 0;
         for(int i = 0; i < b.length && i <= 2; i++)
             value = value * 100 + b[i];

         return value;
     }

     public static int chineseCompareTo(String s1, String s2)
     {
         int len1 = s1.length();
         int len2 = s2.length();
         int n = Math.min(len1, len2);
         for(int i = 0; i < n; i++)
         {
             int s1_code = getCharCode(s1.charAt(i) + "");
             int s2_code = getCharCode(s2.charAt(i) + "");
             if(s1_code * s2_code < 0)
                 return Math.min(s1_code, s2_code);
             if(s1_code != s2_code)
                 return s1_code - s2_code;
         }

         return len1 - len2;
     }

     public static String getBeginCharacter(String res)
     {
         String a = res;
         String result = "";
         for(int i = 0; i < a.length(); i++)
         {
             String current = a.substring(i, i + 1);
             if(compare(current, "\u554A") < 0)
                 result = result + current;
             else
             if(compare(current, "\u554A") >= 0 && compare(current, "\u5EA7") <= 0)
                 if(compare(current, "\u531D") >= 0)
                     result = result + "Z";
                 else
                 if(compare(current, "\u538B") >= 0)
                     result = result + "Y";
                 else
                 if(compare(current, "\u6614") >= 0)
                     result = result + "X";
                 else
                 if(compare(current, "\u6316") >= 0)
                     result = result + "W";
                 else
                 if(compare(current, "\u584C") >= 0)
                     result = result + "T";
                 else
                 if(compare(current, "\u6492") >= 0)
                     result = result + "S";
                 else
                 if(compare(current, "\u7136") >= 0)
                     result = result + "R";
                 else
                 if(compare(current, "\u671F") >= 0)
                     result = result + "Q";
                 else
                 if(compare(current, "\u556A") >= 0)
                     result = result + "P";
                 else
                 if(compare(current, "\u54E6") >= 0)
                     result = result + "O";
                 else
                 if(compare(current, "\u62FF") >= 0)
                     result = result + "N";
                 else
                 if(compare(current, "\u5988") >= 0)
                     result = result + "M";
                 else
                 if(compare(current, "\u5783") >= 0)
                     result = result + "L";
                 else
                 if(compare(current, "\u5580") >= 0)
                     result = result + "K";
                 else
                 if(compare(current, "\u51FB") > 0)
                     result = result + "J";
                 else
                 if(compare(current, "\u54C8") >= 0)
                     result = result + "H";
                 else
                 if(compare(current, "\u5676") >= 0)
                     result = result + "G";
                 else
                 if(compare(current, "\u53D1") >= 0)
                     result = result + "F";
                 else
                 if(compare(current, "\u86FE") >= 0)
                     result = result + "E";
                 else
                 if(compare(current, "\u642D") >= 0)
                     result = result + "D";
                 else
                 if(compare(current, "\u64E6") >= 0)
                     result = result + "C";
                 else
                 if(compare(current, "\u82AD") >= 0)
                     result = result + "B";
                 else
                 if(compare(current, "\u554A") >= 0)
                     result = result + "A";
         }

         return result.toUpperCase();
     }

     public static String getFirstStr(String str)
     {
         char a = str.charAt(0);
         char aa[] = {
             a
         };
         String sss = new String(aa);
         if(Character.isDigit(aa[0]))
             sss = "data";
         else
         if(a >= 'a' && a <= 'z'|| a >= 'A' && a <= 'Z')
             sss = "character";
         else
             sss = getBeginCharacter(sss);
         return sss;
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letter tt=new Letter();
		String hh = "Éñ»°";
		System.out.println(hh);
		System.out.println(tt.getBeginCharacter(hh));
	}

}
