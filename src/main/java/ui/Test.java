package ui;

import java.rmi.RemoteException;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;
import utils.ClientDAO;

public class Test {
	public static void main(String[] args) throws RemoteException {
		TaiKhoan_DAO taiKhoan_DAO = ClientDAO.getTaiKhoanDAO();
		taiKhoan_DAO.getTaiKhoanTuTenDangNhap("user1", "123456").toString();
	}
}
