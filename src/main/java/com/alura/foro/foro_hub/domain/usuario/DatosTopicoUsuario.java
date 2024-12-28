package com.alura.foro.foro_hub.domain.usuario;

import com.alura.foro.foro_hub.domain.perfil.Perfil;

public record DatosTopicoUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        Perfil perfil
) {
    public DatosTopicoUsuario(Usuario datos){
        this(datos.getId(), datos.getNombre(), datos.getCorreo_electronico(), datos.getPerfil());
    }
}
