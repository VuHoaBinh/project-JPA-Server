package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.ThuongHieu_DAO;
import entities.ThuongHieu;
import jakarta.persistence.EntityManager;

public class ThuongHieuService extends UnicastRemoteObject implements ThuongHieu_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public ThuongHieuService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<ThuongHieu> getAllThuongHieu() throws RemoteException {
		return new ArrayList<>(
				entityManager.createQuery("SELECT c FROM ThuongHieu c", ThuongHieu.class).getResultList());
	}

	@Override
	public String getMaThuongHieuTheoTen(String tenThuongHieu) throws RemoteException {
		List<String> results = entityManager
				.createQuery("SELECT c FROM ThuongHieu c WHERE c.tenThuongHieu = :tenThuongHieu", String.class)
				.setParameter("tenThuongHieu", tenThuongHieu).getResultList();

		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return null;
		}
	}

}
