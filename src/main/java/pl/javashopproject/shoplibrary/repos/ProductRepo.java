package pl.javashopproject.shoplibrary.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javashopproject.shoplibrary.base.Product;

import java.util.List;

@Repository
public class ProductRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT id_product, product, price FROM products",
            BeanPropertyRowMapper.newInstance(Product.class));
    }

    public Product getById(int id) {
        return jdbcTemplate.queryForObject( "SELECT id_product, product, price FROM products WHERE " + "id_product = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
    }
}
