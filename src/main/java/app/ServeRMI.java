package app;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import dao.ChiTietHoaDon_DAO;
import dao.ChucVu_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LinhKien_DAO;
import dao.LoaiLinhKien_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import dao.ThongKe_DAO;
import dao.ThuongHieu_DAO;
import jakarta.persistence.EntityManager;
import services.ChiTietHoaDonService;
import services.ChucVuService;
import services.EntityManagerFactoryUtil;
import services.HoaDonService;
import services.KhachHangService;
import services.LinhKienService;
import services.LoaiLinhKienService;
import services.NhanVienService;
import services.TaiKhoanService;
import services.ThongKeService;
import services.ThuongHieuService;

public class ServeRMI {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

		// Create a registry
		Registry registry = LocateRegistry.createRegistry(2003);

		EntityManagerFactoryUtil entityManagerFactory = new EntityManagerFactoryUtil();
		EntityManager entityManager = entityManagerFactory.getEnManager();
		
		
		ChiTietHoaDon_DAO ChiTietHoaDon_DAO = new ChiTietHoaDonService(entityManager);
		ChucVu_DAO ChucVu_DAO = new ChucVuService(entityManager);
		HoaDon_DAO HoaDon_DAO = new HoaDonService(entityManager);
		KhachHang_DAO KhachHang_DAO = new KhachHangService(entityManager);
		LinhKien_DAO LinhKien_DAO = new LinhKienService(entityManager);
		LoaiLinhKien_DAO LoaiLinhKien_DAO = new LoaiLinhKienService(entityManager);
		NhanVien_DAO NhanVien_DAO = new NhanVienService(entityManager);
		TaiKhoan_DAO TaiKhoan_DAO = new TaiKhoanService(entityManager);
		ThongKe_DAO ThongKe_DAO = new ThongKeService(entityManager);
		ThuongHieu_DAO ThuongHieu_DAO = new ThuongHieuService(entityManager);
		
		
		registry.bind("ChiTietHoaDon_DAO", ChiTietHoaDon_DAO);
		registry.bind("ChucVu_DAO", ChucVu_DAO);
		registry.bind("HoaDon_DAO", HoaDon_DAO);
		registry.bind("KhachHang_DAO", KhachHang_DAO);
		registry.bind("LinhKien_DAO", LinhKien_DAO);
		registry.bind("LoaiLinhKien_DAO", LoaiLinhKien_DAO);
		registry.bind("NhanVien_DAO", NhanVien_DAO);
		registry.bind("TaiKhoan_DAO", TaiKhoan_DAO);
		registry.bind("ThongKe_DAO", ThongKe_DAO);
		registry.bind("ThuongHieu_DAO", ThuongHieu_DAO);

		System.out.println("RMI Server ready");
	}
}
