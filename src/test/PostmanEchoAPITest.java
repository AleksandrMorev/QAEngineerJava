import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanEchoAPITest {

    @Test(
            description = "Тест метода GET")
    public void testGET() {
        given().baseUri("https://postman-echo.com")
                .when()
                .get("/get")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(
            description = "Тест POST Raw Text")
    public void testPOSTRawText() {
        given().baseUri("https://postman-echo.com").log().body().contentType("text/plain").body("test: value")
                .when().post("/post")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and().body("data", equalTo("test: value"));
    }

    @Test(
            description = "Тест POST Form Data")
    public void testPOSTFormData() {
        Data example = new Data("bar1", "bar2");
        given().baseUri("https://postman-echo.com").log().body().contentType("application/json").body(example)
                .when().post("/post")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and().body("json.foo1", equalTo("bar1")).and().body("json.foo2", equalTo("bar2"));
    }

    @Test(
            description = "Тест PUT")
    public void testPUT() {
        given().baseUri("https://postman-echo.com").log().body().contentType("text/plain").body("This is expected to be sent back as part of response")
                .when().put("/put")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and().body("data", equalTo("This is expected to be sent back as part of response"));
    }

    @Test(
            description = "Тест PATCH")
    public void testPATCH() {
        given().baseUri("https://postman-echo.com").log().body().contentType("text/plain").body("Test data PATCH")
                .when().patch("/patch")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and().body("data", equalTo("Test data PATCH"));
    }

    @Test(
            description = "Тест DELETE")
    public void testDELETE() {
        given().baseUri("https://postman-echo.com").log().body().contentType("text/plain").body("Test data DELETE")
                .when().delete("/delete")
                .then().log().body()
                .assertThat().statusCode(HttpStatus.SC_OK).and().body("data", equalTo("Test data DELETE"));
    }
}

