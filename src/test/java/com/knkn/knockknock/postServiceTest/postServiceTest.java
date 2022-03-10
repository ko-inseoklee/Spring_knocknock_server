//package com.knkn.knockknock.postServiceTest;
//
//import com.knkn.knockknock.domain.Comments;
//import com.knkn.knockknock.domain.Post;
//import com.knkn.knockknock.domain.TopicOfDay;
//import com.knkn.knockknock.domain.user.User;
//import com.knkn.knockknock.service.PostService;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//@SpringBootTest
////@Transactional
//public class postServiceTest {
//    User user = new User("tjrkd222", "1234", "20대", "inseoking", "남","학생");
////String id, String pw, String age, String nickname, String sex, String job
//    Post p1 = new Post("inseoking","고백하는 방법", "연애","어떻게 말하면 좋을까요?", new Date(),"20대", 24);
//    Post p2 = new Post("someng2","자녀 결혼", "자식","결혼시켜야 하는데", new Date(),"60대", 70);
//    Post p3 = new Post("seungeun3","이직 고민", "직장","이직을 고민하고 있는데, 어디가 좋을까요?", new Date(),"40대", 44);
//    TopicOfDay topicOfDay = new TopicOfDay();
//
//
//
//    @Autowired
//    PostService postService;
//
//    @Test
//    public Post 게시글작성(Post p){
//        p1.setUserID(user.getId());
//        return postService.uploadPost(p);
//    }
//
//    @Test
//    public void 불러오기(){
//        게시글작성(p1);
//        게시글작성(p2);
//
//        ArrayList<Post> result = postService.loadPosts();
//        Assertions.assertThat(result.size()).isEqualTo(1);
//    }
//
//    @Test
//    public void 검색기준불러오기(){
//        게시글작성(p1);
//
//        ArrayList<Post> result = postService.search("고백");
//        Assertions.assertThat(result.size()).isEqualTo(1);
//    }
//
//    @Test
//    public void 세대정렬불러오기(){
//        게시글작성(p1);
//
//        ArrayList<Post> result = postService.sortByAge("30대");
//        Assertions.assertThat(result.size()).isEqualTo(1);
//    }
//
//    @Test
//    public void 핫한게시글(){
//        게시글작성(p1);
//        게시글작성(p2);
//        게시글작성(p3);
//
//        ArrayList<Post> result = postService.getHotPosts(100,1);
//
//        Assertions.assertThat(result.size()).isEqualTo(1);
//    }
//
//    @Test
//    public void 게시글접속(){
//        Post p = 게시글작성(p1);
//        Post result = postService.enterPost(p.getId());
//
//        Assertions.assertThat(result.getId()).isEqualTo(p.getId());
//    }
//
//    @Test
//    public void 게시글수정(){
//        Post p = 게시글작성(p1);
//        String before = p.getTitle();
//
//        p.setTitle("고백 후기");
//        Post result = postService.updatePost(p);
//
//        Assertions.assertThat(result.getTitle()).isEqualTo(before);
//    }
//
//
//    @Test
//    public void 공감(){
//        Post p = 게시글작성(p1);
//        int before = p.getLike();
//
//        int result = postService.postThumbUp(p.getId(),user.getId());
//        result = postService.postThumbUp(p.getId(),user.getId());
//
//        Assertions.assertThat(result).isEqualTo(before);
//    }
//
//    @Test
//    public void 댓글달기(){
//        Post p = 게시글작성(p1);
////        Comments c = new Comments("잘됐네요..!");
////
////        Comments result = postService.addComment(c, p.getId());
////
////        Assertions.assertThat(result.getContents()).isEqualTo("잘됐?");
//
//    }
//
//    //게시글공감과 동일
//    @Test
//    public void 댓글공감(){
//
//    }
//
//    //TODO: 로직 생각해봐야함.
//    @Test
//    public void 대댓글(){
////        TopicOfDay t = postService.getDailyTopic(220306L);
//
////        System.out.println(t.);
//    }
//
//
//}
