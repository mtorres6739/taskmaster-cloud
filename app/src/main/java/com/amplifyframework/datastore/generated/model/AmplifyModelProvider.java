package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.util.Immutable;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 *  Contains the set of model classes that implement {@link Model}
 * interface.
 */

public final class AmplifyModelProvider implements ModelProvider {
  private static final String AMPLIFY_MODEL_VERSION = "92b9883e73292eb6018f7d48df3a45ed";
  private static AmplifyModelProvider amplifyGeneratedModelInstance;
  private AmplifyModelProvider() {
    
  }
  
  public static AmplifyModelProvider getInstance() {
    if (amplifyGeneratedModelInstance == null) {
      amplifyGeneratedModelInstance = new AmplifyModelProvider();
    }
    return amplifyGeneratedModelInstance;
  }
  
  /**
   * Get a set of the model classes.
   *
   * @return a set of the model classes.
   */
  @Override
   public Set<Class<? extends Model>> models() {
    final Set<Class<? extends Model>> modifiableSet = new HashSet<>(
          Arrays.<Class<? extends Model>>asList(SuperTeam.class, TaskList.class)
        );
    
        return Immutable.of(modifiableSet);
        
  }
  
  /**
   * Get the version of the models.
   *
   * @return the version string of the models.
   */
  @Override
   public String version() {
    return AMPLIFY_MODEL_VERSION;
  }
}
