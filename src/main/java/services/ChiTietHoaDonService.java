package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ChiTietHoaDon_DAO;
import entities.ChiTietHoaDon;
import entities.LinhKien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

public class ChiTietHoaDonService extends UnicastRemoteObject implements ChiTietHoaDon_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public ChiTietHoaDonService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ChiTietHoaDon findMaCTHD(String title) throws RemoteException {
	    try {
	        return entityManager.createQuery("SELECT c FROM ChiTietHoaDon c WHERE c.title = :title", ChiTietHoaDon.class)
	                .setParameter("title", title)
	                .getSingleResult();
	    } catch (NoResultException e) {
	        return null; 
	    } catch (NonUniqueResultException e) {
	        e.printStackTrace(); 
	        return null;
	    }
	}

	@Override
	public ArrayList<ChiTietHoaDon> timTheoMaCTHD(String maCT) throws SQLException {
	    try {
	        return new ArrayList<>(entityManager.createNamedQuery("ChiTietHoaDon.findMaCTHD", ChiTietHoaDon.class)
	                .setParameter("maCT", "%" + maCT + "%")
	                .getResultList());
	    } catch (NoResultException e) {
	        return new ArrayList<>();
	    }
	}

	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(cthd);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean updateSoLuongTon(ChiTietHoaDon ct) throws SQLException {
	    EntityTransaction trans = entityManager.getTransaction();
	    try {
	        trans.begin();
	        LinhKien linhKien = ct.getLinhKien(); 
	        int newSoLuong = linhKien.getSoLuong() - ct.getSoLuong(); 
	        linhKien.setSoLuong(newSoLuong); 
	        entityManager.merge(linhKien); 
	        trans.commit();
	        return true;
	    } catch (Exception e) {
	        if (trans.isActive()) {
	            trans.rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}

}
