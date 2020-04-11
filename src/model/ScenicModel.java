package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ScenicVO;

/*
 * ScenicModel��
 * ��Scenic������ķ�װ
 * */
public class ScenicModel extends ModelBase {

	/**
	 * ��þ�����������
	 */
	public List<ScenicVO> getAllScenic() {
		// ��֯sql��� ��ѯscenic������
		String sql = "select * from scenic";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);

		// ʵ����list�����б� ���洢ScenicVO�������ݰ�
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try {
			// ��ȡ��һ������ ֱ����ȡ�����һ��
			while (res.next()) {
				// ����ScenicVO�������ݰ�
				ScenicVO vo = new ScenicVO();
				// ��res������ӵ�ScenicVO�������ݰ���
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
	 * ���ݾ���id��þ�������
	 */
	public ScenicVO getScenic(String id) {
		// ��֯sql��� ��ѯscenic�������� idΪָ��id��һ������
		String sql = "select * from scenic where id='" + id + "'";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);
		try {
			if (res.next()) {
				// ����ScenicVO�������ݰ�
				ScenicVO vo = new ScenicVO();
				// ��res������ӵ�ScenicVO�������ݰ���
				vo.update(res);
				// ����ScenicVO�������ݰ�
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
	 * ���ݾ�������ģ�����Ҿ�������
	 */
	public List<ScenicVO> getScenicByName(String name) {
		// ��֯sql��� ��ѯscenic�������� ���ݾ�������ģ�����Ҿ�������
		String sql = "select * from scenic where scenic_name like '%" + name + "%'";
		// ִ��sql���
		ResultSet res = conn.executeQuery(sql);
		// ʵ����list�����б� ���洢ScenicVO�������ݰ�
		List<ScenicVO> list = new ArrayList<ScenicVO>();
		try {
			while (res.next()) {
				// ����ScenicVO�������ݰ�
				ScenicVO vo = new ScenicVO();
				// ��res������ӵ�ScenicVO�������ݰ���
				vo.update(res);
				// �����ݰ���ӵ�list�����б���
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ʧ��ʱ����null������
		return list;
	}

	/**
	 * ��scenic������Ӿ���
	 */
	public int addScenic(ScenicVO vo) {

		// ����sql��� ִ�в�����������
		String sql = "insert into scenic (scenic_name,open_time,price_adults,price_children,scenic_describe,scenic_position) values('"
				+ vo.scenic_name + "','" + vo.open_time + "'," + vo.price_adults + "," + vo.price_children + ",'" + vo.scenic_describe
				+ "','" + vo.scenic_position + "')";
		// ִ��sql��� ��num���շ���ֵ �������ݵ�����
		int num = conn.executeInsert(sql);
		// ����num�������ݵ�����
		return num;
	}

	/**
	 * ɾ��scenic���о���
	 */
	public int delScenic(String id) {

		// ����sql��� ɾ��Ŀ������
		String sql = "delete from scenic where id='" + id + "'";

		// ִ��sql��� ��num���շ���ֵ ɾ�����ݵ�����
		int num = conn.executeDelete(sql);
		// ����numɾ�����ݵ�����
		return num;
	}
}
