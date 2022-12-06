package bridge.domain.dto;

public class AttemptCount {
    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return this.count;
    }
}
