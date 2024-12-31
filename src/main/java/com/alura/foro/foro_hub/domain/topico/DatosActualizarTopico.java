package com.alura.foro.foro_hub.domain.topico;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico (

        String titulo,
        String mensaje,
        Estados status,
        Long autor,
        Long curso
){
}
