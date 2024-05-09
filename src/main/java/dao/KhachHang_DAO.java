package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.KhachHang;

public interface KhachHang_DAO extends Remote {
	public KhachHang searchMaKhachHang(String ma) throws RemoteException;

	public KhachHang getKhachVangLai() throws RemoteException;

	public KhachHang getKhachHangBySDT(String soDienThoai) throws RemoteException;

	public ArrayList<KhachHang> getAllKhachHang() throws RemoteException;

	public int themKhachHang(KhachHang kh) throws RemoteException;

	public int suaKhachHang(KhachHang kh) throws RemoteException;
}
