package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidateNameRushTest {
	private PlaceRushOrderController placeRushOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeRushOrderController = new PlaceRushOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
	"NguyenQuocTien,true",
	"@tien,false",
	"abc123,false"
	})
	void test(String name,boolean valid) {
		boolean isValid = placeRushOrderController.validateName(name);
		assertEquals(isValid,valid);
	}
}
