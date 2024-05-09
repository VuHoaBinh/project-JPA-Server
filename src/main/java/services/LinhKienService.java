package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.LinhKien_DAO;
import entities.LinhKien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class LinhKienService extends UnicastRemoteObject implements LinhKien_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public LinhKienService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<LinhKien> getAllLinhKien() throws RemoteException {
		TypedQuery<LinhKien> query = entityManager.createQuery(
				"SELECT lk FROM LinhKien lk JOIN lk.loaiLinhKien llk JOIN lk.thuongHieu th", LinhKien.class);
		return (ArrayList<LinhKien>) query.getResultList();
	}

	@Override
	public int themLinhKien(LinhKien linhKien) throws RemoteException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(linhKien);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int xoaLinhKienTheoMa(String maLinhKien) throws RemoteException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LinhKien linhKien = entityManager.find(LinhKien.class, maLinhKien);
			if (linhKien != null) {
				entityManager.remove(linhKien);
				transaction.commit();
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int suaLinhKien(LinhKien linhKien) throws RemoteException {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(linhKien);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public LinhKien timLinhKienTheoMa(String maLinhKien) throws RemoteException {
		TypedQuery<LinhKien> query = entityManager
				.createQuery("SELECT lk FROM LinhKien lk WHERE lk.maLinhKien = :maLinhKien", LinhKien.class);
		query.setParameter("maLinhKien", maLinhKien);
		return query.getSingleResult();
	}

}
