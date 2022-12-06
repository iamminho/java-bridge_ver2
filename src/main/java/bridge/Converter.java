package bridge;

import bridge.domain.dto.BridgeMap;
import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private final static int DOWN_NUMBER = 0;
    private final static String DOWN_DIRECTION = "D";
    private final static String UP_DIRECTION = "U";
    private final static String RIGHT = "O";
    private final static String WRONG = "X";
    private final static String NOTHING = " ";
    private final static String SEPARATE = " | ";
    private final static String OPEN_BRACKET = "[ ";
    private final static String CLOSE_BRACKET = " ]";

    public static String toDirection(BridgeNumberGenerator bridgeNumberGenerator) {
        if (bridgeNumberGenerator.generate() == DOWN_NUMBER) {
            return DOWN_DIRECTION;
        }
        return UP_DIRECTION;
    }

    public static List<String> convertMap(BridgeMap bridgeMap) {
        List<String> converted = new ArrayList<>();
        List<String> directions = new ArrayList<>(List.of(UP_DIRECTION, DOWN_DIRECTION));
        directions.stream()
                .forEach(direction -> converted.add(toViewBridgeFormat(bridgeMap.getMap(), direction)));
        return converted;
    }

    private static String toViewBridgeFormat(List<MovingResult> movingResult, String direction) {
        List<String> converted = new ArrayList<>();
        movingResult.stream()
                .forEach(result -> inputResult(converted, result, direction));
        return separateMap(converted);
    }

    private static void inputResult(List<String> converted, MovingResult movingResult, String direction) {
        String movingDirection = movingResult.getDirection();
        boolean result = movingResult.getResult();
        if (direction.equals(movingDirection)) {
            inputRightOrWrong(converted, result);
            return;
        }
        converted.add(NOTHING);
    }

    private static void inputRightOrWrong(List<String> converted, boolean result) {
        if (result) {
            converted.add(RIGHT);
            return;
        }
        converted.add(WRONG);
    }

    private static String separateMap(List<String> converted) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_BRACKET);
        stringBuilder.append(String.join(SEPARATE, converted));
        stringBuilder.append(CLOSE_BRACKET);
        return stringBuilder.toString();
    }
}
