
package com.Backend.Pjp.Service;

import com.Backend.Pjp.Entity.Skills;
import java.util.List;



public interface ISkillsService {
    
        public void saveSkills(Skills skills);

    public void deleteSkills(int id);

    public List<Skills> traerSkills();

    public Skills traerSkillsPorId(int id);
}
