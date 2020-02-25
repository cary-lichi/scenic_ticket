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



public class deal_order extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		if(session.getAttribute("user_id")!=null) {
			// ʵ���� TicketOrderVO
			TicketOrderVO vo = new TicketOrderVO();
			// ��ȡ��������
			vo.user_id = session.getAttribute("user_id").toString();
			vo.user_name = req.getParameter("user_name");
			vo.enter_time = req.getParameter("enter_time");
			vo.phone = req.getParameter("phone");
			vo.children_num = req.getParameter("children_num");
			vo.adults_num = req.getParameter("adults_num");
			vo.user_id_card = req.getParameter("user_id_card");
			vo.scenic_id = req.getParameter("scenic_id");
			
			// �жϲ����Ƿ�Ϊ��
			if (vo.user_name != "" && vo.user_id_card != "" && vo.enter_time != "" && vo.phone != ""
					&& vo.adults_num != "" && vo.children_num != "" && vo.scenic_id != "") {

				// ʵ����TicketOrderModel
				TicketOrderModel model = new TicketOrderModel();

				// ��ȡ��ǰʱ��
				Date curDate = new Date();
				// ��ȡ�볡ʱ��
				Date enterTime = vo.getDate();

				// �����ֵ ��λ����
				long time = curDate.getTime() - enterTime.getTime();
				// һ���ж��ٺ���
				long day = 24 * 60 * 60 * 1000;

				if (time > day) {
					// ���ڵ�Ʊ ���볡�Ѿ�����24Сʱ
					resp.setContentType("text/html;charset=utf-8");
					PrintWriter out = resp.getWriter();
					out.println("����ѡ���ڵ���Ʊ�Ѿ�ͣ��");
					resp.setHeader("refresh", "2;url=default/order.jsp");
				} else {
					int addnum = model.addTicketOrder(vo);
					if (addnum > 0) {
						resp.sendRedirect("/scenic_ticket/user_center?type=order_list");
					}
				}
			} else {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println("����д��������Ϣ");
				resp.setHeader("refresh", "2;url=default/order.jsp");
			}
		}

	}
}
