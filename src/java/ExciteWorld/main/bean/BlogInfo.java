
package ExciteWorld.main.bean;

import java.beans.*;
import java.io.Serializable;

public class BlogInfo implements Serializable{
    
    private String Blog_title;
    private String Blog_content;
    private String author_email;
    private int Blog_id;

    public BlogInfo(){
        this.Blog_content = "";
        this.Blog_id = 0;
        this.Blog_title = "";
        this.author_email = "";
    }
    
    public BlogInfo(String Blog_title, String Blog_content, String author_email, int Blog_id) {
        this.Blog_title = Blog_title;
        this.Blog_content = Blog_content;
        this.author_email = author_email;
        this.Blog_id = Blog_id;
    }

    public String getBlog_title() {
        return Blog_title;
    }

    public String getBlog_content() {
        return Blog_content;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public int getBlog_id() {
        return Blog_id;
    }

    public void setBlog_title(String Blog_title) {
        this.Blog_title = Blog_title;
    }

    public void setBlog_content(String Blog_content) {
        this.Blog_content = Blog_content;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public void setBlog_id(int Blog_id) {
        this.Blog_id = Blog_id;
    }
    
}
