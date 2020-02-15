package vo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * TicketOrderVO��
 * ��ticket_order�����ֶ�һһ��Ӧ�������
 * */
public class TicketOrderVO extends VOBase {
	/**
	 * Scenic id
	 */
	public int id;
	/**
	 * ��ϵ������
	 */
	public String user_name;
	/**
	 * �û�id
	 */
	public String user_id;
	/**
	 * �볡ʱ��
	 */
	public String enter_time;
	/**
	 * �ֻ���
	 */
	public String phone;
	/**
	 * �����ͯƱ����
	 */
	public String children_num;
	/**
	 * ����Ʊ����
	 */
	public String adults_num;
	/**
	 * ��ϵ�����֤
	 */
	public String user_id_card;
	/**
	 * ����id
	 */
	public String scenic_id;

	@Override
	public void update(ResultSet res) {
		try {
			// ���ݱ����������ζ�ȡ����
			id = res.getInt(1);
			user_name = res.getString(2);
			user_id = res.getString(3);
			Date time = res.getDate(4);
			enter_time = time.toString();
			phone = res.getString(5);
			children_num = res.getString(6);
			adults_num = res.getString(7);
			user_id_card = res.getString(8);
			scenic_id = res.getString(9);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
