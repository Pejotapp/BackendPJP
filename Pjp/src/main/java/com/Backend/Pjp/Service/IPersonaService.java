
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Persona;


public interface IPersonaService {
        public Persona traerPersona();
    public void savePersona(Persona persona);
    public void deletePersona(int id);
    public Persona editarPersona(Persona persona);
    
}
