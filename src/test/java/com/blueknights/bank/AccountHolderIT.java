package com.blueknights.bank;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.blueknights.bank.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class AccountHolderIT {

	private static final String INVALID_DATA_PROBLEM_TITLE = "Dados inválidos";

	@LocalServerPort
	private int port;

	private String jsoncorrectHolder;
	private String jsonincorrectHolder;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/holders";

		jsoncorrectHolder = ResourceUtils.getContentFromResource("/json/correct/holder-account.json");

		jsonincorrectHolder = ResourceUtils.getContentFromResource("/json/incorrect/holder-account-without-email.json");

	}

	@Test
	public void mustReturnStatus200_WhenConsultingHolders() {
		given().accept(ContentType.JSON).when().get().then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void givenHolder_whenSave_thenGetCREATED() {
		given().body(jsoncorrectHolder).contentType(ContentType.JSON).accept(ContentType.JSON).when().post().then()
				.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void givenHolderWithoutEmail_whenSave_thenGetBADREQUEST() {
		given().body(jsonincorrectHolder).contentType(ContentType.JSON).accept(ContentType.JSON).when().post().then()
				.statusCode(HttpStatus.BAD_REQUEST.value()).body("title", equalTo(INVALID_DATA_PROBLEM_TITLE));
	}

}
