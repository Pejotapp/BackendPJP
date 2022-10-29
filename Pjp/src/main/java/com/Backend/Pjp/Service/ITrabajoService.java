
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Trabajo;
import javax.validation.constraints.NegativeOrZero.List;


public interface ITrabajoService {
    
    
     public void saveTrabajo(Trabajo trabajo);

    public void deleteTrabajo(int id);

    public List<Trabajo> traerTrabajos();

    public Trabajo traerTrabajoPorId(int id);
}
