/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hangnt
 */
public class SinhVien {

    private String maSV;
    private Lop lop;
    private String ten;
    private String cmnd;
    private String email;

    public SinhVien(String maSV, Lop lop, String ten, String cmnd, String email) {
        this.maSV = maSV;
        this.lop = lop;
        this.ten = ten;
        this.cmnd = cmnd;
        this.email = email;
    }

    public SinhVien() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", lop=" + lop + ", ten=" + ten + ", cmnd=" + cmnd + ", email=" + email + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{maSV, lop.getTenLop(), ten, cmnd, email};
    }
}
