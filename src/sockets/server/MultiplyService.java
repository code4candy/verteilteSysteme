package sockets.server;

public class MultiplyService extends Command {

	MultiplyService() {
		super();
	}

	@Override
	public String process(String[] args) {
		double result = 1;
		for(int i=1; i<args.length; i++){
			result *= Double.parseDouble(args[i]);
		}
		return Double.toString(result);
	}

	@Override
	public String getName() {
		return "multiply";
	}

}
