package string;

import java.util.Stack;

/**
 * @author Wei
 * @since 10/19/16
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    st.push(')');
                    break;
                case '[':
                    st.push(']');
                    break;
                case '{':
                    st.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (!st.isEmpty() && st.peek().equals(ch)) st.pop();
                    else return false;
                    break;
                default:
                    //return false; // When non-parenthesis characters are NOT allowed.
            }
        }
        return st.empty();
    }


    public static void main(String[] args) {
        String s = "{}()[]";
        System.out.println(new ValidParentheses().isValid(s));

        s = "{}([)]";
        System.out.println(new ValidParentheses().isValid(s));

        s = "{}([]";
        System.out.println(new ValidParentheses().isValid(s));

        s = "{}([])))";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
