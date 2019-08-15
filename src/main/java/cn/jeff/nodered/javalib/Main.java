package cn.jeff.nodered.javalib;

import com.alibaba.fastjson.JSON;

public class Main {

	public static void main(String[] args) {
		class Abc {
			public String topic;
			public String payload;
		}

		Abc abc = new Abc();
		abc.topic = "标题";
		abc.payload = "内容";
		String json = JSON.toJSONString(abc);
		System.out.println("json=" + json);
	}

}
