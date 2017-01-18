package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|name")
@Table(name = "DEMO_WORKER")
@Entity(name = "demo$Worker")
public class Worker extends StandardEntity {
    private static final long serialVersionUID = -3167246309957098171L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "DEMO_WORKER_TASK_LINK",
        joinColumns = @JoinColumn(name = "WORKER_ID"),
        inverseJoinColumns = @JoinColumn(name = "TASK_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
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