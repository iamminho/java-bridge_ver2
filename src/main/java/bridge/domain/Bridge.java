package bridge.domain;

import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import java.util.List;

public class Bridge {
    private final String INVALID_DIRECTION = "[ERROR] 다리의 각 칸은 U또는 D로 이루어져야 합니다.";
    private final String UP_DIRECTION = "U";
    private final String DOWN_DIRECTION = "D";
    private List<String> bridge;
    private BridgeLocation bridgeLocation;


    public Bridge(List<String> bridge, BridgeLocation bridgeLocation) {
        validateBridge(bridge);
        this.bridge = bridge;
        this.bridgeLocation = bridgeLocation;
    }

    private void validateBridge(List<String> bridge) {
        bridge.stream()
                .forEach(space -> validateDirection(space));
    }

    private void validateDirection(String direction) {
        if (!direction.equals(UP_DIRECTION) && !direction.equals(DOWN_DIRECTION)) {
            throw new IllegalArgumentException(INVALID_DIRECTION);
        }
    }

    public MovingResult getMovingResult(Moving moving) {
        return new MovingResult(moving, isCorrect(moving.getMoving()));
    }

    private boolean isCorrect(String direction) {
        return getDirection(bridge).equals(direction);
    }

    private String getDirection(List<String> bridge) {
        bridgeLocation.moveLocation();
        return bridgeLocation.getCurrentDirection(bridge);
    }

    public void resetLocation() {
        bridgeLocation.resetLocation();
    }
}
