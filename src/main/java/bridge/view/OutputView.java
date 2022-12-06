package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String FINAL_GAME_RESULT = "최종 게임 결과";
    private final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private final String TOTAL_ATTEMPT_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridgeMap) {
        bridgeMap.stream()
                .forEach(bridge -> System.out.println(bridge));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeMap, String isSuccess, int attemptCount) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeMap);
        System.out.println(GAME_SUCCESS_OR_NOT + isSuccess);
        System.out.println(TOTAL_ATTEMPT_COUNT + attemptCount);
    }
}
