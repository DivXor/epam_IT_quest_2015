INSERT INTO TASK (ID, TYPE) VALUES (0, 'MAZE');
INSERT INTO TASK (ID, TYPE) VALUES (1, 'ASSOCIATIONS');
INSERT INTO TASK (ID, TYPE) VALUES (2, 'WORD_SEARCH');
INSERT INTO TASK (ID, TYPE) VALUES (3, 'GRAMMAR_QUIZ');
INSERT INTO TASK (ID, TYPE) VALUES (4, 'FIND_SUPERFLUOUS');

INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team1', 'password', 'USER', 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team2', 'password', 'USER', 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('admin', 'itquiz2015', 'ADMIN', 0);

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
VALUES (0, 60, 60, 'Test word', 1);

INSERT INTO word_search (ANSWER, BASE_SCORE) VALUES ('cloth', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES (2, '/images/excess_image_quiz/img1.jpg', '/images/excess_image_quiz/img2.jpg', '/images/excess_image_quiz/img3.jpg', '/images/excess_image_quiz/img4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES (2, '/images/excess_image_quiz/img1.jpg', '/images/excess_image_quiz/img2.jpg', '/images/excess_image_quiz/img3.jpg', '/images/excess_image_quiz/img4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES (2, '/images/excess_image_quiz/img1.jpg', '/images/excess_image_quiz/img2.jpg', '/images/excess_image_quiz/img3.jpg', '/images/excess_image_quiz/img4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES (2, '/images/excess_image_quiz/img1.jpg', '/images/excess_image_quiz/img2.jpg', '/images/excess_image_quiz/img3.jpg', '/images/excess_image_quiz/img4.jpg', 1.0);

COMMIT;