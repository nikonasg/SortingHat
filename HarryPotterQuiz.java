import java.util.*;
//TODO randomization
//enums?
//tests
//error check user input

class House {
    private final String[] answerChoices;
    private final String name;
    private final int id;
    
    House(String[] answerChoices, String name, int id) {
        this.answerChoices = answerChoices;
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getAnswerChoice(int question) {
        return this.answerChoices[question];
    }
    
    public String[] getAnswerChoices() {
        return this.answerChoices;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

public class HarryPotterQuiz {

    static final House[] HOUSES = {
        new House(new String[]{"Bold", "Help it", "Find out more about it", "How courages you were", "The dark path illuminated only by a lamp post"}, "Gryffindor", 0), 
        new House(new String[]{"Kind", "Alert somebody of it", "Find out when it is best used", "The friends you had", "The sunny fields path"}, "Hufflepuff", 1), 
        new House(new String[]{"Bossy", "Igrnore it", "Use it on something or someone", "How great you were", "The stoned road path"}, "Slytherin", 2),
        new House(new String[]{"Cunning", "Find out what's wrong with it", "Use it to help me in a way that's useful", "Your acheivments", "The confusing-interesting curvy path" }, "Ravenclaw", 3)
    };

    public static void main(String[] args) {
        intro();
        quiz();
    }

    private static void intro() {
        System.out.println("Welcome to the sorting hat quiz.\n"
                + " You will be 10 givin questions to determine what house you will be put in.\n"
                + " There are four houses: " + Arrays.toString(HOUSES) + "\n"
                + " Each answer will contribute points to a house with the tribute most like your answer.\n"
                + " After you are done with the quiz, you will be told the house you most belong to.\n"
                + " Here is the quiz.");
        System.out.println();
        System.out.println();
    }

    private static void quiz() { 
        Map<Integer, Integer> playerChoiceToFrequency = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String[] questions = {"How would you describe yourself", "What would you do if you found a wounded animal", "What is the first thing you would do with a new spell", "How would you want people to remember you as", "If there was a shortcut to go to hogwarts which one would you choose"};
        for (int ans = 0; ans < questions.length; ans++) {
            System.out.println(questions[ans] + ":\n");
            
            int offset = randomIteration(ans);

            System.out.println();
            System.out.println("Choose an answer by the order they are placed in. 0-" + (HOUSES.length - 1));
            int playerChoice = (scan.nextInt() + offset) % HOUSES.length;
            scan.nextLine();
            System.out.println();

            Integer currentFreq = playerChoiceToFrequency.get(playerChoice);
            playerChoiceToFrequency.put(playerChoice, (currentFreq != null ? currentFreq + 1: 1));
        }
        System.out.println("You were sorted into the " + getHouse(playerChoiceToFrequency) + " house!");
    }
    
    private static int randomIteration(int ans) {
        int offset = (int)(Math.random() * HOUSES.length);
        for (int i = offset, count = 0; count < HOUSES.length; i = (i + 1) % HOUSES.length, count++) {
            System.out.println(HOUSES[i].getAnswerChoice(ans));
        }
        return offset;
    }

    private static String getHouse(Map<Integer, Integer> playerChoiceToFrequency) {
        Integer highestFrequency = -1;
        Integer mostFrequentPlayerChoice = -1;
        for (Map.Entry<Integer, Integer> entry : playerChoiceToFrequency.entrySet()) {
            if (highestFrequency <= entry.getValue()) {
                highestFrequency = entry.getValue();
                mostFrequentPlayerChoice = entry.getKey();
            }
        }
        return HOUSES[mostFrequentPlayerChoice].getName();
    }

}
