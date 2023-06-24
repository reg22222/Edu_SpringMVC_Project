package board;

public class BoardCommandFactory {
	private BoardCommandFactory() {}
	private static BoardCommandFactory instance = new BoardCommandFactory();
	public static BoardCommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/board_list.do")){
			cmdIf = new BoardListCommand();
		}else if (cmd.equals("/board_index.do")) {
			cmdIf = new BoardIndexCommand();
		}else if (cmd.equals("/board_writeForm.do")) {
			cmdIf = new BoardWriteFormCommand();
		}else if (cmd.equals("/board_writePro.do")) {
			cmdIf = new BoardWriteProCommand();
		}else if (cmd.equals("/board_content.do")) {
			cmdIf = new BoardContentCommand();
		}else if (cmd.equals("/board_deleteForm.do")) {
			cmdIf = new BoardDeleteFormCommand();
		}else if (cmd.equals("/board_deletePro.do")) {
			cmdIf = new BoardDeleteProCommand();
		}else if (cmd.equals("/board_updateForm.do")) {
			cmdIf = new BoardUpdateFormCommand();
		}else if (cmd.equals("/board_updatePro.do")) {
			cmdIf = new BoardUpdateProCommand();
		}
		return cmdIf;
	}
}








