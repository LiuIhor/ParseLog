	@WamiSoftware Ukraine	

Test Task


Introduction

The competition has passed and there are the start and finish logs with the participant ID and his start and finish time, respectively. (There are log files in the current archive).


Test task purpose

1. Using Parsing Logic, get information from tag_read_start. When repeating tags, use the first occurrence. (The start time has a “UTC” timezone!!!)
2. Using Parsing Logic, get information from tag_read_finish. When repeating tags, use the last occurrence.  (The finish time has a “Europe/Kiev” timezone!!!)
3. Define 10 participants who spent the least time in this competition.


Requirements

1. Develop a spring boot application with Rest API using which we can do an HTTP request to get the competition result.
2. Log files must be in the project (“resources” folder) and you must read logs from those files.
3. Implementation ​​ should be done with maximum use of Stream API
4. Implementation should be as concise as possible
5. Ready solution upload to Github



Parsing Logic:

TagRead example:

aaE4058001c6df0700011608131047512800FS
----058001c6df07----160813104751------

//Index start from 0
TAG_STARTS_AT = 4;
TAG_ENDS_AT = 16; //exclusive
TIMESTAMP_STARTS_AT = 20;
TIMESTAMP_ENDS_AT = 32; //exclusive

Timestamp parsing pattern: "yyMMddHHmmss"