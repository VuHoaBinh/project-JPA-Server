package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.ThuongHieu;

public interface ThuongHieu_DAO extends Remote {
	public ArrayList<ThuongHieu> getAllThuongHieu() throws RemoteException;
	
	public String getMaThuongHieuTheoTen(String tenThuongHieu) throws RemoteException;
}
