package sockets.server;

public class SubstractService extends Command {

	SubstractService() {
		super();
	}

	@Override
	public String process(String[] args) {
		double result = Double.parseDouble(args[1]);
		for(int i=2; i<args.length; i++){
			result -= Double.parseDouble(args[i]);
		}
		return Double.toString(result);
	}

	@Override
	public String getName() {
		return "substract";
	}

}
