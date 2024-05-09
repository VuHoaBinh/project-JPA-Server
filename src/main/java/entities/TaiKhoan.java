package entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966096387653616864L;

	@Id
	@OneToOne
	@JoinColumn(name = "InstructorID")
	private NhanVien nhanVien;

	private String tenDangNhap;
	private String matKhau;

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String tenDangNhap) {
		super();
		this.tenDangNhap = tenDangNhap;
	}

	public TaiKhoan(String tenDangNhap, String matKhau, NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoan [nhanVien=" + nhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + "]";
	}

}
