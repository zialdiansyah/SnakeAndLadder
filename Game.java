public class Game {
    private Player curPlayer;
    private int[] cells;
    private int totalPlayers;
    private Player[] players;

    public Game(int[] cells, int totalPlayers, Player[] players) {
        this.cells = cells;
        this.totalPlayers = totalPlayers;
        this.players = players;
    }


    public Player setPlayers(int turn, Player[] players) {
        return players[turn];
    }

    public void startGame() {
        int turn = 0;
        curPlayer = setPlayers(turn, players);
        while (!isGameEnded()) {
            int diceValue = getDiceValue();
            movePlayerPosition(curPlayer, diceValue);
            turn++;
            if(turn == totalPlayers) {
                turn = 0;
            }
            curPlayer = setPlayers(turn, players);
            if (curPlayer.getPosition() == 100) {
                System.out.println(curPlayer.getName() + " won the game!");
            }
        }
    }

    public boolean isGameEnded() {
        return curPlayer.getPosition() == 100;
    }

    public int getDiceValue() {
        return Dice.roll();
    }

    public void movePlayerPosition(Player player, int diceValue) {

        int currPosition = player.getPosition();
        int nextPosition = currPosition + diceValue;
        if(nextPosition > 100) {
            nextPosition = currPosition;
        }
        if(cells[nextPosition-1] == 0) {
            player.setPosition(nextPosition);
        } else {
            player.setPosition(nextPosition-1);
        }

        System.out.println(player.getName() + " rolled a " + diceValue + " moved from position " + currPosition + " to " + nextPosition);
    }
}