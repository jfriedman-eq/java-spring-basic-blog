package com.pluralsight.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

import java.util.List;

@Controller
public class BlogController {
    private PostRepository postRespository;

    public BlogController(PostRepository p) {
        this.postRespository = p;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap m) {
        List<Post> l = this.postRespository.getAllPosts();
        m.put("title", "Blog Post 1");
        m.put("posts", l);

        return "home";
    }
}
