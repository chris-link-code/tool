/*
 * Created by JFormDesigner on Mon Oct 31 20:30:37 CST 2022
 */

package com.formdev.flatlaf.demo;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class TextComparePanel extends JPanel {
    public TextComparePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        splitPane = new JSplitPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(200, 500));
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
                panel1.setBackground(new Color(0x999999));
                panel1.setLayout(new BorderLayout());

                //---- label1 ----
                label1.setText("LEFT");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setForeground(Color.white);
                panel1.add(label1, BorderLayout.CENTER);
            }
            splitPane.setLeftComponent(panel1);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x666666));
                panel2.setLayout(new BorderLayout());

                //---- label2 ----
                label2.setText("RIGHT");
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                label2.setForeground(Color.white);
                panel2.add(label2, BorderLayout.CENTER);
            }
            splitPane.setRightComponent(panel2);
        }
        add(splitPane, "cell 0 0,dock center");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSplitPane splitPane;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
