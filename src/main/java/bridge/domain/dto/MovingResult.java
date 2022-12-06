package bridge.domain.dto;

public class MovingResult {
    public String direction;
    public boolean result;

    public MovingResult(String direction, boolean result) {
        this.direction = direction;
        this.result = result;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean getResult() {
        return this.result;
    }
}
