package entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3034469154760609150L;
	@Id
	@Column(name = "NhanVienID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maNhanVien;

	private String tenNhanVien;
	private String diaChi;
	private String sdt;
	private String email;
	private Date ngaySinh;
	private boolean gioiTinh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ChucVuID")
	private ChucVu chucVu;

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String diaChi, String soDienThoai, String email,
			ChucVu chucVu, Date ngaySinh, boolean gioiTinh) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.sdt = soDienThoai;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", diaChi=" + diaChi + ", sdt="
				+ sdt + ", email=" + email + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", chucVu=" + chucVu
				+ "]";
	}

}
