package com.waylau.spring.boot.thymeleaf.repository.es;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.waylau.spring.boot.thymeleaf.domain.es.EsBlog;

/**
 * Hello World 控制器测试类
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2017年1月26日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRespositoryTest {

	
	@Autowired
	private EsBlogRepository esBlogRepository;
	
	@Before
	public void initData() {
		System.out.println(">>>>>>>initData<<<<<<");
		//清楚索引
		esBlogRepository.deleteAll();
		//添加索引
		esBlogRepository.save(new EsBlog("1","老卫跟你谈谈安装 Elasticsearch","关于如何来安装 Elasticsearch，这个请看我的博客 https://waylau.com"));
		esBlogRepository.save(new EsBlog("2","老卫跟你谈谈 Elasticsearch 的几个用法",
				"关于如何来用 Elasticsearch，还是得看我的博客 https://waylau.com，妹"));  // 关键字"妹"
		esBlogRepository.save(new EsBlog("3","老卫和你一起学 Elasticsearch",
				"如何来学习 Elasticsearch，最终看我的博客 https://waylau.com，酒")); // 关键字"酒"
		
		esBlogRepository.save(new EsBlog("4","03-05 用大白话聊聊分布式系统",
				"一提起“分布式系统”，大家的第一感觉就是好高大上啊，深不可测"));
		esBlogRepository.save(new EsBlog("5","02-19 Thymeleaf 3 引入了新的解析系统",
				"如果你的代码使用了 HTML5 的标准，而Thymeleaf 版本来停留在 2.x ，那么如果没有把闭合"));  
		esBlogRepository.save(new EsBlog("6","02-19 使用 GFM Eclipse 插件时，不在项目里面生成 HTML 文件",
				"GFM 是 GitHub Flavored Markdown Viewer 的简称，是一款对 GitHub 友好的 Markdown 编辑器 。"));  
	
	}
	
    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContontContaining() throws Exception {
    	Pageable pageable = new PageRequest(0, 20);
    	String title = "1";
    	String summary = "老卫";
    	String content = "编辑器";
    	Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
    	System.out.println("----------------------------------");
    	System.out.println(page.getTotalElements());
    }
}
