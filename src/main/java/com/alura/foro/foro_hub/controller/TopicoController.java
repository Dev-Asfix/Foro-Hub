package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.curso.CursoRepository;
import com.alura.foro.foro_hub.domain.topico.*;
import com.alura.foro.foro_hub.domain.topico.validacion.ActualizacionDeTopicos;
import com.alura.foro.foro_hub.domain.topico.validacion.RegistroDeTopicos;
import com.alura.foro.foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos topicosRepository;

    @Autowired
    private TopicoRepository registroTopico;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ActualizacionDeTopicos actualizacionDeTopicos;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos,
                                    UriComponentsBuilder uriComponentsBuilder){
        var detalleTopico = topicosRepository.registrar(datos);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleTopico.id()).toUri();
        return ResponseEntity.created(uri).body(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page <DatosDetalleTopico>> listar(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) Integer year,
            @PageableDefault(page = 0, size = 10,sort={"titulo"} ) Pageable pageable){

        if(curso == null && year == null){
            var page = registroTopico.findAll(pageable).map(DatosDetalleTopico::new);
            return ResponseEntity.ok(page);
        }

        var page = registroTopico.buscarPorCursoDeYear(curso, year, pageable).map(DatosDetalleTopico::new);
        return ResponseEntity.ok(page);

    }


    @GetMapping("{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topicoOptional = registroTopico.findById(id);

        if(topicoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un tópico con el ID proporcionado.");
        }
         var topico = topicoOptional.get();


        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizarTopico datos , @PathVariable Long id){

        try{
            var detalleTopico = actualizacionDeTopicos.actualizar(id, datos);
            return ResponseEntity.ok(detalleTopico);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico = registroTopico.findById(id);
        if(topico.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró un tópico con el ID proporcionado");
        }

        registroTopico.delete(topico.get());
        return ResponseEntity.noContent().build();

    }
}
