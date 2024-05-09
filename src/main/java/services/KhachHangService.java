package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import dao.KhachHang_DAO;
import entities.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class KhachHangService extends UnicastRemoteObject implements KhachHang_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public KhachHangService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public KhachHang searchMaKhachHang(String maKhachHang) throws RemoteException {
		TypedQuery<KhachHang> query = entityManager
				.createQuery("SELECT kh FROM KhachHang kh WHERE kh.maKhachHang = :ma", KhachHang.class);
		query.setParameter("ma", maKhachHang);
		return query.getSingleResult();
	}

	@Override
	public KhachHang getKhachVangLai() {
		TypedQuery<KhachHang> query = entityManager
				.createQuery("SELECT kh FROM KhachHang kh WHERE kh.maKhachHang = :ma", KhachHang.class);
		query.setParameter("ma", "KH000001");
		return query.getSingleResult();
	}

	@Override
	public KhachHang getKhachHangBySDT(String sdt) {
		TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh WHERE kh.sdt = :sdt",
				KhachHang.class);
		query.setParameter("sdt", sdt);
		return query.getSingleResult();
	}

	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		TypedQuery<KhachHang> query = entityManager.createQuery("SELECT kh FROM KhachHang kh", KhachHang.class);
		return (ArrayList<KhachHang>) query.getResultList();
	}

	@Override
	public int themKhachHang(KhachHang kh) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(kh);
			trans.commit();
			return 1;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public int suaKhachHang(KhachHang kh) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(kh);
			trans.commit();
			return 1;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}

}
