package nj.hk.lyy.testjersey;

public class TextMessageRequestBody {
	private String target_type;
	private String[] target;
	private BaseMsgBody msg;
	private String from;
	
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}
	public String[] getTarget() {
		return target;
	}
	public void setTarget(String[] target) {
		this.target = target;
	}
	public BaseMsgBody getMsg() {
		if(msg == null){
			msg = new BaseMsgBody();
			msg.setType("txt");
		}
		return msg;
	}
	public void setMsg(BaseMsgBody msg) {
		this.msg = msg;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
}


//{
//    "target_type" : "users", // users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
//    "target" : ["u1", "u2", "u3"], // 注意这里需要用数组，数组长度建议不大于20，即使只有一个用户，
//                                   // 也要用数组 ['u1']，给用户发送时数组元素是用户名，给群组发送时  
//                                   // 数组元素是groupid
//    "msg" : {
//        "type" : "txt",
//        "msg" : "hello from rest" //消息内容，参考[[start:100serverintegration:30chatlog|聊天记录]]里的bodies内容
//        },
//    "from" : "jma2" //表示消息发送者。无此字段Server会默认设置为"from":"admin"，有from字段但值为空串("")时请求失败
//}