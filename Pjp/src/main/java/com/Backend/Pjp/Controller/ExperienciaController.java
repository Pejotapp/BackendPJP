/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Backend.Pjp.Controller;


import com.Backend.Pjp.Entity.Experiencia;
import com.Backend.Pjp.Service.IExperienciaService;
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


 @CrossOrigin(origins = "https://frontpjp.web.app")
@RequestMapping("experiencia")
@RestController
public class ExperienciaController {
     @Autowired
    public IExperienciaService iExperienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> listaExpe = iExperienciaService.getExperiencia();
        return new ResponseEntity<>(listaExpe, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarExperiencia(@PathVariable int id) {

        Experiencia expe = iExperienciaService.findExperiencia(id);
        if (expe == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarExperiencia(@RequestBody Experiencia expe) {
        if (StringUtils.isBlank(expe.getNombreExpe())
                && StringUtils.isBlank(expe.getDescripcionExpe())
                && StringUtils.isBlank(expe.getFechainicio())) {
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);

        }
        iExperienciaService.saveExperiencia(expe);
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarExperiencia(@PathVariable int id, @RequestBody Experiencia experiencia) {
        if (iExperienciaService.findExperiencia(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experiencia.getNombreExpe())
                && StringUtils.isBlank(experiencia.getDescripcionExpe())
                && StringUtils.isBlank(experiencia.getFechainicio())) {
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);
        }

        Experiencia experienciaEditada = iExperienciaService.findExperiencia(id);

        experienciaEditada.setNombreExpe(experiencia.getNombreExpe());
        experienciaEditada.setDescripcionExpe(experiencia.getDescripcionExpe());
        experienciaEditada.setFechainicio(experiencia.getFechainicio());
        experienciaEditada.setFechafin(experiencia.getFechafin());

        iExperienciaService.saveExperiencia(experienciaEditada);

        return new ResponseEntity<>(experienciaEditada, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable int id) {

        if (iExperienciaService.findExperiencia(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        iExperienciaService.deleteExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
