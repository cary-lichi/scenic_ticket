package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.MessageVO;

/*
 * messageModel��
 * ��message������ķ�װ
 * */
public class MessageModel extends ModelBase {

	/**
	 * ���������������
	 */
	public List<MessageVO> getAllmessage() {
		// ��֯sql��� ��ѯmessage���Ա�
		String sql = "select * from message";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);

		// ʵ����list�����б� ���洢MessageVO�������ݰ�
		List<MessageVO> list = new ArrayList<MessageVO>();
		try {
			// ��ȡ��һ������ ֱ����ȡ�����һ��
			while (res.next()) {
				// ����MessageVO�������ݰ�
				MessageVO vo = new MessageVO();
				// ��res������ӵ�MessageVO�������ݰ���
				vo.update(res);
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
	 * ��������id�����������
	 */
	public MessageVO getmessage(String id) {
		// ��֯sql��� ��ѯmessage���Ա��� idΪָ��id��һ������
		String sql = "select * from message where id='" + id + "'";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);
		try {
			if (res.next()) {
				// ����MessageVO�������ݰ�
				MessageVO vo = new MessageVO();
				// ��res������ӵ�MessageVO�������ݰ���
				vo.update(res);
				// ����MessageVO�������ݰ�
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
	 * ��message�����������
	 */
	public int addmessage(MessageVO vo) {

		// ����sql��� ִ�в�����������
		String sql = "insert into message (user_id,content,message_date) values('"
				+ vo.user_id + "','" + vo.content + "','" + vo.message_date + "')";
		// ִ��sql��� ��num���շ���ֵ �������ݵ�����
		int num = conn.executeInsert(sql);
		// ����num�������ݵ�����
		return num;
	}

	/**
	 * ɾ��message��������
	 */
	public int delmessage(String id) {

		// ����sql��� ɾ��Ŀ������
		String sql = "delete from message where id='" + id + "'";

		// ִ��sql��� ��num���շ���ֵ ɾ�����ݵ�����
		int num = conn.executeDelete(sql);
		// ����numɾ�����ݵ�����
		return num;
	}
}
