/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.SinhVien;
import repository.SinhVienRepository;
import service.SinhVienService;

/**
 *
 * @author hangnt
 */
public class SinhVienServiceImpl implements SinhVienService {

    private SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    public List<SinhVien> getAll() {
        return sinhVienRepository.getAll();
    }

}
