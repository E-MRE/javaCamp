package inheritance;

public class SendikaCustomer extends Customer {
	private String sendikaBiseyi;
	
	public SendikaCustomer() {
		
	}
	
	public SendikaCustomer(String sendikaBiseyi) {
		super();
		this.sendikaBiseyi = sendikaBiseyi;
	}

	public String getSendikaBiseyi() {
		return sendikaBiseyi;
	}

	public void setSendikaBiseyi(String sendikaBiseyi) {
		this.sendikaBiseyi = sendikaBiseyi;
	}
	
	
}
