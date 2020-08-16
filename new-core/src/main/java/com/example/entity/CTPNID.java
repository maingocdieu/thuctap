package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CTPNID implements Serializable {

    @Column(name = "sanpham_id")
    private Integer sanPham_Id;

    public Integer getSanPham_Id() {
        return sanPham_Id;
    }

    public void setSanPham_Id(Integer sanPham_Id) {
        this.sanPham_Id = sanPham_Id;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    @Column(name = "MAPN")
    private String maPN;
}
