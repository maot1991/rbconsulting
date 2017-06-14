package com.rbconsulting.web.Action;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

import com.rbconsulting.web.Bean.Mentor.*;
import com.rbconsulting.web.Dao.MentorDao;
import com.rbconsulting.web.Dao.UserDao;


@Configuration
public class IndexAction {
  	
	@Autowired
	private MentorDao dao;
	
  	@Bean(name = "carouselContents")
    public JSONArray getCarouselContents() throws JSONException {
  		JSONArray objs = new JSONArray();
  		String[] titles = {"我们的服务", "我们的团队","更多关于我们"};
  		String[] contents = {
  				"颠覆传统申请服务模式，摆脱千篇一律的死板文书，不再受困于平庸的申请辅导！根据每位客户的详细背景、个人特色和职业发展，全方位打造独一无二的全方位留学申请辅导，让你在申请中脱颖而出。", 
  				"我们拥有最专业的团队，从学校定位到网申服务，每一个环节都有优秀的导师服务。我们的规模不断壮大，团队成员均毕业于哥伦比亚大学、卡内基梅隆大学、约翰霍普金斯大学、佐治亚理工学院、伦敦大学、清华大学、北京大学、上海交通大学等国内外知名高校。",
  				"想了解更多资讯，请联系我们！思源瑞博，打造专业留学服务！"
  		};
  		String host = "https://s3.eu-central-1.amazonaws.com/siyuanrainbow/img/com/index/carousel/";
  		String[] links = {"了解我们","关注我们","更多信息"};
  		for (int i = 0; i < 3 ; i++){
  	  		JSONObject obj = new JSONObject();
  	  		if ( i == 0 ) {
  	  			obj.put("active", 1);
  	  		} else {
  	  			obj.put("active", 0);
  	  		}
  	  		obj.put("title",titles[i]);
	  	  	obj.put("intro",contents[i]);
	  	  	obj.put("img",host+"carousel_"+i+".jpg");
	  	  	obj.put("link",links[i]);
	  	  	objs.put(obj);
  		}
//  		System.out.println(objs[0])
  		return objs;
    }
}
