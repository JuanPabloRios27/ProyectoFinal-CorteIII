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

import co.edu.unbosque.CApuestasBackend.dao.BetplayDAO;
import co.edu.unbosque.CApuestasBackend.model.Betplay;

@RestController
@RequestMapping("betplay")

public class BetplayAPI {

	@Autowired
	private BetplayDAO betplayDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Betplay bet) {
		betplayDAO.save(bet);
	}
	
	@GetMapping("/listar")
	public List<Betplay> listar(){
		return betplayDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		betplayDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Betplay bet) {
		betplayDAO.save(bet);
	}
}
