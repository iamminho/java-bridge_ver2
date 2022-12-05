package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.BridgeMap;
import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGame 클래스")
class BridgeGameTest {
    @Nested
    @DisplayName("move 메소드는")
    class Describe_move {

        @Nested
        @DisplayName("이동할 칸을 선택하면")
        class Context_select_moving_direction {
            private List<String> inputBridge = new ArrayList<>(List.of("U", "D", "D"));
            private List movings = List.of("U", "U", "D");
            private List expected = List.of(
                    new LinkedList<>(List.of(new MovingResult("U", true))),
                    new LinkedList<>(List.of(new MovingResult("U", true), new MovingResult("U", false))),
                    new LinkedList<>(List.of(new MovingResult("U", true), new MovingResult("U", false),
                            new MovingResult("D", true)))
            );


            @Test
            @DisplayName("이동 결과들을 반환한다.")
            void it_returns_moving_results() {
                Bridge bridge = new Bridge(inputBridge, new BridgeLocation(-1));
                BridgeMap bridgeMap = new BridgeMap(new LinkedList<>(), false);
                BridgeGame bridgeGame = new BridgeGame(bridge, bridgeMap);

                IntStream.range(0, inputBridge.size())
                        .forEach(idx -> {
                            BridgeMap answer = bridgeGame.move(new Moving((String) movings.get(idx)));
                            LinkedList<MovingResult> expectedMap = (LinkedList<MovingResult>) expected.get(idx);
                            boolean expectedStatus = expectedMap.getLast().getResult();
                            assertThat(answer).usingRecursiveComparison()
                                    .isEqualTo(new BridgeMap(expectedMap, expectedStatus));
                        });
            }
        }
    }
}
