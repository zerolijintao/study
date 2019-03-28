package enums;

public enum TestConstruction {

    RED(1,"red color"),
    BLUE(2, "blue color"),
    ERROR(3, null);

    private int code;
    private String desc;

    TestConstruction(int i, String s) {
        this.code = i;
        this.desc = s;
    }

    public String getDesc() {
        return desc;
    }

    public void print() {
        if (TestConstruction.RED.name().equals(this.name())) {
            System.out.println("red");
        } else if (TestConstruction.BLUE.name().endsWith(this.name())) {
            System.out.println("bule");
        } else {
            System.out.println("error");
        }
    }


    public static void main(String[] args) {
        System.out.println(TestConstruction.RED.getDesc());
        TestConstruction.RED.print();
        TestConstruction.BLUE.print();

        try
        {
            if (TestConstruction.ERROR.getDesc() != null)
                System.out.println("a");
            else
                throw new NullPointerException();
        }
        catch (Exception e)
        {
            System.out.println("Some Error" + e.getMessage());
            System.out.println(e);
        }
    }
}
