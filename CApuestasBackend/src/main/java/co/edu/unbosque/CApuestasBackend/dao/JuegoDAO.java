package co.edu.unbosque.CApuestasBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.CApuestasBackend.model.Juego;

public interface JuegoDAO extends JpaRepository<Juego, Integer>{

}
