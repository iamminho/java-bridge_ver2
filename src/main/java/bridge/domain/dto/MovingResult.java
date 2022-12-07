package bridge.domain.dto;

public class MovingResult {
    private String direction;
    private boolean result;

    public MovingResult(Moving moving, boolean result) {
        this.direction = moving.getMoving();
        this.result = result;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean getResult() {
        return this.result;
    }
}
