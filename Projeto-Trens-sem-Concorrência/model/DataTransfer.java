package model;

public class DataTransfer {
    
    private static final DataTransfer instance = new DataTransfer();

    private int choice=0;

    private DataTransfer() {
    }

    public static DataTransfer getInstance() {
        return instance;
    }

    public int getChoice() {
       return choice;
    }

    public void setChoice(int choice) {
       this.choice = choice;
    }
}
