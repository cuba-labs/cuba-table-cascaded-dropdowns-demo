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
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@NamePattern("%s|name")
@Table(name = "DEMO_TASK")
@Entity(name = "demo$Task")
public class Task extends StandardEntity {
    private static final long serialVersionUID = -5364600299533240591L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @JoinTable(name = "DEMO_WORKER_TASK_LINK",
        joinColumns = @JoinColumn(name = "TASK_ID"),
        inverseJoinColumns = @JoinColumn(name = "WORKER_ID"))
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected Set<Worker> workers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    protected Project project;

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }


    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}