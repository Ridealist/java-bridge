package bridge.models;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 *
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private final List<String> bridge;
    private int bridgeIndex = -1;

    private boolean gameContinue = true;
    private int trialCount = 1;

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public int getTrialCount() {
        return trialCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        bridgeIndex++;
        if (!checkStatus(direction)) {
            gameContinue = false;
        }
    }

    public boolean checkStatus(String direction) {
        return bridge.get(bridgeIndex).equals(direction);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameContinue = true;
        trialCount++;
        bridgeIndex = -1;
    }

    public boolean gameSuccess() {
        return ((bridgeIndex == (bridge.size() - 1)) && gameContinue);
    }
}
