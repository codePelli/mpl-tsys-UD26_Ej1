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
import ejercicios.service.IPiezaServiceImpl;

@RestController
@RequestMapping("/pieza")
public class PiezaController {

	@Autowired
	private IPiezaServiceImpl piezaServ;
	
    @PostMapping("/add")
    public Pieza insertProveedor(@RequestBody Pieza pieza) {
    	
    	return piezaServ.savePieza(pieza);
    }
    
    @GetMapping("/list")
    public List <Pieza> getAllPiezas(){
    	
    	return piezaServ.listPiezas();
    }
    
    @GetMapping("/{codigo}")
    public Pieza piezaPorCod(@PathVariable Long codigo) {
    	
    	return piezaServ.piezaPorCodigo(codigo);
    }
    
    @PutMapping("/{codigo}")
    public Pieza updatePieza(@PathVariable(name = "codigo") Long codigo, @RequestBody Pieza pieza) {
    	
        Pieza piezaSeleccionada = piezaServ.piezaPorCodigo(codigo);

        if (piezaSeleccionada != null) {
        	
            piezaSeleccionada.setNombre(pieza.getNombre());
            Pieza piezaActualizada = piezaServ.updatePieza(piezaSeleccionada);
            
            return piezaActualizada;
            
        } else {
            System.out.println("ERROR updating Pieza");
            return null;
        }
    }
    
    @DeleteMapping("/{codigo}")
    public void deletePieza(@PathVariable(name = "codigo")Long codigo) {
    	
    	piezaServ.deletePieza(codigo);
    }
}
