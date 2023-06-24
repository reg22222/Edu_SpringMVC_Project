package student;

public class CommandFactory {
	private CommandFactory() {}
	private static CommandFactory instance = new CommandFactory();
	public static CommandFactory getinstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("index")) {
			cmdIf = new IndexCommand();
		}else if (cmd.equals("insert")) {
			cmdIf = new InsertCommand();
		}else if (cmd.equals("delete")) {
			cmdIf = new DeleteCommand();
		}else if (cmd.equals("find")) {
			cmdIf = new FindCommand();
		}else if (cmd.equals("list")) {
			cmdIf = new ListCommand();
		}
		return cmdIf;
	}
}
