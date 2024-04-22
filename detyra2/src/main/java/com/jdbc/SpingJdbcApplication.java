package com.jdbc;

import com.jdbc.entity.Category;
import com.jdbc.entity.Post;
import com.jdbc.entity.User;
import com.jdbc.service.CategoryService;
import com.jdbc.service.PostCategoryService;
import com.jdbc.service.PostService;
import com.jdbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpingJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpingJdbcApplication.class, args);
    }
private Logger logger= LoggerFactory.getLogger(SpingJdbcApplication.class);

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostCategoryService postCategoryService;


    @Override
    public void run(String... args) throws Exception {
        //testing UserService
        logger.info("userService.getUsers: {}",userService.getUsers());
        logger.info("userService.getUserById: {}",userService.getUserById(1));
        var newUser=User.builder().username("ilirjan").email("email@email.com").password("pass").dateCreated(null).dateModified(null).build();
        logger.info("userService.createUser: {}",userService.createUser(newUser));
        var newUser2=User.builder().username("ilirjan").email("email2222@email.com").password("pass").dateCreated(null).dateModified(null).build();
        logger.info("userService.createUser: {}",userService.createUser(newUser2));
        var newUser1=User.builder().username("ilirjan").email("email12321321@email.com").password("pass").dateCreated(null).dateModified(null).build();
        logger.info("userService.updateUser: {}",userService.updateUser(2,newUser1));
        logger.info("userService.deleteUser: {}",userService.deleteUser(6));
        logger.info("userService.getUsers: {}",userService.getUsers());
        // end testing UserService

        //testing PostService
        logger.info("postService.getPosts: {}",postService.getPosts());
        logger.info("postService.getPostsById: {}",postService.getPostsById(1));
        var newPost= Post.builder().title("test").body("asdsadsadsadsa").userId(2).dateCreated(null).dateModified(null).build();
        logger.info("postService.createPost: {}",postService.createPost(newPost));
        logger.info("postService.getPostsByUserId: {}",postService.getPostsByUserId(1));
        logger.info("postService.updatePost: {}",postService.updatePost(2,newPost));
        logger.info("postService.getPosts: {}",postService.getPosts());
        //

        //testing CategoryService
        logger.info("categoryService.getCategories: {}",categoryService.getCategories());
        logger.info("categoryService.getCategoryById: {}",categoryService.getCategoryById(2));
        var newCategory= Category.builder().name("catTest").dateCreated(null).dateModified(null).build();
        logger.info("categoryService.createCategory: {}",categoryService.createCategory(newCategory));
        logger.info("categoryService.getCategories: {}",categoryService.getCategories());
        //

        //testing PostCategoryService
        logger.info("postCategoryService.getPostCategoryByPostId: {}",postCategoryService.getPostCategoryByPostId(1));
        logger.info("postCategoryService.getPostCategoryByPostIdAndCategoryId: {}",postCategoryService.getPostCategoryByPostIdAndCategoryId(1,1));
        //

    }
}
