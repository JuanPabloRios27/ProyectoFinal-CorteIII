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

import co.edu.unbosque.CApuestasBackend.dao.LoteriaDAO;
import co.edu.unbosque.CApuestasBackend.model.Loteria;



@RestController
@RequestMapping("loteria")
public class LoteriaAPI {
	@Autowired
	private LoteriaDAO loteriaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Loteria loteria) {
		loteriaDAO.save(loteria);
	}
	
	@GetMapping("/listar")
	public List<Loteria> listar(){
		return loteriaDAO.findAll();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		loteriaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Loteria loteria) {
		loteriaDAO.save(loteria);
	}
}
