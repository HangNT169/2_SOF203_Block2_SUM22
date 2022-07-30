/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B11_BaiMauCURD_QuanHe.repository;

import B11_BaiMauCURD_QuanHe.model.Lop;
import B11_BaiMauCURD_QuanHe.model.SinhVien;
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
public class SinhVienRepository {

    public List<SinhVien> getAll() {
        String query = "SELECT ma_sv ,l.ten_lop ,sv.ten ,sv.cmnd ,sv.dien_thoai ,sv.email , l.ma_lop"
                + "FROM sinh_vien sv ,lop l "
                + "WHERE sv.ma_lop  = l.ma_lop ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SinhVien> listSinhVien = new ArrayList<>();
            while (rs.next()) {
                Lop lop = new Lop(rs.getString(7), rs.getString(2));
                SinhVien sv = new SinhVien(rs.getString(1), lop, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listSinhVien.add(sv);
            }
            return listSinhVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        new SinhVienRepository().getAll().forEach(s -> System.out.println(s.toString()));
    }
}
