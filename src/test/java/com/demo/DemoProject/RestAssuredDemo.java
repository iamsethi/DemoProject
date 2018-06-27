package com.demo.DemoProject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDemo {

	String consumerKey = "binkFuGAb6wb96jKzNqhXsSK6";
	String consumerSecret = "kgACwCIN5n1mmAOkviLgFwgx3vexh3HbTU9MjFP274hx3ZMR8S";
	String accessToken = "149037788-Kksp0VfC3B157PAxL7901OF1QDkuLEnM2EQANvmF";
	String tokenSecret = "dNrWU3IhO5vBKKMY7JuUkmQ2p2EPgUZ8udFea6a5yu1dY";

	private RequestSpecification request;
	private Response responseBody;
	private String tweetId;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
		request = given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret);

	}

	@Test(priority = 0)
	public void postTweet() {
		// https://api.twitter.com/1.1/statuses/update.json?status=Hi There!!
		responseBody = request.basePath(RestAssured.basePath.concat("/update.json"))
				.queryParam("status", "Tweet from Rest Assured").then().log().all().when().post().then().assertThat()
				.statusCode(200).extract().response();
		this.tweetId = responseBody.jsonPath().get("id_str");
	}

	@Test(priority = 1)
	public void getTweet() {
		// https://api.twitter.com/1.1/statuses/show.json?id=123456
		responseBody = request.basePath(RestAssured.basePath.concat("/show.json")).queryParam("id", this.tweetId).when()
				.get().then().assertThat().statusCode(200).extract().response();
		System.out.println("$$" + responseBody.asString() + "####");

	}

	@Test(priority = 2)
	public void deleteTweet() {
		// https://api.twitter.com/1.1/statuses/destroy/{id}.json
		request.basePath(RestAssured.basePath.concat("/destroy/{id}.json")).pathParam("id", tweetId).when().post()
				.then().assertThat().statusCode(200);

	}

}
