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
    public int save(List<Detail> details) {
        details.forEach(detail -> jdbcTemplate
                .update("INSERT INTO details(id_order, id_product, amount) VALUES(?, ?, ?)",
                        detail.getId_order(), detail.getId_product(),detail.getAmount()
                ));
        return 1;
    }

    public int update(Detail detail ) {
        return jdbcTemplate.update("UPDATE details SET id_product=?, amount=? WHERE id_order=?",
                detail.getId_product(), detail.getAmount(), detail.getId_order());
    }
    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM details WHERE id_order=?", id);
    }
}
