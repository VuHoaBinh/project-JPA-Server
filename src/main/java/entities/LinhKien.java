package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

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
@Table(name = "linhkien")
public class LinhKien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8780113468596521941L;

	@Id
	@Column(name = "LinhKienID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maLinhKien;

	private String tenLinhKien;
	private int soLuong;
	private double giaNhap;
	private double giaBan;
	private int baoHanh;
	private String moTa;
	private Date ngayNhap;

	@OneToMany(mappedBy = "linhkien", fetch = FetchType.LAZY)
	private Set<ChiTietHoaDon> chiTietHoaDon;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LoaiLinhKienID")
	private LoaiLinhKien loaiLinhKien;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ThuongHieuID")
	private ThuongHieu thuongHieu;

	public String getMaLinhKien() {
		return maLinhKien;
	}

	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}

	public String getTenLinhKien() {
		return tenLinhKien;
	}

	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(Set<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public LoaiLinhKien getLoaiLinhKien() {
		return loaiLinhKien;
	}

	public void setLoaiLinhKien(LoaiLinhKien loaiLinhKien) {
		this.loaiLinhKien = loaiLinhKien;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinhKien(String maLinhKien) {
		super();
		this.maLinhKien = maLinhKien;
	}

	public LinhKien(String tenLinhKien, int soLuong, double giaNhap, double giaBan, int baoHanh, String moTa,
			LoaiLinhKien loaiLinhKien, ThuongHieu thuongHieu, Date ngayNhap) {
		super();
		this.tenLinhKien = tenLinhKien;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.baoHanh = baoHanh;
		this.moTa = moTa;
		this.loaiLinhKien = loaiLinhKien;
		this.thuongHieu = thuongHieu;
		this.ngayNhap = ngayNhap;
	}

	public LinhKien(String maLinhKien, String tenLinhKien, int soLuong, double giaNhap, double giaBan, int baoHanh,
			String moTa, LoaiLinhKien loaiLinhKien, ThuongHieu thuongHieu, Date ngayNhap) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.baoHanh = baoHanh;
		this.moTa = moTa;
		this.loaiLinhKien = loaiLinhKien;
		this.thuongHieu = thuongHieu;
		this.ngayNhap = ngayNhap;
	}

	public LinhKien(String maLinhKien, String tenLinhKien, int soLuong, double giaNhap, double giaBan, int baoHanh,
			String moTa, Date ngayNhap, LoaiLinhKien loaiLinhKien, ThuongHieu thuongHieu) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.baoHanh = baoHanh;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
		this.loaiLinhKien = loaiLinhKien;
		this.thuongHieu = thuongHieu;
	}

	public LinhKien(String maLinhKien, String tenLinhKien, int soLuong, double giaNhap, double giaBan, int baoHanh,
			String moTa, Date ngayNhap, Set<ChiTietHoaDon> chiTietHoaDon, LoaiLinhKien loaiLinhKien,
			ThuongHieu thuongHieu) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.baoHanh = baoHanh;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
		this.chiTietHoaDon = chiTietHoaDon;
		this.loaiLinhKien = loaiLinhKien;
		this.thuongHieu = thuongHieu;
	}

	@Override
	public String toString() {
		return "LinhKien [maLinhKien=" + maLinhKien + ", tenLinhKien=" + tenLinhKien + ", soLuong=" + soLuong
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", baoHanh=" + baoHanh + ", moTa=" + moTa
				+ ", ngayNhap=" + ngayNhap + ", chiTietHoaDon=" + chiTietHoaDon + ", loaiLinhKien=" + loaiLinhKien
				+ ", thuongHieu=" + thuongHieu + "]";
	}

}
