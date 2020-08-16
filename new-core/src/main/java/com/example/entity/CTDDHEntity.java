package com.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "CTDonDatHang")

public class CTDDHEntity {

    @EmbeddedId
    private CTDDHID  ctDonDatHangId;

    @ManyToOne
    @MapsId("id")
    private SanPhamEntity sanPham;

    @ManyToOne
    @MapsId("masoDH")
    private DonDatHangEntity donDatHang;

    public CTDDHID getCtDonDatHangId() {
        return ctDonDatHangId;
    }

    public void setCtDonDatHangId(CTDDHID ctDonDatHangId) {
        this.ctDonDatHangId = ctDonDatHangId;
    }

    public SanPhamEntity getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamEntity sanPham) {
        this.sanPham = sanPham;
    }

    public DonDatHangEntity getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(DonDatHangEntity donDatHang) {
        this.donDatHang = donDatHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Column
    private int soLuong;
}
