PGDMP                         z            spotifaninidb    12.0    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    131475    spotifaninidb    DATABASE     ?   CREATE DATABASE spotifaninidb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE spotifaninidb;
                postgres    false            ?            1259    131924    artist    TABLE     ?   CREATE TABLE public.artist (
    id integer NOT NULL,
    country character varying(255),
    image character varying(255),
    name character varying(255)
);
    DROP TABLE public.artist;
       public         heap    postgres    false            ?            1259    131922    artist_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.artist_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.artist_id_seq;
       public          postgres    false    203                       0    0    artist_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.artist_id_seq OWNED BY public.artist.id;
          public          postgres    false    202            ?            1259    131935    music    TABLE     ?   CREATE TABLE public.music (
    id integer NOT NULL,
    audio character varying(255),
    genre character varying(255),
    image character varying(255),
    name character varying(255),
    release character varying(255),
    artist bigint
);
    DROP TABLE public.music;
       public         heap    postgres    false            ?            1259    131933    music_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.music_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.music_id_seq;
       public          postgres    false    205                       0    0    music_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.music_id_seq OWNED BY public.music.id;
          public          postgres    false    204            ?
           2604    131927 	   artist id    DEFAULT     f   ALTER TABLE ONLY public.artist ALTER COLUMN id SET DEFAULT nextval('public.artist_id_seq'::regclass);
 8   ALTER TABLE public.artist ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            ?
           2604    131938    music id    DEFAULT     d   ALTER TABLE ONLY public.music ALTER COLUMN id SET DEFAULT nextval('public.music_id_seq'::regclass);
 7   ALTER TABLE public.music ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205                      0    131924    artist 
   TABLE DATA           :   COPY public.artist (id, country, image, name) FROM stdin;
    public          postgres    false    203   ?                 0    131935    music 
   TABLE DATA           O   COPY public.music (id, audio, genre, image, name, release, artist) FROM stdin;
    public          postgres    false    205   B                  0    0    artist_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.artist_id_seq', 8, true);
          public          postgres    false    202                       0    0    music_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.music_id_seq', 14, true);
          public          postgres    false    204            ?
           2606    131932    artist artist_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.artist
    ADD CONSTRAINT artist_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.artist DROP CONSTRAINT artist_pkey;
       public            postgres    false    203            ?
           2606    131943    music music_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.music
    ADD CONSTRAINT music_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.music DROP CONSTRAINT music_pkey;
       public            postgres    false    205            ?
           2606    131944    music fk_music_artist    FK CONSTRAINT     t   ALTER TABLE ONLY public.music
    ADD CONSTRAINT fk_music_artist FOREIGN KEY (artist) REFERENCES public.artist(id);
 ?   ALTER TABLE ONLY public.music DROP CONSTRAINT fk_music_artist;
       public          postgres    false    2698    203    205               ?   x?M??1D??*\??;!$Dd$?yuX?l?^??Zh	ɼ73S??X%g??Y?f?Z?V7?_??{=^??ܻ??????Ud)؈?mZ?+?.s???4?T?V??1?n?CB???f?-?Fwn??????J??????:?           x?eO?n?0=;_?/?P`Ƕhb?VM+?]L???(?&??gJ?R??????(?&?]z???`?	>h??????????pS?s?%b.@??]?3?5??b? ??h?#?a??	ۥpL?H??bZ??AiΚ?????pv??@?z4??\V'??????+?e??@?Cg??V?????N?͌7|e-?њ????8?hɈggG*?\??kQ۟*3Ɋ????d?r??8?(?R????vI_??r|??_OB???~??     