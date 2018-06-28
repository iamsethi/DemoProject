package com.demo.DemoProject;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredDemo2 {

	private Response responseBody;
	private String petId;
	private String name;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "http://petstore.swagger.io";
		RestAssured.basePath = "/v2";

	}

	@Test(priority = 0)
	public void postExample() throws Exception {
		// http://petstore.swagger.io/v2/pet
		responseBody = given().basePath(RestAssured.basePath.concat("/pet")).contentType("application/json")
				.body(new File("./dog.json")).when().post().then().assertThat().statusCode(200).extract().response();
		this.petId = responseBody.jsonPath().get("id").toString();
		this.name = responseBody.jsonPath().get("name").toString();
		System.out.println(petId + "####POST EXAMPLE######" + name);

	}

	@Test(priority = 1)
	public void getExample() {
		// http://petstore.swagger.io/v2/pet/{id}
		responseBody = given().basePath(RestAssured.basePath.concat("/pet/{id}")).pathParam("id", petId).get().then()
				.assertThat().statusCode(200).extract().response();
		System.out.println("####GET EXAMPLE######" + responseBody.asString());

	}

	@Test(priority = 2)
	public void putExample() {
		// http://petstore.swagger.io/v2/pet
		responseBody = given().basePath(RestAssured.basePath.concat("/pet")).contentType("application/json")
				.body(new File("./elephant.json")).when().put().then().assertThat().statusCode(200).extract()
				.response();
		this.petId = responseBody.jsonPath().get("id").toString();
		this.name = responseBody.jsonPath().get("name").toString();
		System.out.println(petId + "####PUT EXAMPLE######" + name);
	}

	@Test(priority = 3)
	public void deleteExample() {
		// http://petstore.swagger.io/v2/pet/{id}
		given().basePath(RestAssured.basePath.concat("/pet/{id}")).pathParam("id", petId).delete().then().assertThat()
				.statusCode(200);

	}
}
