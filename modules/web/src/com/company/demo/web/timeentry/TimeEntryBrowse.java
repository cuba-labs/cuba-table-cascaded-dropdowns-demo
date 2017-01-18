package com.company.demo.web.timeentry;

import com.company.demo.entity.Project;
import com.company.demo.entity.Task;
import com.company.demo.entity.TimeEntry;
import com.company.demo.entity.Worker;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TimeEntryBrowse extends AbstractLookup {
    @Inject
    private Table<TimeEntry> timeEntriesTable;
    @Inject
    private CollectionDatasource<TimeEntry, UUID> timeEntriesDs;
    @Inject
    private Metadata metadata;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        initTaskColumn();
        initWorkerColumn();
    }

    public void createTimeEntry() {
        TimeEntry timeEntry = metadata.create(TimeEntry.class);
        timeEntriesDs.addItem(timeEntry);
    }

    public void saveTimeEntries() {
        timeEntriesDs.commit();
        showNotification("Saved", NotificationType.TRAY);
    }

    private void initTaskColumn() {
        String columnId = "task";
        timeEntriesTable.addGeneratedColumn(columnId, entity -> {
            LookupField lookupField = componentsFactory.createComponent(LookupField.class);
            lookupField.setWidth("100%");
            //noinspection unchecked
            Datasource<TimeEntry> itemDs = timeEntriesTable.getItemDatasource(entity);
            lookupField.setDatasource(itemDs, columnId);

            itemDs.addItemPropertyChangeListener(e -> {
                if ("project".equals(e.getProperty())) {
                    Project project = (Project) e.getValue();
                    lookupField.setValue(null);
                    lookupField.setOptionsMap(getProjectTasksMap(project));
                }
            });

            Project project = itemDs.getItem().getProject();
            lookupField.setOptionsMap(getProjectTasksMap(project));

            return lookupField;
        });
    }

    private Map<String, ?> getProjectTasksMap(@Nullable Project project) {
        if (project == null) {
            return Collections.emptyMap();
        }

        Map<String, Object> tasks = new HashMap<>();
        for (Task task : project.getTasks()) {
            tasks.put(task.getInstanceName(), task);
        }
        return tasks;
    }

    private void initWorkerColumn() {
        String columnId = "worker";
        timeEntriesTable.addGeneratedColumn(columnId, entity -> {
            LookupField lookupField = componentsFactory.createComponent(LookupField.class);
            lookupField.setWidth("100%");
            //noinspection unchecked
            Datasource<TimeEntry> itemDs = timeEntriesTable.getItemDatasource(entity);
            lookupField.setDatasource(itemDs, columnId);

            itemDs.addItemPropertyChangeListener(e -> {
                if ("task".equals(e.getProperty())) {
                    Task task = (Task) e.getValue();
                    lookupField.setValue(null);
                    lookupField.setOptionsMap(getTaskWorkersMap(task));
                }
            });

            Task task = itemDs.getItem().getTask();
            lookupField.setOptionsMap(getTaskWorkersMap(task));

            return lookupField;
        });
    }

    private Map<String, ?> getTaskWorkersMap(@Nullable Task task) {
        if (task == null) {
            return Collections.emptyMap();
        }

        Map<String, Object> workers = new HashMap<>();
        for (Worker worker : task.getWorkers()) {
            workers.put(worker.getInstanceName(), worker);
        }
        return workers;
    }
}