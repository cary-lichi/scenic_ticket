package vo;

import java.sql.ResultSet;

public abstract class VOBase {
	public VOBase() {

	}

	/**
	 * ��ResultSet������ӵ�VO���ݰ���
	 */
	public abstract void update(ResultSet res);
}
