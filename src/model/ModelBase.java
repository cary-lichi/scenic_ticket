package model;

import javabean.db_conn;

/*
 * ModelBase��
 * Model�Ļ��࣬����Modelģ�鹲ͬ�Ĳ�����������
 * �����������ݿ�
 * */
public abstract class ModelBase {

	// db_conn���ݿ������
	protected db_conn conn;
	
	// ���캯��
	public ModelBase() {
		// ʵ���� db_conn���ݿ������
		conn = new db_conn();
	}

	public void destroy() {
		// �ر����ݿ�����
		conn.closeDB();
		// ��connֵΪnull��
		conn = null;
	}
}
