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
@Table(name = "chucvu")
public class ChucVu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1796478843460897906L;

	@Id
	@Column(name = "ChucVuID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maChucVu;

	private String tenChucVu;

	@OneToMany(mappedBy = "chucvu")
	private Set<NhanVien> nhanVien;

	public String getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public Set<NhanVien> getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(Set<NhanVien> nhanVien) {
		this.nhanVien = nhanVien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChucVu(String maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}

	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}

	public ChucVu(String maChucVu, String tenChucVu, Set<NhanVien> nhanVien) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + ", nhanVien=" + nhanVien + "]";
	}

}
