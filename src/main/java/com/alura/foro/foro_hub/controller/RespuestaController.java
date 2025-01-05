package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.respuesta.DatosDetalleRespuesta;
import com.alura.foro.foro_hub.domain.respuesta.DatosRegistroRespuesta;
import com.alura.foro.foro_hub.domain.respuesta.Respuesta;
import com.alura.foro.foro_hub.domain.respuesta.RespuestaRepository;
import com.alura.foro.foro_hub.domain.respuesta.validacion.RegistroDeRespuestas;
import jakarta.validation.Valid;
import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RegistroDeRespuestas registroDeRespuestas;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
                                    UriComponentsBuilder uriComponentsBuilder){

        var detalleRespuesta = registroDeRespuestas.registrar(datosRegistroRespuesta);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleRespuesta.id()).toUri();
        return ResponseEntity.created(uri).body(detalleRespuesta);
    }


    @GetMapping
    public ResponseEntity<Page<DatosDetalleRespuesta>> listar(@PageableDefault(size = 1)Pageable pageable){

        return ResponseEntity.ok(respuestaRepository.findAll(pageable).map(DatosDetalleRespuesta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarRespuesta(@PathVariable Long id){
        var respuestaOptional = respuestaRepository.findById(id);
        if(respuestaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO se encontro una respuesta con ese ID");
        }
        var respuesta = respuestaOptional.get();
        return ResponseEntity.ok(new DatosDetalleRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){
        var respuestaOptional = respuestaRepository.findById(id);
        if(respuestaOptional.isEmpty()){
            //            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un tópico con el ID proporcionado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro una Respuesta con ese id");
        }

        var respuesta = respuestaOptional.get();
        respuestaRepository.delete(respuesta);
        return ResponseEntity.noContent().build();

    }



}
