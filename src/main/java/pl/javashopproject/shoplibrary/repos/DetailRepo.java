package pl.javashopproject.shoplibrary.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.javashopproject.shoplibrary.base.Detail;

import java.util.List;

@Repository
public class DetailRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Detail> getAll() {
        return jdbcTemplate.query("SELECT id_order, id_product, amount FROM details",
                BeanPropertyRowMapper.newInstance(Detail.class));
    }

    public Detail getById(int id) {
        return jdbcTemplate.queryForObject( "SELECT id_order, id_product, amount FROM details WHERE " + "id_order = ?",
                BeanPropertyRowMapper.newInstance(Detail.class), id);
    }
}
