package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScenicModel;
import vo.ScenicVO;

public class scenic_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ñ����ʽΪutf-8
		req.setCharacterEncoding("utf-8");
		// ʵ���� ScenicVO
		ScenicVO vo = new ScenicVO();
		// ��������
		vo.scenic_name = req.getParameter("scenic_name");
		// ����ʱ��
		vo.open_time = req.getParameter("open_time");
		// ����Ʊ�۸�
		vo.price_adults = req.getParameter("adults_price");
		// ��ͯƱ�۸�
		vo.price_children = req.getParameter("children_price");
		// ��������
		vo.scenic_describe = req.getParameter("scenic_describe");
		// ����λ��
		vo.scenic_position = req.getParameter("scenic_position");

		// ʵ���� ScenicModel
		ScenicModel model = new ScenicModel();
		// ��scenic������Ӿ���
		model.addScenic(vo);
		// ����ScenicModel����
		model.destroy();
		//��ת�������б����
		resp.sendRedirect("admin/scenic_list.jsp");

	}
}
