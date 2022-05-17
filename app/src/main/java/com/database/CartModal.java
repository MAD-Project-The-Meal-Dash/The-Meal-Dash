package com.database;

public class CartModal {
    private String Name;
    private String Price;
    private String Quantity;
    private String Itemno;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
         Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getItemno() {
        return Itemno;
    }

    public void setItemno(String itemno) {
        Itemno = itemno;
    }

    public CartModal(String Name,String Price,String Quantity,String Itemno){
        this.Name=Name;
        this.Price=Price;
        this.Quantity=Quantity;
        this.Itemno=Itemno;
    }
}
