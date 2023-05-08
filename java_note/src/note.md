# 21. 리터럴

* int의 리터럴 : 없음
* long의 리터럴 : L 혹은 l (가독성을 위해 되도록 L 사용)
  * 생략 가능
  * 하지만 int의 범위보다 큰 수일 때 생략하면 컴파일 요류
```java
int num1 = 1234;
long num2 = 1234567890L;
long num3 = 987654321;
long num4 = 1234567345345890; // 컴파일 오류
```

* null
  * 참조형에 사용 가능한 리터럴
  * 의미 : 참조하는 대상이 없음 (c의 널 포인터)
* _
  * 큰 숫자의 가독성을 높이기 위해 사용 (쉼표 찍듯이)
  * java 7 부터 사용 가능
```java
String msg = null;
int num = 12_345_678;
float pi = 3.14_15F;
long hexNum = 0xFF_EC_DE_5E;
```

# 22. final 키워드
* java는 const 대신 final 키워드 사용
* 변수 값 변경을 금지
* final 키워드를 붙일 수 있는 곳
  1. 지역 번수
  2. 클래스 멤버변수
  3. 메서드 매개변수
  4. 클래스와 메서드
* java의 경우 static을 붙일 수 있음
* 메서드 매개변수의 값 변경을 막을 수 있음
* 메서드 안에서 인자 값을 변경할 수 없음

```java
public class StudentManager {
    public final int MAX_STUDENT = 10;
    public static final int MAX_CLASS = 7;
    public int add(final op1, final float op2) {
        op1 += 1; // 컴파일 오류 
    }
}
```

* final 변수의 초기화 1: 선언과 동시에
```java
public class StudentManager {
    // 멤버변수
    public final int MAX_STUDENT = 10;
    public void printScores() {
        // 지역 변수
        final int MAX_CLASS = 5;
    }
}
```
* final 변수의 초기화 2: 사용하기 전에만
* final은 선언 후에 초기화 가능
* 지역 변수일 경우 실제로 그 final 변수를 사용하기 전에만 초기화해주면 됨
```java
public class StudentManager {
  public void printScores() {
    final int MAX_CLASS;

    MAX_CLASS = 5;
    System.out.printf("%d", MAX_CLASS)
  }
}
```
* 멤버 변수일 경우
  * 생성자에서 초기화 가능
  * 그 외의 메서드에서 초기화 할 경우 컴파일 오류가 발생
  * 초기화 해주는 메서드가 해당 변수가 사용되기 전에 실행되는지 컴파일러는 알 수 없기 때문
```java
public class StudentManager {
    final int MAX_STUDENT;
    
    public void printScores() {
        MAX_STUDENT = 10; // 컴파일 오류
    }
}
```
* final 변수 초기화 예
```java
public class StudentManager {
    final int MAX_STUDENT;
    // 지역 변수
    public void pirntScores() {
        final int MAX_CLASS;
        MAX_CLASS = 5;
        System.out.printf("%d", MAX_CLASS);
    }
    // 생성자에서 초기화
    public StudentManager() {
        MAX_STUDENT = 10;
    }
}
```

# 23. 주석, 연산자 우선순위, 산술 연산자
* javadoc 주석 예
```java
public class Ex {
  /**
   * Returns the greater of two int values
   * @param num1 an argument
   * @param num2 another argument
   * @return the larger of num1 and num2
   */
  public int max(int num1, int num2) {
    return num1> num2 ? num1 : num2
  }
}
```

# 24. 대입 연산자, 논리 연산자, 캐스팅
* java에서도 자료형 간의 변환(casting)이 가능
* 클래스 역시 가능!
```java
class Ex {
    // 암시적 캐스팅
    int i = 10;
    long l = i;
    float f = l;
    double d = f;
    
    // 명시적 캐스팅
    double d2 = 12324.985645;
    float f2 = (float) d2;
    long l2 = (long) f2;
    int i2 = (int) l2;
}
```

* java도 short circuit평가를 한다

# 25. 문자열 비교
```java
class Ex {
    String name1 = "Nana";
    String name2 = "Nana";
    String name3 = new String(name1);
    String name4 = new String("Nana");
    
    boolean isSame1 = (name1 == name2); // true
    boolean isSame2 = (name1 == name3); // false
    boolean isSame3 = (name1 == name4); // false
    boolean isSame4 = (name1 == "Nana");// true
}
```
* case 1 : 주소를 공유하는 경우
  * String을 new로 생성하지 않은 경우
  * 보다 자세한 내용은 'string constant pool', 'string pool' 검색
* 문자열 자체 비교를 위해서는 equals() 메서드를 사용해야 한다.
```java
class Ex {
    boolean isSame1 = name1.equals(name2);
    boolean isSame2 = name1.equals(name3);
    boolean isSame3 = name1.equals(name4);
    boolean isSame4 = name1.equals("Nana");
}
```

# 28. 참조형 인자, 열거형
* 1차원 배열
```java
class Ex {
  int[] nums = new int[5]; // 이 방법이 좀 더 흔함
  int scores[] = new int[20];
}
```
* 다차원 배열
```java
class Ex {
    int[][] checkerboard = new int[8][8];
}
```

* java의 열거형
* 열거형은 독자적 또는 클래스 내부에 선언할 수 있음
* java의 열거형은 클래스형
  * 멤버 변수와 메서드를 가질 수 있음
  * 그러나 그냥 데이터로만 사용할 것 (추천)
```java
public enum Subject {
  KOREAN,
  ENGLISH,
  MATH;
}

public class SchoolManager {
    public enum Subject {
      KOREAN,
      ENGLISH,
      MATH;
    }
}
```
