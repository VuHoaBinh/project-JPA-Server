package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ThongKe_DAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.LinhKien;
import entities.NhanVien;
import jakarta.persistence.EntityManager;

public class ThongKeService extends UnicastRemoteObject implements ThongKe_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public ThongKeService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<ChiTietHoaDon> layDsChiTietHoaDon() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietHoaDon> layDsChiTietHoaDonTheoMaHoaDon(String maHoaDon) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinhKien timLinhKienTheoMa(String maLinhKien) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HoaDon> layDsHoaDon() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietHoaDon timTheoMaHoaDon(String maHoaDon) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang timKiemTheoMaKhachHang(KhachHang ma) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVien searchMaNhanVien(NhanVien ma) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
