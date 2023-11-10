package ejercicios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ejercicios.dto.Pieza;

public interface PiezaDAO extends JpaRepository<Pieza, Integer>{

}
