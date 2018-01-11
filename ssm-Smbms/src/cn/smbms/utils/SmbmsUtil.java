package cn.smbms.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SmbmsUtil {
	
	
	public static final String TCP_HOST = "http://127.0.0.1:8003/ImageServer";
	
	
	
	
	
	/**
	 * 执行生成文件名称
	 * @param extension  文件扩展名
	 * @return
	 */
	public static String generateFileName(String extension){
		StringBuffer sb = new StringBuffer();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//格式化时间
		
		Random random = new Random();
		int r = random.nextInt(10000);  // 生成随机数
		
		DecimalFormat decfor = new DecimalFormat("0000");  // 如果随机数小于 4位的话 用该对象布上
		if(extension != null){ // 把 时间 随机数 扩展名拼接成字符串
			sb.append(sdf.format(new Date())).append(decfor.format(r)).append(".").append(extension);
			return sb.toString();
		}
		return null;
		
	}
	
}
