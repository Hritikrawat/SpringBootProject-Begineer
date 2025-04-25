package com.MajorProject.student.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> failedInputArgument(MethodArgumentNotValidException e ){
        Map<String,Object> map = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach( error -> {

            map.put(error.getField(),error.getDefaultMessage());
        });
        return  map;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,Object> noStudentFound(NoSuchElementException e ){
        Map<String,Object> map = new HashMap<>();

        map.put("Data","No data found");
        map.put("Message",e.getMessage());
        return  map;
    }
}
