package nLayeredDemo.core;

import nLayeredDemo.jLogger.JLoggerManager;

public class JloggerManagerAdapter implements LoggerService {

	private JLoggerManager jLoggerService;
	

	public JloggerManagerAdapter() {
		this.jLoggerService = new JLoggerManager();
	}


	@Override
	public void logToSystem(String message) {
		jLoggerService.log(message);
	}

}
