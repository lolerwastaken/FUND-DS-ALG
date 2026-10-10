import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
		
        System.out.println("Hello and welcome to Robot Fight!");

        //Default bot for player
        Part head1 = new Part(20, 6, 2);
        Part arms1 = new Part(20, 8, 2);
        Part legs1 = new Part(20, 4, 2);
        Bot playerBot = new Bot(head1, arms1, legs1);

        //Default bot for opponent level 1
        Part head2 = new Part(20, 6, 2);
        Part arms2 = new Part(20, 8, 2);
        Part legs2 = new Part(20, 4, 2);
        Bot opponentBot = new Bot(head2, arms2, legs2);

        //print the status of both bots.
        System.out.println("Player:" + playerBot);
        System.out.println("Opponent: " + opponentBot);

        Scanner s = new Scanner(System.in);
        int num = 0;
        System.out.println("A Battle about to begin!");
        while (!playerBot.isDead() && !opponentBot.isDead()) {
            //Player attacks first
            System.out.println("Player's Turn. Choose the attack target:");

            String input = "";

            //Choose where to attack
            while (true) {
                System.out.println("1: head, 2: arms, 3: legs, 4: do nothing");
                input = s.nextLine();
                try {
                    num = Integer.parseInt(input);
                    if (num == 1 || num == 2 || num == 3 || num == 4) {
                        break;
                    } else {
                        System.out.println("Not a legal number, please re-input.");
                    }

                } catch (Exception e) {
                    System.out.println("Not a number, please re-input.");
                }
            }
            //The effect of player attack resolves
            Part target = null;

            if (num == 1) { // attack head
                target = opponentBot.getHead();
                System.out.println("player attack the head");
            } else if (num == 2) { //attack the arm
                target = opponentBot.getArms();
                System.out.println("player attack the arms");
            } else if (num == 3) { // attack the legs
                target = opponentBot.getLegs();
                System.out.println("player attack the legs");
            } else { // choose not to attack
                System.out.println("player DOES NOT attack");
            }

            playerBot.attack(target);
            System.out.println("Player:" + playerBot);
            System.out.println("Opponent: " + opponentBot);
            if(opponentBot.isDead()){
                break;
            }

            //Then the opponent chooses where to attack
            //opponent attacks head, arms, and legs respectively
            if (playerBot.getHead().getHp() > 0) {
                target = playerBot.getHead();
                System.out.println("Opponent attack player's head");
            } else if (playerBot.getArms().getHp() > 0) {
                target = playerBot.getArms();
                System.out.println("Opponent attack player's arms");
            } else {
                target = playerBot.getLegs();
                System.out.println("Opponent attack player's legs");
            }

            //Then the effect of the opponent attack resolves.
            opponentBot.attack(target);
            System.out.println("Player:" + playerBot);
            System.out.println("Opponent: " + opponentBot);


        }
        // One of the bot is dead now.
        if (playerBot.isDead()) {
            System.out.println("Game Over: You Lose.");
        } else {
            System.out.println("Congratulations: You Win.");
        }


    }
}