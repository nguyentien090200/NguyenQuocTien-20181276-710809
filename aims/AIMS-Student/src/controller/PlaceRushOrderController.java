package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;
import utils.Configs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceRushOrderController extends PlaceOrderController {
	
	/**
     * This method show the processing in console
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());

	 /**
     * This method checks the avaibility of product when user click PlaceOrder button
     * And check the product supported rush order
     * @throws SQLException
     */
	public void placeRushOrder() throws SQLException{
        super.placeOrder();
    }
	
	/**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    public Order createOrder() throws SQLException{
    	return super.createOrder();
    }
    
    
    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */
    public Invoice createInvoice(Order order) {
    	return super.createInvoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    public void processDeliveryInfoForRushOrderItem(HashMap info) throws InterruptedException, IOException{
    	super.processDeliveryInfo(info);
		validateRushOrderDeliveryInfo(info);
    }
    
    /**
     * The method validates the info
     * @param info this info include delivery information ex: address, phone, name, card ,...
     * @throws InterruptedException
     * @throws IOException
     */
    public void validateRushOrderDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
    	super.validateDeliveryInfo(info);
    	if (validateProvince(info.get("province")) == false) {
			throw new IOException("error: rush order invalid");
		}
    }
    

    
	/**
     * this method check rush order for user address
     * if the province is Ha Noi => true
     * @param province : Tinh
     * @return
     */
    public boolean validateProvince(String province){
    	if (province.equalsIgnoreCase("Hà Nội"))
			return true;
		else
			return false;
    }

    
    /**
     * This method calculates the shipping fees of Rush order
     * @param order
     * @return shippingFee
     */
  
}
