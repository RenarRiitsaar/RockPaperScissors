package rps;


import lombok.Getter;
import lombok.Setter;
import java.util.Objects;



class RockPaperScissors {


    @Setter @Getter
    private static boolean playerOneTurn = true;
    @Getter @Setter
    private static Player playerOne;
    @Getter @Setter
    private static Player playerTwo;
    private static int playerTwoScore = 0;
    private static int playerOneScore;
    @Getter
    private static int roundCount= 1;
    @Getter
    private static int tieCount = 0;


    public static void initializePlayers() {
        playerOne = new Player();
        playerTwo = new Player();

    }

    public static void match() {



            if (Objects.equals(playerOne.getChoice(), playerTwo.getChoice())) {

                roundCount++;
                Frame.getRound().setText("Round: " + roundCount);

                tieCount++;
                Frame.getTie().setText("Ties: " + tieCount);

                playerOne.setChoice(null);
                playerTwo.setChoice(null);


            } else if (Objects.equals(playerOne.getChoice(), "Rock") && Objects.equals(playerTwo.getChoice(), "Paper") ||
                    Objects.equals(playerOne.getChoice(), "Paper") && Objects.equals(playerTwo.getChoice(), "Scissors")||
                    Objects.equals(playerOne.getChoice(), "Scissors") && Objects.equals(playerTwo.getChoice(), "Rock")){

                roundCount++;
                Frame.getRound().setText("Round: " + roundCount);

                playerTwo.setWinCount(++playerTwoScore);
                Frame.getPlayerTwoScore().setText("Player two: " + RockPaperScissors.getPlayerTwo().getWinCount());

                playerOne.setChoice(null);
                playerTwo.setChoice(null);

            } else if (Objects.equals(playerTwo.getChoice(), "Rock") && Objects.equals(playerOne.getChoice(), "Paper") ||
                    Objects.equals(playerTwo.getChoice(), "Paper") && Objects.equals(playerOne.getChoice(), "Scissors")||
                    Objects.equals(playerTwo.getChoice(), "Scissors") && Objects.equals(playerOne.getChoice(), "Rock")){

                roundCount++;
                Frame.getRound().setText("Round: " + roundCount);

                playerOne.setWinCount(++playerOneScore);
                Frame.getPlayerOneScore().setText("Player one: " + RockPaperScissors.getPlayerOne().getWinCount());

                playerOne.setChoice(null);
                playerTwo.setChoice(null);
            }

        }
    }






