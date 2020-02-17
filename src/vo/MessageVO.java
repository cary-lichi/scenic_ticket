package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * MessageVO��
 * ��Message�����ֶ�һһ��Ӧ�������
 * */
public class MessageVO extends VOBase {
	/**
	 * Message id
	 */
	public int id;
	/**
	 * �û�id
	 */
	public String user_id;
	/**
	 * ��������
	 */
	public String content;
	/**
	 * ����ʱ��
	 */
	public String message_date;


	public MessageVO() {
		super();
	}

	@Override
	public void update(ResultSet res) {
		try {
			// ���ݱ����������ζ�ȡ����
			id = res.getInt(1);
			user_id = res.getString(2);
			content = res.getString(3);
			message_date = res.getString(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
