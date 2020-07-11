
package jarvis;

import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class jarvis {

    public static void main(String[] args) {
        try {
            String option = args[0];
            if(option.equals("--help"))
            {
                helpSection();
            }
            else if(option.equals("define"))
                
            {
                try{
                    String word = args[1];
                    if(word!=null)
                    {
                       Definition d = new Definition();
                       d.define_word(word);
                    }else
                    {
                        System.out.println("Too short parameter ... ");
                        System.out.println("Enter word to define...(eg. \"jarvis define omnipotent\") ");
                    }  
                }catch(java.lang.ArrayIndexOutOfBoundsException e){
                    System.out.println("Too short parameter ... ");
                    System.out.println("Enter word to define...(eg. \"jarvis define [String]\") ");
                }
            }
            else if(option.equals("duplicate"))
            {
                try{
                    String srcfile =args[1];
                    String destfile = args[2];
                    //String srcfile = "C:\\Users\\hp\\Documents\\NetBeansProjects\\jarvis\\src\\jarvis\\test.txt";
                    //String destfile = "C:\\Users\\hp\\Documents\\NetBeansProjects\\jarvis\\src\\jarvis\\test2.txt";
                    File src = new File(srcfile);
                    File dest = new File(destfile);
                    PrintWriter pw =new PrintWriter(dest);
                    Scanner s = new Scanner(src);
                    String content;
                    while(s.hasNext())
                    {
                        pw.println(s.next());
                    }
                    System.out.println("Succesfully duplicate the file");
                    System.out.println("Location --> "+dest.getAbsolutePath());
                    pw.close();
                }
                catch(java.lang.ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Too short parameter ... ");
                    System.out.println("please follow syntax...(eg. \"jarvis duplicate [source_file_path] [dest_file_path]\") ");
                }
                catch(Exception e)
                {
                    System.out.println("File not Found / - please specify full path or check your file names");
                }
            }
            else if(option.equals("translate"))
            {
                String codes[] =Locale.getISOLanguages();
                int count=0;
                String code = args[1];
                String text = args[2].trim();
                for (int i = 0; i < codes.length; i++) {
                    if(codes[i].equals(code)){
                        count++;
                        break;
                    }
                }
                if(count==0)
                {
                    System.out.println("please put valid language code to translate");
                    System.out.println("for eg. hi - hindi \n mr - marathi");
                }
                else{
                    String translated_text = GoogleTranslate.translate(code, text);
                    //JOptionPane.showMessageDialog(null,translated_text);
                    System.out.println("Translated Text is -- >> "+translated_text);
                    System.out.println("if text is not showing properly then copy the translated text and paste it into notepad..");
                }
            }
            else if(option.equals("convert"))
            {
                String flag = args[1];
                if(flag.equals("-ETM"))
                {
                    String regex = "^[a-zA-Z]+$";
                    String message = args[2];
                    if(message.matches(regex))
                    {
                        Conversion c = new Conversion();
                        c.convertETM(message);
                    }
                    else
                    {
                        System.out.println("please check the String you Enter");
                        System.out.println("type this command to see the help section");
                        System.out.println("[\"jarvis --help\"]");
                    }
                }
                else
                {
                    System.out.println("please Enter valid flags to convert");
                    System.out.println("for eg. -ETM - english to morse");
                }
                
            }
            else if(option.equals("--version"))
            {
                System.out.println("Jarvis Version : 1.0.0");
            }
            else{
                
                System.out.println("no such command");
                System.out.println("see the help section : [\"jarvis --help\"]");
            }
            
        }
        catch (Exception ex) {
            System.out.println("Please put valid command");
            System.out.println("type this command to see the help section");
            System.out.println("[\"jarvis --help\"]");
        }
    }

    private static void helpSection() {
        Map m= new HashMap();
        m.put("--help", "help section , this is optional parameter");
        m.put("define", "It retrives the meaning for your any kind of word");
        m.put("translate", "it translate text into different languages");
        m.put("duplicate", "it duplicate the file");
        m.put("convert", "it Convert given text in to morse code");
        m.put("--version", "version of tool");
        
        System.out.println("-------COMMANDS DESCRIPTION-------");
        System.out.println("\t--version   -- "+m.get("--version"));
        System.out.println("\t--help      -- "+m.get("--help"));
        System.out.println("\tdefine      -- "+m.get("define"));
        System.out.println("\ttranslate   -- "+m.get("translate"));
        System.out.println("\tduplicate   -- "+m.get("duplicate"));
        System.out.println("\tconvert     -- "+m.get("convert"));
        
        System.out.println("------COMMAND USAGE---------------");
        System.out.println("\t--version   -- [\"jarvis --version\"]");
        System.out.println("\t--help      -- [\"jarvis --help\"]");
        System.out.println("\tdefine      -- [\"jarvis define [String]\"]");
        System.out.println("\ttranslate   -- [\"jarvis translate [language_code] [string]\"]");
        System.out.println("\tduplicate   -- [\"jarvis duplicate [src_file] [dest_file]\"]");
        System.out.println("\tconvert     -- [\"jarvis convert [flag] [String]\"]");
        System.out.println("\t\t --flag -- [-ETM]");
        
        System.out.println("------Version---------------------");
        System.out.println("Jarvis version 1.0.0");
    }
    
}
