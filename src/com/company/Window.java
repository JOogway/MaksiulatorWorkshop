package com.company;

import javafx.stage.FileChooser;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Maksym on 2014-11-09.
 */
public class Window extends JFrame implements ActionListener {
    public JSeparator separator;

    public static ArrayList<String> listaRybna;
    JButton buttonExit, buttonActivator, buttonActivatorRecipe, Fish, Meat, Vege;
    JTextField titleField;
    JMenuBar MenuBar;
    JComboBox foodTypeList;
    JLabel lShowReaction0, lShowReaction1, lShowReaction2;
    JMenu plik, pomoc;
    JMenuItem OpenMenuItem, Zapisz, Wyjscie, About_Program;
    String About = "Program dla Aniutka", tekst = "Tutaj pojawia się przepis", tytuł, absolutePath;
    String tekstPrzepisu = "brak", path = "Mięsne";
    String[] baseOfFish;
    int number, index = 1, toReadPath, i, j;
    JTextArea textArea;
    String fs = System.getProperty("file.separator");
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("src/data/cursor.png");


    public void Window() throws Exception {
        LShowReaction0();
        LShowReaction1();
        LShowReaction2();
        setSize(610, 440);
        setTitle("Maksiulator");
        MenuBar();
        Wyjscie();
        About();
        ButtonActivator();
        ButtonActivatorRecipe();
        ButtonExit();
        TextArea();
        Separator();
        Fish();
        Meat();
        Vege();
        TitleField();
        ChooseKindField();
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        DirectoryCreator();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(foodTypeList);
        getContentPane().add(titleField);
        getContentPane().add(buttonActivator);
        getContentPane().add(buttonExit);
        getContentPane().add(lShowReaction0);
        getContentPane().add(lShowReaction1);
        getContentPane().add(lShowReaction2);
        getContentPane().add(separator);
        getContentPane().add(textArea);
        getContentPane().add(buttonActivatorRecipe);
        getContentPane().add(Wyjscie);
        setJMenuBar(MenuBar);
        Point spot = new Point(1, 1);
        Cursor c = toolkit.createCustomCursor(image, spot, "cursor");
        this.setCursor(c);
        repaint();
        setVisible(true);
        setResizable(false);
    }


    public void LShowReaction0() {
        lShowReaction0 = new JLabel("Kliknij raz guziczek. :*");
        lShowReaction0.setBounds(10, 10, 300, 20);
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
        lShowReaction2.setBounds(10, 70, 500, 60);
        lShowReaction2.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
        lShowReaction2.setForeground(new Color(250, 50, 50));
        lShowReaction2.setVisible(true);
    }

    public void DirectoryCreator() throws IOException {
        File theDir0 = new File("Rybne");
        File FishList = new File("Rybne/ListaRybnych.txt");
        File theDir1 = new File("Mięsne");
        File MeatList = new File("Mięsne/ListaMięsnych.txt");
        File theDir2 = new File("Wegetariańskie");
        File WegeList = new File("Wegetariańskie/ListaWege.txt");
        File theDir3 = new File("Deser");
        File DesertList = new File("Deser/ListaDeserów.txt");
        File theDir4 = new File("Przystawka");
        File AppeList = new File("Przystawka/ListaPrzystawek.txt");
        PrintWriter fileWriter;

        if (!FishList.exists()) {
            fileWriter = new PrintWriter(FishList);
            fileWriter.print("");
            fileWriter.close();

        }
        if (!MeatList.exists()) {
            fileWriter = new PrintWriter(MeatList);
            fileWriter.print("");
            fileWriter.close();
        }
        if (!WegeList.exists()) {
            fileWriter = new PrintWriter(WegeList);
            fileWriter.print("");
            fileWriter.close();
        }
        if (!DesertList.exists()) {
            fileWriter = new PrintWriter(DesertList);
            fileWriter.print("");
            fileWriter.close();
        }
        if (!AppeList.exists()) {
            fileWriter = new PrintWriter(AppeList);
            fileWriter.print("");
            fileWriter.close();
        }


        // if the directory does not exist, create it
        if (!theDir0.exists()) {
            System.out.println("creating directory: " + "Rybne");
            boolean result = false;

            try {
                theDir0.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }

        if (!theDir1.exists()) {
            System.out.println("creating directory: " + "Mięsne");
            boolean result = false;

            try {
                theDir1.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }

        if (!theDir2.exists()) {
            System.out.println("creating directory: " + "Wegetariańskie");
            boolean result = false;

            try {
                theDir2.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }

        if (!theDir3.exists()) {
            System.out.println("creating directory: " + "Deser");
            boolean result = false;

            try {
                theDir3.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }

        if (!theDir4.exists()) {
            System.out.println("creating directory: " + "Przystawka");
            boolean result = false;

            try {
                theDir4.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }
    }
    public void Zapisz() {
        Zapisz = new JMenuItem("Zapisz", 'Z');
        Zapisz.setVisible(true);
        Zapisz.addActionListener(e -> {
            try {
                save_to_file();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    public void Wyjscie() {
        Wyjscie = new JMenuItem("Wyjście", 'Q');
        Wyjscie.setVisible(true);
        Wyjscie.addActionListener(e -> System.exit(0));
    }

    public void OpenMenuItem() {
        OpenMenuItem = new JMenuItem("Otwórz", 'W');
        OpenMenuItem.setVisible(true);
        OpenMenuItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "IdeaProjects" + System.getProperty("file.separator") + "MaksiulatorWorkshop"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "TXT & DOCX Docs", "txt", "docx");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " +
                        chooser.getSelectedFile().getName());
            }
        });
    }
    public void Pomoc() {
        pomoc = new JMenu("Pomoc");
        pomoc.setVisible(true);
        pomoc.addActionListener(this);
    }
    public void MenuBar() {
        Pomoc();
        OpenMenuItem();
        Zapisz();
        Wyjscie();
        plik = new JMenu("Plik...");
        plik.add(OpenMenuItem);
        plik.add(Zapisz);
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
        About_Program.addActionListener(e -> tekst = About);
        pomoc.add(About_Program);
    }
    public void ButtonActivator() {
        buttonActivator = new JButton("Losuj Cyferke na dziś :*");
        buttonActivator.setBounds(10, 350, 200, 20);
        buttonActivator.setToolTipText("Losuje Twoją cyferkę na dziś");
        buttonActivator.setVisible(true);
        buttonActivator.addActionListener(ButtonActivatorAction());
    }
    public void ButtonExit() {
        buttonExit = new JButton("Wyjście");
        buttonExit.setBounds(500, 350, 99, 20);
        buttonExit.setVisible(true);
        buttonExit.addActionListener(e -> System.exit(0));
    }
    public void ButtonActivatorRecipe() {
        buttonActivatorRecipe = new JButton("Wyświetl losowy przepis");
        buttonActivatorRecipe.setBounds(210, 350, 220, 20);
        buttonActivatorRecipe.setVisible(true);
        buttonActivatorRecipe.addActionListener(e -> {
            getContentPane().add(Fish);
            getContentPane().add(Vege);
            getContentPane().add(Meat);
            repaint();
            textArea.setText(tekstPrzepisu);
        });
    }
    public void TitleField() {
        titleField = new JTextField(tytuł);
        titleField.setVisible(true);
        titleField.setBounds(10, 120, 400, 25);
        titleField.setEditable(true);
    }
    public void ChooseKindField() {

        String[] FoodTypesStrings = {"Rybne", "Mięsne", "Wegetariańskie", "Deser", "Przystawka"};
        foodTypeList = new JComboBox<>(FoodTypesStrings);
        foodTypeList.setSelectedIndex(index);
        foodTypeList.addActionListener(this);
        foodTypeList.setVisible(true);
        foodTypeList.setBounds(410, 120, 189, 25);
        //foodTypeList.addActionListener(e -> );
        foodTypeList.setEditable(false);
    }
    public void TextArea() throws IOException {
        textArea = new JTextArea(100, 100);
        textArea.getDocument();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 150, 589, 160);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.white);
        textArea.setLayout(null);
        textArea.setText("");
        textArea.setEditable(true);
        textArea.setToolTipText("Tutaj wyświetla się przepis");
        textArea.setVisible(true);
        textArea.setWrapStyleWord(true);
    }
    public void Separator() {
        separator = new JSeparator();
        separator.setBounds(160, 90, 490, 0);
    }
    public void Fish() {
        Fish = new JButton("Danie rybne");
        Fish.setBounds(40, 320, 155, 20);
        Fish.setVisible(true);
        Fish.addActionListener(e -> {
            toReadPath = 0;
            try {
                open_file();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }
    public void Meat() {
        Meat = new JButton("Danie mięsne");
        Meat.setBounds(240, 320, 155, 20);
        Meat.setVisible(true);
        Meat.addActionListener(e -> {
            toReadPath = 1;
            try {
                open_file();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }
    public void Vege() {
        Vege = new JButton("Danie wege");
        Vege.setBounds(444, 320, 155, 20);
        Vege.setVisible(true);
        Vege.addActionListener(e -> {
            toReadPath = 2;
            try {
                open_file();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void save_to_file() throws IOException, NullPointerException {
        listaRybna = new ArrayList<>();
        tekstPrzepisu = textArea.getText();
        tytuł = titleField.getText();
        absolutePath = path + fs + tytuł + ".txt";
        String doListy = tytuł;
        listaRybna.add(doListy);
        FileWriter fw = new FileWriter(absolutePath);
        fw.write(tekstPrzepisu);
        fw.close();
    }

    public void randRecipe() {
        Random r = new Random();
        int whatType = r.nextInt() % 3;
        switch (whatType) {
            case 0:
                path = "Rybne";
            case 1:
                path = "Mięsne";
            case 2:
                path = "Wegetariańskie";
        }
    }

    public void open_file() throws FileNotFoundException {
        switch (toReadPath) {
            case 0:
                path = "Rybne";
                break;
            case 1:
                path = "Mięsne";
                break;
            case 2:
                path = "Wegetariańskie";
                break;
            case 3:
                path = "Deser";
                break;
            case 4:
                path = "Przystawka";
                break;
        }
        int zas = listaRybna.size();
        Random R = new Random(zas);
        int l = R.nextInt() % listaRybna.size();
        tytuł = listaRybna.get(l);
        /*for (i=0;i<listaRybna.size()+1;i++){

            tytuł = listaRybna.get(i);
            if (tytuł != null) {
                tytuł = listaRybna.get(j);
            } else {
                j++;
            }
        }*/
        absolutePath = path + fs + tytuł + ".txt";
        titleField.setText(tytuł);
        FileReader reader = new FileReader(tytuł);
        BufferedReader br = new BufferedReader(reader);

        try {
            textArea.read(br, null);
            br.close();
            textArea.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void AddToArray() {
        for (i = 0; i < j; i++) {
            if (baseOfFish[j].isEmpty()) {
                baseOfFish[j] = tytuł;
            } else {
                j++;
            }
        }
    }


    public ActionListener ButtonActivatorAction() {

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
                    lShowReaction2.setText("coś się kończy, coś się zaczyna a nasza miłość jest nieśmiertelna :*");
                    break;
                case 9:
                    lShowReaction1.setText("Dziewiątka to symbol odrodzenia i podróży, ");
                    lShowReaction2.setText("dzisiaj musisz koniecznie wyjść z domku :*");
                    break;
                case 10:
                    lShowReaction1.setText("10 jest jak 2 tylko po binarnemu... :D");
                    lShowReaction2.setText("Do nauki! Albo Polibuda nas zje...");
            }
        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object bSource = e.getSource();


        if (bSource == buttonActivator)


        path = (String) foodTypeList.getSelectedItem();
    }
}




