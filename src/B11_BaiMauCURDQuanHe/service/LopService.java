/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Lop;

/**
 *
 * @author hangnt
 */
public interface LopService {

    List<Lop> getAll();
    
    Lop getOne(String maLop);

}
