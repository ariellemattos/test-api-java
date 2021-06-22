import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import static org.hamcrest.CoreMatchers.containsString;

public class RestAssuredTest {

    String url = "https://reqres.in/api/users";

    @Test
    public void postUserTest(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Arielle");
        requestParams.put("job", "QA");

        given().
                body(requestParams.toJSONString()).
                when().
                post(url).
                then().
                statusCode(201).
                body(containsString("createdAt"));
    }

    @Test
    public void getUserTest() {
        get(url + "/2").then().body("data.id", equalTo(2));
    }
}
