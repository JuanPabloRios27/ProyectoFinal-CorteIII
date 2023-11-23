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

import co.edu.unbosque.CApuestasBackend.dao.BalotoDAO;
import co.edu.unbosque.CApuestasBackend.model.Baloto;

@RestController
@RequestMapping("baloto")
public class BalotoAPI {
	
	@Autowired
	private BalotoDAO balotoDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Baloto baloto) {
		balotoDAO.save(baloto);
	}
	
	@GetMapping("/listar")
	public List<Baloto> listar(){
		return balotoDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		balotoDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Baloto baloto) {
		balotoDAO.save(baloto);
	}
}
