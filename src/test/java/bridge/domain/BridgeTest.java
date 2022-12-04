package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.Moving;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge 클래스")
class BridgeTest {

    @Nested
    @DisplayName("isCorrect 메소드는")
    class Describe_isCorrect {

        @Nested
        @DisplayName("이동할 방향을 선택하면")
        class Context_select_moving_direction {
            private final List<String> BRIDGE = new ArrayList<>(List.of("U", "D", "U", "D"));
            private final List<String> MOVING = new ArrayList<>(List.of("U", "U", "D", "D"));
            private final List EXPECTED = List.of(true, false, false, true);
            private final int START_LOCATION = -1;

            @Test
            @DisplayName("이동방향의 결과를 반환한다.")
            void it_returns_moving_result() {
                BridgeLocation bridgeLocation = new BridgeLocation(START_LOCATION);
                Bridge bridge = new Bridge(BRIDGE, bridgeLocation);

                IntStream.range(0, MOVING.size())
                        .forEach(idx -> {
                            boolean movingResult = bridge.isCorrect(new Moving(MOVING.get(idx)));
                            assertThat(movingResult).isEqualTo(EXPECTED.get(idx));
                        });
            }
        }
    }
}
