package Lyst.api.controller;

import Lyst.DTO.BillDto;
import Lyst.DTO.EmployeeDto;
import Lyst.service.BillService;
import Lyst.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/RetailPay")
@RestController
public class MainController {

    @Autowired
    private BillService billService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/CalculatePayment", method = RequestMethod.GET,produces = "application/json")
    ResponseEntity<Double> CalculatePayment(@RequestParam int billId) throws Exception
    {
        Double pay = billService.CalculatePayment(billId);
        return new ResponseEntity<Double>(pay,HttpStatus.OK);
    }

    @RequestMapping(value = "/GetBillByID", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<BillDto> getBillById(@RequestParam int billId) throws Exception
    {
        BillDto billDTO = billService.findById(billId);
        //log.info("GET CUSTOMER- customer found with id {}: {}", employeeId, customerDTO);
        return new ResponseEntity<BillDto>(billDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/GetEmployeeByID", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam int employeeId) throws Exception
    {
        EmployeeDto employeeDTO = employeeService.findById(employeeId);
        //log.info("GET CUSTOMER- customer found with id {}: {}", employeeId, customerDTO);
        return new ResponseEntity<EmployeeDto>(employeeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/GetEmployees", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<EmployeeDto>> GetCalculatePayment() throws Exception
    {
        return  new ResponseEntity<List<EmployeeDto>>(employeeService.GetEmployees(),HttpStatus.OK);
    }
}
