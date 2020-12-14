package com.cg.employeepayrollapp.exceptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.employeepayrollapp.dto.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ResponseDTO> employeeNotFoundException(NotFoundException e) {
		ResponseDTO status = new ResponseDTO("Exception: ", e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataMissingException.class)
	public final ResponseEntity<ResponseDTO> dataMissingException(DataMissingException e) {
		ResponseDTO status = new ResponseDTO("Exception: ", e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ResponseDTO> noElementException(NoSuchElementException e) {
		ResponseDTO status = new ResponseDTO("Exception: ", e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO response = new ResponseDTO("Exceptions: ",errMsg);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> anonymousException(Exception e) {
		ResponseDTO status = new ResponseDTO("Exception: ", e.getMessage());
		return new ResponseEntity<ResponseDTO>(status, HttpStatus.BAD_REQUEST);
	}
}