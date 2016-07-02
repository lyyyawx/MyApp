package nj.hk.lyy.test02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class ClinicalPicExistService {

	public static void main(String[] args) throws IOException {
		List<String> clinicalsLines = FileUtils.readLines(new File("D:\\doc\\clinicals.txt"), Charset.forName("gb2312"));
		List<String> picsLines = FileUtils.readLines(new File("D:\\doc\\pics.txt"), Charset.forName("gb2312"));
		List<String> clinicalsWithoutPic = Lists.newArrayList();
		
		for (String clinicalName : clinicalsLines) {
			boolean hitName = false;
			for (String aPicName : picsLines) {
				if(StringUtils.contains(aPicName, clinicalName)){
					hitName = true;
					break;
				}
			}
			if(!hitName){
				clinicalsWithoutPic.add(clinicalName);
			}
		}
		
		for (String string : clinicalsWithoutPic) {
			System.out.println(string);
		}
	}

}
