package com.damac.srvc;

import java.util.List;

import com.damac.model.DepartmentVO;
import com.damac.model.EmployeeReq;
import com.damac.model.EmployeeRespVO;
import com.damac.model.Response;
import com.damac.model.SearchEmpReq;

public interface EmployeeAppSrvc {

	Response saveEmployee(EmployeeReq employeeReq);

	Response updateEmployee(EmployeeReq employeeReq);

	Response deleteEmployee(Long employeeNo);

	List<EmployeeRespVO> getEmployee(SearchEmpReq searchEmpReq);

	List<DepartmentVO> getAllDepartments();

	List<EmployeeRespVO> getAllEmployee();
}
