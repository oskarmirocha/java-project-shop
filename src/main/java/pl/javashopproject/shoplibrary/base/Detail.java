package pl.javashopproject.shoplibrary.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private int id_order;
    private int id_product;
    private int amount;
}
