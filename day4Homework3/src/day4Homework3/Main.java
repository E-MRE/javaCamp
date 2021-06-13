package day4Homework3;

import Adapters.MernisServiceAdapter;
import Concrate.*;
import Entity.Campaign;
import Entity.Game;
import Entity.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(0,"Emre","12312312","1990");
		User newUser = new User(1,"Betül","1233456456","1995");

		Game game = new Game(0,"AGB",44.99);
		
		Campaign campaign = new Campaign(0, "yeni üye kampanyasý", 25);
		
		UserManager userManager = new UserManager(new MernisServiceAdapter());
		userManager.register(user);
		
		GameManager gameManager = new GameManager();
		gameManager.add(game);
		
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign);
		
		SalesManager salesManager = new SalesManager();
		salesManager.sale(user, game);
		salesManager.campaignedSale(newUser, game, campaign);
	}

}
