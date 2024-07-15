package site.coduo.pairroom.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import site.coduo.pairroom.dto.CreatePairRoom;
import site.coduo.pairroom.dto.ResponsePairRoom;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PairRoomControllerTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void beforeEach() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("페어룸 요청 시 정보를 반환한다.")
    void show_pair_room() {
        //given
        final ResponsePairRoom pairRoomUrl = createPairRoom(new CreatePairRoom("레디", "프람"));

        //when & then
        RestAssured.given().log().all()
                .contentType("application/json")
                .when().get("/pair-room?accessCode=" + pairRoomUrl.accessCode())
                .then().log().all()
                .statusCode(200);
    }

    ResponsePairRoom createPairRoom(final CreatePairRoom pairRoom) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(pairRoom)
                .when().post("/pair-room")
                .then().log().all()
                .extract().as(ResponsePairRoom.class);
    }
}
