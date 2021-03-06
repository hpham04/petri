package com.wixpress.petri.experiments.domain;

import com.wixpress.petri.laboratory.EligibilityCriterion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author talyag
 * @since 9/3/14
 */
public class AdditionalEligibilityCriteria {

    private Map<Class<? extends EligibilityCriterion>, EligibilityCriterion> criteria;

    public AdditionalEligibilityCriteria() {
        this.criteria = new HashMap<>();
    }

    public <T extends EligibilityCriterion> T getCriterion(Class<T> fieldClass) {
        return (T) criteria.get(fieldClass);
    }

    public <T extends EligibilityCriterion> AdditionalEligibilityCriteria withCriterion(T data) {
        criteria.put(data.getClass(), data);
        return this;
    }

    public static AdditionalEligibilityCriteria merge(AdditionalEligibilityCriteria criteria, AdditionalEligibilityCriteria moreCriteria){
        for (EligibilityCriterion criterion : moreCriteria.criteria.values()){
            criteria = criteria.withCriterion(criterion);
        }
        return criteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionalEligibilityCriteria that = (AdditionalEligibilityCriteria) o;

        return !(criteria != null ? !criteria.equals(that.criteria) : that.criteria != null);
    }

    @Override
    public int hashCode() {
        return criteria != null ? criteria.hashCode() : 0;
    }
}
