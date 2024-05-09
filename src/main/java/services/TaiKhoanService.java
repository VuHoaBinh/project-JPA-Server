package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TaiKhoanService extends UnicastRemoteObject implements TaiKhoan_DAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public TaiKhoanService(EntityManager entityManager) throws RemoteException {
		this.entityManager = entityManager;
	}

	@Override
	public TaiKhoan getTaiKhoanTuTenDangNhap(String tenDangNhap, String matKhau) throws RemoteException {
		TypedQuery<TaiKhoan> query = entityManager
				.createQuery("SELECT tk FROM TaiKhoan tk JOIN tk.nhanVien nv JOIN nv.chucVu cv "
						+ "WHERE tk.tenDangNhap = :tenDangNhap AND tk.matKhau = :matKhau", TaiKhoan.class);
		query.setParameter("tenDangNhap", tenDangNhap);
		query.setParameter("matKhau", matKhau);
		return query.getSingleResult();
	}

}
