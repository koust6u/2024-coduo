package site.coduo.pairroom.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import site.coduo.pairroom.exception.PairRoomNotFoundException;

@Transactional
@SpringBootTest
class PairRoomServiceTest {

    @Autowired
    private PairRoomService pairRoomService;

    @Test
    @DisplayName("존재하지 않는 페어룸 접근 코드를 찾으면 예외가 발생한다.")
    void throw_exception_when_find_not_exist_access_code() {
        // given
        final String notSavedAccessCode = "123456";

        // when & then
        assertThatThrownBy(() -> pairRoomService.findByAccessCode(notSavedAccessCode))
                .isExactlyInstanceOf(PairRoomNotFoundException.class);
    }
}
