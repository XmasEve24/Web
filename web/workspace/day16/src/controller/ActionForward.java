package controller;

public class ActionForward {
	private boolean redirect; // ���(������ ���ۿ���)
	private String path; // ���
	
	// redirect��� T == ������ ������ ����
	// forward��� F == ������ ������ ����
	
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
