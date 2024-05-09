package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.HoaDon;

public interface HoaDon_DAO extends Remote {
	public ArrayList<HoaDon> layDsHoaDon() throws RemoteException;

	public ArrayList<HoaDon> getHoaDonTheoMa(String id) throws RemoteException;

	public int laySoHoaDon() throws RemoteException;

	public boolean themHoaDon(HoaDon p) throws SQLException;

	public boolean xoaPhieuDatHang(String p) throws RemoteException;
}
