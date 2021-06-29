package ec.blaze.wscore.request;



import javax.validation.constraints.NotNull;

import lombok.Data;
public class RequestId {
	@NotNull
	private String id;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
