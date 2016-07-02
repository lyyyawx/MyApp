package nj.hk.lyy.testcontains;

import java.util.List;

import com.google.common.collect.Lists;

public class TestContains {
	
	public static void main(String[] args) {
		List<BaseBean> lists = Lists.newArrayList();
		
		BaseBean bean1 = new BaseBean("刘亚一","27");
		BaseBean bean2 = new BaseBean("刘亚一","18");
		
		lists.add(bean1);
		
		System.out.println(lists.contains(bean2));
	}

	
	
	
}
