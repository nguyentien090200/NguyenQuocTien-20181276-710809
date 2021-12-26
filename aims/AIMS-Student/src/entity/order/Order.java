package entity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Configs;

public class Order {
    
    private int shippingFees;
    private int rushOrderFees;
    private int weightOrder;
    private List lstOrderMedia;
    private HashMap<String, String> deliveryInfo;

    public Order(){
        this.lstOrderMedia = new ArrayList<>();
    }

    public Order(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void addOrderMedia(OrderMedia om){
        this.lstOrderMedia.add(om);
    }

    public void removeOrderMedia(OrderMedia om){
        this.lstOrderMedia.remove(om);
    }

    public List getlstOrderMedia() {
        return this.lstOrderMedia;
    }

    public void setlstOrderMedia(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    public int getShippingFees() {
        return shippingFees;
    }
    
    public void setRushOrderFees(int rushOrderFees) {
        this.rushOrderFees = rushOrderFees;
    }

    public int getRushOrderFees() {
        return rushOrderFees;
    }

    public HashMap getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(HashMap deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
    
    // Getter Setter trong luong thuc te
    public int getWeightOrder() {
        return weightOrder;
    }
    
    public void setWeightOrder(int weightOrder) {
        this.weightOrder = weightOrder;
    }

    public int getAmount(){
        double amount = 0;
        for (Object object : lstOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice() * om.getQuantity(); // Fix: Tien = Gia * So luong san pham
        }
        return (int) (amount + (Configs.PERCENT_VAT/100)*amount);
    }

}
