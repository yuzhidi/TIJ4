package typeinfo;

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static net.mindview.util.Print.*;

class Candy {
  static { print("Loading Candy"); }
}

class Gum {
  static { print("Loading Gum"); }
  static void printf() {
	  print("Gum printf()");
  }
}

class Cookie {
  static { print("Loading Cookie"); }

}

public class SweetShop {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {	
    print("inside main");
    new Candy();
    print("After creating Candy");
    try {
      Class a = Class.forName("typeinfo.Gum");
      Object b = a.newInstance();
      ((Gum)b).printf();
    } catch(ClassNotFoundException e) {
      print("Couldn't find Gum");
    }
    print("After Class.forName(\"Gum\")");
    new Cookie();
    print("After creating Cookie");
  }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
