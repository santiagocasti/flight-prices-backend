--
-- Name: imports; Type: TABLE; Schema: public; Owner: santiago; Tablespace:
--

CREATE TABLE imports (
    id bigint NOT NULL,
    import_date timestamp without time zone
);


ALTER TABLE public.imports OWNER TO santiago;

--
-- Name: imports_id_seq; Type: SEQUENCE; Schema: public; Owner: santiago
--

CREATE SEQUENCE imports_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.imports_id_seq OWNER TO santiago;

--
-- Name: imports_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: santiago
--

ALTER SEQUENCE imports_id_seq OWNED BY imports.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: santiago
--

ALTER TABLE ONLY imports ALTER COLUMN id SET DEFAULT nextval('imports_id_seq'::regclass);


--
-- Name: imports_pkey; Type: CONSTRAINT; Schema: public; Owner: santiago; Tablespace:
--

ALTER TABLE ONLY imports
    ADD CONSTRAINT imports_pkey PRIMARY KEY (id);