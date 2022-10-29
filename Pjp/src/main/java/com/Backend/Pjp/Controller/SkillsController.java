/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Backend.Pjp.Controller;

/**
 *
 * @author pagua
 */
public class SkillsController {
 @Autowired
    public ISkillsService iSkillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> mostrarSkills() {
        List<Skills> listaSkills = iSkillsService.traerSkills();
        return new ResponseEntity<>(listaSkills, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarSkillporId(@PathVariable int id) {

        Skills skill = iSkillsService.traerSkillsPorId(id);
        if (skill == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarSkilll(@RequestBody Skills skill) {
        if (StringUtils.isBlank(skill.getNombreSkill())
                && StringUtils.isBlank(skill.getImgsrc())
                && skill.getPorcentaje() <= 0) {
            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);

        }
        iSkillsService.saveSkills(skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkills(@PathVariable int id, @RequestBody Skills skill) {
        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skills no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skill.getNombreSkill())
                && StringUtils.isBlank(skill.getImgsrc())
                && skill.getPorcentaje() <= 0) {

            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);
        }

        Skills nuevaSkill = iSkillsService.traerSkillsPorId(id);

        nuevaSkill.setNombreSkill(skill.getNombreSkill());
        nuevaSkill.setPorcentaje(skill.getPorcentaje());
        nuevaSkill.setImgsrc(skill.getImgsrc());
        nuevaSkill.setColorInterno(skill.getColorInterno());
        nuevaSkill.setColorExterno(skill.getColorExterno());

        iSkillsService.saveSkills(nuevaSkill);

        return new ResponseEntity<>(nuevaSkill, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable int id) {

        if (iSkillsService.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.NOT_FOUND);
        }
        iSkillsService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}