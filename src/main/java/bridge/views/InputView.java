package bridge.views;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 *
 * - `InputView`의 패키지는 변경할 수 있다.
 * - `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * - 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return Validator.validateBridgeSize(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        Validator.isUOrD(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        Validator.isROrQ(input);
        return input;
    }
}
