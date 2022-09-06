package pl.javashopproject.shoplibrary.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private int id_client;
    private String name;
    private String surname;
    private String NIP;
    private String Number;
}

