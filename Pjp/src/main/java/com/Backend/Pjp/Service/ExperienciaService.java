
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Experiencia;
import com.Backend.Pjp.Repository.ExperienciaRepository;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperienciaService {
   @Autowired
    ExperienciaRepository experienciaRepo;

    @Override
    public void deleteExperiencia(int id) {
        experienciaRepo.deleteById(id);

    }

    @Override
    public Experiencia findExperiencia(int id) {
        Experiencia expe = experienciaRepo.findById(id).orElse(null);
        return expe;
    }

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencias = experienciaRepo.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {

        experienciaRepo.save(experiencia);  
}}
