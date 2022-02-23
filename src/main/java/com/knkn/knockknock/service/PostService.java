package com.knkn.knockknock.service;

import com.knkn.knockknock.domain.Comments;
import com.knkn.knockknock.domain.Post;
import com.knkn.knockknock.domain.user.UserThumbUp;
import com.knkn.knockknock.repository.postRepository.CommentsRepository;
import com.knkn.knockknock.repository.postRepository.PostRepository;
import com.knkn.knockknock.repository.userRepository.UserThumbUpRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentsRepository commentsRepository;
    private final UserThumbUpRepository userThumbUpRepository;

    public PostService(PostRepository postRepository, CommentsRepository commentsRepository, UserThumbUpRepository userThumbUpRepository) {
        this.postRepository = postRepository;
        this.commentsRepository = commentsRepository;
        this.userThumbUpRepository = userThumbUpRepository;
    }

    public ArrayList<Post> loadPosts(){
        return postRepository.findAll();
    }
    public Post uploadPost(Post post) {
        try{
            Post p = postRepository.save(post);
            return p;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Post> search(String token){
        return postRepository.findByTitleContains(token);
    }

    public ArrayList<Post> sortByAge(String age){
        return postRepository.findByAgeContains(age);
    }

    public Post enterPost(Long postID){
        return postRepository.findByIdEquals(postID);
    }

    public ArrayList<Post> getHotPosts(int likes, int cnt){
        ArrayList<Post> result = postRepository.findByLikeCntIsGreaterThan(likes);
        if (result.size() < cnt) return result;
        else {
            ArrayList<Post> ps = new ArrayList<>();
            ps.addAll(result.subList(0,cnt));
            return ps;
        }
    }

    public Post updatePost(Post p){
        return postRepository.saveAndFlush(p);
    }

    public Comments addComment(Comments c, Long pId){
        c.setPostID(pId);
        return commentsRepository.save(c);
    }

    public int postThumbUp(Long pId,String userID){
        Post p = postRepository.findByIdEquals(pId);
        Optional<UserThumbUp> isThumbUp = userThumbUpRepository.findByUIdEqualsAndBIdEquals(userID, pId);
        if(isThumbUp.isPresent()) {
            p.setLike(p.getLike() - 1);
            userThumbUpRepository.delete(isThumbUp.get());
        }
        else {
            UserThumbUp newThumbUp = new UserThumbUp();
            newThumbUp.setUId(userID);
            newThumbUp.setBId(pId);

            userThumbUpRepository.save(newThumbUp);
            p.setLike(p.getLike() + 1);
        }
        postRepository.saveAndFlush(p);

        return p.getLike();
    }

    public int commentThumbUp(Long cId, String uId){
        Comments c = commentsRepository.findByCommentIDEquals(cId);
        Optional<UserThumbUp> isThumbUp = userThumbUpRepository.findByUIdEqualsAndCIdEquals(uId, cId);
        if(isThumbUp.isPresent()) {
            c.setLikeCnt(c.getLikeCnt() - 1);
            userThumbUpRepository.delete(isThumbUp.get());
        }
        else {
            UserThumbUp newThumbUp = new UserThumbUp();
            newThumbUp.setUId(uId);
            newThumbUp.setCId(cId);

            userThumbUpRepository.save(newThumbUp);
            c.setLikeCnt(c.getLikeCnt() + 1);
        }
        commentsRepository.saveAndFlush(c);

        return c.getLikeCnt();
    }


}
