package com.example.SampleJPAREST.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler
{
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
    Map<String,String> resp = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error)->{
        String fieldName =((FieldError) error).getField();
        String message = error.getDefaultMessage();
        resp.put(fieldName,message);
    });
    return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }

//    public ResponseEntity<Map<String, String>> handle(MethodArgumentNotValidException exception) {
//        Map<String, String> res = new HashMap<>();
//        exception.getBindingResult().getAllErrors().forEach((error) -> {
//            String fiedName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            res.put(fiedName, message);
//        });
//        return new ResponseEntity<Map<String,String>>(res, HttpStatus.BAD_REQUEST);
//    }
}
