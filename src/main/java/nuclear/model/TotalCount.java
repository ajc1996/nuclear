package nuclear.model;

import org.springframework.stereotype.Service;

@Service
public class TotalCount {
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
