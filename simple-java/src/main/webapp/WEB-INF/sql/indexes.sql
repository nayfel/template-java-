create index IX_1DC28386 on train_Assignment (assignmentId);
create index IX_848BF5F7 on train_Assignment (courses_title);
create index IX_23E1AC70 on train_Assignment (ms3employeedb_uid);

create index IX_1DE2B3A2 on train_Course (courseId);
create index IX_6300D270 on train_Course (title);

create index IX_EE501615 on train_DailyLog (assignment_id);
create index IX_B4EE4402 on train_DailyLog (dailyLogId);

create index IX_19B4EBBC on train_Track (trackId);

create index IX_C84CB3AF on train_TrackAssignment (trackId);
create index IX_8F370BDD on train_TrackAssignment (userScreenName);