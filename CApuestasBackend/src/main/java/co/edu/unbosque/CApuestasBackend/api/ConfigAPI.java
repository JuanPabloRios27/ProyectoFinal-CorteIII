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

import co.edu.unbosque.CApuestasBackend.dao.ConfigDAO;
import co.edu.unbosque.CApuestasBackend.model.Config;


@RestController
@RequestMapping("configuracion")
public class ConfigAPI {

	@Autowired
	private ConfigDAO configDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Config config) {
		configDAO.save(config);
	}
	
	@GetMapping("/listar")
	public List<Config> listar(){
		return configDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		configDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Config config) {
		configDAO.save(config);
	}
	
}
