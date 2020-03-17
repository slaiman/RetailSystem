package Lyst.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StoreDto {

    private int id;

    private String name;

    private String type;

    private List<EmployeeDto> employees;

    private List<ProductDto> products;
}
