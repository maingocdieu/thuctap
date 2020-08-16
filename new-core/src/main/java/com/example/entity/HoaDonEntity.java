package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HoaDon")
public class HoaDonEntity implements Serializable {

    private static final long serialVersionUID = 3050640464816933435L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long soHD;

    @Column
    private String maSoThue;

    @Column
    private Date ngay;

//    @OneToOne
//    @JoinColumn(name = "donhang_id",referencedColumnName = "masoDDH")
//    private DonDatHangEntity donDatHang;

    public Long getSoHD() {
        return soHD;
    }

    public void setSoHD(Long soHD) {
        this.soHD = soHD;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

//    public DonDatHangEntity getDonDatHang() {
//        return donDatHang;
//    }
//
//    public void setDonDatHang(DonDatHangEntity donDatHang) {
//        this.donDatHang = donDatHang;
//    }
}
