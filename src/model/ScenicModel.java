package model;

import javabean.db_conn;
import vo.ScenicVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScenicModel extends ModelBase {

	public List<ScenicVO> getAllScenic() {
		String sql = "select * from scenic_order";
		ResultSet res = conn.executeQuery(sql);

		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try {
			while (res.next()) {
				ScenicVO vo = new ScenicVO();

				vo.id = res.getString(1);// id
				vo.scenic_name = res.getString(2);// ��������
				vo.open_time = res.getString(3);// ����ʱ��
				vo.price_adults = res.getString(4);// ����Ʊ�۸�
				vo.price_children = res.getString(5);// ��ͯƱ�۸�
				vo.scenic_describe = res.getString(6);// ����
				vo.scenic_position = res.getString(7);// ����λ��
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ScenicVO getScenic(String user_id) {
		String sql = "select * from scenic_order where user_id='" + user_id + "'";
		ResultSet res = conn.executeQuery(sql);
		try {
			if (res.next()) {
				ScenicVO vo = new ScenicVO();

				vo.id = res.getString(1);// id
				vo.scenic_name = res.getString(2);// ��������
				vo.open_time = res.getString(3);// ����ʱ��
				vo.price_adults = res.getString(4);// ����Ʊ�۸�
				vo.price_children = res.getString(5);// ��ͯƱ�۸�
				vo.scenic_describe = res.getString(6);// ����
				vo.scenic_position = res.getString(7);// ����λ��
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int addScenic(ScenicVO vo) {

		// ����sql��� ִ�в�����������
		String sql = "insert into scenic (scenic_name,open_time,price_adults,price_children,scenic_describe,position) values('"
				+ vo.scenic_name + "','" + vo.open_time + "'," + vo.price_adults + "," + vo.price_children + ",'" + vo.scenic_describe
				+ "','" + vo.scenic_position + "')";
		// ִ��sql���
		return conn.executeInsert(sql);

	}
}
