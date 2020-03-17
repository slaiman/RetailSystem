package Lyst.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {

    private int id;

    private String name;

    private Date date;

    private List<BillDto> bills;
}
