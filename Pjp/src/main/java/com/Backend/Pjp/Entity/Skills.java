
package com.Backend.Pjp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreSkill;
    @Range(min = 0, max = 100, message = "Por favor, ingrese valores positivos entre 0 y 100.")
    private int porcentaje;
    @NotBlank
    private String imgsrc;
    private String colorInterno;
    private String colorExterno;

    public Skills() {
    }

    public Skills(@NotBlank String nombreSkill, @Range(min = 1, max = 100) int porcentaje,@NotBlank String imgsrc,
            String colorInterno, String colorExterno) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
        this.imgsrc = imgsrc;
        this.colorInterno = colorInterno;
        this.colorExterno = colorExterno;
    }

}