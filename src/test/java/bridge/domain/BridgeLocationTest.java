package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BridgeLocation 클래스")
class BridgeLocationTest {

    @Nested
    @DisplayName("getCurrentDirection 메소드는")
    class Describe_getCurrentDirection {
        private List<String> bridge = new ArrayList<>(List.of("U", "D", "U", "D"));

        @ValueSource(ints = {0, 1, 2, 3})
        @ParameterizedTest
        @DisplayName("현제 위치한 다리칸의 방향을 반환한다.")
        void it_returns_current_direction(int input) {
            BridgeLocation bridgeLocation = new BridgeLocation(input);
            String expected = bridge.get(input);
            assertThat(bridgeLocation.getCurrentDirection(bridge)).isEqualTo(expected);
        }
    }
}
