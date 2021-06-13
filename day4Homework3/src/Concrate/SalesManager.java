package Concrate;

import Abstract.SalesService;
import Entity.Campaign;
import Entity.Game;
import Entity.User;

public class SalesManager implements SalesService {

	@Override
	public void sale(User user, Game game) {
		System.out.println(user.getName() + " adlý kullanýcý " + game.getName() + " satýn aldý");
		
	}

	@Override
	public void campaignedSale(User user, Game game, Campaign campaign) {
		System.out.println("%" + campaign.getDiscountRate() + " indirim uygulandý!");
		sale(user,game);
	}

}
