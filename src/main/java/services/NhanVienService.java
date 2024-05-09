package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import dao.NhanVien_DAO;
import entities.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class NhanVienService extends UnicastRemoteObject implements NhanVien_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public NhanVienService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<NhanVien> getAllTableNhanVien() throws RemoteException {
		TypedQuery<NhanVien> query = entityManager.createQuery("SELECT nv FROM NhanVien nv JOIN FETCH nv.chucVu",
				NhanVien.class);
		return (ArrayList<NhanVien>) query.getResultList();
	}

	@Override
	public int themNhanVien(NhanVien nv) throws RemoteException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(nv);
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
	public int xoaNhanVienTheoMa(String maNV) throws RemoteException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			NhanVien course = entityManager.find(NhanVien.class, maNV);
			entityManager.remove(course);
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
	public int suaNhanVien(NhanVien nv) throws RemoteException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(nv);
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
	public NhanVien searchMaNhanVien(String ma) throws RemoteException {
		return entityManager.find(NhanVien.class, ma);
	}

}
