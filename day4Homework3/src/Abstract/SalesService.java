package Abstract;

import Entity.Campaign;
import Entity.Game;
import Entity.User;

public interface SalesService {
	void sale(User user, Game game);
	void campaignedSale(User user, Game game, Campaign campaign);
}
