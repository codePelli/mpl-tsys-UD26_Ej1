package ejercicios.service;

import java.util.List;

import ejercicios.dto.Proveedor;

public interface IProveedorService {

	List<Proveedor> listProv();
	
	Proveedor proveedorPorCod(String id);
	
	Proveedor saveProveedor(Proveedor prov);
	
	Proveedor updateProveedor(Proveedor prov);
	
	void deleteProveedor(String id);
}
