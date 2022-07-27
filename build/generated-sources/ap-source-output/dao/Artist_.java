package dao;

import dao.Music;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-27T15:21:53")
@StaticMetamodel(Artist.class)
public class Artist_ { 

    public static volatile SingularAttribute<Artist, String> country;
    public static volatile SingularAttribute<Artist, String> name;
    public static volatile CollectionAttribute<Artist, Music> musicCollection;
    public static volatile SingularAttribute<Artist, Integer> id;

}