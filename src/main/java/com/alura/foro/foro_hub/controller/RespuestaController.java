package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.respuesta.DatosRegistroRespuesta;
import com.alura.foro.foro_hub.domain.respuesta.validacion.RegistroDeRespuestas;
import jakarta.validation.Valid;
import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RegistroDeRespuestas registroDeRespuestas;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
                                    UriComponentsBuilder uriComponentsBuilder){

        var detalleRespuesta = registroDeRespuestas.registrar(datosRegistroRespuesta);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleRespuesta.id()).toUri();
        return ResponseEntity.created(uri).body(detalleRespuesta);
    }

}
