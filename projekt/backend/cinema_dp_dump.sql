--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-07-08 11:01:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16718)
-- Name: cinema_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cinema_user (
    id bigint NOT NULL,
    fname character varying(30) NOT NULL,
    lname character varying(30) NOT NULL,
    email character varying(50) NOT NULL,
    phone_number character varying(15) NOT NULL
);


ALTER TABLE public.cinema_user OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16686)
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(320) NOT NULL,
    genre character varying(20) NOT NULL,
    duration integer NOT NULL,
    actors character varying(300) NOT NULL,
    director character varying(100) NOT NULL,
    image character varying(300) NOT NULL
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16779)
-- Name: movie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.movie ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 16698)
-- Name: screening; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screening (
    id bigint NOT NULL,
    start_time character varying(10) NOT NULL,
    date character varying(20) NOT NULL,
    movie_id bigint NOT NULL,
    ongoing boolean NOT NULL
);


ALTER TABLE public.screening OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16780)
-- Name: screening_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.screening ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.screening_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 16785)
-- Name: screening_seat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screening_seat (
    seat_id bigint NOT NULL,
    screening_id bigint NOT NULL,
    status boolean NOT NULL,
    id bigint NOT NULL
);


ALTER TABLE public.screening_seat OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16800)
-- Name: screening_seat_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.screening_seat ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.screening_seat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 16713)
-- Name: seat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seat (
    id bigint NOT NULL
);


ALTER TABLE public.seat OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16708)
-- Name: ticket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ticket (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    price integer NOT NULL,
    seat_id integer NOT NULL,
    screening_id bigint NOT NULL,
    movie_id bigint NOT NULL
);


ALTER TABLE public.ticket OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16783)
-- Name: ticket_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.ticket ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ticket_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 16784)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cinema_user ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4878 (class 0 OID 16718)
-- Dependencies: 219
-- Data for Name: cinema_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cinema_user (id, fname, lname, email, phone_number) FROM stdin;
\.


--
-- TOC entry 4874 (class 0 OID 16686)
-- Dependencies: 215
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie (id, name, description, genre, duration, actors, director, image) FROM stdin;
3	Inception	A mind-bending thriller about dreams within dreams.	Sci-Fi	148	Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page	Christopher Nolan	inception.jpg
4	Bad Boys	Two hip detectives protect a witness to a murder while investigating a case of stolen heroin from the evidence storage room from their police precinct.	Action, Comedy	119	Will Smith	Michael Bay	https://example.com/images/badboys.jpg
\.


--
-- TOC entry 4875 (class 0 OID 16698)
-- Dependencies: 216
-- Data for Name: screening; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.screening (id, start_time, date, movie_id, ongoing) FROM stdin;
1	15:00	08/07/2024	4	t
\.


--
-- TOC entry 4883 (class 0 OID 16785)
-- Dependencies: 224
-- Data for Name: screening_seat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.screening_seat (seat_id, screening_id, status, id) FROM stdin;
\.


--
-- TOC entry 4877 (class 0 OID 16713)
-- Dependencies: 218
-- Data for Name: seat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seat (id) FROM stdin;
2
3
4
5
6
7
8
\.


--
-- TOC entry 4876 (class 0 OID 16708)
-- Dependencies: 217
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ticket (id, user_id, price, seat_id, screening_id, movie_id) FROM stdin;
\.


--
-- TOC entry 4890 (class 0 OID 0)
-- Dependencies: 220
-- Name: movie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movie_id_seq', 4, true);


--
-- TOC entry 4891 (class 0 OID 0)
-- Dependencies: 221
-- Name: screening_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.screening_id_seq', 1, true);


--
-- TOC entry 4892 (class 0 OID 0)
-- Dependencies: 225
-- Name: screening_seat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.screening_seat_id_seq', 2, true);


--
-- TOC entry 4893 (class 0 OID 0)
-- Dependencies: 222
-- Name: ticket_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ticket_id_seq', 1, false);


--
-- TOC entry 4894 (class 0 OID 0)
-- Dependencies: 223
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 2, true);


--
-- TOC entry 4713 (class 2606 OID 16692)
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id);


--
-- TOC entry 4715 (class 2606 OID 16702)
-- Name: screening screening_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screening
    ADD CONSTRAINT screening_pkey PRIMARY KEY (id);


--
-- TOC entry 4723 (class 2606 OID 16799)
-- Name: screening_seat screening_seat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screening_seat
    ADD CONSTRAINT screening_seat_pkey PRIMARY KEY (id);


--
-- TOC entry 4719 (class 2606 OID 16717)
-- Name: seat seat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seat
    ADD CONSTRAINT seat_pkey PRIMARY KEY (id);


--
-- TOC entry 4717 (class 2606 OID 16712)
-- Name: ticket ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (id);


--
-- TOC entry 4721 (class 2606 OID 16722)
-- Name: cinema_user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cinema_user
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 4724 (class 2606 OID 16768)
-- Name: screening screening_movie_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screening
    ADD CONSTRAINT screening_movie_id_foreign FOREIGN KEY (movie_id) REFERENCES public.movie(id);


--
-- TOC entry 4729 (class 2606 OID 16793)
-- Name: screening_seat screening_seat_screening_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screening_seat
    ADD CONSTRAINT screening_seat_screening_id_foreign FOREIGN KEY (screening_id) REFERENCES public.screening(id);


--
-- TOC entry 4730 (class 2606 OID 16788)
-- Name: screening_seat screening_seat_seat_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screening_seat
    ADD CONSTRAINT screening_seat_seat_id_foreign FOREIGN KEY (seat_id) REFERENCES public.seat(id);


--
-- TOC entry 4725 (class 2606 OID 16748)
-- Name: ticket ticket_movie_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_movie_id_foreign FOREIGN KEY (movie_id) REFERENCES public.movie(id);


--
-- TOC entry 4726 (class 2606 OID 16758)
-- Name: ticket ticket_screening_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_screening_id_foreign FOREIGN KEY (screening_id) REFERENCES public.screening(id);


--
-- TOC entry 4727 (class 2606 OID 16753)
-- Name: ticket ticket_seat_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_seat_id_foreign FOREIGN KEY (seat_id) REFERENCES public.seat(id);


--
-- TOC entry 4728 (class 2606 OID 16738)
-- Name: ticket ticket_user_id_foreign; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_user_id_foreign FOREIGN KEY (user_id) REFERENCES public.cinema_user(id);


-- Completed on 2024-07-08 11:01:46

--
-- PostgreSQL database dump complete
--

