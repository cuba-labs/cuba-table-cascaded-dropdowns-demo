package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;

@NamePattern("%s|name")
@Table(name = "DEMO_PROJECT")
@Entity(name = "demo$Project")
public class Project extends StandardEntity {
    private static final long serialVersionUID = -5818110795851504190L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "project")
    protected Set<Task> tasks;

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Task> getTasks() {
        return tasks;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}