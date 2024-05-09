package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.LoaiLinhKien;

public interface LoaiLinhKien_DAO extends Remote {
	public ArrayList<LoaiLinhKien> getAllLoaiLinhKien()throws RemoteException;

	public String getMaLoaiLinhKienTheoTen(String tenLoaiLinhKien)throws RemoteException;

}
