package app;

import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("BanHang_server");
	}
}
