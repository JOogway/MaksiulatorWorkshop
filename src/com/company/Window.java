package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Maksym on 2014-11-09.
 */
public class Window extends JFrame implements ActionListener {
    public JSeparator separator;

    JButton buttonExit, buttonActivator, buttonActivatorRecipe, Fish, Meat, Vege;
    JLabel lShowReaction0, lShowReaction1, lShowReaction2;
    JMenuBar MenuBar;
    JMenu plik, pomoc;
    JMenuItem Choose, Zmodyfikuj, Wyjscie, About_Program;
    String About = "Program dla Aniutka", tekst = "Tutaj pojawia się przepis";
    String[] tekstPrzepisu;
    int number, odpowiedz;
    JTextArea textArea;
    BufferedReader br;



    public void Window() throws Exception, IOException {
        setSize(610, 440);
        setTitle("Maksiulator");
        setBackground(Color.magenta);
        MenuBar();
        Wyjscie();
        About();
        ButtonActivator();
        ButtonActivatorRecipe();
        ButtonExit();
        LShowReaction0();
        LShowReaction1();
        LShowReaction2();
        TextArea();
        Separator();
        Fish();
        Meat();
        Vege();
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().add(buttonActivator);
        getContentPane().add(buttonExit);
        getContentPane().add(lShowReaction0);
        getContentPane().add(lShowReaction1);
        getContentPane().add(lShowReaction2);
        getContentPane().add(separator);
        getContentPane().add(textArea);
        getContentPane().add(buttonActivatorRecipe);
        setJMenuBar(MenuBar);
        repaint();
        setVisible(true);

    }

    public void Zmodyfikuj() {
        Zmodyfikuj = new JMenuItem("Zmodyfikuj", 'Z');
        Zmodyfikuj.setVisible(true);
        Zmodyfikuj.addActionListener(this);
    }

    public void Wyjscie() {
        Wyjscie = new JMenuItem("Wyjście", 'Q');
        Wyjscie.setVisible(true);
        Wyjscie.addActionListener(this);
    }

    public void Choose() {
        Choose = new JMenuItem("Wybierz", 'W');
        Choose.setVisible(true);
        Choose.addActionListener(this);
    }

    public void Pomoc() {
        pomoc = new JMenu("Pomoc");
        pomoc.setVisible(true);
        pomoc.addActionListener(this);
    }

    public void MenuBar() {
        Pomoc();
        Choose();
        Zmodyfikuj();
        Wyjscie();
        plik = new JMenu("Plik...");
        plik.add(Choose);
        plik.add(Zmodyfikuj);
        plik.addSeparator();
        plik.add(Wyjscie);
        plik.setVisible(true);
        MenuBar = new JMenuBar();
        MenuBar.setBounds(0, 0, 510, 10);
        MenuBar.add(plik);
        MenuBar.add(pomoc);
        MenuBar.setVisible(true);
    }

    public void About() {
        About_Program = new JMenuItem("O programie", 'I');
        About_Program.setVisible(true);
        pomoc.add(About_Program);
    }

    public void ButtonActivator() {
        buttonActivator = new JButton("Losuj Cyferke na dziś :*");
        buttonActivator.setBounds(10, 350, 155, 20);
        buttonActivator.setToolTipText("Losuje Twoją cyferkę na dziś");
        buttonActivator.setVisible(true);
        buttonActivator.addActionListener(this);
    }

    public void ButtonExit() {
        buttonExit = new JButton("Wyjście");
        buttonExit.setBounds(390, 350, 100, 20);
        buttonExit.setVisible(true);
        buttonExit.addActionListener(this);
    }

    public void ButtonActivatorRecipe() {
        buttonActivatorRecipe = new JButton("Wyświetl losowy przepis");
        buttonActivatorRecipe.setBounds(175, 350, 155, 20);
        buttonActivatorRecipe.setVisible(true);
        buttonActivatorRecipe.addActionListener(this);
    }

    public void LShowReaction0() {
        lShowReaction0 = new JLabel("Kliknij raz guziczek. :*");
        lShowReaction0.setBounds(10, 10, 200, 20);
        lShowReaction0.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        lShowReaction0.setForeground(new Color(250, 150, 50));
        lShowReaction0.setVisible(true);
    }

    public void LShowReaction1() {
        lShowReaction1 = new JLabel("");
        lShowReaction1.setBounds(10, 40, 400, 40);
        lShowReaction1.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
        lShowReaction1.setForeground(new Color(250, 50, 250));
        lShowReaction1.setVisible(true);
    }

    public void LShowReaction2() {
        lShowReaction2 = new JLabel("");
        lShowReaction2.setBounds(10, 70, 400, 60);
        lShowReaction2.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
        lShowReaction2.setForeground(new Color(250, 50, 50));
        lShowReaction2.setVisible(true);
    }

    /*/public void FileChooser() {
        JFileChooser s = new JFileChooser();
        s.setVisible(true);

    }/*/

    public void TextArea() throws IOException {
        textArea = new JTextArea(10, 40);
        /*/JFileChooser file = new JFileChooser();
        textArea.read( new FileReader( file.getAbsolutePath() ), null );
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String linia;
        String tekst = "";
        while ((linia = br.readLine()) != null) {
            tekst = tekst+linia+"\n" ;
        }
        br.close();
        tekst = tekst.toUpperCase();/*/
        textArea.setText(tekst);
        textArea.getDocument();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 150, 475, 160);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setColumns(10);
        textArea.setRows(10);
        textArea.setBackground(Color.white);
        textArea.setSize(475, 160);
        textArea.setLayout(null);
        textArea.setText("");
        textArea.setEditable(true);
        textArea.setToolTipText("Tutaj wyświetla się przepis");
        textArea.setVisible(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(tekst);
    }

    public void Separator() {
        separator = new JSeparator();
        separator.setBounds(160, 90, 490, 0);
    }

    public void Fish() {
        Fish = new JButton("Danie rybne");
        Fish.setBounds(10, 320, 155, 20);
        Fish.setVisible(true);
    }

    public void Meat() {
        Meat = new JButton("Danie mięsne");
        Meat.setBounds(175, 320, 155, 20);
        Meat.setVisible(true);
    }

    public void Vege() {
        Vege = new JButton("Danie wegetariańskie");
        Vege.setBounds(350, 320, 155, 20);
        Vege.setVisible(true);
    }

    public class ReadFile {

        private String path;

    public ReadFile(String file_path) {
        path = file_path;
    }
        int readLines() throws IOException{
            FileReader file_to_read = new FileReader(path);
            BufferedReader bf = new BufferedReader(file_to_read);

            String aLine;
            int NumberOfLines = 0;
            while ((aLine = bf.readLine())!= null){
                NumberOfLines++;
            }
            bf.close();
            return NumberOfLines;
        }
    public String[] OpenFile() throws IOException{
        readLines();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        int NumberOfLines = 10;
        String[] textData = new String[NumberOfLines];
        int i;
        for (i = 0; i < NumberOfLines; i++) {
            textData[i] = br.readLine();
        }
        br.close();
        return textData;
    }

}



    @Override
    public void actionPerformed(ActionEvent e) {
        Object bSource = e.getSource();
        if (bSource == buttonExit) {
            dispose();
        } else if (bSource == Wyjscie) {
            dispose();
        } else {
            if (bSource == buttonActivator) {

                Random r = new Random();

                number = r.nextInt(10);

                lShowReaction0.setText("Twoja cyferka na dziś to: " + " " + Integer.toString(number));
                buttonActivator.setVisible(false);
                switch (number) {
                    case 0:
                        lShowReaction1.setText("Bo tyle będzie dzisiaj zmartwień :*");
                        lShowReaction2.setText("Uśmiechnij się Pysiu :*");
                        break;
                    case 1:
                        lShowReaction1.setText("1# bo jesteś number one :*");
                        lShowReaction2.setText("Pingwinek Cię Kocha :*");
                        break;
                    case 2:
                        lShowReaction1.setText("Cyferka dwa tak jak Ty i ja :*");
                        lShowReaction2.setText("Tuluu! :*");
                        break;
                    case 3:
                        lShowReaction1.setText("Cyferka trzy, Koteczka szukasz Tyyy :*");
                        lShowReaction2.setText("A kto Cię Kocha? :*");
                        break;
                    case 4:
                        lShowReaction1.setText("Za taki Pysio należy się buziol :*");
                        lShowReaction2.setText("śliczna jesteś, wiesz? :*");
                        break;
                    case 5:
                        lShowReaction1.setText("Tak jak Twoja matura która będzie na pięć :*");
                        lShowReaction2.setText("Ucz się Słońce :*");
                        break;
                    case 6:
                        lShowReaction1.setText("Sześć Aniutkowi trzeba oddać cześć! ");
                        lShowReaction2.setText("Kochanie Jesteś Królewną Chwała! :*");
                        break;
                    case 7:
                        lShowReaction1.setText("Szczęśliwa siódemka to dzisiaj Twoja number :*");
                        lShowReaction2.setText("Zawsze jestem przy Tobie :*");
                        break;
                    case 8:
                        lShowReaction1.setText("Osiem to stojąca cyfra nieskończoności,");
                        lShowReaction2.setText("coś się kończy, coś się zaczyna a nasza miłoś jest nieśmiertelna :*");
                        break;
                    case 9:
                        lShowReaction1.setText("Dziewiątka to symbol odrodzenia i podróży, ");
                        lShowReaction2.setText("dzisiaj musisz koniecznie wyjść z domku :*");
                        break;
                    case 10:
                        lShowReaction1.setText("10 jest jak 2 tylko po binarnemu... :D");
                        lShowReaction2.setText("Do nauki! Albo Polibuda nas zje...");
                }
            } else if (bSource == About_Program) {
                tekst = About;
            }else if (bSource == buttonActivatorRecipe){

                textArea.setText(tekstPrzepisu.toString());
                getContentPane().add(Fish);
                getContentPane().add(Vege);
                getContentPane().add(Meat);
                repaint();
            }/*/else if (bSource == Zmodyfikuj){
                int odpowiedz = jFileChooserOtworzPlik.showOpenDialog(this);
                if (odpowiedz == jFileChooserOtworzPlik.APPROVE_OPTION) {
                    File file = jFileChooserOtworzPlik.getSelectedFile();
                    try {"dupa dupa dupa, przepisy w trakcie dodawania"
                        textArea.read( new FileReader( file.getAbsolutePath() ), null );
                    } catch (IOException e) {
                        System.out.println("Nie mogę otworzyć pliku: "+file.getAbsolutePath());
                        System.out.println("Problem: "+e);
                    }/*/
        }

    }
}

