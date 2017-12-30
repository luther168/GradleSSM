package cn.luo.form;

import cn.luo.mybatis.DBHelper;

import javax.swing.*;

public class MainForm {
    private JPanel panelRoot;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().panelRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        DBHelper.getInstance().select("UserInfo");
    }
}
