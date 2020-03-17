package Lyst.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDto {

    private int id;

    private String name;

    private Double total;

    private Double netpayment;

    private CustomerDto bill_customer;

    private StoreDto bill_store;

    private ProductDto bill_product;

    public BillDto(Integer id, String name, Double total, Double netpayment) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.netpayment = netpayment;
    }

}
