
import java.util.Stack;

public class EvalPostfix {
    
  public static int expressionEval(String[] exp)
  {
    Stack<Integer> stack = new Stack<>();
    
    for(int i = 0 ; i<exp.length ; i++)
    {
        if(exp[i].contains("+-*/"))
        {
            int b = stack.pop();
            int a = stack.pop();
            
            switch exp[i])
            {
                case "+" : stack.push(a+b); break;
                case "-" : stack.push(a-b); break;
                case "*" : stack.push(a*b); break;
                case "/" : stack.push(a/b); break;
            }
        }
        else{
            stack.push(Integer.parseInt(exp[i]));
        }
    }
    return stack.peek();
  }
    
    
  public static void main(String args[]) {
    
    String[] str = {"2","5","10","+","*"};
    
    //30
    
    int res = expressionEval(str);
    System.out.println(res);

  }
}
