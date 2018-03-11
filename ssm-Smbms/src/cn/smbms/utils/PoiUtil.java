package cn.smbms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import cn.smbms.pojo.Html;
import fr.opensagres.poi.xwpf.converter.core.BasicURIResolver;
import fr.opensagres.poi.xwpf.converter.core.FileImageExtractor;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLOptions;

/**
 * Created by will on 2017/6/9. 使用poi将word转为html文件，并从文件中读取内容
 */
public class PoiUtil {
	// 在html中图片保存的相对路径
	private static String imagePath;

	/**
	 * @param source
	 *            word文件的File对象
	 * @param savePath
	 *            图片保存路径
	 * @return 转成的html字符串
	 */
	public static Html getHtml(MultipartFile source, HttpServletRequest request) throws Exception {
		// 获取tomcat路径
		String projectRelUrl = request.getSession().getServletContext().getRealPath("/");
		projectRelUrl = new File(projectRelUrl).getParentFile().getPath()+"/ROOT";
		
		Date date = new Date();
		imagePath = "/images/"+ date.getTime();
		String imagePathStr = projectRelUrl + File.separator + "images" + File.separator+ date.getTime();
		String content;
//		String imgEnd = "";
		// 判断word文档类型，使用不同方法进行转换
		if (source.getOriginalFilename().endsWith(".doc")) {
			content = docToStr(source, source.getOriginalFilename(), imagePathStr);
		} else if (source.getOriginalFilename().endsWith(".docx")) {
			content = docxToStr(source, source.getOriginalFilename(), imagePathStr);
			// 转换docx文件得到的图片路径
//			imgEnd = "word/media/";
		} else {
			return new Html();
		}
		// 利用正则表达式过滤无用标签和属性
//		content = RegexAnswerUtil.clear(content);
		Html html = new Html();
		html.setHtml(content);
		html.setImagesParentFileUrl(imagePathStr);
		return html;
	}

	// doc转换为html
	public static String docToStr(MultipartFile source, String sourceFileName, String imagePathStr) throws Exception {
		String targetFileName = imagePathStr + ".html";
		File target = new File(targetFileName);
		target.getParentFile().mkdirs();
		HWPFDocument wordDocument = new HWPFDocument(source.getInputStream());
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
		// 保存图片，并返回图片的相对路径
		wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
			try (FileOutputStream out = new FileOutputStream(new File(imagePathStr + name))) {
				out.write(content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Constants.SERVICE_URL+imagePath + "/" + name;
		});
		wordToHtmlConverter.processDocument(wordDocument);
		Document htmlDocument = wordToHtmlConverter.getDocument();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(new File(targetFileName));
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		String content = splitContext(targetFileName);
		// 删除生成的html文件
		File file = new File(targetFileName);
		file.delete();
		return content;
	}

	// docx转换为html
	public static String docxToStr(MultipartFile source, String sourceFileName, String imagePathStr) throws Exception {
		String targetFileName = imagePathStr + ".html";
		System.out.println("targetFileName:" + targetFileName);
		File target = new File(targetFileName);
		target.getParentFile().mkdirs();
		OutputStreamWriter outputStreamWriter = null;
		try {
			XWPFDocument document = new XWPFDocument(source.getInputStream());
			XHTMLOptions options = XHTMLOptions.create();
			// 存放图片的文件夹
			options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
			// html中图片的路径
			options.URIResolver(new BasicURIResolver(Constants.SERVICE_URL+imagePath));
			// 设置图片文件夹保存的路径以及文件夹名称
//			options.setImageManager(new ImageManager(new File(imagePathStr), sourceFileName.substring(0, sourceFileName.lastIndexOf("."))));
			
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(target), "utf-8");
			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
			xhtmlConverter.convert(document, outputStreamWriter, options);
		} finally {
			if (outputStreamWriter != null) {
				outputStreamWriter.close();
			}
		}
		String content = splitContext(targetFileName);
		// 删除生成的html文件
		File file = new File(targetFileName);
		file.delete();
		return content;
	}

	/**
	 * docx文件转html会生成html编码 该方法能转换大部分 富文本编辑器中可以不做处理
	 */
	public static String htmlEncoding(String html) {
		String regExp = "&#\\d*;";
		Matcher m = Pattern.compile(regExp).matcher(html);
		StringBuffer sb = new StringBuffer();
		if (!m.find()) {
			sb.append(html);
		} else {
			while (m.find()) {
				String s = m.group(0);
				s = s.replaceAll("(&#)|;", "");
				char c = (char) Integer.parseInt(s);
				m.appendReplacement(sb, Character.toString(c));
			}
		}
		return sb.toString();
	}

	/**
	 * 读取转换得到的html文件，并过滤多余空行
	 */
	public static String splitContext(String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			reader = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
				if (!tempString.equals("")) {
					sb.append("\n");
				}
			}
			reader.close();
			String content = sb.toString().replaceAll("\\n+", "\n");
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return "";
	}
}
