package com.alura.foro.foro_hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosDetalleUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        String contrasena,
        Long idPerfil
) {
    public DatosDetalleUsuario(Usuario datos){
        this(datos.getId(), datos.getNombre(), datos.getCorreo_electronico(),datos.getContrasena(),datos.getPerfil().getId());
    }
}
