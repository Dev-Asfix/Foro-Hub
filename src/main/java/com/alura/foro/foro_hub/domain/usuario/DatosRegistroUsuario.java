package com.alura.foro.foro_hub.domain.usuario;

import com.alura.foro.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroUsuario(

        @NotBlank String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank String contrasena,
        @NotNull
        @Positive
        Long idPerfil
) {
}
