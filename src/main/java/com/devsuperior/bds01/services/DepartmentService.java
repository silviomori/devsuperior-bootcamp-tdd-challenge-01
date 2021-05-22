package com.devsuperior.bds01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public DepartmentService() {
	}

	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll(String orderBy) {
		List<Department> listEntity = repository.findAll(Sort.by(orderBy));
		return listEntity.stream().map(entity -> new DepartmentDTO(entity)).collect(Collectors.toList());
	}

}
