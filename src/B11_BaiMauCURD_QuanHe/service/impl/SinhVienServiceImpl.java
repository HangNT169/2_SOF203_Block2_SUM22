/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B11_BaiMauCURD_QuanHe.service.impl;

import B11_BaiMauCURD_QuanHe.model.SinhVien;
import B11_BaiMauCURD_QuanHe.repository.SinhVienRepository;
import B11_BaiMauCURD_QuanHe.service.SinhVienService;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class SinhVienServiceImpl implements SinhVienService{

    private SinhVienRepository sinhVienRepository = new SinhVienRepository();
    @Override
    public List<SinhVien> getAll() {
        return sinhVienRepository.getAll();
    }
    
}
