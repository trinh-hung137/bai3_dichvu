package dao;

import models.Check;
import models.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CheckDAO extends DAO {
    public CheckDAO() {
        super();
        checkTable();
    }

    private void checkTable() {
        String sql = "CREATE TABLE IF NOT EXISTS check (id INT NOT NULL AUTO_INCREMENT, amount INT, PRIMARY KEY (id))";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Check> findAll() {
        String sql = "SELECT * FROM check";
        ArrayList<Check> checks = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Check check = new Check();
                check.setId(rs.getString("id"));
                check.setAmount(rs.getInt("amount"));
                checks.add(check);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checks;
    }
    public boolean checkInventory(String id, int quantity) {
        String sql = "SELECT amount FROM check WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int stockQuantity = rs.getInt("amount");
                if (stockQuantity >= quantity) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
