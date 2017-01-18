-- begin DEMO_TASK
create table DEMO_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PROJECT_ID varchar(36),
    --
    primary key (ID)
)^
-- end DEMO_TASK
-- begin DEMO_WORKER
create table DEMO_WORKER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEMO_WORKER
-- begin DEMO_PROJECT
create table DEMO_PROJECT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end DEMO_PROJECT
-- begin DEMO_TIME_ENTRY
create table DEMO_TIME_ENTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    HOURS integer not null,
    PROJECT_ID varchar(36) not null,
    TASK_ID varchar(36) not null,
    WORKER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DEMO_TIME_ENTRY
-- begin DEMO_WORKER_TASK_LINK
create table DEMO_WORKER_TASK_LINK (
    WORKER_ID varchar(36) not null,
    TASK_ID varchar(36) not null,
    primary key (WORKER_ID, TASK_ID)
)^
-- end DEMO_WORKER_TASK_LINK
