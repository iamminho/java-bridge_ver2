package bridge.domain.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMap 클래스")
class BridgeMapTest {

    @Nested
    @DisplayName("addResult 메소드는")
    class Describe_addResult {
        private List movingResults = List.of(
                new MovingResult(new Moving("U"), true),
                new MovingResult(new Moving("D"), true),
                new MovingResult(new Moving("U"), false)
        );
        private LinkedList<MovingResult> expected = new LinkedList<>(
                List.of(
                        new MovingResult(new Moving("U"), true),
                        new MovingResult(new Moving("D"), true),
                        new MovingResult(new Moving("U"), false)
                )
        );

        @Test
        @DisplayName("이동결과를 저장한다.")
        void it_saves_moving_result() {
            BridgeMap bridgeMap = new BridgeMap(new LinkedList<>(), true);
            movingResults.stream()
                    .forEach(result -> bridgeMap.addResult((MovingResult) result));

            assertThat(bridgeMap.getMap()).usingRecursiveComparison().isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("resetMap 메소드는")
    class Describe_resetMap {
        private LinkedList<MovingResult> map = new LinkedList<>(
                List.of(
                        new MovingResult(new Moving("U"), true),
                        new MovingResult(new Moving("D"), true),
                        new MovingResult(new Moving("U"), false)
                )
        );

        private BridgeMap expected = new BridgeMap(new LinkedList<>(), true);


        @Test
        @DisplayName("저장한 이동결과들과 현제 이동결과 상태를 초기화한다.")
        void it_resets_moving_results_and_current_status() {
            BridgeMap bridgeMap = new BridgeMap(map, false);
            bridgeMap.resetMap();

            assertThat(bridgeMap).usingRecursiveComparison().isEqualTo(expected);
        }
    }
}
