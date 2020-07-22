package AltimetricAPI.Examonlineapitest;

import static org.junit.Assert.assertEquals;  
import org.junit.After;    
import org.junit.Before;   
import org.junit.Test;

import io.restassured.http.Headers;
import junit.framework.TestCase;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Unit test for simple App.
 */

public class AppTest 
    extends TestCase
{
    static String url="https://postman-echo.com/get?foo1=bar1&foo2=bar2";
    
    public static void getResponseBody(){
        //given().when().get(url).then();

        given().queryParam("foo1","bar1")
        .queryParam("foo2","bar2")
        .when().get("https://postman-echo.com/get").then().log().body()
        .assertThat().statusCode(200);
        }

	public static void getResponseStatus(){
	
	   int statusCode= given().queryParam("foo1","bar1")
            .queryParam("foo2","bar2")
            .when().get("https://postman-echo.com/get").getStatusCode();
	   System.out.println("The response status is "+statusCode);

	   //given().when().get(url).then().assertThat().statusCode(200);
	} 


	public static void postResponseBody() {
		postBody pB = new postBody();
		pB.setFoo1("bar1");
		pB.setFoo2("bar2");
		
		given()
		.contentType("application/json")
		.body(pB)
		.when().post("https://postman-echo.com/post").then().log().body()
		.statusCode(200);
	   	}
	public static void getResponseHeaders(){
		System.out.println("The headers in the response "+ get(url).then().extract()
		           .headers());
		}
	@Test
	public void testResponse(){
		getResponseBody();
	    getResponseStatus();
		getResponseHeaders();
		postResponseBody();
		}
    
	
  
            
}
class postBody {
	String sfoo1;
	String sfoo2;
	public void setFoo1(String s)
	{
		sfoo1 = s;
	}
	public void setFoo2(String s)
	{
		sfoo2 = s;
	}
	public String getFoo1()
	{
		return sfoo1;
	}
	public String getFoo2()
	{
		return sfoo2;
	}
}