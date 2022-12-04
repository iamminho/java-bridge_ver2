package bridge.domain;

import bridge.domain.dto.Moving;
import java.util.List;

public class Bridge {
    private List<String> bridge;
    private BridgeLocation bridgeLocation;

    public Bridge(List<String> bridge, BridgeLocation bridgeLocation) {
        this.bridge = bridge;
        this.bridgeLocation = bridgeLocation;
    }

    public boolean isCorrect(Moving moving) {
        String userMoving = moving.getMoving();
        return userMoving.equals(getDirection(bridge));
    }

    private String getDirection(List<String> bridge) {
        bridgeLocation.moveLocation();
        return bridgeLocation.getCurrentDirection(bridge);
    }
}
