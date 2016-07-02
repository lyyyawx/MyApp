package nj.hk.lyy.testjersey;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class TestClient {
	private static String token = null;
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			Thread.sleep(100);
			sendTxtMsg(i);
			
		}
//		Long today = new Date().getTime();
//		Long todayBeforeOneHour = today - 1000 * 60 * 60;
//		System.out.println(new Date().getTime() - 1000 * 60 * 60);
	}

	private static TokenResponseBody getHuanxinToken() throws Exception {
		Client client = ClientBuilder.newClient();
		TokenRequestBody tokenRequestBody = new TokenRequestBody();

		Response responseResult = client.target(Constants.LOGIN_URL).path("token").register(JacksonJsonProvider.class).request()
				.buildPost(Entity.entity(tokenRequestBody, MediaType.APPLICATION_JSON)).invoke();
		if( responseResult.getStatus() != 200){
			throw new Exception("获取环信授权失败");
		}

		TokenResponseBody result = responseResult.readEntity(TokenResponseBody.class);
		System.out.println("Bearer " + result.getAccess_token());
		return result;
	}
	
	private static void sendTxtMsg(int value) throws Exception{
		if(token == null){
			token = getHuanxinToken().getAccess_token();
		}
		
		Client client = ClientBuilder.newClient();
		TextMessageRequestBody requestBody = new TextMessageRequestBody();
		requestBody.setFrom("周总"); //1123490  1123512
		requestBody.setTarget_type("users");
		requestBody.getMsg().setMsg(value + " 你好，我是刘亚一 ");
		requestBody.setTarget(new String[]{"2892"});
		
		System.out.println(JSON.toJSONString(requestBody));
		
		Response responseResult = client.target(Constants.LOGIN_URL).path("messages").register(JacksonJsonProvider.class).request()
				.header("Authorization", "Bearer " + token)
				.buildPost(Entity.entity(requestBody, MediaType.APPLICATION_JSON)).invoke();
		
		if( responseResult.getStatus() != 200){
			throw new Exception("发送文本信息失败");
		}else{
			//System.out.println("发送文本信息成功");
		}
		
	}
}
