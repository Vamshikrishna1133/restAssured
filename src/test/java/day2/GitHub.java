package day2;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GitHub {
	@BeforeTest
	public void beforeTest()
	{
		baseURI="https://api.github.com/user/repos";
		authentication= oauth2("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");
		
	}
  @Test(enabled=true)
  public void gettingAllRepositories() {
	  given()
	  .when()
	  .get()
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  
  @Test(enabled=true)
  public void createRepositories() {
	 JSONObject data =new JSONObject();
	 data.put("name", "RestAssuredCreations5");
	 data.put("description","I am Created By RestAssured Tool");
	 data.put("homepage","https://github.com/Vamshikrishna1133");
	
	  given()
	  		.header("Content-Type","application/json")
	  		.body(data.toJSONString())
	  .when()
	  		.post()
	  .then()
	  		.log()
	  		.body()
	  		.statusCode(201)
	  		.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS);
  }	
}
