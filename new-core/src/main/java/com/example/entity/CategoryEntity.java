package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    private static final long serialVersionUID = 3050640464816933435L;

    @Column
    private String name;

    @Column
    private String code;

//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//    private List<NewEntity> news = new ArrayList<>();

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<SanPhamEntity> sanPhams = new ArrayList<>();

    public List<SanPhamEntity> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPhamEntity> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
