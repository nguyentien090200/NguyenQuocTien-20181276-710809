package entity.order;

import entity.media.Media;

public class OrderMedia {
    
    private Media media;
    private int price;
    private int quantity;
    private boolean checkRush = true;

    public OrderMedia(Media media, int quantity, int price, boolean checkRush) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
        this.checkRush = checkRush;
    }
    
    @Override
    public String toString() {
        return "{" +
            "  media='" + media + "'" +
            ", quantity='" + quantity + "'" +
            ", price='" + price + "'" +
            ", checkRush='" + checkRush + "'" +
            "}";
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
    
    public boolean getCheckRush() {
        return this.checkRush;
    }

    public void setCheckRush(boolean checkRush) {
        this.checkRush = checkRush;
    }

}
