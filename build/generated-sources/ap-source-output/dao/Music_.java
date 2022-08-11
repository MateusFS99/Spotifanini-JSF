package dao;

import dao.Artist;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-10T22:09:28")
@StaticMetamodel(Music.class)
public class Music_ { 

    public static volatile SingularAttribute<Music, String> image;
    public static volatile SingularAttribute<Music, Artist> artist;
    public static volatile SingularAttribute<Music, String> release;
    public static volatile SingularAttribute<Music, String> name;
    public static volatile SingularAttribute<Music, String> genre;
    public static volatile SingularAttribute<Music, Long> id;
    public static volatile SingularAttribute<Music, String> audio;

}