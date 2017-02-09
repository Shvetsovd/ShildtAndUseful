package company.shildt.chapter9;

import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 * Created by dmitry on 07.02.17.
 */
public class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();

        c.callback(42);

        c = ob;
        c.callback(42);
    }
}
