package company.myUseful.swing.components;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by OPER on 05.07.2017.
 */
public class JTreeDemo extends JApplet {
    JTree tree;
    JLabel jl;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(()->makeGUI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeGUI() {
        //this.setLayout(new FlowLayout());

        //Создаем вершину дерева
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Oprions");

        //Создаем поддерево А
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
        top.add(a);

        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
        a.add(a1);

        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
        a.add(a2);

        //Создаем поддерево B
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
        top.add(b);

        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
        b.add(b1);

        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
        b.add(b2);

        DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
        b.add(b3);

        //Создаем дерево из сформированных узлов
        tree = new JTree(top);

        //Добавим дерево на панель прокрутки
        JScrollPane sp = new JScrollPane(tree);
        sp.setPreferredSize(new Dimension(120, 200));

        //Добавим панель прокрутки на панель отображения
        this.add(sp);

        jl = new JLabel();
        this.add(jl, BorderLayout.SOUTH);

        //Добавим обработчик событий при выделении узлов дерева
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                jl.setText(e.getPath().toString());
            }
        });



    }
}
