package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 597323413279932363L;
	
	private int soLuong;
	private double donGia;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CourseID")
	private HoaDon hoaDon;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CourseID")
	private LinhKien linhKien;

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public LinhKien getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}

	public double tinhThanhTien() {
		return (double) soLuong * donGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon hoaDon, LinhKien linhKien, int soLuong, double donGia) {
		super();
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hoaDon = hoaDon;
		this.linhKien = linhKien;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", donGia=" + donGia + ", hoaDon=" + hoaDon + ", linhKien="
				+ linhKien + "]";
	}

}
