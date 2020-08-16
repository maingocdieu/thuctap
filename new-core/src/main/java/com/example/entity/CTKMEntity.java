package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "CTKhuyenMai")

public class CTKMEntity {

    @EmbeddedId
    private CTKMID  ctkmid;

    @ManyToOne
    @MapsId("sanPham_Id")
    private SanPhamEntity sanPham;

    @ManyToOne
    @MapsId("khuyenmai_id")
    private KhuyeMaiEntity khuyemai;

    public CTKMID getCtkmid() {
        return ctkmid;
    }

    public void setCtkmid(CTKMID ctkmid) {
        this.ctkmid = ctkmid;
    }

    public SanPhamEntity getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPhamEntity sanPham) {
        this.sanPham = sanPham;
    }

    public KhuyeMaiEntity getKhuyemai() {
        return khuyemai;
    }

    public void setKhuyemai(KhuyeMaiEntity khuyemai) {
        this.khuyemai = khuyemai;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    @Column
    private int phanTram;
}
