package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entities.TaiKhoan;

public interface TaiKhoan_DAO extends Remote {
	public TaiKhoan getTaiKhoanTuTenDangNhap(String tenDangNhap, String matKhau) throws RemoteException;
}
