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

import ejercicios.dto.Suministra;
import ejercicios.service.ISuministraService;
import ejercicios.service.ISuministraServiceImpl;

@RestController
@RequestMapping("/suministra")
public class SuminsitraController {

	@Autowired
	private ISuministraService iServ;
	
	@GetMapping("/list")
	public List<Suministra> allSuministra(){
		
		return iServ.listSuministra();
	}
	
	@GetMapping("/{id}")
	public Suministra sumPorId(@PathVariable int id) {
		
		return iServ.sumPorId(id);
	}
	
	@PostMapping("/add")
	public Suministra saveSum(@RequestBody Suministra suministra) {
		
		return iServ.saveSuministra(suministra);
	}
	
	@PutMapping("/{id}")
	public Suministra updateSum(@PathVariable int id, @RequestBody Suministra suministra) {
		
		return iServ.updateSuministra(suministra);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSum(@PathVariable int id) {
		
		iServ.deleteSuministra(id);
	}
}
