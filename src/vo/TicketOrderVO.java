package vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * �볡ʱ��
	 */
	public Date getDate() {

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = simpleDateFormat.parse(enter_time);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

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
	/**
	 * ��ǰ״̬��0����״̬��1������Ʊ��2������Ʊ ��3:�ѹ���
	 */
	public String state;

	/**
	 * �Ƿ�����
	 */
	public boolean isNormal() {
		return state.equals("0");
	}

	/**
	 * �Ƿ�������Ʊ
	 */
	public boolean isApplyReturnTicket() {
		return state.equals("1");
	}

	/**
	 * �Ƿ��Ѿ���Ʊ
	 */
	public boolean isReturnTicket() {
		return state.equals("2");
	}

	/**
	 * �Ƿ����
	 */
	public boolean isExpired() {
		return state.equals("3");
	}

	/**
	 * ��ȡ��ǰ״̬
	 */
	public String getState() {
		String res = "����";
		if (isNormal()) {
			res = "����";
		}
		if (isApplyReturnTicket()) {
			res = "������Ʊ";
		}
		if (isReturnTicket()) {
			res = "����Ʊ";
		}
		if (isExpired()) {
			res = "�ѹ���";
		}

		return res;
	}

	/**
	 * ����״̬Ϊ������Ʊ
	 */
	public void applyReturnTicket() {
		state = "1";
	}

	/**
	 * ����״̬Ϊ����Ʊ
	 */
	public void agreeReturnTicket() {
		state = "2";
	}

	/**
	 * ����״̬Ϊ�ѹ���
	 */
	public void expiredTicket() {
		state = "3";
	}

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
			state = res.getString(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
