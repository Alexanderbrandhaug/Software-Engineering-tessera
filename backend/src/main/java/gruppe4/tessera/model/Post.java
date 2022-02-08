package gruppe4.tessera.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "posts") // This tells Hibernate to make a table out of this class
public class Post {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)// ID will be used as primarykey and will be autoincremented
    private Integer id;
    private String title, description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;



    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title= title;
    }
        
    public String getTitle(){
        return title;
    }
    public void setAuthor(User user){
        this.user = user;
    }
    public User getAuthor(){
        return user;
    }
}