package Lyst.service;


import Lyst.DTO.BillDto;

public interface  BillService {

    public Double CalculatePayment(int billId) throws Exception;

    public BillDto findById(int billId) throws Exception;
}
