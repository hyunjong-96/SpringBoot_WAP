package org.sopt.seminar3.lombok;

public class Main {
    public static void main(String... args){
        Test test = new Test();
        TestData testData = new TestData();
        TestBuilder.TestBuilderBuilder builder = new TestBuilder.TestBuilderBuilder();
        TestBuilder.builder()
                .userIdx(1)
                .name("이현종")
                .email("ahajongs@naver.com")
                .build();

        TestValue testValue = new TestValue(0,"이현종","ahajongs");
        TestValue testValue1 = testValue.withUserIdx(1);
        System.out.println("testValue: "+testValue.getUserIdx());
        System.out.println("testValue_name: "+testValue1.getName());
        System.out.println("testValue1: "+testValue1.getUserIdx());
        System.out.println("testValue1_name: "+testValue1.getName());
    }
}
