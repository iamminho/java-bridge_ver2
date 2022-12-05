package bridge.domain;

import java.util.List;

public class BridgeLocation {
    private int location;

    public BridgeLocation(int startLocation) {
        this.location = startLocation;
    }

    public String getCurrentDirection(List<String> bridge) {
        return bridge.get(location);
    }

    public void moveLocation() {
        this.location++;
    }

    public void resetLocation() {
        this.location = 0;
    }
}
