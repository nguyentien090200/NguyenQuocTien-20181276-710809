package shippingfees;

import entity.order.Order;

public interface ShippingFeeCalculator {
	int calculateShippingFees(Order order);
}
