package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.ChiTietHoaDon;

public interface ChiTietHoaDon_DAO extends Remote {

	public ArrayList<ChiTietHoaDon> timTheoMaCTHD(String maCT) throws SQLException;
	public ChiTietHoaDon findMaCTHD(String title) throws RemoteException;
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException;

	public boolean updateSoLuongTon(ChiTietHoaDon ct) throws SQLException;

}
