package day12;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MsgHandler extends SimpleTagSupport {
	
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.println("�±� �ڵ鷯Ŭ������� ��°��!");
	}
	

}
