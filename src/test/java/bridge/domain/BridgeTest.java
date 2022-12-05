package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge 클래스")
class BridgeTest {

    @Nested
    @DisplayName("getMovingResult 메소드는")
    class Describe_getMovingResult {

        @Nested
        @DisplayName("이동할 방향을 선택하면")
        class Context_select_moving_direction {
            private List<String> inputBridge = new ArrayList<>(List.of("U", "D", "U", "D"));
            private List<String> moving = new ArrayList<>(List.of("U", "U", "D", "D"));
            private List expected = List.of(
                    new MovingResult("U", true),
                    new MovingResult("U", false),
                    new MovingResult("D", false),
                    new MovingResult("D", true)
            );
            private final int START_LOCATION = -1;

            @Test
            @DisplayName("이동방향의 결과를 반환한다.")
            void it_returns_moving_result() {
                BridgeLocation bridgeLocation = new BridgeLocation(START_LOCATION);
                Bridge bridge = new Bridge(inputBridge, bridgeLocation);

                IntStream.range(0, moving.size())
                        .forEach(idx -> {
                            MovingResult answer = bridge.getMovingResult(new Moving(moving.get(idx)));
                            assertThat(answer).usingRecursiveComparison().isEqualTo(expected.get(idx));
                        });
            }
        }
    }
}
