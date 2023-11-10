package ejercicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import ejercicios.dao.ProveedorDAO;
import ejercicios.dto.Proveedor;

@Service
public class IProveedorServiceImpl implements IProveedorService{

	@Autowired
	@Lazy
	ProveedorDAO iProvServ;
	@Override
	public List<Proveedor> listProv() {
		// TODO Auto-generated method stub
		return iProvServ.findAll();
	}

	@Override
	public Proveedor proveedorPorCod(String id) {
		// TODO Auto-generated method stub
		return iProvServ.findById(id).get();
	}

	@Override
	public Proveedor saveProveedor(Proveedor prov) {
		// TODO Auto-generated method stub
		return iProvServ.save(prov);
	}

	@Override
	public Proveedor updateProveedor(Proveedor prov) {
		// TODO Auto-generated method stub
		return iProvServ.save(prov);
	}

	@Override
	public void deleteProveedor(String id) {
		// TODO Auto-generated method stub
		iProvServ.deleteById(id);
	}

	
}
