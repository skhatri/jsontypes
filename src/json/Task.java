package json;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "GenericTask", value = GenericTask.class),
        @JsonSubTypes.Type(name = "SpecialTask", value = SpecialTask.class)
})
@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, property = "taskType", use = JsonTypeInfo.Id.NAME)
class Task {

    @JsonIgnore
    private String taskType;

    public Task(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return this.taskType;
    }


}
