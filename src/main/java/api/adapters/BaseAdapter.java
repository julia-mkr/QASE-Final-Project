package api.adapters;

import api.constants.IConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseAdapter implements IConstants {

    Gson converter = new Gson();
    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();


    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .addHeader("Token", TOKEN)
            .build();

    private static final RequestSpecification REQ_SPEC_FOR_UPLOAD = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.MULTIPART)
            .addHeader("Token", TOKEN)
            .build();

    public Response get(String url) {
        return given()
                .spec(REQ_SPEC)
        .when()
                .get(url)
        .then()
                .log().all()
                .extract().response();
    }

    public Response post(String url, String body) {
        return given()
                .spec(REQ_SPEC)
                .body(body)
        .when()
                .post(url)
        .then()
                .log().all()
                .extract().response();
    }

    public Response postAttachment(String url, String fileName) {
        File file = new File(String.format("src/test/resources/%s", fileName));
        return given()
                .spec(REQ_SPEC_FOR_UPLOAD)
                .multiPart("media_url", file)
        .when()
                .post(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    public Response patch(String url, String body) {
        return given()
                .spec(REQ_SPEC)
                .body(body)
        .when()
                .patch(url)
        .then()
                .log().all()
                .extract().response();
    }

    public Response patch(String url) {
        return given()
                .spec(REQ_SPEC)
        .when()
                .patch(url)
        .then()
                .log().all()
                .extract().response();
    }
}
