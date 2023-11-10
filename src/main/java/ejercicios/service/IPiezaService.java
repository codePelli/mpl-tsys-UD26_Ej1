package ejercicios.service;

import java.util.List;

import ejercicios.dto.Pieza;

public interface IPiezaService {
	
	
	List<Pieza> listPiezas();
	
	Pieza savePieza(Pieza pieza);
	
	Pieza piezaPorCodigo(Long codigo);
	
	Pieza updatePieza(Pieza pieza);
	
	void deletePieza(Long codigo);

}