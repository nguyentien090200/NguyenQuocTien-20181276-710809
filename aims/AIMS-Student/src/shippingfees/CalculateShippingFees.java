package shippingfees;

import java.util.Random;
import java.util.logging.Logger;

import controller.PlaceOrderController;
import entity.order.Order;

public class CalculateShippingFees implements ShippingFeeCalculator {
	
	private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());
	@Override
	public int calculateShippingFees(Order order) {
		// Hang Hoa gia tri cao duoc Free Ship
    	if(order.getAmount() > 1000000)
        	return 0;
    	
    	
        Random rand = new Random();
        int fees = (int)( ( (rand.nextFloat()*10) ) * order.getAmount());
        LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
	};

}
