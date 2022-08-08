package com.example.monkeyshop.pojo;

public class Cart {
    public Integer cartId;
    public String cartPFilename;
    public String cartPName;
    public Integer cartPPrice;
    public Integer cartQuantity;
    public Integer cartPStock;
    public Integer cartPId;
    public Integer cartUId;
    public String cartUUserid;
    public String cartUName;
    public String cartUMobile;
    public String cartUAddress;
    public String currentTime;
    public String updateTime;
    public Integer cartValid;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartPFilename='" + cartPFilename + '\'' +
                ", cartPName='" + cartPName + '\'' +
                ", cartPPrice=" + cartPPrice +
                ", cartQuantity=" + cartQuantity +
                ", cartPStock=" + cartPStock +
                ", cartPId=" + cartPId +
                ", cartUId=" + cartUId +
                ", cartUUserid='" + cartUUserid + '\'' +
                ", cartUName='" + cartUName + '\'' +
                ", cartUMobile='" + cartUMobile + '\'' +
                ", cartUAddress='" + cartUAddress + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", cartValid=" + cartValid +
                '}';
    }

    public String getCartUUserid() {
        return cartUUserid;
    }

    public void setCartUUserid(String cartUUserid) {
        this.cartUUserid = cartUUserid;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getCartPFilename() {
        return cartPFilename;
    }

    public void setCartPFilename(String cartPFilename) {
        this.cartPFilename = cartPFilename;
    }

    public String getCartPName() {
        return cartPName;
    }

    public void setCartPName(String cartPName) {
        this.cartPName = cartPName;
    }

    public Integer getCartPPrice() {
        return cartPPrice;
    }

    public void setCartPPrice(Integer cartPPrice) {
        this.cartPPrice = cartPPrice;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Integer getCartPStock() {
        return cartPStock;
    }

    public void setCartPStock(Integer cartPStock) {
        this.cartPStock = cartPStock;
    }

    public Integer getCartPId() {
        return cartPId;
    }

    public void setCartPId(Integer cartPId) {
        this.cartPId = cartPId;
    }

    public Integer getCartUId() {
        return cartUId;
    }

    public void setCartUId(Integer cartUId) {
        this.cartUId = cartUId;
    }

    public String getCartUName() {
        return cartUName;
    }

    public void setCartUName(String cartUName) {
        this.cartUName = cartUName;
    }

    public String getCartUMobile() {
        return cartUMobile;
    }

    public void setCartUMobile(String cartUMobile) {
        this.cartUMobile = cartUMobile;
    }

    public String getCartUAddress() {
        return cartUAddress;
    }

    public void setCartUAddress(String cartUAddress) {
        this.cartUAddress = cartUAddress;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCartValid() {
        return cartValid;
    }

    public void setCartValid(Integer cartValid) {
        this.cartValid = cartValid;
    }
}
