package bridge.domain.dto;

public class Moving {
    private final String INVALID_MOVING = "[ERROR] U와 D만 입력 가능합니다.";
    private final String UP_DIRECTION = "U";
    private final String DOWN_DIRECTION = "D";
    private String moving;

    public Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    private void validateMoving(String moving) {
        if (!moving.equals(UP_DIRECTION) && !moving.equals(DOWN_DIRECTION)) {
            throw new IllegalArgumentException(INVALID_MOVING);
        }
    }

    public String getMoving() {
        return this.moving;
    }
}
