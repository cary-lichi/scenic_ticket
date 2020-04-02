package javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//���ݿ������
public class db_conn {
	// ���ݿ�����
	public Connection conn = null;
	// ִ��sql���󷵻صĽ��
	public ResultSet res = null;
	// Statement �������� SQL ��䷢�͵����ݿ�
	public Statement st = null;
	
	//���ݿ��ʼ������
	public  db_conn() {
		// �������ݿ��ַ
		String URL = "jdbc:mysql://localhost:3306/ticket?serverTimezone=UTC";
		// ���ݿ��û���
		String USER = "root";
		// ���ݿ�����
		String PWD = "root";
		
		try{
			// ����com.mysql.jdbc.Driver����
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}try{
			// �������ݿ�
			conn = DriverManager.getConnection(URL,USER,PWD);
			// ����һ�� Statement �������� SQL ��䷢�͵����ݿ�
			st=conn.createStatement();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	//�����ݿ����������
	public int executeInsert(String sql){
		int num=0;
		try{
			// �� SQL ��䷢�͵����ݿ�
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("������ݳ�����Ϣ:"+e.getMessage());
		}
		return num;
	}
	
	//�����ݿ��в�ѯ����
	public ResultSet executeQuery(String sql){
		res=null;
		try{
			// �� SQL ��䷢�͵����ݿ�
			res=st.executeQuery(sql);
		}
		catch(SQLException e){
			System.out.print("��ѯ������Ϣ:"+e.getMessage());
		}
		return res;
	}
	
	//��������
	public int Update(String sql){
		int num=0;
		try{
			// �� SQL ��䷢�͵����ݿ�
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			System.out.print("ִ���޸��д���"+ex.getMessage());
		}
		return num;
	}
	
	//ɾ������
	public int executeDelete(String sql){
		int num=0;
		try{
			// �� SQL ��䷢�͵����ݿ�
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.print("ִ��ɾ���д���:"+e.getMessage());
		}
		return num;
	}
	
	//�ر����ݿ�����
	public void closeDB(){
		try{
			// �ر�Statement
			st.close();
			// �ر����ݿ�����
			conn.close();
		}
		catch(Exception e){
			System.out.print("ִ�йر�Connection�����д���:"+e.getMessage());
		}
	}
}
