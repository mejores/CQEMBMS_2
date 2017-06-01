package com.edu.util;

import java.security.MessageDigest;

public class MD5Encoder {
public String toMD5(String chars){
	char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
	try {
        /*byte[] btInput = chars.getBytes("utf-8");
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < md.length; i++) {
            int val = ((int) md[i]) & 0xff;
            if (val < 16){
            	sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString();*/
		
		 byte[] btInput = chars.getBytes();
         // 获得MD5摘要算法的 MessageDigest 对象
         MessageDigest mdInst = MessageDigest.getInstance("MD5");
         // 使用指定的字节更新摘要
         mdInst.update(btInput);
         // 获得密文
         byte[] md = mdInst.digest();
         // 把密文转换成十六进制的字符串形式
         int j = md.length;
         char str[] = new char[j * 2];
         int k = 0;
         for (int i = 0; i < j; i++) {
             byte byte0 = md[i];
             str[k++] = hexDigits[byte0 >>> 4 & 0xf];
             str[k++] = hexDigits[byte0 & 0xf];
         }
         return new String(str);
    } catch (Exception e) {
    	System.out.println("转MD5出错");
        return null;
    }
}
/*public static void main(String[] args) {
	System.out.println(MD5Encoder.toMD5("关于开放就业系统2017届毕业生签约派遣信息录入权限的通知届毕业生签约派遣信息录入权限的(1)2016-03-25"));
	System.out.println(MD5Encoder.toMD5("关于开放就业系统2017届毕业生fshfo签约派遣信息录入权系统2017届毕业生fshfo签约派遣信息录入权限的限的通知(1)2016-03-25").length());
}*/

}
