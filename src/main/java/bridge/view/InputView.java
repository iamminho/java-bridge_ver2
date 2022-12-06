package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.\n";
    private final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_GAME_COMMAD = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String INVALID_INPUT_BRIDGE = "[ERROR] 3과 20사이의 숫자만 입력해주세요";

    public int readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(INVALID_INPUT_BRIDGE);
        }
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAD);
        return Console.readLine();
    }
}
