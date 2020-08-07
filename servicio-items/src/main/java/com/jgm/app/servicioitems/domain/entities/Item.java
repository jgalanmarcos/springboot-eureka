package com.jgm.app.servicioitems.domain.entities;

public class Item {

    private Producto producto;
    private Integer cantidad;

    /*
     * Constructores
     */

    public Item() {

    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /*
     * Otros métodos
     */

    public Double getTotal() {
        return producto.getPrecio() * cantidad;
    }

    /*
     * Getters & Setters
     */

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}