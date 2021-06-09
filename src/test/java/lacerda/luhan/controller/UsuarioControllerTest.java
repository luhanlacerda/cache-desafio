package lacerda.luhan.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {

    public static final String ENDPOINT_USERS_SAVE = "/users/save";
    public static final String ENDPOINT_USERS_CALCULATE = "/users/calculate";
    public static final String ENDPOINT_USERS_CACHE = "/users/cache";
    @LocalServerPort
    private int port;

    private Map<String, String> usuarioJson;


    @BeforeEach
    void setup() {
        RestAssured.port = this.port;
        this.usuarioJson = new HashMap<>();
        this.usuarioJson.put("nome", "teste");
        this.usuarioJson.put("email", "email@email.com");
    }

    @Test
    @Order(1)
    void getAllUsuariosNotFoundTest() {
        RestAssured.when().get("/users/all").then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @Order(6)
    void saveUsuarioSucessfullyTest() {
        RestAssured.with().body(this.usuarioJson).contentType(ContentType.JSON).when().post(ENDPOINT_USERS_SAVE)
                .then().statusCode(HttpStatus.SC_OK).and().body(Matchers.containsStringIgnoringCase("sucesso"));
    }

    @Test
    @Order(7)
    void saveUsuarioWithSameNameInDBTest() {
        RestAssured.with().body(this.usuarioJson).contentType(ContentType.JSON).when().post(ENDPOINT_USERS_SAVE)
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).and().body(Matchers.containsStringIgnoringCase("erro"));
    }

    @Test
    void saveUsuarioWithNoValidJsonTest() {
        this.usuarioJson = new HashMap<>();
        this.usuarioJson.put("", "");

        RestAssured.with().body(this.usuarioJson).contentType(ContentType.JSON).when().post(ENDPOINT_USERS_SAVE)
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).and()
                .body(Matchers.containsStringIgnoringCase("erro"));
    }

    @Test
    void saveUsuarioWithUnsupportedMediaTypeTest() {
        this.usuarioJson = new HashMap<>();
        this.usuarioJson.put("", "");

        RestAssured.with().body(this.usuarioJson).contentType(ContentType.TEXT).when().post(ENDPOINT_USERS_SAVE).then()
                .statusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE);
    }

    @Test
    @Order(3)
    void calculateOneDigitWithNoContentWithIdOneTest() {
        this.usuarioJson.put("id", "1");

        RestAssured.with().body(this.usuarioJson).contentType(ContentType.JSON).when().post(ENDPOINT_USERS_CALCULATE)
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).and()
                .body(Matchers.containsStringIgnoringCase("erro"));
    }

    @Test
    @Order(4)
    void calculateOneDigitWithNoIdTest() {
        RestAssured.with().body(this.usuarioJson).contentType(ContentType.JSON).when().post(ENDPOINT_USERS_CALCULATE)
                .then().statusCode(HttpStatus.SC_BAD_REQUEST).and()
                .body(Matchers.containsStringIgnoringCase("erro"));
    }

    @Test
    @Order(5)
    void getCacheSucessfullyTest() {
        RestAssured.when().get(ENDPOINT_USERS_CACHE).then().statusCode(HttpStatus.SC_OK).and().body(Matchers.notNullValue());
    }

    @Test
    @Order(2)
    void getEmptyCacheTest() {
        RestAssured.when().get(ENDPOINT_USERS_CACHE).then().statusCode(HttpStatus.SC_OK).and().body(Matchers.equalTo("{}"));
    }

}
