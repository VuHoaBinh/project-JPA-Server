package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.HoaDon_DAO;
import entities.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class HoaDonService extends UnicastRemoteObject implements HoaDon_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public HoaDonService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public ArrayList<HoaDon> layDsHoaDon() throws RemoteException {
		ArrayList<HoaDon> dshd = new ArrayList<>();
		try {
			TypedQuery<HoaDon> query = entityManager.createQuery(
					"SELECT hd FROM HoaDon hd JOIN FETCH hd.khachHang JOIN FETCH hd.nhanVien", HoaDon.class);
			List<HoaDon> resultList = query.getResultList();
			dshd.addAll(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException("Error retrieving list of HoaDon", e);
		}
		return dshd;
	}

	@Override
	public ArrayList<HoaDon> getHoaDonTheoMa(String id) throws RemoteException {
		ArrayList<HoaDon> dshd = new ArrayList<>();
		try {
			TypedQuery<HoaDon> query = entityManager.createQuery(
					"SELECT hd FROM HoaDon hd JOIN FETCH hd.khachHang JOIN FETCH hd.nhanVien WHERE hd.maHoaDon = :maHoaDon",
					HoaDon.class);
			query.setParameter("maHoaDon", id);
			List<HoaDon> resultList = query.getResultList();
			dshd.addAll(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException("Error retrieving HoaDon with id: " + id, e);
		}
		return dshd;
	}

	@Override
	public int laySoHoaDon() throws RemoteException {
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(hd.maHoaDon) FROM HoaDon hd", Long.class);
        return query.getSingleResult().intValue();
	}

	@Override
	public boolean themHoaDon(HoaDon p) throws SQLException {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(p);
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
	public boolean xoaPhieuDatHang(String p) throws RemoteException {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int n = entityManager.createQuery("DELETE FROM HoaDon hd WHERE hd.maHoaDon = :maHoaDon")
                            .setParameter("maHoaDon", p)
                            .executeUpdate();
        transaction.commit();
        return n > 0;
	}

}
