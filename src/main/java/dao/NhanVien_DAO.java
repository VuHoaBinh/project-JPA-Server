package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.NhanVien;

public interface NhanVien_DAO extends Remote {
	public ArrayList<NhanVien> getAllTableNhanVien() throws RemoteException;

	public int themNhanVien(NhanVien nv) throws RemoteException;

	public int xoaNhanVienTheoMa(String maNV) throws RemoteException;

	public int suaNhanVien(NhanVien nv) throws RemoteException;

	public NhanVien searchMaNhanVien(String ma) throws RemoteException;

	
}
