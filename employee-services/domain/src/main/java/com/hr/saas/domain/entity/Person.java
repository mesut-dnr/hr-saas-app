package com.hr.saas.domain.entity;

import com.hr.saas.domain.vo.PersonId;

public class Person extends AggregateRoot<PersonId> {

    private String personName;

    private Person(Builder builder) {
        super.setId(builder.personId);
        personName = builder.personName;
    }


    public static final class Builder {
        private PersonId personId;
        private String personName;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PersonId val) {
            personId = val;
            return this;
        }

        public Builder personName(String val) {
            personName = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public String getPersonName() {
        return personName;
    }
}
