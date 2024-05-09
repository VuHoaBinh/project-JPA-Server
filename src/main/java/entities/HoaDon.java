package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1299267359876653671L;

	@Id
	@Column(name = "HoaDonID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maHoaDon;
	private Date ngayLap;
	private float thue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KhachHangID")
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID")
	private NhanVien nhanVien;

	@OneToMany(mappedBy = "student")
	private ArrayList<ChiTietHoaDon> listChiTietHoaDon;

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
		return listChiTietHoaDon;
	}

	public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double tinhTongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon ct : this.listChiTietHoaDon) {
			tongTien += ct.getSoLuong() * ct.getDonGia();
		}
		return tongTien;
	}

	public double tinhThue() {
		return 0.1 * this.tinhTongTien();
	}

	public void addItem(ChiTietHoaDon ct) {
		this.listChiTietHoaDon.add(ct);
	}

	public HoaDon() {
		super();
		this.listChiTietHoaDon = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public HoaDon(String maHoaDon, KhachHang maKhachHang, NhanVien maNhanVien, Date ngayLap, float thue) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = maKhachHang;
		this.nhanVien = maNhanVien;
		this.ngayLap = ngayLap;
		this.thue = thue;
	}

	public HoaDon(String maHoaDon, Date ngayLap, float thue, KhachHang khachHang, NhanVien nhanVien,
			ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.thue = thue;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.listChiTietHoaDon = listChiTietHoaDon;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", thue=" + thue + ", khachHang=" + khachHang
				+ ", nhanVien=" + nhanVien + ", listChiTietHoaDon=" + listChiTietHoaDon + "]";
	}

}
