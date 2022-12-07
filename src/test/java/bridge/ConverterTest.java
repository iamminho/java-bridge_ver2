package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.BridgeMap;
import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("converter 클래스")
class ConverterTest {

    @Nested
    @DisplayName("convertMap 메소드는")
    class Describe_convertMap {
        private List<String> inputBridge = new ArrayList<>(List.of("U", "D", "D"));
        private LinkedList inputMap = new LinkedList<>(
                List.of(
                        new MovingResult(new Moving("U"), true),
                        new MovingResult(new Moving("D"), true),
                        new MovingResult(new Moving("U"), false)
                )
        );
        private List expected = List.of(
                "[ O |   | X ]",
                "[   | O |   ]"
        );

        @Test
        @DisplayName("출력형식으로 변환한 이동결과들을 반환한다.")
        void it_returns_converted_moving_results() {
            BridgeMap bridgeMap = new BridgeMap((LinkedList<MovingResult>) inputMap, false);
            List<String> converted = Converter.convertMap(bridgeMap);

            assertThat(converted).isEqualTo(expected);
        }
    }
}
