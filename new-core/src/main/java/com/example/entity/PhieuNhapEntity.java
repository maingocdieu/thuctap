package com.example.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PhieuNhap")
public class PhieuNhapEntity  {

    private static final long serialVersionUID = 3050640464816933435L;

    @Id
    @Column(name = "MAPN",unique=true,columnDefinition="VARCHAR(4)")
    private String MAPN;

    public String getMAPN() {
        return MAPN;
    }

    public void setMAPN(String MAPN) {
        this.MAPN = MAPN;
    }

    @Column
    private Date ngay;

    @OneToMany(mappedBy = "sanPham")
    private List<CTPNEntity> sanphams;

    public UserEntity getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(UserEntity nhanVien) {
        NhanVien = nhanVien;
    }

    @ManyToOne
    private  UserEntity NhanVien;

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public List<CTPNEntity> getSanphams() {
        return sanphams;
    }

    public void setSanphams(List<CTPNEntity> sanphams) {
        this.sanphams = sanphams;
    }
}
