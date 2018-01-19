package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {

    private List<Double> historyList;

    public ContainerHistory() {
        historyList = new ArrayList<>();
    }

    public void add(double situation) {
        historyList.add(situation);
    }

    public void reset() {
        historyList.clear();
    }

    public String toString() {
        return historyList.toString();
    }

    public double maxValue() {
        return Collections.max(historyList);
    }

    public double minValue() {
        return Collections.min(historyList);
    }

    public double average() {
        double average = 0.00;
        if (this.historyList.isEmpty()) {
            return average;
        }

        for (int i = 0, n = historyList.size(); i < n; i++) {
            average += historyList.get(i);
        }
        return average / historyList.size();
    }

    public double greatestFluctuation() {
        List<Double> fluctuations = new ArrayList<>();
        double greatestFluctuation = 0;
        if(historyList.isEmpty() || historyList.size() == 1){
            return greatestFluctuation;
        }else{
            for(int i = historyList.size() - 1; i >= 1; i--){
                double fluctuation = Math.abs(historyList.get(i) - historyList.get(i-1));
                fluctuations.add(fluctuation);
            }
        }
        for(double f : fluctuations){
            if(greatestFluctuation < f){
                greatestFluctuation = f;
            }
        }
        return greatestFluctuation;
    }

    public double variance() {
        double mean = average();
        double sum = 0;

        for (double history : historyList) {
            sum += Math.pow((history - mean), 2);
        }
        return sum / (historyList.size() - 1);
    }
}
