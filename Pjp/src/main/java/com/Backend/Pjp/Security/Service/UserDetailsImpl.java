package com.Backend.Pjp.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;



public class UserDetailsImpl implements UserDetailsService{
       @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
