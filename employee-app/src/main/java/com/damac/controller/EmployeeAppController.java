package com.damac.controller;

import static com.damac.util.Constants.API;
import static com.damac.util.Constants.CREATE_EMP;
import static com.damac.util.Constants.DELETE_EMP;
import static com.damac.util.Constants.GET_ALL_DEP;
import static com.damac.util.Constants.GET_ALL_EMP;
import static com.damac.util.Constants.GET_EMP;
import static com.damac.util.Constants.UPDATE_EMP;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.damac.model.EmployeeReq;
import com.damac.model.Response;
import com.damac.model.SearchEmpReq;
import com.damac.srvc.EmployeeAppSrvc;

@RestController
@RequestMapping(API)
public class EmployeeAppController {
	
	private EmployeeAppSrvc employeeSrvc;

	public EmployeeAppController(EmployeeAppSrvc employeeSrvc) {
		this.employeeSrvc = employeeSrvc;
	}

	@PostMapping(CREATE_EMP)
	public ResponseEntity<Response> saveEmployee(@Valid @RequestBody EmployeeReq employeeReq) {
		return new ResponseEntity<>(employeeSrvc.saveEmployee(employeeReq), HttpStatus.OK);
	}

	@PutMapping(UPDATE_EMP)
	public ResponseEntity<Response> updateEmployee(@RequestBody EmployeeReq employeeReq) {
		return new ResponseEntity<>(employeeSrvc.updateEmployee(employeeReq), HttpStatus.CREATED);
	}

	@DeleteMapping(DELETE_EMP)
	public ResponseEntity<Response> deleteEmployee(@RequestParam("employeeNo") Long employeeNo) {
		return new ResponseEntity<>(employeeSrvc.deleteEmployee(employeeNo), HttpStatus.OK);
	}

	@PostMapping(GET_EMP)
	public ResponseEntity<?> getEmployee(@RequestBody SearchEmpReq searchEmpReq) {
		return new ResponseEntity<>(employeeSrvc.getEmployee(searchEmpReq), HttpStatus.OK);
	}
	
	@GetMapping(GET_ALL_EMP)
	public ResponseEntity<?> getAllEmployee() {
		return new ResponseEntity<>(employeeSrvc.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping(GET_ALL_DEP)
	public ResponseEntity<?> getAllDepartments() {
		return new ResponseEntity<>(employeeSrvc.getAllDepartments(), HttpStatus.OK);
	}
}
