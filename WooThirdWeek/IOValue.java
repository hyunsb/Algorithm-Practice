package WooThirdWeek;

import java.util.ArrayList;
import java.util.List;

import static WooThirdWeek.Error.isCorrectBonusNumber;
import static WooThirdWeek.Error.isCorrectWinningNumbers;

public class IOValue {
    private static final String INPUT_LOTTO_AMOUNT = "로또금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ENTER = "\n";

    private static final String OUTPUT_LOTTO_PURCHASE_COUNT = "개를 구매했습니다.";

    private static final int TICKET_PRICE = 1000;
    private static final int MAX_VALUE_OF_LOTTO_NUMBER = 45;
    private static final int MIN_VALUE_OF_LOTTO_NUMBER = 1;
    private static final int LOTTO_COUNT = 6;

    private static int lottoAmount;
    private static int ticketNumbers;

    private static final List<Lotto> LottoList = new ArrayList<>();
    private static List<String> winningNumbers = new ArrayList<>();
    private static String bonusNumber;

    public void buyTicket(){
        initializationLottoAmount();
        initializationTicketNumbers();
        initializationLottoList();
        printLottoNumbers();
    }

    // TODO: 로또 금액 문장 출력 후 로또 금액을 입력 받는다.
    private static int inputLottoAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Error.isCorrectAmount(Console.readLine());
    }

    // TODO: LOTTO_AMOUNT 변수를 초기화 한다.
    private static void initializationLottoAmount(){
        lottoAmount = inputLottoAmount();
    }

    // TODO: TICKET_NUMBERS 변수를 초기화 한다.
    private static void initializationTicketNumbers(){
        ticketNumbers = lottoAmount / TICKET_PRICE;
    }

    // TODO: LottoList를 초기화 한다.
    private static void initializationLottoList(){
        for(int i=0; i<ticketNumbers; i++)
            createLottoTicket();
    }

    // TODO: 로또 객체 생성 후 로또 번호를 랜덤으로 생성
    private static void createLottoTicket(){
        LottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                        MIN_VALUE_OF_LOTTO_NUMBER, MAX_VALUE_OF_LOTTO_NUMBER, LOTTO_COUNT)));
    }

    // TODO: 로또 구매 개수 및 번호 출력
    public void printLottoNumbers(){
        System.out.println(ENTER + ticketNumbers + OUTPUT_LOTTO_PURCHASE_COUNT);
        for(Lotto lottoTicket : LottoList)
            System.out.println(lottoTicket.getNumbers());
    }

    public static void receiveWinningNumber(){
        initializationWinningNumbers();
        initializationBonusNumber();
    }

    // TODO: winningNumbers 리스트를 초기화 한다.
    private static void initializationWinningNumbers() {
        System.out.println(ENTER + INPUT_WINNING_NUMBERS);
        winningNumbers = isCorrectWinningNumbers(Console.readLine());
    }

    // TODO: bonusNumber 변수를 초기화 한다.
    private static void initializationBonusNumber() {
        System.out.println(ENTER + INPUT_BONUS_NUMBER);
        bonusNumber = isCorrectBonusNumber(Console.readLine());
    }

    public static List<String> getWinningNumbers() {
        return winningNumbers;
    }
    public static String getBonusNumber() {
        return bonusNumber;
    }

}
