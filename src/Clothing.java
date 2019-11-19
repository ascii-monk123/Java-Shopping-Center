import java.io.*;

import static java.lang.System.exit;

public class Clothing {
    String name;
    String id;
    float bill;
    Clothing(String name,String id){
        if(id==null){
            System.out.println("Sorry the id cant be generated");
            System.out.println("The number of customers have exceeded the length\n");
            exit(0);
        }
        this.name=name;
        this.id=id;
        System.out.println(this.name+" "+this.id);
    }
    void getItems(String type,String id,String name,double qty,double price) {
       switch(type){
           case "kids":
               double bill=qty*price;
               try {
                   FileWriter f = new FileWriter("src/admin.txt",true);
                   BufferedWriter out =new BufferedWriter(f);


                   out.write("Type : "+" "+type+"/ "+"UserName : "+" "+this.name+"/ "+"Id : "+" "+this.id+"/ "+"Quantity : "+" "+qty+"/ "+"Price : "+" "+price+"/ "+"Itemname "+" "+name+"/ "+"Bill: "+bill+"\n");
              out.close();
               }
               catch(IOException e){
                   System.out.println(e);
               }
               break;

           case "ladies":
               System.out.println("eNTERER LDIES");
               double bill2=qty*price;
               try {
                   FileWriter f = new FileWriter("src/admin.txt",true);
                   BufferedWriter out =new BufferedWriter(f);


                   out.write("Type : "+" "+type+"/ "+"UserName : "+" "+this.name+"/ "+"Id : "+" "+this.id+"/ "+"Quantity : "+" "+qty+"/ "+"Price : "+" "+price+"/ "+"Itemname "+" "+name+"/ "+"Bill: "+bill2+"\n");
                   out.close();
               }
               catch(IOException e){
                   System.out.println(e);
               }
               break;
           case "gents":
               double bill3=qty*price;
               try {
                   FileWriter f = new FileWriter("src/admin.txt",true);
                   BufferedWriter out =new BufferedWriter(f);


                   out.write("Type : "+" "+type+"/ "+"UserName : "+" "+this.name+"/ "+"Id : "+" "+this.id+"/ "+"Quantity : "+" "+qty+"/ "+"Price : "+" "+price+"/ "+"Itemname "+" "+name+"/ "+"Bill: "+bill3+"\n");
                   out.close();
               }
               catch(IOException e){
                   System.out.println(e);
               }
               break;




           default:
               System.out.println("\n Invalid type please enter again");
           return;

    }


    }

}
