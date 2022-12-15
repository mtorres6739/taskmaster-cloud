package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.BelongsTo;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the TaskList type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "TaskLists", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byTeams", fields = {"superTeamId","name"})
public final class TaskList implements Model {
  public static final QueryField ID = field("TaskList", "id");
  public static final QueryField NAME = field("TaskList", "name");
  public static final QueryField DESCRIPTION = field("TaskList", "description");
  public static final QueryField TYPE = field("TaskList", "type");
  public static final QueryField DATE_CREATED = field("TaskList", "dateCreated");
  public static final QueryField DIFFICULTY = field("TaskList", "difficulty");
  public static final QueryField SUPER_TEAM = field("TaskList", "superTeamId");
  public static final QueryField S3_IMAGE_KEY = field("TaskList", "s3ImageKey");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="TaskListStatusTypeEnum") TaskListStatusTypeEnum type;
  private final @ModelField(targetType="AWSDateTime") Temporal.DateTime dateCreated;
  private final @ModelField(targetType="Int") Integer difficulty;
  private final @ModelField(targetType="SuperTeam") @BelongsTo(targetName = "superTeamId", targetNames = {"superTeamId"}, type = SuperTeam.class) SuperTeam superTeam;
  private final @ModelField(targetType="String") String s3ImageKey;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getDescription() {
      return description;
  }
  
  public TaskListStatusTypeEnum getType() {
      return type;
  }
  
  public Temporal.DateTime getDateCreated() {
      return dateCreated;
  }
  
  public Integer getDifficulty() {
      return difficulty;
  }
  
  public SuperTeam getSuperTeam() {
      return superTeam;
  }
  
  public String getS3ImageKey() {
      return s3ImageKey;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private TaskList(String id, String name, String description, TaskListStatusTypeEnum type, Temporal.DateTime dateCreated, Integer difficulty, SuperTeam superTeam, String s3ImageKey) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.type = type;
    this.dateCreated = dateCreated;
    this.difficulty = difficulty;
    this.superTeam = superTeam;
    this.s3ImageKey = s3ImageKey;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      TaskList taskList = (TaskList) obj;
      return ObjectsCompat.equals(getId(), taskList.getId()) &&
              ObjectsCompat.equals(getName(), taskList.getName()) &&
              ObjectsCompat.equals(getDescription(), taskList.getDescription()) &&
              ObjectsCompat.equals(getType(), taskList.getType()) &&
              ObjectsCompat.equals(getDateCreated(), taskList.getDateCreated()) &&
              ObjectsCompat.equals(getDifficulty(), taskList.getDifficulty()) &&
              ObjectsCompat.equals(getSuperTeam(), taskList.getSuperTeam()) &&
              ObjectsCompat.equals(getS3ImageKey(), taskList.getS3ImageKey()) &&
              ObjectsCompat.equals(getCreatedAt(), taskList.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), taskList.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getDescription())
      .append(getType())
      .append(getDateCreated())
      .append(getDifficulty())
      .append(getSuperTeam())
      .append(getS3ImageKey())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("TaskList {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("dateCreated=" + String.valueOf(getDateCreated()) + ", ")
      .append("difficulty=" + String.valueOf(getDifficulty()) + ", ")
      .append("superTeam=" + String.valueOf(getSuperTeam()) + ", ")
      .append("s3ImageKey=" + String.valueOf(getS3ImageKey()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static TaskList justId(String id) {
    return new TaskList(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      description,
      type,
      dateCreated,
      difficulty,
      superTeam,
      s3ImageKey);
  }
  public interface NameStep {
    BuildStep name(String name);
  }
  

  public interface BuildStep {
    TaskList build();
    BuildStep id(String id);
    BuildStep description(String description);
    BuildStep type(TaskListStatusTypeEnum type);
    BuildStep dateCreated(Temporal.DateTime dateCreated);
    BuildStep difficulty(Integer difficulty);
    BuildStep superTeam(SuperTeam superTeam);
    BuildStep s3ImageKey(String s3ImageKey);
  }
  

  public static class Builder implements NameStep, BuildStep {
    private String id;
    private String name;
    private String description;
    private TaskListStatusTypeEnum type;
    private Temporal.DateTime dateCreated;
    private Integer difficulty;
    private SuperTeam superTeam;
    private String s3ImageKey;
    @Override
     public TaskList build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new TaskList(
          id,
          name,
          description,
          type,
          dateCreated,
          difficulty,
          superTeam,
          s3ImageKey);
    }
    
    @Override
     public BuildStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep type(TaskListStatusTypeEnum type) {
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep dateCreated(Temporal.DateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
    
    @Override
     public BuildStep difficulty(Integer difficulty) {
        this.difficulty = difficulty;
        return this;
    }
    
    @Override
     public BuildStep superTeam(SuperTeam superTeam) {
        this.superTeam = superTeam;
        return this;
    }
    
    @Override
     public BuildStep s3ImageKey(String s3ImageKey) {
        this.s3ImageKey = s3ImageKey;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String description, TaskListStatusTypeEnum type, Temporal.DateTime dateCreated, Integer difficulty, SuperTeam superTeam, String s3ImageKey) {
      super.id(id);
      super.name(name)
        .description(description)
        .type(type)
        .dateCreated(dateCreated)
        .difficulty(difficulty)
        .superTeam(superTeam)
        .s3ImageKey(s3ImageKey);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder type(TaskListStatusTypeEnum type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder dateCreated(Temporal.DateTime dateCreated) {
      return (CopyOfBuilder) super.dateCreated(dateCreated);
    }
    
    @Override
     public CopyOfBuilder difficulty(Integer difficulty) {
      return (CopyOfBuilder) super.difficulty(difficulty);
    }
    
    @Override
     public CopyOfBuilder superTeam(SuperTeam superTeam) {
      return (CopyOfBuilder) super.superTeam(superTeam);
    }
    
    @Override
     public CopyOfBuilder s3ImageKey(String s3ImageKey) {
      return (CopyOfBuilder) super.s3ImageKey(s3ImageKey);
    }
  }
  
}
