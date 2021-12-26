package shippingfees;

import java.util.logging.Logger;

import controller.PlaceOrderController;
import entity.order.Order;
import entity.order.OrderMedia;

public class CalculateRushOrderShippingFees implements ShippingFeeCalculator {
	// Nguyen Quoc Tien
	private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

	@Override
	public int calculateShippingFees(Order order) {
    	int numOfRush = 0;
    	
    	// Dem so Mat Hang chon Rush Order
    	for (int i = 0; i < order.getlstOrderMedia().size(); i++) {
    		OrderMedia ordMedia = (OrderMedia) order.getlstOrderMedia().get(i);
    		if (ordMedia.getCheckRush()) numOfRush++; 
    		
    	}
    	LOGGER.info("Number of Item choose Rush Order:" + order.getRushOrderFees());
    	
    	// Moi Mat Hang chon Rush Order se tinh 2000 phi Rush
    	return numOfRush * 2000;
	}
	
}
