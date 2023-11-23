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

import co.edu.unbosque.CApuestasBackend.dao.SedeDAO;
import co.edu.unbosque.CApuestasBackend.model.Sede;


@RestController
@RequestMapping("sede")
public class SedeAPI {
	
	@Autowired
	private SedeDAO sedeDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Sede sede) {
		sedeDAO.save(sede);
	}
	
	@GetMapping("/listar")
	public List<Sede> listar(){
		return sedeDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		sedeDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Sede sede) {
		sedeDAO.save(sede);
	}
}
