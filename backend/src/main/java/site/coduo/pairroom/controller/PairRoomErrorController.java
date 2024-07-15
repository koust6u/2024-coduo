package site.coduo.pairroom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import site.coduo.common.controller.error.CommonApiError;
import site.coduo.common.controller.response.ApiErrorResponse;
import site.coduo.pairroom.controller.error.PairRoomApiError;
import site.coduo.pairroom.exception.PairRoomNotFoundException;

@RestControllerAdvice
public class PairRoomErrorController {

    @ExceptionHandler(PairRoomNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlePairRoomErrorController() {
        return ResponseEntity.status(PairRoomApiError.PAIR_ROOM_NOT_FOUND.getHttpStatus())
                .body(new ApiErrorResponse(PairRoomApiError.PAIR_ROOM_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException() {
        return ResponseEntity.status(CommonApiError.SERVER_ERROR.getHttpStatus())
                .body(new ApiErrorResponse(CommonApiError.SERVER_ERROR.getMessage()));
    }
}
