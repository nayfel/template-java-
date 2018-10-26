create table train_Assignment (
	assignmentId LONG not null primary key,
	courses_title VARCHAR(75) null,
	ms3employeedb_uid VARCHAR(75) null,
	assignedDate VARCHAR(75) null,
	startDate VARCHAR(75) null,
	endDate VARCHAR(75) null,
	status VARCHAR(500) null,
	cost VARCHAR(75) null,
	certification BOOLEAN,
	hoursSpent DOUBLE,
	currentSection VARCHAR(75) null,
	notes VARCHAR(500) null,
	admin VARCHAR(75) null
);

create table train_Course (
	title VARCHAR(75) not null primary key,
	description VARCHAR(500) null,
	listPrice VARCHAR(75) null,
	provider VARCHAR(75) null,
	courseId LONG,
	estimatedHours DOUBLE,
	sections VARCHAR(75) null,
	skills VARCHAR(75) null
);

create table train_DailyLog (
	dailyLogId LONG not null primary key,
	assignment_id LONG,
	date_ VARCHAR(75) null,
	accomplishments VARCHAR(500) null,
	roadblocks VARCHAR(500) null,
	plan VARCHAR(500) null,
	notes VARCHAR(500) null,
	hours DOUBLE,
	section VARCHAR(75) null
);

create table train_Track (
	trackId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(500) null,
	courseList VARCHAR(75) null,
	accreditation VARCHAR(75) null
);

create table train_TrackAssignment (
	trackAssignmentId LONG not null primary key,
	trackId LONG,
	userScreenName VARCHAR(75) null,
	assignmentIdList VARCHAR(75) null,
	dateAssigned VARCHAR(75) null,
	admin VARCHAR(75) null
);