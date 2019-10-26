package matyja.projects;

public interface Game {
    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuessess();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameVon();

    boolean isGameLost();



}
