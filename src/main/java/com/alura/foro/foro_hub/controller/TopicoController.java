package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.topico.DatosDetalleTopico;
import com.alura.foro.foro_hub.domain.topico.DatosRegistroTopico;
import com.alura.foro.foro_hub.domain.topico.validacion.RegistroDeTopicos;
import com.alura.foro.foro_hub.domain.topico.TopicoRepository;
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

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos,
                                    UriComponentsBuilder uriComponentsBuilder){
        var detalleTopico = topicosRepository.registrar(datos);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(detalleTopico.id()).toUri();
        return ResponseEntity.created(uri).body(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listar(@PageableDefault(page = 0, size = 10,sort={"titulo"} )
                                                           Pageable pageable){
        var page = registroTopico.findAll(pageable).map(DatosDetalleTopico::new);
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
}
