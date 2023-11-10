package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicios.dto.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, String>{
	
}
