package sockets.server;

abstract class Command {

	public Command() {}

	public abstract String getName();
	
	public abstract String process(String[] args);
	
	public static Command getService(String name) {
		switch(name) {
		case "add":	
			return new AddService();
		case "substract": 
			return new SubstractService();
		case "multiply": 
			return new MultiplyService();
		default: 
			throw new RuntimeException("Invalid name: " + name);
		}
		
	}

}
