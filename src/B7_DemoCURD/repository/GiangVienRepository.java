/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B7_DemoCURD.repository;

import B7_DemoCURD.model.GiangVien;
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
        //B1: Viet query
        String query = "SELECT * FROM giang_vien gv";
        // B2: Mo cong ket noi SQL
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            // B3: Statment: 1 interface cho phep gui cac cau SQL toi Database
            // B4: Khoi tao kieu tra ve cua ham
            List<GiangVien> listGiangVien = new ArrayList<>();
            // B5: ResultSet : dai dien cho tap hop cac ban ghi (record) 
            // co duoc sau khi thuc hien truy van(query)
            ResultSet rs = ps.executeQuery();
            // B6: Doc data
            while (rs.next()) {
                GiangVien gv = new GiangVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                listGiangVien.add(gv);
            }
            return listGiangVien;
        } catch (SQLException e) {
            // SQL Exception : class nay xu ly bat cu loi nao xuat hien trong khi lam viec voi database
            e.printStackTrace(System.out);
        }
        return null;
    }

    public GiangVien getOne(String maGV) {
        String query = "SELECT * FROM giang_vien gv WHERE gv.ma_gv = ? ";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, maGV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                GiangVien gv = new GiangVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                return gv;
            }

        } catch (SQLException e) {
            // SQL Exception : class nay xu ly bat cu loi nao xuat hien trong khi lam viec voi database
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<GiangVien> lists = new GiangVienRepository().getAll();
        for (GiangVien gv : lists) {
            System.out.println(gv.toString());
        }
    }
}
