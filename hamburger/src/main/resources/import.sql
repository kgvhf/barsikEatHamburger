INSERT INTO public."document" (date_create, date_modify, num) values (now(), now(), 1);
INSERT INTO public."document" (date_create, date_modify, num) values (now() - interval '10 DAY', now(), 2);
INSERT INTO public."document" (date_create, date_modify, num) values (now() - interval '100 DAY', now() - interval '50 DAY', 3);
INSERT INTO public."document" (date_create, date_modify, num) values (now() - interval '100 DAY', now() - interval '60 DAY', 4);
INSERT INTO public."document" (date_create, date_modify, num) values (now() - interval '100 DAY', now() - interval '70 DAY', 5);
INSERT INTO public."document" (date_create, date_modify, num) values (now() - interval '100 DAY', now() - interval '80 DAY', 6);