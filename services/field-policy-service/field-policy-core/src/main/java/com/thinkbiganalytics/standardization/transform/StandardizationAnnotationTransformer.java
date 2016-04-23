package com.thinkbiganalytics.standardization.transform;

import com.thinkbiganalytics.policy.BasePolicyAnnotationTransformer;
import com.thinkbiganalytics.policy.standardization.StandardizationPolicy;
import com.thinkbiganalytics.policy.standardization.Standardizer;
import com.thinkbiganalytics.policy.rest.model.FieldRuleProperty;
import com.thinkbiganalytics.policy.rest.model.FieldStandardizationRule;
import com.thinkbiganalytics.policy.rest.model.FieldStandardizationRuleBuilder;

import java.util.List;

/**
 * Created by sr186054 on 4/21/16.
 */
public class StandardizationAnnotationTransformer
    extends BasePolicyAnnotationTransformer<FieldStandardizationRule, StandardizationPolicy, Standardizer> implements StandardizationTransformer {

  private static final StandardizationAnnotationTransformer instance = new StandardizationAnnotationTransformer();

  @Override
  public FieldStandardizationRule buildUiModel(Standardizer annotation, StandardizationPolicy policy,
                                               List<FieldRuleProperty> properties) {
    FieldStandardizationRule
        rule =
        new FieldStandardizationRuleBuilder(annotation.name()).objectClassType(policy.getClass()).description(
            annotation.description()).addProperties(properties).build();
    return rule;
  }

  @Override
  public Class<Standardizer> getAnnotationClass() {
    return Standardizer.class;
  }

  public static StandardizationAnnotationTransformer instance() {
    return instance;
  }
}
