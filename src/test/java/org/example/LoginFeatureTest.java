package org.example;

import Helper.SetUpFunctions;
import com.google.gson.Gson;
import dto.LoginDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginFeatureTest {

    static SetUpFunctions setupFunctions;
    @BeforeAll
    public static void setup(){
        setupFunctions = new SetUpFunctions();
        System.out.println( "username" + setupFunctions.getUsername());
        System.out.println("password" + setupFunctions.getPassword());
    }

   @Test
    public void successfullLoginTest() {

        //creating the instance of the login dto class
       LoginDto login = new LoginDto(setupFunctions.getUsername(), setupFunctions.getPassword());
        // Serialization
       String LoginDtoAsJson = new Gson().toJson(login);

        given().
               log().
               all().
               header("Content-Type", "application/json").
               // header ("Bearer Token", "TOKEN_VALUE").
                       body(LoginDtoAsJson ).
               post("http://51.250.6.164:8080/login/student").
               then().
               log().
               all().
               assertThat().
                statusCode(HttpStatus.SC_OK);
   }

    @Test
    public void unsuccessfullLoginTest() {
        LoginDto login = new LoginDto(setupFunctions.getUsername(), "drtghddd");

        String LoginDtoAsJson = new Gson().toJson(login);

        given().
                log().
                all().
                header("Content-Type", "application/json").
                // header ("Bearer Token", "TOKEN_VALUE").
                        body(LoginDtoAsJson ).
                post("http://51.250.6.164:8080/login/student").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
