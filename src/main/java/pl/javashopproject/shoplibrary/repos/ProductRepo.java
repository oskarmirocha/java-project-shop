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
        return jdbcTemplate.queryForObject("SELECT id_product, product, price FROM products WHERE " + "id_product = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    public int save(List<Product> products) {
        products.forEach(product -> jdbcTemplate
                .update("INSERT INTO products(product, price) VALUES(?, ?)",
                        product.getProduct(), product.getPrice()
                ));
        return 1;
    }

    public int update(Product product) {
        return jdbcTemplate.update("UPDATE products SET product=?, price=? WHERE id_product=?",
                product.getProduct(), product.getPrice(), product.getId_product());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM products WHERE id_product=?", id);
    }

}
