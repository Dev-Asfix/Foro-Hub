package com.alura.foro.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha_creacion,
        @NotBlank
        String status,
        @NotNull
        Long autor,
        @NotNull
        Long curso
) {
}
