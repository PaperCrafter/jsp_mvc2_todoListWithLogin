package action;

public class MemberActionFactory {
	//factory, singletone pattern
	private static MemberActionFactory instance = null;
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(instance == null) {
			instance = new MemberActionFactory();
		}
		return instance;
	}
	
	public Action makeAction(String command) {
		Action action = null;
		if(command.equals("signin_form")) {
			action = new MemberFormAction();
		}else if(command.equals("regist")) {
			action = new MemberRegistAction();
		}else if(command.equals("Login")) {
			action = new MemberLoginAction();
		}
		return action;
	}
}
