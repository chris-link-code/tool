/*
 * Created by JFormDesigner on Mon Oct 31 20:30:37 CST 2022
 */

package com.demo;

import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
@Slf4j
public class TextComparePanel extends JPanel {
    public TextComparePanel() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        textArea1.setText("");
        textArea2.setText("");
    }

    private void button2MouseClicked(MouseEvent e) {
        String text1 = textArea1.getText();
        String text2 = textArea2.getText();
        log.info("text1: " + text1);
        log.info("text2: " + text2);

        // TODO 无法改颜色
        textArea1.select(3,9);
        textArea1.select(13,21);

        textArea2.select(6,10);
        textArea2.select(16,20);

        textArea1.setSelectedTextColor(Color.red);
        textArea2.setSelectedTextColor(Color.lightGray);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane = new JSplitPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(200, 500));
        setMinimumSize(new Dimension(200, 120));
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]",
            // rows
            "[]" +
            "[]"));

        //======== splitPane ========
        {
            splitPane.setResizeWeight(0.5);
            splitPane.setDividerLocation(450);
            splitPane.setMinimumSize(new Dimension(100, 100));
            splitPane.setLastDividerLocation(450);

            //======== panel1 ========
            {
                panel1.setBackground(new Color(0xcccccc));
                panel1.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textArea1);
                }
                panel1.add(scrollPane1, BorderLayout.CENTER);
            }
            splitPane.setLeftComponent(panel1);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0xcccccc));
                panel2.setLayout(new BorderLayout());

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(textArea2);
                }
                panel2.add(scrollPane2, BorderLayout.CENTER);
            }
            splitPane.setRightComponent(panel2);
        }
        add(splitPane, "cell 0 0,dock center");

        //---- button1 ----
        button1.setText("clear");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        add(button1, "cell 0 1");

        //---- button2 ----
        button2.setText("compare");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        add(button2, "cell 0 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
