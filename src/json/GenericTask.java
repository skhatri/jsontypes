package json;
class GenericTask extends Task {

    private String name;

    public GenericTask() {
        super("GenericTask");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
