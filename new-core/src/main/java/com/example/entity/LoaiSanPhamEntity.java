package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPhamEntity {

    private static final long serialVersionUID = 3050640464816933435L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanpham_ID")
    private int LoaiSPId;

    @Column
    private String tenLoaiSP;



    public int getLoaiSPId() {
        return LoaiSPId;
    }

    public void setLoaiSPId(int loaiSPId) {
        LoaiSPId = loaiSPId;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }


}
