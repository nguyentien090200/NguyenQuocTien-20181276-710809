package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateNameTest {
	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
	"NguyenQuocTien,true",
	"@tien,false",
	"abc123,false"
	})
	void test(String name,boolean valid) {
		boolean isValid = placeOrderController.validateName(name);
		assertEquals(isValid,valid);
	}

}
