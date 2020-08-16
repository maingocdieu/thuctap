package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DATHANG")
public class DonDatHangEntity  {

    private static final long serialVersionUID = 5362004646431296772L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long masoDDH;
    @Column
    private String shortDescription;
    @Column
    private Date Ngay;
    @Column
    private int soLuong;
    @Column
    private String diaChi;
    @Column
    private int soDT;

    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false)
    private  UserEntity khachHang;

    @OneToMany(mappedBy = "sanPham")
    private List<CTDDHEntity> sanpham=new ArrayList<>();


//    @OneToOne(mappedBy = "donDatHang", cascade = CascadeType.ALL)
//    private HoaDonEntity hoaDons;


    public Long getMasoDDH() {
        return masoDDH;
    }

    public void setMasoDDH(Long masoDDH) {
        this.masoDDH = masoDDH;
    }

//    public HoaDonEntity getHoaDons() {
//        return hoaDons;
//    }
//
//    public void setHoaDons(HoaDonEntity hoaDons) {
//        this.hoaDons = hoaDons;
//    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date ngay) {
        Ngay = ngay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public UserEntity getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(UserEntity khachHang) {
        this.khachHang = khachHang;
    }

    public List<CTDDHEntity> getSanpham() {
        return sanpham;
    }

    public void setSanpham(List<CTDDHEntity> sanpham) {
        this.sanpham = sanpham;
    }
}
