package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Maksym on 2014-11-09.
 */
public class Window extends JFrame {
    public JSeparator separator;

    List<String> listaRybna = new ArrayList<>();
    List<String> listaMięsna = new ArrayList<>();
    List<String> listaWege = new ArrayList<>();
    List<String> listaDeser = new ArrayList<>();
    List<String> listaPrzystawek = new ArrayList<>();

    JButton buttonExit, buttonActivator, buttonActivatorRecipe, Fish, Meat, Vege;
    JTextField titleField;
    JMenuBar MenuBar;
    JComboBox foodTypeList;
    JLabel lShowReaction0, lShowReaction1, lShowReaction2;
    JMenu plik, pomoc;
    JMenuItem OpenMenuItem, Zapisz, Wyjscie, About_Program;
    String About = "Program dedykowany specjalnie dla Aniutka", tekst = "Tutaj pojawia się przepis", tytuł, absolutePath;
    String tekstPrzepisu = "brak", path = "Mięsne";
    int number, index, toReadPath, i, j, whichRecipe;
    JTextArea textArea;
    String fs = System.getProperty("file.separator"), lossedRecipePath;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage("src/data/cursor.png");
    File filePath;
    Random r = new Random();


    public Window() throws Exception {
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
        getLists();
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

    public void getLists() throws FileNotFoundException {
        Scanner s0 = new Scanner((new File("Rybne/ListaRybnych.txt")));
        Scanner s1 = new Scanner((new File("Mięsne/ListaMięsnych.txt")));
        Scanner s2 = new Scanner((new File("Wegetariańskie/ListaWege.txt")));
        Scanner s3 = new Scanner((new File("Deser/ListaDeserów.txt")));
        Scanner s4 = new Scanner((new File("Przystawka/ListaPrzystawek.txt")));

        while (s0.hasNextLine()) {
            listaRybna.add(s0.nextLine());
        }
        while (s1.hasNextLine()) {
            listaMięsna.add(s1.nextLine());
        }
        while (s2.hasNextLine()) {
            listaWege.add(s2.nextLine());
        }
        while (s3.hasNextLine()) {
            listaDeser.add(s3.nextLine());
        }
        while (s4.hasNextLine()) {
            listaPrzystawek.add(s4.nextLine());
        }

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
            filePath = chooser.getSelectedFile();
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " +
                        chooser.getSelectedFile().getName());
                try {
                    BufferedReader in = new BufferedReader(new FileReader(filePath));
                    String line = null;
                    textArea.setText("");
                    while ((line = in.readLine()) != null) {
                        textArea.append(line + "\n");
                        titleField.setText(chooser.getSelectedFile().getName());
                    }
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void Pomoc() {
        pomoc = new JMenu("Pomoc");
        pomoc.setVisible(true);
        pomoc.addActionListener(e -> textArea.setText("Wszelkie pytania kieruj na e-mail: rut1900@o2.pl"));
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
        About_Program.addActionListener(e -> textArea.setText(About));
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
            try {
                randRecipe();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
        foodTypeList.addActionListener(e -> index = foodTypeList.getSelectedIndex());
        foodTypeList.setVisible(true);
        foodTypeList.setBounds(410, 120, 189, 25);
        foodTypeList.setEditable(false);
    }

    public void TextArea() throws IOException {
        textArea = new JTextArea(100, 100);
        textArea.getDocument();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(10, 150, 589, 160);
        textArea.setFont(new Font("Serif", Font.ITALIC, 13));
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

    public void Fish() throws IOException {
        Fish = new JButton("Danie rybne");
        Fish.setBounds(40, 320, 155, 20);
        Fish.setVisible(true);
        Fish.addActionListener(e -> {
            toReadPath = 0;
            path = "Rybne";
            whichRecipe = r.nextInt() % listaRybna.size();
            lossedRecipePath = path + fs + listaRybna.get(whichRecipe) + ".txt";
            titleField.setText(listaRybna.get(whichRecipe));
            BufferedReader in1 = null;
            try {
                in1 = new BufferedReader(new FileReader(lossedRecipePath));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            System.out.print(lossedRecipePath);
            String line;
            textArea.setText("");
            try {
                while ((line = in1.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                in1.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    public void Meat() throws IOException {
        Meat = new JButton("Danie mięsne");
        Meat.setBounds(240, 320, 155, 20);
        Meat.setVisible(true);
        Meat.addActionListener(e -> {
            path = "Mięsne";
            whichRecipe = r.nextInt() % listaMięsna.size();
            lossedRecipePath = path + fs + listaMięsna.get(whichRecipe) + ".txt";
            titleField.setText(listaMięsna.get(whichRecipe));
            BufferedReader in1 = null;
            try {
                in1 = new BufferedReader(new FileReader(lossedRecipePath));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            System.out.print(lossedRecipePath);
            String line;
            textArea.setText("");
            try {
                while ((line = in1.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                in1.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    public void Vege() throws IOException {
        Vege = new JButton("Danie wege");
        Vege.setBounds(444, 320, 155, 20);
        Vege.setVisible(true);
        Vege.addActionListener(e -> {
            path = "Wegetariańskie";
            whichRecipe = r.nextInt() % listaWege.size();
            lossedRecipePath = path + fs + listaWege.get(whichRecipe) + ".txt";
            titleField.setText(listaWege.get(whichRecipe));
            BufferedReader in1 = null;
            try {
                in1 = new BufferedReader(new FileReader(lossedRecipePath));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            System.out.print(lossedRecipePath);
            String line;
            textArea.setText("");
            try {
                while ((line = in1.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                in1.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public void save_to_file() throws IOException, NullPointerException {
        tekstPrzepisu = textArea.getText();
        tytuł = titleField.getText();
        if (!tytuł.isEmpty()) {
            path = String.valueOf(foodTypeList.getSelectedItem());
            absolutePath = path + fs + tytuł + ".txt";
            AddToList(tytuł, index);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(absolutePath, true)));
            out.print(tekstPrzepisu);
            out.close();
        } else {
            System.out.print("error: empty title");
        }
    }

    public void randRecipe() throws IOException {
        Random r1 = new Random();
        int whatType;
        whatType = r1.nextInt() % 5;
        System.out.println(listaRybna.size() + " " + listaMięsna.size() + " " + listaWege.size() + " " + listaDeser.size() + " " + listaPrzystawek.size());
        switch (whatType) {
            case 0:
                path = "Rybne";
                whichRecipe = r.nextInt() % listaRybna.size();
                lossedRecipePath = path + fs + listaRybna.get(whichRecipe) + ".txt";
                titleField.setText(listaRybna.get(whichRecipe));
            case 1:
                path = "Mięsne";
                whichRecipe = r.nextInt() % listaMięsna.size();
                lossedRecipePath = path + fs + listaMięsna.get(whichRecipe) + ".txt";
                titleField.setText(listaMięsna.get(whichRecipe));
            case 2:
                path = "Wegetariańskie";
                whichRecipe = r.nextInt() % listaWege.size();
                lossedRecipePath = path + fs + listaWege.get(whichRecipe) + ".txt";
                titleField.setText(listaWege.get(whichRecipe));
            case 3:
                path = "Deser";
                whichRecipe = r.nextInt() % listaDeser.size();
                lossedRecipePath = path + fs + listaDeser.get(whichRecipe) + ".txt";
                titleField.setText(listaDeser.get(whichRecipe));
            case 4:
                path = "Przystawka";
                whichRecipe = r.nextInt() % listaPrzystawek.size();
                lossedRecipePath = path + fs + listaPrzystawek.get(whichRecipe) + ".txt";
                titleField.setText(listaPrzystawek.get(whichRecipe));
        }
        BufferedReader in1 = null;
        try {
            in1 = new BufferedReader(new FileReader(lossedRecipePath));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        System.out.print(lossedRecipePath);
        String line;
        textArea.setText("");
        try {
            while ((line = in1.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            in1.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void CheckList(String path, String title) {
        if (index == 0) {
            for(int i= 0 ;i<=listaRybna.size();i++){
                if (Objects.equals(listaRybna.get(i), "title")) {
                    listaRybna.remove("title");
                    listaRybna.get(i).re
                }
            }
        } else if (index == 1) {
            if (listaMięsna.contains("title")) {
                listaMięsna.remove("title");
            }
        } else if (index == 2) {
            if (listaWege.contains("title")) {
                listaWege.remove("title");
            }
        } else if (index == 3) {
            if (listaPrzystawek.contains("title")) {
                listaPrzystawek.remove("title");
            }
        }
    }

    public void AddToList(String tytuł, int index) throws IOException {
        String path = null;
        if (index == 0) {
            path = "Rybne/ListaRybnych.txt";
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            CheckList(path, tytuł);
            listaRybna.add(tytuł);

            System.out.println(listaRybna);
            out.println(tytuł);
            out.close();
        }
        if (index == 1) {
            path = "Mięsne/ListaMięsnych.txt";
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            CheckList(path, tytuł);

            listaMięsna.add(tytuł);
            System.out.println(listaMięsna);
            out.println(tytuł);
            out.close();
        }
        if (index == 2) {
            path = "Wegetariańskie/ListaWege.txt";
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            CheckList(path, tytuł);


            listaWege.add(tytuł);
            System.out.println(listaWege);
            out.println(tytuł);
            out.close();
        }
        if (index == 3) {
            path = "Deser/ListaDeserów.txt";
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            CheckList(path, tytuł);

            listaDeser.add(tytuł);
            System.out.println(listaDeser);
            out.println(tytuł);
            out.close();
        }
        if (index == 4) {
            path = "Przystawka/ListaPrzystawek.txt";
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            CheckList(path, tytuł);

            listaPrzystawek.add(tytuł);
            System.out.println(listaPrzystawek);
            out.println(tytuł);
            out.close();
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
}




