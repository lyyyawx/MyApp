package nj.hk.lyy.test02;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hk.aliyun.oss.OSSConstant;
import com.hk.aliyun.util.OSSUploadUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

public class diancang {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext =   
		          new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		
		String fileDir = "D:\\doc\\org2\\体检报告\\";
		String[] attentionNames = { "png" };
		List<File> picfiles = (List<File>) FileUtils.listFiles(new File(fileDir), attentionNames, false);
		String keyPrifix = "FILE/PHYSICAL_PIC/";
		int i = 0;
		List<Dict> resultList = Lists.newArrayList();
		
		List<String> matchList = FileUtils.readLines(new File("D:\\doc\\match.txt"), Charset.forName("gb2312"));
		Map<String, String> matchMap = Maps.newHashMap();
		for (String string : matchList) {
			String[] aLineArray = StringUtils.splitByWholeSeparator(string, null);
			matchMap.put(aLineArray[1], aLineArray[0]); // 图片关键字：科室名称
		}
		
		List<Dict> clinicalDicts = DictUtils.getDictList("clinical_type");
		for (File file : picfiles) {
			String orgFileName = file.getName();
			String clinicalName = StringUtils.substringBefore(orgFileName, "-");
			if("a".equals(clinicalName)){
				clinicalName = StringUtils.substringBetween(orgFileName, "-");
			}
			
			String realClinicalName = matchMap.get(clinicalName);
			if (StringUtils.isBlank(realClinicalName)) {
				System.err.println(clinicalName);
				continue;
			}
			
			boolean isFound = false;
			String parentId = null;
			for (Dict dict : clinicalDicts) {
				if (realClinicalName.equals(dict.getLabel())) {
					isFound = true;
					parentId = dict.getId();
				}
			}
			if (!isFound) {
				throw new Exception(clinicalName + " 没有找到对应科室");
			}
			

			String fileNumber = StringUtils.substringBetween(orgFileName, "(", ")");
			OSSUploadUtil.fileUpload(keyPrifix + orgFileName, new File(fileDir + orgFileName));

			String url = OSSConstant.endpointUrl + keyPrifix + orgFileName;
			Dict aDict = new Dict();
			aDict.setSearch("admin");  // 供导入时createBy和UpdateBy用
			aDict.setId(IdGen.uuid());
			aDict.setValue(fileNumber);
			aDict.setLabel(orgFileName);
			aDict.setType("physical_pic");
			aDict.setDescription("临床类型图片");
			aDict.setSort(i++);
			aDict.setParentId(parentId);
			aDict.setCreateBy(null);
			aDict.setCreateDate(new Date());
			aDict.setUpdateBy(null);
			aDict.setUpdateDate(new Date());
			aDict.setRemarks(url);
			aDict.setDelFlag("0");

			resultList.add(aDict);
		}

		FileUtils.write(new File("D:\\doc\\org2\\result2.js"), JSON.toJSONStringWithDateFormat(resultList,"yyyy/MM/dd HH:mm:ss",SerializerFeature.WriteDateUseDateFormat), Charset.forName("gb2312"));
		System.exit(0);
	}
}
