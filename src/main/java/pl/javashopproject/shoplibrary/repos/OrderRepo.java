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

    public int save(List<Order> orders) {
        orders.forEach(order -> jdbcTemplate
                .update("INSERT INTO orders(date, id_client) VALUES(?, ?)",
                        order.getDate(), order.getId_client()
                ));
        return 1;
    }

    public int update(Order order) {
        return jdbcTemplate.update("UPDATE orders SET id_client=?, date=? WHERE id_order=?",
                order.getId_order(), order.getDate(), order.getId_client());
    }
}
