
package com.Backend.Pjp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreExpe;
    @NotBlank
    private String descripcionExpe;
    @NotBlank
    private String fechainicio;
    private String fechafin;

    public Experiencia() {
    }

    public Experiencia(@NotBlank String nombreExpe,@NotBlank String descripcionExpe, @NotBlank String fechainicio, String fechafin) {
        this.nombreExpe = nombreExpe;
        this.descripcionExpe = descripcionExpe;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

}
    

