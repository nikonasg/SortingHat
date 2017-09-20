import java.util.*;
//TODO randomization
//enums?
//tests
//error check user input
/*

       enum
     /      \
    /        \
String       int

House.GRYFFINDOR -> enum
House.GRYFFINDOR.name() -> String "GRYFFINDOR"
House.GRYFFINDOR.ordinal() -> int 0

House.values() -> enum array [House.GRYFFINDOR, House.blahblah ....]

int into enum
House.values()[0] -> House.GRYFFINDOR

String into enum
House e = House.valueOf("GRYFFINDOR"); -> House.GRYFFINDOR

int into String
House.values()[0].name()
           step 1|step 2

String into an int
House.valueOf("GRYFFINDOR").ordinal()
                     step 1|step 2
*/

enum House {
    GRYFFINDOR(new String[]{"Bold", "Help it", "Find out more about it", "How courages you were", "The dark path illuminated only by a lamp post"}),
    HUFFLEPUFF(new String[]{"Kind", "Alert somebody of it", "Find out when it is best used", "The friends you had", "The sunny fields path"}),
    SLYTHERIN(new String[]{"Bossy", "Igrnore it", "Use it on something or someone", "How great you were", "The stoned road path"}),
    RAVENCLAW(new String[]{"Cunning", "Find out what's wrong with it", "Use it to help me in a way that's useful", "Your acheivments", "The confusing-interesting curvy path" });
    
    private final String[] answerChoices;
    
    House(String[] answerChoices) {
        this.answerChoices = answerChoices;
    }
    
    public String getAnswerChoice(int question) {
        return this.answerChoices[question];
    }
    
    public String[] getAnswerChoices() {
        return this.answerChoices;
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
        Map<Integer, Integer> playerChoiceToFrequency = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String[] questions = {"How would you describe yourself", "What would you do if you found a wounded animal", "What is the first thing you would do with a new spell", "How would you want people to remember you as", "If there was a shortcut to go to hogwarts which one would you choose"};
        for (int ans = 0; ans < questions.length; ans++) {
            System.out.println(questions[ans] + ":\n");
            
            int offset = randomIteration(ans);

            System.out.println();
            System.out.println("Choose an answer by the order they are placed in. 0-" + (House.values().length - 1));
            int playerChoice = (scan.nextInt() + offset) % House.values().length;
            scan.nextLine();
            System.out.println();

            Integer currentFreq = playerChoiceToFrequency.get(playerChoice);
            playerChoiceToFrequency.put(playerChoice, (currentFreq != null ? currentFreq + 1: 1));
        }
        System.out.println("You were sorted into the " + getHouse(playerChoiceToFrequency) + " house!");
    }
    
    private static int randomIteration(int ans) {
        int offset = (int)(Math.random() * House.values().length);
        for (int i = offset, count = 0; count < House.values().length; i = (i + 1) % House.values().length, count++) {
            System.out.println(House.values()[i].getAnswerChoice(ans));
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
        return House.values()[mostFrequentPlayerChoice].name();
    }

}
