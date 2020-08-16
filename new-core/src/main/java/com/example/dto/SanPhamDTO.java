package com.example.dto;

import com.example.entity.CTDDHEntity;
import com.example.entity.CTPNEntity;
import com.example.entity.LoaiSanPhamEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamDTO extends AbstractDTO<SanPhamDTO> {

    private static final long serialVersionUID = -4755660539311568972L;
    private String tenSanPham;
    private String moTa;
    private float giaSanPham;
    private boolean sanPhamNoiBat;
    private String thumbnail;
    private String categoryCode;
    private String base64;
    private String fileName;
    private Map<String, String> categories = new HashMap<>();

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }
}
