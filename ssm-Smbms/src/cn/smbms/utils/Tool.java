package cn.smbms.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tool {

	public static final String PIC_HOST = "http://127.0.0.1:8003/ImageServer";

	/**
	 * 执行生成文件名称
	 * 
	 * @param extension
	 *            文件扩展名
	 * @return
	 */
	public static String generateFileName(String extension) {
		StringBuffer sb = new StringBuffer();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 格式化时间

		Random random = new Random();
		int r = random.nextInt(10000); // 生成随机数

		DecimalFormat decfor = new DecimalFormat("0000"); // 如果随机数小于 4位的话 用该对象布上
		if (extension != null) { // 把 时间 随机数 扩展名拼接成字符串
			sb.append(sdf.format(new Date())).append(decfor.format(r)).append(".").append(extension);
			return sb.toString();
		}
		return null;

	}

	/**
	 * 乱码问题解决
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param folderPath
	 */
	public static void deFolder(String folderPath) {
		try {
			delAllFile(folderPath);
			File file = new File(folderPath);
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {

			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				// 先删除文件夹里面的文件
				delAllFile(path + "\\" + tempList[i]);
				// 再删除空文件夹
				deFolder(path + "\\" + tempList[i]);
				flag = true;
			}
		}
		return flag;
	}

}
