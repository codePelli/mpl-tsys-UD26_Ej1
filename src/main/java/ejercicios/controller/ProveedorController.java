package ejercicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ejercicios.dto.Pieza;
import ejercicios.dto.Proveedor;
import ejercicios.service.IProveedorServiceImpl;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorServiceImpl IProveedorServiceImpl;
	
    @PostMapping("/add")
    public Proveedor insertProveedor(@RequestBody Proveedor proveedor) {
    	
    	return IProveedorServiceImpl.saveProveedor(proveedor);
    }
    
    @GetMapping("/list")
    public List <Proveedor> listPiezas() {
    	
    	return IProveedorServiceImpl.listProv();
    }
    
    @GetMapping("/{id}")
    public Proveedor proveedorPorId(@PathVariable(name = "id") String id) {
    	
    	Proveedor provPorId = IProveedorServiceImpl.proveedorPorCod(id);
    	System.out.println("Proveedor por ID" + provPorId);
    	
    	return provPorId;
    }
    
    @PutMapping("{id}")
	public Proveedor updateProveedor(@PathVariable(name = "id") String id, @RequestBody Proveedor proveedor) {
    	
    	Proveedor provSeleccionado = IProveedorServiceImpl.proveedorPorCod(id);
    	
    	if(provSeleccionado != null) {
    		
    		provSeleccionado.setNombre(proveedor.getNombre());
    		Proveedor provUpd = IProveedorServiceImpl.updateProveedor(provSeleccionado);
    		
    		return provUpd;
    		
    	} else {
    		
    		System.out.println("ERROR updating Proveedor");

    		return null;
    	}
    }
    
    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable(name = "id")String id) {
    	
    	IProveedorServiceImpl.deleteProveedor(id);
    }
}
