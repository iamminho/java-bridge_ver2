package bridge.domain.dto;

public class BridgeSize {
    private final String INVALID_BOUNDARY = "[ERROR] 3에서 20 사이의 숫자만 입력가능합니다.";
    private final int MIN_NUMBER = 3;
    private final int MAX_NUMBER = 20;
    private int size;

    public BridgeSize(int size) {
        validateBoundary(size);
        this.size = size;
    }

    private void validateBoundary(int size) {
        if (size < MIN_NUMBER || size > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BOUNDARY);
        }
    }

    public int getSize() {
        return size;
    }
}
