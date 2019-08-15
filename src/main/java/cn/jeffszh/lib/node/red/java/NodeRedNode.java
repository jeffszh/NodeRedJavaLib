package cn.jeffszh.lib.node.red.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class NodeRedNode {

	public void run() {
		onStart();

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		//noinspection InfiniteLoopStatement
		for (; ; ) {
			try  {
				String line = stdin.readLine();
				JSONObject obj = JSON.parseObject(line);
				onInput(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("WeakerAccess")
	protected void onStart() {
	}

	protected abstract void onInput(JSONObject msg);

	protected void writeOutput(Object msg) {
		String outStr = JSON.toJSONString(msg, SerializerFeature.BrowserCompatible);
		System.out.println(outStr);
	}

}
