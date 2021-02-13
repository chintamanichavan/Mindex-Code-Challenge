package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        int reportCount = -1;
        Stack<Employee> reportStack = new Stack<>();
        reportStack.add(employee);

        while (!reportStack.isEmpty()) {
            Employee curEmployee = reportStack.pop();
            System.out.println(curEmployee.getEmployeeId());
            reportCount++;
            List<Employee> directReports = curEmployee.getDirectReports();
            if (directReports != null) {
                for (Employee directEmployee : directReports) {
                    directEmployee = employeeRepository.findByEmployeeId(directEmployee.getEmployeeId());
                    reportStack.push(directEmployee);
                }
            }
        }

        return new ReportingStructure(employee, reportCount);
    }
}
