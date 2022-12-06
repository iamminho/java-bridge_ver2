package bridge.domain.dto;

public class GameCommand {
    private final String RETRY_COMMAND = "R";
    private final String QUIT_COMMAND = "Q";
    private final String INVALID_COMMAND = "[ERROR] R와 Q만 입력가능합니다.";
    private String command;

    public GameCommand(String command) {
        validateCommand(command);
        this.command = command;
    }

    private void validateCommand(String command) {
        if (!command.equals(RETRY_COMMAND) && !command.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
    }

    public String getCommand() {
        return this.command;
    }
}
