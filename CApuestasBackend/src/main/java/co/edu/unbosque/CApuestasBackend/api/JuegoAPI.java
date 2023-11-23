package co.edu.unbosque.CApuestasBackend.api;

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

import co.edu.unbosque.CApuestasBackend.dao.JuegoDAO;
import co.edu.unbosque.CApuestasBackend.model.Juego;



@RestController
@RequestMapping("juegos")
public class JuegoAPI {

	
	@Autowired
	private JuegoDAO juegoDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Juego juego) {
		juegoDAO.save(juego);
	}
	
	@GetMapping("/listar")
	public List<Juego> listar(){
		return juegoDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		juegoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Juego juego) {
		juegoDAO.save(juego);
	}
}
