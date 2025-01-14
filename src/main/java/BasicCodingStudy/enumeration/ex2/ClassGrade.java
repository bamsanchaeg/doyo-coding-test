package BasicCodingStudy.enumeration.ex2;

public class ClassGrade {

    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    //여기 안의 이 상수만 사용하라는 이야기
    private ClassGrade(){};
}
