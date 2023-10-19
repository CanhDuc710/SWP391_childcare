/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * CREATE TABLE Post ( post_id INT IDENTITY(1,1) PRIMARY KEY, title
 * NVARCHAR(200) NULL, short NVARCHAR(100) NULL, author_id INT NULL,
 * updated_date DATETIME NULL, detail NVARCHAR(MAX) NULL, image NVARCHAR(200)
 * NULL, post_category_id INT NULL, FOREIGN KEY (author_id) REFERENCES
 * Staff(staff_id), FOREIGN KEY (post_category_id) REFERENCES
 * Post_category(post_category_id) );
 *
 */
public class Post {

    private int postId;
    private int postCategoryId;
    private String title;
    private int authorId;
    private Timestamp updateDate;
    private String detail;
    private String image;

    public Post() {
    }

    public Post(int postId, int postCategoryId, String title, int authorId, Timestamp updateDate, String detail, String image) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.title = title;
        this.authorId = authorId;
        this.updateDate = updateDate;
        this.detail = detail;
        this.image = image;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(int postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getUpdateDate() {
        // Chuyển đổi Timestamp thành Date
        Date date = new Date(updateDate.getTime());

        // Trả về Date (chỉ chứa ngày, không chứa giờ, phút, giây và mili giây)
        return date;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
