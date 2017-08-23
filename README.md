# spring-security-practice

spring boot docker 참조 : https://github.com/spring-guides/gs-spring-boot-docker

1. docker image 생성
    - ./gradlew build buildDocker
2. docker 실행
    - docker run -p 8888:8888 -t spring-security-practice:0.0.1-SNAPSHOT
3. docker 실행 시 프로파일 설정
    - docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8888:8888 -t spring-security-practice:0.0.1-SNAPSHOT