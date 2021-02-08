springboot시작하기

# Java기초

## *객체 지향 프로그래밍(Object-Oriented Programming)의 특징

1. 캡슐화(Encapsulation)
   -프로그램의 세부 구현을 외부로 드러나지 않도록 특정 클래스 내부로 감추는것
   -접근 제어 지시자를 통해 외부에서 접근을 제어한다.

2. 상속(Inheritance)
   -자식 클래스가 부모클래스의 특성과 기능을 그대로 물려받는 것을 말한다.
   -자식 클래스에서 재 정의를 통해 부모 클래스의 매소드를 사용할 수 있다.

3. 다형성(Polymorphism)
   -하나의 메소드, 클래스가 상황에 따라 다른 의미로 해석될 수 있다.

   -Overloading은 다형성의 가장 대표적인 예

# 1.클래스(class)(Object)를 만드는 기능을 한다.

* 붕어빵 틀(클래스)과 붕어빵(객체)
* 여러가지 필드(Field)와 메소드(Method)를 가진다.
* JVM시작 시 RunTimeDataArea의 Method(Static)Area에 할당된다.

## [1]필드(Field)

```java
public class User{
	private int idx;
    private String name;
    private String part;
}
```



* 필드 = 속성 = 상태 = 멤버 변수 표현하는것.
* 접근 제어 지시자는 private
* Field는 JVM내의 Method(Static) Area에 할당된다.

## [2]메소드(Method)

```java
public class User{
	private int idx;
    private String name;
    private String part;
    
    public void hello(){
        System.out.println("안녕하세요. 저는 "+part+"파트"+name+"입니다.")
    }
}
```

* 객체의 동작, 행위, 기능
* 메소드는 JVM내의 Method(Static) Area에 할당된다.

## [3]생성자(Constructor)

```java
//회원 객체 생성자
//Default 생성자
//매개변수가 없는 생성자
public User(){
    this.idx = 9;
    this.name = "이현종";
    this.part = "Server";
}

//회원 객체 생성자
//매개변수가 있는 생성자
//@param idx  회원 고유 번호
//@param name 이름
//@param part 파트
public User(final int idx,final String name,final String part){
    this.idx = idx;
    this.name = name;
    this.part = part;
}
```

* Instance생성해주는 특수한 매소드
* 값을 반환하지 않는다.
* 생성자의 이름은 클래스의 이름과 동일
* 접근 제어 지시자는 반드시 public

### (1)생성

```java
//Default 생성자로 객체 생성
        final User user1 = new User();
        //매개변수를 통해 객체 생성
        final User user2 = new User(2,"류지훈","기획");
```

1. User타입의 user객체 변수 생성
2. new 키워드를 통해 JVM RunTimeDataArea내의 Heap영역에 Instance를 저장할 메모리를 할당
3. User생성자를 통해 객체를 생성(초기화)
4. 생성자가 종료되면 new연산자는 객체의 **참조 값을 반환**한다.
5. user변수에 User객체의 **참조 값 할당**

## [4]static

* static으로 설정하면 같은 곳의 메모리 주소(동일한 참조 값)만을 가리키기 떄문에 static변수의 값을 공유하게 된다.
* 클래스 변수 라고도 부른다.
* 인스턴스화 하지 않고도 사용이 가능하다.(메모리를 공유하기 떄문)
* 해당 값을 변경하지 못하게 하기 위해서는 final키워드를 함께 사용해준다.

## [5]final

* 해당 Entity가 오직 한 번 할당 될 수 있음을 의미.
* 상속/변경을 금지하는 규제.
* final변수 : 해당 변수가 생성자나 대입 연산자를 통해 **한 번만 초기화 가능함**
* final메소드 : 해당 메소드를 @Override하거나 숨길 수 없음을 의미한다.
* final클래스 : 해당 클래스를 상속할 수 없음을 의미. 상속 계층 구조에서 마지막 클래스를 의미한다.
* 상수를 표현할 떄 static과 같이 사용한다.
* final키워드가 붙으면 해당 객체는 immutable이된다.

## *은닉화

클래스의 Field는 Private로 접근 재어지시자로 지정한 뒤 Getter,Setter를 통해 Filed의 값을 변경, 호출한다.
1.Getter:값을 호출
2.Setter:값을 변경

```java
public int getIdx(){
    return idx;
}
public void setIdx(final int idx){
    this.idx = idx;
}
public String getName(){
    return name;
}
public void setName(final String name){
    this.name = name;
}
public String getPart(){
    return part;
}
public void setPart(final String part){
    this.part = part;
}
```

## *접근 제어 지시자

![image](https://user-images.githubusercontent.com/57162257/106906315-62515f80-6740-11eb-9cf1-390d08005217.png)

# 2.Builder패턴

인스턴스를 생성하고자할때 파라미터를 받는 생성자에서는 정확한 위치와 순서를 고려해서 파라미터값을 넣어주어야한다.  
만약 데이터베이스를 모델링할때 100개의 필드값이 있다면 100개의 파라미터값을 정확한 순서로 집어넣어주어야 된다.

**Builder패턴**

* 생성자에 들어갈 매개변수를 차례대로 받아들이고 모든 매개변수를 받은 뒤에 이 변수들을 통합하여 한번에 사용한다.
* 데이터의 순서에 상관 없이 객체를 만든다.
* 사용자가 봤을 떄 명시적이고 명확하게 이해할 수 있어야 한다.
* 불필요한 생성자를 만들지 않고 객체를 만든다.



```java
public class UserBuilder{
    private int idx;
    private String name;
    private String part;
    
    public UserBuilder setIdx(final int idx){
        this.idx=idx;
        return this;
    }
    public UserBilder setName(final String name){
        this.name = name;
        return this;
    }
    public UserBuilder setPart(final String part){
        this.part = part;
        return this;
    }
    
    //User Builder
    //@return User객체
    public User build(){
        return new User(this.idx, this.name, this.part);
    }//User클래스에서 사용할수 있게 UserBilder클래스의 필드값들을 User클래스의 인스턴스 생성할수 있게 해준다.
}
```

# 2.인터페이스(interface)

인터페이스란 상수(static final)와 추상 메소드(abstract method)의 집합.

생성자를 가질 수 없어서 객체화가 불가능.

상수는 public static final, 추상메소드는 public abstract를 생략가능한데, 이것은 컴파일 시 자동으로 생성해주기 떄문.

인터페이스는 다중상속을 지원, 구현체에 여러개의 인터페이스를 구현할 수 있다.

## *네이밍 규칙

"~할 수 있는" 이라는 의미를 가지므로 **xxxable** 이런 형식으로 짓는다. 또는 **xxxImp1**과 같이 클래스 이름을 짓는다.

```java
public interface userInterface{
}
```



* 클래스들이 구현해야 하는 동작을 지정하는데 사용되는 추상형
* 규약, 규제
* 추상 클래스의 극단적인 경우
* 인터페이스도 상속이 가능하고, 클래스와 달리 다중 상속이 가능하다.
* 객체의 내부 구조를 알 필요 없이 인터페이스의 메소드만 알고 있으면 된다.
* 다형성을 이용한 인터페이스의 구현 객체를 손쉽게 교체할 수 있다.

## [1]상수 필드

```java
public interface Userinterface{
    public static final String DEPT = "컴퓨터공학부";
    int DEPTNO = 320;
}
```

* public static final 생략이 가능하다.

## [2]추상 메소드

```java
public interface Userinterface{
    public abstract void getInfo();
    String getDept();
}
```

* public abstract 생략이 가능하다.

## [3]디폴트 메소드

```java
public interface UserInterface{
    public default void setState(final boolean state){
        if(state){
            System.out.println("휴학중");
        }else{
            System.out.println("재학중");
        }
    }
}
```

* 메소드 내용까지 구현이 가능하다.
* 해당 인터페이스 구현시 디폴트 메소드를 override해서 사용할수 있다.
* public생략이 가능.

## [4]정적 메소드

```java
public interface UserInterface{
    public static void world(){
        System.out.println("World!");
    }
}
```

* public생략이 가능하다.

## *인터페이스 사용 이유

인터페이스를 구현하는 클래스들은 추상메소드를 오버라이딩 해야한다. 즉, 여러 클래스들이 동일한 이름을 갖는 메소드를 클래스에 따라 정의하여 사용하게된다.  결국 인터페이스는 **일종의 양식을 제공**하는 것. 그 양식에 따라 클래스들은 해당하는 항목의 조건에 따라 자유롭게 코드를 정의할수 있다.

개발할때 인터페이스는 **여러 개발자가 프로젝트를 진행할 때 통일성 있는 설계가 가능하게 해준다**. 또한 **구현한 클래스들에 따라서 하나의 인터페이스로 다양한 실행 결과를 얻을 수 있다**.(**다형성**)



# 3.상속(Inheritance)

* 객체지향의 재활용성을 극대화 시킨 프로그래밍 기법, 동시에 객체 지향을 복잡하게 하는 주요 원인.
* 부모 클래스의 내용을 자식 클래스가 물려 받는 것
* 하나의 부모 클래스는 여러 개의 자식 클래스를 가질 수 있지만, 하나의 자식 클래스는 오직 하나의 부모 클래스를 가져야 한다.
* 자식 클래스는 부모 클래스로부터 받은 메소드를 재정의 해서 사용할 수 있다.

```java
public class Student extends Person{
}
```

[예시]

```java
public class Person{
    private String name;
    public Person(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

public class Student extends Person{
    private String department;
    public Student(final String name,final String department){
        //부모클래스의 생성자 사용.
        super(name);
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.departmenrt = department;
    }
}

public static void main(String[] args){
    final Student student = new Student('이현종','컴퓨터공학부');
    //부모 클래스의 메소드
    System.out.println(student.getName());//이현종
    //자식 클래스의 메소드
    System.out.println(student.getDepartment());//컴퓨터공학부
}
```



# 4.제네릭(Generic)

* 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
* 다양한 타입의 객체들을 다루는 메소드나, 컬렉션 클래스에서 컴파일 시 타입 체크를 해주는 기능.
* 타입 안정성을 제공한다.
* 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.
* 컴파일 단계에서 오류를 찾을 수 있다.
* 중복 제거가 가능하다.

```java
public class DefaultRes<T>{
}
```

1. 각각의 인스턴스를 생성할 때 <> 사이에 어떤 데이터 타입을 사용했느냐에 따라 다르다.

   ```java
   public class DefaultRes<T>{
       private T responseData;
       public DefaultRes(final T responseData){
           this.responseData = responseData;
       }
   }
   
   DefaultRes<Student> defaultRes1 = new DefaultRes<(student);
   DefaultRes<User> defaultRes2 = new DefaultRes<>(user1);
   DefaultRes<User2> defaultRes3 = new DefaultRes<>(cowalwerPM);
   ```

2. 복수의 제네릭을 사용 가능(어떠한 문자도 사용할 수 있다.)

   ```java
   public class DefaultRes<T,S>{
       private T responseData;
       private S statusCode;
   }
   ```

3. 제네릭으로 올 수 있는 데이터 타입을 특정 클래스의 자식으로 한정할 수도 있다.

   ```java
   public class DefaultRes<T extends Person>{
       private T responseData;
   }
   ```

*제네릭과 인터페이스 활용 예

```java
public interface CRUDService<T>{
    DefaultRes<T> findOne(final int id) throws InternalServerError;
    DefaultRes<T> save(final T t) throws InternalServerError;
    DefaultRes<T> update (final int id, T t) throws InternalServerError;
    DefaultRes<T> delete (final int id) throws InternalServerError;
}
```



# 5.예외(Exception)

* 오류가 발생하지 않는 프로그램은 없다.
* 기능이 많아질수록 오류가 발생할 확률도 높아진다.
* 프로그램을 만든 개발자가 상정한 정상적인 처리에서 벗어나는 경우에 이를 처리하기 위한 방법

```java
try{
    ...
}catch(Exception e){
    //해당 에러 발생시 실행
}finally{
    //무조건실행
}
```

## *사용자 정의 예외

```java
public class InternalServerError extends Exception{
    private static final long serialVersionUID = 1L;
    public InternalServerError(final string msg){
        super(msg);
    }
}
```

예외 활용

```java
if(res.getStatusCode() == StatusCode.SERVICE_UNAVAILABLE){
    throw new InternalServerError("Remote Server Error");
}
```



# 6.어노테이션(annotation)

* Java 5에서 추가된 문법
* Java코드에 마치 주석 처럼 달아 특수한 의미를 부여한다.
* Compile Time, Run Time시에 해석될 수 있다.
* 자바,Spring이 제공해 주는 것도 있고, 사용자가 직접 만들 수도 있다.

## *사용자 정의 어노테이션

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth{
    
}
```

사용자 정의 Annotation(@Auth)

1. @Target : Annotation이 적용할 위치를 선택
   * PACAGE, TYPE, FIELD, METHOD..등
2. @Retention : Java Compile가 Annotation을 다루는 방법을 설정
   * 특정 시점까지 영향을 미치는 지를 결정
   * SOURCE(컴파일 전까지), CLASS(클래스 참조할 때 까지), RUNTIME(JVM에 의해 계속 참조 가능, Reflection사용)

# SpringBoot시작하기

# 7.Spring 소개

![image](https://user-images.githubusercontent.com/57162257/107146943-9de16900-698e-11eb-8fa3-83e0faf0e1f3.png)

1. POJO(Plain Old Java Object) : 평범한 옛날 자바 객체, 자바 객체
2. IOC(Inversion Of Control) : 제어의 역전, 컨테이너는 개발자 대신 객체의 생성부터 소멸까지 책임진다.
3. DI(Dependency Injection) : 의존성 주입
4. AOP(Aspect Oriented Programming) : 관점 지향 프로그래밍
5. PSA(Portable Service Abstraction) : 일관성 있는 서비스 추상화

![image](https://user-images.githubusercontent.com/57162257/107147163-e6e5ed00-698f-11eb-9bc4-c1f3b6167cf2.png)

1. Core : 스프링의 핵심, IoC기능이 구현된 BeanFactory제공
2. Context : 스프링의 기본, 스프링 기반에서 구현된 기능 객체들에 대한 접근 방법을 제공
3. DAO : JDBC에 대한 추상화 계층, 반복적인 코딩을 줄여주고, 트랜잭션 관리 기능도 제공
4. ORM : 객체와 관계 맵핑, ORM제품들을 스프링 기능과 조합해서 사용 가능
5. AOP : 관점 지향 프로그래밍 기능 제공
6. Web, Web MVC : MVC Web Application개발에 필요한 기본 기능 제공.

## [1]구성요소

1. pom.xml

   * Project Object Model
   * Maven이 해당 파일을 토대로 의존성 관리 및 배포까지 모든 것을 관리한다.
   * Spring boot는 pom.xml을 토대로 필요한 라이브러리나 프레임워크의 의존 관계를 설정을 자동으로 해준다.

2. resources

   * 자원 파일 저장
   * static : 웹 정적 리소스 저장 위치, (html,css,js,img)
   * templates : 웹 동적 리소스 저장 위치, (뷰 템플릿 저장 위치, FreeMarker, Groovy,Thymeleaf, JSP)
   * **application.properties** : Springboot의 기본 설정 파일
     spring boot가 Application시작 시 이곳의 설정들을 자동으로 반영해 준다.
     이곳에 DB정보, 서버 포트 번호 등 설정, 이럴 경우 반드시 git에 올리면 안된다.
   * 이곳에 Mapper(SQL)관련 파일이 저장될 예정

3. 프로젝트Application파일

   ![image](https://user-images.githubusercontent.com/57162257/107148087-b3f22800-6994-11eb-9a29-6d1c69d1ba3d.png)

   * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
   * @Configuration : 현재 클래스가 스프링의 설정 파일임을 Spring Context에게 알려주는 Annotation
   * @EnableAutoConfiguration : SpringBoot가 설정을 자동으로 하도록 하는 Annotation
   * @ComponentScan : 다른 컴포넌트, 서비스, 설정 등을 찾을 수 있게 도와주는 Annotation

4. ServletInitializer

   ![image](https://user-images.githubusercontent.com/57162257/107148481-a2118480-6996-11eb-882f-6bff3cf57a06.png)

   * packaging을 war로 설정할 시 자동 생성되는 클래스(Jar로 설정시 생성되지 않는다.)
   * WebApplicationInitializer Interface의 구현체
   * Tomcat같은 Servlet Container환경에서 SpringBootApplication이 동작 될 수 있도록 하는 Web Application Copntext를 구성한다는 의미


## [2]MVC

![image](https://user-images.githubusercontent.com/57162257/107182641-789d3b00-6a20-11eb-8bc7-5f4f7221833b.png)

* Model-View-Controller
* 사용자 인터페이스로부터 비즈니스 로직을 분리
* 애플리케이션을 세가지의 역할로 구분한 패턴
* Model : 정보(data), 데이터베이스
* View : 사용자 인터페이스, 프론트 엔드
* Controller : 데이터와 비즈니스 로직 사이의 상호작용 관리
  사용자가 접근한 URL에 따라 요청에 맞는 데이터를 Model로 처리를 위임하고, 데이터를 View에 반영해 사용자에게 알려준다.



![image](https://user-images.githubusercontent.com/57162257/107183353-09284b00-6a22-11eb-8080-e4259a1e9129.png)

1. 클라이언트의 요청에 대한 최초 진입 지점은 DispatcherServlet이 담당. 이 Servlet이 최초 진입 지점으로 다음의 작업을 처리하게 된다.
2. DispatcherServlet은 Spring Bean Definition에 설정되어 있는 Handler Mapping 정보를 참조하여 해당 요청을 처리하기 위한 Controller를 찾는다.
3. DispatcherServlet은 선택된 Controller를 호출하여 클아이언트가 요청한 작업을 처리한다.
4. Controller는 Business Layer와의 통신을 통하여 원하는 작업을 처리한 다음 요청에 대한 성공유무에 따라 ModelAndView인스턴스를 반환한다. ModelAndView클래스에는 UI Layer에서 사용할 Model데이터와 UI Layer로 사용할 View에 대한 정보가 포함되어 있다.
5. DispatcherServlet은 ModelAndView의 View의 이름이 논리적인 View정보이면 ViewResolver를 참조하여 이 논리적인 View정보를 실질적으로 처리해야할 View를 생성하기 된다.
6. DispatcherServlet은 ViewResolver를 통하여 전달된 View에게 ModelAndView를 전달하여 마지막으로 클라이언트에게 원하는 UI를 제공할 수 있도록 한다. 마지막으로 클라이언트에게 UI를 제공할 책임은 View클래스가 담당하게 된다.

## [3]Servlet

* Java를 사용하여 웹 페이지를 동적으로 생성하는 서버측 프로그램을 말한다.
* 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종.
* JSP와 비슷한 점이 있지만. JSP는 HTML에 Java코드를 포함하고있지만, Servlet은 Java코드에 HTML을 포함하고있음.
* 외부 요청마다 Thread로 응답한다.
* Java로 구현되기 떄문에 다양한 플랫폼에서 동작한다.

## [4]Web Container(Servlet Container)

* 웹 서버의 컴포넌트 중 하나로 Java Servlet과 상호작용 한다.
* 웹 컨테이너는 Servlet의 생명주기를 관리하고, URL과 특정 Servlet을 Mapping하여 URL요청이 올바른 접근 권한을 갖도록 한다.
* Servlet, JSP, Server Side Code가 포함된 다른 타입의 파일들에 대한 요청을 다룬다.
* Servlet객체를 생성하고, Servlet을 로드, 언로드하며 요청과 응답 객체를 생성, 관리하고 다른 Servlet관리 작업을 수행한다.

## [5]WAS

![image](https://user-images.githubusercontent.com/57162257/107184372-c8313600-6a23-11eb-9d5d-e697e42117d3.png)

1. Web Server로 부터 요청이 들어오면 Container가 이를 안맞게 처리한다.
2. Container는 web.xml(배포 서술자)를 참조하여 해당 서블릿에 대한 스레드를 생성하고 httpservletRequest 및 httpServletResponse객체를 생성하여 전달한다.
3. 다음으로 컨테이너는 서블릿을 호출(service())
4. 호출된 서블릿의 작업을 담당하게 된 스레드(미리 생성된 스레드)는 요청에 따라 doPost(), 또는 doGet()을 호출한다.
5. 호출된 doPost9),doGet()메소드는 생성된 동적 페이지를  Response객체에 실어서 컨테이너에 전달한다.
6. 컨테이너는 전달받은 Response객체를 HttpResponse형태로 전환하여 웹 서버에 전달하고 생성되었던 스레드를 종료하고, HttpservletRequest 및 httpservletResponse객체를 소멸시킨다.

# 8.Spring Presentation Layer

## [1]Controller

### @RestController

* REST를 위한 전용 Controller 기능을 부여하는 Annotation
* @RestController = @Controller + @ResponseBody
* 반환값을 JSON으로 변환해 준다.

### @Controller

* 템플릿을 이용해서 HTML페이지를 렌더링하고 표시해준다

### @ResponseBody 

* 반환값을 JSON으로 변환해 준다.

### @GetMapping

* Get메소드 전용 Controller Annotation
* 리소스를 조회하는 요청에 사용

### @RequestMappgin

* method, value를 구분시켜준다.
* @RequestMapping(method= RequestMethod.GET, value=""); 의 뜻은 httpMethod는 Get이고 URL Mapping은 ""이다.

### @PathVariable

* URL Mapping에 {}문법 추가

* public String getName(@PathVariable(value="name") final String name){ return name }

  만약 URL에 "/name/이현종"으로 들어오면 이현종이 name이라는 Parameter값으로 받아져 name이라는 String타입의 변수로 변환되게된다.

### @RequestParam

* QueryString을 받아올때 사용

* **/part?part=서버** 와 같은 형태

* ```java
  @GetMapping("/info")
  public String getPart(
      @RequestParam(value="name")final String name,
  	@RequestParam(value="type",defailtValue="yb")final String type
  ){
      return name+"이고 "+ type + "입니다."; 
  }
  ```

  value는 queryString의 key값
  defaultValue는 queryString값이 없을 경우의 기본값.
  ex) URL : **localhost:8080/info?name=이현종&type=ob**  => 이현종이고 ob입니다.

### @PostMapping

* Post메소드 전용 Controller Annotation
* 리소스를 생성하는 요청에 사용

### @RequestBody

* requestBody를 parameter로 객체를 받는 Annotation
* http Messsage본문을 자바 객체로 변환해준다(Mapping)
* Spring MVC내의 HttpMessageConverter가 변환을 처리해준다.
* 전송한 객체와 전송 받을 Controller의 객체 타입이 같아야 한다.
* 같지 않으면 값이 자동으로 채워지지 않고 기본값이 들어간다.

#### *Request Body객체 받는 순서

![image](https://user-images.githubusercontent.com/57162257/107192588-27497780-6a31-11eb-825b-bf37bb65abb3.png)

1. Default생성자를 통해 빈 객체가 생성된다.(**빈 생성자 필수!**)
2. 전송 받은 Http Message Body에 생성된 객체의 속성값이 있다면 Set Method를 통해 값이 채워진다.

### @PutMapping

* Put 메소드 전용 Controller Annotation

### @DeleteMapping

* Delet 메소드 전용 Controller Annotation

# 9.SpringBoot App 3가지 배포 방법

1. 내장 Tomcat이용
   1. Jar로 Build
   2. Maven명령어 이용
2. 다른 WAS(Tomcat)이용
   1. War로 Build



# 10.Spring

## [1]Architecture

![image](https://user-images.githubusercontent.com/57162257/107230018-ddc55080-6a61-11eb-80d9-b74754d0b2ac.png)

## [2]Spring IoC(Inversion of Control, 제어의 역전)

* 프로그램의 제어 흐름 구조가 바뀌는것
* 사용자가 객체를 생성하고 소멸시키는 것이 컨테이너가 대신 하게 된다.(제어의 역전)
* 이 제어권이 스프링 Container로 넘어가는 것이 Spring IoC다.
* 제어권이 Container로 넘어 감으로써 DI, AOP가 가능하다.
* 인스턴스의 생성부터 소멸까지의 객체(Bean) 생명주기를 Container가 관리하게 된다.

## [3]Spring DI(Dependency Injection, 의존성 주입)

* 인스턴스를 자신이 아닌 IoC Container에서 생성 후 주입한다.
* 내부적으로 new 키워드를 사용하지 않고 내부적으로 setter나 생성자를 이용한다.
* 기능이 변경 될 때마다 코드를 변경하는 것은 비용이 많이 들게 되므로 가급적 코드의 변화가 적어지도록 프로그램을 작성하기 위해 탄생
* 모듈간 결합도를 낮춰서 유연한 변경을 가능하도록 한다.
* 불 필요한 의존 관계를 없애거나 줄일 수 있다.
* 각 객체를 bean컨테이너로 관리한다.
* IoC를 구현하는 한 가지 방법이 DI이다.

## [4]Spring Container

* 컨테이너는 보통 인스턴스의 생명 주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하도록 한다.
* 작성한 코드의 처리과정을 위임 받은 독립적인 존재.
* 적절한 설정만 되어있다면 누구의 도움 없이도 프로그래머가 작성한 코드를 스스로 참조한 뒤 알아서 객체의 생성과 소멸을 컨트롤해준다.
* Spring Container는 IoC를 사용해 어플리케이션을 구성하는 빈/컴포넌트 들을 관리한다.
* Spring Container = IoC Container = DI Container
* Spring Container의 종류
  1. BeanFactory
     * DI의 기본사항을 제공하는 가장 단순한 컨테이너
     * 팩토리 패턴을 구현한 것
     * Bean을 생성하고 분배하는 책임을 지는 클래스
     * Bean의 정의는 즉시 로딩, 하지만 Bean 인스턴스 생성은 Lazy Loading한다.
     * 처음으로 getBean()이 호출된 시점에서야 해당 빈을 생성(Lazy Loading)
  2. ApplicationContext
     * BeanFactory인터페이스를 상속 받은 하위 인터페이스
     * BeanFactory와 유사한 기능을 제공하지만 좀 더 많은 기능을 제공한다.
     * 국제화가 지원되는 텍스트 메시지를 관리해준다.
     * 이미지같은 파일 자원을 로드 할 수 있는 포괄적인 방법을 제공한다.
     * Listener로 등록된 Bean에게 이벤트 발생을 알려준다.
     * Context초기화 시점에서 모든 싱글톤 Bean을 미리 로드한 후 어플리케이션 기동
* Spring Container 생명주기
  1. 생성
  2. 설정
  3. 사용
  4. 종료

## [5]Spring Bean

* 자바 객체
* 스프링 컨테이너에 의해서 만들어지고 관리되면 Spring Bean
* 다양한 Annotation으로 스프링 컨테이너에 Bean을 등록한다.
* 사용자가 직접 컨트롤 하지 않고 컨테이너가 Bean을 주입해준다.

## [6]POJO

* 우리가 매일 사용하는 자바 객체(getter, setter가 있는 그것)
* 스프링을 모두 제거해도 POGO는 작동을 해야 하는 것이 스프링의 철학

## [7]Spring Life Cycle

![image](https://user-images.githubusercontent.com/57162257/107232651-fe42da00-6a64-11eb-9aaa-ea97a1ad9710.png)



# 11.Lombok

* IDEA와 Build도구에 자동으로 연결되는 Java라이브러리
* Model을 만들고 각 멤버 변수와 관련된 Method를 자동으로 만들어준다
* 다양한 Annotation을 사용해 코드가 간결해 진다.
* AnnotationProcessor를 이용해 Compile시점에 코드를 생성해준다.
* 라이브러리를 도입하기 전엔 항상 모든 팀원 간의 합의가 있어야한다.

## [1]@Data

* 모든 멤버 변수의 생성자 및 접근자, toString,equals, hashCode등 모든 메소드 자동 생성.

* 만능 Annotation이지만 사용하지 않는 메소드까지 만들어 주므로 사용시 고민할 필요가 있음.

* Builder클래스까지는 자동으로 만들어주지않음.

  ```java
  @Data
  public class TestData{
      private int userIdx;
      private String name;
      private String email;
  }
  ```

  ![image](https://user-images.githubusercontent.com/57162257/107236102-b756e380-6a68-11eb-8a2b-d920cf75ee0a.png)

  

## [2]@Getter & @Setter

* @Setter : 필드에 대해 자동으로 Setter메소드를 만들어 준다.
* @Getter : 필드에 대해 자동으로 Getter메소드를 만들어 준다.

## [3]@NoArgsConstructor

* Default 생성자 자동 생성
* 같은 기능의 생성자가 이미 존재할 경우 Compile Error

## [4]@AllArgsConstructor

* 모든 필드에 대한 생성자 자동 생성

## [5]@NonNull

* 클래스가 아닌 필드에 붙이는 Annotation
* RunTime시에 Null체크를 통해 NullPointerException발생(실행시켰을떄)
* Compile시에는 Null체크하지 않는다.

## [6]@RequireArgsConstructor

* @NonNull 이나 final 키워드가 붙여진 필드의 생성자 자동 생성

## [7]@Builder

* 자동으로 Builder클래스 및 메소드 생성
  ![image](https://user-images.githubusercontent.com/57162257/107238356-17e72000-6a6b-11eb-8f06-d1846348fe1e.png)

  ![image](https://user-images.githubusercontent.com/57162257/107238669-76ac9980-6a6b-11eb-9beb-3a867f7f3811.png)

  

## [8]@Value

* Immutable Class로 만드는 Annotation
* 모든 필드 값 private final
* Getter메소드는 생성하지만 Setter메소드는 생성하지 않는다.
* 해당 클래스는 더 이상 상속이 불가능.





# *서치

## Array &  List

[https://velog.io/@adam2/Array%EC%99%80-List%EA%B7%B8%EB%A6%AC%EA%B3%A0-Java-List]

### Array

* index로 해당 원소에 접근가능
* 연속된 메모리의 공간으로 이루어짐
* **장점 :** 인덱스를 통한 검색이 용이함, 연속적이므로 메모리 관리가 편하다.
* **단점 :** 크기가 고정되어있기때문에 삭제되면 상태를 빈 공간으로 남겨야함(메모리 낭비), 정적이므로 배열의 크기를 컴파일 이전에 정해주어야함.
* **데이터의 크기가 정해져있고, 추가적인 삽입 삭제가 일어나지 않으며 검색을 필요로 할때 유리**

### List

* 순서가 있는 엘리먼트의 모임으로 배열과는 다르게 빈 엘리먼트는 절대 허용하지않는다.
* 리스트의 index는 몇 번째 데이터인가 정도(순서)의 의미를 가짐
* 포인터를 통한 접근
* **장점 :** 포인터를 통해 다음 데이터의 위치를 가르키고 있어 삽입 삭제의 용이, 동적이므로 크기가 정해져있지 않음, 메모리의 재사용 편리
* **단점 :** 검색기능이 좋지않음, 포인터를 통해 다음 데이터를 가르키므로 추가적인 메모리 공간 발생
* **데이터의 크기가 정해져있지 않고, 삽입 삭제가 많이 일어나며, 검색이 적은 경우**

### ArrayList

* Array와 ArrayList는 인덱스로 객체를 관리한다는 점에서 동일하지만, 크기를 동적으로 늘릴수 있다.
* 설정한 저장 용량을 넘어서 더 많은 객체가 들어오면, 배열 크기를 1.5배로 증가시킴.
* 중간위치의 객체에 변화가있을때 뒤에 있는 객체들의 위치가 한꺼번에 움직이게됨.
* Array는 primitive type(int, byte, char 등)과 object를 담을수 있지만, ArrayList는 object element만 담을 수 있다.
* 길이에 대해 size() 메소드 사용.
* **장점 :** 데이터를 검색할떄 매우 빠름
* **단점 :** 저장 용량을 늘리는데 많은 시간이 소요, 저장된 데이터를 삭제하는 데도 많은 시간이 소요 
* **잦은 원소의 이동, 삭제가 발생할 경우 ArrayList보다 LinkedList를 사용하는 것이 좋음.**
  ![image](https://user-images.githubusercontent.com/57162257/107219035-d8f9a000-6a53-11eb-97b7-2fc7d6107568.png)

### LinkedList

* 노드 간에 연결을 통해서 리스트로 구현된 객체.
* 다음 노드의 위치 정보만 가지고 있으며 인덱스를 가지고 있지 않기 때문에 탐색시, 순차접근만 가능(노드 탐색 시 시간이 많이 소요됨)
* 추가/삭제는 위치정보의 수정만으로 가능하기 떄문에 성능이 좋음.
* **장점 :** 저장 용량을 늘리는 과정이 간단, 저장된 데이터를 삭제하는 과정도 매우 간단.
* **단점 :** 데이터를 검색할 때 매우 느림 

![image](https://user-images.githubusercontent.com/57162257/107219202-18c08780-6a54-11eb-8966-77df1c7b0e6f.png)

![image](https://user-images.githubusercontent.com/57162257/107219277-3130a200-6a54-11eb-8760-db93041755f2.png)

### 메소드

* add : element
* get : index
* set : index,element
* remove : index



## WebServer

* 웹 서버는 웹 브라우저 클라이언트로부터 HTTP요청을 받아 정적인 컨첸츠(.html .jpeg .css등)를 제공하는 컴퓨터 프프로그램
* WAP을 사용하지않고 WebServer만 사용하면 WAP을 사용하는것보다 더 빠르고 효율적으로 정적인 데이터를 받을수 있다.

## WAS

![image](https://user-images.githubusercontent.com/57162257/107148672-db96bf80-6997-11eb-9232-b8fd10b52084.png)

* WAS(Web Application Service) = Web Server + Web Container
* WAS는 DB조회나 다양한 로직 처리를 요구하는 동적인 컨텐츠를 제공하기 위해 만들어진 Appliocation Server
* 톰캣은 webserver(정적 data처리)에서 넘어온 동적인 페이지를 읽고 프로그래밍을 실행하고 결과를 html로 재구성해서 webServer(apach)로 돌려준다

## TomCat

* Apache소프트웨어 재단에서 개발한 Servlet Container(Web Container)만 있는 Web Application Server이다. = WAS
* Web Server와 연동하여 실행할 수 있는 자바 환경을 제공한다.
* Servlet이나 JSP를 실행하기 위한 Servlet Container을 제공한다.
* 정적 컨텐츠를 로딩 하는데 웹 서버보다 수행 속도가 느리다.



## 영속성(Persistence)

* 데이터를 생성한 프로그램이 종료되더라도 사라지지 않는 데이터의 특성을 말함.
* 영속성을 갖지 않는 데이터는 단지 메모리에서만 존재하기 떄문에 프로그램이 종료되면 모두 잃어버리게 된다. 때문에 파일 시스템,관계형 데이터베이스, 혹은 객체 데이터베이스 등을 활용하여 데이터를 영구적으로 저장하여 영속성을 부여함.

## SQL Mapper

* SQL Mapper는 SQL문장으로 직접 데이터베이스를 다룬다.
* MyBatis, jdbcTemplates 등..

## ORM

* 데이터베이스 객체를 자바 객체로 매핑함으로써 객체 간의 관계를 바탕으로 SQL을 자동으로 생성.
* Persistence(영속성) API라고도 할수있음.
* JPA, Hibernate등

## JDBC(Java Database Connectivity)

* JDBC는 DB에 접근할 수 있도록 Java에서 제공하는 API이다. ㅁ보든 Java Data Access기술의 근간으로 모든 Persistence Framework는 내부적으로 JDBC API를 사용한다.
  ![image](https://user-images.githubusercontent.com/57162257/107179473-e5f99d80-6a19-11eb-8634-0c48f386e8d9.png)

## JPA(Java Persistent API)

![image-20210208142915108](C:\Users\leehyunjong\AppData\Roaming\Typora\typora-user-images\image-20210208142915108.png)

* 자바 ORM기술에 대한 API표준 명세로 Java에서 제공하는 API
* 사용자가 원하는 JPA구현체(Hibernate 등)를 선택해서 사용할수 있다.

## Mybatis

![image-20210208143047774](C:\Users\leehyunjong\AppData\Roaming\Typora\typora-user-images\image-20210208143047774.png)

* 개발자가 지정한 SQL, 저장 프로시저 그리고 몇 가지 고급 매핑을 지원하는 SQL Mapper.
* mybastis의 장점은 SQL에 대한 모든 컨트롤을 하고자 할 때 매우 적합하다, SQL쿼리들의 최적화가 잘되어 있을떄 유용하다.
* 단점은 애플리케이션과 데이터베이스 간의 설계에 대한 모든 조작을 하고자 할 때는 적합하지 않다. 왜냐면 애플리케이션과 데이터베이스의 구조화가 잘 되도록 많은 설정부분을 바꾸어야 하기 때문이다.