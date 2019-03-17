/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith(
        List_inArraySlots list
      , String prefix
      ) {
        String result = "";

        for( int el = 0; el < list.size(); el++){
          if(list.get(el) instanceof String){
            String stringElem = (String) list.get(el);
            if(stringElem.startsWith(prefix)){
              result += stringElem;
          }
          //if(((String)list.get(el)).startsWith(prefix))
            //result += // dummy for incremental development
                 //     list.get( el) + " ";
          }
      }

            /* 3.  Stumbling block 0
               Java protects a programmer against applying a method to
               elements in list when some elements of the list might
               omit support for a particular operation.

               This protection is implemented by the compiler.
               The following code violates the restriction:
              */
            // [code that violates the restriction]
            //System.out.println(list.get(el).indexOf("hello"));
             //}
            /*
             predicted error message:
             Cannot find method in Object class
             actual error message:
             Accumulator.java:32: error: cannot find symbol
            System.out.println(list.get(el).indexOf("hello"));
                                           ^
              symbol:   method indexOf(String)
              location: class Object
             */
            

            /* 4.  Workaround 0
               A programmer should expect there to be a way to
               work around the stumbling block, because
               the compiler
               knows the type of an element.

               Java's instanceof operator identifies the type
               of an element to the JVM.
             */


            /* 5.  Stumbling block 1
               However, use of the operator alone is insufficient,
               because the compiler
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            // [code that illustrates the use of the operator]
            //if(list.get(el) instanceof String) System.out.println(list.get(0).indexOf("Hello"));
            //}

            /*
             predicted error message:
             Cannot find method in Object class
             actual error message:
             Accumulator.java:65: error: cannot find symbol
            if(list.get(el) instanceof String) System.out.println(list.get(0).indexOf("Hello"));
                                                                             ^
            symbol:   method indexOf(String)
            location: class Object
             */


            /* 6. Workaround 1
               Programmers use Java's (type) operator
               to tell the compiler
               that code uses a subclass's method on an object,
               even though the reference to the object is stored
               in a super-class variable.
             */


            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the JVM
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            //{
              //String stringElem = (String) list.get(el);
              //if(stringElem.startsWith(prefix)){
                //result += stringElem;
              //}
            /*
             predicted error message:
             Cannot cast String onto different value types
             actual error message:
             Exception in thread "main" java.lang.ClassCastException: class java.lang.Double cannot be cast to class java.lang.String (java.lang.Double and java.lang.String are in module java.base of loader 'bootstrap')
             at Accumulator.catElementsStartingWith(Accumulator.java:20)
	           at UserOfList.main(UserOfList.java:32)
             */


            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */

            // [working code here, finally]
            /*
              if(list.get(el) instanceof String) String stringElem = (String) list.get(el);
              if(stringElem.startsWith(prefix)){
              result += stringElem;
          }
            */

        return result;
    }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites(
        List_inArraySlots list
      ) {
        List_inArraySlots result = new List_inArraySlots();
        for( int el = 0; el < list.size(); el++){
        if(list.get(el) instanceof Double){
          double doubleElement = (double) list.get(el);
            if(Double.isFinite(doubleElement))result.add(list.get(el));
        }
      }
        return result;
    }
}
