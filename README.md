# MySelectShop

네이버 검색 api 를 이용해, 예상 최저가를 지정하여 관리할 수 있다.


### 사용 기술
- SpringBoot 3.3.2
- Spring Data Jpa
- validation
- Spring Security, JWT
- thymeleaf


### Feature
- Naver api 상품 `검색`
- Auth
  - `로그인` 및 `회원가입` (이메일, 닉네임, 패스워드)
    - `JwtAuthenticationFilter` 클래스를 생성해 필터에서 jwt와 security 를 이용한 로그인 로직 구현
  - `카카오 로그인`
  - `JwtAuthorizationFilter` 를 통한 권한 검증
- 관심상품
  - 희망 최저가 설정과 함께 관심상품 `등록`
  - 최저가 `수정`
- 카테고리 폴더
  - 폴더 별 관심상품 `저장`
  - 폴더 별 관심상품 `조회`
- 스케쥴링
  - **Spring Scheduling** 을 통해 등록된 관심상품의 가격 업데이트

#### TO-DO
- 삭제 기능
- 업데이트 및 삭제 시 권한 처리 고도화
- 최저가 달성 시 알림 기능 구현
- 스케쥴링을 통한 관심상품 가격 수정 기능 수정
  - 관싱상품 데이터 검증이 필요. 현재는 검색을 List로 받아와 제일 가까운(제목과 제일 일치하는) 데이터 하나를 뽑아 업데이트함. 네이버 검색 로직 결과에 의존적이다.
