package com.alura.foro.foro_hub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(
        @NotBlank String nombre
) {
}
