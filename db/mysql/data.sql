INSERT INTO it_quest.TASK (ID, TYPE) VALUES (0, 'GRAMMAR_QUIZ');
INSERT INTO it_quest.TASK (ID, TYPE) VALUES (1, 'FIND_EXCESS');
INSERT INTO it_quest.TASK (ID, TYPE) VALUES (2, 'WORD_SEARCH');
INSERT INTO it_quest.TASK (ID, TYPE) VALUES (3, 'MAZE');
INSERT INTO it_quest.TASK (ID, TYPE) VALUES (4, 'ASSOCIATIONS');
INSERT INTO it_quest.TASK (ID, TYPE) VALUES (5, 'FINISH');

INSERT INTO it_quest.USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team1', 'fatwhale16', 'USER', 0);
INSERT INTO it_quest.USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('Team2', 'jollywolf88', 'USER', 0);
INSERT INTO it_quest.USERS (NAME, PASSWORD, ROLE, TASK_ID) VALUES ('admin', 'itquiz2015', 'ADMIN', 0);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'In 2002, 20 million people in the United States <span class="possible-answer">were reported have</span>
  <span class="answer-letter">(A)</span>  asthma -- a chronic inflammatory lung disease
  <span class="possible-answer">characterized by</span> <span class="answer-letter">(B)</span>
  wheezing, <span class="possible-answer">difficulty breathing</span> <span class="answer-letter">(C)</span>,
  chest tightness <span class="possible-answer">and coughing</span> <span class="answer-letter">(D)</span>.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'D',
  'Charters <span class="possible-answer">are</span> <span class="answer-letter">(A)</span> self-governed schools
   <span class="possible-answer">that</span> <span class="answer-letter">(B)</span> operate independent
   <span class="possible-answer">of</span> <span class="answer-letter">(C)</span> local school boards,
   <span class="possible-answer">however</span> <span class="answer-letter">(D)</span> with public money.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'D',
  'Scientists have <span class="possible-answer">uncovered</span> <span class="answer-letter">(A)</span> evidence
    <span class="possible-answer">for an</span> <span class="answer-letter">(B)</span> innate satisfaction
    <span class="possible-answer">in human</span> <span class="answer-letter">(C)</span> beings
    <span class="possible-answer">giving</span> <span class="answer-letter">(D)</span> people their comeuppance.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'D',
  'When major food companies <span class="possible-answer">began widely</span> <span class="answer-letter">(A)</span>
    using partially hydrogenated oils <span class="possible-answer">in the</span> <span class="answer-letter">(B)</span>
    1970s, they thought <span class="possible-answer">they</span> <span class="answer-letter">(C)</span> were making
    <span class="possible-answer">these</span> <span class="answer-letter">(D)</span> products more healthful.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'C',
  'Education <span class="possible-answer">should</span> <span class="answer-letter">(A)</span> emphasize
    <span class="possible-answer">our</span> <span class="answer-letter">(B)</span> interdependence
    <span class="possible-answer">with</span> <span class="answer-letter">(C)</span> peoples, with other species
    and with the planet <span class="possible-answer">as a whole</span> <span class="answer-letter">(D)</span>.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'C',
  'Italian citizens <span class="possible-answer">lead their counterparts</span> <span class="answer-letter">(A)</span>
    in the UK, France and Germany <span class="possible-answer">in supporting moves</span>
    <span class="answer-letter">(B)</span> to bring the service standards and
    <span class="possible-answer">practices of government''s</span> <span class="answer-letter">(C)</span> departments
    closer to <span class="possible-answer">those achieved</span> <span class="answer-letter">(D)</span> by the best
    private sector companies.',
  0.25
);

INSERT INTO it_quest.GRAMMAR_QUIZ (ANSWER, SENTENCE, BASE_SCORE)
VALUES (
  'A',
  'Everybody <span class="possible-answer">holds hands</span> <span class="answer-letter">(A)</span>. This is the
    energy that will <span class="possible-answer">get you</span> <span class="answer-letter">(B)</span> through the
    evening. We''re going to be a winning team. <span class="possible-answer">Let''s</span>
    <span class="answer-letter">(C)</span> make it the best shift we''ve ever had. Go
    <span class="possible-answer">for it</span>, <span class="answer-letter">(D)</span> guys!.',
  0.25
);

INSERT INTO it_quest.MAZE (ID, WX, WY, WORD, BASE_SCORE, PASSWORD)
VALUES (1, 60, 60, 'hitchhiker''s guide to the galaxy', 3, 'hitchhiker''s guide to the galaxy');

INSERT INTO it_quest.MAZE (ID, WX, WY, WORD, BASE_SCORE, PASSWORD)
VALUES (2, 60, 60, 'hitchhiker''s guide to the galaxy', 3, 'hitchhiker''s guide to the galaxy');

INSERT INTO it_quest.WORD_SEARCH (ANSWER, BASE_SCORE) VALUES ('cloth', 3);
INSERT INTO it_quest.WORD_SEARCH (ANSWER, BASE_SCORE) VALUES ('octet', 3);
INSERT INTO it_quest.WORD_SEARCH (ANSWER, BASE_SCORE) VALUES ('focal', 3);

INSERT INTO it_quest.EXCESS_IMAGE (EXCESS_IMAGE_NUMBER, IMG1, IMG2, IMG3, IMG4, BASE_SCORE)
VALUES
  (1, '/images/excess_image_quiz/1/1.jpg',
   '/images/excess_image_quiz/1/2.jpg',
   '/images/excess_image_quiz/1/3.jpg',
   '/images/excess_image_quiz/1/4.jpg', 0.25),

  (3, '/images/excess_image_quiz/2/1.jpg',
   '/images/excess_image_quiz/2/2.jpg',
   '/images/excess_image_quiz/2/3.jpg',
   '/images/excess_image_quiz/2/4.jpg', 0.25),

  (3, '/images/excess_image_quiz/3/1.jpg',
   '/images/excess_image_quiz/3/2.jpg',
   '/images/excess_image_quiz/3/3.jpg',
   '/images/excess_image_quiz/3/4.jpg', 0.25),

  (4, '/images/excess_image_quiz/4/1.jpg',
   '/images/excess_image_quiz/4/2.jpg',
   '/images/excess_image_quiz/4/3.jpg',
   '/images/excess_image_quiz/4/4.jpg', 0.25),

  (1, '/images/excess_image_quiz/5/1.jpg',
   '/images/excess_image_quiz/5/2.jpg',
   '/images/excess_image_quiz/5/3.jpg',
   '/images/excess_image_quiz/5/4.jpg', 0.25),

  (2, '/images/excess_image_quiz/6/1.jpg',
   '/images/excess_image_quiz/6/2.jpg',
   '/images/excess_image_quiz/6/3.jpg',
   '/images/excess_image_quiz/6/4.jpg', 0.25),

  (3, '/images/excess_image_quiz/7/1.jpg',
   '/images/excess_image_quiz/7/2.jpg',
   '/images/excess_image_quiz/7/3.jpg',
   NULL, 0.25),

  (3, '/images/excess_image_quiz/8/1.jpg',
   '/images/excess_image_quiz/8/2.jpg',
   '/images/excess_image_quiz/8/3.jpg',
   NULL, 0.25);

# Association
INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/5/1_06aca64e-5713-4d5e-bf4a-04e2e1d43146.jpg',
        '/images/association/5/2_3fb410a7-3a5c-497e-a194-13f85f9c953e.jpg',
        '/images/association/5/3_8aabfd3a-e32a-4f68-945d-3e429b7b3fa4.jpg',
        '/images/association/5/4_1349b58c-864f-4298-b2ed-e9cba8e7782d.jpg',
        3, 2, 'Queen', 'England');

INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/1/1_e6d75fbb-7699-4630-a911-0e2b2141217d.jpg',
        '/images/association/1/2_eb59266c-5bc9-49e7-86e9-c084d68cbb65.jpg',
        '/images/association/1/3_2fb09ffd-3c81-4fb8-9c5a-ed082e3427df.jpg',
        '/images/association/1/4_cb6e2b51-5ae8-471b-8464-98092af00148.jpg',
        3, 2, 'Beatles', 'Music');

INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/2/1_68c4a23d-6ab5-43ca-ab64-6369c89cf6ea.jpg',
        '/images/association/2/2_42a767a6-c098-4d4c-a0e7-ea9b42210919.jpg',
        '/images/association/2/3_366e46b6-ffb5-4af3-9bb0-bf843544ea9d.jpg',
        '/images/association/2/4_379bb8c6-d119-4396-b05c-80579134a742.jpg',
        3, 2, 'Bobby', 'England');

INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/3/1_0dbb476c-9bc0-4b40-9e77-773634a3a7f3.jpg',
        '/images/association/3/2_c14f2594-13cb-4efb-8c36-c214a7b56b74.jpg',
        '/images/association/3/3_96c57cba-5cd9-4a0f-a342-e80c4826b7a2.jpg',
        '/images/association/3/4_fed0f081-b23e-4fa2-9533-c67b4ec4ff65.jpg',
        3, 2, 'Churchill', 'Politics');

INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/4/1_c3e86810-3bee-4cd3-bf42-59259a4d55e1.jpg',
        '/images/association/4/2_48b74f96-da5e-466f-b412-46ec09fb35b5.jpg',
        '/images/association/4/3_8c18e138-29e6-40d6-8730-8599120a610e.jpg',
        '/images/association/4/4_cfe5d1b4-7eb9-4a6c-af8b-534334269812.jpg',
        3, 2, 'Newton', 'Science');

INSERT INTO it_quest.ASSOCIATIONS (IMG1, IMG2, IMG3, IMG4, HINT_TOTAL, BASE_SCORE, HIDDEN_WORD, CATEGORY)
VALUES ('/images/association/6/1_89d76724-d58c-401c-a85f-8bd5bbdd1e3a.jpg',
        '/images/association/6/2_8d895b73-9295-4ee4-a4c2-42a0eebee9b9.jpg',
        '/images/association/6/3_abcee915-fab3-4ca1-92b6-f833d099515d.jpg',
        '/images/association/6/4_81329a6e-fd84-4adf-8cad-3a241a10cf23.jpg',
        3, 2, 'Sting', 'Music');

COMMIT;