package Abstract;

import Entity.User;

public interface UserService {
	void register(User user);
	void update(User user);
	void delete(User user);
}
