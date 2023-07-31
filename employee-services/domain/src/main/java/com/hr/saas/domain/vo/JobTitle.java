package com.hr.saas.domain.vo;

import java.util.Objects;
import java.util.UUID;

public class JobTitle {

    private final UUID id;

    private final String titleName;


    public JobTitle(UUID id, String titleName) {
        this.id = id;
        this.titleName = titleName;
    }

    public UUID getId() {
        return id;
    }

    public String getTitleName() {
        return titleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobTitle jobTitle = (JobTitle) o;
        return Objects.equals(id, jobTitle.id) && Objects.equals(titleName, jobTitle.titleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titleName);
    }
}
