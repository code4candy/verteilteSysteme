package sockets.server;

public class AddService extends Command {

	AddService() {
		super();
	}
	
	@Override
	public String process(String[] args) {
		int result = 0;
		for(int i=1; i<args.length; i++){
			result += Double.parseDouble(args[i]);
		}
		return Double.toString(result);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "add";
	}
	
}
