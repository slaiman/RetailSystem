package Lyst.service;


import Lyst.DTO.BillDto;
import Lyst.exceptions.ControllerException;
import Lyst.model.Bill;
import Lyst.repository.BillRepository;
import Lyst.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService{

    private static final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Double CalculatePayment(int billId) throws ControllerException
    {
        Bill bill = billRepository.findById(billId).get();
        BillDto billDto = new BillDto(bill.getId()
                ,bill.getName()
                ,bill.getTotal()
                ,bill.getNetpayment());
        double payment = billDto.getTotal();

        //For every $100 on the bill, there would be a $ 5 discount
        payment = payment - ( (int) (payment / 100) * 5);

        //if the bill store is not of type groceries
        if(!billDto.getBill_store().getType().equals("groceries"))
        {
            //if the user is an employee and has a store
            if(employeeRepository.existsById(billDto.getBill_customer().getId()) && employeeRepository.getOne(billDto.getBill_customer().getId()).getEmployee_store() != null )
            {
                //If the user is an employee of the store, he gets a 30% discount
                if( employeeRepository.getOne(billDto.getBill_customer().getId()).getEmployee_store().getId() == billDto.getBill_store().getId())
                {
                    payment = payment * 0.7;
                }
                //If the user is an affiliate of the store, he gets a 10% discount
                else if( employeeRepository.getOne(billDto.getBill_customer().getId()).getEmployee_store().getId() != billDto.getBill_store().getId() )
                {
                    payment = payment * 0.9;
                }
            }

            //If the user has been a customer for over 2 years, he gets a 5% discount
            else if( Period.between(LocalDate.now(), new java.sql.Date(billDto.getBill_customer().getDate().getTime()).toLocalDate()).getYears() > 2 )
            {
                payment = payment * 0.95;
            }
        }

        //set the new payment to the bill
        billDto.setNetpayment(payment);
        //save the bill to the repository
        bill.setNetpayment(payment);
        billRepository.save(bill);

        return payment;
    }

    @Override
    public BillDto findById(int billId) throws Exception {
        Optional<Bill> bill = billRepository.findById(billId);
        /*BillDto billDTO = modelMapper.map(bill, BillDto.class);
        return billDTO;*/
        return new BillDto(bill.get().getId()
                ,bill.get().getName()
                ,bill.get().getTotal()
                ,bill.get().getNetpayment());
    }
}
