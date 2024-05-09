package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.LoaiLinhKien_DAO;
import entities.LoaiLinhKien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LoaiLinhKienService extends UnicastRemoteObject implements LoaiLinhKien_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public LoaiLinhKienService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<LoaiLinhKien> getAllLoaiLinhKien() throws RemoteException {
		TypedQuery<LoaiLinhKien> query = entityManager.createQuery("SELECT llk FROM LoaiLinhKien llk",
				LoaiLinhKien.class);
		return (ArrayList<LoaiLinhKien>) query.getResultList();
	}

	@Override
	public String getMaLoaiLinhKienTheoTen(String tenLoaiLinhKien) throws RemoteException {
		TypedQuery<String> query = entityManager.createQuery(
				"SELECT llk.maLoaiLinhKien FROM LoaiLinhKien llk WHERE llk.tenLoaiLinhKien = :tenLoaiLinhKien",
				String.class);
		query.setParameter("tenLoaiLinhKien", tenLoaiLinhKien);
		List<String> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}

}
