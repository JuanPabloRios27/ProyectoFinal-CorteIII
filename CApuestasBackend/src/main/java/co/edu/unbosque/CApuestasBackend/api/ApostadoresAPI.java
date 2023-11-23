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

import co.edu.unbosque.CApuestasBackend.dao.ApostadoresDAO;
import co.edu.unbosque.CApuestasBackend.model.Apostadores;

@RestController
@RequestMapping("apostadores")
public class ApostadoresAPI {

		@Autowired
		private ApostadoresDAO apostadoresDAO;
		
		@PostMapping("/guardar")
		public void guardar(@RequestBody Apostadores apostadores) {
			apostadoresDAO.save(apostadores);
		}
		
		@GetMapping("/listar")
		public List<Apostadores> listar(){
			return apostadoresDAO.findAll();
			
		}
		
		@DeleteMapping("/eliminar/{id}")
		public void eliminar(@PathVariable("id") Integer id) {
			apostadoresDAO.deleteById(id);
		}
		
		@PutMapping("/actualizar")
		public void actualizar(@RequestBody Apostadores apostadores) {
			apostadoresDAO.save(apostadores);
		}
}
