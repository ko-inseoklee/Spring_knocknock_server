package com.knkn.knockknock;

public class ResponseMessage {
    // 시스템 관련 응답 메세
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";

    // USER 관련 응답 메세지
    public static final String USER_FOUND = "유저 찾기 성공";
    public static final String USER_CREATE_SUCCESS = "유저 정보 생성 성공";
    public static final String USER_CREATE_FAIL = "유저 정보 생성 실패";

    // 매칭 관련 응답 메세지
    public static final String MATCHING_CREATE_SUCCESS = "매칭방 생성 성공";
    public static final String MATCHING_JOIN_SUCCESS = "매칭방 입장 성공";
    public static final String MATCHING_JOIN_FAIL = "매칭방 입장 실패";


    // 전화번호 인증 응답 메세지
    public static final String MORE_THAN_TEN_TIMES_REQUEST = "일일 전송 횟수를 초과했습니다.";
    public static final String CONFIRM_CREATE_SUCCESS = "전화번호 인증 요청 성공";
}
