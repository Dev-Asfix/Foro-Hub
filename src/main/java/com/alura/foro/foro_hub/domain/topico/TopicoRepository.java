package com.alura.foro.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(@NotBlank String titulo, @NotBlank String mensaje);


    @Query("SELECT t FROM topico t WHERE " +
            "(:curso IS NULL OR t.curso.nombre LIKE %:curso%) AND " +
            "(:year IS NULL OR YEAR(t.fecha_creacion) = :year)")
    Page<Topico> buscarPorCursoDeYear(@Param("curso") String curso,
                                      @Param("year") Integer year,
                                      Pageable pageable);

//    @Query("SELECT t FROM topico t WHERE " +
//            "(:curso IS NULL OR t.curso.nombre = :curso) AND " +
//            "(:year IS NULL OR YEAR(t.fecha_creacion) = :year)")
}
