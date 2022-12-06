package bridge.controller;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class ViewController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public BridgeSize getBridgeSize() {
        while (true) {
            try {
                int size = inputView.readBridgeSize();
                return new BridgeSize(size);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Moving getMoving() {
        while (true) {
            try {
                String moving = inputView.readMoving();
                return new Moving(moving);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public GameCommand getGameCommand() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                return new GameCommand(command);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void viewBridgeMap(List<String> bridgeMap) {
        outputView.printMap(bridgeMap);
    }

    public void viewGameResult(List<String> bridgeMap, String isSuccess, int attemptCount) {
        outputView.printResult(bridgeMap, isSuccess, attemptCount);
    }
}
