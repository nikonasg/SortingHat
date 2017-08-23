
import java.util.Scanner;

public class HarryPotterQuiz {

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
        int gryffindor = 0;
        int hufflepuff = 0;
        int slytherin = 0;
        int ravenclaw = 0;

        Scanner scan = new Scanner(System.in);
        String[] answers1 = {"Bold", "Kind", "Bossy", "Cunning"};
        String[] answers2 = {"Help it", "Alert somebody of it", "Ignore it", "Find out what's wrong with it"};
        String[] answers3 = {"Find out more about it", "Find out when it is best used", "Use it on something or someone", "Use it to help me in a way it's useful"};
        String[] answers4 = {"How courages you were", "The friends you had", "How great you were", "Your acheivments"};
        String[] answers5 = {"The dark path iluminated only by light posts", "The sunny fields path", "The stoned road path", "The confusing curvy path"};
        String[][] answers = {answers1, answers2, answers3, answers4, answers5};
        String[] questions = {"How would you describe yourself", "What would you do if you found a wounded animal", "What is the first thing you would do with a new spell", "If there was a shortcut to go to hogwarts which one would you choose"};
        for (int ans = 0; ans < answers.length; ans++) {
            System.out.println(questions[ans]);

            for (int choice = 0; choice < answers[ans].length; choice++) {
                System.out.println(answers[ans][choice]);
            }
            System.out.println();
            System.out.println("Choose an answer by the order they are placed in.");
            int playerChoice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (playerChoice) {
                case 0: {
                    gryffindor++;
                    break;
                }
                case 1: {
                    hufflepuff++;
                    break;
                }
                case 2: {
                    slytherin++;
                    break;
                }
                case 3: {
                    ravenclaw++;
                    break;
                }
            }

        }
        String house = "";
        System.out.println("You were sorted into the " + mostPoints(gryffindor, hufflepuff, slytherin, ravenclaw, house) + " house!");
    }

    private static String mostPoints(int gryffindor, int hufflepuff, int slytherin, int ravenclaw, String house) {
        if (gryffindor > hufflepuff && gryffindor > slytherin && gryffindor > ravenclaw) {
            house = "Gryffindor";
        } else if (hufflepuff > slytherin && hufflepuff > ravenclaw) {
            house = "Hufflepuff";
        } else if (slytherin > ravenclaw) {
            house = "Slytherin";
        } else {
            house = "Ravenclaw";
        }
        return house;
    }

}
