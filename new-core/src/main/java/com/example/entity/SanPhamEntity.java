package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "SanPham")
public class SanPhamEntity extends BaseEntity {

    private static final long serialVersionUID = 3050640464816933435L;


    @Column
    private String tenSanPham;

    @Column
    private String moTa;

    @Column
    private float giaSanPham;

    @Column
    private boolean sanPhamNoiBat;

    @Column
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "phieuNhap")
    private List<CTPNEntity> phieuNhap;

    @OneToMany(mappedBy = "donDatHang")
    private List<CTDDHEntity> donDatHang;

    public List<CTPNEntity> getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(List<CTPNEntity> phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public List<CTDDHEntity> getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(List<CTDDHEntity> donDatHang) {
        this.donDatHang = donDatHang;
    }

    public List<CTKMEntity> getKhuyenmais() {
        return khuyenmais;
    }

    public void setKhuyenmais(List<CTKMEntity> khuyenmais) {
        this.khuyenmais = khuyenmais;
    }


    @OneToMany(mappedBy = "khuyemai")
    private List<CTKMEntity> khuyenmais;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(float giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public boolean isSanPhamNoiBat() {
        return sanPhamNoiBat;
    }

    public void setSanPhamNoiBat(boolean sanPhamNoiBat) {
        this.sanPhamNoiBat = sanPhamNoiBat;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
