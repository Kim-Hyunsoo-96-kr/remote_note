package academy.pocu;
public class Note {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
    }
}

/** 패키지 이름 짓기
 * 패키지 이름의 중복을 최소화해야 함
 * 그래서 보통 회사의 도메인명을 패키지 이름에 사용 (단, 역순으로)
 *      ex) 담성(damsung.com)이라는 회사에서 패키지를 만들 경우 -> package com.damsung.<패키지 이름>;
 *      ex) POCU 아카데미(pocu.academy)에서 패키지를 만들 경우 -> package academy.pocu.<패키지 이름>;
 * java의 경우 패키지명과 똑같은 폴더 트리에 .java 파일을 넣어야 함
 *      ex) src/academy/pocu/Note.java
 */