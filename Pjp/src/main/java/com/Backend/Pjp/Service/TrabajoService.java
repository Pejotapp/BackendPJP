
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Trabajo;
import com.Backend.Pjp.Repository.TrabajoRepository;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrabajoService implements ITrabajoService {
     @Autowired
    TrabajoRepository trabajoRepo;

    @Override
    public void deleteTrabajo(int id) {
        trabajoRepo.deleteById(id);
    }

    @Override
    public void saveTrabajo(Trabajo trabajo) {
        trabajoRepo.save(trabajo);
        
    }

    @Override
    public Trabajo traerTrabajoPorId(int id) {
        Trabajo tra = trabajoRepo.findById(id).orElse(null);
        return tra;
    }

    @Override
    public List<Trabajo> traerTrabajos() {
        List<Trabajo> trabajos = trabajoRepo.findAll();
        return trabajos;
    }
}
   
  

