public class Static {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "GHRCCST";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "GHRCE";

        // System.out.println(s1.schoolName);
        // System.out.println(s2.schoolName);
        // System.out.println(s3.schoolName);
        int per = s1.returnPercentage(90, 90, 90);
        System.out.println(per);
    }
}

class Student {
    static int returnPercentage(int math, int phy, int chem) {
        return (math + phy + chem)/3;
    }

    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}