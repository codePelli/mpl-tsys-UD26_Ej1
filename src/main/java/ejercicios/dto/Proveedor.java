package ejercicios.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	private String id;
	private String nombre;

	public Proveedor() {
		super();
	}
	
	@OneToMany(mappedBy = "proveedor")
	private List<Suministra> suministra;
	
	public Proveedor(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
