package member;

public class MemberCommandFactory {
	private MemberCommandFactory() {}
	private static MemberCommandFactory instance = new MemberCommandFactory();
	public static MemberCommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/member_index.do")) {
			cmdIf = new MemberIndexCommand();
		}else if (cmd.equals("/member_ssn.do")) {
			cmdIf = new MemberSsnCommand();
		}else if (cmd.equals("/member_check.do")) {
			cmdIf = new MemberCheckCommand();
		}else if (cmd.equals("/member_input.do")) {
			cmdIf = new MemberInputCommand();
		}else if (cmd.equals("/member_input_ok.do")) {
			cmdIf = new MemberInputOkCommand();
		}
		return cmdIf;
	}
}








