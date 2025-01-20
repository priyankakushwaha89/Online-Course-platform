package com.example.Online_Course_Platform.Handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(IdNotFoundException exception)
    {
        ResponseEntity<Object> entity=new ResponseEntity<>("Id Not Found...!!!", HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(CourseIdNotFoundException.class)
    public ResponseEntity<Object> handleCourseIdException(CourseIdNotFoundException exception)
    {
        ResponseEntity<Object> entity=new ResponseEntity<>("Course Id Not Found....!!!",HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException exception)
    {
        ResponseEntity<Object> entity=new ResponseEntity<>("Sorry! Data is not present....!!!",HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex)
    {
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->
        {
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleUniqueDataEntry(DataIntegrityViolationException exception, WebRequest request)
    {
        String errorMessage="Phone Number Already Resistered";
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getConstraintViolations().forEach(violation ->{
            String propertyPath=violation.getPropertyPath().toString();
            String errorMessage=violation.getMessage();
            errors.put(propertyPath, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
