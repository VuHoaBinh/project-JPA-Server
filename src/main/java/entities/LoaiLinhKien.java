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
@Table(name = "loailinhkien")
public class LoaiLinhKien implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5942826205199138379L;

	@Id
	@Column(name = "LoaiLinhKienID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maLoaiLinhKien;
	private String tenLoaiLinhKien;

	@OneToMany(mappedBy = "thuonghieu", fetch = FetchType.LAZY)
	private Set<LinhKien> linkKien;

	public String getMaLoaiLinhKien() {
		return maLoaiLinhKien;
	}

	public void setMaLoaiLinhKien(String maLoaiLinhKien) {
		this.maLoaiLinhKien = maLoaiLinhKien;
	}

	public String getTenLoaiLinhKien() {
		return tenLoaiLinhKien;
	}

	public void setTenLoaiLinhKien(String tenLoaiLinhKien) {
		this.tenLoaiLinhKien = tenLoaiLinhKien;
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

	public LoaiLinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiLinhKien(String maLoaiLinhKien) {
		this.maLoaiLinhKien = maLoaiLinhKien;
	}

	public LoaiLinhKien(String maLoaiLinhKien, String tenLoaiLinhKien) {
		super();
		this.maLoaiLinhKien = maLoaiLinhKien;
		this.tenLoaiLinhKien = tenLoaiLinhKien;
	}

	public LoaiLinhKien(String maLoaiLinhKien, String tenLoaiLinhKien, Set<LinhKien> linkKien) {
		super();
		this.maLoaiLinhKien = maLoaiLinhKien;
		this.tenLoaiLinhKien = tenLoaiLinhKien;
		this.linkKien = linkKien;
	}

	@Override
	public String toString() {
		return "LoaiLinhKien [maLoaiLinhKien=" + maLoaiLinhKien + ", tenLoaiLinhKien=" + tenLoaiLinhKien + ", linkKien="
				+ linkKien + "]";
	}

}
