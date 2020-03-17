package Lyst.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Category")
@NoArgsConstructor
public class Category {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @OneToMany(mappedBy = "product_category")
    private List<Product> products;

}
