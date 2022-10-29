
package com.Backend.Pjp.Controller;


import com.Backend.Pjp.Entity.Trabajo;
import com.Backend.Pjp.Service.ITrabajoService;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://localhost:4200")
@RequestMapping("trabajo")
@RestController
public class TrabajoController {
    
    @Autowired
    public ITrabajoService iTrabajoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Trabajo>> lista() {
        List<Trabajo> listaTrabajos = iTrabajoService.traerTrabajos();
        return new ResponseEntity<>(listaTrabajos, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> addTrabajo(@RequestBody Trabajo trabajo) {
        if (StringUtils.isBlank(trabajo.getNombreTrabajo())
                && StringUtils.isBlank(trabajo.getDescripcionTrabajo())) {
            return new ResponseEntity<>("Campos obligatorios vacios.", HttpStatus.BAD_REQUEST);
        }

        iTrabajoService.saveTrabajo(trabajo);
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarTrabajo(@PathVariable int id) {

        Trabajo trabajo = iTrabajoService.traerTrabajoPorId(id);
        if (trabajo == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTrabajo(@PathVariable int id, @RequestBody Trabajo trabajo) {
        if (iTrabajoService.traerTrabajoPorId(id) == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(trabajo.getNombreTrabajo())
                && StringUtils.isBlank(trabajo.getDescripcionTrabajo())) {
            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);
        }

        Trabajo trabajoNuevo = iTrabajoService.traerTrabajoPorId(id);

        trabajoNuevo.setNombreTrabajo(trabajo.getNombreTrabajo());
        trabajoNuevo.setDescripcionTrabajo(trabajo.getDescripcionTrabajo());
        trabajoNuevo.setImgtrabajo(trabajo.getImgtrabajo());
        trabajoNuevo.setLinktrabajo(trabajo.getLinktrabajo());

        iTrabajoService.saveTrabajo(trabajoNuevo);

        return new ResponseEntity<>(trabajoNuevo, HttpStatus.OK);

    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarTrabajo(@PathVariable int id) {

        if (iTrabajoService.traerTrabajoPorId(id) == null) {
            return new ResponseEntity<>("Proyecto no encontrado", HttpStatus.BAD_REQUEST);
        }
        iTrabajoService.deleteTrabajo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
