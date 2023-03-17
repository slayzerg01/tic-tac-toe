import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * Вроде сделал ток все равно надо как то бота добавить
 *
 */
public class Main {
    private static int size;
    /**
     * Главный метод
     *
    / * @param args
    / * @throws InterruptedException
     /* @throws InvocationTargetException
     /* @throws ClassNotFoundException
     /* @throws InstantiationException
     /* @throws IllegalAccessException
     /* @throws UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws InterruptedException,
            InvocationTargetException, ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {

        // установка темы Nimbus
        // если для данной версии JDK эта тема не доступна
        // будет установлена тема по умолчанию
        setNimbusLookAndFeel();

        // запуск приложения
        EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                // создание главного окна
                window();
            }
        });

    }
    private static void window(){
        JFrame frame = new JFrame("МЕНЮ");
        JLabel label = new JLabel("Размер поля:");
        JPanel panel = new JPanel();
        JTextField text = new JTextField(15);
        JButton button = new JButton("ИГРАТЬ!");
        panel.add(label);
        panel.add(text);
        panel.add(button);
        frame.setContentPane(panel);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                size = Integer.parseInt(text.getText());
                frame.setVisible(false);
                GameFrame wnd = new GameFrame(size);
                wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                wnd.setTitle("Крестики-нолики");
                wnd.setLocation(100, 100);
                wnd.setResizable(false);
                wnd.setVisible(true);
            }
        });
        frame.setBounds(100, 100, 200, 150);
        frame.setVisible(true);
    }


    // установка внешнего вида приложения Nimbus
    private static void setNimbusLookAndFeel() {
        //Nimbus, если доступно
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}