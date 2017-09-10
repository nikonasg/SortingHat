import java.util.*;

public class HarryPotterQuiz {
    
    static final Map<Integer, String> CHOICE_TO_HOUSE = new HashMap<>();
    
    static {
        CHOICE_TO_HOUSE.put(0, "Gryffindor");
        CHOICE_TO_HOUSE.put(1, "Hufflepuff");
        CHOICE_TO_HOUSE.put(2, "Slytherin");
        CHOICE_TO_HOUSE.put(3, "Ravenclaw");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        intro();
        quiz();
    }

    public static void intro() {
        System.out.println("Welcome to the sorting hat quiz."
                + " You will be 10 givin questions to determine what house you will be put in."
                + " There are four houses, Gryffindor, Hufflepuff, Ravenclaw, and Slytherin."
                + " Each answer will contribute points to a house with the tribute most like your answer."
                + " After you are done with the quiz, you will be told the house you most belong to."
                + " Here is the quiz.");
        System.out.println();
        System.out.println();
    }

    public static void quiz() {
        Map<Integer, Integer> playerChoiceToFrequency = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String[] answers1 = {"Bold", "Kind", "Bossy", "Cunning"};
        String[] answers2 = {"Help it", "Alert somebody of it", "Ignore it", "Find out what's wrong with it"};
        String[] answers3 = {"Find out more about it", "Find out when it is best used", "Use it on something or someone", "Use it to help me in a way it's useful"};
        String[] answers4 = {"How courages you were", "The friends you had", "How great you were", "Your acheivments"};
        String[] answers5 = {"The dark path iluminated only by light posts", "The sunny fields path", "The stoned road path", "The confusing curvy path"};
        String[][] answers = {answers1, answers2, answers3, answers4, answers5};
        String[] questions = {"How would you describe yourself", "What would you do if you found a wounded animal", "What is the first thing you would do with a new spell", "How would you want people to remember you as", "If there was a shortcut to go to hogwarts which one would you choose"};
        for (int ans = 0; ans < answers.length; ans++) {
            System.out.println(questions[ans]);

            for (String answer : answers[ans]) {
                System.out.println(answer);
            }
            System.out.println();
            System.out.println("Choose an answer by the order they are placed in.");
            int playerChoice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            Integer currentFreq = playerChoiceToFrequency.get(playerChoice);
            playerChoiceToFrequency.put(playerChoice, (currentFreq != null ? currentFreq + 1: 1));
//            Integer currentFreq = playerChoiceToFrequency.getOrDefault(playerChoice, 0);
//            playerChoiceToFrequency.put(playerChoice, currentFreq + 1);
        }
        System.out.println("You were sorted into the " + mostPoints(playerChoiceToFrequency) + " house!");
    }

    private static String mostPoints(Map<Integer, Integer> playerChoiceToFrequency) {
        Integer highestFrequency = -1;
        Integer mostFrequentPlayerChoice = -1;
        for (Map.Entry<Integer, Integer> entry : playerChoiceToFrequency.entrySet()) {
            if (highestFrequency <= entry.getValue()) {
                highestFrequency = entry.getValue();
                mostFrequentPlayerChoice = entry.getKey();
            }
        }
        return CHOICE_TO_HOUSE.get(mostFrequentPlayerChoice);
    }

}
