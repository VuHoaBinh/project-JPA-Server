package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2521082880762617270L;

	@Id
	@Column(name = "KhachHangID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maKhachHang;

	private String tenKhachHang;
	private String sdt;
	private String diaChi;
	private String email;

	@OneToMany(mappedBy = "khachhang")
	private Set<HoaDon> hoaDon;

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<HoaDon> getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(Set<HoaDon> hoaDon) {
		this.hoaDon = hoaDon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public KhachHang(String maKhachHang, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String sdt, String diaChi, String email) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String sdt, String diaChi, String email,
			Set<HoaDon> hoaDon) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.email = email;
		this.hoaDon = hoaDon;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", sdt=" + sdt + ", diaChi="
				+ diaChi + ", email=" + email + ", hoaDon=" + hoaDon + "]";
	}

}
