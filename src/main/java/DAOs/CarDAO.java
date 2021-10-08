package DAOs;

import models.CarModel;
import models.ToDoItem;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;


//I didn't implement the interface because I wanted to try out a static method DAO
//So I refactored this to just have a partial save method for tinkering.

/**
 * This example shows how to retrieve the automatically generated key
 * after a new row is inserted into our table.
 */
public class CarDAO {
    private Connection conn;

    public CarDAO(Connection conn) {
        this.conn = conn;
    }

    public void save(CarModel carModel) throws SQLException {
        String sql = "insert into cars (color, make, model, model_year) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, RETURN_GENERATED_KEYS);
        pstmt.setString(1, carModel.getColor());
        pstmt.setString(2, carModel.getMake());
        pstmt.setString(3, carModel.getModel());
        pstmt.setInt(4, carModel.getYear());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();

        rs.next();
        carModel.setId(rs.getInt("id"));
        //we could also identify the column by index 1

    }

    public CarModel getCarByID(int id) throws SQLException {
        String sql = "SELECT * FROM CAR WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            return new CarModel(rs.getInt("ID"),
                    rs.getString("COLOR"), rs.getString("MAKE"),
                    rs.getString("MODEL"), rs.getInt("CAR_YEAR"));
        } else {
            return null;
        }

    }

}
