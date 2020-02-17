package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.oDate;
import model.MessageModel;
import vo.MessageVO;

public class deal_message extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("default/message_board.jsp");
		//�û��Ƿ��Ĳ�����ֱ�Ӻ��Լ���
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		// �ж��Ƿ��¼
		if (session.getAttribute("user_id") == null) {
			resp.sendRedirect("/scenic_ticket/index/login_reg.jsp");
			// ΪʲôҪд����·������Ϊ�û���servlet���������ʺ��û�ֱ�ӷ���ҳ��ʱ��·���ǲ�һ���ģ�����
			// д�ɾ���·��������������
			return;
		}
		// ��ȡ�û�id
		String user_id = session.getAttribute("user_id").toString();
		// ���ñ����ʽΪ utf-8
		req.setCharacterEncoding("utf-8");
		// ʵ����oDate����
		oDate o_date=new oDate();
		// ��ȡ��������
		String content = req.getParameter("message").toString();
		// ��ȡ��ǰʱ��
		String message_date = o_date.get_date();

		if (!content.equals("")) {

			// ʵ����MessageModel����
			MessageModel model = new MessageModel();
			// ʵ����MessageVO����
			MessageVO vo = new MessageVO();
			// �û�id
			vo.user_id = user_id;
			// ��������
			vo.content = content;
			// ����ʱ��
			vo.message_date = message_date;
			// �������
			model.addmessage(vo);
			// ����MessageModel����
			model.destroy();
		}
		resp.sendRedirect("default/message_board.jsp");
	}
}
