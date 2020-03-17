package Lyst.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Store")
@NoArgsConstructor
public class Store {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "employee_store")
    private List<Employee> employees;

    @OneToMany(mappedBy = "product_store")
    private List<Product> products;

}
