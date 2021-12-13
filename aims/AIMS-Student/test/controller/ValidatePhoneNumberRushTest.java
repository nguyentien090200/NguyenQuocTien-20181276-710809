package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatePhoneNumberRushTest {
	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
	@CsvSource({
	"0123456789,true",
	"01234,false",
	"abc123,false"
	})
	
	void test(String phoneNumber,boolean valid) {
		boolean isValid = placeRushOrderController.validatePhoneNumber(phoneNumber);
		assertEquals(isValid,valid);
	}


}
