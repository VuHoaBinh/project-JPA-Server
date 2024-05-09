package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "thuonghieu")
public class ThuongHieu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8254875325628345399L;

	@Id
	@Column(name = "ThuongHieuID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maThuongHieu;

	private String tenThuongHieu;

	@OneToMany(mappedBy = "thuonghieu", fetch = FetchType.LAZY)
	private Set<LinhKien> linkKien;

	public String getMaThuongHieu() {
		return maThuongHieu;
	}

	public void setMaThuongHieu(String maThuongHieu) {
		this.maThuongHieu = maThuongHieu;
	}

	public String getTenThuongHieu() {
		return tenThuongHieu;
	}

	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}

	public Set<LinhKien> getLinkKien() {
		return linkKien;
	}

	public void setLinkKien(Set<LinhKien> linkKien) {
		this.linkKien = linkKien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ThuongHieu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThuongHieu(String maThuongHieu) {
		super();
		this.maThuongHieu = maThuongHieu;
	}

	public ThuongHieu(String maThuongHieu, String tenThuongHieu) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
	}

	public ThuongHieu(String maThuongHieu, String tenThuongHieu, Set<LinhKien> linkKien) {
		super();
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.linkKien = linkKien;
	}

	@Override
	public String toString() {
		return "ThuongHieu [maThuongHieu=" + maThuongHieu + ", tenThuongHieu=" + tenThuongHieu + ", linkKien="
				+ linkKien + "]";
	}

}
