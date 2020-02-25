package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TicketOrderModel;
import vo.TicketOrderVO;


public class return_ticket extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		// ��ȡsession
		HttpSession session = req.getSession();
		// ��ȡid
		String id = req.getParameter("id");
		// ��ȡtype
		String type = req.getParameter("type");
		// ʵ����TicketOrderModel
		TicketOrderModel model = new TicketOrderModel();
		// ����id��ȡTicketOrderVO
		TicketOrderVO vo = model.getTicketOrder(id);
		if (type.equals("apply")) {
			// ������Ʊ
			// ��ȡ��ǰʱ��
			Date curDate = new Date();
			// ��ȡ�볡ʱ��
			Date enterTime = vo.getDate();
			// �����ֵ ��λ����
			long time = enterTime.getTime() - curDate.getTime();

			// �ж�ʱ���Ƿ����0
			if (time > 0) {
				vo.applyReturnTicket();
				model.updateTicketOrder(vo);
				resp.sendRedirect("/scenic_ticket/index/order_list.jsp");
			} else {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("���볡����24Сʱ���޷���Ʊ");
				resp.setHeader("refresh", "2;/scenic_ticket/index/order_list.jsp");
			}
		}else if (type.equals("agree")) {
			// ͬ����Ʊ
			vo.agreeReturnTicket();
			model.updateTicketOrder(vo);
			resp.sendRedirect("/scenic_ticket/admin/order_list.jsp");
		}


	}
}
