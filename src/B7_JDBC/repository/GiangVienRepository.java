/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B7_JDBC.repository;

import B7_JDBC.model.GiangVien;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hangnt
 */
public class GiangVienRepository {

    public List<GiangVien> getAll() {
        // B1: Tao query
        String query = "SELECT * FROM giang_vien gv";
        // B2: Mo connection
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            // B3: Statement:la 1 inteface cho phep 
            // cac gui cac cau len SQL toi Database
            // B4: Tao kieu tra ve cua ham
            List<GiangVien> listGiangVien = new ArrayList<>();
            // B5: Tao resultset: dai dien cho tap hop cac
            // ban ghi(record) co duoc sau khi thuc hien truy van ( query)
            ResultSet rs = ps.executeQuery();
            // B6: Doc data tu resultset
            while (rs.next()) {
                GiangVien gv = new GiangVien(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getBoolean(6));
                listGiangVien.add(gv);
            }
            return listGiangVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public GiangVien getOne(String maGV) {
        // B1: Tao query
        String query = "SELECT * FROM giang_vien gv WHERE gv.ma_gv  = ?";

        // B2: Mo connection
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            // B3: Statement:la 1 inteface cho phep 
            // cac gui cac cau len SQL toi Database
            // B4: Set tham so truyen vao
            ps.setObject(1, maGV);
            // B5: Tao resultset: dai dien cho tap hop cac
            // ban ghi(record) co duoc sau khi thuc hien truy van ( query)
            ResultSet rs = ps.executeQuery();
            // B6: Doc data tu resultset
            if (rs.next()) {
                GiangVien gv = new GiangVien(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getBoolean(6));
                return gv;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(GiangVien giangVien) {
        String query = "INSERT INTO B7_TrenLop.dbo.giang_vien "
                + " (ma_gv, ten_gv, tuoi, bac, loai, gioi_tinh) "
                + " VALUES(?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, giangVien.getMaGV());
            ps.setObject(2, giangVien.getTenGV());
            ps.setObject(3, giangVien.getTuoi());
            ps.setObject(4, giangVien.getBac());
            ps.setObject(5, giangVien.getLoai());
            ps.setObject(6, giangVien.isGioiTinh());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maGV) {
        String query = "DELETE FROM B7_TrenLop.dbo.giang_vien "
                + "WHERE ma_gv= ? ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maGV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(GiangVien gv, String maGV) {
        String query = "UPDATE B7_TrenLop.dbo.giang_vien "
                + "SET ten_gv= ? , tuoi= ? , bac= ? , loai= ? , gioi_tinh= ? "
                + "WHERE ma_gv= ? ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, gv.getTenGV());
            ps.setObject(2, gv.getTuoi());
            ps.setObject(3, gv.getLoai());
            ps.setObject(4, gv.getBac());
            ps.setObject(5, gv.isGioiTinh());
            ps.setObject(6, maGV);

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        GiangVien gv = new GiangVien("testUpdate", "testUpdate", 10, "full_time", "3", true);
        boolean testAdd = new GiangVienRepository().update(gv,"2");
        System.out.println(testAdd);
    }
}
