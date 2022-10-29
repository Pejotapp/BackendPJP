
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Persona;
import com.Backend.Pjp.Repository.PersonaRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService implements IPersonaService{
     @Autowired
    PersonaRepository personaRepo;

    @Override
    public void deletePersona(int id) {
        personaRepo.deleteById(1);

    }

    @Override
    public Persona editarPersona(Persona nuevaPersona) {
        Persona persona = personaRepo.findById(1).orElse(null);
        persona.setNombre(nuevaPersona.getNombre());
        persona.setApellido(nuevaPersona.getApellido());
        persona.setImg(nuevaPersona.getImg());
        persona.setAbout(nuevaPersona.getAbout());
        persona.setTitulo(nuevaPersona.getTitulo());

        return persona;
    }

    @Override
    public void savePersona(Persona persona) {

        personaRepo.save(persona);

    }

    @Override
    public Persona traerPersona() {
        return personaRepo.getReferenceById(1);
    }

}
