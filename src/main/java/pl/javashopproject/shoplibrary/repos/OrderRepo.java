package pl.javashopproject.shoplibrary.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javashopproject.shoplibrary.base.Order;

import java.util.List;

@Repository
public class OrderRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Order> getAll() {
        return jdbcTemplate.query("SELECT id_order, date, id_client FROM orders",
                BeanPropertyRowMapper.newInstance(Order.class));
    }

    public Order getById(int id) {
        return jdbcTemplate.queryForObject( "SELECT id_order, date, id_client FROM orders WHERE " + "id_order = ?",
                BeanPropertyRowMapper.newInstance(Order.class), id);
    }
}
