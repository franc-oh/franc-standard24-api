# SpringBoot-Project : Standard API
> API 어플리케이션 생성 시 참고할 나만의 표준을 개발

## ⚙️ 개발 환경
- JDK 17
- Springboot 3.2.1
- H2 DB (In-Memory)
- Mybatis
- Gradle 8.4

---

## 🔧 기능
### Global
1. 글로벌 예외처리 + 예외처리 규격화
    - `global.error.*`
1. 공통 Response
    - `global.common.*`
1. ObjectMapper Date 타입 포맷팅
    - `global.config.ObjectMapperConfig`
1. HikariCP 설정, mybatis 설정
    - `global.config.database.*`
1. 공통유틸
    - `global.util.*`

### Domain
1. 도메인별 패키지 관리
1. 샘플 API 구현
   - 각 계층별 책임 및 비즈니스 로직 구현 예시
   - Domain, DTO

---

## ❗안내사항
- 서비스 구동 시 프로파일 설정
  - `-Dspring.profiles.active=test`