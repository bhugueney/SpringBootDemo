package co.simplon.demo;

import org.springframework.web.client.HttpServerErrorException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC {
    Connection c;

    public CityDaoJDBC() {
        try {
            c = DriverManager.getConnection("jdbc:postgresql://balarama.db.elephantsql.com/ryvqsokv"
                    , "ryvqsokv", "DNu2xjb_tneZuLdkEE70tSA7c5XVvXz7");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public City findOne(final long id) {
        City res = null; // TODO Optional<City>
        try (PreparedStatement ps =
                     c.prepareStatement("SELECT * FROM \"public\".\"City\" WHERE index= ?;")) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();// move to first and only row
            res = new City(rs.getString(2), rs.getDouble(3), rs.getDouble(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<City> findAll() {
        throw new UnsupportedOperationException();
    }

    public List<City> findAllPaged(final int pageNum, final int pageSize) {
        throw new UnsupportedOperationException();
    }

    public City create(final City entity) {
        throw new UnsupportedOperationException();
    }

    public City update(final City entity) {
        throw new UnsupportedOperationException();
    }

    public void delete(final City entity) {
        throw new UnsupportedOperationException();
    }

    public void deleteById(final long entityId) {
        delete(findOne(entityId));
    }
}
