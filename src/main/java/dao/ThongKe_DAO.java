package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.LinhKien;
import entities.NhanVien;

public interface ThongKe_DAO extends Remote {
	public ArrayList<ChiTietHoaDon> layDsChiTietHoaDon() throws RemoteException;

	public List<ChiTietHoaDon> layDsChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException;

	public LinhKien timLinhKienTheoMa(String maLinhKien) throws RemoteException;

	public ArrayList<HoaDon> layDsHoaDon() throws RemoteException;

	public ChiTietHoaDon timTheoMaHoaDon(String maHoaDon) throws RemoteException;

	public KhachHang timKiemTheoMaKhachHang(KhachHang ma) throws RemoteException;

	public NhanVien searchMaNhanVien(NhanVien ma) throws RemoteException;
}
