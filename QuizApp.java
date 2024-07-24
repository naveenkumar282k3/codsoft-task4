import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Timer setup
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up! Quiz over.");
                showFinalScore();
                scanner.close();
                System.exit(0); // Exit the program after time's up
            }
        };

        // Start the timer (adjust the time in milliseconds as needed, 10 minutes in this case)
        timer.schedule(task, 600000);

        // Quiz questions
        String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "1"},
            {"What is the largest planet in our solar system?", "Saturn", "Jupiter", "Mars", "Earth", "2"},
            {"Who wrote Romeo and Juliet?", "Shakespeare", "Dickens", "Austen", "Hemingway", "1"},
            {"What is the tallest mountain in the world?", "Makalu", "K2", "Kangchenjunga", "Mount Everest", "4"},
            {"Which planet is known as the red planet?", "Venus", "Mars", "Jupiter", "Mercury", "2"},
            {"Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet", "1"},
            {"Which country won the FIFA World Cup in 2018?", "Germany", "Brazil", "France", "Argentina", "3"},
            {"Who invented the telephone?", "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Albert Einstein", "1"},
            {"Which element has the chemical symbol 'H'?", "Oxygen", "Helium", "Hydrogen", "Nitrogen", "3"},
            {"What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "1"}
        };

        // Quiz logic
        for (int i = 0; i < questions.length && !timeUp; i++) {
            String question = questions[i][0];
            String option1 = questions[i][1];
            String option2 = questions[i][2];
            String option3 = questions[i][3];
            String option4 = questions[i][4];
            String answer = questions[i][5];

            System.out.println("Question " + (i + 1) + ": " + question);
            System.out.println("1. " + option1);
            System.out.println("2. " + option2);
            System.out.println("3. " + option3);
            System.out.println("4. " + option4);
            System.out.print("Enter your answer (1-4): ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + answer + "\n");
            }
        }

        // After quiz completion or time up
        showFinalScore();
        timer.cancel(); // Cancel timer after quiz ends
        scanner.close();
    }

    // Method to display final score
    static void showFinalScore() {
        System.out.println("Quiz complete!");
        System.out.println("Your score: " + score);
    }
}