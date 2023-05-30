interface Interf2
{
    void m1();
}
class Demo implements Interf2
{
    @Override
    public void m1() {
        System.out.println("m1() method implementation");
    }
}

class WithoutLambda {
    public static void main(String[] args)
    {
        Interf2 i = new Demo();
        i.m1();
    }
}
