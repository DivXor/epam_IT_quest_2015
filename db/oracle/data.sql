INSERT INTO TASKS (ID, TYPE) VALUES (0, 'MAZE');
INSERT INTO TASKS (ID, TYPE) VALUES (1, 'ASSOCIATIONS');
INSERT INTO TASKS (ID, TYPE) VALUES (2, 'WORD_SEARCH');
INSERT INTO TASKS (ID, TYPE) VALUES (3, 'GRAMMAR_QUIZ');
INSERT INTO TASKS (ID, TYPE) VALUES (4, 'FIND_SUPERFLUOUS');

INSERT INTO USERS (NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES ('Team1', 'password', 'USER', 0, 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES ('Team2', 'password', 'USER', 0, 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TOTAL_SCORE, TASKS_ID) VALUES ('admin', 'itquiz2015', 'ADMIN', 0, 0);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'To enable <u>the automatic</u> registration to SLD you have <u>to configure</u>
  the connectivity information <u>using the</u> command line tool sldreg.',
  1
);

INSERT INTO MAZE (ID, WX, WY, WORD, BASE_SCORE)
VALUES (0, 60, 60, 'TheHitchhikersGuidetotheGalaxy', 1);

COMMIT;