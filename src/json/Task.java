package json;


import com.fasterxml.jackson.annotation.*;
import org.joda.time.LocalDate;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "GenericTask", value = GenericTask.class),
        @JsonSubTypes.Type(name = "SpecialTask", value = SpecialTask.class)
})
@JsonTypeInfo(include = JsonTypeInfo.As.PROPERTY, property = "taskType", use = JsonTypeInfo.Id.NAME)
class Task {

    @JsonIgnore
    private String taskType;

    @JsonProperty
    private LocalDate createdDate;

    public Task(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return this.taskType;
    }

    void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    LocalDate getCreatedDate() {
        return createdDate;
    }

    void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
