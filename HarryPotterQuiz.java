
import java.util.Scanner;
import java.util.Map;
import java.util.EnumMap;
import java.util.Arrays;
//TODO
//tests
//error check user input

enum House {
    GRYFFINDOR(new String[]{"Bold", "Help it", "Find out more about it", "How courages you were", "The dark path illuminated only by a lamp post"}),
    HUFFLEPUFF(new String[]{"Kind", "Alert somebody of it", "Find out when it is best used", "The friends you had", "The sunny fields path"}),
    SLYTHERIN(new String[]{"Bossy", "Igrnore it", "Use it on something or someone", "How great you were", "The stoned road path"}),
    RAVENCLAW(new String[]{"Cunning", "Find out what's wrong with it", "Use it to help me in a way that's useful", "Your acheivments", "The confusing-interesting curvy path"});

    private static final String[] QUESTIONS = createQuestions(new String[]{"How would you describe yourself", "What would you do if you found a wounded animal", "What is the first thing you would do with a new spell", "How would you want people to remember you as", "If there was a shortcut to go to hogwarts which one would you choose"});
    private final String[] answerChoices;

    House(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }

    private static String[] createQuestions(String[] q) {
        for (House h : House.values()) {
            if (h.answerChoices.length != q.length) {
                throw new IllegalStateException("Answer choice quantity for " + h.name()
                        + " is " + h.answerChoices.length + ". Question quantity is " + q.length);
            }
        }
        return q;
    }

    public static int getQuestionsLength() {
        return QUESTIONS.length;
    }

    public static String getQuestion(int question) {
        return QUESTIONS[question];
    }

    public String getAnswerChoice(int question) {
        return this.answerChoices[question];
    }

    @Override
    public String toString() {
        return this.name();
    }
}

public class HarryPotterQuiz {

    public static void main(String[] args) {
        intro();
        quiz();
    }

    private static void intro() {
        System.out.println("Welcome to the sorting hat quiz.\n"
                + " You will be 10 givin questions to determine what house you will be put in.\n"
                + " There are four houses: " + Arrays.toString(House.values()) + "\n"
                + " Each answer will contribute points to a house with the tribute most like your answer.\n"
                + " After you are done with the quiz, you will be told the house you most belong to.\n"
                + " Here is the quiz.");
        System.out.println();
        System.out.println();
    }

    private static void quiz() {
        Map<House, Integer> playerChoiceToFrequency = new EnumMap<>(House.class);
        Scanner scan = new Scanner(System.in);
        for (int ans = 0; ans < House.getQuestionsLength(); ans++) {
            System.out.println(House.getQuestion(ans) + ":\n");

            int offset = randomIteration(ans);

            System.out.println();
            System.out.println("Choose an answer by the order they are placed in. 0-" + (House.values().length - 1));
            int playerChoice = (scan.nextInt() + offset) % House.values().length;
            scan.nextLine();
            System.out.println();

            Integer currentFreq = playerChoiceToFrequency.get(House.values()[playerChoice]);
            playerChoiceToFrequency.put(House.values()[playerChoice], (currentFreq != null ? currentFreq + 1 : 1));
        }
        System.out.println("You were sorted into the " + getHouse(playerChoiceToFrequency) + " house!");
    }

    private static int randomIteration(int ans) {
        int offset = (int) (Math.random() * House.values().length);
        for (int i = offset, count = 0; count < House.values().length; i = (i + 1) % House.values().length, count++) {
            System.out.println(House.values()[i].getAnswerChoice(ans));
        }
        return offset;
    }

    private static String getHouse(Map<House, Integer> playerChoiceToFrequency) {
        Integer highestFrequency = -1;
        House mostFrequentHouse = null;
        for (Map.Entry<House, Integer> entry : playerChoiceToFrequency.entrySet()) {
            if (highestFrequency <= entry.getValue()) {
                highestFrequency = entry.getValue();
                mostFrequentHouse = entry.getKey();
            }
        }
        return mostFrequentHouse.name();
    }

}
