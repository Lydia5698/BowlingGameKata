public class Game {
    private  int roll = 0;
    private int[] rolls = new int[21];
    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int score() {
        int score = 0;
        int counter = 0;
        for (int frame = 0; frame < 10; frame++){
            if (isStrike(counter)){
                score += 10 + strikeBonus(counter);
                counter++;
            }
            else if (isSpare(counter)){ // Spare
                score += 10 + spareBonus(counter);
                counter += 2;
            }
            else {
                score += sumOfBallsInFrame(counter);
                counter += 2;
            }
        }
        return score;
    }

    private int sumOfBallsInFrame(int counter) {
        return rolls[counter] + rolls[counter+1];
    }

    private int strikeBonus(int counter){
        return rolls[counter+1] + rolls[counter+2];
    }

    private int spareBonus(int counter){
        return rolls[counter+2];
    }

    private boolean isStrike(int counter) {
        return rolls[counter] == 10;
    }

    private boolean isSpare(int counter) {
        return rolls[counter] + rolls[counter + 1] == 10;
    }
}
