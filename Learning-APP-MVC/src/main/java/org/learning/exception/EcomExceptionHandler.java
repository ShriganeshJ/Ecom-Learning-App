package org.learning.exception;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class EcomExceptionHandler  {

    /**
     * If employee Not found in DB
     */

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> employeeNotFound()
    {
        ApiError apiError = new ApiError(400,"Provided Data Not Found ",new Date());
        return  new ResponseEntity<ApiError>(apiError,NOT_FOUND);
    }


    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public ResponseEntity<ApiError> handelJBDCException(DataAccessException ex)
{
    ApiError apiError = new ApiError(500,"JDBC Exception "+ex.getMessage(),new Date());
    return  new ResponseEntity<ApiError>(apiError,NOT_FOUND);
}


}
