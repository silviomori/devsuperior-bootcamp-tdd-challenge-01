package com.devsuperior.bds01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<Page<EmployeeDTO>> findAll(
			@RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
			@RequestParam(name = "size", defaultValue = "10") Integer size,
			@RequestParam(name = "direction", defaultValue = "ASC") String direction,
			@RequestParam(name = "orderBy", defaultValue = "name") String orderBy) {
		Pageable pageable = PageRequest.of(pageNumber, size, Direction.fromString(direction), orderBy);
		Page<EmployeeDTO> page = service.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}

}
