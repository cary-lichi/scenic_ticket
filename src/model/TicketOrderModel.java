package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.TicketOrderVO;

/*
 * TicketOrderModel��
 * ��ticket_order������ķ�װ
 * */
public class TicketOrderModel extends ModelBase {

	/**
	 * ��ö�����������
	 */
	public List<TicketOrderVO> getAllTicketOrder() {
		// ��֯sql��� ��ѯticket_order������
		String sql = "select * from ticket_order order by enter_time desc";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);

		// ʵ����list�����б� ���洢TicketOrderVO�������ݰ�
		List<TicketOrderVO> list = new ArrayList<TicketOrderVO>();
		try {
			// ��ȡ��һ������ ֱ����ȡ�����һ��
			while (res.next()) {
				// ����TicketOrderVO�������ݰ�
				TicketOrderVO vo = getTicketOrderVO(res);
				// �����ݰ���ӵ�list�����б���
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����list�����б�
		return list;
	}

	/**
	 * �����û�id ��ø��û�������������
	 */
	public List<TicketOrderVO> getAllTicketOrderByUserid(String id) {
		// ��֯sql��� ��ѯticket_order������
		String sql = "select * from ticket_order where user_id='" + id + "' order by enter_time desc";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);

		// ʵ����list�����б� ���洢TicketOrderVO�������ݰ�
		List<TicketOrderVO> list = new ArrayList<TicketOrderVO>();
		try {
			// ��ȡ��һ������ ֱ����ȡ�����һ��
			while (res.next()) {
				// ����TicketOrderVO�������ݰ�
				TicketOrderVO vo = getTicketOrderVO(res);
				// �����ݰ���ӵ�list�����б���
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����list�����б�
		return list;
	}

	/**
	 * ���ݶ���id��ö�������
	 */
	public TicketOrderVO getTicketOrder(String id) {
		// ��֯sql��� ��ѯticket_order�������� idΪָ��id��һ������
		String sql = "select * from ticket_order where id='" + id + "'";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);
		try {
			if (res.next()) {
				// ����TicketOrderVO�������ݰ�
				TicketOrderVO vo = getTicketOrderVO(res);
				// ����TicketOrderVO�������ݰ�
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ʧ��ʱ����null������
		return null;
	}

	/**
	 * ���� ��ϵ�����֤ ��ö�������
	 */
	public TicketOrderVO getTicketOrderbyIdCard(String id) {
		// ��֯sql��� ��ѯticket_order�������� idΪָ��id��һ������
		String sql = "select * from ticket_order where user_id_card='" + id + "'";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);
		try {
			if (res.next()) {
				// ����TicketOrderVO�������ݰ�
				TicketOrderVO vo = getTicketOrderVO(res);
				// ����TicketOrderVO�������ݰ�
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ʧ��ʱ����null������
		return null;
	}

	/**
	 * ���Ʊ�Ƿ����
	 */
	private TicketOrderVO getTicketOrderVO(ResultSet res) {
		// ����TicketOrderVO�������ݰ�
		TicketOrderVO vo = new TicketOrderVO();
		// ��res������ӵ�TicketOrderVO�������ݰ���
		vo.update(res);
		// ���Ʊ�Ƿ����
		checkTicketTime(vo);
		// ����TicketOrderVO�������ݰ�
		return vo;
	}

	/**
	 * ���Ʊ�Ƿ����
	 */
	private void checkTicketTime(TicketOrderVO vo) {
		if (vo.isNormal()) {
			// Ʊ״̬Ϊ�����Ž��м��
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
				vo.expiredTicket();
				updateTicketOrder(vo);
			}
		}
	}

	/**
	 * ��ticket_order������Ӷ���
	 */
	public int addTicketOrder(TicketOrderVO vo) {

		// ����sql��� ִ�в�����������
		String sql = "insert into ticket_order (user_name,user_id,enter_time,phone,children_num,adults_num,user_id_card,scenic_id) values('"
				+ vo.user_name + "','" + vo.user_id + "','" + vo.enter_time + "','" + vo.phone + "','" + vo.children_num
				+ "','" + vo.adults_num + "','" + vo.user_id_card + "','" + vo.scenic_id + "')";
		// ִ��sql��� ��num���շ���ֵ �������ݵ�����
		int num = conn.executeInsert(sql);
		// ����num�������ݵ�����
		return num;
	}

	/**
	 * ���¶���
	 */
	public int updateTicketOrder(TicketOrderVO vo) {

		// ����sql��� ִ�в�����������
		String sql = "update ticket_order set " + "state='" + vo.state + "'," + "user_name='" + vo.user_name + "',"
				+ "user_id='" + vo.user_id + "'," + "enter_time='" + vo.enter_time + "'," + "phone='" + vo.phone + "',"
				+ "children_num='" + vo.children_num + "'," + "adults_num='" + vo.adults_num + "'," + "user_id_card='"
				+ vo.user_id_card + "'," + "scenic_id='" + vo.scenic_id + "' " + "where id='" + vo.id + "'";
		// ִ��sql��� ��num���շ���ֵ �������ݵ�����
		int num = conn.executeInsert(sql);
		// ����num�������ݵ�����
		return num;
	}
}
