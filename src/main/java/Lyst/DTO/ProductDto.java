package Lyst.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private int id;

    private String name;

    private StoreDto product_store;

    private CategoryDto product_category;
}
