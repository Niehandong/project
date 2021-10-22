package com.cy.store.vo;

import java.io.Serializable;
import java.util.Objects;

public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer num;
    private String title;
    private String image;
    private Long price;
    private Long realPrice;

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", realPrice=" + realPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO)) return false;
        CartVO cartVO = (CartVO) o;
        return Objects.equals(getCid(), cartVO.getCid()) &&
                Objects.equals(getUid(), cartVO.getUid()) &&
                Objects.equals(getPid(), cartVO.getPid()) &&
                Objects.equals(getNum(), cartVO.getNum()) &&
                Objects.equals(getTitle(), cartVO.getTitle()) &&
                Objects.equals(getImage(), cartVO.getImage()) &&
                Objects.equals(getPrice(), cartVO.getPrice()) &&
                Objects.equals(getRealPrice(), cartVO.getRealPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCid(), getUid(), getPid(), getNum(), getTitle(), getImage(), getPrice(), getRealPrice());
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }
}
