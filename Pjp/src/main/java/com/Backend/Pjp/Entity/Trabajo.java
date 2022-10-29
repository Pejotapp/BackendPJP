
package com.Backend.Pjp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String nombreTrabajo;
    @NotBlank
    private String descripcionTrabajo;
    private String imgtrabajo;
    private String linktrabajo;

    
    public Trabajo() {
    }


    public Trabajo(@NotBlank String nombreTrabajo, @NotBlank String descripcionTrabajo, String imgtrabajo, String linktrabajo) {
        this.nombreTrabajo = nombreTrabajo;
        this.descripcionTrabajo = descripcionTrabajo;
        this.imgtrabajo = imgtrabajo;
        this.linktrabajo = linktrabajo;
    }
}

