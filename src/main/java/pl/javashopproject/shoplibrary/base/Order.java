package pl.javashopproject.shoplibrary.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id_order;
    private LocalDateTime date;
    private int id_client;
}
