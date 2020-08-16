package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "KhuyenMai")
public class KhuyeMaiEntity implements Serializable {
    private static final long serialVersionUID = -4801795205724965281L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long khuyenmai_id;

    @Column
    private  String tenKhuyenMai;

    @Column
    private Date ngayBatDau;

    public Long getKhuyenmai_id() {
        return khuyenmai_id;
    }

    public void setKhuyenmai_id(Long khuyenmai_id) {
        this.khuyenmai_id = khuyenmai_id;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public List<CTKMEntity> getSanphams() {
        return sanphams;
    }

    public void setSanphams(List<CTKMEntity> sanphams) {
        this.sanphams = sanphams;
    }

    @Column
    private  Date ngayKetThuc;
    @OneToMany(mappedBy = "sanPham")
    private List<CTKMEntity> sanphams =new ArrayList<>();

}
