/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B11_BaiMauCURD_QuanHe.repository;

import B11_BaiMauCURD_QuanHe.model.Lop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class LopRepository {

    public List<Lop> getAll() {
        String query = "SELECT ma_lop, ten_lop "
                + "FROM Buoi9_TrenLop.dbo.lop";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<Lop> listLop = new ArrayList<>();
            while (rs.next()) {
                listLop.add(new Lop(rs.getString(1), rs.getString(2)));
            }
            return listLop;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Lop getOne(String maLop) {
        String query = "SELECT ma_lop, ten_lop "
                + "FROM Buoi9_TrenLop.dbo.lop WHERE ma_lop = ? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maLop);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Lop(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
