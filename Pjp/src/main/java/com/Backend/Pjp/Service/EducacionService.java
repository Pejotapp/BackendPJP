
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Educacion;
import com.Backend.Pjp.Repository.EducacionRepository;
import javax.transaction.Transactional;
import javax.validation.constraints.NegativeOrZero.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacionService{
    
    @Autowired
    EducacionRepository educacionRepo;

    @Override
    public void deleteEducacion(int id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        Educacion edu = educacionRepo.findById(id).orElse(null);
        return edu;
    }

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educaciones = educacionRepo.findAll();
        return educaciones;
    }

    @Override
    public void saveEducacion(Educacion educacion) {

        educacionRepo.save(educacion);

    }
}
