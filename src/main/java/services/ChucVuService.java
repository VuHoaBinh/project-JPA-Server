package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ChucVu_DAO;
import entities.ChucVu;
import jakarta.persistence.EntityManager;

public class ChucVuService extends UnicastRemoteObject implements ChucVu_DAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public ChucVuService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}
	@Override
	public ArrayList<ChucVu> getAllChucVu() throws RemoteException {
		return new ArrayList<>(entityManager.createQuery("SELECT c FROM ChucVu c", ChucVu.class).getResultList());
	}

	@Override
	public String getMaChucVuTheoTen(String tenChucVu) throws RemoteException {
		List<String> results = entityManager
				.createQuery("SELECT c FROM ChucVu c WHERE c.tenChucVu = :tenChucVu",
						String.class)
				.setParameter("tenChucVu", tenChucVu).getResultList();

		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return null;
		}
	}

}
