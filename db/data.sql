INSERT INTO TASKS (ID, TYPE) VALUES (0, 'MAZE');
INSERT INTO TASKS (ID, TYPE) VALUES (1, 'ASSOCIATIONS');
INSERT INTO TASKS (ID, TYPE) VALUES (2, 'WORD_SEARCH');
INSERT INTO TASKS (ID, TYPE) VALUES (3, 'GRAMMAR_QUIZ');
INSERT INTO TASKS (ID, TYPE) VALUES (4, 'FIND_SUPERFLUOUS');

INSERT INTO USERS (ID, NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES (0, 'Team1', 'password', 'USER', 0, 0);
INSERT INTO USERS (ID, NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES (1, 'Team2', 'password', 'USER', 0, 0);
INSERT INTO USERS (ID, NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES (2, 'admin', 'itquiz2015', 'ADMIN', 0, 0);

INSERT INTO GRAMMAR_QUIZ (ID, ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  0,
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ID, ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  1,
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

COMMIT;