package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import entities.LinhKien;

public interface LinhKien_DAO extends Remote {
	public ArrayList<LinhKien> getAllLinhKien() throws RemoteException;

	public int themLinhKien(LinhKien linhKien) throws RemoteException;

	public int xoaLinhKienTheoMa(String maLinhKien) throws RemoteException;

	public int suaLinhKien(LinhKien linhKien) throws RemoteException;

	public LinhKien timLinhKienTheoMa(String maLinhKien) throws RemoteException;
}
