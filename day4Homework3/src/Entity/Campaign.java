package Entity;

import Abstract.Entity;

public class Campaign implements Entity {
	private int id;
	private String campaignName;
	private int discountRate;
	
	public Campaign() {

	}

	public Campaign(int id, String campaignName, int discountRate) {
		this.id = id;
		this.campaignName = campaignName;
		this.discountRate = discountRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
