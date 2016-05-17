package restaurant;

import java.sql.Date;

/**
 *
 * @author Alejandro D
 */
public class OrderBean {
    
    public int orderNo;
    public int mesaNo;
    public Date creado;
    public boolean activo;
    public String plat1;
    public float plat1Price;
    public String plat2;
    public float plat2Price;
    public String plat3;
    public float plat3Price;
    public String bebida;
    public float bebidaprice;

    public OrderBean(int orderNo, int mesaNo, Date creado, boolean isActivo, String plat1, float plat1Price, String plat2, float plat2Price, String plat3, float plat3Price, String bebida, float bebidaprice) {
        this.orderNo = orderNo;
        this.mesaNo = mesaNo;
        this.creado = creado;
        this.activo = activo;
        this.plat1 = plat1;
        this.plat1Price = plat1Price;
        this.plat2 = plat2;
        this.plat2Price = plat2Price;
        this.plat3 = plat3;
        this.plat3Price = plat3Price;
        this.bebida = bebida;
        this.bebidaprice = bebidaprice;
    }

    public OrderBean() {
    }

    public String getBebida() {
        return bebida;
    }

    public float getBebidaprice() {
        return bebidaprice;
    }

    public Date getCreado() {
        return creado;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getMesaNo() {
        return mesaNo;
    }

    public String getPlat1() {
        return plat1;
    }

    public float getPlat1Price() {
        return plat1Price;
    }

    public String getPlat2() {
        return plat2;
    }

    public float getPlat2Price() {
        return plat2Price;
    }

    public String getPlat3() {
        return plat3;
    }

    public float getPlat3Price() {
        return plat3Price;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public void setBebidaprice(float bebidaprice) {
        this.bebidaprice = bebidaprice;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public void setIsActivo(boolean activo) {
        this.activo = activo;
    }

    public void setMesaNo(int mesaNo) {
        this.mesaNo = mesaNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public void setPlat1(String plat1) {
        this.plat1 = plat1;
    }

    public void setPlat1Price(float plat1Price) {
        this.plat1Price = plat1Price;
    }

    public void setPlat2(String plat2) {
        this.plat2 = plat2;
    }

    public void setPlat2Price(float plat2Price) {
        this.plat2Price = plat2Price;
    }

    public void setPlat3(String plat3) {
        this.plat3 = plat3;
    }

    public void setPlat3Price(float plat3Price) {
        this.plat3Price = plat3Price;
    }
    
    
    
}
