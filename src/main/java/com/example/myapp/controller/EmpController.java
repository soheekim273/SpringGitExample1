package com.example.myapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.model.Emp;
import com.example.myapp.service.IEmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	IEmpService empService;
	
	// 1. 전체 직원 수 조회
	@GetMapping("/cnt")
	public int getEmpCount() {
		return empService.getEmpCount();
	}
	
	// 2. 특정 부서의 직원 수 조회
    @GetMapping("/cnt/{deptid}")
    public int getEmpCountByDept(@PathVariable int deptid) {
        return empService.getEmpCount(deptid);
    }

    // 3. 모든 직원 리스트 조회
    @GetMapping
    public List<Emp> getAllEmployees() {
        return empService.getEmpList();
    }

    // 4. 특정 직원 정보 조회
    @GetMapping("/{empid}")
    public Emp getEmployeeById(@PathVariable int empid) {
        return empService.getEmpInfo(empid);
    }

    // 5. 직원 정보 추가
    @PostMapping
    public void addEmployee(@RequestBody Emp emp) {
        empService.insertEmp(emp);
    }

    // 6. 직원 정보 수정
    @PutMapping("/{empid}")
    public void updateEmployee(@PathVariable int empid, @RequestBody Emp emp) {
        empService.updateEmp(emp);
    }

    // 7. 직원 정보 삭제
    @DeleteMapping("/{empid}/{email}")
    public int deleteEmployee(@PathVariable int empid, @PathVariable String email) {
        return empService.deleteEmp(empid, email);
    }

    // 8. 모든 부서 ID 조회
    @GetMapping("/departments")
    public List<Map<String, Object>> getAllDepartments() {
        return empService.getAllDeptId();
    }

    // 9. 모든 직책 ID 조회
    @GetMapping("/jobs")
    public List<Map<String, Object>> getAllJobIds() {
        return empService.getAllJobId();
    }

    // 10. 모든 매니저 ID 조회
    @GetMapping("/managers")
    public List<Map<String, Object>> getAllManagerIds() {
        return empService.getAllManagerId();
    }
}
