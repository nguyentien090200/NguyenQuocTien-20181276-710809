package entity.cart;

import entity.media.Media;

public class CartMedia {
    
    private Media media;
    private int quantity;
    private int price;
    private boolean rushOrder;

    public CartMedia(){

    }

    public CartMedia(Media media, Cart cart, int quantity, int price, boolean rushOrder) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
        this.rushOrder = rushOrder;
    }
    
    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public boolean getRushOrder() {
        return this.rushOrder;
    }

    public void setRushOrder(boolean rushOrder) {
        this.rushOrder = rushOrder;
    }

    @Override
    public String toString() {
        return "{" 
            + " media='" + media + "'" 
            + ", quantity='" + quantity + "'" 
            + ", rushOrder='" + rushOrder + "'"
            + "}";
    }

}

    
