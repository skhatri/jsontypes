package json;

class SpecialTask extends Task {
    private String operator;

    public SpecialTask() {
        super("SpecialTask");
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }
}
