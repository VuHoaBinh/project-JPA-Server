package utils;

import java.rmi.Naming;

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

public class ClientDAO {
	private static final String URL = "rmi://192.168.43.152:2004/";

	public static TaiKhoan_DAO getTaiKhoanDAO() {
		try {
			return (TaiKhoan_DAO) Naming.lookup(URL + "TaiKhoan_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the CourseDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static KhachHang_DAO getKhachHangDAO() {
		try {
			return (KhachHang_DAO) Naming.lookup(URL + "KhachHang_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static ChucVu_DAO getChucVu_DAO() {
		try {
			return (ChucVu_DAO) Naming.lookup(URL + "ChucVu_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static ChiTietHoaDon_DAO getChiTietHoaDon_DAO() {
		try {
			return (ChiTietHoaDon_DAO) Naming.lookup(URL + "ChiTietHoaDon_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static HoaDon_DAO getHoaDon_DAO() {
		try {
			return (HoaDon_DAO) Naming.lookup(URL + "HoaDon_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static LinhKien_DAO getLinhKien_DAO() {
		try {
			return (LinhKien_DAO) Naming.lookup(URL + "LinhKien_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static LoaiLinhKien_DAO getLoaiLinhKien_DAO() {
		try {
			return (LoaiLinhKien_DAO) Naming.lookup(URL + "LoaiLinhKien_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static NhanVien_DAO getNhanVien_DAO() {
		try {
			return (NhanVien_DAO) Naming.lookup(URL + "NhanVien_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static ThongKe_DAO getThongKe_DAO() {
		try {
			return (ThongKe_DAO) Naming.lookup(URL + "ThongKe_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}

	public static ThuongHieu_DAO getThuongHieu_DAO() {
		try {
			return (ThuongHieu_DAO) Naming.lookup(URL + "ThuongHieu_DAO");
		} catch (Exception e) {
			System.out.println("An error occurred while accessing the StudentDAO.");
			e.printStackTrace();
		}
		return null;
	}
}