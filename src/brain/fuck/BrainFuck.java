package brain.fuck;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author kaushal28
 */
public class BrainFuck {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String program = "--<-<<+[+[<+>--->->->-<<<]>]<<--.<++++++.<<-..<<.<+.>>.>>.<<<.+++.>>.>>-.<<<+.";
        int tape[] = new int[300000];
        int tapeHead = 150000;
        boolean isValid = true;
        int nestingLevel = 0;
        int l=0;
        Scanner in = new Scanner(System.in);
        Stack<Character> checker = new Stack<>();
        Stack<Integer> loop = new Stack<>();
        for(int i=0;i<program.length();i++){
            if(program.charAt(i)=='['){
                checker.push('[');
            }
            else if(program.charAt(i) == ']'){
                checker.pop();
            }
        }
        if(!checker.isEmpty()){
            System.out.println("Invalid Program! Balance Square Breakets.");
            isValid = false;
        }
        for(int i=0;i<program.length() && isValid;i++){
            switch (program.charAt(i)) {
                case '<':
                    --tapeHead;
                    break;
                case '>':
                    ++tapeHead;
                    break;
                case '.':
                    if(tape[tapeHead]>=0){
                        System.out.print((char)tape[tapeHead]);
                    }   break;
                case '+':
                    ++tape[tapeHead];
                    break;
                case '-':
                    --tape[tapeHead];
                    break;
                case ',':
                    char input = in.next().charAt(0);
                    tape[tapeHead] = (int)input;
                    break;
                case ']':
                if(tape[tapeHead] != 0) {
                    i--;
                    while(l > 0 || program.charAt(i) != '[') {
                        if(program.charAt(i) == ']') l++;
                        if(program.charAt(i) == '[') l--;
                        i--;
                    }
                    i--;
}
                    break;
                case '[':
                if(tape[tapeHead] == 0) {
                    i++;
                    while(l > 0 || program.charAt(i) != ']') {
                        if(program.charAt(i) == '[') l++;
                        if(program.charAt(i) == ']') l--;
                        i++;
                    }
                }
                    break;
                default:
                    break;
            }
            
        }  
    }
    
}
