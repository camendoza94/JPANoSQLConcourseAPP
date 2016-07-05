package co.edu.uniandes.isis2503.basic.model.entity;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-05T08:36:21")
@StaticMetamodel(CompetitionEntity.class)
public class CompetitionEntity_ { 

    public static volatile SingularAttribute<CompetitionEntity, String> country;
    public static volatile SingularAttribute<CompetitionEntity, List> competitors;
    public static volatile SingularAttribute<CompetitionEntity, String> city;
    public static volatile SingularAttribute<CompetitionEntity, String> year;
    public static volatile SingularAttribute<CompetitionEntity, Long> winnerId;
    public static volatile SingularAttribute<CompetitionEntity, String> name;
    public static volatile SingularAttribute<CompetitionEntity, Long> id;
    public static volatile SingularAttribute<CompetitionEntity, Double> prize;

}