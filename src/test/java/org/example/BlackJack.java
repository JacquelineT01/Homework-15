package org.example;

import com.google.gson.Gson;
import dto.BlackJackDto;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class BlackJack {
    public static void main(String[] args) {
Response response =
        given().
                log().
                all().
                get("https://deckofcardsapi.com/api/deck/new/").
                then().
                log().
                all().
                extract().
                response();

// Deserialization
        BlackJackDto result = new Gson().fromJson(response.asString(), BlackJackDto.class);
        String deckId = result.getDeck_id();

        String urLForCards = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=6";
        String urlShuffling =  "https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";

        //Shuffling
        given().
                log().
                all().
                get(urlShuffling).
                then().
                log().
                all();

        //Drawing cards
        Response responseCards =
        given().
                log().
                all().
                get(urLForCards).
                then().
                log().
                all().
                extract().
                response();

        // Parse the JSON response using JsonPath
        JsonPath jsonPath = JsonPath.from(response.asString());

        // Extract the ArrayList of "value"
        ArrayList<String> valuesList = jsonPath.get("cards.value");

        // Convert ArrayList to String[]
        String[] values = valuesList.toArray(new String[0]);


    }
}


