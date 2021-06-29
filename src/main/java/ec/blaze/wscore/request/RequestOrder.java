package ec.blaze.wscore.request;



import javax.validation.constraints.NotNull;

import lombok.Data;
public class RequestOrder {
	private String id;
	@NotNull
	private String consumer;
	@NotNull
	private String status;
	@NotNull
	private String date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	

    
	
}
