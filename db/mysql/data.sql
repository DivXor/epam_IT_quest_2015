INSERT INTO TASK (ID, TYPE) VALUES (0, 'MAZE');
INSERT INTO TASK (ID, TYPE) VALUES (1, 'ASSOCIATIONS');
INSERT INTO TASK (ID, TYPE) VALUES (2, 'WORD_SEARCH');
INSERT INTO TASK (ID, TYPE) VALUES (3, 'GRAMMAR_QUIZ');
INSERT INTO TASK (ID, TYPE) VALUES (4, 'FIND_SUPERFLUOUS');
INSERT INTO TASK (ID, TYPE) VALUES (5, 'FINISH');

INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team1', 'password', 'USER', 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team2', 'password', 'USER', 0);
INSERT INTO USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('admin', 'itquiz2015', 'ADMIN', 0);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'In 2002, 20 million people in the United States <span class="possible-answer">were reported</span>
  <span class="answer-letter">(A)</span> have asthma -- a chronic inflammatory lung disease
  <span class="possible-answer">characterized by</span> <span class="answer-letter">(B)</span>
  wheezing, <span class="possible-answer">difficulty breathing</span> <span class="answer-letter">(C)</span>,
  chest tightness <span class="possible-answer">and coughing</span> <span class="answer-letter">(D)</span>.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Charters <span class="possible-answer">are</span> <span class="answer-letter">(A)</span> self-governed schools
   <span class="possible-answer">that</span> <span class="answer-letter">(B)</span> operate independent
   <span class="possible-answer">of</span> <span class="answer-letter">(C)</span> local school boards,
   <span class="possible-answer">however</span> <span class="answer-letter">(D)</span> with public money.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Scientists have <span class="possible-answer">uncovered</span> <span class="answer-letter">(A)</span> evidence
    <span class="possible-answer">for an</span> <span class="answer-letter">(B)</span> innate satisfaction
    <span class="possible-answer">in human</span> <span class="answer-letter">(C)</span> beings
    <span class="possible-answer">giving</span> <span class="answer-letter">(D)</span> people their comeuppance.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'When major food companies <span class="possible-answer">began widely</span> <span class="answer-letter">(A)</span>
    using partially hydrogenated oils <span class="possible-answer">in the</span> <span class="answer-letter">(B)</span>
    1970s, they thought <span class="possible-answer">they</span> <span class="answer-letter">(C)</span> were making
    <span class="possible-answer">these</span> <span class="answer-letter">(D)</span> products more healthful.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Education <span class="possible-answer">should</span> <span class="answer-letter">(A)</span> emphasize
    <span class="possible-answer">our</span> <span class="answer-letter">(B)</span> interdependence
    <span class="possible-answer">with</span> <span class="answer-letter">(C)</span> peoples, with other species
    and with the planet <span class="possible-answer">as a whole</span> <span class="answer-letter">(D)</span>.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Italian citizens <span class="possible-answer">lead their counterparts</span> <span class="answer-letter">(A)</span>
    in the UK, France and Germany <span class="possible-answer">in supporting moves</span>
    <span class="answer-letter">(B)</span> to bring the service standards and
    <span class="possible-answer">practices of government''s</span> <span class="answer-letter">(C)</span> departments
    closer to <span class="possible-answer">those achieved</span> <span class="answer-letter">(D)</span> by the best
    private sector companies.',
  1
);

INSERT INTO GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Everybody <span class="possible-answer">holds hands</span> <span class="answer-letter">(A)</span>. This is the
    energy that will <span class="possible-answer">get you</span> <span class="answer-letter">(B)</span> through the
    evening. We''re going to be a winning team. <span class="possible-answer">Let''s</span>
    <span class="answer-letter">(C)</span> make it the best shift we''ve ever had. Go
    <span class="possible-answer">for it</span>, <span class="answer-letter">(D)</span> guys!.',
  1
);

INSERT INTO MAZE (ID, WX, WY, WORD, BASE_SCORE)
VALUES (0, 60, 60, 'Test word', 1);

INSERT INTO word_search (ANSWER, BASE_SCORE) VALUES ('cloth', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (1, '/images/excess_image_quiz/1/1.jpg', '/images/excess_image_quiz/1/2.jpg', '/images/excess_image_quiz/1/3.jpg',
   '/images/excess_image_quiz/1/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (3, '/images/excess_image_quiz/2/1.jpg', '/images/excess_image_quiz/2/2.jpg', '/images/excess_image_quiz/2/3.jpg',
   '/images/excess_image_quiz/2/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (3, '/images/excess_image_quiz/3/1.jpg', '/images/excess_image_quiz/3/2.jpg', '/images/excess_image_quiz/3/3.jpg',
   '/images/excess_image_quiz/3/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (4, '/images/excess_image_quiz/4/1.jpg', '/images/excess_image_quiz/4/2.jpg', '/images/excess_image_quiz/4/3.jpg',
   '/images/excess_image_quiz/4/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (1, '/images/excess_image_quiz/5/1.jpg', '/images/excess_image_quiz/5/2.jpg', '/images/excess_image_quiz/5/3.jpg',
   '/images/excess_image_quiz/5/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (2, '/images/excess_image_quiz/6/1.jpg', '/images/excess_image_quiz/6/2.jpg', '/images/excess_image_quiz/6/3.jpg',
   '/images/excess_image_quiz/6/4.jpg', 1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, BASE_SCORE)
VALUES
  (3, '/images/excess_image_quiz/7/1.jpg', '/images/excess_image_quiz/7/2.jpg', '/images/excess_image_quiz/7/3.jpg',
   1.0);

INSERT INTO excess_image (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, BASE_SCORE)
VALUES
  (3, '/images/excess_image_quiz/8/1.jpg', '/images/excess_image_quiz/8/2.jpg', '/images/excess_image_quiz/8/3.jpg',
   1.0);

# Association
INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/1/1.jpg',
        '/images/association/1/2.jpg',
        '/images/association/1/3.jpg',
        '/images/association/1/4.jpg',
        3, 1.0, 'Beatles');

INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/2/1.jpg',
        '/images/association/2/2.jpg',
        '/images/association/2/3.jpg',
        '/images/association/2/4.jpg',
        3, 1.0, 'Bobby');

INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/3/1.jpg',
        '/images/association/3/2.jpg',
        '/images/association/3/3.jpg',
        '/images/association/3/4.jpg',
        3, 1.0, 'Churchill');

INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/4/1.jpg',
        '/images/association/4/2.jpg',
        '/images/association/4/3.jpg',
        '/images/association/4/4.jpg',
        3, 1.0, 'Newton');

INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/5/1.jpg',
        '/images/association/5/2.jpg',
        '/images/association/5/3.jpg',
        '/images/association/5/4.jpg',
        3, 1.0, 'Queen');

INSERT INTO associations (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD)
VALUES ('/images/association/6/1.jpg',
        '/images/association/6/2.jpg',
        '/images/association/6/3.jpg',
        '/images/association/6/4.jpg',
        3, 1.0, 'Sting');

COMMIT;