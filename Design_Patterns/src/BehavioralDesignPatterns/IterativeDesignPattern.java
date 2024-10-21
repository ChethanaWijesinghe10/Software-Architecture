package BehavioralDesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int runs, int wickets);
}

class BattingCardObserver implements Observer{
    @Override
    public void update(int runs, int wickets) {
        System.out.println("Batting Card Updated: Runs = " + runs);
    }


}


class BowlingCardObserver implements Observer {
    @Override
    public void update(int runs, int wickets) {
        System.out.println("Bowling Card Updated: Wickets = " + wickets);
    }

}

class MatchSummaryObserver implements Observer {
    @Override
    public void update(int runs, int wickets) {
        System.out.println("Match Summary Updated: Runs = " + runs + ", Wickets = " + wickets);
    }
}


class MatchData {
    private List<Observer> observers;
    private int runs;
    private int wickets;

    public MatchData() {
        observers = new ArrayList<>();
    }

    //Methods to Manage Observers

    //To add observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    //
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(runs, wickets);
        }
    }

    public void setMatchData(int runs, int wickets) {
        this.runs = runs;
        this.wickets = wickets;
        notifyObservers();
    }
}

public class IterativeDesignPattern {
    public static void main(String[] args) {
        MatchData cricketData = new MatchData();

        BattingCardObserver battingCard = new BattingCardObserver();
        BowlingCardObserver bowlingCard = new BowlingCardObserver();
        MatchSummaryObserver matchSummary = new MatchSummaryObserver();

        cricketData.addObserver(battingCard);
        cricketData.addObserver(bowlingCard);
        cricketData.addObserver(matchSummary);

        cricketData.setMatchData(100, 2);
        //System.out.println("********************");

        /*cricketData.removeObserver(bowlingCard);
        System.out.println("After removing bowling card update");
        cricketData.setMatchData(200, 5);*/
    }
}
