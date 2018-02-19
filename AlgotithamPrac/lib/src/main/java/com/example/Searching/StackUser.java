package com.example.Searching;

/**
 * Created by bandaab on 2/11/18.
 */

public class StackUser {
    public static void main(String[] args){
        Stack st = new Stack();
        st.push(1);
        st.push(5);
        st.push(4);
        st.push(8);
        st.print();
        st.pop();
        st.print();
    }
}
