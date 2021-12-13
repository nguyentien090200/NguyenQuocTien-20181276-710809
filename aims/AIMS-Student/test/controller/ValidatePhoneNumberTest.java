package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatePhoneNumberTest {
private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}

	@ParameterizedTest
	@CsvSource({
	"0123456789,true",
	"01234,false",
	"abc123,false"
	})
	
	void test(String phoneNumber,boolean valid) {
		boolean isValid = placeOrderController.validatePhoneNumber(phoneNumber);
		assertEquals(isValid,valid);
	}

}
