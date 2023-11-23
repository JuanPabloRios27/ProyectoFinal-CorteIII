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

import co.edu.unbosque.CApuestasBackend.dao.ChanceDAO;
import co.edu.unbosque.CApuestasBackend.model.Chance;


@RestController
@RequestMapping("chance")
public class ChanceAPI {
	@Autowired
	private ChanceDAO chanceDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Chance chance) {
		chanceDAO.save(chance);
	}
	
	@GetMapping("/listar")
	public List<Chance> listar(){
		return chanceDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		chanceDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Chance chance) {
		chanceDAO.save(chance);
	}
}
