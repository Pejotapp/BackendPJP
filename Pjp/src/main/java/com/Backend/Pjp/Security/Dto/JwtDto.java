
package com.Backend.Pjp.Security.Dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {
        private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

    // constuctor
    public JwtDto(String token, String nombreUsuario,
            Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }

}
