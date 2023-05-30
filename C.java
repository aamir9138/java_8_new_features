// Case 1
//@FunctionalInterface
//interface p
//{
//    public void m1();
//}
//
//@FunctionalInterface
//interface c extends p
//{
//}

// Case 2
//@FunctionalInterface
//interface p
//{
//    public void m1();
//}
//
//@FunctionalInterface
//interface c extends p
//{
//    public void m1();
//}


// Case 3
//@FunctionalInterface
//interface p
//{
//    public void m1();
//}
//
//@FunctionalInterface
//interface c extends p
//{
//    public void m2();
//}

// Case 4
@FunctionalInterface
interface p
{
    public void m1();
}

interface c extends p
{
    public void m2();
}