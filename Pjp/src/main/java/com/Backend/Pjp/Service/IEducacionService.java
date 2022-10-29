
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Educacion;
import javax.validation.constraints.NegativeOrZero.List;

public interface IEducacionService {
     
    public List<Educacion> getEducacion();

    public void saveEducacion(Educacion educacion);

    public void deleteEducacion(int id);

    public Educacion findEducacion(int id);

}
