package com.alura.foro.foro_hub.infra.errores;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException ex){
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(DatosDetalleErrores::new).toList());
    }



    private record DatosDetalleErrores(String campo, String mensaje, int hash){
        public DatosDetalleErrores(FieldError error){
            this(error.getField(), error.getDefaultMessage(), error.hashCode());
        }
    }

}
