package upskill.pt.CarDealerShip.models;

public class Condition {
    // estados permitidos
    public enum ConditionType {
        NEW,
        USED
    }

    private ConditionType condition;
    private int kilometers;

    public Condition(ConditionType condition) {
        if (condition == ConditionType.USED) {
            throw new IllegalArgumentException("Number of kilometers must be provided this vehicle.");
        }
        this.condition = condition;
    }

    public Condition(ConditionType condition, int kilometers) {
        if (condition != ConditionType.USED) {
            throw new IllegalArgumentException("Number of kilometers is only applicable for used vehicles.");
        }
        this.condition = condition;
        this.kilometers = kilometers;
    }

    public ConditionType getCondition() {
        return condition;
    }

    public void setCondition(ConditionType condition) {
        if (condition == ConditionType.USED) {
            throw new IllegalArgumentException("Number of kilometers must be provided for used vehicles.");
        }
        this.condition = condition;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        if (condition != ConditionType.USED) {
            throw new IllegalArgumentException("Number of kilometers is only applicable for used vehicles.");
        }
        this.kilometers = kilometers;
    }

}
