package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Converter;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeLocation;
import bridge.domain.dto.AttemptCount;
import bridge.domain.dto.BridgeMap;
import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import java.util.LinkedList;
import java.util.List;

public class GameController {
    private final int START_LOCATION = -1;
    private final int START_COUNT = 0;
    private final String GAME_SUCCESS = "성공";
    private final String GAME_FAIL = "실패";
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private ViewController viewController = new ViewController();
    private Bridge bridge;
    private BridgeSize bridgeSize;
    private BridgeGame bridgeGame;
    private AttemptCount attemptCount = new AttemptCount(START_COUNT);

    public void start() {
        try {
            createBridge();
            play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void createBridge() {
        bridgeSize = viewController.getBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()), new BridgeLocation(START_LOCATION));
    }

    private void play() {
        attemptCount.addCount();
        bridgeGame = new BridgeGame(bridge, new BridgeMap(new LinkedList<>(), true));
        BridgeMap bridgeMap = move(START_COUNT);
        select(bridgeMap);
    }

    private BridgeMap move(int count) {
        BridgeMap bridgeMap;
        do {
            Moving moving = viewController.getMoving();
            bridgeMap = bridgeGame.move(moving);
            viewController.viewBridgeMap(Converter.convertMap(bridgeMap));
            count++;
        } while (count < bridgeSize.getSize() && bridgeMap.getStatus());
        return bridgeMap;
    }

    private void select(BridgeMap bridgeMap) {
        if (bridgeMap.getStatus()) {
            List<String> convertedMap = Converter.convertMap(bridgeMap);
            viewController.viewGameResult(convertedMap, GAME_SUCCESS, attemptCount.getCount());
            return;
        }
        retryOrQuit(bridgeMap);
    }

    private void retryOrQuit(BridgeMap bridgeMap) {
        GameCommand gameCommand = viewController.getGameCommand();
        String command = gameCommand.getCommand();
        if (bridgeGame.retry(command)) {
            play();
            return;
        }
        quit(bridgeMap);
    }

    private void quit(BridgeMap bridgeMap) {
        List<String> convertedMap = Converter.convertMap(bridgeMap);
        viewController.viewGameResult(convertedMap, GAME_FAIL, attemptCount.getCount());
    }
}
