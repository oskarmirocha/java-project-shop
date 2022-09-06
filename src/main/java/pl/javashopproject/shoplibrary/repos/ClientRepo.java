package pl.javashopproject.shoplibrary.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javashopproject.shoplibrary.base.Client;

import java.util.List;

@Repository
public class ClientRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Client> getAll() {
        return jdbcTemplate.query("SELECT id_client, name, surname, NIP, number FROM clients",
                BeanPropertyRowMapper.newInstance(Client.class));
    }

    public Client getById(int id) {
        return jdbcTemplate.queryForObject( "SELECT id_client, name, surname, NIP, number FROM clients WHERE " + "id_client = ?",
                BeanPropertyRowMapper.newInstance(Client.class), id);
    }

    public int save(List<Client> clients) {
        clients.forEach(client -> jdbcTemplate
                .update("INSERT INTO clients(name, surname, NIP, number) VALUES(?, ?, ?, ?)",
                        client.getName(), client.getSurname(), client.getNIP(), client.getNumber()
                ));
        return 1;
    }

    public int update(Client client) {
        return jdbcTemplate.update("UPDATE clients SET name=?, surname=?, NIP=?, number=? WHERE id_client=?",
                client.getName(), client.getSurname(), client.getNIP(), client.getNumber(), client.getId_client());
    }
}