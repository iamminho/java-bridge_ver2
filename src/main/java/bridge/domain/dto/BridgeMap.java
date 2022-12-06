package bridge.domain.dto;

import java.util.LinkedList;

public class BridgeMap {
    private LinkedList<MovingResult> map;
    private boolean status;

    public BridgeMap(LinkedList<MovingResult> map, boolean status) {
        this.map = map;
        this.status = status;
    }

    public void addResult(MovingResult movingResult) {
        map.add(movingResult);
        this.status = movingResult.getResult();
    }

    public LinkedList<MovingResult> getMap() {
        return this.map;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void resetMap() {
        map.clear();
        status = true;
    }
}
