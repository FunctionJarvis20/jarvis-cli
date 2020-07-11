
package jarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Definition {
    void define_word(String Word)
    {
        try {
            Process p = Runtime.getRuntime().exec("python --version");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String chk = in.readLine().substring(0,6);
            if(chk.equals(chk.substring(0,6))){
                try {
                    Process pr = Runtime.getRuntime().exec("python C:\\Users\\hp\\Documents\\NetBeansProjects\\jarvis\\src\\jarvis\\dict.py "+Word);
                    BufferedReader inn = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String define = inn.readLine();
                    String example = inn.readLine();
                    System.out.println("meaning ->>> "+define);
                    System.out.println("example ->>> "+example);
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
