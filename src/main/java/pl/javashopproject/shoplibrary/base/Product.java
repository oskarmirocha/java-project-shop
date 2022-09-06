package pl.javashopproject.shoplibrary.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id_product;
    private String product;
    private int price;
}
