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
		}else if (cmd.equals("/member_list.do")) {
			cmdIf = new MemberListCommand();
		}else if (cmd.equals("/member_delete.do")) {
			cmdIf = new MemberDeleteCommand();
		}else if (cmd.equals("/member_update.do")) {
			cmdIf = new MemberUpdateCommand();
		}else if (cmd.equals("/member_update_ok.do")) {
			cmdIf = new MemberUpdateOkCommand();
		}else if (cmd.equals("/login.do")) {
			cmdIf = new LoginCommand();
		}else if (cmd.equals("/login_ok.do")) {
			cmdIf = new LoginOkCommand();
		}else if (cmd.equals("/logout.do")) {
			cmdIf = new LogoutCommand();
		}
		return cmdIf;
	}
}








