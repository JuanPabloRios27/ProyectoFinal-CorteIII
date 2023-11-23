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

import co.edu.unbosque.CApuestasBackend.dao.SuperastroDAO;
import co.edu.unbosque.CApuestasBackend.model.Superastro;



@RestController
@RequestMapping("superastro")
public class SuperastroAPI {
	@Autowired
	private SuperastroDAO superastroDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Superastro supe) {
		superastroDAO.save(supe);
	}
	
	@GetMapping("/listar")
	public List<Superastro> listar(){
		return superastroDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		superastroDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Superastro sup) {
		superastroDAO.save(sup);
	}
}
