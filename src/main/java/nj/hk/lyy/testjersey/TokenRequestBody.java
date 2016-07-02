package nj.hk.lyy.testjersey;

public class TokenRequestBody {
	private String grant_type = "client_credentials";
	private String client_id = Constants.APP_CLIENT_ID;
	private String client_secret = Constants.APP_CLIENT_SECRET;
	
	public String getGrant_type() {
		return grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	
	
}
