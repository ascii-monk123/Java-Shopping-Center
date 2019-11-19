import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.nio.Buffer;
import java.util.Scanner;
import java.io.*;
public class Main {
   static Scanner sc=new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        String username;
        String password;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nWelcome to the clothing shop\n");
        System.out.println("Enter your name\n");
        username = reader.readLine();
        System.out.println("Enter the password\n");
        password = reader.readLine();
        BufferedReader r = new BufferedReader(new FileReader("src/login.txt"));
        String lines;
        int ind = 0;
        while ((lines = r.readLine()) != null) {
            if(ind==0) {
                if (!username.equals(lines)) {
                    System.out.println("\nInvalid username\n");
                    return;
                }
            }
                else if(ind==1){
                    if(!password.equals(lines)){
                        System.out.println("\nInvalid password\n");
                        return;
                    }
                }
            ind++;
            }


        System.out.println("\nAuthentication Confirmed\n");
      int  idIndex=0;
        int choice;
        boolean flag=true;
      outermost:  while(flag==true) {
            System.out.println("\nEnter your name customer none to exit the programme\n");
          double total=0;
            String name = reader.readLine();
            if(name.equalsIgnoreCase("NONE")){
                flag=false;
                continue outermost;


            }
            String id = null;
            FileReader f = new FileReader("src/ids.txt");
            BufferedReader b = new BufferedReader(f);
            int i = 0;
            String custId;
            while ((custId = b.readLine()) != null) {
                if (i == idIndex) {
                    id = custId;
                    idIndex++;
                    break;
                }
                i++;
            }
            Clothing c = new Clothing(name, id);
            FileWriter fs = new FileWriter("src/admin.txt", true);
            BufferedWriter bs = new BufferedWriter(fs);
            bs.write("****************************\n" + "Customer Name : " + "  " + c.name + "\n" + "Customer id: " + "  " + c.id + "\n" + "Order Summary : " + "  " + "***************\n");
            bs.close();
            int numberOfChoices = 0;
            boolean cont = true;
            try{
            outer:
            while (cont && numberOfChoices <= 20) {

                System.out.println("Which type of clothes do you want \n");
                String type = reader.readLine();
                if (type.equals("none")) {
                    cont = false;
                    try {
                        FileWriter frTotal = new FileWriter("src/admin.txt",true);
                        BufferedWriter bTotal=new BufferedWriter(frTotal);
                        bTotal.write("Your total bills is :"+" "+total+"\n");
                        bTotal.write("GST : 15%\n");
                        double newTotal=total+total*15/100;
                        bTotal.write("Your bill after calculating the GST is "+newTotal+"\n");
                        bTotal.write("\n\n");
                        bTotal.close();

                    }catch(IOException e){
                        System.out.println(e);
                    }
                    continue outer;
                }

                FileReader fr = new FileReader("src/" + type + ".txt");
                b = new BufferedReader(fr);
                String ids;
                System.out.println("Enter what item do you want\n");
                String itemName = reader.readLine();
                inner:
                while ((ids = b.readLine()) != null) {
                    String arr[] = new String[4];
                    arr = ids.split(" ");
                    for (String ele : arr) {
                        if (itemName.equalsIgnoreCase(ele)) {
                            System.out.println("Enter the items quantity");
                            double quant = sc.nextDouble();

                               total+=quant*Double.parseDouble(arr[3]);
                            c.getItems(type.toLowerCase(), arr[0], arr[1], quant, Double.parseDouble(arr[3]));
                            break inner;
                        }
                    }


                }
                b.close();

            }
        }
            catch(IOException E){
                System.out.println(E);
            }
              }








        }


    }






