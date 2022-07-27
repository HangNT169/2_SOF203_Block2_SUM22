/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.Lop;
import repository.LopRepository;
import service.LopService;

/**
 *
 * @author hangnt
 */
public class LopServiceImpl implements LopService {

    private LopRepository lopRepository = new LopRepository();

    @Override
    public List<Lop> getAll() {
        return lopRepository.getAll();
    }

    @Override
    public Lop getOne(String maLop) {
        return lopRepository.getOne(maLop);
    }

}
