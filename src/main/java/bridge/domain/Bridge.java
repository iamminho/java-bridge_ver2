package bridge.domain;

import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import java.util.List;

public class Bridge {
    private List<String> bridge;
    private BridgeLocation bridgeLocation;

    public Bridge(List<String> bridge, BridgeLocation bridgeLocation) {
        this.bridge = bridge;
        this.bridgeLocation = bridgeLocation;
    }

    public MovingResult getMovingResult(Moving moving) {
        String direction = moving.getMoving();
        return new MovingResult(direction, isCorrect(direction));
    }

    private boolean isCorrect(String direction) {
        return getDirection(bridge).equals(direction);
    }

    private String getDirection(List<String> bridge) {
        bridgeLocation.moveLocation();
        return bridgeLocation.getCurrentDirection(bridge);
    }
}
