
package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class Conversion {
    void convertETM(String message)
    {
        try {
            Process p = Runtime.getRuntime().exec("python --version");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String chk = in.readLine().substring(0,6);
            Process pip = Runtime.getRuntime().exec("pip install morse_talk");
            if(chk.equals(chk.substring(0,6))){
                try {   
                    Process pr = Runtime.getRuntime().exec("python C:\\Users\\hp\\Documents\\NetBeansProjects\\jarvis\\src\\jarvis\\morse.py "+message);
                    BufferedReader inn = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String converted_message = inn.readLine();
                    System.out.println("Converted Text is : "+converted_message);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"something went Wrong");
                }
            }else{
                System.out.print("please install python ...");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"something went Wrong");
        }
    }
}
