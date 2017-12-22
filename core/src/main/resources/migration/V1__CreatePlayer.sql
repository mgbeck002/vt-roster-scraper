CREATE TABLE player {
	id bigserial primary key,
	number smallint,
	name text,
	varsity_letters int,
	position character varying(3),
	height smallint,
	weight smallint,
	eligibility_class character varying(3),
	home_state text,
	hometown text,
	high_school text,
	first_seen_time timestamp not null default now,
	last_seen_time timestamp
};