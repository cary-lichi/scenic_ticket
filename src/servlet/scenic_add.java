package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.db_conn;

public class scenic_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����������ʼ��ȡ���ֲ���
		req.setCharacterEncoding("utf-8");
		// ��������
		String scenic_name = req.getParameter("scenic_name");
		// ����ʱ��
		String open_time = req.getParameter("open_time");
		// ����Ʊ�۸�
		String adults_price_str = req.getParameter("adults_price");
		Integer adults_price = Integer.parseInt(adults_price_str);
		// ��ͯƱ�۸�
		String children_price_str = req.getParameter("children_price");
		Integer children_price = Integer.parseInt(children_price_str);
		// ��������
		String scenic_describe = req.getParameter("scenic_describe");
		// ����λ��
		String scenic_position = req.getParameter("scenic_position");
		// ������ȡ����

		// �������ݿ�����
		db_conn conn = new db_conn();
//����sql���  ִ�в�����������
		String sql = "insert into scenic (scenic_name,open_time,price,price_children,scenic_describe,position) values('"
				+ scenic_name + "','" + open_time + "'," + adults_price + "," + children_price + ",'" + scenic_describe
				+ "','" + scenic_position + "')";
		// ִ��sql���
		conn.executeInsert(sql);
		//��ת�������б����
		resp.sendRedirect("admin/scenic_list.jsp");

	}
}
