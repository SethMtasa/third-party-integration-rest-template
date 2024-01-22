package seth.rdPartyIntergration11jan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seth.rdPartyIntergration11jan.service.PostService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/getPosts")
    List<Map<String, Object>> getAllPosts(){
return  postService.getPosts();
    }

    @GetMapping("/getPostsById/{id}")
    Map<String, Object> getAllPosts(@PathVariable int id){
        return  postService.getPostsById(id);
    }

    @PostMapping("/insertPosts")
    Map<String, Object> getAllPosts(@RequestBody Map<String, Object> payload){
        return  postService.insertPost(payload);
    }


    @PutMapping("/updatePosts/{id}")
    Map<String, Object> updatePosts(@RequestBody Map<String, Object> payload, @PathVariable int id){
        return  postService.updatePost(payload, id);
    }

    @DeleteMapping("/deletePosts/{id}")
    Map<String, Object> deletePosts( @PathVariable int id){
        return  postService.deletePost(id);
    }


}
