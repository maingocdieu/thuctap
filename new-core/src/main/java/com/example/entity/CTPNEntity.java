package com.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "CTPN")

public class CTPNEntity {

    @EmbeddedId
    private CTPNID  ctpnid;

    @ManyToOne
    @MapsId("sanPham_Id")
    private SanPhamEntity sanPham;

    @ManyToOne
    @MapsId("maPN")
    private PhieuNhapEntity phieuNhap;

    @Column
    private int soLuong;

    public CTPNID getCtpnid() {
        return ctpnid;
    }

    public void setCtpnid(CTPNID ctpnid) {
        this.ctpnid = ctpnid;
    }

    public SanPhamEntity getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamEntity sanPham) {
        this.sanPham = sanPham;
    }

    public PhieuNhapEntity getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhapEntity phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
