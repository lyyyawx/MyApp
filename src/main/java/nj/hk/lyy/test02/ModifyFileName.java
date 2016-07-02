package nj.hk.lyy.test02;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Sets;

public class ModifyFileName {
	public static void main(String[] args) {
		/*
		String[] attentionNames = {"png"};
		List<File> picfiles = (List<File>)FileUtils.listFiles(new File("D:\\doc\\org"), attentionNames, false);
		for (File file : picfiles) {
			String orgFileName = file.getName();
			String fileNumber = StringUtils.substringBetween(orgFileName, "(",")");
//			fileNumber = String.valueOf(Integer.parseInt(fileNumber) % 3 + 1);
			String tempString = StringUtils.substringBefore(orgFileName, " ");
			tempString = StringUtils.substringAfter(tempString, "a-");
			String finalName = tempString + "图片" + fileNumber + ".png";
			System.out.println(orgFileName+ "  =>  " + finalName);
			file.renameTo(new File("D:\\doc\\追加临床类型\\" + finalName));
		}
		*/
		
		String[] attentionNames = {"png"};
		List<File> picfiles = (List<File>)FileUtils.listFiles(new File("D:\\doc\\org"), attentionNames, false);
		Set<String> cliSetNames = Sets.newHashSet();
		for (File file : picfiles) {
			String orgFileName = file.getName();
			
			cliSetNames.add( StringUtils.substringBefore(orgFileName, "图片") );
		}
		
		for (String string : cliSetNames) {
			System.out.println(string);
		}
	}
}
