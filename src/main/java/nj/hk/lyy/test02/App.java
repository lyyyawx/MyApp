package nj.hk.lyy.test02;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		App instance = new App();
		// 1. 解析原始的neta数据
//		List<String> datas = FileUtils.readLines(new File("C:\\Users\\HK\\Desktop\\citys.js"),
//				Charset.forName("utf-8"));
//		List<Area> resultLists = new ArrayList<Area>();
		
//		instance.analyzeProvince(datas, resultLists);
//		String resultStr = JSON.toJSONString(resultLists);
//		FileUtils.writeStringToFile(new File("C:\\Users\\HK\\Desktop\\mydata.json"), resultStr, "utf-8", false);
		
		// 2. 设置parentid
		String jsonStr = FileUtils.readFileToString(new File("C:\\Users\\HK\\Desktop\\sys_area.json"), "utf-8");
		List<Area> lists = JSON.parseArray(jsonStr, Area.class);
		System.out.println(lists.size());
		
		for (Area area : lists) {
			if(area.getId().intValue() != 1 && area.getParent_id() == null){
				String parentCode = area.getParent_code();
				if(parentCode == null){
					System.err.println(area.getId());
				}
				Area parentArea = instance.getAreaByCode(parentCode, lists);
				Long parentId = parentArea.getId();
				area.setParent_id(parentId);
			}
			
			// 3. 设置parentids
			if(area.getId().intValue() != 1 && area.getParent_ids() == null){
				LinkedList<Long> parents = Lists.newLinkedList();	
				Long parentId = area.getParent_id();  // 1. 先找父亲
				
				parents.addFirst(parentId);
				
				while (parentId != null) {
					Area parentArea = instance.getAreaById(parentId, lists);
					parentId = parentArea.getParent_id();
					if(parentId != null){
						parents.addFirst(parentId);
					}
				}
				
				String parent_ids = "";
				for (Long aLong : parents) {
					parent_ids = parent_ids + aLong + ",";
				}
				if(StringUtils.isNotBlank(parent_ids)){
					parent_ids = StringUtils.substringBeforeLast(parent_ids, ",");
					area.setParent_ids(parent_ids);
				}
			}
		}
		
		FileUtils.writeStringToFile(new File("C:\\Users\\HK\\Desktop\\mydata.json"), JSON.toJSONString(lists), "gb2312", false);
	}

	public void analyzeProvince(List<String> datas, List<Area> resultLists) {
		boolean startScanCity = false;
		int provinceCount = 0;
		String parentCityCode = "";
		Map<String, String> cities = new HashMap<String, String>();
		
		for (String aLine : datas) {
			String trimLine = StringUtils.trim(aLine);
			if (StringUtils.startsWith(trimLine, "{code:")) {
				String[] tempRes = StringUtils.substringsBetween(aLine, "'", "'");
				String proCode = tempRes[0];
				String proName = tempRes[1];
				Area area = new Area();
				area.setCode(proCode);
				area.setName(proName);
				area.setType("2");
				area.setParent_code("156");
				area.setParent_id(1l);
				
				resultLists.add(area);
				provinceCount++;
				System.out.println(proCode + ":" + proName);
			}
			if(StringUtils.startsWith(aLine, "// 省份结束----")){
				startScanCity = true;
			}
			// 开始扫描城市
			if(startScanCity){
				// 一个城市开始标签，获取
				if(StringUtils.endsWith(trimLine, ": {")){
					parentCityCode = StringUtils.substringBefore(trimLine, ":");
				}
				else if(StringUtils.endsWith(trimLine, "',") || StringUtils.endsWith(trimLine, "'")){
					String key = StringUtils.substringBefore(trimLine, ":");
					String value = StringUtils.substringBetween(trimLine, "'", "'");
					cities.put(key, value);
				}
				else if(StringUtils.endsWith(trimLine, "},")){
					if(StringUtils.isNotEmpty(parentCityCode) && cities.size() > 0){
						Area parentArea = getAreaByCode(parentCityCode, resultLists);
						if(parentArea == null){
							throw new RuntimeException("数据出错了");
						}
						
						Iterator<Entry<String, String>> iterator = cities.entrySet().iterator();
						while(iterator.hasNext()){
							Entry<String, String> entry = iterator.next();
							Area newArea = new Area();
							newArea.setCode(entry.getKey());
							newArea.setName(entry.getValue());
							newArea.setParent_code(parentArea.getCode());
							newArea.setParent_id(parentArea.getId());
							newArea.setType(String.valueOf(( Integer.parseInt(parentArea.getType()) + 1)));
							resultLists.add(newArea);
 						}
					}
					
					// 清空数据
					cities.clear();
					parentCityCode = "";
				}
			}
		}
		System.out.println("省份数目:" + provinceCount);
	}
	
	private Area getAreaByCode(String code, List<Area> resultLists){
		if(resultLists == null){
			return null;
		}
		for (Area area : resultLists) {
			if(code.equals(area.getCode())){
				return area;
			}
		}
		return null;
	}
	
	private Area getAreaById(Long id, List<Area> resultLists){
		if(resultLists == null){
			return null;
		}
		for (Area area : resultLists) {
			if(id.equals(area.getId())){
				return area;
			}
		}
		return null;
	}
	
	
}
