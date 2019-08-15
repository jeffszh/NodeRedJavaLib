import cn.jeffszh.lib.node.red.java.NodeRedNode;
import com.alibaba.fastjson.JSONObject;

public class MyNode extends NodeRedNode {

	@Override
	protected void onInput(JSONObject msg) {
		@SuppressWarnings("WeakerAccess")
		class Obj {
			public String topic;
			public String payload;
		}

		Obj obj = new Obj();
		obj.topic = "标题";
		obj.payload = msg.toString();
		writeOutput(obj);
	}

}
