package com.example.ex01.controller;

import com.example.ex01.domain.ProductVO;
import com.example.ex01.domain.TaskVO;
import com.example.ex01.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value="ex01", method = RequestMethod.GET)
    public String ex01(){
        log.info("ex01........................");
        return "ex01";
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02........................");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request) {
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(@ModelAttribute("name") String name/*, Model model*/) {    // 스프링이 알아서 서블릿에 주입해주는 Model
//        model.addAttribute("name", name);
        log.info(name);
    }

//    이름, 나이, 성별 받고 출력
    @GetMapping("ex05")
    public void ex05(UserVO userVO) {
        log.info(userVO.getName());
        log.info(""+ userVO.getAge());
    }

    @GetMapping("ex06")
    public void ex06(UserVO userVO, @ModelAttribute("city") String city) {
        log.info(userVO.getName());
        log.info(""+ userVO.getAge());
        log.info(userVO.getGender());
        log.info(city);
    }

//    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
    @GetMapping("product")
    public void product() {;}

    @GetMapping("product-result")
    public void productResult(ProductVO productVO) {;}

//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
    @GetMapping("task")
    public void task() {;}

    @GetMapping("task-result")
    public void taskResult(TaskVO taskVO, Model model) {
        int total;
        double average;
        final int SUBJECT = 3;

        total = taskVO.getKorea() + taskVO.getEnglish() + taskVO.getMath();
        average = total / SUBJECT;

        model.addAttribute("total", total);
        model.addAttribute("average", average);
    }

//    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력
    @GetMapping("login")
    public void login(String identification, String password) {
        log.info("들어옴");
    }

    @GetMapping("login-result")
    public String loginResult(String identification) {
        return "/ex/" + identification;
    }

    @GetMapping("admin")
    public void admin() {;}

    @GetMapping("user")
    public void user() {;}

//    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
    @GetMapping("check")
    public void check() {;}

    @GetMapping("check-result")
    public String checkResult(String name, String result) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        int time = Integer.parseInt(formatter.format(date));
        String path = "";

        if(time < 9){
            path = "/ex/getToWork";
        } else if(time > 9) {
            path = "/ex/late";
        } else if(time > 17) {
            path = "/ex/leaveWork";
        } else if(time < 17) {
            path = "/ex/work";
        }
        log.info(path);
        return path;
    }

    @GetMapping("getToWork")
    public void getToWork(){;}

    @GetMapping("late")
    public void late(){;}

    @GetMapping("leaveWork")
    public void leaveWork(){;}

    @GetMapping("work")
    public void work(){;}
}