package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CTKMID implements Serializable {

    @Column(name = "sanpham_id")
    private Integer sanPham_Id;

    public Integer getSanPham_Id() {
        return sanPham_Id;
    }

    public void setSanPham_Id(Integer sanPham_Id) {
        this.sanPham_Id = sanPham_Id;
    }

    public Long getKhuyenmai_id() {
        return khuyenmai_id;
    }

    public void setKhuyenmai_id(Long khuyenmai_id) {
        this.khuyenmai_id = khuyenmai_id;
    }

    @Column(name = "khuyenmai_id")
    private Long khuyenmai_id;
}

