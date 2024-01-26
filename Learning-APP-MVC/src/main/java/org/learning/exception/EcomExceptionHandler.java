package org.learning.exception;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class EcomExceptionHandler  {

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public ResponseEntity<ApiError> handelJBDCException(DataAccessException ex)
{
    ApiError apiError = new ApiError(500,"JDBC Exception "+ex.getMessage(),new Date());
    return  new ResponseEntity<ApiError>(apiError,NOT_FOUND);
}


}
