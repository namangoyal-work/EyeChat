
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

class Ex {
 public static void main(String args[]) throws Exception {
  {
   String fromClient;
   ServerSocket server = new ServerSocket(8960);
   Socket client = server.accept();
   BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));


   JFrame f = new JFrame("Label Example");
   JLabel[][] labels;
   f.setSize(800, 800);

   String c[][] = {
    {
     "END",
     "E",
     "K",
     "Q",
     "W",
     "3",
     "9"
    },
    {
     "SPACE",
     "F",
     "L",
     "R",
     "X",
     "4",
     "0"
    },
    {
     "A",
     "G",
     "M",
     "S",
     "Y",
     "5",
     ""
    },
    {
     "B",
     "H",
     "N",
     "T",
     "Z",
     "6",
     ""
    },
    {
     "C",
     "I",
     "O",
     "U",
     "1",
     "7",
     ""
    },
    {
     "D",
     "J",
     "P",
     "V",
     "2",
     "8",
     ""
    }
   };
   String str = "Text Entered: ";

   int x = 100, y = 100;
   labels = new JLabel[6][7];
   for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 7; ++j) {
     labels[i][j] = new JLabel(c[i][j]);
     labels[i][j].setOpaque(true);
     labels[i][j].setBounds(x * (j + 1), y * (i + 1), 50, 50);
     f.add(labels[i][j]);
    }
   }

   JLabel txt = new JLabel(str);
   txt.setOpaque(true);
   txt.setBounds(20, 0, 200, 50);
   f.add(txt);

   f.setLayout(null);
   f.setVisible(true);
   int closed, opened, closedin, openedin, k;
   long n1;

   
   long n = System.currentTimeMillis();
   while (System.currentTimeMillis() - n < 5000); //wait for 5 seconds then remove all labels
   for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 7; ++j) {
     labels[i][j].setVisible(false);
    }
   }

   int index = 0;
   boolean flag=true;

   while (flag) {
    closed = 0;
    opened = 0;

    for (int i = 0; i < 6; ++i)
     labels[i][index].setVisible(true);

    n = System.currentTimeMillis();
    while (System.currentTimeMillis() - n < 2000) {
      fromClient = inFromClient.readLine();
     if (fromClient.equals("Close")) {
      closed = 1;
      opened = 0;
      n1 = System.currentTimeMillis();
      fromClient = inFromClient.readLine();
      while (System.currentTimeMillis() - n1 < 1000) {
       if (fromClient.equals("Close"))
        closed++;
       if (fromClient.equals("Open"))
        opened++;
      }

     }

    }

    for (int i = 0; i < 6; ++i)
     labels[i][index].setVisible(false);

      System.out.println("closed:"+closed);
      System.out.println("opened:"+opened);

    if (closed > opened) {
     closedin = 0;
     openedin = 0;
     for (k = 0; k < 6; ++k) {
      labels[k][index].setVisible(true);
      n = System.currentTimeMillis();

      while (System.currentTimeMillis() - n < 2000) {
        fromClient = inFromClient.readLine();

       if (fromClient.equals("Close")) {
        closedin = 1;
        openedin = 0;
        n1 = System.currentTimeMillis();
        while (System.currentTimeMillis() - n1 < 1000) {
          fromClient = inFromClient.readLine();
          System.out.println(fromClient);
         if (fromClient.equals("Close"))
          closedin++;
         if (fromClient.equals("Open"))
          openedin++;
        }

       }

      }

      System.out.println("closedin:"+closedin);
      System.out.println("openedin:"+openedin);

      if (closedin > openedin) {
       System.out.println(c[k][index]);
       if(c[k][index].equals("SPACE"))
       {
        str=str+" ";
      }
        else if(c[k][index].equals("END"))
        {
          flag=false; 
        }
        else
        {
       str = str + c[k][index];
        }
       txt.setText(str);
       f.add(txt);
       labels[k][index].setVisible(false);
       break;
      }

      labels[k][index].setVisible(false);
     }
    }

    n = System.currentTimeMillis();
    while (System.currentTimeMillis() - n < 2000);

    index++;
    if (index == 7)
     index = 0;
   }
  }
 }
}
