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
    private static volatile boolean firstCompare = true;

    public TextComparePanel() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        textArea1.setEditable(true);
        textArea2.setEditable(true);
        textArea1.setText(null);
        textArea2.setText(null);
    }

    private void textArea() {
        if (firstCompare) {
            // 改变背景颜色
            textArea1.setSelectionColor(Color.LIGHT_GRAY);
            log.info("change selected text background color LIGHT_GRAY");

            // 改变字体颜色
            textArea1.setSelectedTextColor(Color.BLUE);
            log.info("change selected text color BLUE");

            firstCompare = false;
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        textArea();

        // TODO 选择这里有问题，在这里选中不会变色，手动选中才会变色
        textArea1.select(1, 3);

        textArea1.setEditable(false);
        textArea2.setEditable(false);

        //textArea1.setSelectionStart(0);
        //textArea1.setSelectionEnd(0);

        //textArea1.select(13,21);
        textArea2.setText(textArea1.getSelectedText());

        //textArea2.select(6, 10);
        //textArea2.select(16,20);
        //textArea2.setSelectedTextColor(Color.lightGray);

        String text1 = textArea1.getText();
        String text2 = textArea2.getText();

        log.info("text1: " + text1);
        log.info("text2: " + text2);
    }
    
    /*
     * C# 代码
    public void speedTest()
    {
        //string text1 = File.ReadAllText("D:/code/others/Speedtest1.txt");
        //string text2 = File.ReadAllText("D:/code/others/Speedtest2.txt");
        string text1 = rtb1.Text.Trim();
        string text2 = rtb2.Text.Trim();

        diff_match_patch dmp = new diff_match_patch();
        dmp.Diff_Timeout = 0;

        int i = 0,j = 0;

        // Execute one reverse diff as a warmup.
        List<Diff> diffs = dmp.diff_main(text2, text1);
        foreach (Diff diff in diffs)
        {
            //rtb1.Select(i, 1);
            if (diff.operation == Operation.EQUAL)
            {
                rtb3.Text += "[EQUAL]" + diff.text + "\r\n";
                i += diff.text.Length;
            }
            else if (diff.operation == Operation.INSERT)
            {
                rtb3.Text += "[INSERT]" + diff.text + "\r\n";
                rtb1.Select(i, diff.text.Length);
                i += diff.text.Length;
            }
            else if (diff.operation == Operation.DELETE)
                rtb3.Text += "[DELETE]" + diff.text + "\r\n";
            else
                rtb3.Text += "[OTHERS]";
            rtb1.SelectionColor = Color.Blue;
            rtb1.SelectionBackColor = Color.LightGray;
        }
        GC.Collect();
        GC.WaitForPendingFinalizers();

        DateTime ms_start = DateTime.Now;
        List<Diff> diffs1 = dmp.diff_main(text1, text2);
        DateTime ms_end = DateTime.Now;

        foreach (Diff diff in diffs1)
        {
            //rtb2.Select(j, 1);
            if (diff.operation == Operation.EQUAL)
            {
                rtb4.Text += "[EQUAL]" + diff.text + "\r\n";
                j += diff.text.Length;
            }
            else if (diff.operation == Operation.INSERT)
            {
                rtb4.Text += "[INSERT]" + diff.text + "\r\n";
                rtb2.Select(j, diff.text.Length);
                j += diff.text.Length;
            }
            else if (diff.operation == Operation.DELETE)
                rtb4.Text += "[DELETE]" + diff.text + "\r\n";
            else
                rtb4.Text += "[OTHERS]";
            rtb2.SelectionColor = Color.Blue;
            rtb2.SelectionBackColor = Color.LightGray;
        }

        //Console.WriteLine("Elapsed time: " + (ms_end - ms_start));
        //rtb1.Text += "Elapsed time: " + (ms_end - ms_start) + "\r\n";
    }*/

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
