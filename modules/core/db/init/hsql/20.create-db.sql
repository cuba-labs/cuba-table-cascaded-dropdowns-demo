-- begin DEMO_TASK
alter table DEMO_TASK add constraint FK_DEMO_TASK_PROJECT foreign key (PROJECT_ID) references DEMO_PROJECT(ID)^
create index IDX_DEMO_TASK_PROJECT on DEMO_TASK (PROJECT_ID)^
-- end DEMO_TASK
-- begin DEMO_TIME_ENTRY
alter table DEMO_TIME_ENTRY add constraint FK_DEMO_TIME_ENTRY_PROJECT foreign key (PROJECT_ID) references DEMO_PROJECT(ID)^
alter table DEMO_TIME_ENTRY add constraint FK_DEMO_TIME_ENTRY_TASK foreign key (TASK_ID) references DEMO_TASK(ID)^
alter table DEMO_TIME_ENTRY add constraint FK_DEMO_TIME_ENTRY_WORKER foreign key (WORKER_ID) references DEMO_WORKER(ID)^
create index IDX_DEMO_TIME_ENTRY_WORKER on DEMO_TIME_ENTRY (WORKER_ID)^
create index IDX_DEMO_TIME_ENTRY_PROJECT on DEMO_TIME_ENTRY (PROJECT_ID)^
create index IDX_DEMO_TIME_ENTRY_TASK on DEMO_TIME_ENTRY (TASK_ID)^
-- end DEMO_TIME_ENTRY
-- begin DEMO_WORKER_TASK_LINK
alter table DEMO_WORKER_TASK_LINK add constraint FK_DWTL_WORKER foreign key (WORKER_ID) references DEMO_WORKER(ID)^
alter table DEMO_WORKER_TASK_LINK add constraint FK_DWTL_TASK foreign key (TASK_ID) references DEMO_TASK(ID)^
-- end DEMO_WORKER_TASK_LINK
