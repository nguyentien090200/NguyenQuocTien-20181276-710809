package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateAddressRushTest {

	private PlaceRushOrderController placeRushOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}

	@ParameterizedTest
	@CsvSource({
	"pho hue,true",
	"so 15 Hai ba trung,true",
	"Hanoi,true",
	"tien@12,false",
	",false",
	"null,false"
	})
	
	void test(String address,boolean valid) {
		boolean isValid = placeRushOrderController.validateAddress(address);
		assertEquals(isValid,valid);
	}
}
