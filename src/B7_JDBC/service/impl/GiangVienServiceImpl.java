/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B7_JDBC.service.impl;

import B7_JDBC.model.GiangVien;
import B7_JDBC.repository.GiangVienRepository;
import B7_JDBC.service.GiangVienService;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class GiangVienServiceImpl implements GiangVienService {

    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    public List<GiangVien> getAll() {
        return giangVienRepository.getAll();
    }

    @Override
    public GiangVien getOne(String maGV) {
        return giangVienRepository.getOne(maGV);
    }

    @Override
    public String add(GiangVien gv) {
        // Check validate
        if (gv.getMaGV().isEmpty()) {
            return "Ma giang vien trong";
        }
        if (gv.getTenGV().isEmpty()) {
            return "Ten GV trong";
        }
        boolean add = giangVienRepository.add(gv);
        if (add) {
            return "Add thanh cong";
        } else {
            return "Add that bai";
        }
    }

    @Override
    public String update(GiangVien gv, String maGV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String maGV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
