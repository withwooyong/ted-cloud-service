package com.ted.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 인증 및 권한 부여
 * 서비스 검색 통합
 * 응답 캐싱
 * 정책, 회로 차단기 및 Qos 다시 시도
 * 속도제한
 * 부하 분산
 * 로깅, 추적, 상관관계
 * 헤더, 쿼리 문자열 및 청구 변환
 * IP허용 목록에 추가
 * https://velog.io/@tedigom/MSA-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-3API-Gateway-nvk2kf0zbj
 * http://localhost:8080/user/execute?userName=Ted&orderName=MacBook&payType=kakao&price=2000
 * http://localhost:8080/auth/token?userName=token
 */
@SpringBootApplication
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }
}
