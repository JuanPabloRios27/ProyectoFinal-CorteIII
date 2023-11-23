package co.edu.unbosque.CApuestasBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.CApuestasBackend.model.Chance;



public interface ChanceDAO extends JpaRepository<Chance, Integer>{

}
