package Lyst.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Bill")
@NoArgsConstructor
public class Bill {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "total")
    private Double total;

    @Column(name = "netpayment")
    private Double netpayment;

    @ManyToOne
    private Customer bill_customer;

    @ManyToOne
    private Store bill_store;

    @ManyToOne
    private Product bill_product;

    public Bill(Integer id, String name, Double total, Double netpayment) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.netpayment = netpayment;
    }
}
