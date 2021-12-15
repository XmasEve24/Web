package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
// ������� ��� ��û�� FC�� ���ϰ��ؾ���!!!
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ��û�� �ľ�
		String uri=request.getRequestURI();
		System.out.println(uri);
		String cp=request.getContextPath();
		System.out.println(cp);
		String command=uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward = null;
		// 2. �� ��û�� ���� Controller ó���� ����
		if(command.equals("/main.do")) {
			 try {
				forward = new MainAction().execute(request, response);
				// 1. ������ ���ۿ��� == ������ ���޹��  (forward : �����Ұ� �������)
				// 2. ���ϴ� ����������
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/board.do")) {
			try {
				forward = new BoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/insert.do")) {
			try {
				forward = new InsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/update.do")) {
			try {
				forward = new UpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.do")) {
			try {
				forward = new DeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null) { // ���ܵ��� �߻��ϸ� null�ϼ�������
			if(forward.isRedirect()) { // ���������ͼ��� �߻����ɼ�����
				response.sendRedirect(forward.getPath());
			}
			else {
				// pageContext.forward();
				// �����ؾ��� ������ �������� �ǹ�
				// [RequestDispatcher API�� ���]
				//  : ��û ������ ����� �������ִ� API
				//  : Ŭ���̾�Ʈ�κ��� ��û���� ������ ���� ���������ʰ�
				//    �ٸ� �ڿ��� �Ѱܹ޾� ó�� ����� ��� �����ϴ� ��
				//    == Ŭ���̾�Ʈ�� ��û�� ���Ͽ� ������ �ٸ� ������� �� ��û�� ó���ϵ��� �������ϴ� ��
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request,	response);
			}
			
		}
	}
}
