package nj.hk.lyy.test02;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;

public class TestURLEncoder {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//FileUtils
		
		System.out.println(URLEncoder.encode("http://hkfs.oss-cn-shanghai.aliyuncs.com/FILE/CLINICAL_PIC/X射线图片2.png","utf-8"));
	}
}
