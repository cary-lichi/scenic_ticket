package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * ScenicVO��
 * ��Scenic�����ֶ�һһ��Ӧ�������
 * */
public class ScenicVO extends VOBase {
	/**
	 * Scenic id
	 */
	public int id;
	/**
	 * ��������
	 */
	public String scenic_name;
	/**
	 * ��������ʱ��
	 */
	public String open_time;
	/**
	 * ����Ʊ�۸�
	 */
	public String price_adults;
	/**
	 * ��ͯƱ�۸�
	 */
	public String price_children;
	/**
	 * ��������
	 */
	public String scenic_describe;
	/**
	 * ��������λ��
	 */
	public String scenic_position;

	public ScenicVO() {
		super();
	}

	@Override
	public void update(ResultSet res) {
		try {
			// ���ݱ����������ζ�ȡ����
			id = res.getInt(1);
			scenic_name = res.getString(2);
			open_time = res.getString(3);
			price_adults = res.getString(4);
			price_children = res.getString(5);
			scenic_describe = res.getString(6);
			scenic_position = res.getString(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
