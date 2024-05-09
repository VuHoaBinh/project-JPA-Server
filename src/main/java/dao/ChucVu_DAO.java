package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entities.ChucVu;

public interface ChucVu_DAO extends Remote{
	public ArrayList<ChucVu> getAllChucVu()throws RemoteException;
	public String getMaChucVuTheoTen(String tenChucVu)throws RemoteException;
}
