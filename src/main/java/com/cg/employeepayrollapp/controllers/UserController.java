package com.cg.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeepayrollapp.dto.ResponseDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getUser() {
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", "Hiii");
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
